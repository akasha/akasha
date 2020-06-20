package org.realityforge.webtack.model.tools.combiners.merge;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.spi.Combiner;
import org.realityforge.webtack.model.tools.spi.CombinerFactory;
import org.realityforge.webtack.model.tools.spi.Name;

@Name( "Merge" )
public final class MergeCombinerFactory
  implements CombinerFactory
{
  @Nonnull
  @Override
  public Combiner create()
  {
    return new MergeCombiner();
  }
}
