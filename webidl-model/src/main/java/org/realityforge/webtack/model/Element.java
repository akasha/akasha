package org.realityforge.webtack.model;

import java.util.List;
import javax.annotation.Nonnull;

public abstract class Element
  extends AttributedNode
{
  Element( @Nonnull final List<ExtendedAttribute> extendedAttributes,
           @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
  }
}
