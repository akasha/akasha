package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class TypedefDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Type _type;

  TypedefDefinition( @Nonnull final String name,
                     @Nonnull final Type type,
                     @Nonnull final List<ExtendedAttribute> extendedAttributes,
                     @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
    _type = Objects.requireNonNull( type );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public Type getType()
  {
    return _type;
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
      final TypedefDefinition that = (TypedefDefinition) o;
      return _name.equals( that._name ) && _type.equals( that._type );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _name, _type );
  }

  public boolean equiv( @Nonnull final TypedefDefinition other )
  {
    return super.equiv( other ) && _name.equals( other._name ) && _type.equiv( other._type );
  }
}
