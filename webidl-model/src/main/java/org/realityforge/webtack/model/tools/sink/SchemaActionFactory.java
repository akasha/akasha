package org.realityforge.webtack.model.tools.sink;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.transform.SchemaProcessor;

public interface SchemaActionFactory
{
  @Nonnull
  SchemaAction create();
}
