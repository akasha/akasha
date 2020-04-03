package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * A reference to a type with specified name.
 * The name may identify an interface, enumeration, callback function, callback interface or typedef.
 */
public final class TypeReference
  extends Type
{
  @Nonnull
  private final String _name;

  TypeReference( @Nonnull final String name,
                 @Nonnull final List<ExtendedAttribute> extendedAttributes,
                 final boolean nullable )
  {
    super( Kind.TypeReference, extendedAttributes, nullable );
    _name = Objects.requireNonNull( name );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }
}
