package org.realityforge.webtack.model.tools.transform;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.json.JsonObject;
import javax.json.bind.JsonbBuilder;

public final class SchemaProcessorRegistry
{
  @Nonnull
  private static final Map<String, Class<? extends SchemaProcessorFactory>> FACTORY_MAP =
    new HashMap<String, Class<? extends SchemaProcessorFactory>>()
    {
      {
        put( ExtractExposureSetProcessor.NAME, ExtractExposureSetProcessor.Config.class );
        put( RemoveIncludesProcessor.NAME, RemoveIncludesProcessor.Config.class );
        put( FlattenProcessor.NAME, FlattenProcessor.Config.class );
        put( ValidatorProcessor.NAME, ValidatorProcessor.Config.class );
      }
    };

  private SchemaProcessorRegistry()
  {
  }

  public static boolean isSchemaProcessorFactoryPresent( @Nonnull final String name )
  {
    return FACTORY_MAP.containsKey( name );
  }

  @Nonnull
  public static SchemaProcessor createSchemaProcessor( @Nonnull final String name, @Nonnull final JsonObject config )
  {
    final Class<? extends SchemaProcessorFactory> type = FACTORY_MAP.get( name );
    if ( null == type )
    {
      throw new IllegalArgumentException( "Unable to locate schema processor factory with name '" + name + "'" );
    }
    return JsonbBuilder.create().fromJson( config.toString(), type ).create();
  }
}
