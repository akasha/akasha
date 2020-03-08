package org.realityforge.webtack.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;

public class RepositoryConfig
{
  @Nonnull
  public static final String FILENAME = "sources.json";
  @Nullable
  private Path _configLocation;
  @Nullable
  private List<SourceConfig> _sources;

  @Nonnull
  public static RepositoryConfig load( @Nonnull final Path path )
    throws Exception
  {
    final RepositoryConfig config = new RepositoryConfig();
    config.setConfigLocation( path );
    final Jsonb jsonb = JsonbBuilder.create();
    try ( final FileInputStream inputStream = new FileInputStream( path.toFile() ) )
    {
      final List<SourceConfig> sources = jsonb.fromJson( inputStream, new ArrayList<SourceConfig>()
      {
      }.getClass().getGenericSuperclass() );
      config.setSources( sources );
    }
    return config;
  }

  public static void save( @Nonnull final Path path, @Nonnull final RepositoryConfig config )
    throws Exception
  {
    final JsonbConfig jsonbConfig = new JsonbConfig().withFormatting( true );
    final Jsonb jsonb = JsonbBuilder.create( jsonbConfig );
    Files.createDirectories( path.getParent() );
    try ( final FileOutputStream outputStream = new FileOutputStream( path.toFile() ) )
    {
      jsonb.toJson( config.getSources(), outputStream );
    }
  }

  private void setConfigLocation( @Nonnull final Path configLocation )
  {
    _configLocation = Objects.requireNonNull( configLocation );
  }

  @Nonnull
  public Path getConfigLocation()
  {
    assert null != _configLocation;
    return _configLocation;
  }

  @Nonnull
  public List<SourceConfig> getSources()
  {
    assert null != _sources;
    return _sources;
  }

  private void setSources( @Nonnull final List<SourceConfig> sources )
  {
    _sources = Objects.requireNonNull( sources );
  }
}
