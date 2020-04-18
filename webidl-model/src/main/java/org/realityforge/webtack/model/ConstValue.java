package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.Writer;
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

  ConstValue( @Nonnull final Kind kind,
              @Nullable final String value,
              @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( sourceLocations );
    assert ( Kind.Decimal == kind || Kind.Integer == kind ) == ( null != value );
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
      final ConstValue that = (ConstValue) o;
      return _kind == that._kind && Objects.equals( _value, that._value );
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

  public void write( @Nonnull final Writer writer )
    throws IOException
  {
    switch ( getKind() )
    {
      case NaN:
        writer.write( "NaN" );
        break;
      case PositiveInfinity:
        writer.write( "Infinity" );
        break;
      case NegativeInfinity:
        writer.write( "-Infinity" );
        break;
      case True:
        writer.write( "true" );
        break;
      case False:
        writer.write( "false" );
        break;
      default:
        assert null != _value;
        writer.write( _value );
        break;
    }
  }

  public enum Kind
  {
    True,
    False,
    Decimal,
    NegativeInfinity,
    PositiveInfinity,
    NaN,
    Integer
  }
}
