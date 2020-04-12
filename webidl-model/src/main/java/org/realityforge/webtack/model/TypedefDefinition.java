package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class TypedefDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Type _type;

  TypedefDefinition( @Nonnull final String name,
                     @Nonnull final Type type,
                     @Nonnull final List<ExtendedAttribute> extendedAttributes,
                     @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
    _type = Objects.requireNonNull( type );
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
}
