package org.realityforge.webtack.model.tools.pipeline;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

public abstract class SourceException
  extends PipelineException
{
  @Nonnull
  private final SourceConfig _source;

  public SourceException( @Nonnull final PipelineConfig pipeline, @Nonnull final SourceConfig source )
  {
    this( pipeline, source, null );
  }

  public SourceException( @Nonnull final PipelineConfig pipeline,
                          @Nonnull final SourceConfig source,
                          @Nullable final Throwable cause )
  {
    super( pipeline, cause );
    _source = Objects.requireNonNull( source );
  }

  @Nonnull
  public final SourceConfig getSource()
  {
    return _source;
  }
}
