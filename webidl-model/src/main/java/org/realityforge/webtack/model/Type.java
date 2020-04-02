package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public class Type
  extends Element
{
  @Nonnull
  private final Kind _kind;
  private final int _flags;

  Type( @Nonnull final Kind kind, @Nonnull final List<ExtendedAttribute> extendedAttributes, final int flags )
  {
    super( extendedAttributes );
    _kind = Objects.requireNonNull( kind );
    _flags = flags;
    assert _kind.isNullableAllowed() || !isNullable();
    assert ( Kind.Sequence == _kind ) == ( this instanceof SequenceType );
    assert ( Kind.FrozenArray == _kind ) == ( this instanceof FrozenArrayType );
    assert ( Kind.Enumeration == _kind ) == ( this instanceof EnumerationType );
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
    return ( _flags & Flags.NULLABLE ) == Flags.NULLABLE;
  }

  public static final class Flags
  {
    private Flags()
    {
    }

    // TODO: If there is only one flag we should just use a boolean
    public static final int NULLABLE = 1 << 5;
  }
}
