package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public final class NamespaceDefinition
  extends Definition
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final List<OperationMember> _operations;
  @Nonnull
  private final List<AttributeMember> _attributes;

  NamespaceDefinition( @Nonnull final String name,
                       @Nonnull final List<OperationMember> operations,
                       @Nonnull final List<AttributeMember> attributes,
                       @Nonnull final List<ExtendedAttribute> extendedAttributes,
                       @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
    _operations = Objects.requireNonNull( operations );
    _attributes = Objects.requireNonNull( attributes );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public List<OperationMember> getOperations()
  {
    return _operations;
  }

  @Nonnull
  public List<AttributeMember> getAttributes()
  {
    return _attributes;
  }
}
