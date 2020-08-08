package org.realityforge.webtack.model.tools.mdn_scanner.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import org.realityforge.webtack.model.tools.mdn_scanner.RepositorySaveException;
import org.realityforge.webtack.model.tools.repository.config.IllegalConfigException;

public final class DocRepositoryConfig
{
  @Nonnull
  public static final String FILENAME = "doc_sources.json";
  @Nonnull
  private final Path _configLocation;
  @Nonnull
  private final List<DocSourceConfig> _sources;

  DocRepositoryConfig( @Nonnull final Path configLocation, @Nonnull final List<DocSourceConfig> sources )
  {
    _configLocation = Objects.requireNonNull( configLocation );
    _sources = Objects.requireNonNull( sources );
  }

  public void save()
    throws RepositorySaveException
  {
    DocRepositoryConfig.save( this );
  }

  /**
   * Find or create a DocSourceConfig for specified name.
   *
   * @param name       the name of the DocSourceConfig.
   * @param defaultUrl the url to use if need to create the DocSourceConfig.
   * @return a DocSourceConfig that was either looked up or created.
   * @throws RepositorySaveException if there was an error saving the repository after the config was created.
   */
  @Nonnull
  public DocSourceConfig findOrCreateDocSourceConfig( @Nonnull final String name, @Nullable final String defaultUrl )
    throws RepositorySaveException
  {
    DocSourceConfig source = findSourceByName( name );
    if ( null == source )
    {
      source = new DocSourceConfig();
      source.setName( name );
      source.setLastModifiedAt( 0 );
      source.setUrl( defaultUrl );
      _sources.add( source );
      save();
    }
    return source;
  }

  @Nonnull
  public static DocRepositoryConfig create( @Nonnull final Path path )
  {
    return new DocRepositoryConfig( path, new ArrayList<>() );
  }

  @Nonnull
  public static DocRepositoryConfig load( @Nonnull final Path path )
    throws Exception
  {
    try ( final InputStream inputStream = new FileInputStream( path.toFile() ) )
    {
      final List<DocSourceConfig> sources =
        JsonbBuilder.create().fromJson( inputStream, new ArrayList<DocSourceConfig>()
        {
        }.getClass().getGenericSuperclass() );
      for ( final DocSourceConfig source : sources )
      {
        if ( null == source.getName() )
        {
          throw new IllegalConfigException( "DocRepository contains a source missing the name value" );
        }
      }
      return new DocRepositoryConfig( path, sources );
    }
  }

  public static void save( @Nonnull final DocRepositoryConfig config )
    throws RepositorySaveException
  {
    try
    {
      final Path path = config.getConfigLocation();
      Files.createDirectories( path.getParent() );
      final JsonbConfig jsonbConfig = new JsonbConfig().withFormatting( true );
      final Jsonb jsonb = JsonbBuilder.create( jsonbConfig );
      try ( final FileOutputStream outputStream = new FileOutputStream( path.toFile() ) )
      {
        jsonb.toJson( config.getSources()
                        .stream()
                        .sorted( Comparator.comparing( DocSourceConfig::getName ) )
                        .collect( Collectors.toList() ),
                      outputStream );
      }
      jsonb.close();
      // Add newline as json output omits trailing new line
      Files.write( path, new byte[]{ '\n' }, StandardOpenOption.APPEND );
    }
    catch ( final Exception e )
    {
      throw new RepositorySaveException( config, e );
    }
  }

  @Nonnull
  public Path getConfigLocation()
  {
    return _configLocation;
  }

  @Nonnull
  public List<DocSourceConfig> getSources()
  {
    return _sources;
  }

  @Nullable
  public DocSourceConfig findSourceByName( @Nonnull final String sourceName )
  {
    return getSources().stream().filter( s -> Objects.equals( s.getName(), sourceName ) ).findAny().orElse( null );
  }
}
