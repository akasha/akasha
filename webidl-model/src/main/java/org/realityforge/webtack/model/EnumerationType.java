package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class EnumerationType
  extends Type
{
  @Nonnull
  private final String _enumerationName;

  EnumerationType( @Nonnull final String enumerationName,
                   @Nonnull final List<ExtendedAttribute> extendedAttributes,
                   final int flags )
  {
    super( Kind.Enumeration, extendedAttributes, flags );
    _enumerationName = Objects.requireNonNull( enumerationName );
  }

  @Nonnull
  public String getEnumerationName()
  {
    return _enumerationName;
  }
}
