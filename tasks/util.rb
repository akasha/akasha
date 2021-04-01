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

def changes_between_refs?(from_branch, to_branch)
  `git log #{from_branch}..#{to_branch} 2>&1`.split.select {|l| l.size != 0}.size > 0
end
