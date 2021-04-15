require 'buildr/release_tool.rb'

Buildr::ReleaseTool.define_release_task do |t|
  t.extract_version_from_changelog
  t.zapwhite
  t.ensure_git_clean
  t.verify_no_todo
  t.cleanup_staging
  t.build(:additional_tasks => 'do_test_api_diff')
  t.patch_changelog('akasha/akasha',
                    :header_suffix => " · [Source Diff](https://github.com/akasha/akasha-java/compare/v#{ENV['PREVIOUS_PRODUCT_VERSION']}...v#{ENV['PRODUCT_VERSION']})",
                    :api_diff_directory => "#{WORKSPACE_DIR}/api-test",
                    :api_diff_website => 'https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&')
  t.patch_maven_version_in_readme
  t.tag_project
  t.stage_release(:release_to => { :url => 'https://stocksoftware.jfrog.io/stocksoftware/staging', :username => ENV['STAGING_USERNAME'], :password => ENV['STAGING_PASSWORD'] })
  t.maven_central_publish(:additional_tasks => 'source:publish_and_tag api_diff:publish')
  t.patch_changelog_post_release
  t.push_changes
  t.github_release('akasha/akasha')
end
