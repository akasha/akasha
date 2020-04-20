package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;

public final class AttributeMember
  extends NamedElement
  implements Member
{
  @Nonnull
  private final Type _type;
  @Nonnull
  private final Set<Modifier> _modifiers;

  AttributeMember( @Nonnull final String name,
                   @Nonnull final Type type,
                   @Nonnull final Set<Modifier> modifiers,
                   @Nonnull final List<ExtendedAttribute> extendedAttributes,
                   @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, extendedAttributes, sourceLocations );
    _type = Objects.requireNonNull( type );
    _modifiers = Objects.requireNonNull( modifiers );
  }

  @Nonnull
  public Type getType()
  {
    return _type;
  }

  @Nonnull
  public Set<Modifier> getModifiers()
  {
    return _modifiers;
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
      final AttributeMember that = (AttributeMember) o;
      return _type.equals( that._type ) &&
             _modifiers.equals( that._modifiers );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _type, _modifiers );
  }

  public boolean equiv( @Nonnull final AttributeMember other )
  {
    return super.equiv( other ) &&
           _modifiers.equals( other._modifiers ) &&
           _type.equiv( other._type );
  }

  public int orderId()
  {
    final boolean isStatic = getModifiers().contains( Modifier.STATIC );
    final boolean isReadOnly = getModifiers().contains( Modifier.READ_ONLY );
    if ( isStatic )
    {
      return isReadOnly ? 1 : 2;
    }
    else
    {
      final boolean isInherit = getModifiers().contains( Modifier.INHERIT );
      if ( isInherit )
      {
        return isReadOnly ? 3 : 4;
      }
      final boolean isStringifier = getModifiers().contains( Modifier.STRINGIFIER );
      if ( !isStringifier )
      {
        return isReadOnly ? 5 : 6;
      }
      else
      {
        return isReadOnly ? 7 : 8;
      }
    }
  }

  public enum Modifier
  {
    STATIC,
    READ_ONLY,
    INHERIT,
    STRINGIFIER
  }
}
