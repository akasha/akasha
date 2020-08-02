package org.realityforge.webtack.model.tools.mdn_scanner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.repository.config.DocRepositoryConfig;
import org.realityforge.webtack.model.tools.repository.config.DocSourceConfig;

public final class DocRepositoryRuntime
{
  @Nonnull
  private final DocRepositoryConfig _repository;
  @Nonnull
  private final Path _dataDirectory;

  public DocRepositoryRuntime( @Nonnull final DocRepositoryConfig repository, @Nonnull final Path dataDirectory )
  {
    _repository = Objects.requireNonNull( repository );
    _dataDirectory = Objects.requireNonNull( dataDirectory );
  }

  @Nonnull
   DocRepositoryConfig getRepository()
  {
    return _repository;
  }

  @Nullable
  public DocEntry getDocEntry( @Nonnull final String name )
  {
    final DocSourceConfig config = _repository.findSourceByName( name );
    return null == config ? null : getDocEntry( config );
  }

  @Nullable
  private DocEntry getDocEntry( @Nonnull final DocSourceConfig config )
  {
    final Path path = getDataFileLocation( config );
    try
    {
      return Files.exists( path ) ? DocEntry.load( path ) : null;
    }
    catch ( final Exception e )
    {
      //TODO: Log error message here
      return null;
    }
  }

  @Nonnull
  public Path getDataFileLocation( @Nonnull final DocSourceConfig config )
  {
    return _dataDirectory.resolve( config.getName() + ".json" );
  }
}
