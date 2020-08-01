package org.realityforge.webtack.model.tools.mdn_scanner;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.repository.config.DocSourceConfig;

public final class SourceFetchException
  extends DocException
{
  @Nonnull
  private final DocSourceConfig _source;

  public SourceFetchException( @Nonnull final DocSourceConfig source, @Nonnull final Throwable cause )
  {
    super( cause );
    _source = Objects.requireNonNull( source );
  }

  @Nonnull
  public DocSourceConfig getSource()
  {
    return _source;
  }
}
