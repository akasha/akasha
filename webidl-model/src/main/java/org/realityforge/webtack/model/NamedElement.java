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
      final NamedElement that = (NamedElement) o;
      return _name.equals( that._name );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _name );
  }
}
