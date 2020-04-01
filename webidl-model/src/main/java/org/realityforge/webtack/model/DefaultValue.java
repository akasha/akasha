package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class DefaultValue
{
  @Nonnull
  private final Kind _kind;
  @Nullable
  private final ConstValue _constValue;
  @Nullable
  private final String _stringValue;

  DefaultValue( @Nonnull final Kind kind, @Nullable final ConstValue constValue, @Nullable final String stringValue )
  {
    assert ( Kind.Const == kind ) == ( null != constValue );
    assert ( Kind.String == kind ) == ( null != stringValue );
    _kind = Objects.requireNonNull( kind );
    _constValue = constValue;
    _stringValue = stringValue;
  }

  @Nonnull
  public Kind getKind()
  {
    return _kind;
  }

  @Nullable
  public ConstValue getConstValue()
  {
    return _constValue;
  }

  @Nullable
  public String getStringValue()
  {
    return _stringValue;
  }

  @Nonnull
  public static DefaultValue parse( @Nonnull final WebIDLParser.DefaultValueContext ctx )
  {
    final WebIDLParser.ConstMemberValueContext constMemberValueContext = ctx.constMemberValue();
    if ( null != constMemberValueContext )
    {
      return new DefaultValue( Kind.Const, ConstValue.parse( constMemberValueContext ), null );
    }
    final TerminalNode string = ctx.STRING();
    if ( null != string )
    {
      return new DefaultValue( Kind.String, null, ParseUtil.extractString( string ) );
    }
    final String child = ctx.getChild( 0 ).getText();
    if ( "[".equals( child ) )
    {
      return new DefaultValue( Kind.EmptySequence, null, null );
    }
    else if ( "{".equals( child ) )
    {
      return new DefaultValue( Kind.EmptyDictionary, null, null );
    }
    else
    {
      assert "null".equals( child );
      return new DefaultValue( Kind.Null, null, null );
    }
  }

  public enum Kind
  {
    Const,
    String,
    EmptyDictionary,
    EmptySequence,
    Null
  }
}
