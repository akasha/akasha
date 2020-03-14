# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements. See the NOTICE file distributed with this
# work for additional information regarding copyright ownership. The ASF
# licenses this file to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
# WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
# License for the specific language governing permissions and limitations under
# the License.

module Buildr
  module Antlr4
    class << self

      # The specs for requirements
      def runtime_dependencies
        %w(org.antlr:antlr4-runtime:jar:4.5.1)
      end

      # The specs for requirements
      def dependencies
        %w(
        org.antlr:antlr4:jar:4.5.1
        org.antlr:ST4:jar:4.0.8
        org.antlr:antlr-runtime:jar:3.5.2
        org.abego.treelayout:org.abego.treelayout.core:jar:1.0.1
        ) + runtime_dependencies
      end

      def antlr(*args)
        options = Hash === args.last ? args.pop.dup : {}
        rake_check_options options, :directory, :package

        cp = Buildr.artifacts(self.dependencies).each(&:invoke).map(&:to_s)

        Java::Commands.java 'org.antlr.v4.Tool', *(args + [{ :classpath => cp, :verbose => true, :dir => options[:directory] }])
      end
    end

    def compile_antlr(input_file, *args)
      options = Hash === args.last ? args.pop.dup : {}
      rake_check_options options, :directory, :package, :visitor, :listener
      args = args.dup

      target_dir = File.expand_path(options[:directory] || _(:target, :generated, :antlr, 'main/java'))

      project.iml.main_source_directories << target_dir if project.iml?

      file(target_dir => input_file) do |task|
        package_dir = "#{target_dir}/#{options[:package].gsub('.','/')}"
        mkdir_p package_dir
        args << "-o" << package_dir
        args << "-lib" << File.dirname(input_file)

        args << "-package" << options[:package] if options[:package]
        args << "-Werror"
        args << "-visitor" if !options[:visitor].nil? && options[:visitor]
        args << "-no-visitor" if !options[:visitor].nil? && !options[:visitor]
        args << "-listener" if !options[:listener].nil? && options[:listener]
        args << "-no-listener" if !options[:listener].nil? && !options[:listener]
        args << input_file
        begin
          Antlr4.antlr(args, :directory => package_dir)
        rescue Exception => e
          rm_rf target_dir
          raise e
        end
        touch target_dir
      end

      target_dir
    end
  end
end

class Buildr::Project
  include Buildr::Antlr4
end
