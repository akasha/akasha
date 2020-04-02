package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class DictionaryMember
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Type _type;
  private final boolean _optional;
  @Nullable
  private final DefaultValue _defaultValue;
  @Nonnull
  private final List<ExtendedAttribute> _extendedAttributes;

  DictionaryMember( @Nonnull final String name,
                    @Nonnull final Type type,
                    final boolean optional,
                    @Nullable final DefaultValue defaultValue,
                    @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    assert optional || extendedAttributes.isEmpty();
    assert optional || null == defaultValue;

    _name = Objects.requireNonNull( name );
    _type = Objects.requireNonNull( type );
    _optional = optional;
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
