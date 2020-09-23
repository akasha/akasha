package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class NamedElement
  extends Element
  implements Named
{
  @Nonnull
  private final String _name;

  protected NamedElement( @Nonnull final String name,
                          @Nullable final DocumentationElement documentation,
                          @Nonnull final List<ExtendedAttribute> extendedAttributes,
                          @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( documentation, extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
  }

  @Nonnull
  @Override
  public final String getName()
  {
    return _name;
  }

  @Override
  public boolean equals( final Object o )
  {
    if ( this == o )
    {
      return true;
    }
    else if ( o == null || getClass() != o.getClass() || !super.equals( o ) )
    {
      return false;
    }
    else
    {
      final NamedElement other = (NamedElement) o;
      return _name.equals( other._name );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _name );
  }

  @SuppressWarnings( "BooleanMethodIsAlwaysInverted" )
  boolean equiv( @Nonnull final NamedElement other )
  {
    return _name.equals( other._name ) && super.equiv( other );
  }
}
