package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.AbstractTest;
import org.realityforge.webtack.model.WebIDLSchema;

public abstract class AbstractValidatorTest
  extends AbstractTest
{
  @Nonnull
  abstract Validator createValidator();

  @Nonnull
  final Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema, final int errorCount )
  {
    final Collection<ValidationError> errors = createValidator().validate( schema );
    assertErrorCount( errors, errorCount );
    return errors;
  }

  protected final void assertSingleError( @Nonnull final String filename, @Nonnull final String message )
  {
    assertErrorPresent( validate( loadTestLocalSchema( filename ), 1 ), message );
  }
}
