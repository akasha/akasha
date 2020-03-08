package org.realityforge.webtack;

import java.util.Objects;
import javax.annotation.Nonnull;

final class CommandContextImpl
  implements Command.Context
{
  @Nonnull
  private final Environment _environment;

  CommandContextImpl( @Nonnull final Environment environment )
  {
    _environment = Objects.requireNonNull( environment );
  }

  @Nonnull
  @Override
  public Environment environment()
  {
    return _environment;
  }
}
