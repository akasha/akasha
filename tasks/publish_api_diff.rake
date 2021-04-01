require File.expand_path(File.dirname(__FILE__) + '/util')

desc 'Publish the api-diff to the associated website'
task 'api_diff:publish' do
  version_diff_filename = "#{WORKSPACE_DIR}/api-test/#{ENV['PREVIOUS_PRODUCT_VERSION']}-#{ENV['PRODUCT_VERSION']}.json"
  if File.exist?(version_diff_filename)
    origin_url = 'https://github.com/akasha/akasha-java.git'
    origin_url = origin_url.gsub('https://github.com/', 'git@github.com:') if ENV['TRAVIS_BUILD_NUMBER']

    repository_dir = "#{WORKSPACE_DIR}/target/website_repository"

    rm_rf repository_dir

    sh "git clone -b gh-pages --depth 1 #{origin_url} #{repository_dir}"

    FileUtils.cp version_diff_filename, "#{repository_dir}/api-diff/data/akasha-java/#{ENV['PREVIOUS_PRODUCT_VERSION']}-#{ENV['PRODUCT_VERSION']}.json"

    in_dir(repository_dir) do
      sh "git add api-diff/data/akasha-java/#{ENV['PREVIOUS_PRODUCT_VERSION']}-#{ENV['PRODUCT_VERSION']}.json -f"
      sh "git commit -m \"Updating api-diff between version #{ENV['PREVIOUS_PRODUCT_VERSION']} and #{ENV['PRODUCT_VERSION']}\"" rescue nil
      sh 'git push origin gh-pages' if changes_between_refs?('origin/gh-pages', 'gh-pages')
    end
  end
end
