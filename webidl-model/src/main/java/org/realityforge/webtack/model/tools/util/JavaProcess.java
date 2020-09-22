package org.realityforge.webtack.model.tools.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.tools.DiagnosticCollector;
import javax.tools.DocumentationTool;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

/**
 * Helper class used to execute java processes.
 */
public final class JavaProcess
{
  private JavaProcess()
  {
  }

  @SuppressWarnings( "SameParameterValue" )
  public static int exec( @Nonnull final String className,
                          @Nonnull final List<String> jvmArgs,
                          @Nonnull final List<String> args,
                          @Nonnull final List<String> classpath )
    throws IOException, InterruptedException
  {
    final String javaHome = System.getProperty( "java.home" );
    final String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
    final List<String> command = new ArrayList<>();
    command.add( javaBin );
    command.addAll( jvmArgs );
    command.add( "-cp" );
    command.add( String.join( File.pathSeparator, classpath ) );
    command.add( className );
    command.addAll( args );
    final ProcessBuilder builder = new ProcessBuilder( command );
    final Process process = builder.inheritIO().start();
    process.waitFor();
    return process.exitValue();
  }

  @Nonnull
  public static Path javac( @Nonnull final List<Path> javaFiles,
                            @Nonnull final List<Path> classpathEntries,
                            @Nonnull final Path output )
    throws IOException
  {
    final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    final StandardJavaFileManager fileManager = compiler.getStandardFileManager( null, null, null );
    Files.createDirectories( output );
    final Iterable<? extends JavaFileObject> compilationUnits =
      fileManager.getJavaFileObjectsFromFiles( javaFiles
                                                 .stream()
                                                 .map( Path::toFile )
                                                 .collect( Collectors.toList() ) );
    final DiagnosticCollector<JavaFileObject> listener = new DiagnosticCollector<>();
    fileManager.setLocation( StandardLocation.CLASS_OUTPUT,
                             Collections.singletonList( output.toFile() ) );
    fileManager.setLocation( StandardLocation.SOURCE_OUTPUT,
                             Collections.singletonList( output.toFile() ) );
    fileManager.setLocation( StandardLocation.CLASS_PATH,
                             classpathEntries.stream().map( Path::toFile ).collect( Collectors.toList() ) );

    final JavaCompiler.CompilationTask task =
      compiler.getTask( null,
                        fileManager,
                        listener,
                        Arrays.asList( "-Xlint:all,-processing,-serial", "-Werror" ),
                        null,
                        compilationUnits );
    if ( !task.call() || !listener.getDiagnostics().isEmpty() )
    {
      throw new AssertionError( "Failed to compile files:\n" +
                                listener.getDiagnostics()
                                  .stream()
                                  .map( Object::toString )
                                  .collect( Collectors.joining( "\n" ) ) );
    }
    return output;
  }

  public static void javadoc( @Nonnull final List<Path> sourceDirectories,
                              @Nonnull final List<Path> javaFiles,
                              @Nonnull final List<Path> classpathElements,
                              @Nonnull final Path output )
    throws IOException
  {
    final DocumentationTool javadoc = ToolProvider.getSystemDocumentationTool();
    final StandardJavaFileManager fileManager = javadoc.getStandardFileManager( null, null, null );
    Files.createDirectories( output );
    final Iterable<? extends JavaFileObject> compilationUnits =
      fileManager.getJavaFileObjectsFromFiles( javaFiles
                                                 .stream()
                                                 .map( Path::toFile )
                                                 .collect( Collectors.toList() ) );
    final DiagnosticCollector<JavaFileObject> listener = new DiagnosticCollector<>();
    fileManager.setLocation( DocumentationTool.Location.DOCUMENTATION_OUTPUT,
                             Collections.singletonList( output.toFile() ) );
    fileManager.setLocation( StandardLocation.CLASS_PATH,
                             classpathElements.stream().map( Path::toFile ).collect( Collectors.toList() ) );
    fileManager.setLocation( StandardLocation.SOURCE_PATH,
                             sourceDirectories.stream().map( Path::toFile ).collect( Collectors.toList() ) );

    final DocumentationTool.DocumentationTask task =
      javadoc.getTask( null,
                       fileManager,
                       listener,
                       null,
                       Collections.singletonList( "-Xdoclint:all" ),
                       compilationUnits );
    if ( !task.call() )
    {
      throw new AssertionError( "Failed to javadoc files:\n" +
                                listener.getDiagnostics()
                                  .stream()
                                  .map( Object::toString )
                                  .collect( Collectors.joining( "\n" ) ) );
    }
  }
}
