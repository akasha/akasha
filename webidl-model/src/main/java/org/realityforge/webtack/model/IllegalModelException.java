package org.realityforge.webtack.model;

import javax.annotation.Nullable;

public class IllegalModelException
  extends RuntimeException
{
  public IllegalModelException( @Nullable final String message )
  {
    super( message );
  }
}
