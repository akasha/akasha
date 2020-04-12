package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public final class SourceInterval
{
  @Nonnull
  private final SourcePosition _start;
  @Nonnull
  private final SourcePosition _stop;

  public SourceInterval( @Nonnull final SourcePosition start, @Nonnull final SourcePosition stop )
  {
    _start = Objects.requireNonNull( start );
    _stop = Objects.requireNonNull( stop );
  }

  @Nonnull
  public SourcePosition getStart()
  {
    return _start;
  }

  @Nonnull
  public SourcePosition getStop()
  {
    return _stop;
  }
}
