module Buildr
  class ApiDiffTool
    class << self
      def generate_differences_report(artifact_coordinate, old_version, new_version, new_file, output_file, options = {})
        revapi = Buildr.artifact('org.realityforge.revapi.diff:revapi-diff:jar:all:0.08')
        revapi.invoke

        old_artifact = Buildr.artifact("#{artifact_coordinate}:#{old_version}")
        old_artifact.invoke

        unless new_file
          new_artifact = Buildr.artifact("#{artifact_coordinate}:#{new_version}")
          new_artifact.invoke
          new_file = new_artifact.to_s
        end

        FileUtils.mkdir_p File.dirname(output_file)

        args = []
        args << Java::Commands.path_to_bin('java')
        args << '-jar'
        args << revapi.to_s
        args << '--old-api'
        args << "#{artifact_coordinate}:#{old_version}::#{old_artifact.to_s}"
        if options[:support_libs]
          options[:support_libs].each do |lib|
            args << '--old-api-support'
            args << lib.to_s
          end
        end
        args << '--new-api'
        args << "#{artifact_coordinate}:#{new_version}::#{new_file}"
        if options[:support_libs]
          options[:support_libs].each do |lib|
            args << '--new-api-support'
            args << lib.to_s
          end
        end
        args << '--output-file'
        args << output_file.to_s

        sh args.join(' ')
        if File.exist?(output_file)
          data = JSON.parse(IO.read(output_file, :encoding => 'UTF-8'))
          if data.empty?
            FileUtils.rm_f output_file
          else
            sh "git add #{output_file}"
          end
        end
      end

      def update_differences_report(artifact_coordinate, old_version, new_version, new_file, output_directory, options = {})
        output_file = "#{output_directory}/#{old_version}-#{new_version}.json"
        generate_differences_report(artifact_coordinate, old_version, new_version, new_file, output_file, options)
      end

      def test_differences_report(artifact_coordinate, old_version, new_version, new_file, output_directory, options = {})
        report_file = "#{output_directory}/#{old_version}-#{new_version}.json"
        tmp = nil
        begin
          tmp = Tempfile.open("#{old_version}-#{new_version}.json")
          tmp.close
          generate_differences_report(artifact_coordinate, old_version, new_version, new_file, tmp.path, options)

          report_content = File.exist?(report_file) ? IO.read(report_file, :encoding => 'UTF-8') : ''
          test_content = File.exist?(tmp.path) ? IO.read(tmp.path, :encoding => 'UTF-8') : ''
          if report_content != test_content
            if File.exist?(report_file)
              raise "Differences report at #{report_file} does not record the correct set differences between #{old_version} and #{new_version} for #{artifact_coordinate}"
            else
              raise "No differences report at #{report_file} but differences exist between #{old_version} and #{new_version} for #{artifact_coordinate}"
            end
          end
        ensure
          tmp.close unless tmp.nil?
        end
      end
    end
  end
end
