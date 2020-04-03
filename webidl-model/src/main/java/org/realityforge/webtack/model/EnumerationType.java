package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class EnumerationType
  extends Type
{
  @Nonnull
  private final String _name;

  EnumerationType( @Nonnull final String name,
                   @Nonnull final List<ExtendedAttribute> extendedAttributes,
                   final int flags )
  {
    super( Kind.Enumeration, extendedAttributes, flags );
    _name = Objects.requireNonNull( name );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }
}
