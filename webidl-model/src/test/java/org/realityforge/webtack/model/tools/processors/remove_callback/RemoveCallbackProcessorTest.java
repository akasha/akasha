package org.realityforge.webtack.model.tools.processors.remove_callback;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RemoveCallbackProcessorTest
  extends AbstractTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "RemoveCallback" ) );
    assertNotNull( createProcessor( "Window" ) );
  }

  @Test
  public void badConfiguration()
  {
    final IllegalArgumentException exception =
      expectThrows( IllegalArgumentException.class,
                    () -> Registry.createProcessor( "RemoveCallback", Json.createObjectBuilder().build() ) );
    assertEquals( exception.getMessage(),
                  "RemoveCallbackProcessor missing required namePattern configuration value" );
  }

  @Test
  public void basicOperationTest()
    throws Exception
  {
    performFixtureTest( "RemoveCallbackProcessor - interface",
                        () -> createProcessor( "^AudioWorkletProcessorConstructor$" ),
                        getTestLocalFixtureDir(),
                        "input",
                        "output" );
  }

  @Nonnull
  private Processor createProcessor( @Nonnull final String namePattern )
  {
    return Registry.createProcessor( "RemoveCallback",
                                     Json.createObjectBuilder()
                                       .add( "namePattern", namePattern )
                                       .build() );
  }
}
