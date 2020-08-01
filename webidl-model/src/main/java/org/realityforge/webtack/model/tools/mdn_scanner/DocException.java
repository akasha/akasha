package org.realityforge.webtack.model.tools.mdn_scanner;

import javax.annotation.Nullable;

/**
 * Base exception for all errors that occur fetching, processing and saving documentation for web apis.
 */
public abstract class DocException
  extends Exception
{
  public DocException()
  {
  }

  public DocException( @Nullable final String message )
  {
    super( message );
  }

  public DocException( @Nullable final String message, @Nullable final Throwable cause )
  {
    super( message, cause );
  }

  public DocException( @Nullable final Throwable cause )
  {
    super( cause );
  }
}
