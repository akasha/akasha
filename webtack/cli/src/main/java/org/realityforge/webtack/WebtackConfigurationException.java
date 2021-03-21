package org.realityforge.webtack;

import javax.annotation.Nonnull;

public final class WebtackConfigurationException
  extends WebtackException
{
  public WebtackConfigurationException( @Nonnull final String message )
  {
    super( message );
  }

  public WebtackConfigurationException( @Nonnull final String message, @Nonnull final Throwable cause )
  {
    super( message, cause );
  }
}
