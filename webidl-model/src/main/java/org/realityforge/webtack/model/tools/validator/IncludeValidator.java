package org.realityforge.webtack.model.tools.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.DictionaryDefinition;
import org.realityforge.webtack.model.IncludesStatement;
import org.realityforge.webtack.model.InterfaceDefinition;
import org.realityforge.webtack.model.WebIDLSchema;

final class IncludeValidator
  implements Validator
{
  @Nonnull
  @Override
  public Collection<ValidationError> validate( @Nonnull final WebIDLSchema schema )
  {
    final List<ValidationError> errors = new ArrayList<>();
    for ( final IncludesStatement include : schema.getIncludes() )
    {
      final String interfaceName = include.getInterfaceName();
      final String mixinName = include.getMixinName();
      if ( null == schema.findInterfaceByName( interfaceName ) )
      {
        final String message =
          "Include of mixin named '" + mixinName + "' into interface named '" + interfaceName +
          "' defined but no such interface exists";
        errors.add( new ValidationError( include, message, true ) );
      }
      if ( null == schema.findMixinByName( mixinName ) )
      {
        final String message =
          "Include of mixin named '" + mixinName + "' into interface named '" + interfaceName +
          "' defined but no such mixin exists";
        errors.add( new ValidationError( include, message, true ) );
      }
    }
    return errors;
  }
}
