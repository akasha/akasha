package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public abstract class NamedElement
  extends Element
{
  @Nonnull
  private final String _name;

  protected NamedElement( @Nonnull final String name,
                          @Nonnull final List<ExtendedAttribute> extendedAttributes,
                          @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
  }

  @Nonnull
  public final String getName()
  {
    return _name;
  }
}
