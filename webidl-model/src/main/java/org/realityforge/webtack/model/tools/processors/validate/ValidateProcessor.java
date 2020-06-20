package org.realityforge.webtack.model.tools.processors.validate;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.spi.Processor;
import org.realityforge.webtack.model.tools.validator.ValidationError;
import org.realityforge.webtack.model.tools.validator.ValidatorTool;

final class ValidateProcessor
  implements Processor
{
  @Override
  public WebIDLSchema process( @Nonnull final WebIDLSchema schema )
    throws ValidationException
  {
    final Collection<ValidationError> errors = ValidatorTool.create().validate( schema );
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
