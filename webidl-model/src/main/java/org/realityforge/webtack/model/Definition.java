package org.realityforge.webtack.model;

import java.util.List;
import javax.annotation.Nonnull;

public abstract class Definition
  extends Element
{
  Definition( @Nonnull final List<ExtendedAttribute> extendedAttributes,
              @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
  }
}
