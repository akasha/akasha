package org.realityforge.webtack;

import javax.annotation.Nullable;

final class TerminalStateException
  extends RuntimeException
{
  private final int _exitCode;

  TerminalStateException( final int exitCode )
  {
    this( null, exitCode );
  }

  TerminalStateException( @Nullable final String message, final int exitCode )
  {
    this( message, null, exitCode );
  }

  TerminalStateException( @Nullable final String message, @Nullable final Throwable cause, final int exitCode )
  {
    super( message, cause );
    _exitCode = exitCode;
  }

  int getExitCode()
  {
    return _exitCode;
  }
}
