package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class AsyncIterableMember
  extends Element
  implements Member
{
  @Nonnull
  private final Type _keyType;
  @Nonnull
  private final Type _valueType;

  public AsyncIterableMember( @Nonnull final Type keyType,
                              @Nonnull final Type valueType,
                              @Nullable final DocumentationElement documentation,
                              @Nonnull final List<ExtendedAttribute> extendedAttributes,
                              @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( documentation, extendedAttributes, sourceLocations );
    _keyType = Objects.requireNonNull( keyType );
    _valueType = Objects.requireNonNull( valueType );
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
      final AsyncIterableMember other = (AsyncIterableMember) o;
      return _keyType.equals( other._keyType ) &&
             _valueType.equals( other._valueType );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _keyType, _valueType );
  }

  public boolean equiv( @Nonnull final AsyncIterableMember other )
  {
    return super.equiv( other ) &&
           _keyType.equiv( other._keyType ) &&
           _valueType.equiv( other._valueType );
  }
}
