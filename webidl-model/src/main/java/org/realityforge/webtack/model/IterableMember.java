package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class IterableMember
  extends Element
  implements Member
{
  @Nullable
  private final Type _keyType;
  @Nonnull
  private final Type _valueType;

  IterableMember( @Nullable final Type keyType,
                  @Nonnull final Type valueType,
                  @Nonnull final List<ExtendedAttribute> extendedAttributes,
                  @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _keyType = keyType;
    _valueType = Objects.requireNonNull( valueType );
  }

  @Nullable
  public Type getKeyType()
  {
    return _keyType;
  }

  @Nonnull
  public Type getValueType()
  {
    return _valueType;
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
      final IterableMember other = (IterableMember) o;
      return Objects.equals( _keyType, other._keyType ) &&
             _valueType.equals( other._valueType );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _keyType, _valueType );
  }

  public boolean equiv( @Nonnull final IterableMember other )
  {
    return super.equiv( other ) &&
           (
             ( null == _keyType && null == other._keyType ) ||
             ( null != _keyType && null != other._keyType && _keyType.equiv( other._keyType ) )
           ) &&
           _valueType.equiv( other._valueType );
  }
}
