package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class OperationMember
  extends Element
  implements Member
{
  @Nonnull
  private final Kind _kind;
  @Nullable
  private final String _name;
  @Nonnull
  private final List<Argument> _arguments;
  @Nonnull
  private final Type _returnType;

  public OperationMember( @Nonnull final Kind kind,
                          @Nullable final String name,
                          @Nonnull final List<Argument> arguments,
                          @Nonnull final Type returnType,
                          @Nonnull final List<ExtendedAttribute> extendedAttributes,
                          @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _kind = Objects.requireNonNull( kind );
    _name = name;
    _arguments = Objects.requireNonNull( arguments );
    _returnType = Objects.requireNonNull( returnType );
  }

  @Nonnull
  public Kind getKind()
  {
    return _kind;
  }

  @Nullable
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public List<Argument> getArguments()
  {
    return _arguments;
  }

  @Nonnull
  public Type getReturnType()
  {
    return _returnType;
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
      final OperationMember that = (OperationMember) o;
      return _kind == that._kind &&
             Objects.equals( _name, that._name ) &&
             _arguments.equals( that._arguments ) &&
             _returnType.equals( that._returnType );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _kind, _name, _arguments, _returnType );
  }

  public boolean equiv( @Nonnull final OperationMember other )
  {
    return super.equiv( other ) &&
           _kind == other._kind &&
           Objects.equals( _name, other._name ) &&
           Argument.argumentListEquiv( _arguments, other._arguments ) &&
           _returnType.equiv( other._returnType );
  }

  public enum Kind
  {
    STATIC,
    CONSTRUCTOR,
    DEFAULT,
    GETTER,
    SETTER,
    DELETER,
    STRINGIFIER
  }
}
