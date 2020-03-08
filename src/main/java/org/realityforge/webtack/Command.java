package org.realityforge.webtack;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import javax.annotation.Nonnull;
import org.realityforge.webtack.config.RepositoryConfig;

abstract class Command
{
  interface Context
  {
    @Nonnull
    Environment environment();

    @Nonnull
    RepositoryConfig config();
  }

  @Nonnull
  private final String _name;
  @Nonnull
  private final String _help;

  Command( @Nonnull final String name, @Nonnull final String help )
  {
    _name = Objects.requireNonNull( name );
    _help = Objects.requireNonNull( help );
  }

  @Nonnull
  String getName()
  {
    return _name;
  }

  @Nonnull
  String getHelp()
  {
    return _help;
  }

  boolean requireConfigFile()
  {
    return true;
  }

  boolean processOptions( @Nonnull final Environment environment, @Nonnull final String... args )
  {
    if ( args.length > 0 )
    {
      environment.logger()
        .log( Level.SEVERE, "Error: Unknown arguments to " + _name + " command. Arguments: " + Arrays.asList( args ) );
      return false;
    }
    else
    {
      return true;
    }
  }

  abstract int run( @Nonnull Context context )
    throws Exception;
}
