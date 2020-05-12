package org.realityforge.webtack.model.tools.merger;

import javax.annotation.Nonnull;

public interface SchemaJoinerFactory
{
  @Nonnull
  SchemaJoiner create();
}
