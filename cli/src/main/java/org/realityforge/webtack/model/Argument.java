package org.realityforge.webtack.model;

import javax.annotation.Nonnull;

public final class Argument
{
  @Nonnull
  private final String _name;

  public Argument( @Nonnull final String name )
  {
    _name = name;
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }
}
