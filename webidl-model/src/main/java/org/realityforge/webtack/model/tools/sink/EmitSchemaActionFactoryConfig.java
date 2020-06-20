package org.realityforge.webtack.model.tools.sink;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.Name;

@Name( EmitAction.NAME )
public final class EmitSchemaActionFactoryConfig
  implements SchemaActionFactory
{
  public String filePattern;

  @Nonnull
  @Override
  public SchemaAction create()
  {
    if ( null == filePattern )
    {
      throw new IllegalArgumentException( "EmitAction missing required filePattern configuration value" );
    }
    return new EmitAction( filePattern );
  }
}
