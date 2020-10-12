package org.realityforge.webtack.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class InterfaceDefinition
  extends NamedDefinition
{
  @Nullable
  private final String _inherits;
  @Nonnull
  private final List<ConstMember> _constants;
  @Nonnull
  private final List<AttributeMember> _attributes;
  @Nonnull
  private final List<OperationMember> _operations;
  @Nonnull
  private final List<EventMember> _events;
  @Nullable
  private final IterableMember _iterable;
  @Nullable
  private final AsyncIterableMember _asyncIterable;
  @Nullable
  private final MapLikeMember _mapLikeMember;
  @Nullable
  private final SetLikeMember _setLikeMember;
  private boolean _linked;
  @Nullable
  private InterfaceDefinition _superInterface;
  @Nonnull
  private final List<InterfaceDefinition> _directSubInterfaces = new ArrayList<>();

  public InterfaceDefinition( @Nonnull final String name,
                              @Nullable final String inherits,
                              @Nonnull final List<ConstMember> constants,
                              @Nonnull final List<AttributeMember> attributes,
                              @Nonnull final List<OperationMember> operations,
                              @Nonnull final List<EventMember> events,
                              @Nullable final IterableMember iterable,
                              @Nullable final AsyncIterableMember asyncIterable,
                              @Nullable final MapLikeMember mapLikeMember,
                              @Nullable final SetLikeMember setLikeMember,
                              @Nullable final DocumentationElement documentation,
                              @Nonnull final List<ExtendedAttribute> extendedAttributes,
                              @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, documentation, extendedAttributes, sourceLocations );
    _inherits = inherits;
    _constants = Objects.requireNonNull( constants );
    _attributes = Objects.requireNonNull( attributes );
    _operations = Objects.requireNonNull( operations );
    _events = Objects.requireNonNull( events );
    _iterable = iterable;
    _asyncIterable = asyncIterable;
    _mapLikeMember = mapLikeMember;
    _setLikeMember = setLikeMember;
  }

  @Nullable
  public String getInherits()
  {
    return _inherits;
  }

  @Nullable
  public InterfaceDefinition getSuperInterface()
  {
    assert _linked;
    assert null == _inherits || null != _superInterface;
    return _superInterface;
  }

  @Nonnull
  public List<InterfaceDefinition> getDirectSubInterfaces()
  {
    assert _linked;
    return _directSubInterfaces;
  }

  @Nonnull
  public List<ConstMember> getConstants()
  {
    return _constants;
  }

  @Nullable
  public ConstMember findConstantByName( @Nonnull final String name )
  {
    return getConstants().stream().filter( c -> c.getName().equals( name ) ).findFirst().orElse( null );
  }

  @Nonnull
  public ConstMember getConstantByName( @Nonnull final String name )
  {
    return Objects.requireNonNull( findConstantByName( name ), "Missing expected constant with name " + name );
  }

  @Nonnull
  public List<AttributeMember> getAttributes()
  {
    return _attributes;
  }

  @Nonnull
  public List<OperationMember> getOperations()
  {
    return _operations;
  }

  @Nonnull
  public List<EventMember> getEvents()
  {
    return _events;
  }

  @Nullable
  public IterableMember getIterable()
  {
    return _iterable;
  }

  @Nullable
  public AsyncIterableMember getAsyncIterable()
  {
    return _asyncIterable;
  }

  @Nullable
  public MapLikeMember getMapLikeMember()
  {
    return _mapLikeMember;
  }

  @Nullable
  public SetLikeMember getSetLikeMember()
  {
    return _setLikeMember;
  }

  @Nullable
  public String getNamespace()
  {
    return getExtendedAttributes()
      .stream()
      .filter( a -> ExtendedAttribute.Kind.IDENT == a.getKind() && "LegacyNamespace".equals( a.getName() ) )
      .map( ExtendedAttribute::getIdent )
      .findAny()
      .orElse( null );
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
      final InterfaceDefinition other = (InterfaceDefinition) o;
      return getName().equals( other.getName() ) &&
             Objects.equals( _inherits, other._inherits ) &&
             _constants.equals( other._constants ) &&
             _attributes.equals( other._attributes ) &&
             _operations.equals( other._operations ) &&
             Objects.equals( _iterable, other._iterable ) &&
             Objects.equals( _asyncIterable, other._asyncIterable ) &&
             Objects.equals( _mapLikeMember, other._mapLikeMember ) &&
             Objects.equals( _setLikeMember, other._setLikeMember );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(),
                         _inherits,
                         _constants,
                         _attributes,
                         _operations,
                         _iterable,
                         _asyncIterable,
                         _mapLikeMember,
                         _setLikeMember );
  }

  public boolean equiv( @Nonnull final InterfaceDefinition other )
  {
    if ( super.equiv( other ) &&
         Objects.equals( _inherits, other._inherits ) &&
         _constants.size() == other._constants.size() &&
         _attributes.size() == other._attributes.size() &&
         _operations.size() == other._operations.size() &&
         (
           ( null == _iterable && null == other._iterable ) ||
           ( null != _iterable && null != other._iterable && _iterable.equiv( other._iterable ) )
         ) &&
         (
           ( null == _asyncIterable && null == other._asyncIterable ) ||
           ( null != _asyncIterable && null != other._asyncIterable && _asyncIterable.equiv( other._asyncIterable ) )
         ) &&
         (
           ( null == _mapLikeMember && null == other._mapLikeMember ) ||
           ( null != _mapLikeMember && null != other._mapLikeMember && _mapLikeMember.equiv( other._mapLikeMember ) )
         ) &&
         (
           ( null == _setLikeMember && null == other._setLikeMember ) ||
           ( null != _setLikeMember && null != other._setLikeMember && _setLikeMember.equiv( other._setLikeMember ) )
         )
    )
    {
      final Set<ConstMember> otherConstants = new HashSet<>( other._constants );
      for ( final ConstMember member : _constants )
      {
        if ( !otherConstants.removeIf( member::equiv ) )
        {
          return false;
        }
      }
      final Set<AttributeMember> otherAttributes = new HashSet<>( other._attributes );
      for ( final AttributeMember member : _attributes )
      {
        if ( !otherAttributes.removeIf( member::equiv ) )
        {
          return false;
        }
      }
      final Set<OperationMember> otherOperations = new HashSet<>( other._operations );
      for ( final OperationMember member : _operations )
      {
        if ( !otherOperations.removeIf( member::equiv ) )
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

  void link( @Nonnull final WebIDLSchema schema )
  {
    if ( null != _inherits )
    {
      _superInterface = schema.getInterfaceByName( _inherits );
      _superInterface._directSubInterfaces.add( this );
    }
    _linked = true;
  }
}
