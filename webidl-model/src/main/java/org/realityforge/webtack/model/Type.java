package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public abstract class Type
{
  @Nonnull
  private final String _name;

  protected Type( @Nonnull final String name )
  {
    _name = Objects.requireNonNull( name );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }
}
