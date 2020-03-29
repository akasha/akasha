package org.realityforge.webtack.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public class DistinguishableType
{
  @Nonnull
  private static final Map<String, Kind> STRING_KIND_MAP = Collections.unmodifiableMap( new HashMap<String, Kind>()
  {
    {
      put( "DOMString", Kind.DOMString );
      put( "ByteString", Kind.ByteString );
      put( "USVString", Kind.USVString );
    }
  } );
  @Nonnull
  private static final Map<String, Kind> BUFFER_KIND_MAP = Collections.unmodifiableMap( new HashMap<String, Kind>()
  {
    {
      put( "ArrayBuffer", Kind.ArrayBuffer );
      put( "DataView", Kind.DataView );
      put( "Int8Array", Kind.Int8Array );
      put( "Int16Array", Kind.Int16Array );
      put( "Int32Array", Kind.Int32Array );
      put( "Uint8Array", Kind.Uint8Array );
      put( "Uint16Array", Kind.Uint16Array );
      put( "Uint32Array", Kind.Uint32Array );
      put( "Uint8ClampedArray", Kind.Uint8ClampedArray );
      put( "Float32Array", Kind.Float32Array );
      put( "Float64Array", Kind.Float64Array );
    }
  } );

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
      return new Type( Kind.Any );
    }
    else
    {
      final WebIDLParser.PromiseTypeContext promiseTypeContext = ctx.promiseType();
      assert null != promiseTypeContext;
      return parse( promiseTypeContext );
    }
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.PromiseTypeContext ctx )
  {
    final WebIDLParser.TypeContext type = ctx.returnType().type();
    return new PromiseType( null != type ? parse( type ) : new Type( Kind.Void ) );
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.DistinguishableTypeContext ctx )
  {
    final int additionalFlags = 1 == ctx.nullModifier().getChildCount() ? Type.Flags.NULLABLE : 0;

    final WebIDLParser.PrimitiveTypeContext primitiveTypeContext = ctx.primitiveType();
    if ( null != primitiveTypeContext )
    {
      return parse( primitiveTypeContext, additionalFlags );
    }
    final WebIDLParser.StringTypeContext stringTypeContext = ctx.stringType();
    if ( null != stringTypeContext )
    {
      return parse( stringTypeContext, additionalFlags );
    }
    final TerminalNode identifier = ctx.IDENTIFIER();
    if ( null != identifier )
    {
      return new EnumerationType( identifier.getText(), additionalFlags );
    }
    final ParseTree child1 = ctx.getChild( 0 );
    if ( child1 instanceof TerminalNode )
    {
      final String text = child1.getText();
      //  | 'sequence' '<' typeWithExtendedAttributes '>' nullModifier
      if ( "object".equals( text ) )
      {
        return new Type( Kind.Object, additionalFlags );
      }
      else if ( "symbol".equals( text ) )
      {
        return new Type( Kind.Symbol, additionalFlags );
      }
      //  | 'FrozenArray' '<' typeWithExtendedAttributes '>' nullModifier
    }
    final WebIDLParser.BufferRelatedTypeContext bufferRelatedTypeContext = ctx.bufferRelatedType();
    if ( null != bufferRelatedTypeContext )
    {
      return parse( bufferRelatedTypeContext, additionalFlags );
    }
    //  | recordType nullModifier
    throw new UnsupportedOperationException();
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.BufferRelatedTypeContext ctx, final int additionalFlags )
  {
    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    assert null != literalName;
    final Kind kind = BUFFER_KIND_MAP.get( literalName );
    assert null != kind;
    return new Type( kind, additionalFlags );
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.PrimitiveTypeContext ctx, final int additionalFlags )
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
          return new Type( unsigned ? Kind.UnsignedLong : Kind.Long, additionalFlags );
        }
        else
        {
          assert optionalLongContext.getChild( 0 ).getText().equals( "long" );
          return new Type( unsigned ? Kind.UnsignedLongLong : Kind.LongLong, additionalFlags );
        }
      }
      else
      {
        assert integerTypeContext.getChild( 0 ).getText().equals( "short" );
        return new Type( unsigned ? Kind.UnsignedShort : Kind.Short, additionalFlags );
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
        return new Type( unrestricted ? Kind.UnrestrictedFloat : Kind.Float, additionalFlags );
      }
      else
      {
        assert unrestrictedFloatType.floatType().getChild( 0 ).getText().equals( "double" );
        return new Type( unrestricted ? Kind.UnrestrictedDouble : Kind.Double, additionalFlags );
      }
    }

    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( "boolean".equals( literalName ) )
    {
      return new Type( Kind.Boolean, additionalFlags );
    }
    else if ( "byte".equals( literalName ) )
    {
      return new Type( Kind.Byte, additionalFlags );
    }
    else
    {
      assert "octet".equals( literalName );
      return new Type( Kind.Octet, additionalFlags );
    }
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.StringTypeContext ctx, final int additionalFlags )
  {
    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    assert null != literalName;
    final Kind kind = STRING_KIND_MAP.get( literalName );
    assert null != kind;
    return new Type( kind, additionalFlags );
  }
}
