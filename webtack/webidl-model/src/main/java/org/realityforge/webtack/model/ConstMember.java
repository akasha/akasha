package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class ConstMember
  extends NamedElement
  implements Member
{
  @Nonnull
  private final Type _type;
  @Nonnull
  private final ConstValue _value;

  public ConstMember( @Nonnull final String name,
                      @Nonnull final Type type,
                      @Nonnull final ConstValue value,
                      @Nullable final DocumentationElement documentation,
                      @Nonnull final List<ExtendedAttribute> extendedAttributes,
                      @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, documentation, extendedAttributes, sourceLocations );
    // The type reference should be to a primitive type but this would need to be verified post resolution
    assert type.getKind().isPrimitive() || type.getKind().isString() || Kind.TypeReference == type.getKind();
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

  @Override
  public boolean equals( final Object o )
  {
    if ( this == o )
    {
      return true;
    }
    else if ( o == null || getClass() != o.getClass() || !super.equals( o ) )
    {
      return false;
    }
    else
    {
      final ConstMember other = (ConstMember) o;
      return _type.equals( other._type ) &&
             _value.equals( other._value );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _type, _value );
  }

  public boolean equiv( @Nonnull final ConstMember other )
  {
    return super.equiv( other ) &&
           _type.equiv( other._type ) &&
           _value.equiv( other._value );
  }
}
