package org.realityforge.webtack.model;

import java.io.IOException;
import java.io.Reader;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;
import org.realityforge.webtack.webidl.parser.WebIDLParserTool;

public final class WebIDLModelParser
{
  private WebIDLModelParser()
  {
  }

  @Nonnull
  public static WebIDLParser createParser( @Nonnull final Reader reader, @Nonnull final ModelRepository repository )
    throws IOException
  {
    final WebIDLParser parser = WebIDLParserTool.createParser( reader );
    parser.setBuildParseTree( true );
    parser.addParseListener( new ModelBuilderListener( repository ) );
    return parser;
  }
}
