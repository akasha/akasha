package org.realityforge.webtack.model;

import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class PrimitiveType
  extends Type
{
  @Nonnull
  public static final PrimitiveType BOOLEAN = new PrimitiveType( "boolean", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_BOOLEAN = new PrimitiveType( "boolean", true );
  @Nonnull
  public static final PrimitiveType BYTE = new PrimitiveType( "byte", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_BYTE = new PrimitiveType( "byte", true );
  @Nonnull
  public static final PrimitiveType OCTET = new PrimitiveType( "octet", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_OCTET = new PrimitiveType( "octet", true );
  @Nonnull
  public static final PrimitiveType FLOAT = new PrimitiveType( "float", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_FLOAT = new PrimitiveType( "float", true );
  @Nonnull
  public static final PrimitiveType DOUBLE = new PrimitiveType( "double", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_DOUBLE = new PrimitiveType( "double", true );
  @Nonnull
  public static final PrimitiveType UNRESTRICTED_FLOAT = new PrimitiveType( "unrestricted float", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_UNRESTRICTED_FLOAT = new PrimitiveType( "unrestricted float", true );
  @Nonnull
  public static final PrimitiveType UNRESTRICTED_DOUBLE = new PrimitiveType( "unrestricted double", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_UNRESTRICTED_DOUBLE = new PrimitiveType( "unrestricted double", true );
  @Nonnull
  public static final PrimitiveType SHORT = new PrimitiveType( "short", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_SHORT = new PrimitiveType( "short", true );
  @Nonnull
  public static final PrimitiveType LONG = new PrimitiveType( "long", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_LONG = new PrimitiveType( "long", true );
  @Nonnull
  public static final PrimitiveType LONG_LONG = new PrimitiveType( "long long", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_LONG_LONG = new PrimitiveType( "long long", true );
  @Nonnull
  public static final PrimitiveType UNSIGNED_SHORT = new PrimitiveType( "unsigned short", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_UNSIGNED_SHORT = new PrimitiveType( "unsigned short", true );
  @Nonnull
  public static final PrimitiveType UNSIGNED_LONG = new PrimitiveType( "unsigned long", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_UNSIGNED_LONG = new PrimitiveType( "unsigned long", true );
  @Nonnull
  public static final PrimitiveType UNSIGNED_LONG_LONG = new PrimitiveType( "unsigned long long", false );
  @Nonnull
  public static final PrimitiveType NULLABLE_UNSIGNED_LONG_LONG = new PrimitiveType( "unsigned long long", true );

  @Nonnull
  public static PrimitiveType parse( @Nonnull final WebIDLParser.PrimitiveTypeContext ctx, final boolean nullable )
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
            return nullable ? NULLABLE_UNSIGNED_LONG : UNSIGNED_LONG;
          }
          else
          {
            return nullable ? NULLABLE_LONG : LONG;
          }
        }
        else
        {
          assert optionalLongContext.getChild( 0 ).getText().equals( "long" );
          if ( unsigned )
          {
            return nullable ? NULLABLE_UNSIGNED_LONG_LONG : UNSIGNED_LONG_LONG;
          }
          else
          {
            return nullable ? NULLABLE_LONG_LONG : LONG_LONG;
          }
        }
      }
      else
      {
        assert integerTypeContext.getChild( 0 ).getText().equals( "short" );
        if ( unsigned )
        {
          return nullable ? NULLABLE_UNSIGNED_SHORT : UNSIGNED_SHORT;
        }
        else
        {
          return nullable ? NULLABLE_SHORT : SHORT;
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
          return nullable ? NULLABLE_UNRESTRICTED_FLOAT : UNRESTRICTED_FLOAT;
        }
        else
        {
          return nullable ? NULLABLE_FLOAT : FLOAT;
        }
      }
      else
      {
        assert unrestrictedFloatType.floatType().getChild( 0 ).getText().equals( "double" );
        if ( unrestricted )
        {
          return nullable ? NULLABLE_UNRESTRICTED_DOUBLE : UNRESTRICTED_DOUBLE;
        }
        else
        {
          return nullable ? NULLABLE_DOUBLE : DOUBLE;
        }
      }
    }

    final TerminalNode child = (TerminalNode) ctx.getChild( 0 );
    final String literalName = child.getText();
    if ( BOOLEAN.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_BOOLEAN : BOOLEAN;
    }
    else if ( BYTE.getTypeName().equals( literalName ) )
    {
      return nullable ? NULLABLE_BYTE : BYTE;
    }
    else
    {
      assert OCTET.getTypeName().equals( literalName );
      return nullable ? NULLABLE_OCTET : OCTET;
    }
  }

  private PrimitiveType( @Nonnull final String name, final boolean nullable )
  {
    super( name, nullable );
  }
}
