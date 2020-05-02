package org.realityforge.webtack.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class DictionaryDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nullable
  private final String _inherits;
  @Nonnull
  private final List<DictionaryMember> _members;

  public DictionaryDefinition( @Nonnull final String name,
                               @Nullable final String inherits,
                               @Nonnull final List<DictionaryMember> members,
                               @Nonnull final List<ExtendedAttribute> extendedAttributes,
                               @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
    _inherits = inherits;
    _members = Objects.requireNonNull( members );
  }

  @Nonnull
  public String getName()
  {
    return _name;
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
      return _name.equals( other._name ) &&
             Objects.equals( _inherits, other._inherits ) &&
             _members.equals( other._members );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _name, _inherits, _members );
  }

  public boolean equiv( @Nonnull final DictionaryDefinition other )
  {
    if ( super.equiv( other ) &&
         _name.equals( other._name ) &&
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
