module Buildr
  class BazelJ2cl
    class << self

      def define_bazel_j2cl_test(root_project, projects, requires, options = {})
        desc 'Verify that the specified packages can be compiled with J2CL'
        root_project.task('bazel_j2cl_test') do
          perform_bazel_test(root_project, projects, requires, options) if ENV['J2CL'].nil? || ENV['J2CL'] == root_project.name
        end
      end

      private

      def perform_bazel_test(root_project, projects, requires, options)
        packages = projects.collect { |p| p.packages }.flatten.select{|p| p.classifier.nil? }.sort.uniq

        depgen_cache_dir = root_project._(:target, :depgen_artifact_cache)
        cache_dir = root_project._(:target, :artifact_cache)
        bazel_workspace_dir = root_project._(:target, :bazel_workspace)

        install_artifacts_into_local_cache(cache_dir, projects)

        FileUtils.mkdir_p bazel_workspace_dir
        write_bazelrc(bazel_workspace_dir)
        write_workspace(bazel_workspace_dir)
        write_js_src(bazel_workspace_dir, requires)
        write_build(bazel_workspace_dir, packages)
        write_dependency_yml(bazel_workspace_dir, cache_dir, packages, options)
        write_dependency_bzl(bazel_workspace_dir, depgen_cache_dir)

        sh "cd #{bazel_workspace_dir} && bazel build :all"
      end

      def write_js_src(bazel_workspace_dir, requires)
        File.write("#{bazel_workspace_dir}/src.js",
                   "goog.module('bazel.BuildTest');\n" +
                     requires.collect { |r| "goog.require('#{r}');\n" }.join)
      end

      def write_bazelrc(dir)
        # "build --spawn_strategy=local" is only required because
        # jsinterop-base does not support sandboxing
        File.write("#{dir}/.bazelrc", <<TEXT)
build --incompatible_strict_action_env
build --strict_system_includes
build --spawn_strategy=local
TEXT
      end

      def write_workspace(dir)
        File.write("#{dir}/WORKSPACE", <<TEXT)
workspace(name = "bazel_test")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "com_google_j2cl",
    strip_prefix = "j2cl-master",
    url = "https://github.com/google/j2cl/archive/master.zip",
)

load("@com_google_j2cl//build_defs:repository.bzl", "load_j2cl_repo_deps")

load_j2cl_repo_deps()

load("@com_google_j2cl//build_defs:rules.bzl", "setup_j2cl_workspace")

setup_j2cl_workspace()

load("//:dependencies.bzl", "generate_workspace_rules")

generate_workspace_rules()

# Required for jsinterop-base dependencies
_JSINTEROP_BASE_VERSION = "a2b98ca84a4daa04d69d90dce49bc74108ad733c"
http_archive(
    name = "com_google_jsinterop_base",
    strip_prefix = "jsinterop-base-%s" % _JSINTEROP_BASE_VERSION,
    url = "https://github.com/google/jsinterop-base/archive/%s.zip" % _JSINTEROP_BASE_VERSION,
)
TEXT
      end

      def write_build(dir, packages)
        content = <<TEXT
package(default_visibility = ["//visibility:public"])

alias( name = "jsinterop_annotations-j2cl", actual = "@com_google_j2cl//:jsinterop-annotations-j2cl", visibility = ["//visibility:public"],)

alias( name = "jsinterop_base-j2cl", actual = "@com_google_jsinterop_base//:jsinterop-base-j2cl", )

load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_import", "j2cl_application")

load("@io_bazel_rules_closure//closure:defs.bzl", "closure_js_library")

j2cl_import( name = "javaemul_internal_annotations-j2cl", jar = "@org_gwtproject_gwt//user:gwt-javaemul-internal-annotations", )

load("//:dependencies.bzl", "generate_targets")

generate_targets()
TEXT
        packages.collect { |d| d.to_spec_hash }.each do |d|
          name = d[:id].gsub('-','_')

          content += <<TEXT

closure_js_library( name = "#{name}-closure", srcs = ["src.js"], deps = [":#{name}-j2cl"], )

j2cl_application( name = "#{name}-app", entry_points = ["bazel.BuildTest"], extra_production_args = ["--env=CUSTOM"], deps = [":#{name}-closure"], )
TEXT
        end
        File.write("#{dir}/BUILD.bazel", content)
      end

      def write_dependency_yml(dir, cache_dir, dependencies, options)
        content = <<TEXT
repositories:
  - name: local
    url: file://#{cache_dir}
  - name: central
    url: https://repo.maven.apache.org/maven2
options:
  workspaceDirectory: .
  aliasStrategy: ArtifactId
  verifyConfigSha256: false
  defaultNature: J2cl
replacements:
  - coord: com.google.jsinterop:jsinterop-annotations
    targets:
      - target: ":jsinterop_annotations-j2cl"
  - coord: com.google.jsinterop:base
    targets:
      - target: ":jsinterop_base-j2cl"
  - coord: org.realityforge.javaemul.internal.annotations:javaemul.internal.annotations
    targets:
      - target: ":javaemul_internal_annotations-j2cl"
artifacts:
TEXT

        dependencies.collect { |d| d.to_spec_hash }.each do |d|
          content += "  - coord: #{d[:group]}:#{d[:id]}:#{d[:version]}\n"

          if d[:group].to_s == 'org.realityforge.javax.annotation'
            # This package does all sorts of uglies including colliding with a
            # annotation that is already present in jre emulation later so we
            # add a suppression to ignore problem
            content += <<TEXT
    j2cl:
      suppress: [CR_REDECLARED_PROVIDES]
TEXT
          end
        end

        if options[:javax_annotation]
          content += <<TEXT
  - coord: org.realityforge.javax.annotation:javax.annotation
    j2cl:
      suppress: [CR_REDECLARED_PROVIDES]
TEXT
        end

        File.write("#{dir}/dependencies.yml", content)
      end

      def write_dependency_bzl(bazel_workspace_dir, depgen_cache_dir)
        depgen = Buildr.artifact('org.realityforge.bazel.depgen:bazel-depgen:jar:all:0.12')
        depgen.invoke

        args = []
        args << Java::Commands.path_to_bin('java')
        args << '-jar'
        args << depgen.to_s
        args << '--config-file'
        args << 'dependencies.yml'
        args << '--directory' << bazel_workspace_dir
        args << '--cache-directory' << depgen_cache_dir
        args << 'generate'

        sh args.join(' ')
      end

      def install_artifacts_into_local_cache(cache_dir, projects_to_upload)
        local_test_repository_url = URI.join('file:///', File.expand_path(cache_dir)).to_s
        old_release_to = Buildr.repositories.release_to
        begin
          # First we install them in a local repository so we don't have to access the network during local builds
          Buildr.repositories.release_to = local_test_repository_url
          projects_to_upload.each do |project|
            project.packages.each do |pkg|
              # Uninstall version already present in local maven cache
              pkg.uninstall
              # Install version into local repository
              pkg.upload
            end
          end
        ensure
          Buildr.repositories.release_to = old_release_to
        end
      end
    end
  end
end
