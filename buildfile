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
  :javaemul_internal_annotations,
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
  pom.add_github_project('akasha/akasha')
  pom.add_developer('realityforge', 'Peter Donald')

  define 'webtack' do

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
    end

    define 'jsinterop-generator' do
      compile.with project('webidl-model').package(:jar),
                   project('webidl-model').compile.dependencies

      test.using :testng
      test.options[:properties] = {
        'webtack.jsinterop-generator.gwtc' => ENV['GWT'] == 'no' ? 'false' : 'true',
        'webtack.jsinterop-generator.closure_compile' => ENV['CLOSURE'] == 'no' ? 'false' : 'true',
        'webtack.jsinterop-generator.fixture_dir' => _('src/test/fixtures'),
        'webtack.jsinterop-generator.fixture.libs' => "#{JSINTEROP_DEPS.collect { |a| artifact(a).to_s }.join(':')}:#{artifact(:gwt_user)}",
        'webtack.jsinterop-generator.gwt_dev.libs' => "#{Buildr::GWT.dependencies('2.9.0').collect { |d| artifact(d).to_s }.join(':')}",
        'webtack.jsinterop-generator.closure.jar' => artifact(:closure_compiler).to_s
      }
      test.options[:java_args] = %w(-ea)
      test.compile.with :gir,
                        Buildr::Util.tools_jar
      test.compile.enhance do |d|
        artifact(:closure_compiler).invoke
        JSINTEROP_DEPS.collect { |a| artifact(a).invoke }
        Buildr::GWT.dependencies('2.9.0').collect { |a| artifact(a).invoke }
      end

      package(:jar, :classifier => 'all').tap do |jar|
        [:javapoet].collect { |dep| Buildr.artifact(dep) }.each do |d|
          jar.merge(d)
        end
      end
    end

    define 'react4j-generator' do
      compile.with project('webidl-model').package(:jar),
                   project('webidl-model').compile.dependencies

      test.using :testng
      test.options[:properties] = {
        'webtack.react4j-generator.gwtc' => ENV['GWT'] == 'no' ? 'false' : 'true',
        'webtack.react4j-generator.fixture_dir' => _('src/test/fixtures'),
        'webtack.react4j-generator.fixture.libs' => "#{REACT4J_DEPS.collect { |a| artifact(a).to_s }.join(':')}:#{artifact(:gwt_user)}",
        'webtack.react4j-generator.gwt_dev.libs' => "#{Buildr::GWT.dependencies('2.9.0').collect { |d| artifact(d).to_s }.join(':')}"
      }
      test.options[:java_args] = %w(-ea)
      test.compile.with :gir,
                        Buildr::Util.tools_jar
      test.compile.enhance do |d|
        REACT4J_DEPS.collect { |a| artifact(a).invoke }
        Buildr::GWT.dependencies('2.9.0').collect { |a| artifact(a).invoke }
      end

      package(:jar, :classifier => 'all').tap do |jar|
        [:javapoet].collect { |dep| Buildr.artifact(dep) }.each do |d|
          jar.merge(d)
        end
      end
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

      test.using :testng
    end
    project.no_iml
  end

  desc 'Akasha Java Browser API for GWT'
  define 'gwt', :base_dir => "#{WORKSPACE_DIR}/akasha/gwt" do
    java_test_src_dir = "#{WORKSPACE_DIR}/akasha/java/src/test/java"
    src_dir = file("#{project._(:target, :generated)}/webtack/main/java" => ['data:run_gwt_complete_pipeline'])
    test_src_dir = file("#{project._(:target, :generated)}/webtack/test/java" => ['data:run_gwt_complete_pipeline'])

    input_java_dir = "#{WORKSPACE_DIR}/akasha/java/src/main/java"
    output_java_dir = "#{project._(:target, :generated)}/java/main/java"
    java_main_src_dir = file(output_java_dir => [input_java_dir]) do
      Dir["#{input_java_dir}/**/*.java"].each do |f|
        output_filename = "#{output_java_dir}#{f.gsub(input_java_dir,'')}"
        FileUtils.mkdir_p( File.dirname(output_filename))
        IO.write(output_filename, IO.read(f).gsub(/\/\/ GWT_ONLY /, ''))
      end
    end

    input_test_dir = "#{WORKSPACE_DIR}/akasha/java/src/test/java"
    output_test_dir = "#{project._(:target, :generated)}/java/test/java"
    java_test_src_dir = file(output_test_dir => [input_test_dir]) do
      Dir["#{input_java_dir}/**/*.java"].each do |f|
        output_filename = "#{output_test_dir}#{f.gsub(input_test_dir,'')}"
        FileUtils.mkdir_p( File.dirname(output_filename))
        IO.write(output_filename, IO.read(f).gsub(/\/\/ GWT_ONLY /, ''))
      end
    end

    compile.sources << src_dir.to_s << java_main_src_dir.to_s
    test.compile.sources << test_src_dir.to_s << java_test_src_dir.to_s

    project.no_iml

    doc.options.merge!('Xdoclint:all,-reference,-missing' => true)

    compile.using :javac

    deps = artifacts(JSINTEROP_DEPS)
    compile.with deps

    gwt_enhance(project, :extra_deps => [src_dir])

    pom.include_transitive_dependencies << deps
    pom.dependency_filter = Proc.new { |dep| dep[:scope].to_s != 'test' && deps.include?(dep[:artifact]) }

    package(:jar).tap do |j|
      j.enhance([java_main_src_dir]) do |j2|
        j2.include("#{java_main_src_dir}/*")
      end
    end
    package(:sources).tap do |j|
      j.enhance([java_main_src_dir]) do |j2|
        j2.include("#{java_main_src_dir}/*")
      end
    end
    package(:javadoc)
  end

  desc 'Akasha Java Browser API for J2CL'
  define 'j2cl', :base_dir => "#{WORKSPACE_DIR}/akasha/java" do
    src_dir = file("#{project._(:target, :generated)}/webtack/main/java" => ['data:run_j2cl_complete_pipeline'])
    test_src_dir = file("#{project._(:target, :generated)}/webtack/test/java" => ['data:run_j2cl_complete_pipeline'])
    js_src_dir = file("#{project._(:target, :generated)}/webtack/main/js" => ['data:run_j2cl_complete_pipeline'])
    compile.sources << src_dir.to_s
    test.compile.sources << test_src_dir.to_s
    iml.main_generated_source_directories << src_dir.to_s
    iml.test_generated_source_directories << test_src_dir.to_s

    doc.options.merge!('Xdoclint:all,-reference,-missing' => true)

    compile.using :javac

    deps = artifacts(JSINTEROP_DEPS)
    compile.with deps,
                 # gwt_dev required for javaemul.internal.ArrayStamper which is provided by jre dep in j2cl
                 :gwt_user

    pom.include_transitive_dependencies << deps
    pom.dependency_filter = Proc.new { |dep| dep[:scope].to_s != 'test' && deps.include?(dep[:artifact]) }

    package(:jar).tap do |j|
      j.enhance([js_src_dir]) do |j2|
        j2.include("#{js_src_dir}/*")
      end
    end
    package(:sources).tap do |j|
      j.enhance([js_src_dir]) do |j2|
        j2.include("#{js_src_dir}/*")
      end
    end
    package(:javadoc)
  end

  Buildr::BazelJ2cl.define_bazel_j2cl_test(Buildr.project('akasha'),
                                           [Buildr.project('akasha:j2cl')],
                                           'akasha.AkashaCompileTest',
                                           Buildr.project('akasha:j2cl')._(:target, :generated, 'webtack/test/js/akasha/Akasha.CompileTest.js'),
                                           [Buildr.project('akasha:j2cl')._(:target, :generated, 'webtack/test/java'), Buildr.project('akasha:j2cl')._(:source, :test, :java)],
                                           :javax_annotation => true)

  iml.excluded_directories << project._('tmp')

  ipr.add_default_testng_configuration(:jvm_args => '-ea -Dwebtack.output_fixture_data=false -Dwebtack.fixture_dir=webtack/webidl-model/src/test/resources')

  ipr.add_testng_configuration('webidl-parser', :module => 'webidl-parser', :jvm_args => '-ea')

  ipr.add_testng_configuration('webidl-model',
                               :module => 'webidl-model',
                               :jvm_args => '-ea -Dwebtack.output_fixture_data=true -Dwebtack.fixture_dir=src/test/java')

  ipr.add_testng_configuration('jsinterop-generator',
                               :module => 'jsinterop-generator',
                               :jvm_args => "-ea -Dwebtack.output_fixture_data=true -Dwebtack.jsinterop-generator.fixture_dir=src/test/fixtures -Dwebtack.jsinterop-generator.gwtc=false -Dwebtack.jsinterop-generator.closure.jar=#{artifact(:closure_compiler)} -Dwebtack.jsinterop-generator.closure_compile=true -Dwebtack.jsinterop-generator.fixture.libs=#{JSINTEROP_DEPS.collect { |a| artifact(a).to_s }.join(':')}:#{artifact(:gwt_user)} -Dwebtack.jsinterop-generator.gwt_dev.libs=#{Buildr::GWT.dependencies('2.9.0').collect { |d| artifact(d).to_s }.join(':')}")

  ipr.add_testng_configuration('react4j-generator',
                               :module => 'react4j-generator',
                               :jvm_args => "-ea -Dwebtack.output_fixture_data=true -Dwebtack.react4j-generator.fixture_dir=src/test/fixtures -Dwebtack.react4j-generator.gwtc=false -Dwebtack.react4j-generator.fixture.libs=#{REACT4J_DEPS.collect { |a| artifact(a).to_s }.join(':')}:#{artifact(:gwt_user)} -Dwebtack.react4j-generator.gwt_dev.libs=#{Buildr::GWT.dependencies('2.9.0').collect { |d| artifact(d).to_s }.join(':')}")

  ipr.add_java_configuration(project('webtack:cli'), 'org.realityforge.webtack.Main', :name => 'Run - j2cl_complete', :dir => 'file://$PROJECT_DIR$', :args => '-d data run j2cl_complete')

  ipr.add_java_configuration(project('webtack:cli'), 'org.realityforge.webtack.Main', :name => 'Run - react4j', :dir => 'file://$PROJECT_DIR$', :args => '-d data run react4j')

  ipr.add_java_configuration(project('webtack:cli'), 'org.realityforge.webtack.Main', :name => 'Add', :dir => 'file://$PROJECT_DIR$', :args => '-d data add')

  ipr.add_java_configuration(project('webtack:cli'), 'org.realityforge.webtack.Main', :name => 'Fetch', :dir => 'file://$PROJECT_DIR$', :args => '-d data fetch')

  ipr.add_java_configuration(project('webtack:cli'), 'org.realityforge.webtack.Main', :name => 'FetchDocs', :dir => 'file://$PROJECT_DIR$', :args => '-d data fetch-docs')

  ipr.add_component_from_artifact(:idea_codestyle)
  ipr.add_code_insight_settings
  ipr.add_nullable_manager
  ipr.add_javac_settings('-Xlint:all,-serial -Werror -Xmaxerrs 10000 -Xmaxwarns 10000')
end

desc 'Generate source artifacts'
task('generate:all').enhance([file(File.expand_path("#{File.dirname(__FILE__)}/webtack/webidl-parser/generated/antlr/main/java"))])

Buildr.projects.each do |project|
  unless %w(akasha:gwt akasha:j2cl).include?(project.name)
    project.task('install').actions.clear
    project.task('upload').actions.clear
  end
end
