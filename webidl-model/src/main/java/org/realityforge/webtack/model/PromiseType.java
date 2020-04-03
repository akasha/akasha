package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class PromiseType
  extends Type
{
  @Nonnull
  private final Type _resolveType;

  PromiseType( @Nonnull final Type resolveType, @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    super( Kind.Promise, extendedAttributes, false );
    _resolveType = Objects.requireNonNull( resolveType );
  }

  @Nonnull
  public Type getResolveType()
  {
    return _resolveType;
  }
}
