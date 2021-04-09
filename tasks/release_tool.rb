#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

module Buildr
  class ReleaseTool
    class << self
      def define_release_task(options = {}, &block)
        task_name = options[:task_name] || 'perform_release'
        description = options[:description] || 'Perform a release'
        workspace_dir = options[:workspace_dir] || File.dirname(Buildr.application.buildfile.to_s)

        ENV['PREVIOUS_PRODUCT_VERSION'] = nil if ENV['PREVIOUS_PRODUCT_VERSION'].to_s == ''
        ENV['PRODUCT_VERSION'] = nil if ENV['PRODUCT_VERSION'].to_s == ''

        desc description
        task task_name do
          in_dir(workspace_dir) do
            yield ReleaseTool.new
          end
          if ENV['STAGE']
            if ENV['LAST_STAGE'] == ENV['STAGE']
              puts "LAST_STAGE specified '#{ENV['LAST_STAGE']}', later stages were skipped"
            else
              raise "Invalid STAGE specified '#{ENV['STAGE']}' that did not match any stage"
            end
          end
        end
      end

      def derive_versions_from_changelog(options = {})
        ENV['PREVIOUS_PRODUCT_VERSION'] ||= IO.read('CHANGELOG.md')[/^### \[v(\d+\.\d+(\.\d+)?)\]/, 1] || '0.00'
        ENV['PRODUCT_VERSION'] ||= derive_next_version(ENV['PREVIOUS_PRODUCT_VERSION'], options)
      end

      def derive_next_version(current_version, options = {})
        return options[:next_version_action].call(current_version) if options[:next_version_action]
        version_parts = current_version.split('.')
        next_version = "#{version_parts[0]}.#{sprintf('%02d', version_parts[1].to_i + 1)}#{version_parts.length > 2 ? ".#{version_parts[2]}" : ''}"
      end

      private

      def in_dir(dir)
        current = Dir.pwd
        begin
          Dir.chdir(dir)
          yield
        ensure
          Dir.chdir(current)
        end
      end
    end

    def extract_version_from_changelog(options = {})
      stage('ExtractVersion', 'Extract the last version from CHANGELOG.md and derive next version unless specified', :always_run => true) do
        Buildr::ReleaseTool.derive_versions_from_changelog(options)
        # Also initialize release date if required
        ENV['RELEASE_DATE'] ||= Time.now.strftime('%Y-%m-%d')
      end
    end

    def zapwhite
      stage('ZapWhite', 'Ensure that zapwhite produces no changes') do
        sh 'bundle exec zapwhite'
      end
    end

    def ensure_git_clean
      stage('GitClean', 'Ensure there is nothing to commit and the working tree is clean') do
        status_output = `git status -s 2>&1`.strip
        raise 'Uncommitted changes in git repository. Please commit them prior to release.' if 0 != status_output.size
      end
    end

    def verify_no_todo
      stage('TodoScan', 'Verify that there are no TODO notes in codebase') do
        task('todos:scan').invoke
      end
    end

    def cleanup_staging
      stage('StagingCleanup', 'Remove artifacts from staging repository') do
        task('staging:cleanup').invoke
      end
    end

    def build(options = {})
      additional_tasks = options[:additional_tasks] || ''
      stage('Build', 'Build the project to ensure that the tests pass') do
        sh "bundle exec buildr clean package #{additional_tasks} install PRODUCT_VERSION=#{ENV['PRODUCT_VERSION']}#{ENV['TEST'].nil? ? '' : " TEST=#{ENV['TEST']}"}#{Buildr.application.options.trace ? ' --trace' : ''}"
      end
    end

    def patch_changelog(repository_name, options = {})
      stage('PatchChangelog', 'Patch the changelog to update from previous release') do
        changelog = IO.read('CHANGELOG.md')
        from = '0.00' == ENV['PREVIOUS_PRODUCT_VERSION'] ? `git rev-list --max-parents=0 HEAD`.strip : "v#{ENV['PREVIOUS_PRODUCT_VERSION']}"

        header = "### [v#{ENV['PRODUCT_VERSION']}](https://github.com/#{repository_name}/tree/v#{ENV['PRODUCT_VERSION']}) (#{ENV['RELEASE_DATE']}) · [Full Changelog](https://github.com/spritz/spritz/compare/#{from}...v#{ENV['PRODUCT_VERSION']})"

        sub_header_text = ''

        api_diff_directory = options[:api_diff_directory]
        api_diff_filename = api_diff_directory ? "#{api_diff_directory}/#{ENV['PREVIOUS_PRODUCT_VERSION']}-#{ENV['PRODUCT_VERSION']}.json" : nil
        if api_diff_filename && File.exist?(api_diff_filename)

          api_diff_site = options[:api_diff_website]
          if api_diff_site
            header += " · [API Differences](#{api_diff_site}old=#{ENV['PREVIOUS_PRODUCT_VERSION']}&new=#{ENV['PRODUCT_VERSION']})"
          end

          changes = JSON.parse(IO.read(api_diff_filename))
          non_breaking_changes = changes.select { |j| j['classification']['SOURCE'] == 'NON_BREAKING' }.size
          potentially_breaking_changes = changes.select { |j| j['classification']['SOURCE'] == 'POTENTIALLY_BREAKING' }.size
          breaking_changes = changes.select { |j| j['classification']['SOURCE'] == 'BREAKING' }.size
          change_descriptions = []
          change_descriptions << "#{non_breaking_changes} non breaking API change#{1 == non_breaking_changes ? '' : 's'}" unless 0 == non_breaking_changes
          change_descriptions << "#{potentially_breaking_changes} potentially breaking API change#{1 == potentially_breaking_changes ? '' : 's'}" unless 0 == potentially_breaking_changes
          change_descriptions << "#{breaking_changes} breaking API change#{1 == breaking_changes ? '' : 's'}" unless 0 == breaking_changes

          if change_descriptions.size > 0
            description = "The release includes "
            if 1 == change_descriptions.size
              description += "#{change_descriptions[0]}"
            elsif 2 == change_descriptions.size
              description += "#{change_descriptions[0]} and #{change_descriptions[1]}"
            else
              description += "#{change_descriptions[0]}, #{change_descriptions[1]} and #{change_descriptions[2]}"
            end

            sub_header_text = description
          end
        end

        header_suffix = options[:header_suffix]
        header += header_suffix if header_suffix
        header += "\n\n#{sub_header_text}" unless sub_header_text.empty?
        header += "\n"

        header += <<CONTENT

Changes in this release:
CONTENT

        IO.write('CHANGELOG.md', changelog.gsub("### Unreleased\n", header))

        sh 'git reset 2>&1 1> /dev/null'
        sh 'git add CHANGELOG.md'
        sh 'git commit -m "Update CHANGELOG.md in preparation for release"'
      end
    end

    def patch_maven_version_in_readme
      stage('PatchReadme', 'Patch the README to update from previous release') do
        contents = IO.read('README.md')
        contents = contents.
          gsub("<version>#{ENV['PREVIOUS_PRODUCT_VERSION']}</version>", "<version>#{ENV['PRODUCT_VERSION']}</version>").
          gsub("/#{ENV['PREVIOUS_PRODUCT_VERSION']}/", "/#{ENV['PRODUCT_VERSION']}/").
          gsub("-#{ENV['PREVIOUS_PRODUCT_VERSION']}-", "-#{ENV['PRODUCT_VERSION']}-")
        IO.write('README.md', contents)

        sh 'git reset 2>&1 1> /dev/null'
        sh 'git add README.md'
        sh 'git commit -m "Update README.md in preparation for release"'
      end
    end

    def tag_project
      stage('TagProject', 'Tag the project') do
        sh "git tag v#{ENV['PRODUCT_VERSION']}"
      end
    end

    def stage_release(options = {})
      release_to = options[:release_to] || (raise "StageRelease stage must specify :release_to configuration")
      stage('StageRelease', 'Stage the release') do
        IO.write('_buildr.rb', "repositories.release_to = #{release_to.inspect}")
        sh 'bundle exec buildr clean upload TEST=no GWT=no'
        sh 'rm -f _buildr.rb'
      end
    end

    def maven_central_publish(options = {})
      additional_tasks = options[:additional_tasks] || ''
      stage('MavenCentralPublish', 'Publish artifacts to Maven Central') do
        sh "bundle exec buildr clean mcrt:publish_if_tagged #{additional_tasks} TEST=no GWT=no"
      end
    end

    def patch_changelog_post_release
      stage('PatchChangelogPostRelease', 'Patch the changelog post release to prepare for next development iteration') do
        changelog = IO.read('CHANGELOG.md')
        changelog = changelog.gsub("# Change Log\n", <<HEADER)
# Change Log

### Unreleased
HEADER
        IO.write('CHANGELOG.md', changelog)

        `bundle exec zapwhite`
        sh 'git add CHANGELOG.md'
        sh 'git commit -m "Update CHANGELOG.md in preparation for next development iteration"'
      end
    end

    def push_changes
      stage('PushChanges', 'Push changes to git repository') do
        sh 'git push'
        sh 'git push --tags'
      end
    end

    def github_release(repository_name)
      stage('GithubRelease', 'Create a Release on GitHub') do
        changelog = IO.read('CHANGELOG.md')
        start = changelog.index("### [v#{ENV['PRODUCT_VERSION']}]")
        raise "Unable to locate version #{ENV['PRODUCT_VERSION']} in change log" if -1 == start
        start = changelog.index("\n", start)
        start = changelog.index("\n", start + 1)

        end_index = changelog.index('### [v', start)
        end_index = changelog.length if end_index.nil?

        changes = changelog[start, end_index - start]

        changes = changes.strip

        tag = "v#{ENV['PRODUCT_VERSION']}"

        version_parts = ENV['PRODUCT_VERSION'].split('.')
        prerelease = '0' == version_parts[0]

        require 'octokit'

        client = Octokit::Client.new(:netrc => true, :auto_paginate => true)
        client.login
        client.create_release(repository_name, tag, :name => tag, :body => changes, :draft => false, :prerelease => prerelease)

        candidates = client.list_milestones(repository_name).select { |m| m[:title].to_s == tag }
        unless candidates.empty?
          milestone = candidates[0]
          unless milestone[:state] == 'closed'
            client.update_milestone(repository_name, milestone[:number], :state => 'closed')
          end
        end
      end
    end

    def stage(stage_name, description, options = {})
      if ENV['STAGE'].nil? || ENV['STAGE'] == stage_name || options[:always_run]
        puts "🚀 Release Stage: #{stage_name} - #{description}"
        begin
          yield
        rescue Exception => e
          puts '💣 Error completing stage.'
          puts "Fix the error and re-run release process passing: STAGE=#{stage_name}#{ ENV['PREVIOUS_PRODUCT_VERSION'] ? " PREVIOUS_PRODUCT_VERSION=#{ENV['PREVIOUS_PRODUCT_VERSION']}" : ''}#{ ENV['PREVIOUS_PRODUCT_VERSION'] ? " PRODUCT_VERSION=#{ENV['PRODUCT_VERSION']}" : ''}"
          raise e
        end
        ENV['STAGE'] = nil unless options[:always_run]
      elsif !ENV['STAGE'].nil?
        puts "Skipping Stage: #{stage_name} - #{description}"
      end
      if ENV['LAST_STAGE'] == stage_name
        ENV['STAGE'] = ENV['LAST_STAGE']
      end
    end
  end
end
