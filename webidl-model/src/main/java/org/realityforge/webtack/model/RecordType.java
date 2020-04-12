package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class RecordType
  extends Type
{
  @Nonnull
  private final Type _keyType;
  @Nonnull
  private final Type _valueType;

  RecordType( @Nonnull final Type keyType,
              @Nonnull final Type valueType,
              @Nonnull final List<ExtendedAttribute> extendedAttributes,
              final boolean nullable,
              @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( Kind.Record, extendedAttributes, nullable, sourceLocations );
    _keyType = Objects.requireNonNull( keyType );
    _valueType = Objects.requireNonNull( valueType );
    assert _keyType.getKind().isString();
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
}
