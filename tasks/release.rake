WORKSPACE_DIR = File.expand_path(File.dirname(__FILE__) + '/..')

def in_dir(dir)
  current = Dir.pwd
  begin
    Dir.chdir(dir)
    yield
  ensure
    Dir.chdir(current)
  end
end

ENV['PREVIOUS_PRODUCT_VERSION'] = nil if ENV['PREVIOUS_PRODUCT_VERSION'].to_s == ''
ENV['PRODUCT_VERSION'] = nil if ENV['PRODUCT_VERSION'].to_s == ''

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

desc 'Perform a release'
task 'perform_release' do

  in_dir(WORKSPACE_DIR) do
    stage('ExtractVersion', 'Extract the last version from CHANGELOG.md and derive next version unless specified', :always_run => true) do
      changelog = IO.read('CHANGELOG.md')
      ENV['PREVIOUS_PRODUCT_VERSION'] ||= changelog[/^### \[v(\d+\.\d+(\.\d+)?)\]/, 1] || '0.00'

      next_version = ENV['PRODUCT_VERSION']
      unless next_version
        version_parts = ENV['PREVIOUS_PRODUCT_VERSION'].split('.')
        next_version = "#{version_parts[0]}.#{sprintf('%02d', version_parts[1].to_i + 1)}#{version_parts.length > 2 ? ".#{version_parts[2]}" : ''}"
        ENV['PRODUCT_VERSION'] = next_version
      end

      # Also initialize release date if required
      ENV['RELEASE_DATE'] ||= Time.now.strftime('%Y-%m-%d')
    end

    stage('ZapWhite', 'Ensure that zapwhite produces no changes') do
      sh 'bundle exec zapwhite'
    end

    stage('GitClean', 'Ensure there is nothing to commit and the working tree is clean') do
      status_output = `git status -s 2>&1`.strip
      raise 'Uncommitted changes in git repository. Please commit them prior to release.' if 0 != status_output.size
    end

    stage('TodoScan', 'Verify that there are no TODO notes in codebase') do
      task('todos:scan').invoke
    end

    stage('StagingCleanup', 'Remove artifacts from staging repository') do
      task('staging:cleanup').invoke
    end

    stage('Build', 'Build the project to ensure that the tests pass') do
      sh "bundle exec buildr clean package install PRODUCT_VERSION=#{ENV['PRODUCT_VERSION']}#{ENV['TEST'].nil? ? '' : " TEST=#{ENV['TEST']}"}#{Buildr.application.options.trace ? ' --trace' : ''}"
    end

    stage('PatchChangelog', 'Patch the changelog to update from previous release') do
      changelog = IO.read('CHANGELOG.md')
      from = '0.00' == ENV['PREVIOUS_PRODUCT_VERSION'] ? `git rev-list --max-parents=0 HEAD`.strip : "v#{ENV['PREVIOUS_PRODUCT_VERSION']}"
      changelog = changelog.gsub("### Unreleased\n", <<HEADER)
### [v#{ENV['PRODUCT_VERSION']}](https://github.com/realityforge/webtack/tree/v#{ENV['PRODUCT_VERSION']}) (#{ENV['RELEASE_DATE']}) · [Full Changelog](https://github.com/realityforge/webtack/compare/#{from}...v#{ENV['PRODUCT_VERSION']})
HEADER
      IO.write('CHANGELOG.md', changelog)

      sh 'git reset 2>&1 1> /dev/null'
      sh 'git add CHANGELOG.md'
      sh 'git commit -m "Update CHANGELOG.md in preparation for release"'
    end

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

    stage('TagProject', 'Tag the project') do
      sh "git tag v#{ENV['PRODUCT_VERSION']}"
    end

    stage('StageRelease', 'Stage the release') do
      IO.write('_buildr.rb', "repositories.release_to = { :url => 'https://stocksoftware.jfrog.io/stocksoftware/staging', :username => '#{ENV['STAGING_USERNAME']}', :password => '#{ENV['STAGING_PASSWORD']}' }")
      sh 'bundle exec buildr clean upload TEST=no'
      sh 'rm -f _buildr.rb'
    end

    stage('MavenCentralPublish', 'Publish artifacts to Maven Central') do
      sh 'bundle exec buildr clean mcrt:publish_if_tagged TEST=no GWT=no'
    end

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

    stage('PushChanges', 'Push changes to git repository') do
      sh 'git push'
      sh 'git push --tags'
    end

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
      client.create_release('realityforge/webtack', tag, :name => tag, :body => changes, :draft => false, :prerelease => prerelease)

      candidates = client.list_milestones('realityforge/webtack').select {|m| m[:title].to_s == tag}
      unless candidates.empty?
        milestone = candidates[0]
        unless milestone[:state] == 'closed'
          client.update_milestone('realityforge/webtack', milestone[:number], :state => 'closed')
        end
      end
    end
  end

  if ENV['STAGE']
    if ENV['LAST_STAGE'] == ENV['STAGE']
      puts "LAST_STAGE specified '#{ENV['LAST_STAGE']}', later stages were skipped"
    else
      raise "Invalid STAGE specified '#{ENV['STAGE']}' that did not match any stage"
    end
  end
end
