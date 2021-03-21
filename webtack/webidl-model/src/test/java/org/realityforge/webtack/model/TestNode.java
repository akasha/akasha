package org.realityforge.webtack.model;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

public final class TestNode
  extends Node
{
  public TestNode()
  {
    this( Collections.emptyList() );
  }

  public TestNode( @Nonnull SourceInterval sourceLocation )
  {
    this( Collections.singletonList( sourceLocation ) );
  }

  public TestNode( @Nonnull final List<SourceInterval> sourceLocations )
  {
    super( sourceLocations );
  }
}
