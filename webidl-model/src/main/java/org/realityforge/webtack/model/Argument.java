package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class Argument
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Type _type;
  private final boolean _optional;
  private final boolean _variadic;
  @Nullable
  private final DefaultValue _defaultValue;
  @Nonnull
  private final List<ExtendedAttribute> _extendedAttributes;

  public Argument( @Nonnull final String name,
                   @Nonnull final Type type,
                   final boolean optional,
                   final boolean variadic,
                   @Nullable final DefaultValue defaultValue,
                   @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    assert !optional || !variadic;
    assert optional || null == defaultValue;
    assert !optional || extendedAttributes.isEmpty();
    _name = Objects.requireNonNull( name );
    _type = Objects.requireNonNull( type );
    _optional = optional;
    _variadic = variadic;
    _defaultValue = defaultValue;
    _extendedAttributes = Objects.requireNonNull( extendedAttributes );
  }

  @Nonnull
  public String getName()
  {
    return _name;
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

  @Nonnull
  public List<ExtendedAttribute> getExtendedAttributes()
  {
    return _extendedAttributes;
  }
}
