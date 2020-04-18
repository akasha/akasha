package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;

public final class SourcePosition
{
  @Nonnull
  private final String _sourceName;
  private final int _line;
  private final int _charPositionInLine;

  public SourcePosition( @Nonnull final String sourceName, final int line, final int charPositionInLine )
  {
    assert line > 0;
    assert charPositionInLine >= 0;
    _sourceName = Objects.requireNonNull( sourceName );
    _line = line;
    _charPositionInLine = charPositionInLine;
  }

  @Nonnull
  public String getSourceName()
  {
    return _sourceName;
  }

  public int getLine()
  {
    return _line;
  }

  public int getCharPositionInLine()
  {
    return _charPositionInLine;
  }

  @Override
  public String toString()
  {
    return getSourceName() + ":" + getLine() + ":" + getCharPositionInLine();
  }
}
