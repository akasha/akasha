package org.realityforge.webtack.model.tools.sink;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.json.JsonObject;
import javax.json.bind.JsonbBuilder;

public final class SchemaActionRegistry
{
  @Nonnull
  private static final Map<String, Class<? extends SchemaActionFactory>> FACTORY_MAP =
    new HashMap<String, Class<? extends SchemaActionFactory>>()
    {
      {
        put( EmitAction.NAME, EmitAction.Config.class );
      }
    };

  private SchemaActionRegistry()
  {
  }

  public static boolean isSchemaActionFactoryPresent( @Nonnull final String name )
  {
    return FACTORY_MAP.containsKey( name );
  }

  @Nonnull
  public static SchemaAction createSchemaAction( @Nonnull final String name, @Nonnull final JsonObject config )
  {
    final Class<? extends SchemaActionFactory> type = FACTORY_MAP.get( name );
    if ( null == type )
    {
      throw new IllegalArgumentException( "Unable to locate schema action factory with name '" + name + "'" );
    }
    return JsonbBuilder.create().fromJson( config.toString(), type ).create();
  }
}
