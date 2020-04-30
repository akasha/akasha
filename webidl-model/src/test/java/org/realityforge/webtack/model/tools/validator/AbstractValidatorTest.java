package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
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
                                 @Nonnull final String message,
                                 final boolean shouldHaltValidation )
  {
    assertTrue( errors.stream().anyMatch( e -> e.getMessage().equals( message ) &&
                                               e.shouldHaltValidation() == shouldHaltValidation ) );
  }
}
