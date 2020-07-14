package org.realityforge.webtack.model.tools.processors.rename_enumeration;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RenameEnumerationProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "RenameEnumeration" ) );
    assertNotNull( createProcessor( "^PermissionState$", "DevicePermissionState" ) );
  }

  @Test
  public void badConfiguration_missing_replacement()
  {
    final IllegalArgumentException exception =
      expectThrows( IllegalArgumentException.class,
                    () -> Registry.createProcessor( "RenameEnumeration",
                                                    Json.createObjectBuilder()
                                                      .add( "namePattern", "^PermissionState$" )
                                                      .build() ) );
    assertEquals( exception.getMessage(),
                  "RenameEnumerationProcessor missing required replacement configuration value" );
  }

  @Test
  public void badConfiguration_missing_mixinPattern()
  {
    final IllegalArgumentException exception =
      expectThrows( IllegalArgumentException.class,
                    () -> Registry.createProcessor( "RenameEnumeration",
                                                    Json.createObjectBuilder()
                                                      .add( "replacement", "DevicePermissionState" )
                                                      .build() ) );
    assertEquals( exception.getMessage(),
                  "RenameEnumerationProcessor missing required namePattern configuration value" );
  }

  @Test
  public void basicOperationTest()
    throws Exception
  {
    performFixtureTest( "RenameEnumeration",
                        () -> createProcessor( "^PermissionState$", "DevicePermissionState" ),
                        getTestLocalFixtureDir(),
                        "input",
                        "output" );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final String namePattern, @Nonnull final String replacement )
  {
    return Registry.createProcessor( "RenameEnumeration",
                                     Json.createObjectBuilder()
                                       .add( "namePattern", namePattern )
                                       .add( "replacement", replacement )
                                       .build() );
  }
}
