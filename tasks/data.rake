require File.expand_path(File.dirname(__FILE__) + '/util')

def run_webtack(args)
  pkg = Buildr.project('akasha:webtack:cli').package(:jar, :classifier => 'all')
  pkg.invoke

  jsinterop_pkg = project('akasha:webtack:jsinterop-generator').package(:jar, :classifier => 'all')
  jsinterop_pkg.invoke

  react4j_pkg = project('akasha:webtack:react4j-generator').package(:jar, :classifier => 'all')
  react4j_pkg.invoke

  actual_args = []
  actual_args << '-cp'
  actual_args << "#{pkg}:#{jsinterop_pkg}:#{react4j_pkg}"
  actual_args << 'org.realityforge.webtack.Main'
  actual_args += args

  Java::Commands.java actual_args
end

task 'data:fetch' do
  in_dir(WORKSPACE_DIR) do
    run_webtack(%w(--verbose -d data fetch))
  end
end

task 'data:force_fetch' do
  in_dir(WORKSPACE_DIR) do
    run_webtack(%w(--verbose -d data fetch --force))
  end
end

desc 'Run the react4j pipeline'
task 'data:run_react4j_pipeline' do
  in_dir(WORKSPACE_DIR) do
    run_webtack(%w(--verbose -d data run react4j))
  end
end

desc 'Run the complete pipeline'
task 'data:run_complete_pipeline' do
  in_dir(WORKSPACE_DIR) do
    run_webtack(%w(--verbose -d data run complete))
  end

  a = artifact(:closure_compiler)
  a.invoke

  output = "#{WORKSPACE_DIR}/target/akasha-java/tmp/output.js"
  FileUtils.mkdir_p File.dirname(output)

  args = []
  args << Java::Commands.path_to_bin('java')
  args << '-jar'
  args << a.to_s
  args << '--compilation_level' << 'ADVANCED'
  args << '--env' << 'CUSTOM'
  args << '--warning_level' << 'VERBOSE'
  args << '--inject_libraries' << 'false'
  args << '--js_output_file' << output
  args << '--jscomp_error' << "'*'"
  args << "#{WORKSPACE_DIR}/akasha/java/generated/webtack/main/js/akasha/Akasha.externs.js"

  sh args.join(' ')
end

desc 'Run all of the pipelines'
task 'data:run_pipelines' => %w(data:run_complete_pipeline data:run_react4j_pipeline)
