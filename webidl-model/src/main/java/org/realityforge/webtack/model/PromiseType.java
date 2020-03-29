package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public final class PromiseType
  extends Type
{
  @Nonnull
  private final Type _resolveType;

  PromiseType( @Nonnull final Type resolveType )
  {
    super( Kind.Promise );
    _resolveType = Objects.requireNonNull( resolveType );
  }

  @Nonnull
  public Type getResolveType()
  {
    return _resolveType;
  }
}
