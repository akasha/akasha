package org.realityforge.webtack.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class NamespaceDefinition
  extends NamedDefinition
  implements ConstantMemberContainer, AttributeMemberContainer, OperationMemberContainer
{
  @Nonnull
  private final List<ConstMember> _constants;
  @Nonnull
  private final List<OperationMember> _operations;
  @Nonnull
  private final List<AttributeMember> _attributes;

  public NamespaceDefinition( @Nonnull final String name,
                              @Nonnull final List<ConstMember> constants,
                              @Nonnull final List<OperationMember> operations,
                              @Nonnull final List<AttributeMember> attributes,
                              @Nullable final DocumentationElement documentation,
                              @Nonnull final List<ExtendedAttribute> extendedAttributes,
                              @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, documentation, extendedAttributes, sourceLocations );
    _constants = Objects.requireNonNull( constants );
    _operations = Objects.requireNonNull( operations );
    _attributes = Objects.requireNonNull( attributes );
  }

  @Nonnull
  @Override
  public List<ConstMember> getConstants()
  {
    return _constants;
  }

  @Nonnull
  @Override
  public List<OperationMember> getOperations()
  {
    return _operations;
  }

  @Nonnull
  public List<AttributeMember> getAttributes()
  {
    return _attributes;
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
      final NamespaceDefinition other = (NamespaceDefinition) o;
      return getName().equals( other.getName() ) &&
             _constants.equals( other._constants ) &&
             _operations.equals( other._operations ) &&
             _attributes.equals( other._attributes );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _constants, _operations, _attributes );
  }

  public boolean equiv( @Nonnull final NamespaceDefinition other )
  {
    if ( super.equiv( other ) &&
         _constants.size() == other._constants.size() &&
         _operations.size() == other._operations.size() &&
         _attributes.size() == other._attributes.size() )
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
}
