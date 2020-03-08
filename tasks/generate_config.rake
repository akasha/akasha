def generate_config_resource(project)
  generated_dir = project._(:target, :generated, :versions, :main, :resources)
  generated_file = "#{base_dir}/config.properties"
  project.file(generated_file) do
    rm_rf generated_dir
    base_dir = "#{generated_dir}/#{project.group.gsub('.', '/')}"
    mkdir_p base_dir
    File.write("#{base_dir}/config.properties", <<-PROPS)
version=#{project.version}
    PROPS
  end
  project.file(generated_dir => [generated_file])
  desc 'Generate artifact confid resource file'
  project.task(':config:generate' => [generated_dir])
  project.iml.main_resource_directories << generated_dir
  project.resources.from(generated_dir)
end
