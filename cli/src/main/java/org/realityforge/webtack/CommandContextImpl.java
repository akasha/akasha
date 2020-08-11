package org.realityforge.webtack;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.mdn_scanner.DocRepositoryRuntime;
import org.realityforge.webtack.model.tools.repository.config.RepositoryConfig;

final class CommandContextImpl
  implements Command.Context
{
  @Nonnull
  private final Environment _environment;
  @Nonnull
  private final DocRepositoryRuntime _docRuntime;

  CommandContextImpl( @Nonnull final Environment environment )
  {
    _environment = Objects.requireNonNull( environment );
    _docRuntime = new DocRepositoryRuntime( _environment.docDirectory() );
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

  @Nonnull
  @Override
  public DocRepositoryRuntime docRuntime()
  {
    return _docRuntime;
  }
}
