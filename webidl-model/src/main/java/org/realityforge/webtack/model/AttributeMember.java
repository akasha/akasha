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

  public enum Modifier
  {
    READ_ONLY,
    STRINGIFIER,
    STATIC,
    INHERIT
  }
}
