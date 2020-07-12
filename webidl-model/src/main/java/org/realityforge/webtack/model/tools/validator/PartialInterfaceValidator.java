package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.WebIDLSchema;

final class PartialInterfaceValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final Collection<ValidationError> errors = new ArrayList<>();
    for ( final PartialInterfaceDefinition partial : schema.getPartialInterfaces() )
    {
      final String name = partial.getName();
      if ( null == schema.findInterfaceByName( name ) )
      {
        final String message =
          "Interface named '" + name + "' does not exist but a partial for the interface does exist";
        errors.add( new ValidationError( partial, message, true ) );
      }
    }
    return errors;
  }
}
