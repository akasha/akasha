package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public class Type
  extends Element
{
  @Nonnull
  private final Kind _kind;
  private final boolean _nullable;

  Type( @Nonnull final Kind kind,
        @Nonnull final List<ExtendedAttribute> extendedAttributes,
        final boolean nullable,
        @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _kind = Objects.requireNonNull( kind );
    _nullable = nullable;
    assert _kind.isNullableAllowed() || !isNullable();
    assert ( Kind.Sequence == _kind ) == ( this instanceof SequenceType );
    assert ( Kind.FrozenArray == _kind ) == ( this instanceof FrozenArrayType );
    assert ( Kind.TypeReference == _kind ) == ( this instanceof TypeReference );
    assert ( Kind.Promise == _kind ) == ( this instanceof PromiseType );
    assert ( Kind.Record == _kind ) == ( this instanceof RecordType );
    assert ( Kind.Union == _kind ) == ( this instanceof UnionType );
  }

  @Nonnull
  public final Kind getKind()
  {
    return _kind;
  }

  public final boolean isNullable()
  {
    return _nullable;
  }
}
