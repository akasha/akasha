package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;

public final class EnumerationDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Set<String> _values;

  EnumerationDefinition( @Nonnull final String name,
                         @Nonnull final Set<String> values,
                         @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    super( extendedAttributes );
    _name = Objects.requireNonNull( name );
    _values = Objects.requireNonNull( values );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public Set<String> getValues()
  {
    return _values;
  }
}
