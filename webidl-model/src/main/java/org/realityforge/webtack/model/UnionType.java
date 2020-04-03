package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class UnionType
  extends Type
{
  @Nonnull
  private final List<Type> _memberTypes;

  UnionType( @Nonnull final List<Type> memberTypes,
             @Nonnull final List<ExtendedAttribute> extendedAttributes,
             final boolean nullable )
  {
    super( Kind.Union, extendedAttributes, nullable );
    _memberTypes = Objects.requireNonNull( memberTypes );
  }

  @Nonnull
  public List<Type> getMemberTypes()
  {
    return _memberTypes;
  }
}
