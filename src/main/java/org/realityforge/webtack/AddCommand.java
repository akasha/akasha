package org.realityforge.webtack;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.webtack.config.RepositoryConfig;
import org.realityforge.webtack.config.SourceConfig;

final class AddCommand
  extends ConfigurableCommand
{
  @Nonnull
  static final String COMMAND = "add";
  private static final int NO_FETCH_OPT = 2;
  private static final CLOptionDescriptor[] OPTIONS = new CLOptionDescriptor[]
    {
      new CLOptionDescriptor( "no-fetch",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              NO_FETCH_OPT,
                              "Skip running fetch command after registering WebIDL source." )
    };
  private boolean _noFetch;
  private String _sourceUrl;

  AddCommand()
  {
    super( COMMAND, "Register a url from which to download a WebIDL source", OPTIONS );
  }

  @Override
  boolean processArguments( @Nonnull final Environment environment, @Nonnull final List<CLOption> arguments )
  {
    // Get a list of parsed options
    for ( final CLOption option : arguments )
    {
      if ( CLOption.TEXT_ARGUMENT == option.getId() )
      {
        final String argument = option.getArgument();
        if ( null != _sourceUrl )
        {
          final String message =
            "Error: Attempted to specify multiple source urls arguments.\n" +
            "\tSpecified source: " + _sourceUrl + "\n" +
            "\tUnexpected parameter: " + argument;
          environment.logger().log( Level.SEVERE, message );
          return false;
        }
        else
        {
          try
          {
            // Check format of URI by attempting to parse it
            new URI( argument );
            _sourceUrl = argument;
          }
          catch ( final URISyntaxException use )
          {
            final String message = "Error: Invalid url specified: " + argument + "  Error: " + use.getMessage();
            environment.logger().log( Level.SEVERE, message );
            return false;
          }
        }
      }
      else
      {
        assert NO_FETCH_OPT == option.getId();
        _noFetch = true;
      }
    }

    return true;
  }

  @Override
  int run( @Nonnull final Context context )
  {
    final Logger logger = context.environment().logger();
    if ( logger.isLoggable( Level.INFO ) )
    {
      logger.log( Level.INFO, "Adding source: " + _sourceUrl );
    }

    final RepositoryConfig config = context.config();

    if ( config.getSources().stream().anyMatch( s -> Objects.equals( _sourceUrl, s.getUrl() ) ) )
    {
      final String message =
        "Error: Existing source exists with url " + _sourceUrl + " and can not add another source with the same url";
      logger.log( Level.SEVERE, message );
      return ExitCodes.ERROR_SOURCE_EXISTS_CODE;
    }

    final SourceConfig source = new SourceConfig();
    source.setUrl( _sourceUrl );
    config.getSources().add( source );
    final Path configLocation = config.getConfigLocation();
    try
    {
      RepositoryConfig.save( configLocation, config );
    }
    catch ( final Exception e )
    {
      final String message =
        "Error: Failed to save config file " + configLocation + " after adding source " + _sourceUrl;
      logger.log( Level.SEVERE, message );
      return ExitCodes.ERROR_SAVING_CONFIG_CODE;
    }
    if ( !_noFetch )
    {
      //return new FetchCommand().run( context );
      return ExitCodes.SUCCESS_EXIT_CODE;
    }
    else
    {
      return ExitCodes.SUCCESS_EXIT_CODE;
    }
  }
}
