package org.realityforge.webtack;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.mdn_scanner.DocException;
import org.realityforge.webtack.model.tools.mdn_scanner.DocKind;
import org.realityforge.webtack.model.tools.mdn_scanner.MdnDocScanner;
import org.realityforge.webtack.model.tools.mdn_scanner.SourceFetchException;
import org.realityforge.webtack.model.tools.mdn_scanner.SourceIOException;
import org.realityforge.webtack.model.tools.repository.config.RepositoryConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

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
                              "Force the downloading of the source even if the last modified at time indicates it is up to date." ),
      new CLOptionDescriptor( "no-remove-source",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              NO_REMOVE_SOURCE_OPT,
                              "Do not remove source after fetching and extracting documentation." )
    };
  @Nonnull
  private final Set<String> _sourceNames = new LinkedHashSet<>();
  private boolean _force;
  private boolean _noRemoveSource;

  FetchDocsCommand()
  {
    super( COMMAND, "Fetch the documentation for WebIDL sources", OPTIONS );
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
        _sourceNames.add( option.getArgument() );
      }
    }

    return true;
  }

  @Override
  int run( @Nonnull final Context context )
  {
    final Logger logger = context.environment().logger();
    final RepositoryConfig config = context.config();

    for ( final String sourceName : getSourceNames( config ) )
    {
      if ( logger.isLoggable( Level.FINE ) )
      {
        logger.log( Level.FINE, "Processing source named '" + sourceName + "'" );
      }
      final SourceConfig source = config.findSourceByName( sourceName );
      if ( null == source )
      {
        final String message =
          "Error: Attempting to process source with the name '" + sourceName + "' but no such source exists.";
        throw new TerminalStateException( message, ExitCodes.ERROR_SOURCE_DOES_NOT_EXIST_CODE );
      }
      if ( logger.isLoggable( Level.FINE ) )
      {
        logger.log( Level.FINE, "Fetched documentation for source named '" + sourceName + "'" );
      }
      final WebIDLSchema schema = loadSchema( context, source );

      for ( final InterfaceDefinition definition : schema.getInterfaces() )
      {
        final MdnDocScanner scanner =
          new MdnDocScanner( context.docRepository(), context.environment().docDirectory() );
        try
        {
          scanner.fetchDocumentation( DocKind.Type, definition.getName(), null, _force, !_noRemoveSource );
        }
        catch ( final SourceFetchException sfe )
        {
          final String message =
            "Error: Failed to fetch documentation for element named '" + sfe.getSource().getName() +
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

    }

    return ExitCodes.SUCCESS_EXIT_CODE;
  }

  @Nonnull
  private WebIDLSchema loadSchema( @Nonnull final Context context, @Nonnull final SourceConfig source )
  {
    final Path target = context.environment().getPathForSource( source );
    if ( !Files.exists( target ) )
    {
      final String message =
        "Error: IDL source with the name '" + source.getName() + "' has not been fetched. " +
        "The tool can not fetch documentation until the IDL has been fetched.";
      throw new TerminalStateException( message, ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE );
    }

    final Logger logger = context.environment().logger();
    try ( final FileReader reader = new FileReader( target.toFile() ) )
    {
      final CountingConsoleErrorListener errorListener = new CountingConsoleErrorListener( target.toString() );
      final WebIDLSchema schema =
        WebIDLModelParser.parse( target.toString(), Collections.emptySet(), reader, errorListener );

      final int errorCount = errorListener.getErrorCount();
      if ( 0 == errorCount )
      {
        if ( logger.isLoggable( Level.FINE ) )
        {
          logger.log( Level.FINE, "Source named '" + source.getName() + "' parsed without errors." );
        }
        return schema;
      }
      else
      {
        final String message =
          "Error: Attempting to parse source named '" + source.getName() + "' but there was " + errorCount +
          " errors detected in the WebIDL";
        throw new TerminalStateException( message, ExitCodes.ERROR_IDL_NOT_VALID_CODE );
      }
    }
    catch ( final IOException ioe )
    {
      final String message =
        "Error: Attempting to parse source named '" + source.getName() + "' but there was an error " +
        "reading the WebIDL for source. Error: " + ioe;
      throw new TerminalStateException( message, ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE );
    }
    catch ( final Throwable t )
    {
      final String message =
        "Error: Attempting to parse source with the name '" + source.getName() +
        "' but there was an unexpected error verifying source. Error: " + t;
      throw new TerminalStateException( message, ExitCodes.ERROR_SOURCE_NOT_FETCHED_CODE );
    }
  }

  @Nonnull
  private Set<String> getSourceNames( @Nonnull final RepositoryConfig config )
  {
    return _sourceNames.isEmpty() ?
           config.getSources()
             .stream()
             .map( SourceConfig::getName )
             .collect( Collectors.toCollection( LinkedHashSet::new ) ) :
           _sourceNames;
  }
}
