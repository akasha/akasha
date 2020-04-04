package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * A member of an interface, a callback interface, interface mixins or namespaces.
 */
public final class ConstMember
  extends Member
{
  @Nonnull
  private final Type _type;
  @Nonnull
  private final ConstValue _value;

  ConstMember( @Nonnull final String name,
               @Nonnull final Type type,
               @Nonnull final ConstValue value,
               @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    super( name, extendedAttributes );
    // The type reference should be to a primitive type but this would need to be verified post resolution
    assert type.getKind().isPrimitive() || Kind.TypeReference == type.getKind();
    _type = Objects.requireNonNull( type );
    _value = Objects.requireNonNull( value );
  }

  @Nonnull
  public Type getType()
  {
    return _type;
  }

  @Nonnull
  public ConstValue getValue()
  {
    return _value;
  }
}
