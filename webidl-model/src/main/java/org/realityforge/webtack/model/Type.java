package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public abstract class Type
{
  @Nonnull
  private final String _typeName;
  private final boolean _nullable;

  protected Type( @Nonnull final String typeName, final boolean nullable )
  {
    _typeName = Objects.requireNonNull( typeName );
    _nullable = nullable;
  }

  @Nonnull
  public String getTypeName()
  {
    return _typeName;
  }

  public boolean isNullable()
  {
    return _nullable;
  }
}
