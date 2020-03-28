package org.realityforge.webtack.model;

import javax.annotation.Nonnull;

public abstract class NullableType
  extends Type
{
  protected NullableType( @Nonnull final String name )
  {
    super( name );
  }
}
