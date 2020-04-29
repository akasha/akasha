package org.realityforge.webtack;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

final class CountingConsoleErrorListener
  extends ConsoleErrorListener
{
  /**
   * The name of the source file used when reporting errors.
   */
  @Nonnull
  private final String _sourceName;
  private int _errorCount;

  CountingConsoleErrorListener( @Nonnull final String sourceName )
  {
    _sourceName = Objects.requireNonNull( sourceName );
  }

  @Override
  public void syntaxError( final Recognizer<?, ?> recognizer,
                           final Object offendingSymbol,
                           final int line,
                           final int charPositionInLine,
                           final String msg,
                           final RecognitionException e )
  {
    System.err.println( "syntax error: " + _sourceName + ":" + line + ":" + charPositionInLine + " " + msg );
    _errorCount++;
  }

  int getErrorCount()
  {
    return _errorCount;
  }
}
