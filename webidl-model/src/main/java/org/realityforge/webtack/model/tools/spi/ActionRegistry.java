package org.realityforge.webtack.model.tools.spi;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import javax.annotation.Nonnull;
import javax.json.JsonObject;
import javax.json.bind.JsonbBuilder;
import org.realityforge.webtack.model.tools.Name;

public final class ActionRegistry
{
  @Nonnull
  private static final Map<String, Class<? extends ActionFactory>> ACTIONS = new HashMap<>();

  static
  {
    loadTypes();
  }

  private ActionRegistry()
  {
  }

  public static boolean isActionPresent( @Nonnull final String name )
  {
    return ACTIONS.containsKey( name );
  }

  @Nonnull
  public static Action createAction( @Nonnull final String name, @Nonnull final JsonObject config )
  {
    final Class<? extends ActionFactory> type = ACTIONS.get( name );
    if ( null == type )
    {
      throw new IllegalArgumentException( "Unable to locate schema action factory with name '" + name + "'" );
    }
    return JsonbBuilder.create().fromJson( config.toString(), type ).create();
  }

  private static void loadTypes()
  {
    for ( final ActionFactory factory : ServiceLoader.load( ActionFactory.class ) )
    {
      final Class<? extends ActionFactory> type = factory.getClass();
      final Name annotation = type.getAnnotation( Name.class );
      final String name = null == annotation ? type.getSimpleName() : annotation.value();
      ACTIONS.put( name, type );
    }
  }
}
