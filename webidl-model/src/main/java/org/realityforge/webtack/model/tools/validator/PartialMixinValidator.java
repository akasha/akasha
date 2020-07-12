package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.WebIDLSchema;

final class PartialMixinValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final Collection<ValidationError> errors = new ArrayList<>();
    for ( final PartialMixinDefinition partial : schema.getPartialMixins() )
    {
      final String name = partial.getName();
      if ( null == schema.findMixinByName( name ) )
      {
        final String message =
          "Mixin named '" + name + "' does not exist but a partial for the mixin does exist";
        errors.add( new ValidationError( partial, message, true ) );
      }
    }
    return errors;
  }
}
