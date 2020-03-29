package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class PromiseType
  extends Type
{
  @Nonnull
  private final Type _resolveType;

  PromiseType( @Nonnull final List<ExtendedAttribute> extendedAttributes, @Nonnull final Type resolveType )
  {
    super( Kind.Promise, extendedAttributes, 0 );
    _resolveType = Objects.requireNonNull( resolveType );
  }

  @Nonnull
  public Type getResolveType()
  {
    return _resolveType;
  }
}
