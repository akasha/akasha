package org.realityforge.webtack.model.tools.processors.remove_member;

import javax.annotation.Nonnull;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class RemoveMemberProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "RemoveMember" ) );
    assertNotNull( createProcessor( "^MouseEvent$", "^clientX$", ElementType.dictionary ) );
  }

  @Test
  public void basic()
    throws Exception
  {
    performStandardFixtureTest( "basic",
                                () -> createProcessor( "^(MouseEvent|MouseEventInit)$",
                                                       "^(clientX|clientY|screenX|screenY)$",
                                                       ElementType.interface_type,
                                                       ElementType.dictionary ) );
  }

  @Test
  public void remove_event()
    throws Exception
  {
    performStandardFixtureTest( "remove_event",
                                () -> createProcessor( "^Window$",
                                                       "^vrdisplay.*$",
                                                       ElementType.interface_type ) );
  }

  @Nonnull
  private Processor createProcessor( @Nonnull final String elementNamePattern,
                                     @Nonnull final String memberNamePattern,
                                     @Nonnull final ElementType... types )
  {
    final JsonObjectBuilder json = Json
      .createObjectBuilder()
      .add( "elementNamePattern", elementNamePattern )
      .add( "memberNamePattern", memberNamePattern );
    if ( 0 != types.length )
    {
      final JsonArrayBuilder typesJson = Json.createArrayBuilder();
      for ( final ElementType type : types )
      {
        typesJson.add( type.name() );
      }
      json.add( "types", typesJson );
    }
    return Registry.createProcessor( newPipelineContext(), "RemoveMember", json.build() );
  }
}
