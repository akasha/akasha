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
               :getopt4j

  package(:jar)
  package(:sources)
  package(:javadoc)

  test.using :testng

  iml.excluded_directories << project._('tmp')

  ipr.add_component_from_artifact(:idea_codestyle)
end
