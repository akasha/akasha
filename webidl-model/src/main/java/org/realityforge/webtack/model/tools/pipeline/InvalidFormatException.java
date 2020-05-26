package org.realityforge.webtack.model.tools.pipeline;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.pipeline.config.PipelineConfig;
import org.realityforge.webtack.model.tools.repository.config.SourceConfig;

public final class InvalidFormatException
  extends SourceException
{
  @Nonnull
  private final List<ParseError> _errors;

  public InvalidFormatException( @Nonnull final PipelineConfig pipeline,
                                 @Nonnull final SourceConfig source,
                                 @Nonnull final List<ParseError> errors )
  {
    super( pipeline,source );
    _errors = Objects.requireNonNull( errors );
  }

  @Nonnull
  public List<ParseError> getErrors()
  {
    return _errors;
  }
}
