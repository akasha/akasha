package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class MixinDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final List<ConstMember> _constants;
  @Nonnull
  private final List<AttributeMember> _attributes;
  @Nonnull
  private final List<OperationMember> _operations;

  MixinDefinition( @Nonnull final String name,
                   @Nonnull final List<ConstMember> constants,
                   @Nonnull final List<AttributeMember> attributes,
                   @Nonnull final List<OperationMember> operations,
                   @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    super( extendedAttributes );
    _name = Objects.requireNonNull( name );
    _constants = Objects.requireNonNull( constants );
    _attributes = Objects.requireNonNull( attributes );
    _operations = Objects.requireNonNull( operations );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public List<ConstMember> getConstants()
  {
    return _constants;
  }

  @Nonnull
  public List<AttributeMember> getAttributes()
  {
    return _attributes;
  }

  @Nonnull
  public List<OperationMember> getOperations()
  {
    return _operations;
  }
}
