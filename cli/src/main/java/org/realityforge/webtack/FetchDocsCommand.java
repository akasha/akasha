package org.realityforge.webtack;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
import org.realityforge.webtack.model.tools.mdn_scanner.config2.DocIndex;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.EntryIndex;
import org.realityforge.webtack.model.tools.mdn_scanner.config2.IndexIOException;

final class FetchDocsCommand
  extends ConfigurableCommand
{
  @Nonnull
  static final String COMMAND = "fetch-docs";
  private static final int FORCE_OPT = 'f';
  private static final int STAMP_OPT = 1;
  private static final int SINCE_STAMP_OPT = 4;
  private static final int SINCE_OPT = 2;
  private static final int NO_REMOVE_SOURCE_OPT = 3;
  private static final CLOptionDescriptor[] OPTIONS = new CLOptionDescriptor[]
    {
      new CLOptionDescriptor( "force",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              FORCE_OPT,
                              "Force the downloading of the documentation even if the last modified at time indicates it is up to date." ),
      new CLOptionDescriptor( "stamp",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              STAMP_OPT,
                              "Write the current time in the global time stamp file.",
                              new int[]{ SINCE_OPT, SINCE_STAMP_OPT } ),
      new CLOptionDescriptor( "since-stamp",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              SINCE_STAMP_OPT,
                              "Only update documentation if they have not been updated since the timestamp in the global time stamp file.",
                              new int[]{ SINCE_OPT } ),
      new CLOptionDescriptor( "since",
                              CLOptionDescriptor.ARGUMENT_REQUIRED,
                              SINCE_OPT,
                              "Only update documentation if they have not been updated since the specified timestamp." ),
      new CLOptionDescriptor( "no-remove-source",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              NO_REMOVE_SOURCE_OPT,
                              "Do not remove html after fetching and extracting documentation." )
    };
  @Nonnull
  private final Set<String> _typeNames = new LinkedHashSet<>();
  private boolean _force;
  private boolean _noRemoveSource;
  private long _sinceLastUpdatedAt;
  private boolean _loadTimestamp;
  private boolean _stamp;

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
      else if ( SINCE_OPT == optionId )
      {
        final String argument = option.getArgument();
        try
        {
          _sinceLastUpdatedAt = Long.parseLong( argument );
        }
        catch ( final NumberFormatException nfe )
        {
          environment.logger().log( Level.WARNING, () -> "Failed to parse since argument '" + argument + "'" );
          return false;
        }
      }
      else if ( SINCE_STAMP_OPT == optionId )
      {
        _loadTimestamp = true;
      }
      else if ( STAMP_OPT == optionId )
      {
        _sinceLastUpdatedAt = System.currentTimeMillis();
        _stamp = true;
      }
      else
      {
        assert CLOption.TEXT_ARGUMENT == optionId;
        _typeNames.add( option.getArgument() );
      }
    }

    if ( _loadTimestamp )
    {
      final Path file = globalTimestampFile( environment );
      if ( !Files.exists( file ) )
      {
        environment.logger().log( Level.WARNING,
                                  () -> "--since-stamp specified but global " +
                                        "timestamp file " + file + " does not exist" );
        return false;
      }
    }

    return true;
  }

  @Nonnull
  private Path globalTimestampFile( @Nonnull final Environment environment )
  {
    return environment.docDirectory().resolve( "lastUpdated.timestamp" );
  }

  @Override
  int run( @Nonnull final Context context )
  {
    final Logger logger = context.environment().logger();
    final DocRepositoryRuntime runtime = context.docRuntime();
    final MdnDocScanner scanner = new MdnDocScanner( runtime, new Listener( logger ) );

    // This value signifies that we should load the timestamp from the global timestamp
    if ( _loadTimestamp )
    {
      final Path file = globalTimestampFile( context.environment() );
      try
      {
        final String text =
          new String( Files.readAllBytes( file ), StandardCharsets.UTF_8 );
        _sinceLastUpdatedAt = Long.parseLong( text );
      }
      catch ( final Exception e )
      {
        context
          .environment()
          .logger()
          .log( Level.WARNING, "Failed to load timestamp from global timestamp file " + file, e );
        return ExitCodes.ERROR_BAD_TIMESTAMP_READ_ERROR_CODE;
      }
    }
    else if ( _stamp )
    {
      final Path file = globalTimestampFile( context.environment() );
      final Path docsDirectory = file.getParent();
      try
      {
        if ( !Files.exists( docsDirectory ) )
        {
          Files.createDirectories( docsDirectory );
        }
        Files.write( file, Long.toString( _sinceLastUpdatedAt ).getBytes( StandardCharsets.UTF_8 ) );
      }
      catch ( final IOException e )
      {
        context
          .environment()
          .logger()
          .log( Level.WARNING, "Failed to load timestamp from global timestamp file " + file, e );
        return ExitCodes.ERROR_BAD_TIMESTAMP_WRITE_ERROR_CODE;
      }
    }

    final List<String> typeNames =
      _typeNames.isEmpty() ? context.docRuntime().findTypes() : new ArrayList<>( _typeNames );
    if ( logger.isLoggable( Level.INFO ) )
    {
      logger.log( Level.INFO, "Fetch of documentation of " + typeNames.size() +
                              " type starting at " + System.currentTimeMillis() + "." );
    }
    for ( final String typeName : typeNames )
    {
      final DocIndex docIndex = context.docRuntime().getIndexForType( typeName );
      final long lastModifiedAt = docIndex.getContent().getLastModifiedAt();
      if ( _sinceLastUpdatedAt > 0 && lastModifiedAt > _sinceLastUpdatedAt )
      {
        if ( logger.isLoggable( Level.FINE ) )
        {
          logger.log( Level.FINE, "Fetch of documentation for element named '" + typeName + "' " +
                                  "skipped as it has been checked after specified since time." );
        }
        continue;
      }
      if ( logger.isLoggable( Level.FINE ) )
      {
        logger.log( Level.FINE, "Fetching documentation for element named '" + typeName + "'" );
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
      if ( _logger.isLoggable( Level.INFO ) )
      {
        _logger.log( Level.INFO,
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
