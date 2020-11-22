package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.Kind;
import org.realityforge.webtack.model.Type;
import org.realityforge.webtack.model.TypeReference;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.UnionType;
import org.realityforge.webtack.model.WebIDLSchema;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;

final class MarkerTypeUnionValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final Collection<ValidationError> errors = new ArrayList<>();

    for ( final TypedefDefinition definition : schema.getTypedefs() )
    {
      final Type type = definition.getType();
      if ( Kind.Union == type.getKind() &&
           definition.isNoArgsExtendedAttributePresent( ExtendedAttributes.MARKER_TYPE ) )
      {
        final UnionType unionType = (UnionType) type;
        final List<Type> memberTypes = unionType.getMemberTypes();
        for ( final Type memberType : memberTypes )
        {
          if ( Kind.TypeReference != memberType.getKind() )
          {
            invalidTypedef( definition, unionType, memberType, errors );
          }
          else
          {
          final String name = ( (TypeReference) memberType ).getName();
          final TypedefDefinition memberTypedef = schema.findTypedefByName( name );
          if ( null != memberTypedef )
          {
            if ( !memberTypedef.isNoArgsExtendedAttributePresent( ExtendedAttributes.MARKER_TYPE ) )
            {
              invalidTypedef( definition, unionType, memberType, errors );
            }
          }
          else if ( null == schema.findInterfaceByName( name ) )
          {
            invalidTypedef( definition, unionType, memberType, errors );
          }
          }
        }
      }
    }

    return errors;
  }

  private void invalidTypedef( @Nonnull final TypedefDefinition definition,
                               @Nonnull final UnionType unionType,
                               @Nonnull final Type memberType,
                               @Nonnull final Collection<ValidationError> errors )
  {
    final String message =
      "Typedef named '" + definition.getName() + "' has the " + ExtendedAttributes.MARKER_TYPE +
      " extended attribute but contains a member type '" + memberType.toString() +
      "' that is not a reference to an interface or a typedef with the " + ExtendedAttributes.MARKER_TYPE +
      " extended attribute.";
    errors.add( new ValidationError( unionType, message, true ) );
  }
}
