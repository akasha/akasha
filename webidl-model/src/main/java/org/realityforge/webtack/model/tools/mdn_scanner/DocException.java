package org.realityforge.webtack.model.tools.mdn_scanner;

import javax.annotation.Nonnull;

/**
 * Base exception for all errors that occur fetching, processing and saving documentation for web apis.
 */
public abstract class DocException
  extends Exception
{
  public DocException()
  {
  }

  public DocException( @Nonnull final String message )
  {
    super( message );
  }

  public DocException( @Nonnull final String message, @Nonnull final Throwable cause )
  {
    super( message, cause );
  }

  public DocException( @Nonnull final Throwable cause )
  {
    super( cause );
  }
}
