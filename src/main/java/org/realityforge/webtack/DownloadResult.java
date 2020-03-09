package org.realityforge.webtack;

import java.nio.file.Path;
import java.util.Objects;
import javax.annotation.Nonnull;

final class DownloadResult
{
  @Nonnull
  private final Path _path;
  private final long _lastModifiedTime;

  DownloadResult( @Nonnull final Path path, final long lastModifiedTime )
  {
    _path = Objects.requireNonNull( path );
    _lastModifiedTime = lastModifiedTime;
  }

  @Nonnull
  Path getPath()
  {
    return _path;
  }

  long getLastModifiedTime()
  {
    return _lastModifiedTime;
  }
}
