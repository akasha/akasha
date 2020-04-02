package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class DefaultValue
{
  @Nonnull
  private final Kind _kind;
  @Nullable
  private final ConstValue _constValue;
  @Nullable
  private final String _stringValue;

  DefaultValue( @Nonnull final Kind kind, @Nullable final ConstValue constValue, @Nullable final String stringValue )
  {
    assert ( Kind.Const == kind ) == ( null != constValue );
    assert ( Kind.String == kind ) == ( null != stringValue );
    _kind = Objects.requireNonNull( kind );
    _constValue = constValue;
    _stringValue = stringValue;
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

  @Nullable
  public String getStringValue()
  {
    return _stringValue;
  }

  public enum Kind
  {
    Const,
    String,
    EmptyDictionary,
    EmptySequence,
    Null
  }
}
