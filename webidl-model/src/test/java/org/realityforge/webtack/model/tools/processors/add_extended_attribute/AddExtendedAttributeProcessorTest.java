package org.realityforge.webtack.model.tools.processors.add_extended_attribute;

import javax.annotation.Nonnull;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class AddExtendedAttributeProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "AddExtendedAttribute" ) );
  }

  @Test
  public void update_geolocation_api()
    throws Exception
  {
    performStandardFixtureTest( "update_geolocation_api",
                                () -> createProcessor( "^(Coordinates|Geolocation|Position|PositionError)$",
                                                       "LegacyNoInterfaceObject" ) );
  }

  @Test
  public void type_restrict()
    throws Exception
  {
    performStandardFixtureTest( "type_restrict",
                                () -> createProcessor( "^MyElement.*$",
                                                       "SomeRandomAttribute",
                                                       ElementType.dictionary ) );
  }

  @Nonnull
  private Processor createProcessor( @Nonnull final String namePattern,
                                     @Nonnull final String extendedAttribute,
                                     @Nonnull final ElementType... types )
  {
    final JsonObjectBuilder json = Json
      .createObjectBuilder()
      .add( "namePattern", namePattern )
      .add( "extendedAttribute", extendedAttribute );

    if ( 0 != types.length )
    {
      final JsonArrayBuilder typesJson = Json.createArrayBuilder();
      for ( final ElementType type : types )
      {
        typesJson.add( type.name() );
      }
      json.add( "types", typesJson );
    }
    return Registry.createProcessor( "AddExtendedAttribute", json.build() );
  }
}
