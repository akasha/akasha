require File.expand_path(File.dirname(__FILE__) + '/api_diff_tool')

desc 'Update the api_differences for the next version'
task 'update_api_diff' do
  Buildr::ReleaseTool.derive_versions_from_changelog
  sh "buildr clean do_update_api_diff TEST=no GWT=no PRODUCT_VERSION=#{ENV['PRODUCT_VERSION']}"
end

task 'do_update_api_diff' do
  a = Buildr.project('akasha:java').package(:jar)
  a.invoke
  Buildr::ApiDiffTool.update_differences_report("org.realityforge.akasha:akasha-java:jar", ENV['PREVIOUS_PRODUCT_VERSION'], ENV['PRODUCT_VERSION'], a.to_s, "#{WORKSPACE_DIR}/api-test")
end

desc 'Test the api differences for the next version'
task 'test_api_diff' do
  Buildr::ReleaseTool.derive_versions_from_changelog
  sh "buildr clean do_test_api_diff TEST=no GWT=no PRODUCT_VERSION=#{ENV['PRODUCT_VERSION']}"
end

task 'do_test_api_diff' do
  a = Buildr.project('akasha:java').package(:jar)
  a.invoke
  Buildr::ApiDiffTool.test_differences_report("org.realityforge.akasha:akasha-java:jar", ENV['PREVIOUS_PRODUCT_VERSION'], ENV['PRODUCT_VERSION'], a.to_s, "#{WORKSPACE_DIR}/api-test")
end
