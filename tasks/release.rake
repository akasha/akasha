require 'buildr/release_tool'

module Buildr
  class ReleaseTool
    def generate_announce_email(email_template)
      stage('GenerateAnnounceEmail', 'Generate an email that can be used to announce the project') do

        changelog = IO.read('CHANGELOG.md')
        start = changelog.index("### [v#{ENV['PRODUCT_VERSION']}]")
        raise "Unable to locate version #{ENV['PRODUCT_VERSION']} in change log" if -1 == start
        start = changelog.index("\n", start)
        start = changelog.index("\n", start + 1)

        end_index = changelog.index('### [v', start)
        end_index = changelog.length if end_index.nil?

        changes = changelog[start, end_index - start].strip

        email =
          IO.
            read(email_template).
            gsub(/__VERSION__/, "#{ENV['PRODUCT_VERSION']}").
            gsub(/__CHANGES__/, changes)

        IO.write('target/announce.txt', email)
        puts 'Email to announce release generated to target/announce.txt'
      end
    end
  end
end

Buildr::ReleaseTool.define_release_task do |t|
  t.extract_version_from_changelog
  t.zapwhite
  t.ensure_git_clean
  t.verify_no_todo
  t.cleanup_staging
  t.build(:additional_tasks => "do_test_api_diff akasha:j2cl:bazel_j2cl_test akasha:webgpu-j2cl:bazel_j2cl_test J2CL=#{ENV['J2CL']}")
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
  t.generate_announce_email('docs/announce.txt')
end
