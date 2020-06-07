package org.realityforge.webtack.model.tools.transform;

import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLSchema;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ValidatorProcessorTest
  extends AbstractTest
{
  @Test
  public void valid()
    throws Exception
  {
    final ValidatorProcessor processor = new ValidatorProcessor();
    final WebIDLSchema input =
      loadWebIDLSchema( getTestLocalFixtureDir().resolve( "valid" + WebIDLSchema.EXTENSION ), "Valid schema" );
    final WebIDLSchema output = processor.transform( input );
    assertNotNull( output );
  }

  @Test
  public void invalid()
  {
    final ValidatorProcessor processor = new ValidatorProcessor();
    final WebIDLSchema input =
      loadWebIDLSchema( getTestLocalFixtureDir().resolve( "invalid" + WebIDLSchema.EXTENSION ), "Invalid schema" );
    final ValidationException exception =
      expectThrows( ValidationException.class, () -> processor.transform( input ) );

    assertErrorCount( exception.getErrors(), 2 );
    assertErrorPresent( exception.getErrors(),
                        "Enumeration named 'MySharedName' conflicts with a callback function with the same name." );
    assertErrorPresent( exception.getErrors(),
                        "Callback named 'MySharedName' conflicts with a enumeration with the same name." );
  }
}
