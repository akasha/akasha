package org.realityforge.webtack.model.tools.spi;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import javax.annotation.Nonnull;
import javax.json.JsonObject;
import javax.json.bind.JsonbBuilder;
import org.realityforge.webtack.model.tools.Name;

public final class Registry
{
  @Nonnull
  private static final Map<String, Class<? extends ActionFactory>> ACTIONS = new HashMap<>();
  @Nonnull
  private static final Map<String, Class<? extends CombinerFactory>> COMBINERS = new HashMap<>();
  @Nonnull
  private static final Map<String, Class<? extends ProcessorFactory>> PROCESSORS = new HashMap<>();

  static
  {
    loadTypes();
  }

  private Registry()
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
      throw new IllegalArgumentException( "Unable to locate action with name '" + name + "'" );
    }
    return JsonbBuilder.create().fromJson( config.toString(), type ).create();
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

  public static boolean isProcessorPresent( @Nonnull final String name )
  {
    return PROCESSORS.containsKey( name );
  }

  @Nonnull
  public static Processor createProcessor( @Nonnull final String name, @Nonnull final JsonObject config )
  {
    final Class<? extends ProcessorFactory> type = PROCESSORS.get( name );
    if ( null == type )
    {
      throw new IllegalArgumentException( "Unable to locate processor with name '" + name + "'" );
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
    for ( final CombinerFactory factory : ServiceLoader.load( CombinerFactory.class ) )
    {
      final Class<? extends CombinerFactory> type = factory.getClass();
      final Name annotation = type.getAnnotation( Name.class );
      final String name = null == annotation ? type.getSimpleName() : annotation.value();
      COMBINERS.put( name, type );
    }
    for ( final ProcessorFactory factory : ServiceLoader.load( ProcessorFactory.class ) )
    {
      final Class<? extends ProcessorFactory> type = factory.getClass();
      final Name annotation = type.getAnnotation( Name.class );
      final String name = null == annotation ? type.getSimpleName() : annotation.value();
      PROCESSORS.put( name, type );
    }
  }
}
