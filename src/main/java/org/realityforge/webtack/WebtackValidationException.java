package org.realityforge.webtack;

import javax.annotation.Nonnull;

public final class WebtackValidationException
  extends WebtackException
{
  public WebtackValidationException( @Nonnull final String message )
  {
    super( message );
  }

  public WebtackValidationException( @Nonnull final String message, @Nonnull final Throwable cause )
  {
    super( message, cause );
  }
}
