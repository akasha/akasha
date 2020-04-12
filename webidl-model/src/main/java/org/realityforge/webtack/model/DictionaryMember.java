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

  DictionaryMember( @Nonnull final String name,
                    @Nonnull final Type type,
                    final boolean optional,
                    @Nullable final DefaultValue defaultValue,
                    @Nonnull final List<ExtendedAttribute> extendedAttributes,
                    @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( name, extendedAttributes, sourceLocations );
    assert optional || extendedAttributes.isEmpty();
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

  @Nullable
  public DefaultValue getDefaultValue()
  {
    return _defaultValue;
  }
}
