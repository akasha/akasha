require 'buildr/git_auto_version'
require 'buildr/gpg'
require 'buildr/gwt'
require 'buildr/single_intermediate_layout'
require 'buildr/top_level_generate_dir'
require 'buildr/jacoco'

Buildr::MavenCentral.define_publish_tasks(:profile_name => 'org.realityforge', :username => 'realityforge')

JSONB_DEPS = [:jsonb_api, :yasson, :javax_json]
PACKAGED_DEPS = [:getopt4j, :jsoup] + JSONB_DEPS + Buildr::Antlr4.runtime_dependencies
# GWT dependencies required for compiling generated code
JSINTEROP_DEPS = [
  :javax_annotation,
  :jetbrains_annotations,
  :jsinterop_annotations,
  :jsinterop_base
]

REACT4J_DEPS = [
  :react4j_core,
  :react4j_dom
] + JSINTEROP_DEPS

desc 'Akasha: Fetch and process WebIDL to generate Source Code'
define 'akasha' do
  project.group = 'org.realityforge.akasha'
  compile.options.source = '1.8'
  compile.options.target = '1.8'
  compile.options.lint = 'all,-serial'
  project.compile.options.warnings = true
  project.compile.options.other = %w(-Werror -Xmaxerrs 10000 -Xmaxwarns 10000)

  project.version = ENV['PRODUCT_VERSION'] if ENV['PRODUCT_VERSION']

  pom.add_apache_v2_license
  pom.add_github_project('realityforge/webtack')
  pom.add_developer('realityforge', 'Peter Donald')

  define 'webidl-parser' do
    compile.with :javax_annotation,
                 Buildr::Antlr4.runtime_dependencies

    antlr_lexer_generated_dir =
      compile_antlr(_('src/main/antlr/WebIDLLexer.g4'),
                    :listener => false,
                    :package => 'org.realityforge.webtack.webidl.parser')
    compile.from antlr_lexer_generated_dir

    antlr_generated_dir =
      compile_antlr(_('src/main/antlr/WebIDLParser.g4'),
                    :listener => false,
                    :package => 'org.realityforge.webtack.webidl.parser')
    compile.from antlr_generated_dir

    package(:jar)
    package(:sources)
    package(:javadoc)

    test.using :testng

    project.iml.main_generated_source_directories << antlr_lexer_generated_dir
    project.iml.main_generated_source_directories << antlr_generated_dir
  end

  define 'webidl-model' do
    compile.with project('webidl-parser').package(:jar),
                 project('webidl-parser').compile.dependencies,
                 JSONB_DEPS,
                 :jsoup,
                 :javapoet

    test.using :testng
    test.options[:properties] = { 'webtack.fixture_dir' => _('src/test/java') }
    test.options[:java_args] = %w(-ea)
    test.compile.with :gir

    package(:jar)
    package(:sources)
    package(:javadoc)
  end

  define 'jsinterop-generator' do
    compile.with project('webidl-model').package(:jar),
                 project('webidl-model').compile.dependencies

    test.using :testng
    test.options[:properties] = {
      'webtack.jsinterop-generator.gwtc' => ENV['GWT'] == 'no' ? 'false' : 'true',
      'webtack.jsinterop-generator.fixture_dir' => _('src/test/fixtures'),
      'webtack.jsinterop-generator.fixture.libs' => "#{JSINTEROP_DEPS.collect { |a| artifact(a).to_s }.join(':')}:#{artifact(:gwt_user)}:#{project('akasha:core').package(:jar)}",
      'webtack.jsinterop-generator.gwt_dev.libs' => "#{Buildr::GWT.dependencies('2.9.0').collect { |d| artifact(d).to_s }.join(':')}"
    }
    test.options[:java_args] = %w(-ea)
    test.compile.with :gir,
                      Buildr::Util.tools_jar,
                      # Next dependency ensures the jar is built so can be used in tests but is not directly referenced
                      project('akasha:core').package(:jar)
    test.compile.enhance do |d|
      JSINTEROP_DEPS.collect { |a| artifact(a).invoke }
      Buildr::GWT.dependencies('2.9.0').collect { |a| artifact(a).invoke }
    end

    package(:jar, :classifier => 'all').tap do |jar|
      [:javapoet].collect { |dep| Buildr.artifact(dep) }.each do |d|
        jar.merge(d)
      end
    end
    package(:sources)
    package(:javadoc)
  end

  define 'react4j-generator' do
    compile.with project('webidl-model').package(:jar),
                 project('webidl-model').compile.dependencies

    test.using :testng
    test.options[:properties] = {
      'webtack.react4j-generator.gwtc' => ENV['GWT'] == 'no' ? 'false' : 'true',
      'webtack.react4j-generator.fixture_dir' => _('src/test/fixtures'),
      'webtack.react4j-generator.fixture.libs' => "#{REACT4J_DEPS.collect { |a| artifact(a).to_s }.join(':')}:#{artifact(:gwt_user)}:#{project('akasha:core').package(:jar)}",
      'webtack.react4j-generator.gwt_dev.libs' => "#{Buildr::GWT.dependencies('2.9.0').collect { |d| artifact(d).to_s }.join(':')}"
    }
    test.options[:java_args] = %w(-ea)
    test.compile.with :gir,
                      Buildr::Util.tools_jar,
                      # Next dependency ensures the jar is built so can be used in tests but is not directly referenced
                      project('akasha:core').package(:jar)
    test.compile.enhance do |d|
      REACT4J_DEPS.collect { |a| artifact(a).invoke }
      Buildr::GWT.dependencies('2.9.0').collect { |a| artifact(a).invoke }
    end

    package(:jar, :classifier => 'all').tap do |jar|
      [:javapoet].collect { |dep| Buildr.artifact(dep) }.each do |d|
        jar.merge(d)
      end
    end
    package(:sources)
    package(:javadoc)
  end

  define 'cli' do
    generate_config_resource(project)

    compile.with :javax_annotation,
                 project('webidl-model').package(:jar),
                 project('webidl-model').compile.dependencies,
                 project('jsinterop-generator').package(:jar),
                 project('jsinterop-generator').compile.dependencies,
                 project('react4j-generator').package(:jar),
                 project('react4j-generator').compile.dependencies,
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

  desc "Akasha Core"
  define 'core', :base_dir => "#{WORKSPACE_DIR}/akasha/core" do
    doc.options.merge!('Xdoclint:all,-reference,-missing' => true)

    compile.using :javac

    deps = JSINTEROP_DEPS
    compile.with deps

    gwt_enhance(project)

    pom.include_transitive_dependencies << deps
    pom.dependency_filter = Proc.new { |dep| dep[:scope].to_s != 'test' && deps.include?(dep[:artifact]) }

    package(:jar)
    package(:sources)
    package(:javadoc)
  end

  desc "Akasha complete"
  define 'complete', :base_dir => "#{WORKSPACE_DIR}/akasha/complete" do
    src_dir = file("#{project._(:target, :generated)}/webtack/main/java" => ["data:run_complete_pipeline"])
    compile.sources << src_dir
    iml.main_generated_source_directories << src_dir

    core_src_path = "#{project._(:target, :generated)}/core/main/java"
    core_src_dir = file(core_src_path) do
      mkdir_p core_src_path
      FileUtils.cp_r "#{WORKSPACE_DIR}/akasha/core/src/main/java", File.dirname(core_src_path)
      FileUtils.rm "#{core_src_path}/akasha/lang/JsIterable.java"
      FileUtils.rm "#{core_src_path}/akasha/lang/Lang.gwt.xml"
      FileUtils.rm "#{core_src_path}/akasha/promise/Promise.gwt.xml"
    end
    compile.sources << core_src_dir
    iml.main_generated_source_directories << core_src_dir

    doc.options.merge!('Xdoclint:all,-reference,-missing' => true)

    compile.using :javac

    deps = artifacts(JSINTEROP_DEPS)
    compile.with deps

    gwt_enhance(project, :extra_deps => [src_dir, core_src_dir])

    pom.include_transitive_dependencies << deps
    pom.dependency_filter = Proc.new { |dep| dep[:scope].to_s != 'test' && deps.include?(dep[:artifact]) }

    package(:jar)
    package(:sources)
    package(:javadoc)
  end

  %w(speech bluetooth).each do |name|
    desc "Akasha #{name}"
    define name, :base_dir => "#{WORKSPACE_DIR}/akasha/#{name}" do
      src_dir = file("#{WORKSPACE_DIR}/data/output/#{name}/main/java" => ["data:run_#{name}_pipeline"])
      compile.sources << src_dir
      project.layout[:target, :generated] = "#{WORKSPACE_DIR}/target/akasha-#{name}/generated"

      doc.options.merge!('Xdoclint:all,-reference,-missing' => true)

      compile.using :javac

      deps = artifacts(JSINTEROP_DEPS)
      deps << [project('akasha:core')]
      compile.with deps

      gwt_enhance(project, :extra_deps => [src_dir])

      pom.include_transitive_dependencies << deps
      pom.dependency_filter = Proc.new { |dep| dep[:scope].to_s != 'test' && deps.include?(dep[:artifact]) }

      package(:jar)
      package(:sources)
      package(:javadoc)

      project.no_iml
    end
  end

  iml.excluded_directories << project._('tmp')

  ipr.add_default_testng_configuration(:jvm_args => '-ea -Dwebtack.output_fixture_data=false -Dwebtack.fixture_dir=webidl-model/src/test/resources')

  ipr.add_testng_configuration('webidl-parser', :module => 'webidl-parser', :jvm_args => '-ea')

  ipr.add_testng_configuration('webidl-model',
                               :module => 'webidl-model',
                               :jvm_args => '-ea -Dwebtack.output_fixture_data=true -Dwebtack.fixture_dir=src/test/java')

  ipr.add_testng_configuration('jsinterop-generator',
                               :module => 'jsinterop-generator',
                               :jvm_args => "-ea -Dwebtack.output_fixture_data=true -Dwebtack.jsinterop-generator.fixture_dir=src/test/fixtures -Dwebtack.jsinterop-generator.gwtc=false -Dwebtack.jsinterop-generator.fixture.libs=#{JSINTEROP_DEPS.collect { |a| artifact(a).to_s }.join(':')}:#{artifact(:gwt_user)}:#{project('akasha:core').package(:jar)} -Dwebtack.jsinterop-generator.gwt_dev.libs=#{Buildr::GWT.dependencies('2.9.0').collect { |d| artifact(d).to_s }.join(':')}")

  ipr.add_testng_configuration('react4j-generator',
                               :module => 'react4j-generator',
                               :jvm_args => "-ea -Dwebtack.output_fixture_data=true -Dwebtack.react4j-generator.fixture_dir=src/test/fixtures -Dwebtack.react4j-generator.gwtc=false -Dwebtack.react4j-generator.fixture.libs=#{REACT4J_DEPS.collect { |a| artifact(a).to_s }.join(':')}:#{artifact(:gwt_user)}:#{project('akasha:core').package(:jar)} -Dwebtack.react4j-generator.gwt_dev.libs=#{Buildr::GWT.dependencies('2.9.0').collect { |d| artifact(d).to_s }.join(':')}")

  ipr.add_java_configuration(project('cli'), 'org.realityforge.webtack.Main', :name => 'Run - bluetooth', :dir => 'file://$PROJECT_DIR$', :args => '-d data run bluetooth')

  ipr.add_java_configuration(project('cli'), 'org.realityforge.webtack.Main', :name => 'Run - main', :dir => 'file://$PROJECT_DIR$', :args => '-d data run main')

  ipr.add_java_configuration(project('cli'), 'org.realityforge.webtack.Main', :name => 'Run - react4j', :dir => 'file://$PROJECT_DIR$', :args => '-d data run react4j')

  ipr.add_java_configuration(project('cli'), 'org.realityforge.webtack.Main', :name => 'Run - speech', :dir => 'file://$PROJECT_DIR$', :args => '-d data run speech')

  ipr.add_component_from_artifact(:idea_codestyle)
  ipr.add_code_insight_settings
  ipr.add_nullable_manager
  ipr.add_javac_settings('-Xlint:all,-serial -Werror -Xmaxerrs 10000 -Xmaxwarns 10000')
end

desc 'Generate source artifacts'
task('generate:all').enhance([file(File.expand_path("#{File.dirname(__FILE__)}/webidl-parser/generated/antlr/main/java"))])

Buildr.projects.each do |project|
  unless %w(akasha:complete).include?(project.name)
    project.task('upload').actions.clear
  end
end
