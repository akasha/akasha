package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class TypedefDefinition
  extends NamedDefinition
{
  @Nonnull
  private final Type _type;

  public TypedefDefinition( @Nonnull final String name,
                            @Nonnull final Type type,
                            @Nullable final DocumentationElement documentation,
                            @Nonnull final List<ExtendedAttribute> extendedAttributes,
                            @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, documentation, extendedAttributes, sourceLocations );
    _type = Objects.requireNonNull( type );
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
      final TypedefDefinition other = (TypedefDefinition) o;
      return getName().equals( other.getName() ) && _type.equals( other._type );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _type );
  }

  public boolean equiv( @Nonnull final TypedefDefinition other )
  {
    return super.equiv( other ) && _type.equiv( other._type );
  }
}
