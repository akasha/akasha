package org.realityforge.webtack.model.tools.qa;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * An error listener that can be used within tests that will fail with an assertion error if there is a parsing error.
 */
public final class BailErrorListener
  extends BaseErrorListener
{
  /**
   * The name of the source file used when reporting errors.
   */
  @Nonnull
  private final String _sourceName;

  public BailErrorListener( @Nonnull final String sourceName )
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
    final String message = "syntax error: " + _sourceName + ":" + line + ":" + charPositionInLine + " " + msg;
    System.err.println( message );
    throw new AssertionError( message );
  }
}
