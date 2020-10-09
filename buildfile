require 'buildr/git_auto_version'
require 'buildr/gpg'
require 'buildr/gwt'
require 'buildr/single_intermediate_layout'
require 'buildr/top_level_generate_dir'
require 'buildr/jacoco'

JSONB_DEPS = [:jsonb_api, :yasson, :javax_json]
PACKAGED_DEPS = [:getopt4j, :jsoup] + JSONB_DEPS + Buildr::Antlr4.runtime_dependencies
# GWT dependencies required for compiling generated code
GWT_DEPS = [
  :javax_annotation,
  :jetbrains_annotations,
  :jsinterop_annotations,
  :jsinterop_base,
  :elemental2_core,
  :elemental2_promise,
  :gwt_user
]

REACT4J_DEPS = [
  :react4j_core,
  :react4j_dom
] + GWT_DEPS

desc 'WebTack: Fetch and process WebIDL to generate Source Code'
define 'webtack' do
  project.group = 'org.realityforge.webtack'
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
      'webtack.jsinterop-generator.gwtc' => 'true',
      'webtack.jsinterop-generator.fixture_dir' => _('src/test/fixtures'),
      'webtack.jsinterop-generator.fixture.libs' => "#{GWT_DEPS.collect{|a| artifact(a).to_s}.join(':')}",
      'webtack.jsinterop-generator.gwt_dev.libs' => "#{GWT_DEPS.collect{|a| artifact(a).to_s}.join(':')}:#{Buildr::GWT.dependencies('2.9.0').collect {|d| artifact(d).to_s }.join(':')}"
    }
    test.options[:java_args] = %w(-ea)
    test.compile.with :gir, Java.tools_jar
    test.compile.enhance do |d|
      GWT_DEPS.collect {|a| artifact(a).invoke }
      Buildr::GWT.dependencies('2.9.0').collect {|a| artifact(a).invoke }
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
      'webtack.react4j-generator.gwtc' => 'true',
      'webtack.react4j-generator.fixture_dir' => _('src/test/fixtures'),
      'webtack.react4j-generator.fixture.libs' => "#{REACT4J_DEPS.collect{|a| artifact(a).to_s}.join(':')}",
      'webtack.react4j-generator.gwt_dev.libs' => "#{REACT4J_DEPS.collect{|a| artifact(a).to_s}.join(':')}:#{Buildr::GWT.dependencies('2.9.0').collect {|d| artifact(d).to_s }.join(':')}"
    }
    test.options[:java_args] = %w(-ea)
    test.compile.with :gir, Java.tools_jar
    test.compile.enhance do |d|
      REACT4J_DEPS.collect {|a| artifact(a).invoke }
      Buildr::GWT.dependencies('2.9.0').collect {|a| artifact(a).invoke }
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

  define 'elemental3' do
    %w(speech bluetooth main react4j).each do |pipeline|

      name = 'main' == pipeline ? 'complete' : pipeline

      # react4j is not yet ready for testing
      next if 'react4j' == pipeline

      desc "Elemental3 #{name}"
      define name do
        project.layout[:target, :generated] = "#{WORKSPACE_DIR}/generated/elemental3/#{name}"

        src_dir = file("#{WORKSPACE_DIR}/data/output/#{pipeline}/main/java" => ["data:run_#{pipeline}_pipeline"])

        project.doc.options.merge!('Xdoclint:all,-missing' => true)

        compile.using :javac
        project.compile.sources << src_dir

        deps = artifacts('react4j' == pipeline ? REACT4J_DEPS : GWT_DEPS)
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
    project.no_iml
  end

  iml.excluded_directories << project._('tmp')

  ipr.add_default_testng_configuration(:jvm_args => '-ea -Dwebtack.output_fixture_data=false -Dwebtack.fixture_dir=webidl-model/src/test/resources')

  ipr.add_testng_configuration('webidl-parser', :module => 'webidl-parser', :jvm_args => '-ea')

  ipr.add_testng_configuration('webidl-model',
                               :module => 'webidl-model',
                               :jvm_args => '-ea -Dwebtack.output_fixture_data=true -Dwebtack.fixture_dir=src/test/java')

  ipr.add_testng_configuration('jsinterop-generator',
                               :module => 'jsinterop-generator',
                               :jvm_args => "-ea -Dwebtack.output_fixture_data=true -Dwebtack.jsinterop-generator.fixture_dir=src/test/fixtures -Dwebtack.jsinterop-generator.gwtc=true -Dwebtack.jsinterop-generator.fixture.libs=#{GWT_DEPS.collect{|a| artifact(a).to_s}.join(':')} -Dwebtack.jsinterop-generator.gwt_dev.libs=#{Buildr::GWT.dependencies('2.9.0').collect {|d| artifact(d).to_s }.join(':')}")

  ipr.add_testng_configuration('react4j-generator',
                               :module => 'react4j-generator',
                               :jvm_args => "-ea -Dwebtack.output_fixture_data=true -Dwebtack.react4j-generator.fixture_dir=src/test/fixtures -Dwebtack.react4j-generator.gwtc=true -Dwebtack.react4j-generator.fixture.libs=#{REACT4J_DEPS.collect{|a| artifact(a).to_s}.join(':')} -Dwebtack.react4j-generator.gwt_dev.libs=#{Buildr::GWT.dependencies('2.9.0').collect {|d| artifact(d).to_s }.join(':')}")

  ipr.add_java_configuration(project('cli'), 'org.realityforge.webtack.Main', :name => 'Run - bluetooth', :dir => 'file://$PROJECT_DIR$', :args => '-d data run bluetooth')

  ipr.add_java_configuration(project('cli'), 'org.realityforge.webtack.Main', :name => 'Run - main', :dir => 'file://$PROJECT_DIR$', :args => '-d data run main')

  ipr.add_java_configuration(project('cli'), 'org.realityforge.webtack.Main', :name => 'Run - react4j', :dir => 'file://$PROJECT_DIR$', :args => '-d data run react4j')

  ipr.add_java_configuration(project('cli'), 'org.realityforge.webtack.Main', :name => 'Run - speech', :dir => 'file://$PROJECT_DIR$', :args => '-d data run speech')

  ipr.add_component_from_artifact(:idea_codestyle)
end

desc 'Generate source artifacts'
task('generate:all').enhance([file(File.expand_path("#{File.dirname(__FILE__)}/webidl-parser/generated/antlr/main/java"))])
