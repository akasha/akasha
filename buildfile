require 'buildr/git_auto_version'
require 'buildr/gpg'
require 'buildr/top_level_generate_dir'

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

  generate_config_resource(project)

  compile.with :javax_annotation,
               :getopt4j,
               :jsoup,
               :jsonb_api,
               :yasson,
               :javax_json,
               Buildr::Antlr4.runtime_dependencies

  antlr_generated_dir = compile_antlr(_('src/main/antlr/WebIDL.g4'), :package => 'org.realityforge.webtack.webidl.parser')
  compile.from antlr_generated_dir

  package(:jar)
  package(:sources)
  package(:javadoc)

  test.using :testng

  project.iml.main_generated_source_directories << antlr_generated_dir
  iml.excluded_directories << project._('tmp')

  ipr.add_component_from_artifact(:idea_codestyle)
end

desc 'Generate source artifacts'
task('generate:all').enhance([file(File.expand_path("#{File.dirname(__FILE__)}/generated/antlr/main/java"))])
