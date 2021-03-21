package org.realityforge.webtack;

import java.util.Objects;
import javax.annotation.Nonnull;

public class WebtackException
  extends RuntimeException
{
  public WebtackException( @Nonnull final String message )
  {
    super( Objects.requireNonNull( message ) );
  }

  public WebtackException( @Nonnull final String message, @Nonnull final Throwable cause )
  {
    super( Objects.requireNonNull( message ), Objects.requireNonNull( cause ) );
  }
}
