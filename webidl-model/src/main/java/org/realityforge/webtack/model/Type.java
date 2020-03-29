package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public class Type
{
  @Nonnull
  private final Kind _kind;
  private final int _flags;

  Type( @Nonnull final Kind kind )
  {
    this( kind, 0 );
  }

  Type( @Nonnull final Kind kind, final int flags )
  {
    _kind = Objects.requireNonNull( kind );
    _flags = flags;
    assert _kind.isNullableAllowed() || !isNullable();
  }

  @Nonnull
  public Kind getKind()
  {
    return _kind;
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

    public static final int NULLABLE = 1 << 5;
  }
}
