package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public abstract class Element
  extends Node
{
  @Nonnull
  private final List<ExtendedAttribute> _extendedAttributes;

  Element( @Nonnull final List<ExtendedAttribute> extendedAttributes,
           @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( sourceLocations );
    _extendedAttributes = Objects.requireNonNull( extendedAttributes );
  }

  @Nonnull
  public final List<ExtendedAttribute> getExtendedAttributes()
  {
    return _extendedAttributes;
  }
}
