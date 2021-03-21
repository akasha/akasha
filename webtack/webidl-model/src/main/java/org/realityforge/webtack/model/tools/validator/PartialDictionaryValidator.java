package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.WebIDLSchema;

final class PartialDictionaryValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final Collection<ValidationError> errors = new ArrayList<>();
    for ( final PartialDictionaryDefinition partial : schema.getPartialDictionaries() )
    {
      final String name = partial.getName();
      if ( null == schema.findDictionaryByName( name ) )
      {
        final String message =
          "Dictionary named '" + name + "' does not exist but a partial for the dictionary does exist";
        errors.add( new ValidationError( partial, message, true ) );
      }
    }
    return errors;
  }
}
