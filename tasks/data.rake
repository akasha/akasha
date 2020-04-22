def run_webtack(args)
  pkg = Buildr.project('webtack:cli').package(:jar, :classifier => 'all')
  pkg.invoke

  actual_args = []
  actual_args << '-jar'
  actual_args << pkg.to_s
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

task "data:load" do
  in_dir(WORKSPACE_DIR) do
    run_webtack(%w(--verbose -d data load))
  end
end
