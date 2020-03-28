package org.realityforge.webtack.model;

import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class StringType
  extends Type
{
  @Nonnull
  public static final StringType BYTE_STRING = new StringType( "ByteString", false );
  @Nonnull
  public static final StringType NULLABLE_BYTE_STRING = new StringType( "ByteString", true );
  @Nonnull
  public static final StringType DOM_STRING = new StringType( "DOMString", false );
  @Nonnull
  public static final StringType NULLABLE_DOM_STRING = new StringType( "DOMString", true );
  @Nonnull
  public static final StringType USV_STRING = new StringType( "USVString", false );
  @Nonnull
  public static final StringType NULLABLE_USV_STRING = new StringType( "USVString", true );

  @Nonnull
  public static StringType parse( @Nonnull final WebIDLParser.StringTypeContext ctx, final boolean nullable )
  {
    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( BYTE_STRING.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_BYTE_STRING : BYTE_STRING;
    }
    else if ( DOM_STRING.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_DOM_STRING : DOM_STRING;
    }
    else
    {
      assert USV_STRING.getTypeName().equals( literalName );
      return nullable ? NULLABLE_USV_STRING : USV_STRING;
    }
  }

  private StringType( @Nonnull final String name, final boolean nullable )
  {
    super( name, nullable );
  }
}
