def run_webtack(args)
  pkg = Buildr.project('akasha:cli').package(:jar, :classifier => 'all')
  pkg.invoke

  jsinterop_pkg = project('akasha:jsinterop-generator').package(:jar, :classifier => 'all')
  jsinterop_pkg.invoke

  react4j_pkg = project('akasha:react4j-generator').package(:jar, :classifier => 'all')
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

%w(speech bluetooth main react4j).each do |pipeline|
  desc "Run the #{pipeline} pipeline"
  task "data:run_#{pipeline}_pipeline" do
    in_dir(WORKSPACE_DIR) do
      run_webtack(%W(--verbose -d data run #{pipeline}))
    end
  end
  task 'data:run_pipelines' => %W(data:run_#{pipeline}_pipeline)
end

desc 'Run all of the pipelines'
task 'data:run_pipelines'
