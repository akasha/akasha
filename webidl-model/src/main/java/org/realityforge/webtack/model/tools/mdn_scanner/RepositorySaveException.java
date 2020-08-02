package org.realityforge.webtack.model.tools.mdn_scanner;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.mdn_scanner.config.DocRepositoryConfig;

public final class RepositorySaveException
  extends DocException
{
  @Nonnull
  private final DocRepositoryConfig _repository;

  public RepositorySaveException( @Nonnull final DocRepositoryConfig repository, @Nonnull final Throwable cause )
  {
    super( cause );
    _repository = Objects.requireNonNull( repository );
  }

  @Nonnull
  public DocRepositoryConfig getRepository()
  {
    return _repository;
  }
}
