package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class MapLikeMember
  extends Element
  implements Member
{
  @Nonnull
  private final Type _keyType;
  @Nonnull
  private final Type _valueType;
  private final boolean _readOnly;

  MapLikeMember( @Nonnull final Type keyType,
                 @Nonnull final Type valueType,
                 final boolean readOnly,
                 @Nonnull final List<ExtendedAttribute> extendedAttributes,
                 @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _keyType = Objects.requireNonNull( keyType );
    _valueType = Objects.requireNonNull( valueType );
    _readOnly = readOnly;
  }

  @Nonnull
  public Type getKeyType()
  {
    return _keyType;
  }

  @Nonnull
  public Type getValueType()
  {
    return _valueType;
  }

  public boolean isReadOnly()
  {
    return _readOnly;
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
      final MapLikeMember that = (MapLikeMember) o;
      return _readOnly == that._readOnly &&
             _keyType.equals( that._keyType ) &&
             _valueType.equals( that._valueType );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _keyType, _valueType, _readOnly );
  }

  public boolean equiv( @Nonnull final MapLikeMember other )
  {
    return super.equiv( other ) &&
           _keyType.equiv( other._keyType ) &&
           _valueType.equiv( other._valueType );
  }
}
