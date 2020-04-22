package org.realityforge.webtack;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.webtack.config.RepositoryConfig;
import org.realityforge.webtack.config.SourceConfig;

final class FetchCommand
  extends ConfigurableCommand
{
  @Nonnull
  static final String COMMAND = "fetch";
  // This was yoinked from https://github.com/microsoft/TSJS-lib-generator/blob/b19840bed0543fadb5361d5071a172d568f00272/src/idlfetcher.ts#L16-L21
  @Nonnull
  private static final String CSS_SELECTOR =
    // bikeshed and ReSpec
    "pre.idl:not(.extract):not(.example)," +
    // Web Cryptography
    "pre.code code.idl-code," +
    // HTML
    "pre:not(.extract) code.idl," +
    // Permissions
    "#permission-registry + pre.highlight";
  private static final int CONNECT_TIMEOUT = 15_000;
  private static final int READ_TIMEOUT = 10_000;
  private static final int FORCE_OPT = 'f';
  private static final int NO_VERIFY_OPT = 2;
  private static final CLOptionDescriptor[] OPTIONS = new CLOptionDescriptor[]
    {
      new CLOptionDescriptor( "force",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              FORCE_OPT,
                              "Force the downloading of the source even if the last modified at time indicates it is up to date." ),
      new CLOptionDescriptor( "no-verify",
                              CLOptionDescriptor.ARGUMENT_DISALLOWED,
                              NO_VERIFY_OPT,
                              "Skip running verify command after fetching WebIDL source." )
    };
  @Nonnull
  private final Set<String> _sourceNames = new LinkedHashSet<>();
  private boolean _force;
  private boolean _noVerify;

  FetchCommand()
  {
    super( COMMAND, "Download the WebIDL source from one or more sources", OPTIONS );
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
      else if ( NO_VERIFY_OPT == optionId )
      {
        _noVerify = true;
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
        logger.log( Level.FINE, "Fetching source named '" + sourceName + "'" );
      }
      final SourceConfig source = config.findSourceByName( sourceName );
      if ( null == source )
      {
        final String message =
          "Error: Attempting to fetch source with the name '" + sourceName + "' but no such source exists.";
        logger.log( Level.SEVERE, message );
        return ExitCodes.ERROR_SOURCE_DOES_NOT_EXIST_CODE;
      }
      final String url = source.getUrl();
      final DownloadResult result = downloadURL( url, source.getLastModifiedTime() );
      if ( null == result )
      {
        if ( logger.isLoggable( Level.INFO ) )
        {
          logger.log( Level.INFO, "Source named '" + sourceName + "' up to date, no need to fetch" );
        }
      }
      else
      {
        final Path file = result.getPath();
        source.setLastModifiedTime( result.getLastModifiedTime() );
        if ( logger.isLoggable( Level.INFO ) )
        {
          logger.log( Level.INFO, "Fetched source named '" + sourceName + "' to " + file );
        }
        final Path target = context.environment().getPathForSource( source );

        if ( !Files.exists( target.getParent() ) )
        {
          try
          {
            Files.createDirectories( target.getParent() );
          }
          catch ( final IOException ioe )
          {
            final String message =
              "Error: Failed to create directory to contain IDL for the source with the name '" +
              sourceName + "' due to " + ioe;
            logger.log( Level.SEVERE, message );
            return ExitCodes.ERROR_EXTRACT_IDL_FAILED_CODE;
          }
        }

        if ( !extractWebIDL( logger, sourceName, url, file, target ) )
        {
          return ExitCodes.ERROR_EXTRACT_IDL_FAILED_CODE;
        }
        try
        {
          RepositoryConfig.save( config.getConfigLocation(), config );
        }
        catch ( final Exception e )
        {
          final String message =
            "Error: Failed to update config file after fetching IDL for the source with the name '" +
            sourceName + "' due to " + e;
          logger.log( Level.SEVERE, message );
          return ExitCodes.ERROR_SAVING_CONFIG_CODE;
        }
      }
    }
    if ( !_noVerify )
    {
      final VerifyCommand command = new VerifyCommand();
      command.processOptions( context.environment(), sourceNames.toArray( new String[ 0 ] ) );
      return command.run( context );
    }
    else
    {
      return ExitCodes.SUCCESS_EXIT_CODE;
    }
  }

  @Nonnull
  private Set<String> getSourceNames( final RepositoryConfig config )
  {
    return _sourceNames.isEmpty() ?
           config.getSources()
             .stream()
             .map( SourceConfig::getName )
             .collect( Collectors.toCollection( LinkedHashSet::new ) ) :
           _sourceNames;
  }

  private boolean extractWebIDL( @Nonnull final Logger logger,
                                 @Nonnull final String sourceName,
                                 @Nonnull final String url,
                                 @Nonnull final Path input,
                                 @Nonnull final Path output )
  {
    try
    {
      if ( url.endsWith( ".idl" ) )
      {
        if ( logger.isLoggable( Level.INFO ) )
        {
          logger.log( Level.INFO, "Source named '" + sourceName + "' is already an IDL file. No processing required." );
        }
        Files.copy( input, output, StandardCopyOption.REPLACE_EXISTING );
      }
      else
      {
        if ( logger.isLoggable( Level.FINE ) )
        {
          logger.log( Level.FINE, "Source named '" + sourceName + "' needs to have IDL extracted." );
        }
        // Cache a copy of downloaded html from which WebIDL was extracted
        Files.copy( input, output.getParent().resolve( sourceName + ".html" ), StandardCopyOption.REPLACE_EXISTING );

        final Document document = Jsoup.parse( input.toFile(), StandardCharsets.UTF_8.name(), url );
        final Elements elements = document.select( CSS_SELECTOR );

        // Some spec docs (gamepad, push_api, screen_orientation, selection_api) include an anchor in block so strip it out
        elements.forEach( e -> e.getElementsByClass( "idlHeader" ).forEach( Node::remove ) );

        final String idl = elements
          .stream()
          // Not part of an example block
          .filter( e -> !( e.hasParent() && e.parent().classNames().contains( "example" ) ) )

          // Not part of the index
          .filter( e -> null == e.previousElementSibling() ||
                        (
                          !e.previousElementSibling().classNames().contains( "atrisk" ) &&
                          !e.previousElementSibling().text().contains( "IDL Index" )
                        ) )
          .map( Element::text )
          .collect( Collectors.joining( "\n\n" ) );
        Files.write( output,
                     idl.getBytes( StandardCharsets.UTF_8 ),
                     StandardOpenOption.CREATE,
                     StandardOpenOption.TRUNCATE_EXISTING );
      }
      if ( logger.isLoggable( Level.INFO ) )
      {
        logger.log( Level.INFO, "Source named '" + sourceName + "' processed and WebIDL extracted to file " + output );
      }

      return true;
    }
    catch ( final IOException ioe )
    {
      final String message =
        "Error: Failed to extract WebIDL from source named '" + sourceName + "' downloaded to file " +
        input + " due to " + ioe;
      throw new TerminalStateException( message, ExitCodes.ERROR_EXTRACT_IDL_FAILED_CODE );
    }
  }

  @Nullable
  private DownloadResult downloadURL( @Nonnull final String url, final long lastModifiedAt )
  {
    try
    {
      final URL sourceURL = URI.create( url ).toURL();

      if ( !_force &&
           0 != lastModifiedAt &&
           ( "http".equals( sourceURL.getProtocol() ) || "https".equals( sourceURL.getProtocol() ) ) )
      {
        final HttpURLConnection connection = (HttpURLConnection) newUrlConnection( sourceURL );
        connection.setIfModifiedSince( lastModifiedAt );
        connection.setRequestMethod( "HEAD" );

        if ( HttpURLConnection.HTTP_NOT_MODIFIED == connection.getResponseCode() )
        {
          return null;
        }
      }

      final URLConnection connection = newUrlConnection( sourceURL );
      try ( final InputStream inputStream = new BufferedInputStream( connection.getInputStream() ) )
      {
        final long lastModified = connection.getLastModified();
        final Path file = Files.createTempFile( "webtack", ".html" );
        try ( final OutputStream outputStream = new BufferedOutputStream( new FileOutputStream( file.toFile() ) ) )
        {
          final byte[] buffer = new byte[ 1024 * 4 ];
          int count;
          while ( -1 != ( count = inputStream.read( buffer ) ) )
          {
            outputStream.write( buffer, 0, count );
          }
        }
        return new DownloadResult( file, lastModified );
      }
    }
    catch ( final IOException ioe )
    {
      throw new TerminalStateException( "Failed during fetch of source at " + url,
                                        ioe,
                                        ExitCodes.ERROR_SOURCE_FETCH_FAILED_CODE );
    }
  }

  private URLConnection newUrlConnection( final URL sourceURL )
    throws IOException
  {
    final URLConnection connection = sourceURL.openConnection();
    connection.setConnectTimeout( CONNECT_TIMEOUT );
    connection.setReadTimeout( READ_TIMEOUT );
    return connection;
  }
}
