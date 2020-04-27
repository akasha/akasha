package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;

/**
 * A validator that runs a chain of validator stages in succession.
 * If a stage returns a error that where {@link ValidationError#shouldHaltValidation()} returns {@code true}
 * then the subsequent stages are skipped.
 */
final class AggregateValidator
  implements Validator
{
  @Nonnull
  private final List<Validator> _validators;

  AggregateValidator( @Nonnull final List<Validator> validators )
  {
    _validators = Objects.requireNonNull( validators );
  }

  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final Collection<ValidationError> errors = new ArrayList<>();
    for ( final Validator validator : _validators )
    {
      final Collection<ValidationError> validationErrors = validator.validate( schema );
      errors.addAll( validationErrors );
      if ( validationErrors.stream().anyMatch( ValidationError::shouldHaltValidation ) )
      {
        break;
      }
    }
    return Collections.unmodifiableCollection( errors );
  }
}
