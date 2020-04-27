package org.realityforge.webtack.model.tools.validator;

import java.util.Collection;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;

final class TestValidator
  implements Validator
{
  @Nonnull
  private final Collection<ValidationError> _errors;

  TestValidator( @Nonnull final Collection<ValidationError> errors )
  {
    _errors = Objects.requireNonNull( errors );
  }

  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    return _errors;
  }
}
