package org.realityforge.webtack.model;

import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public class DistinguishableType
{
  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.TypeContext ctx )
  {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.SingleTypeContext ctx )
  {
    final WebIDLParser.DistinguishableTypeContext distinguishableTypeContext = ctx.distinguishableType();
    if ( null != distinguishableTypeContext )
    {
      return parse( distinguishableTypeContext );
    }
    else if ( ctx.getChild( 0 ) instanceof TerminalNode )
    {
      assert ctx.getChild( 0 ).getText().equals( "any" );
      return Type.ANY;
    }
    else
    {
      final WebIDLParser.PromiseTypeContext promiseTypeContext = ctx.promiseType();
      assert null != promiseTypeContext;
      return parse( promiseTypeContext );
    }
  }

  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.PromiseTypeContext ctx )
  {
    final WebIDLParser.TypeContext type = ctx.returnType().type();
    if ( null != type )
    {
      final Type resolveType = parse( type );
      return new PromiseType( "promise", resolveType );
    }
    else
    {
      return new PromiseType( "promise", null );
    }
  }

  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.DistinguishableTypeContext ctx )
  {
    final boolean nullable = 1 == ctx.nullModifier().getChildCount();

    final WebIDLParser.PrimitiveTypeContext primitiveTypeContext = ctx.primitiveType();
    if ( null != primitiveTypeContext )
    {
      return parse( primitiveTypeContext, nullable );
    }
    final WebIDLParser.StringTypeContext stringTypeContext = ctx.stringType();
    if ( null != stringTypeContext )
    {
      return parse( stringTypeContext, nullable );
    }
    final TerminalNode identifier = ctx.IDENTIFIER();
    if ( null != identifier )
    {
      return new EnumerationType( identifier.getText(), nullable ? Type.Flags.NULLABLE : 0 );
    }
    final ParseTree child1 = ctx.getChild( 0 );
    if ( child1 instanceof TerminalNode )
    {
      final String text = child1.getText();
      //  | 'sequence' '<' typeWithExtendedAttributes '>' nullModifier
      if ( "object".equals( text ) )
      {
        return nullable ? Type.NULLABLE_OBJECT : Type.OBJECT;
      }
      else if ( "symbol".equals( text ) )
      {
        return nullable ? Type.NULLABLE_SYMBOL : Type.SYMBOL;
      }
      //  | 'FrozenArray' '<' typeWithExtendedAttributes '>' nullModifier
    }
    final WebIDLParser.BufferRelatedTypeContext bufferRelatedTypeContext = ctx.bufferRelatedType();
    if ( null != bufferRelatedTypeContext )
    {
      return parse( bufferRelatedTypeContext, nullable );
    }
    //  | recordType nullModifier
    throw new UnsupportedOperationException();
  }

  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.BufferRelatedTypeContext ctx, final boolean nullable )
  {

    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( Type.ARRAY_BUFFER.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_ARRAY_BUFFER : Type.ARRAY_BUFFER;
    }
    else if ( Type.DATA_VIEW.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_DATA_VIEW : Type.DATA_VIEW;
    }
    else if ( Type.INT8_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_INT8_ARRAY : Type.INT8_ARRAY;
    }
    else if ( Type.INT16_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_INT16_ARRAY : Type.INT16_ARRAY;
    }
    else if ( Type.INT32_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_INT32_ARRAY : Type.INT32_ARRAY;
    }
    else if ( Type.UINT8_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_UINT8_ARRAY : Type.UINT8_ARRAY;
    }
    else if ( Type.UINT16_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_UINT16_ARRAY : Type.UINT16_ARRAY;
    }
    else if ( Type.UINT32_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_UINT32_ARRAY : Type.UINT32_ARRAY;
    }
    else if ( Type.UINT8_CLAMPED_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_UINT8_CLAMPED_ARRAY : Type.UINT8_CLAMPED_ARRAY;
    }
    else if ( Type.FLOAT32_ARRAY.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_FLOAT32_ARRAY : Type.FLOAT32_ARRAY;
    }
    else
    {
      assert Type.FLOAT64_ARRAY.getTypeName().equals( literalName );
      return nullable ? Type.NULLABLE_FLOAT64_ARRAY : Type.FLOAT64_ARRAY;
    }
  }

  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.PrimitiveTypeContext ctx, final boolean nullable )
  {
    final WebIDLParser.UnsignedIntegerTypeContext unsignedIntegerType = ctx.unsignedIntegerType();
    if ( null != unsignedIntegerType )
    {
      final ParseTree first = unsignedIntegerType.getChild( 0 );
      final boolean unsigned = first instanceof TerminalNode;
      assert !unsigned || first.getText().equals( "unsigned" );
      final WebIDLParser.IntegerTypeContext integerTypeContext = unsignedIntegerType.integerType();
      if ( integerTypeContext.getChild( 0 ).getText().equals( "long" ) )
      {
        final WebIDLParser.OptionalLongContext optionalLongContext = integerTypeContext.optionalLong();
        if ( 0 == optionalLongContext.getChildCount() )
        {
          if ( unsigned )
          {
            return nullable ? Type.NULLABLE_UNSIGNED_LONG : Type.UNSIGNED_LONG;
          }
          else
          {
            return nullable ? Type.NULLABLE_LONG : Type.LONG;
          }
        }
        else
        {
          assert optionalLongContext.getChild( 0 ).getText().equals( "long" );
          if ( unsigned )
          {
            return nullable ? Type.NULLABLE_UNSIGNED_LONG_LONG : Type.UNSIGNED_LONG_LONG;
          }
          else
          {
            return nullable ? Type.NULLABLE_LONG_LONG : Type.LONG_LONG;
          }
        }
      }
      else
      {
        assert integerTypeContext.getChild( 0 ).getText().equals( "short" );
        if ( unsigned )
        {
          return nullable ? Type.NULLABLE_UNSIGNED_SHORT : Type.UNSIGNED_SHORT;
        }
        else
        {
          return nullable ? Type.NULLABLE_SHORT : Type.SHORT;
        }
      }
    }
    final WebIDLParser.UnrestrictedFloatTypeContext unrestrictedFloatType = ctx.unrestrictedFloatType();
    if ( null != unrestrictedFloatType )
    {
      final ParseTree first = unrestrictedFloatType.getChild( 0 );
      final boolean unrestricted = first instanceof TerminalNode;
      assert !unrestricted || first.getText().equals( "unrestricted" );

      if ( unrestrictedFloatType.floatType().getChild( 0 ).getText().equals( "float" ) )
      {
        if ( unrestricted )
        {
          return nullable ? Type.NULLABLE_UNRESTRICTED_FLOAT : Type.UNRESTRICTED_FLOAT;
        }
        else
        {
          return nullable ? Type.NULLABLE_FLOAT : Type.FLOAT;
        }
      }
      else
      {
        assert unrestrictedFloatType.floatType().getChild( 0 ).getText().equals( "double" );
        if ( unrestricted )
        {
          return nullable ? Type.NULLABLE_UNRESTRICTED_DOUBLE : Type.UNRESTRICTED_DOUBLE;
        }
        else
        {
          return nullable ? Type.NULLABLE_DOUBLE : Type.DOUBLE;
        }
      }
    }

    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( Type.BOOLEAN.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_BOOLEAN : Type.BOOLEAN;
    }
    else if ( Type.BYTE.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_BYTE : Type.BYTE;
    }
    else
    {
      assert Type.OCTET.getTypeName().equals( literalName );
      return nullable ? Type.NULLABLE_OCTET : Type.OCTET;
    }
  }

  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.StringTypeContext ctx, final boolean nullable )
  {
    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( Type.BYTE_STRING.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_BYTE_STRING : Type.BYTE_STRING;
    }
    else if ( Type.DOM_STRING.getTypeName().equals( literalName ) )
    {
      return nullable ? Type.NULLABLE_DOM_STRING : Type.DOM_STRING;
    }
    else
    {
      assert Type.USV_STRING.getTypeName().equals( literalName );
      return nullable ? Type.NULLABLE_USV_STRING : Type.USV_STRING;
    }
  }
}
