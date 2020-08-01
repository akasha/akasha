package org.realityforge.webtack.model.tools.fetch;

import java.nio.file.Path;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class FetchResult
{
  @Nonnull
  private final Path _path;
  private final long _lastModifiedTime;

  FetchResult( @Nonnull final Path path, final long lastModifiedTime )
  {
    _path = Objects.requireNonNull( path );
    _lastModifiedTime = lastModifiedTime;
  }

  @Nonnull
  public Path getPath()
  {
    return _path;
  }

  public long getLastModifiedTime()
  {
    return _lastModifiedTime;
  }
}
