package org.realityforge.webtack.model.tools.repository.config;

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

public final class RepositoryConfig
{
  @Nonnull
  public static final String FILENAME = "sources.json";
  @Nonnull
  private final Path _configLocation;
  @Nonnull
  private final List<SourceConfig> _sources;

  RepositoryConfig( @Nonnull final Path configLocation, @Nonnull final List<SourceConfig> sources )
  {
    _configLocation = Objects.requireNonNull( configLocation );
    _sources = Objects.requireNonNull( sources );
  }

  @Nonnull
  public static RepositoryConfig load( @Nonnull final Path path )
    throws Exception
  {
    try ( final InputStream inputStream = new FileInputStream( path.toFile() ) )
    {
      final List<SourceConfig> sources = JsonbBuilder.create().fromJson( inputStream, new ArrayList<SourceConfig>()
      {
      }.getClass().getGenericSuperclass() );
      for ( final SourceConfig source : sources )
      {
        if ( null == source.getName() )
        {
          throw new IllegalConfigException( "Repository contains a source missing the name value" );
        }
      }
      return new RepositoryConfig( path, sources );
    }
  }

  public static void save( @Nonnull final RepositoryConfig config )
    throws Exception
  {
    final Path path = config.getConfigLocation();
    final JsonbConfig jsonbConfig = new JsonbConfig().withFormatting( true );
    Files.createDirectories( path.getParent() );
    try ( final Jsonb jsonb = JsonbBuilder.create( jsonbConfig );
          final FileOutputStream outputStream = new FileOutputStream( path.toFile() ) )
    {
      jsonb.toJson( config.getSources()
                      .stream()
                      .sorted( Comparator.comparing( SourceConfig::getName ) )
                      .collect( Collectors.toList() ),
                    outputStream );
    }
    // Add newline as json output omits trailing new line
    Files.write( path, new byte[]{ '\n' }, StandardOpenOption.APPEND );
  }

  @Nonnull
  public Path getConfigLocation()
  {
    return _configLocation;
  }

  @Nonnull
  public List<SourceConfig> getSources()
  {
    return _sources;
  }

  @Nullable
  public SourceConfig findSourceByName( @Nonnull final String sourceName )
  {
    return getSources().stream().filter( s -> Objects.equals( s.getName(), sourceName ) ).findAny().orElse( null );
  }
}
