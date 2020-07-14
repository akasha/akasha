package org.realityforge.webtack.model.tools.processors.remove_element;

import javax.annotation.Nonnull;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import org.realityforge.webtack.model.tools.processors.AbstractProcessorTest;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public final class RemoveElementProcessorTest
  extends AbstractProcessorTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "RemoveElement" ) );
    assertNotNull( createProcessor( "^SpeechRecognition.*" ) );
  }

  @Test
  public void remove_all()
    throws Exception
  {
    performStandardFixtureTest( "remove_all", () -> createProcessor( "^SpeechRecognition.*$" ) );
  }

  @Test
  public void remove_callback()
    throws Exception
  {
    performStandardFixtureTest( "remove_callback", () -> createProcessor( "^AudioWorkletProcessorConstructor$" ) );
  }

  @Test
  public void remove_dictionary()
    throws Exception
  {
    performStandardFixtureTest( "remove_dictionary", () -> createProcessor( "^ExtendableMessageEventInit$" ) );
  }

  @Test
  public void remove_interface()
    throws Exception
  {
    performStandardFixtureTest( "remove_interface", () -> createProcessor( "^SpeechRecognition.*", ElementType.interface_type ) );
  }

  @Nonnull
  private Processor createProcessor( @Nonnull final String namePattern, @Nonnull final ElementType... types )
  {
    final JsonObjectBuilder json = Json
      .createObjectBuilder()
      .add( "namePattern", namePattern );
    if ( 0 != types.length )
    {
      final JsonArrayBuilder typesJson = Json.createArrayBuilder();
      for ( final ElementType type : types )
      {
        typesJson.add( type.name() );
      }
      json.add( "types", typesJson );
    }
    return Registry.createProcessor( "RemoveElement", json.build() );
  }
}