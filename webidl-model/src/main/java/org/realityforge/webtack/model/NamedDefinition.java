package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class NamedDefinition
  extends Definition
{
  @Nonnull
  private final String _name;

  protected NamedDefinition( @Nonnull final String name,
                             @Nullable final DocumentationElement documentation,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes,
                             @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( documentation, extendedAttributes, sourceLocations );
    _name = Objects.requireNonNull( name );
  }

  @Nonnull
  public final String getName()
  {
    return _name;
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( super.hashCode(), getName() );
  }

  public boolean equiv( @Nonnull final NamedDefinition other )
  {
    return super.equiv( other ) && _name.equals( other._name );
  }
}
