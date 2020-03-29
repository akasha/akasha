package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public final class EnumerationType
  extends Type
{
  @Nonnull
  private final String _enumerationName;

  EnumerationType( @Nonnull final String enumerationName, final int flags )
  {
    super( Kind.Enumeration, flags );
    _enumerationName = Objects.requireNonNull( enumerationName );
  }

  @Nonnull
  public String getEnumerationName()
  {
    return _enumerationName;
  }
}
