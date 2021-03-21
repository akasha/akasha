package org.realityforge.webtack.model.tools.pipeline;

import java.util.Objects;
import javax.annotation.Nonnull;

public final class ParseError
{
  private final int _line;
  private final int _charPositionInLine;
  @Nonnull
  private final String _message;

  public ParseError( final int line, final int charPositionInLine, @Nonnull final String message )
  {
    _line = line;
    _charPositionInLine = charPositionInLine;
    _message = Objects.requireNonNull( message );
  }

  public int getLine()
  {
    return _line;
  }

  public int getCharPositionInLine()
  {
    return _charPositionInLine;
  }

  @Nonnull
  public String getMessage()
  {
    return _message;
  }
}
