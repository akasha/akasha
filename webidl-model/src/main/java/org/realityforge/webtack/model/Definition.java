package org.realityforge.webtack.model;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class Definition
  extends Element
{
  Definition( @Nullable final DocumentationElement documentation,
              @Nonnull final List<ExtendedAttribute> extendedAttributes,
              @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( documentation, extendedAttributes, sourceLocations );
  }
}
