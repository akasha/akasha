package org.realityforge.webtack.model.tools.pipeline;

import java.nio.file.Path;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class ExecutionContext
{
  @Nonnull
  private final Path _webidlDirectory;
  @Nonnull
  private final Path _docDirectory;
  @Nonnull
  private final ProgressListener _progressListener;

  public ExecutionContext( @Nonnull final Path webidlDirectory,
                           @Nonnull final Path docDirectory,
                           @Nonnull final ProgressListener progressListener )
  {
    _webidlDirectory = Objects.requireNonNull( webidlDirectory );
    _docDirectory = Objects.requireNonNull( docDirectory );
    _progressListener = Objects.requireNonNull( progressListener );
  }

  @Nonnull
  public Path getWebidlDirectory()
  {
    return _webidlDirectory;
  }

  @Nonnull
  public Path getDocDirectory()
  {
    return _docDirectory;
  }

  @Nonnull
  public ProgressListener getProgressListener()
  {
    return _progressListener;
  }
}
