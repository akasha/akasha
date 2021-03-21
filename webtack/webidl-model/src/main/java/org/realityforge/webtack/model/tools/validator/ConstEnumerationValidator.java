package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
import org.realityforge.webtack.model.ConstEnumerationValue;
import org.realityforge.webtack.model.ConstMember;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.WebIDLSchema;

final class ConstEnumerationValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final Collection<ValidationError> errors = new ArrayList<>();
    for ( final ConstEnumerationDefinition definition : schema.getConstEnumerations() )
    {
      final Set<String> names = new HashSet<>();
      Type valueType = null;
      for ( final ConstEnumerationValue value : definition.getValues() )
      {
        final InterfaceDefinition type = schema.findInterfaceByName( value.getInterfaceName() );
        if ( null == type )
        {
          final String message =
            "Constant named '" + value.getConstName() + "' referenced by const enumeration named '" +
            definition.getName() + "' references an unknown type named '" + value.getInterfaceName() + "'";
          errors.add( new ValidationError( value, message, true ) );
        }
        else
        {
          final ConstMember constant = type.findConstantByName( value.getConstName() );
          if ( null == constant )
          {
            final String message =
              "Constant named '" + value.getConstName() + "' referenced by const enumeration named '" +
              definition.getName() + "' does not exist on type named '" + value.getInterfaceName() + "'";
            errors.add( new ValidationError( value, message, true ) );
          }
          else
          {
            final Type actualType = schema.resolveType( constant.getType() );
            if ( null == valueType )
            {
              valueType = actualType;
            }
            else if ( !valueType.equiv( actualType ) )
            {
              final String message =
                "Constant named '" + value.getConstName() + "' referenced by const enumeration named '" +
                definition.getName() + "' has a type of " + actualType + " which does not match the type " +
                "of other constants in the const enumeration which are of type " + valueType;
              errors.add( new ValidationError( value, message, true ) );
            }
            if ( !actualType.getKind().isInteger() && !actualType.getKind().isString() )
            {
              final String message =
                "Constant named '" + value.getConstName() + "' referenced by const enumeration named '" +
                definition.getName() + "' has a type of " + actualType + " which is not an integer or string type";
              errors.add( new ValidationError( value, message, true ) );
            }
          }
        }
      }
    }

    return errors;
  }
}
