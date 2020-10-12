package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class ConstEnumerationDefinition
  extends NamedDefinition
{
  @Nonnull
  private final List<ConstEnumerationValue> _values;

  public ConstEnumerationDefinition( @Nonnull final String name,
                                     @Nonnull final List<ConstEnumerationValue> values,
                                     @Nullable final DocumentationElement documentation,
                                     @Nonnull final List<ExtendedAttribute> extendedAttributes,
                                     @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, documentation, extendedAttributes, sourceLocations );
    _values = Objects.requireNonNull( values );
  }

  @Nonnull
  public List<ConstEnumerationValue> getValues()
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
      final ConstEnumerationDefinition other = (ConstEnumerationDefinition) o;
      return getName().equals( other.getName() ) && _values.equals( other._values );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _values );
  }

  public boolean equiv( @Nonnull final ConstEnumerationDefinition other )
  {
    if ( super.equiv( other ) && _values.size() == other._values.size() )
    {
      int index = 0;
      for ( final ConstEnumerationValue value : _values )
      {
        if ( !value.equiv( other.getValues().get( index++ ) ) )
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
