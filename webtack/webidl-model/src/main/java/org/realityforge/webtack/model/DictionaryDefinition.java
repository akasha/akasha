package org.realityforge.webtack.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class DictionaryDefinition
  extends NamedDefinition
{
  @Nullable
  private final String _inherits;
  @Nonnull
  private final List<DictionaryMember> _members;
  private boolean _linked;
  @Nullable
  private DictionaryDefinition _superDictionary;
  @Nonnull
  private final List<DictionaryDefinition> _directSubDictionary = new ArrayList<>();

  public DictionaryDefinition( @Nonnull final String name,
                               @Nullable final String inherits,
                               @Nonnull final List<DictionaryMember> members,
                               @Nullable final DocumentationElement documentation,
                               @Nonnull final List<ExtendedAttribute> extendedAttributes,
                               @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, documentation, extendedAttributes, sourceLocations );
    _inherits = inherits;
    _members = Objects.requireNonNull( members );
  }

  @Nullable
  public String getInherits()
  {
    return _inherits;
  }

  @Nonnull
  public List<DictionaryMember> getMembers()
  {
    return _members;
  }

  @Nullable
  public DictionaryDefinition getSuperDictionary()
  {
    assert _linked;
    assert null == _inherits || null != _superDictionary;
    return _superDictionary;
  }

  @Nonnull
  public List<DictionaryDefinition> getDirectSubDictionary()
  {
    assert _linked;
    return _directSubDictionary;
  }

  void link( @Nonnull final WebIDLSchema schema )
  {
    if ( null != _inherits )
    {
      _superDictionary = schema.getDictionaryByName( _inherits );
      _superDictionary._directSubDictionary.add( this );
    }
    _linked = true;
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
      final DictionaryDefinition other = (DictionaryDefinition) o;
      return getName().equals( other.getName() ) &&
             Objects.equals( _inherits, other._inherits ) &&
             _members.equals( other._members );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _inherits, _members );
  }

  public boolean equiv( @Nonnull final DictionaryDefinition other )
  {
    if ( super.equiv( other ) &&
         Objects.equals( _inherits, other._inherits ) &&
         _members.size() == other._members.size() )
    {
      final Set<DictionaryMember> otherMembers = new HashSet<>( other._members );
      for ( final DictionaryMember member : _members )
      {
        if ( !otherMembers.removeIf( member::equiv ) )
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
