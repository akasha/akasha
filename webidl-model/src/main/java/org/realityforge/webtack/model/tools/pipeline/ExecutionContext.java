package org.realityforge.webtack.model.tools.pipeline;

import java.nio.file.Path;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class ExecutionContext
{
  @Nonnull
  private final Path _webidlDirectory;
  @Nonnull
  private final ProgressListener _progressListener;

  public ExecutionContext( @Nonnull final Path webidlDirectory,
                           @Nonnull final ProgressListener progressListener )
  {
    _webidlDirectory = Objects.requireNonNull( webidlDirectory );
    _progressListener = Objects.requireNonNull( progressListener );
  }

  @Nonnull
  public Path getWebidlDirectory()
  {
    return _webidlDirectory;
  }

  @Nonnull
  public ProgressListener getProgressListener()
  {
    return _progressListener;
  }
}
