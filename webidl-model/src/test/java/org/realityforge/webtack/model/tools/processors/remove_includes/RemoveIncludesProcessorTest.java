package org.realityforge.webtack.model.tools.processors.remove_includes;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RemoveIncludesProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "RemoveIncludes" ) );
    assertNotNull( createProcessor( "^SVGAElement$", "^SVGURIReference$" ) );
  }

  @Test
  public void badConfiguration_missing_interfacePattern()
  {
    final IllegalArgumentException exception =
      expectThrows( IllegalArgumentException.class,
                    () -> Registry.createProcessor( "RemoveIncludes",
                                                    Json.createObjectBuilder()
                                                      .add( "mixinPattern", "^SVGURIReference$" )
                                                      .build() ) );
    assertEquals( exception.getMessage(),
                  "RemoveIncludesProcessor missing required interfacePattern configuration value" );
  }

  @Test
  public void badConfiguration_missing_mixinPattern()
  {
    final IllegalArgumentException exception =
      expectThrows( IllegalArgumentException.class,
                    () -> Registry.createProcessor( "RemoveIncludes",
                                                    Json.createObjectBuilder()
                                                      .add( "interfacePattern", "^SVGAElement$" )
                                                      .build() ) );
    assertEquals( exception.getMessage(),
                  "RemoveIncludesProcessor missing required mixinPattern configuration value" );
  }

  @Test
  public void basicOperationTest()
    throws Exception
  {
    performFixtureTest( "RemoveIncludesProcessor",
                        () -> createProcessor( "^SVGAElement$", "^SVGURIReference$" ),
                        getTestLocalFixtureDir(),
                        "input",
                        "output" );
  }

  @Nonnull
  private Processor createProcessor( @Nonnull final String interfacePattern, @Nonnull final String mixinPattern )
  {
    return Registry.createProcessor( "RemoveIncludes",
                                     Json.createObjectBuilder()
                                       .add( "interfacePattern", interfacePattern )
                                       .add( "mixinPattern", mixinPattern )
                                       .build() );
  }
}
