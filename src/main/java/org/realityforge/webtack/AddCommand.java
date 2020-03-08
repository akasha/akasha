package org.realityforge.webtack;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;

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
    return ExitCodes.SUCCESS_EXIT_CODE;
  }
}
