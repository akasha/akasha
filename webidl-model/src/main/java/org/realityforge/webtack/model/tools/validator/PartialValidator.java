package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.PartialDictionaryDefinition;
import org.realityforge.webtack.model.PartialInterfaceDefinition;
import org.realityforge.webtack.model.PartialMixinDefinition;
import org.realityforge.webtack.model.PartialNamespaceDefinition;
import org.realityforge.webtack.model.WebIDLSchema;

final class PartialValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final Collection<ValidationError> errors = new ArrayList<>();
    for ( final PartialNamespaceDefinition partial : schema.getPartialNamespaces() )
    {
      final String name = partial.getName();
      if ( null == schema.findNamespaceByName( name ) )
      {
        final String message =
          "Namespace named '" + name + "' does not exist but a partial for the namespace does exist";
        errors.add( new ValidationError( partial, message, true ) );
      }
    }
    for ( final PartialDictionaryDefinition partial : schema.getPartialDictionaries() )
    {
      final String name = partial.getName();
      if ( null == schema.findDictionaryByName( name ) )
      {
        final String message =
          "Dictionary named '" + name + "' does not exist but a partial for the dictionary does exist";
        errors.add( new ValidationError( partial, message, true ) );
      }
    }
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
