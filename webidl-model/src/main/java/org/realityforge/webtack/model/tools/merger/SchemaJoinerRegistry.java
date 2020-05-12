package org.realityforge.webtack.model.tools.merger;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.json.JsonObject;
import javax.json.bind.JsonbBuilder;

public final class SchemaJoinerRegistry
{
  @Nonnull
  private static final Map<String, Class<? extends SchemaJoinerFactory>> FACTORY_MAP =
    new HashMap<String, Class<? extends SchemaJoinerFactory>>()
    {
      {
        put( "Merge", MergerTool.Config.class );
      }
    };

  private SchemaJoinerRegistry()
  {
  }

  public static boolean isSchemaJoinerFactoryPresent( @Nonnull final String name )
  {
    return FACTORY_MAP.containsKey( name );
  }

  @Nonnull
  public static SchemaJoiner createSchemaProcessor( @Nonnull final String name, @Nonnull final JsonObject config )
  {
    final Class<? extends SchemaJoinerFactory> type = FACTORY_MAP.get( name );
    if ( null == type )
    {
      throw new IllegalArgumentException( "Unable to locate schema joiner factory with name '" + name + "'" );
    }
    return JsonbBuilder.create().fromJson( config.toString(), type ).create();
  }
}
