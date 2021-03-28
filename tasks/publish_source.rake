require File.expand_path(File.dirname(__FILE__) + '/util')

REMOTE_REPOSITORY = "#{WORKSPACE_DIR}/target/remote_repository"

def changes_between_refs?(from_branch, to_branch)
  `git log #{from_branch}..#{to_branch} 2>&1`.split.select {|l| l.size != 0}.size > 0
end

desc 'Commit the source to a local copy of an external repository'
task 'source:commit' do
  artifact = Buildr.project('akasha:java').package(:sources)
  artifact.invoke

  origin_url = 'https://github.com/akasha/akasha-java.git'

  travis_build_number = ENV['TRAVIS_BUILD_NUMBER']
  origin_url = origin_url.gsub('https://github.com/', 'git@github.com:') if travis_build_number

  rm_rf REMOTE_REPOSITORY

  sh "git clone -b master --depth 1 #{origin_url} #{REMOTE_REPOSITORY}"

  in_dir(REMOTE_REPOSITORY) do
    rm_rf Dir["#{REMOTE_REPOSITORY}/akasha"]
    sh "jar -xf #{artifact} akasha"
    sh 'git add . -f'
    sh 'git commit -m "Updating source to latest build"' rescue nil
  end
end

desc 'Publish the source to an external repository'
task 'source:publish' => ['source:commit'] do
  in_dir(REMOTE_REPOSITORY) do
    sh 'git push origin master' if changes_between_refs?('origin/master', 'master')
  end
end

desc 'Publish the source to an external repository and tag the version with the product version'
task 'source:publish_and_tag' => ['source:publish'] do
  in_dir(REMOTE_REPOSITORY) do
    sh "git tag v#{ENV['PRODUCT_VERSION']}"
    sh 'git push origin --tags'
  end
end

desc 'Publish the source to an external repository iff current HEAD is a tag on blessed branch'
task 'source:publish_if_tagged' do
  candidate_branches = %w(master)
  tag = get_head_tag_if_any
  if tag.nil?
    puts 'Current HEAD is not a tag. Skipping site:publish step.'
  else
    puts "Current HEAD is a tag: #{tag}"
    if is_tag_on_candidate_branches?(tag, candidate_branches)
      task('site:publish_and_tag').invoke
    end
  end
end

def get_head_tag_if_any
  version = `git describe --exact-match --tags 2>&1`
  if 0 == $?.exitstatus && version =~ /^v[0-9]/ && (ENV['TRAVIS_BUILD_ID'].nil? || ENV['TRAVIS_TAG'].to_s != '')
    version.strip
  else
    nil
  end
end

def is_tag_on_branch?(tag, branch)
  output = `git tag --merged #{branch} 2>&1`
  tags = output.split
  tags.include?(tag)
end

def is_tag_on_candidate_branches?(tag, branches)
  sh 'git fetch origin'
  branches.each do |branch|
    if is_tag_on_branch?(tag, branch)
      puts "Tag #{tag} is on branch: #{branch}"
      return true
    elsif is_tag_on_branch?(tag, "origin/#{branch}")
      puts "Tag #{tag} is on branch: origin/#{branch}"
      return true
    else
      puts "Tag #{tag} is not on branches: #{branch} or origin/#{branch}"
    end
  end
  false
end
