package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Argument
  extends NamedElement
{
  @Nonnull
  private final Type _type;
  private final boolean _optional;
  private final boolean _variadic;
  @Nullable
  private final DefaultValue _defaultValue;

  public Argument( @Nonnull final String name,
                   @Nonnull final Type type,
                   final boolean optional,
                   final boolean variadic,
                   @Nullable final DefaultValue defaultValue,
                   @Nonnull final List<ExtendedAttribute> extendedAttributes,
                   @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, extendedAttributes, sourceLocations );
    assert !optional || !variadic;
    assert optional || null == defaultValue;
    assert !optional || extendedAttributes.isEmpty();
    _type = Objects.requireNonNull( type );
    _optional = optional;
    _variadic = variadic;
    _defaultValue = defaultValue;
  }

  @Nonnull
  public Type getType()
  {
    return _type;
  }

  public boolean isOptional()
  {
    return _optional;
  }

  public boolean isVariadic()
  {
    return _variadic;
  }

  @Nullable
  public DefaultValue getDefaultValue()
  {
    return _defaultValue;
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
      final Argument argument = (Argument) o;
      return _optional == argument._optional &&
             _variadic == argument._variadic &&
             _type.equals( argument._type ) &&
             Objects.equals( _defaultValue, argument._defaultValue );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _type, _optional, _variadic, _defaultValue );
  }

  public boolean equiv( @Nonnull final Argument other )
  {
    return super.equiv( other ) &&
           _optional == other._optional &&
           _variadic == other._variadic &&
           _type.equals( other._type ) &&
           Objects.equals( _defaultValue, other._defaultValue );
  }

  static boolean argumentListEquiv( @Nonnull final List<Argument> arguments1, @Nonnull final List<Argument> arguments2 )
  {
    final int size = arguments1.size();
    if ( arguments2.size() != size )
    {
      return false;
    }
    else
    {
      for ( int i = 0; i < size; i++ )
      {
        if ( !arguments1.get( i ).equiv( arguments2.get( i ) ) )
        {
          return false;
        }
      }
      return true;
    }
  }
}
