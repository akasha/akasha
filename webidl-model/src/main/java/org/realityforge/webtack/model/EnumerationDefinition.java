package org.realityforge.webtack.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;

public final class EnumerationDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Set<String> _values;

  public EnumerationDefinition( @Nonnull final String name,
                                @Nonnull final Set<String> values,
                                @Nonnull final List<ExtendedAttribute> extendedAttributes,
                                @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
    _values = Objects.requireNonNull( values );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public Set<String> getValues()
  {
    return _values;
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
      final EnumerationDefinition other = (EnumerationDefinition) o;
      return _name.equals( other._name ) && _values.equals( other._values );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _name, _values );
  }

  public boolean equiv( @Nonnull final EnumerationDefinition other )
  {
    if ( super.equiv( other ) &&
         _name.equals( other._name ) &&
         _values.size() == other._values.size() )
    {
      final Set<String> otherValues = new HashSet<>( other._values );
      for ( final String value : _values )
      {
        if ( !otherValues.remove( value ) )
        {
          return false;
        }
      }
      return true;
    }
    else
    {
      return false;
    }
  }
}
