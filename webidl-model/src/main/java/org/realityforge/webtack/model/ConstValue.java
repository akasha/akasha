package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class ConstValue
{
  @Nonnull
  private final Kind _kind;
  /**
   * The value is only populated when _kind is Decimal or Integer.
   */
  @Nullable
  private final String _value;

  ConstValue( @Nonnull final Kind kind, @Nullable final String value )
  {
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
