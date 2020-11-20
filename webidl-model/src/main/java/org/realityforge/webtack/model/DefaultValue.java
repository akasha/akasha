package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class DefaultValue
  extends Node
{
  @Nonnull
  private final Kind _kind;
  @Nullable
  private final ConstValue _constValue;

  public DefaultValue( @Nonnull final Kind kind,
                       @Nullable final ConstValue constValue,
                       @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( sourceLocations );
    assert ( Kind.Const == kind ) == ( null != constValue );
    _kind = Objects.requireNonNull( kind );
    _constValue = constValue;
  }

  @Nonnull
  public Kind getKind()
  {
    return _kind;
  }

  @Nullable
  public ConstValue getConstValue()
  {
    return _constValue;
  }

  @Override
  public boolean equals( final Object o )
  {
    if ( this == o )
    {
      return true;
    }
    else if ( o == null || getClass() != o.getClass() )
    {
      return false;
    }
    else
    {
      final DefaultValue other = (DefaultValue) o;
      return _kind == other._kind &&
             Objects.equals( _constValue, other._constValue );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( _kind, _constValue );
  }

  public boolean equiv( @Nonnull final DefaultValue other )
  {
    return equals( other );
  }

  public enum Kind
  {
    Const,
    EmptyDictionary,
    EmptySequence,
    Null
  }
}
