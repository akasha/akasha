package org.realityforge.webtack.model.tools.transform;

import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.validator.ValidationError;
import org.realityforge.webtack.model.tools.validator.ValidatorTool;

final class ValidatorProcessor
  implements SchemaProcessor
{
  @Nonnull
  public static final String NAME = "Validate";

  private ValidatorProcessor()
  {
  }

  @Override
  public WebIDLSchema transform( @Nonnull final WebIDLSchema schema )
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

  public static final class Config
    implements SchemaProcessorFactory
  {
    @Nonnull
    @Override
    public SchemaProcessor create()
    {
      return new ValidatorProcessor();
    }
  }
}
