package org.realityforge.webtack.model.tools.merger;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.Name;

@Name( "Merge" )
public final class MergerSchemaJoinerFactory
  implements SchemaJoinerFactory
{
  @Nonnull
  @Override
  public SchemaJoiner create()
  {
    return new MergerTool();
  }
}
