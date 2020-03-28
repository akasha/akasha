package org.realityforge.webtack.model;

import javax.annotation.Nonnull;

public final class ObjectType
  extends Type
{
  @Nonnull
  public static final ObjectType OBJECT = new ObjectType( "object", false );
  @Nonnull
  public static final ObjectType NULLABLE_OBJECT = new ObjectType( "object", true );

  private ObjectType( @Nonnull final String name, final boolean nullable )
  {
    super( name, nullable );
  }
}
