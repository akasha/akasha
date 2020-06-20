package org.realityforge.webtack.model.tools.spi;

import javax.annotation.Nonnull;

public interface CombinerFactory
{
  @Nonnull
  Combiner create();
}
