package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class UnionType
  extends Type
{
  @Nonnull
  private final List<Type> _memberTypes;

  public UnionType( @Nonnull final List<Type> memberTypes,
                    @Nonnull final List<ExtendedAttribute> extendedAttributes,
                    final boolean nullable,
                    @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( Kind.Union, extendedAttributes, nullable, sourceLocations );
    _memberTypes = Objects.requireNonNull( memberTypes );
  }

  @Nonnull
  public List<Type> getMemberTypes()
  {
    return _memberTypes;
  }
}
