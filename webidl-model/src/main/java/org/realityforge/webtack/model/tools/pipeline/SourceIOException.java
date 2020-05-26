package org.realityforge.webtack.model.tools.pipeline;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

public final class SourceIOException
  extends PipelineException
{
  @Nonnull
  private final SourceConfig _source;

  public SourceIOException( @Nonnull final PipelineConfig pipeline,
                            @Nonnull final SourceConfig source,
                            @Nonnull final IOException ioe )
  {
    super( pipeline, Objects.requireNonNull( ioe ) );
    _source = Objects.requireNonNull( source );
  }

  @Nonnull
  public SourceConfig getSource()
  {
    return _source;
  }

  @Override
  public IOException getCause()
  {
    return (IOException) super.getCause();
  }
}
