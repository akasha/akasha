package org.realityforge.webtack;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
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
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.MixinDefinition;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.WebIDLModelParser;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.mdn_scanner.MdnDocScanner;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocRepositoryConfig;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocSourceConfig;
import org.realityforge.webtack.model.tools.repository.config.RepositoryConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

final class AddDocsCommand
  extends ConfigurableCommand
{
  @Nonnull
  static final String COMMAND = "add-docs";
  private static final int IDL_SOURCE_NAME_OPT = 1;
  private static final int NO_FETCH_OPT = 2;
  private static final CLOptionDescriptor[] OPTIONS = new CLOptionDescriptor[]
    {
      new CLOptionDescriptor( "idl-source-name",
                              CLOptionDescriptor.ARGUMENT_REQUIRED | CLOptionDescriptor.DUPLICATES_ALLOWED,
                              IDL_SOURCE_NAME_OPT,
                              "Scan the idl source and add documentation for all types within the idl source." ),
      new CLOptionDescriptor( "no-fetch",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              NO_FETCH_OPT,
                              "Skip running fetch command after registering doc source." )
    };
  private boolean _noFetch;
  @Nonnull
  private final List<String> _names = new ArrayList<>();
  @Nonnull
  private final List<String> _idlSourceNames = new ArrayList<>();

  AddDocsCommand()
  {
    super( COMMAND, "Register a element or elements to retrieve documentation for", OPTIONS );
  }

  @Override
  boolean processArguments( @Nonnull final Environment environment, @Nonnull final List<CLOption> arguments )
  {
    for ( final CLOption option : arguments )
    {
      if ( CLOption.TEXT_ARGUMENT == option.getId() )
      {
        _names.add( option.getArgument() );
      }
      else if ( IDL_SOURCE_NAME_OPT == option.getId() )
      {
        _idlSourceNames.add( option.getArgument() );
      }
      else
      {
        assert NO_FETCH_OPT == option.getId();
        _noFetch = true;
      }
    }

    if ( _names.isEmpty() && _idlSourceNames.isEmpty() )
    {
      environment.logger().log( Level.SEVERE, "Error: No elements to document specified" );
      return false;
    }

    return true;
  }

  @Override
  int run( @Nonnull final Context context )
  {
    final Logger logger = context.environment().logger();
    final RepositoryConfig config = context.config();

    final List<SourceConfig> idlSources =
      _idlSourceNames.isEmpty() ?
      Collections.emptyList() :
      config
        .getSources()
        .stream()
        .filter( s -> _idlSourceNames.contains( s.getName() ) )
        .collect( Collectors.toList() );

    final List<SourceConfig> sourceConfigs = new ArrayList<>();
    for ( final String idlSourceName : _idlSourceNames )
    {
      final SourceConfig source = config.findSourceByName( idlSourceName );
      if ( null == source )
      {
        final String message =
          "Error: Idl source with name " + idlSourceName + " specified but no such source is registered.";
        logger.log( Level.SEVERE, message );
        return ExitCodes.ERROR_SOURCE_DOES_NOT_EXIST_CODE;
      }
      sourceConfigs.add( source );
    }

    final Set<String> typeNamesToAdd = new LinkedHashSet<>( _names );
    for ( final SourceConfig source : sourceConfigs )
    {
      final WebIDLSchema schema = loadSchema( context, logger, source );
      for ( final CallbackInterfaceDefinition definition : schema.getCallbackInterfaces() )
      {
        typeNamesToAdd.add( definition.getName() );
      }
      for ( final DictionaryDefinition definition : schema.getDictionaries() )
      {
        typeNamesToAdd.add( definition.getName() );
      }
      for ( final PartialDictionaryDefinition definition : schema.getPartialDictionaries() )
      {
        typeNamesToAdd.add( definition.getName() );
      }
      for ( final MixinDefinition definition : schema.getMixins() )
      {
        typeNamesToAdd.add( definition.getName() );
      }
      for ( final PartialMixinDefinition definition : schema.getPartialMixins() )
      {
        typeNamesToAdd.add( definition.getName() );
      }
      for ( final InterfaceDefinition definition : schema.getInterfaces() )
      {
        typeNamesToAdd.add( definition.getName() );
      }
      for ( final PartialInterfaceDefinition definition : schema.getPartialInterfaces() )
      {
        typeNamesToAdd.add( definition.getName() );
      }
    }

    final DocRepositoryConfig docRepository = context.docRepository();
    for ( final String typeName : typeNamesToAdd )
    {
      if ( logger.isLoggable( Level.INFO ) )
      {
        logger.log( Level.INFO, "Adding doc source named '" + typeName + "'" );
      }

      final DocSourceConfig source = new DocSourceConfig();
      source.setName( typeName );
      source.setLastModifiedAt( 0 );
      source.setUrl( MdnDocScanner.BASE_URL + typeName );

      docRepository.getSources().add( source );
    }

    try
    {
      DocRepositoryConfig.save( docRepository );
    }
    catch ( final Exception e )
    {
      logger.log( Level.SEVERE, "Error: Failed to save doc repository" );
      return ExitCodes.ERROR_SAVING_CONFIG_CODE;
    }
    if ( !_noFetch )
    {
      final FetchDocsCommand command = new FetchDocsCommand();
      command.processOptions( context.environment(), typeNamesToAdd.toArray( new String[ 0 ] ) );
      return command.run( context );
    }
    else
    {
      return ExitCodes.SUCCESS_EXIT_CODE;
    }
  }

  @Nonnull
  private WebIDLSchema loadSchema( @Nonnull final Context context,
                                   final Logger logger,
                                   final SourceConfig source )
  {
    final WebIDLSchema schema;
    final Path target = context.environment().getPathForSource( source );
    try ( final FileReader reader = new FileReader( target.toFile() ) )
    {
      final CountingConsoleErrorListener errorListener = new CountingConsoleErrorListener( target.toString() );
      schema = WebIDLModelParser.parse( target.toString(), Collections.emptySet(), reader, errorListener );

      final int errorCount = errorListener.getErrorCount();
      if ( 0 == errorCount )
      {
        if ( logger.isLoggable( Level.FINE ) )
        {
          logger.log( Level.FINE, "Source named '" + source.getName() + "' parsed without errors." );
        }
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
        "Error: Attempting to parse source with the name '" + source.getName() + "' but there was an error " +
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
    return schema;
  }
}
