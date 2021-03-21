package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class ConstValue
  extends Node
{
  @Nonnull
  private final Kind _kind;
  /**
   * The value is only populated when _kind is Decimal or Integer.
   */
  @Nullable
  private final String _value;

  public ConstValue( @Nonnull final Kind kind,
                     @Nullable final String value,
                     @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( sourceLocations );
    assert ( Kind.Decimal == kind || Kind.Integer == kind || Kind.String == kind ) == ( null != value );
    _kind = Objects.requireNonNull( kind );
    _value = value;
  }

  @Nonnull
  public Kind getKind()
  {
    return _kind;
  }

  @Nullable
  public String getValue()
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
    else if ( null == o || getClass() != o.getClass() )
    {
      return false;
    }
    else
    {
      final ConstValue other = (ConstValue) o;
      return _kind == other._kind && Objects.equals( _value, other._value );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( _kind, _value );
  }

  public boolean equiv( @Nonnull final ConstValue other )
  {
    return equals( other );
  }

  public enum Kind
  {
    String,
    True,
    False,
    Decimal,
    NegativeInfinity,
    PositiveInfinity,
    NaN,
    Integer
  }
}
