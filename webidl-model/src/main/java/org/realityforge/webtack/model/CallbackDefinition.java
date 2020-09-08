package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class CallbackDefinition
  extends NamedDefinition
{
  @Nonnull
  private final Type _returnType;
  @Nonnull
  private final List<Argument> _arguments;

  public CallbackDefinition( @Nonnull final String name,
                             @Nonnull final Type returnType,
                             @Nonnull final List<Argument> arguments,
                             @Nullable final DocumentationElement documentation,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes,
                             @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, documentation, extendedAttributes, sourceLocations );
    _returnType = Objects.requireNonNull( returnType );
    _arguments = Objects.requireNonNull( arguments );
  }

  @Nonnull
  public Type getReturnType()
  {
    return _returnType;
  }

  @Nonnull
  public List<Argument> getArguments()
  {
    return _arguments;
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
      final CallbackDefinition other = (CallbackDefinition) o;
      return getName().equals( other.getName() ) &&
             _returnType.equals( other._returnType ) &&
             _arguments.equals( other._arguments );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _returnType, _arguments );
  }

  public boolean equiv( @Nonnull final CallbackDefinition other )
  {
    return super.equiv( other ) &&
           _returnType.equiv( other._returnType ) &&
           Argument.argumentListEquiv( _arguments, other._arguments );
  }
}
