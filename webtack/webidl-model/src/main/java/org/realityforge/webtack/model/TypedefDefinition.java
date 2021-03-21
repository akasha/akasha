package org.realityforge.webtack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.tools.util.ExtendedAttributes;

public final class TypedefDefinition
  extends NamedDefinition
{
  @Nonnull
  private final Type _type;
  @Nonnull
  private final List<TypedefDefinition> _markerTypes = new ArrayList<>();
  private boolean _linked;

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

  @Nonnull
  public List<TypedefDefinition> getMarkerTypes()
  {
    assert _linked;
    return _markerTypes;
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

  void link( @Nonnull final WebIDLSchema schema )
  {
    if ( Kind.Union == _type.getKind() && isNoArgsExtendedAttributePresent( ExtendedAttributes.MARKER_TYPE ) )
    {
      final UnionType unionType = (UnionType) _type;
      for ( final Type memberType : unionType.getMemberTypes() )
      {
        assert Kind.TypeReference == memberType.getKind();
        final String name = ( (TypeReference) memberType ).getName();

        final TypedefDefinition typedef = schema.findTypedefByName( name );
        if ( null != typedef )
        {
          typedef.addMarkerType( this );
        }
        else
        {
          schema.getInterfaceByName( name ).addMarkerType( this );
        }
      }
    }
    _linked = true;
  }

  void addMarkerType( @Nonnull final TypedefDefinition definition )
  {
    _markerTypes.add( definition );
  }
}
