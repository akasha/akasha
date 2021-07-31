package org.realityforge.webtack.model.tools.processors.add_extended_attribute;

import javax.annotation.Nonnull;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import org.realityforge.webtack.model.tools.pipeline.ProgressListener;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.qa.TestProgressListener;
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
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^.*$",
                                                       "JavaSubPackage=bluetooth",
                                                       2 ) );
  }

  @Test
  public void basicBad_expectedAddCount()
    throws Exception
  {
    final TestProgressListener progressListener = new TestProgressListener( 1 );
    performStandardFixtureTest( "basic",
                                () -> createProcessor( progressListener, "^.*$", "JavaSubPackage=bluetooth", 2000 ) );
    progressListener.assertContains(
      "stageError(MyPipeline,MyStage): ERROR: Added 2 extended attributes but expected to add 2000 extended attributes." );
  }

  @Test
  public void update_geolocation_api()
    throws Exception
  {
    performStandardFixtureTest( "update_geolocation_api",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^(Coordinates|Geolocation|Position|PositionError)$",
                                                       "LegacyNoInterfaceObject",
                                                       4 ) );
  }

  @Test
  public void type_restrict()
    throws Exception
  {
    performStandardFixtureTest( "type_restrict",
                                () -> createProcessor( new TestProgressListener(),
                                                       "^MyElement.*$",
                                                       "SomeRandomAttribute",
                                                       1,
                                                       ElementType.dictionary ) );
  }

  @Nonnull
  private Processor createProcessor( @Nonnull final ProgressListener progressListener,
                                     @Nonnull final String namePattern,
                                     @Nonnull final String extendedAttribute,
                                     final int expectedAddCount,
                                     @Nonnull final ElementType... types )
  {
    final JsonObjectBuilder json = Json
      .createObjectBuilder()
      .add( "namePattern", namePattern )
      .add( "extendedAttribute", extendedAttribute )
      .add( "expectedAddCount", expectedAddCount );

    if ( 0 != types.length )
    {
      final JsonArrayBuilder typesJson = Json.createArrayBuilder();
      for ( final ElementType type : types )
      {
        typesJson.add( type.name() );
      }
      json.add( "types", typesJson );
    }
    return Registry.createProcessor( newPipelineContext( progressListener ), "AddExtendedAttribute", json.build() );
  }
}
