package org.realityforge.webtack.model;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class Argument
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Type _type;
  private final boolean _optional;
  private final boolean _variadic;
  @Nullable
  private final DefaultValue _defaultValue;
  @Nonnull
  private final List<ExtendedAttribute> _extendedAttributes;

  public Argument( @Nonnull final String name,
                   @Nonnull final Type type,
                   final boolean optional,
                   final boolean variadic,
                   @Nullable final DefaultValue defaultValue,
                   @Nonnull final List<ExtendedAttribute> extendedAttributes )
  {
    _name = Objects.requireNonNull( name );
    _type = Objects.requireNonNull( type );
    _optional = optional;
    _variadic = variadic;
    _defaultValue = defaultValue;
    _extendedAttributes = Objects.requireNonNull( extendedAttributes );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public Type getType()
  {
    return _type;
  }

  public boolean isOptional()
  {
    return _optional;
  }

  public boolean isVariadic()
  {
    return _variadic;
  }

  @Nullable
  public DefaultValue getDefaultValue()
  {
    return _defaultValue;
  }

  @Nonnull
  public List<ExtendedAttribute> getExtendedAttributes()
  {
    return _extendedAttributes;
  }

  @Nonnull
  public static Argument parse( @Nonnull final WebIDLParser.ArgumentContext ctx )
  {
    final List<ExtendedAttribute> extendedAttributes = ExtendedAttribute.parse( ctx.extendedAttributeList() );
    final WebIDLParser.ArgumentRestContext argumentRestContext = ctx.argumentRest();
    final WebIDLParser.ArgumentNameContext argumentNameContext = argumentRestContext.argumentName();
    final TerminalNode identifier = argumentNameContext.IDENTIFIER();
    final String name = null != identifier ? identifier.getText() : argumentNameContext.argumentNameKeyword().getText();
    final WebIDLParser.TypeWithExtendedAttributesContext typeWithExtendedAttributesContext =
      argumentRestContext.typeWithExtendedAttributes();
    final Type type;
    final boolean optional;
    final boolean variadic;
    final DefaultValue defaultValue;
    if ( null != typeWithExtendedAttributesContext )
    {
      type = Type.parse( typeWithExtendedAttributesContext );
      optional = true;
      variadic = false;
      final WebIDLParser.DefaultValueContext defaultValueContext =
        argumentRestContext.defaultAssignment().defaultValue();
      defaultValue = null != defaultValueContext ? DefaultValue.parse( defaultValueContext ) : null;
    }
    else
    {
      type = Type.parse( argumentRestContext.type() );
      optional = false;
      variadic = argumentRestContext.ellipsis().getChildCount() > 0;
      defaultValue = null;
    }
    return new Argument( name, type, optional, variadic, defaultValue, extendedAttributes );
  }
}
