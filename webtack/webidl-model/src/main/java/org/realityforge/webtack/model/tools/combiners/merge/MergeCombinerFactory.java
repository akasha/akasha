package org.realityforge.webtack.model.tools.combiners.merge;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.spi.Combiner;
import org.realityforge.webtack.model.tools.spi.CombinerFactory;
import org.realityforge.webtack.model.tools.spi.Name;
import org.realityforge.webtack.model.tools.spi.PipelineContext;

@Name( "Merge" )
public final class MergeCombinerFactory
  implements CombinerFactory
{
  @Nonnull
  @Override
  public Combiner create( @Nonnull final PipelineContext context )
  {
    return new MergeCombiner();
  }
}
