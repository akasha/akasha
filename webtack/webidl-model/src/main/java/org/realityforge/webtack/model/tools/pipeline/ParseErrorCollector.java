package org.realityforge.webtack.model.tools.pipeline;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

final class ParseErrorCollector
  extends ConsoleErrorListener
{
  @Nonnull
  private final List<ParseError> _errors = new ArrayList<>();

  @Override
  public void syntaxError( final Recognizer<?, ?> recognizer,
                           final Object offendingSymbol,
                           final int line,
                           final int charPositionInLine,
                           final String msg,
                           final RecognitionException e )
  {
    _errors.add( new ParseError( line, charPositionInLine, msg ) );
    throw new ParseCancellationException( e );
  }

  @Nonnull
  List<ParseError> getErrors()
  {
    return _errors;
  }
}
