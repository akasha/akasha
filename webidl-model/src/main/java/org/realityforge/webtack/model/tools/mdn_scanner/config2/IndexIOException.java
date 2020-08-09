package org.realityforge.webtack.model.tools.mdn_scanner.config2;

import javax.annotation.Nonnull;

public final class IndexIOException
  extends IndexException
{
  public IndexIOException( @Nonnull final String message,
                           @Nonnull final Throwable cause )
  {
    super( message, cause );
  }
}
