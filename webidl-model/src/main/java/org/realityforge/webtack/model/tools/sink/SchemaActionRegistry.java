package org.realityforge.webtack.model.tools.sink;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import javax.annotation.Nonnull;
import javax.json.JsonObject;
import javax.json.bind.JsonbBuilder;
import org.realityforge.webtack.model.tools.Name;

public final class SchemaActionRegistry
{
  @Nonnull
  private static final Map<String, Class<? extends SchemaActionFactory>> ACTIONS = new HashMap<>();

  static
  {
    loadTypes();
  }

  private SchemaActionRegistry()
  {
  }

  public static boolean isSchemaActionFactoryPresent( @Nonnull final String name )
  {
    return ACTIONS.containsKey( name );
  }

  @Nonnull
  public static SchemaAction createSchemaAction( @Nonnull final String name, @Nonnull final JsonObject config )
  {
    final Class<? extends SchemaActionFactory> type = ACTIONS.get( name );
    if ( null == type )
    {
      throw new IllegalArgumentException( "Unable to locate schema action factory with name '" + name + "'" );
    }
    return JsonbBuilder.create().fromJson( config.toString(), type ).create();
  }

  private static void loadTypes()
  {
    for ( final SchemaActionFactory factory : ServiceLoader.load( SchemaActionFactory.class ) )
    {
      final Class<? extends SchemaActionFactory> type = factory.getClass();
      final Name annotation = type.getAnnotation( Name.class );
      final String name = null == annotation ? type.getSimpleName() : annotation.value();
      ACTIONS.put( name, type );
    }
  }
}
