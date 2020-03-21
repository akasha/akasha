package org.realityforge.webtack.webidl.parser;

import java.io.IOException;
import java.io.Reader;
import javax.annotation.Nonnull;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * A simple adapter to launch the generated parser.
 */
public final class WebIDLParserTool
{
  private WebIDLParserTool()
  {
  }

  /**
   * Create a WebIDLParser instance that reads from specified reader.
   * The parser is configured to generate an exception if a lexing or parse exception is detected.
   *
   * @param reader the input reader
   * @return the configured WebIDLParser instance.
   * @throws IOException if there is an error reading from reader.
   */
  @Nonnull
  public static WebIDLParser createParser( @Nonnull final Reader reader )
    throws IOException
  {
    final ANTLRInputStream input = new ANTLRInputStream( reader );
    final WebIDLLexer lexer = new BailLexer( input );
    final CommonTokenStream tokens = new CommonTokenStream( lexer );
    return new WebIDLParser( tokens );
  }

  private static class BailLexer
    extends WebIDLLexer
  {
    public BailLexer( final CharStream input )
    {
      super( input );
    }

    public void recover( final LexerNoViableAltException e )
    {
      throw new ParseCancellationException( e );
    }
  }
}
