package org.realityforge.webtack.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;

public abstract class AttributedNode
  extends Node
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
  public final List<ExtendedAttribute> getExtendedAttributes()
  {
    return _extendedAttributes;
  }

  public final boolean isNoArgsExtendedAttributePresent( @Nonnull final String name )
  {
    return _extendedAttributes
      .stream()
      .filter( a -> ExtendedAttribute.Kind.NO_ARGS == a.getKind() )
      .anyMatch( a -> name.equals( a.getName() ) );
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

  @SuppressWarnings( "BooleanMethodIsAlwaysInverted" )
  boolean equiv( @Nonnull final AttributedNode other )
  {
    final List<ExtendedAttribute> otherAttributes = other.getExtendedAttributes();
    if ( otherAttributes.size() != _extendedAttributes.size() )
    {
      return false;
    }
    else
    {
      final Set<ExtendedAttribute> otherAttr = new HashSet<>( otherAttributes );
      for ( final ExtendedAttribute extendedAttribute : _extendedAttributes )
      {
        if ( !otherAttr.removeIf( extendedAttribute::equiv ) )
        {
          return false;
        }
      }
      return true;
    }
  }
}
