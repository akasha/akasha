package org.realityforge.webtack.model.tools.mdn_scanner.config2;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.tools.mdn_scanner.DocException;

public abstract class IndexException
  extends DocException
{
  public IndexException()
  {
  }

  public IndexException( @Nonnull final String message )
  {
    super( message );
  }

  public IndexException( @Nonnull final String message, @Nonnull final Throwable cause )
  {
    super( message, cause );
  }

  public IndexException( @Nonnull final Throwable cause )
  {
    super( cause );
  }
}
