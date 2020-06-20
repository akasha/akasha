package org.realityforge.webtack.model.tools.merger;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import javax.annotation.Nonnull;
import javax.json.JsonObject;
import javax.json.bind.JsonbBuilder;
import org.realityforge.webtack.model.tools.Name;

public final class SchemaJoinerRegistry
{
  @Nonnull
  private static final Map<String, Class<? extends SchemaJoinerFactory>> FACTORY_MAP = new HashMap<>();

  static
  {
    loadTypes();
  }

  private SchemaJoinerRegistry()
  {
  }

  public static boolean isSchemaJoinerFactoryPresent( @Nonnull final String name )
  {
    return FACTORY_MAP.containsKey( name );
  }

  @Nonnull
  public static SchemaJoiner createSchemaJoiner( @Nonnull final String name, @Nonnull final JsonObject config )
  {
    final Class<? extends SchemaJoinerFactory> type = FACTORY_MAP.get( name );
    if ( null == type )
    {
      throw new IllegalArgumentException( "Unable to locate schema joiner factory with name '" + name + "'" );
    }
    return JsonbBuilder.create().fromJson( config.toString(), type ).create();
  }

  private static void loadTypes()
  {
    for ( final SchemaJoinerFactory factory : ServiceLoader.load( SchemaJoinerFactory.class ) )
    {
      final Class<? extends SchemaJoinerFactory> type = factory.getClass();
      final Name annotation = type.getAnnotation( Name.class );
      final String name = null == annotation ? type.getSimpleName() : annotation.value();
      FACTORY_MAP.put( name, type );
    }
  }
}
