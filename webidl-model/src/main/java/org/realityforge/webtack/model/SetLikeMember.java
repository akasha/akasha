package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class SetLikeMember
  extends Element
  implements Member
{
  @Nonnull
  private final Type _type;
  private final boolean _readOnly;

  SetLikeMember( @Nonnull final Type type,
                 final boolean readOnly,
                 @Nonnull final List<ExtendedAttribute> extendedAttributes,
                 @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _type = Objects.requireNonNull( type );
    _readOnly = readOnly;
  }

  @Nonnull
  public Type getType()
  {
    return _type;
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
      final SetLikeMember other = (SetLikeMember) o;
      return _readOnly == other._readOnly &&
             _type.equals( other._type );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _type, _readOnly );
  }

  public boolean equiv( @Nonnull final SetLikeMember other )
  {
    return super.equiv( other ) &&
           _readOnly == other._readOnly &&
           _type.equiv( other._type );
  }
}
