package org.realityforge.webtack.model;

import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public class DistinguishableType
{
  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.DistinguishableTypeContext ctx )
  {
    final boolean nullable = 1 == ctx.nullModifier().getChildCount();

    final WebIDLParser.PrimitiveTypeContext primitiveTypeContext = ctx.primitiveType();
    if ( null != primitiveTypeContext )
    {
      return PrimitiveType.parse( primitiveTypeContext, nullable );
    }
    final WebIDLParser.StringTypeContext stringTypeContext = ctx.stringType();
    if ( null != stringTypeContext )
    {
      return StringType.parse( stringTypeContext, nullable );
    }
    final TerminalNode identifier = ctx.IDENTIFIER();
    if ( null != identifier )
    {
      return new EnumerationType( identifier.getText(), nullable );
    }
    final ParseTree child1 = ctx.getChild( 0 );
    if ( child1 instanceof TerminalNode )
    {
      final String text = child1.getText();
      //  | 'sequence' '<' typeWithExtendedAttributes '>' nullModifier
      if ( "object".equals( text ) )
      {
        return nullable ? ObjectType.NULLABLE_OBJECT : ObjectType.OBJECT;
      }
      else if ( "symbol".equals( text ) )
      {
        return nullable ? SymbolType.NULLABLE_SYMBOL : SymbolType.SYMBOL;
      }
      //  | 'FrozenArray' '<' typeWithExtendedAttributes '>' nullModifier
    }
    final WebIDLParser.BufferRelatedTypeContext bufferRelatedTypeContext = ctx.bufferRelatedType();
    if ( null != bufferRelatedTypeContext )
    {
      return BufferRelatedType.parse( bufferRelatedTypeContext, nullable );
    }
    //  | recordType nullModifier
    throw new UnsupportedOperationException();
  }
}
