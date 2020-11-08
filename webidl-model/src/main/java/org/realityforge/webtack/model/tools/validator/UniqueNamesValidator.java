package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.CallbackDefinition;
import org.realityforge.webtack.model.CallbackInterfaceDefinition;
import org.realityforge.webtack.model.ConstEnumerationDefinition;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.EnumerationDefinition;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.TypedefDefinition;
import org.realityforge.webtack.model.WebIDLSchema;

final class UniqueNamesValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final Collection<ValidationError> errors = new ArrayList<>();

    schema.getCallbacks().forEach( n -> verifyNameUnique( errors, schema, n.getName(), "callback function" ) );
    schema.getCallbackInterfaces()
      .forEach( n -> verifyNameUnique( errors, schema, n.getName(), "callback interface" ) );
    schema.getEnumerations().forEach( n -> verifyNameUnique( errors, schema, n.getName(), "enumeration" ) );
    schema.getConstEnumerations().forEach( n -> verifyNameUnique( errors, schema, n.getName(), "const enumeration" ) );
    schema.getDictionaries().forEach( n -> verifyNameUnique( errors, schema, n.getName(), "dictionary" ) );
    schema.getInterfaces().forEach( n -> verifyNameUnique( errors, schema, n.getName(), "interface" ) );
    schema.getTypedefs().forEach( n -> verifyNameUnique( errors, schema, n.getName(), "typedef" ) );

    return errors;
  }

  private void verifyNameUnique( @Nonnull final Collection<ValidationError> errors,
                                 @Nonnull final WebIDLSchema schema,
                                 @Nonnull final String name,
                                 @Nonnull final String type )
  {
    if ( !"callback function".equals( type ) )
    {
      final CallbackDefinition existing = schema.findCallbackByName( name );
      if ( null != existing )
      {
        final String message =
          "Callback named '" + name + "' conflicts with a " + type + " with the same name.";
        errors.add( new ValidationError( existing, message, true ) );
      }
    }
    if ( !"callback interface".equals( type ) )
    {
      final CallbackInterfaceDefinition existing = schema.findCallbackInterfaceByName( name );
      if ( null != existing )
      {
        final String message =
          "Callback interface named '" + name + "' conflicts with a " + type + " with the same name.";
        errors.add( new ValidationError( existing, message, true ) );
      }
    }
    if ( !"enumeration".equals( type ) )
    {
      final EnumerationDefinition existing = schema.findEnumerationByName( name );
      if ( null != existing )
      {
        final String message =
          "Enumeration named '" + name + "' conflicts with a " + type + " with the same name.";
        errors.add( new ValidationError( existing, message, true ) );
      }
    }
    if ( !"const enumeration".equals( type ) )
    {
      final ConstEnumerationDefinition existing = schema.findConstEnumerationByName( name );
      if ( null != existing )
      {
        final String message =
          "Const enumeration named '" + name + "' conflicts with a " + type + " with the same name.";
        errors.add( new ValidationError( existing, message, true ) );
      }
    }
    if ( !"interface".equals( type ) )
    {
      final InterfaceDefinition existing = schema.findInterfaceByName( name );
      if ( null != existing )
      {
        final String message =
          "Interface named '" + name + "' conflicts with a " + type + " with the same name.";
        errors.add( new ValidationError( existing, message, true ) );
      }
    }
    if ( !"dictionary".equals( type ) )
    {
      final DictionaryDefinition existing = schema.findDictionaryByName( name );
      if ( null != existing )
      {
        final String message =
          "Dictionary named '" + name + "' conflicts with a " + type + " with the same name.";
        errors.add( new ValidationError( existing, message, true ) );
      }
    }
    if ( !"typedef".equals( type ) )
    {
      final TypedefDefinition existing = schema.findTypedefByName( name );
      if ( null != existing )
      {
        final String message =
          "Typedef named '" + name + "' conflicts with a " + type + " with the same name.";
        errors.add( new ValidationError( existing, message, true ) );
      }
    }
  }
}
