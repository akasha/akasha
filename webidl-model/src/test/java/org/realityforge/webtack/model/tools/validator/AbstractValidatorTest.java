package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLSchema;
import static org.testng.Assert.*;

public abstract class AbstractValidatorTest
  extends AbstractTest
{
  @Nonnull
  abstract Validator createValidator();

  @Nonnull
  final Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema, final int errorCount )
  {
    final Collection<ValidationError> errors = createValidator().validate( schema );
    assertEquals( errors.size(), errorCount );
    return errors;
  }

  final void assertErrorPresent( @Nonnull final Collection<ValidationError> errors,
                                 @Nonnull final String message )
  {
    assertErrorPresent( errors, message, true );
  }

  @SuppressWarnings( "SameParameterValue" )
  final void assertErrorPresent( @Nonnull final Collection<ValidationError> errors,
                                 @Nonnull final String message,
                                 final boolean halt )
  {
    assertTrue( errors.stream().anyMatch( e -> e.getMessage().equals( message ) && e.shouldHalt() == halt ),
                "Failed to find error with message '" + message + "' and shouldHalt = " + halt +
                " in errors:\n" +
                errors.stream().map( ValidationError::getMessage ).collect( Collectors.joining( "\n" ) ) );
  }
}
