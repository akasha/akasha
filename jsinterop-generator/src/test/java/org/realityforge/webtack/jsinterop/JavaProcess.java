package org.realityforge.webtack.jsinterop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;

final class JavaProcess
{
  private JavaProcess()
  {
  }

  @SuppressWarnings( "SameParameterValue" )
  static int exec( @Nonnull final String className,
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
}