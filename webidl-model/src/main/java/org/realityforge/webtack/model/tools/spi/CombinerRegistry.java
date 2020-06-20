package org.realityforge.webtack.model.tools.spi;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import javax.annotation.Nonnull;
import javax.json.JsonObject;
import javax.json.bind.JsonbBuilder;
import org.realityforge.webtack.model.tools.Name;

public final class CombinerRegistry
{
  @Nonnull
  private static final Map<String, Class<? extends CombinerFactory>> COMBINERS = new HashMap<>();

  static
  {
    loadTypes();
  }

  private CombinerRegistry()
  {
  }

  public static boolean isCombinerPresent( @Nonnull final String name )
  {
    return COMBINERS.containsKey( name );
  }

  @Nonnull
  public static Combiner createCombiner( @Nonnull final String name, @Nonnull final JsonObject config )
  {
    final Class<? extends CombinerFactory> type = COMBINERS.get( name );
    if ( null == type )
    {
      throw new IllegalArgumentException( "Unable to locate combiner with name '" + name + "'" );
    }
    return JsonbBuilder.create().fromJson( config.toString(), type ).create();
  }

  private static void loadTypes()
  {
    for ( final CombinerFactory factory : ServiceLoader.load( CombinerFactory.class ) )
    {
      final Class<? extends CombinerFactory> type = factory.getClass();
      final Name annotation = type.getAnnotation( Name.class );
      final String name = null == annotation ? type.getSimpleName() : annotation.value();
      COMBINERS.put( name, type );
    }
  }
}
