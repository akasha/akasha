def scan_todos
  found_todos = false

  `cd #{File.expand_path(File.dirname(__FILE__) + '/..')} && git ls-files`.split("\n").
    select {|f| f =~ /\.java$/}.
    select {|f| File.exist?(f)}.
    each do |f|
    content = IO.read(f)
    matches = content.scan(/[ \/#]TODO[ :]([^\n]+)/i)
    if matches.size > 0
      puts "TODOs found in #{f}"
      matches.each do |match|
        puts "TODO: #{match[0].strip}"
        found_todos = true
      end
    end
  end
  raise 'Found TODO notes in source code' if found_todos
end

desc 'Verify that there are no TODO notes in codebase'
task 'todos:scan' do
  scan_todos
end
