package org.realityforge.webtack.model.tools.transform;

import javax.annotation.Nonnull;

public interface SchemaProcessorFactory
{
  @Nonnull
  SchemaProcessor create();
}
