package org.realityforge.webtack.model.tools.mdn_scanner;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.repository.config.DocSourceConfig;

public final class SourceWriteException
  extends DocException
{
  @Nonnull
  private final DocSourceConfig _source;

  public SourceWriteException( @Nonnull final DocSourceConfig source,
                               @Nonnull final String message,
                               @Nonnull final Throwable cause )
  {
    super( message, cause );
    _source = Objects.requireNonNull( source );
  }

  @Nonnull
  public DocSourceConfig getSource()
  {
    return _source;
  }
}
