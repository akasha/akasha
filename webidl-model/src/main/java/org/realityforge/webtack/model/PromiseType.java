package org.realityforge.webtack.model;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class PromiseType
  extends Type
{
  @Nullable
  private final Type _resolveType;

  PromiseType( @Nonnull final String enumerationName, @Nullable final Type resolveType )
  {
    super( enumerationName, Flags.PROMISE );
    _resolveType = resolveType;
  }

  @Nullable
  public Type getResolveType()
  {
    return _resolveType;
  }
}
