package org.realityforge.webtack.model.tools.processors.rename_type;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RenameTypeProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "RenameType" ) );
    assertNotNull( createProcessor( "^PermissionState$", "DevicePermissionState" ) );
  }

  @Test
  public void badConfiguration_missing_replacement()
  {
    final IllegalArgumentException exception =
      expectThrows( IllegalArgumentException.class,
                    () -> Registry.createProcessor( "RenameType",
                                                    Json.createObjectBuilder()
                                                      .add( "namePattern", "^PermissionState$" )
                                                      .build() ) );
    assertEquals( exception.getMessage(),
                  "RenameTypeProcessor missing required replacement configuration value" );
  }

  @Test
  public void badConfiguration_missing_mixinPattern()
  {
    final IllegalArgumentException exception =
      expectThrows( IllegalArgumentException.class,
                    () -> Registry.createProcessor( "RenameType",
                                                    Json.createObjectBuilder()
                                                      .add( "replacement", "DevicePermissionState" )
                                                      .build() ) );
    assertEquals( exception.getMessage(),
                  "RenameTypeProcessor missing required namePattern configuration value" );
  }

  @Test
  public void rename_callback()
    throws Exception
  {
    performStandardFixtureTest( "rename_callback",
                                () -> createProcessor( "^EventHandler$", "NullableEventHandler" ) );
  }

  @Test
  public void rename_enumeration()
    throws Exception
  {
    performStandardFixtureTest( "rename_enumeration",
                                () -> createProcessor( "^PermissionState$", "DevicePermissionState" ) );
  }

  @SuppressWarnings( "SameParameterValue" )
  @Nonnull
  private Processor createProcessor( @Nonnull final String namePattern, @Nonnull final String replacement )
  {
    return Registry.createProcessor( "RenameType",
                                     Json.createObjectBuilder()
                                       .add( "namePattern", namePattern )
                                       .add( "replacement", replacement )
                                       .build() );
  }
}
