package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class AttributeMember
  extends Member
{
  @Nonnull
  private final Type _type;

  AttributeMember( @Nonnull final String name,
                   @Nonnull final Type type,
                   @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    super( name, extendedAttributes );
    _type = Objects.requireNonNull( type );
  }

  @Nonnull
  public Type getType()
  {
    return _type;
  }
}
