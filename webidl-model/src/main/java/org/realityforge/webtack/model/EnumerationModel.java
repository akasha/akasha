package org.realityforge.webtack.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class EnumerationModel
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Set<String> _values;

  EnumerationModel( @Nonnull final String name, @Nonnull final Set<String> values )
  {
    _name = Objects.requireNonNull( name );
    _values = Objects.requireNonNull( values );
  }

  @Nonnull
  public String getName()
  {
    return _name;
  }

  @Nonnull
  public Set<String> getValues()
  {
    return _values;
  }

  @Nonnull
  public static EnumerationModel parse( @Nonnull final WebIDLParser.EnumDefinitionContext ctx )
  {
    final String name = ctx.IDENTIFIER().getText();
    final WebIDLParser.EnumValueListContext enumValueListContext = ctx.enumValueList();
    final Set<String> values = new LinkedHashSet<>();
    values.add( ParseUtil.extractString( enumValueListContext.STRING() ) );

    WebIDLParser.EnumValueListStringContext enumValueListStringContext =
      enumValueListContext.enumValueListComma().enumValueListString();
    while ( null != enumValueListStringContext )
    {
      final TerminalNode string = enumValueListStringContext.STRING();
      if ( null != string )
      {
        values.add( ParseUtil.extractString( string ) );
      }
      final WebIDLParser.EnumValueListCommaContext enumValueListCommaContext =
        enumValueListStringContext.enumValueListComma();
      enumValueListStringContext =
        null != enumValueListCommaContext ? enumValueListCommaContext.enumValueListString() : null;
    }

    return new EnumerationModel( name, Collections.unmodifiableSet( values ) );
  }
}
