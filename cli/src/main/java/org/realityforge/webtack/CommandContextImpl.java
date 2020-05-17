package org.realityforge.webtack;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.repository.config.RepositoryConfig;

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

  @Nonnull
  @Override
  public RepositoryConfig config()
  {
    return Main.loadConfigFile( _environment );
  }
}
