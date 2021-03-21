package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

public abstract class Node
{
  @Nonnull
  private final List<SourceInterval> _sourceLocations;

  Node( @Nonnull final List<SourceInterval> sourceLocations )
  {
    _sourceLocations = Objects.requireNonNull( sourceLocations );
  }

  @Nonnull
  public final List<SourceInterval> getSourceLocations()
  {
    return _sourceLocations;
  }
}
