package org.realityforge.webtack.model.tools.repository.config;

import javax.annotation.Nullable;

public class IllegalConfigException
  extends RuntimeException
{
  public IllegalConfigException( @Nullable final String message )
  {
    super( message );
  }
}
