package org.realityforge.webtack.model.tools.processors.validate;

import java.util.Collection;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.validator.ValidationError;

public final class ValidationException
  extends Exception
{
  @Nonnull
  private final Collection<ValidationError> _errors;

  public ValidationException( @Nonnull final Collection<ValidationError> errors )
  {
    assert !errors.isEmpty();
    _errors = Objects.requireNonNull( errors );
  }

  @Nonnull
  public Collection<ValidationError> getErrors()
  {
    return _errors;
  }
}
