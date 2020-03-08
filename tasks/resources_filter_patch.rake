class Buildr::Filter
  private

  def copy_map
    # TODO: The following line was commented out so resource directories can be generated
    # sources.each { |source| raise "Source directory #{source} doesn't exist" unless File.exist?(source.to_s) }
    raise 'No target directory specified, where am I going to copy the files to?' if target.nil?

    sources.flatten.map(&:to_s).inject({}) do |map, source|
      files = Util.recursive_with_dot_files(source).
        map {|file| Util.relative_path(file, source)}.
        select {|file| @include.empty? || @include.any? {|pattern| pattern_match(file, pattern)}}.
        reject {|file| @exclude.any? {|pattern| pattern_match(file, pattern)}}
      files.each do |file|
        src, dest = File.expand_path(file, source), File.expand_path(file, target.to_s)
        map[file] = src if !File.exist?(dest) || File.stat(src).mtime >= File.stat(dest).mtime
      end
      map
    end
  end
end
