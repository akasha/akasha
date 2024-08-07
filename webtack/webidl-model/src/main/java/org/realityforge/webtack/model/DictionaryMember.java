package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class DictionaryMember
  extends NamedElement
{
  @Nonnull
  private final Type _type;
  private final boolean _optional;
  @Nullable
  private final DefaultValue _defaultValue;

  public DictionaryMember( @Nonnull final String name,
                           @Nonnull final Type type,
                           final boolean optional,
                           @Nullable final DefaultValue defaultValue,
                           @Nullable final DocumentationElement documentation,
                           @Nonnull final List<ExtendedAttribute> extendedAttributes,
                           @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, documentation, extendedAttributes, sourceLocations );
    assert optional || null == defaultValue;
    _type = Objects.requireNonNull( type );
    _optional = optional;
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

  public boolean isRequired()
  {
    return !isOptional();
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
      final DictionaryMember other = (DictionaryMember) o;
      return _optional == other._optional &&
             _type.equals( other._type ) &&
             Objects.equals( _defaultValue, other._defaultValue );
    }
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), _type, _optional, _defaultValue );
  }

  public boolean equiv( @Nonnull final DictionaryMember other )
  {
    return super.equiv( other ) &&
           _optional == other._optional &&
           _type.equiv( other._type ) &&
           (
             ( null == _defaultValue && null == other._defaultValue ) ||
             ( null != _defaultValue && null != other._defaultValue && _defaultValue.equiv( other._defaultValue ) )
           );
  }
}
