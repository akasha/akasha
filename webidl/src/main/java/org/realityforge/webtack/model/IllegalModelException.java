package org.realityforge.webtack.model;

import javax.annotation.Nullable;

public class IllegalModelException
  extends RuntimeException
{
  public IllegalModelException()
  {
  }

  public IllegalModelException( @Nullable final String message )
  {
    super( message );
  }

  public IllegalModelException( @Nullable final String message, @Nullable final Throwable cause )
  {
    super( message, cause );
  }

  public IllegalModelException( @Nullable final Throwable cause )
  {
    super( cause );
  }
}
