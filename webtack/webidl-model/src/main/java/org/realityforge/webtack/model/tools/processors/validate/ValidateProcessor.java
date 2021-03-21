package org.realityforge.webtack.model.tools.processors.validate;

import java.util.Collection;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.validator.ValidationError;
import org.realityforge.webtack.model.tools.validator.ValidatorRuleConfig;
import org.realityforge.webtack.model.tools.validator.ValidatorTool;

final class ValidateProcessor
  implements Processor
{
  @Nonnull
  private final ValidatorRuleConfig _ruleConfig;

  ValidateProcessor( @Nonnull final ValidatorRuleConfig ruleConfig )
  {
    _ruleConfig = Objects.requireNonNull( ruleConfig );
  }

  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
    throws ValidationException
  {
    final Collection<ValidationError> errors = ValidatorTool.create( _ruleConfig ).validate( schema );
    if ( errors.isEmpty() )
    {
      return schema;
    }
    else
    {
      throw new ValidationException( errors );
    }
  }
}
