require 'buildr/git_auto_version'
require 'buildr/gpg'
require 'buildr/single_intermediate_layout'
require 'buildr/top_level_generate_dir'
require 'buildr/jacoco'

JSONB_DEPS = [:jsonb_api, :yasson, :javax_json]
PACKAGED_DEPS = [:getopt4j, :jsoup] + JSONB_DEPS + Buildr::Antlr4.runtime_dependencies

desc 'webtack: Generate jsinterop types from WebIDL'
define 'webtack' do
  project.group = 'org.realityforge.webtack'
  compile.options.source = '1.8'
  compile.options.target = '1.8'
  compile.options.lint = 'all'

  project.version = ENV['PRODUCT_VERSION'] if ENV['PRODUCT_VERSION']

  pom.add_apache_v2_license
  pom.add_github_project('realityforge/webtack')
  pom.add_developer('realityforge', 'Peter Donald')

  define 'webidl-parser' do
    compile.with :javax_annotation,
                 Buildr::Antlr4.runtime_dependencies

    antlr_generated_dir =
      compile_antlr(_('src/main/antlr/WebIDL.g4'),
                    :listener => false,
                    :package => 'org.realityforge.webtack.webidl.parser')
    compile.from antlr_generated_dir

    package(:jar)
    package(:sources)
    package(:javadoc)

    test.using :testng

    project.iml.main_generated_source_directories << antlr_generated_dir
  end

  define 'webidl-model' do
    compile.with project('webidl-parser').package(:jar),
                 project('webidl-parser').compile.dependencies,
                 JSONB_DEPS

    test.using :testng
    test.options[:properties] = { 'webtack.fixture_dir' => _('src/test/fixtures') }
    test.compile.with :gir

    package(:jar)
    package(:sources)
    package(:javadoc)
  end

  define 'cli' do
    generate_config_resource(project)

    compile.with :javax_annotation,
                 project('webidl-model').package(:jar),
                 project('webidl-model').compile.dependencies,
                 PACKAGED_DEPS

    package(:jar)
    package(:jar, :classifier => 'all').tap do |jar|
      jar.with :manifest => { 'Main-Class' => 'org.realityforge.webtack.Main' }
      PACKAGED_DEPS.collect { |dep| Buildr.artifact(dep) }.each do |d|
        jar.merge(d)
      end
      jar.merge(project('webidl-parser').package(:jar))
      jar.merge(project('webidl-model').package(:jar))
    end
    package(:sources)
    package(:javadoc)

    test.using :testng
  end

  iml.excluded_directories << project._('tmp')

  ipr.add_default_testng_configuration(:jvm_args => '-ea -Dwebtack.output_fixture_data=false -Dwebtack.fixture_dir=webidl-model/src/test/resources')

  ipr.add_testng_configuration('webidl-model',
                               :module => 'webidl-model',
                               :jvm_args => '-ea -Dwebtack.output_fixture_data=true -Dwebtack.fixture_dir=src/test/fixtures')

  ipr.add_component_from_artifact(:idea_codestyle)
end

desc 'Generate source artifacts'
task('generate:all').enhance([file(File.expand_path("#{File.dirname(__FILE__)}/webidl-parser/generated/antlr/main/java"))])
