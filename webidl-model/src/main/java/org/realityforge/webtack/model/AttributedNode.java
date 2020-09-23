package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public abstract class AttributedNode
  extends Node
  implements Attributed
{
  @Nonnull
  private final List<ExtendedAttribute> _extendedAttributes;

  AttributedNode( @Nonnull final List<ExtendedAttribute> extendedAttributes,
                  @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( sourceLocations );
    _extendedAttributes = Objects.requireNonNull( extendedAttributes );
  }

  @Nonnull
  @Override
  public final List<ExtendedAttribute> getExtendedAttributes()
  {
    return _extendedAttributes;
  }

  @Override
  public boolean equals( final Object o )
  {
    if ( this == o )
    {
      return true;
    }
    else if ( o == null || getClass() != o.getClass() )
    {
      return false;
    }
    else
    {
      final AttributedNode element = (AttributedNode) o;
      return _extendedAttributes.equals( element._extendedAttributes );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( _extendedAttributes );
  }
}
