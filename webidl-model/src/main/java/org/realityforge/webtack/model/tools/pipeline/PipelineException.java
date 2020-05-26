package org.realityforge.webtack.model.tools.pipeline;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;

public abstract class PipelineException
  extends Exception
{
  @Nonnull
  private final PipelineConfig _pipeline;

  public PipelineException( @Nonnull final PipelineConfig pipeline )
  {
    _pipeline = Objects.requireNonNull( pipeline );
  }

  public PipelineException( @Nonnull final PipelineConfig pipeline, @Nullable final String message )
  {
    super( message );
    _pipeline = Objects.requireNonNull( pipeline );
  }

  public PipelineException( @Nonnull final PipelineConfig pipeline, final String message, final Throwable cause )
  {
    super( message, cause );
    _pipeline = Objects.requireNonNull( pipeline );
  }

  public PipelineException( @Nonnull final PipelineConfig pipeline, final Throwable cause )
  {
    super( cause );
    _pipeline = Objects.requireNonNull( pipeline );
  }

  @Nonnull
  public final PipelineConfig getPipeline()
  {
    return _pipeline;
  }
}
