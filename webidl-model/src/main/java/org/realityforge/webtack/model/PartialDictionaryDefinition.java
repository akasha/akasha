package org.realityforge.webtack.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;

public final class PartialDictionaryDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final List<DictionaryMember> _members;

  PartialDictionaryDefinition( @Nonnull final String name,
                               @Nonnull final List<DictionaryMember> members,
                               @Nonnull final List<ExtendedAttribute> extendedAttributes,
                               @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
    _members = Objects.requireNonNull( members );
  }

  @Nonnull
  public String getName()
  {
    return _name;
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
      final PartialDictionaryDefinition other = (PartialDictionaryDefinition) o;
      return _name.equals( other._name ) &&
             _members.equals( other._members );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _name, _members );
  }

  public boolean equiv( @Nonnull final PartialDictionaryDefinition other )
  {
    if ( super.equiv( other ) &&
         _name.equals( other._name ) &&
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
