package org.realityforge.webtack;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.webtack.model.tools.mdn_scanner.DocEntry;
import org.realityforge.webtack.model.tools.mdn_scanner.DocException;
import org.realityforge.webtack.model.tools.mdn_scanner.DocKind;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.mdn_scanner.MdnDocScanner;
import org.realityforge.webtack.model.tools.mdn_scanner.MdnScannerListener;
import org.realityforge.webtack.model.tools.mdn_scanner.SourceFetchException;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.EntryIndex;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.IndexIOException;

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
    final DocRepositoryRuntime runtime = new DocRepositoryRuntime( context.environment().docDirectory() );
    final MdnDocScanner scanner = new MdnDocScanner( runtime, new Listener( logger ) );

    final Set<String> typeNames = _typeNames.isEmpty() ? context.docRuntime().findTypes() : _typeNames;
    for ( final String typeName : typeNames )
    {
      if ( logger.isLoggable( Level.FINE ) )
      {
        logger.log( Level.FINE, "Fetched documentation for element named '" + typeName + "'" );
      }

      try
      {
        scanner.fetchDocumentation( typeName, null, _force, !_noRemoveSource );
      }
      catch ( final SourceFetchException sfe )
      {
        final String message =
          "Error: Failed to fetch documentation for type named '" + sfe.getQualifiedName() +
          "' with the error: " + sfe.getCause();
        throw new TerminalStateException( message, sfe, ExitCodes.ERROR_DOC_SOURCE_FETCH_FAILED_CODE );
      }
      catch ( final IndexIOException ioe )
      {
        throw new TerminalStateException( "Error: " + ioe.getMessage(), ioe, ExitCodes.ERROR_DOC_SOURCE_IO_ERROR_CODE );
      }
      catch ( final DocException de )
      {
        final String message =
          "Error: Unexpected error fetching documentation. Error: " + de.getCause();
        throw new TerminalStateException( message, de, ExitCodes.ERROR_DOC_SOURCE_UNEXPECTED_ERROR_CODE );
      }
    }

    return ExitCodes.SUCCESS_EXIT_CODE;
  }

  private static final class Listener
    implements MdnScannerListener
  {
    @Nonnull
    private final Logger _logger;

    Listener( @Nonnull final Logger logger )
    {
      _logger = Objects.requireNonNull( logger );
    }

    @Override
    public void queueScan( @Nonnull final DocKind kind, @Nonnull final String typeName, @Nullable final String name )
    {
      if ( _logger.isLoggable( Level.FINER ) )
      {
        _logger.log( Level.FINER,
                     "Queuing fetch for documentation for type named '" +
                     typeName + ( null != name ? "." + name : "" ) + "' of type " + kind + "." );
      }
    }

    @Override
    public void entrySkipped( @Nonnull final DocEntry entry )
    {
      if ( _logger.isLoggable( Level.FINE ) )
      {
        _logger.log( Level.FINE,
                     "Documentation for element named '" +
                     entry.getName() +
                     "' not fetched as not sourced from standard MDN location." );
      }
    }

    @Override
    public void entryInvalid( @Nonnull final EntryIndex entryIndex, @Nonnull final DocEntry entry )
    {
      if ( _logger.isLoggable( Level.FINE ) )
      {
        _logger.log( Level.FINE,
                     "Documentation for element named '" +
                     entry.getName() +
                     "' could not extract the required fields from the website. Entry will be deleted." );
      }
    }

    @Override
    public void preEntryFetch( @Nonnull final EntryIndex entryIndex, @Nonnull final String url )
    {
      if ( _logger.isLoggable( Level.FINER ) )
      {
        _logger.log( Level.FINER,
                     "Documentation source for element named '" +
                     entryIndex.getQualifiedName() +
                     "' beginning fetch." );
      }
    }

    @Override
    public void entryDeleted( @Nonnull final EntryIndex entryIndex )
    {
      if ( _logger.isLoggable( Level.INFO ) )
      {
        _logger.log( Level.INFO, "Documentation for element named '" + entryIndex.getQualifiedName() + "' deleted." );
      }
    }

    @Override
    public void postEntryFetch( @Nonnull final EntryIndex entryIndex, @Nonnull final String url )
    {
      if ( _logger.isLoggable( Level.FINER ) )
      {
        _logger.log( Level.FINER,
                     "Documentation source for element named '" +
                     entryIndex.getQualifiedName() +
                     "' completed fetch." );
      }
    }

    @Override
    public void entryUpdated( @Nonnull final EntryIndex entryIndex, @Nonnull final DocEntry entry )
    {
      if ( _logger.isLoggable( Level.INFO ) )
      {
        _logger.log( Level.INFO, "Documentation for element named '" + entryIndex.getQualifiedName() + "' updated." );
      }
    }

    @Override
    public void entryUnmodified( @Nonnull final EntryIndex entryIndex, @Nonnull final DocEntry entry )
    {
      if ( _logger.isLoggable( Level.FINE ) )
      {
        _logger.log( Level.FINE,
                     "Documentation for element named '" + entryIndex.getQualifiedName() + "' is unchanged." );
      }
    }
  }
}
