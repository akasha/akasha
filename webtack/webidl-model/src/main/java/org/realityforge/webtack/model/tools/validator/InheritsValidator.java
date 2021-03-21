package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.WebIDLSchema;

final class InheritsValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final List<ValidationError> errors = new ArrayList<>();
    for ( final DictionaryDefinition definition : schema.getDictionaries() )
    {
      final String inherits = definition.getInherits();
      if ( null != inherits )
      {
        final DictionaryDefinition parent = schema.findDictionaryByName( inherits );
        if ( null == parent )
        {
          final String message =
            "Dictionary named '" + definition.getName() + "' inherits from dictionary named '" + inherits +
            "' but no such dictionary exists";
          errors.add( new ValidationError( definition, message, true ) );
        }
      }
    }
    for ( final InterfaceDefinition definition : schema.getInterfaces() )
    {
      final String inherits = definition.getInherits();
      if ( null != inherits )
      {
        final InterfaceDefinition parent = schema.findInterfaceByName( inherits );
        if ( null == parent )
        {
          final String message =
            "Interface named '" + definition.getName() + "' inherits from interface named '" + inherits +
            "' but no such interface exists";
          errors.add( new ValidationError( definition, message, true ) );
        }
      }
    }
    return errors;
  }
}
