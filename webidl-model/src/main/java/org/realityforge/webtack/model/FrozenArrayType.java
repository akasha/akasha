package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class FrozenArrayType
  extends Type
{
  @Nonnull
  private final Type _itemType;

  FrozenArrayType( @Nonnull final List<ExtendedAttribute> extendedAttributes, @Nonnull final Type itemType, final int flags )
  {
    super( Kind.FrozenArray, extendedAttributes, flags );
    _itemType = Objects.requireNonNull( itemType );
  }

  @Nonnull
  public Type getItemType()
  {
    return _itemType;
  }
}
