package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class FrozenArrayType
  extends Type
{
  @Nonnull
  private final Type _itemType;

  FrozenArrayType( @Nonnull final Type itemType,
                   @Nonnull final List<ExtendedAttribute> extendedAttributes,
                   final boolean nullable,
                   @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( Kind.FrozenArray, extendedAttributes, nullable, sourceLocations );
    _itemType = Objects.requireNonNull( itemType );
  }

  @Nonnull
  public Type getItemType()
  {
    return _itemType;
  }
}
