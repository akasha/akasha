package org.realityforge.webtack;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.webtack.model.tools.mdn_scanner.DocException;
import org.realityforge.webtack.model.tools.mdn_scanner.DocFetchResult;
import org.realityforge.webtack.model.tools.mdn_scanner.DocKind;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.mdn_scanner.MdnDocScanner;
import org.realityforge.webtack.model.tools.mdn_scanner.SourceFetchException;
import org.realityforge.webtack.model.tools.mdn_scanner.SourceIOException;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocSourceConfig;

final class FetchDocsCommand
  extends ConfigurableCommand
{
  @Nonnull
  static final String COMMAND = "fetch-docs";
  private static final int FORCE_OPT = 'f';
  private static final int NO_REMOVE_SOURCE_OPT = 3;
  private static final CLOptionDescriptor[] OPTIONS = new CLOptionDescriptor[]
    {
      new CLOptionDescriptor( "force",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              FORCE_OPT,
                              "Force the downloading of the documentation even if the last modified at time indicates it is up to date." ),
      new CLOptionDescriptor( "no-remove-source",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              NO_REMOVE_SOURCE_OPT,
                              "Do not remove html after fetching and extracting documentation." )
    };
  @Nonnull
  private final Set<String> _typeNames = new LinkedHashSet<>();
  private boolean _force;
  private boolean _noRemoveSource;

  FetchDocsCommand()
  {
    super( COMMAND, "Fetch the documentation for WebIDL types", OPTIONS );
  }

  @Override
  boolean processArguments( @Nonnull final Environment environment, @Nonnull final List<CLOption> arguments )
  {
    for ( final CLOption option : arguments )
    {
      final int optionId = option.getId();
      if ( FORCE_OPT == optionId )
      {
        _force = true;
      }
      else if ( NO_REMOVE_SOURCE_OPT == optionId )
      {
        _noRemoveSource = true;
      }
      else
      {
        assert CLOption.TEXT_ARGUMENT == optionId;
        _typeNames.add( option.getArgument() );
      }
    }

    return true;
  }

  @Override
  int run( @Nonnull final Context context )
  {
    final Logger logger = context.environment().logger();
    final MdnDocScanner scanner =
      new MdnDocScanner( new DocRepositoryRuntime( context.docRepository(), context.environment().docDirectory() ) );

    for ( final String typeName : getTypeNames( context ) )
    {
      if ( logger.isLoggable( Level.FINE ) )
      {
        logger.log( Level.FINE, "Fetched documentation for element named '" + typeName + "'" );
      }

      try
      {
        final DocFetchResult result =
          scanner.fetchDocumentation( DocKind.Type, typeName, null, _force, !_noRemoveSource );
        if ( logger.isLoggable( Level.FINE ) && !result.isChanged() )
        {
          logger.log( Level.FINE, "Documentation for element named '" + typeName + "' is unchanged." );
        }
        else if ( logger.isLoggable( Level.FINE ) && result.isChanged() )
        {
          logger.log( Level.FINE, "Documentation for element named '" + typeName + "' created or updated." );
        }
      }
      catch ( final SourceFetchException sfe )
      {
        final String message =
          "Error: Failed to fetch documentation for type named '" + sfe.getSource().getName() +
          "' with the error: " + sfe.getCause();
        throw new TerminalStateException( message, ExitCodes.ERROR_DOC_SOURCE_FETCH_FAILED_CODE );
      }
      catch ( final SourceIOException sioe )
      {
        final String message =
          "Error: " + sioe.getMessage() + ". Element: " + sioe.getSource().getName() +
          " Error: " + sioe.getCause();
        throw new TerminalStateException( message, ExitCodes.ERROR_DOC_SOURCE_IO_ERROR_CODE );
      }
      catch ( final DocException sioe )
      {
        final String message =
          "Error: Unexpected error fetching documentation. Error: " + sioe.getCause();
        throw new TerminalStateException( message, ExitCodes.ERROR_DOC_SOURCE_UNEXPECTED_ERROR_CODE );
      }
    }

    return ExitCodes.SUCCESS_EXIT_CODE;
  }

  @Nonnull
  private Set<String> getTypeNames( @Nonnull final Context context )
  {
    return _typeNames.isEmpty() ?
           context.docRepository().getSources().stream().map( DocSourceConfig::getName ).collect( Collectors.toSet() ) :
           _typeNames;
  }
}
