package org.realityforge.webtack.model.tools.processors.validate;

import javax.annotation.Nonnull;
import javax.json.Json;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.spi.Registry;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ValidateProcessorTest
  extends AbstractTest
{
  @Test
  public void registry()
  {
    assertTrue( Registry.isProcessorPresent( "Validate" ) );
    assertNotNull( createProcessor() );
  }

  @Test
  public void valid()
    throws Exception
  {
    final Processor processor = createProcessor();
    final WebIDLSchema input =
      loadWebIDLSchema( getTestLocalFixtureDir().resolve( "valid" + WebIDLSchema.EXTENSION ), "Valid schema" );
    final WebIDLSchema output = processor.process( input );
    assertNotNull( output );
  }

  @Test
  public void invalid()
  {
    final Processor processor = createProcessor();
    final WebIDLSchema input =
      loadWebIDLSchema( getTestLocalFixtureDir().resolve( "invalid" + WebIDLSchema.EXTENSION ), "Invalid schema" );
    final ValidationException exception =
      expectThrows( ValidationException.class, () -> processor.process( input ) );

    assertErrorCount( exception.getErrors(), 2 );
    assertErrorPresent( exception.getErrors(),
                        "Enumeration named 'MySharedName' conflicts with a callback function with the same name." );
    assertErrorPresent( exception.getErrors(),
                        "Callback named 'MySharedName' conflicts with a enumeration with the same name." );
  }

  @Nonnull
  private Processor createProcessor()
  {
    return Registry.createProcessor( newPipelineContext(), "Validate", Json.createObjectBuilder().build() );
  }
}
