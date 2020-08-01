package org.realityforge.webtack.model.tools.fetch;

import java.nio.file.Path;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class FetchResult
{
  @Nonnull
  private final Path _path;
  private final long _lastModifiedAt;

  FetchResult( @Nonnull final Path path, final long lastModifiedAt )
  {
    _path = Objects.requireNonNull( path );
    _lastModifiedAt = lastModifiedAt;
  }

  @Nonnull
  public Path getPath()
  {
    return _path;
  }

  public long getLastModifiedAt()
  {
    return _lastModifiedAt;
  }
}
