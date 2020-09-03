package org.realityforge.webtack.model.tools;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

public final class PipelineContextImpl
  implements PipelineContext
{
  @Nonnull
  private final DocRepositoryRuntime _docRepository;

  public PipelineContextImpl( @Nonnull final DocRepositoryRuntime docRepository )
  {
    _docRepository = Objects.requireNonNull( docRepository );
  }

  @Nonnull
  @Override
  public DocRepositoryRuntime docRepository()
  {
    return _docRepository;
  }
}
