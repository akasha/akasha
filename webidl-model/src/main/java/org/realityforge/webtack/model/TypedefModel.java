package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public final class TypedefModel
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Type _type;

  TypedefModel( @Nonnull final String name, @Nonnull final Type type )
  {
    _name = Objects.requireNonNull( name );
    _type = Objects.requireNonNull( type );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public Type getType()
  {
    return _type;
  }
}
