package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class SequenceType
  extends Type
{
  @Nonnull
  private final Type _itemType;

  SequenceType( @Nonnull final Type itemType,
                @Nonnull final List<ExtendedAttribute> extendedAttributes,
                final boolean nullable,
                @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( Kind.Sequence, extendedAttributes, nullable, sourceLocations );
    _itemType = Objects.requireNonNull( itemType );
  }

  @Nonnull
  public Type getItemType()
  {
    return _itemType;
  }
}
