package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public class Type
{
  @Nonnull
  private final Kind _kind;
  @Nonnull
  private final List<ExtendedAttribute> _extendedAttributes;
  private final int _flags;

  Type( @Nonnull final Kind kind, @Nonnull final List<ExtendedAttribute> extendedAttributes, final int flags )
  {
    _kind = Objects.requireNonNull( kind );
    _extendedAttributes = Objects.requireNonNull( extendedAttributes );
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
  public Kind getKind()
  {
    return _kind;
  }

  @Nonnull
  public List<ExtendedAttribute> getExtendedAttributes()
  {
    return _extendedAttributes;
  }

  public boolean isNullable()
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
