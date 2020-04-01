package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class ConstValue
{
  @Nonnull
  private final Kind _kind;
  /**
   * The value is only populated when _kind is Decimal or Integer.
   */
  @Nullable
  private final String _value;

  ConstValue( @Nonnull final Kind kind, @Nullable final String value )
  {
    assert ( Kind.Decimal == kind || Kind.Integer == kind ) == ( null != value );
    _kind = Objects.requireNonNull( kind );
    _value = value;
  }

  @Nonnull
  public Kind getKind()
  {
    return _kind;
  }

  @Nullable
  public String getValue()
  {
    return _value;
  }

  @Nonnull
  static ConstValue parse( @Nonnull final WebIDLParser.ConstMemberValueContext ctx )
  {
    final WebIDLParser.BooleanLiteralContext booleanLiteralContext = ctx.booleanLiteral();
    if ( null != booleanLiteralContext )
    {
      return new ConstValue( "true".equals( booleanLiteralContext.getText() ) ? Kind.True : Kind.False, null );
    }
    final WebIDLParser.FloatLiteralContext floatLiteralContext = ctx.floatLiteral();
    if ( null != floatLiteralContext )
    {
      final TerminalNode decimal = floatLiteralContext.DECIMAL();
      if ( null != decimal )
      {
        return new ConstValue( Kind.Decimal, decimal.getText() );
      }
      else
      {
        final String text = floatLiteralContext.getText();
        if ( "-Infinity".equals( text ) )
        {
          return new ConstValue( Kind.NegativeInfinity, null );
        }
        else if ( "Infinity".equals( text ) )
        {
          return new ConstValue( Kind.PositiveInfinity, null );
        }
        else
        {
          assert "NaN".equals( text );
          return new ConstValue( Kind.NaN, null );
        }
      }
    }
    return new ConstValue( Kind.Integer, ctx.INTEGER().getText() );
  }

  public enum Kind
  {
    True,
    False,
    Decimal,
    NegativeInfinity,
    PositiveInfinity,
    NaN,
    Integer
  }
}
