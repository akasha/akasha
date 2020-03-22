package org.realityforge.webtack.model;

import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class PrimitiveType
  extends Type
{
  @Nonnull
  public static final PrimitiveType BOOLEAN = new PrimitiveType( "boolean" );
  @Nonnull
  public static final PrimitiveType BYTE = new PrimitiveType( "byte" );
  @Nonnull
  public static final PrimitiveType OCTET = new PrimitiveType( "octet" );
  @Nonnull
  public static final PrimitiveType FLOAT = new PrimitiveType( "float" );
  @Nonnull
  public static final PrimitiveType DOUBLE = new PrimitiveType( "double" );
  @Nonnull
  public static final PrimitiveType UNRESTRICTED_FLOAT = new PrimitiveType( "unrestricted float" );
  @Nonnull
  public static final PrimitiveType UNRESTRICTED_DOUBLE = new PrimitiveType( "unrestricted double" );
  @Nonnull
  public static final PrimitiveType SHORT = new PrimitiveType( "short" );
  @Nonnull
  public static final PrimitiveType LONG = new PrimitiveType( "long" );
  @Nonnull
  public static final PrimitiveType LONG_LONG = new PrimitiveType( "long long" );
  @Nonnull
  public static final PrimitiveType UNSIGNED_SHORT = new PrimitiveType( "unsigned short" );
  @Nonnull
  public static final PrimitiveType UNSIGNED_LONG = new PrimitiveType( "unsigned long" );
  @Nonnull
  public static final PrimitiveType UNSIGNED_LONG_LONG = new PrimitiveType( "unsigned long long" );

  @Nonnull
  public static PrimitiveType parse( @Nonnull final WebIDLParser.PrimitiveTypeContext ctx )
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
          return unsigned ? UNSIGNED_LONG : LONG;
        }
        else
        {
          assert optionalLongContext.getChild( 0 ).getText().equals( "long" );
          return unsigned ? UNSIGNED_LONG_LONG : LONG_LONG;
        }
      }
      else
      {
        assert integerTypeContext.getChild( 0 ).getText().equals( "short" );
        return unsigned ? UNSIGNED_SHORT : SHORT;
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
        return unrestricted ? UNRESTRICTED_FLOAT : FLOAT;
      }
      else
      {
        assert unrestrictedFloatType.floatType().getChild( 0 ).getText().equals( "double" );
        return unrestricted ? UNRESTRICTED_DOUBLE : DOUBLE;
      }
    }

    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( BOOLEAN.getName().equals( literalName ) )
    {
      return BOOLEAN;
    }
    else if ( BYTE.getName().equals( literalName ) )
    {
      return BYTE;
    }
    else
    {
      assert OCTET.getName().equals( literalName );
      return OCTET;
    }
  }

  private PrimitiveType( @Nonnull final String name )
  {
    super( name );
  }
}
