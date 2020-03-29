package org.realityforge.webtack.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

@SuppressWarnings( "DuplicatedCode" )
public final class DistinguishableType
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
  public static Type parse( @Nonnull final WebIDLParser.TypeWithExtendedAttributesContext ctx )
  {
    final WebIDLParser.ExtendedAttributeListContext extendedAttributeListContext = ctx.extendedAttributeList();
    return parse( ctx.type(), ExtendedAttribute.parse( extendedAttributeListContext ) );
  }

  @Nonnull
  public static Type parse( @Nonnull final WebIDLParser.TypeContext ctx )
  {
    return parse( ctx, Collections.emptyList() );
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.TypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final WebIDLParser.SingleTypeContext singleTypeContext = ctx.singleType();
    if ( null != singleTypeContext )
    {
      return parse( singleTypeContext, extendedAttributes );
    }
    else
    {
      final int additionalFlags = 1 == ctx.nullModifier().getChildCount() ? Type.Flags.NULLABLE : 0;
      final WebIDLParser.UnionTypeContext unionTypeContext = ctx.unionType();
      assert null != unionTypeContext;
      return parse( unionTypeContext, additionalFlags );
    }
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.UnionTypeContext ctx, final int additionalFlags )
  {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.SingleTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final WebIDLParser.DistinguishableTypeContext distinguishableTypeContext = ctx.distinguishableType();
    if ( null != distinguishableTypeContext )
    {
      return parse( distinguishableTypeContext, extendedAttributes );
    }
    else if ( ctx.getChild( 0 ) instanceof TerminalNode )
    {
      assert ctx.getChild( 0 ).getText().equals( "any" );
      return new Type( Kind.Any, extendedAttributes, 0 );
    }
    else
    {
      final WebIDLParser.PromiseTypeContext promiseTypeContext = ctx.promiseType();
      assert null != promiseTypeContext;
      return parse( promiseTypeContext, extendedAttributes );
    }
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.PromiseTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final WebIDLParser.TypeContext type = ctx.returnType().type();
    return new PromiseType( extendedAttributes,
                            null != type ? parse( type ) : new Type( Kind.Void, Collections.emptyList(), 0 ) );
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.DistinguishableTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    final int additionalFlags = 1 == ctx.nullModifier().getChildCount() ? Type.Flags.NULLABLE : 0;

    final WebIDLParser.PrimitiveTypeContext primitiveTypeContext = ctx.primitiveType();
    if ( null != primitiveTypeContext )
    {
      return parse( primitiveTypeContext, extendedAttributes, additionalFlags );
    }
    final WebIDLParser.StringTypeContext stringTypeContext = ctx.stringType();
    if ( null != stringTypeContext )
    {
      return parse( stringTypeContext, extendedAttributes, additionalFlags );
    }
    final TerminalNode identifier = ctx.IDENTIFIER();
    if ( null != identifier )
    {
      return new EnumerationType( identifier.getText(), extendedAttributes, additionalFlags );
    }
    final ParseTree child1 = ctx.getChild( 0 );
    if ( child1 instanceof TerminalNode )
    {
      final String text = child1.getText();
      if ( "sequence".equals( text ) )
      {
        return new SequenceType( extendedAttributes, parse( ctx.typeWithExtendedAttributes() ), additionalFlags );
      }
      else if ( "object".equals( text ) )
      {
        return new Type( Kind.Object, extendedAttributes, additionalFlags );
      }
      else if ( "symbol".equals( text ) )
      {
        return new Type( Kind.Symbol, extendedAttributes, additionalFlags );
      }
      else
      {
        assert "FrozenArray".equals( text );
        return new FrozenArrayType( extendedAttributes, parse( ctx.typeWithExtendedAttributes() ), additionalFlags );
      }
    }
    final WebIDLParser.BufferRelatedTypeContext bufferRelatedTypeContext = ctx.bufferRelatedType();
    if ( null != bufferRelatedTypeContext )
    {
      return parse( bufferRelatedTypeContext, extendedAttributes, additionalFlags );
    }
    //  | recordType nullModifier
    throw new UnsupportedOperationException();
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.BufferRelatedTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes,
                             final int additionalFlags )
  {
    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    assert null != literalName;
    final Kind kind = BUFFER_KIND_MAP.get( literalName );
    assert null != kind;
    return new Type( kind, extendedAttributes, additionalFlags );
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.PrimitiveTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes,
                             final int additionalFlags )
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
          return new Type( unsigned ? Kind.UnsignedLong : Kind.Long, extendedAttributes, additionalFlags );
        }
        else
        {
          assert optionalLongContext.getChild( 0 ).getText().equals( "long" );
          return new Type( unsigned ? Kind.UnsignedLongLong : Kind.LongLong, extendedAttributes, additionalFlags );
        }
      }
      else
      {
        assert integerTypeContext.getChild( 0 ).getText().equals( "short" );
        return new Type( unsigned ? Kind.UnsignedShort : Kind.Short, extendedAttributes, additionalFlags );
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
        return new Type( unrestricted ? Kind.UnrestrictedFloat : Kind.Float, extendedAttributes, additionalFlags );
      }
      else
      {
        assert unrestrictedFloatType.floatType().getChild( 0 ).getText().equals( "double" );
        return new Type( unrestricted ? Kind.UnrestrictedDouble : Kind.Double, extendedAttributes, additionalFlags );
      }
    }

    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( "boolean".equals( literalName ) )
    {
      return new Type( Kind.Boolean, extendedAttributes, additionalFlags );
    }
    else if ( "byte".equals( literalName ) )
    {
      return new Type( Kind.Byte, extendedAttributes, additionalFlags );
    }
    else
    {
      assert "octet".equals( literalName );
      return new Type( Kind.Octet, extendedAttributes, additionalFlags );
    }
  }

  @Nonnull
  private static Type parse( @Nonnull final WebIDLParser.StringTypeContext ctx,
                             @Nonnull final List<ExtendedAttribute> extendedAttributes,
                             final int additionalFlags )
  {
    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    assert null != literalName;
    final Kind kind = STRING_KIND_MAP.get( literalName );
    assert null != kind;
    return new Type( kind, extendedAttributes, additionalFlags );
  }
}
