def run_webtack(args)
  pkg = Buildr.project('webtack:cli').package(:jar, :classifier => 'all')
  pkg.invoke

  jsinterop_pkg = project('webtack:jsinterop-generator').package(:jar, :classifier => 'all')
  jsinterop_pkg.invoke

  react4j_pkg = project('webtack:react4j-generator').package(:jar, :classifier => 'all')
  react4j_pkg.invoke

  actual_args = []
  actual_args << '-cp'
  actual_args << "#{pkg}:#{jsinterop_pkg}:#{react4j_pkg}"
  actual_args << 'org.realityforge.webtack.Main'
  actual_args += args

  Java::Commands.java actual_args
end

task "data:fetch" do
  in_dir(WORKSPACE_DIR) do
    run_webtack(%w(--verbose -d data fetch))
  end
end

task "data:force_fetch" do
  in_dir(WORKSPACE_DIR) do
    run_webtack(%w(--verbose -d data fetch --force))
  end
end

task "data:run_pipelines" do
  in_dir(WORKSPACE_DIR) do
    run_webtack(%w(--verbose -d data run speech))
    run_webtack(%w(--verbose -d data run bluetooth))
    run_webtack(%w(--verbose -d data run main))
    run_webtack(%w(--verbose -d data run react4j))
  end
end
