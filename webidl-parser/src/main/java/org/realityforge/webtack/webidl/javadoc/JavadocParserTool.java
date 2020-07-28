package org.realityforge.webtack.webidl.javadoc;

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import javax.annotation.Nonnull;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * A simple adapter to launch the Javadoc parser.
 */
public final class JavadocParserTool
{
  private JavadocParserTool()
  {
  }

  /**
   * Create a JavadocParser instance that reads from specified reader.
   * The parser is configured to generate an exception if a lexing or parse exception is detected.
   *
   * @param name   the "name" of the input source.
   * @param reader the input reader
   * @return the configured WebIDLParser instance.
   * @throws IOException if there is an error reading from reader.
   */
  @Nonnull
  public static JavadocParser createParser( @Nonnull final String name, @Nonnull final Reader reader )
    throws IOException
  {
    final ANTLRInputStream input = new ANTLRInputStream( reader );
    input.name = Objects.requireNonNull( name );
    return new JavadocParser( new CommonTokenStream( new BailLexer( input ) ) );
  }

  private static class BailLexer
    extends JavadocLexer
  {
    public BailLexer( @Nonnull final CharStream input )
    {
      super( input );
    }

    public void recover( @Nonnull final LexerNoViableAltException e )
    {
      throw new ParseCancellationException( e );
    }
  }
}
