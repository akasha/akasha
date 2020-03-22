package org.realityforge.webtack.model;

import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class StringType
  extends Type
{
  @Nonnull
  public static final StringType BYTE_STRING = new StringType( "ByteString" );
  @Nonnull
  public static final StringType DOM_STRING = new StringType( "DOMString" );
  @Nonnull
  public static final StringType USV_STRING = new StringType( "USVString" );

  @Nonnull
  public static StringType parse( @Nonnull final WebIDLParser.StringTypeContext ctx )
  {

    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( BYTE_STRING.getName().equals( literalName ) )
    {
      return BYTE_STRING;
    }
    else if ( DOM_STRING.getName().equals( literalName ) )
    {
      return DOM_STRING;
    }
    else
    {
      assert USV_STRING.getName().equals( literalName );
      return USV_STRING;
    }
  }

  private StringType( @Nonnull final String name )
  {
    super( name );
  }
}
