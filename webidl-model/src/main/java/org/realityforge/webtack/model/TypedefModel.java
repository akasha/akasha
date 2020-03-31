package org.realityforge.webtack.model;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.realityforge.webtack.webidl.parser.WebIDLParser;

public final class TypedefModel
{
  @Nonnull
  private final String _name;
  @Nonnull
  private final Type _type;

  TypedefModel( @Nonnull final String name, @Nonnull final Type type )
  {
    _name = Objects.requireNonNull( name );
    _type = Objects.requireNonNull( type );
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

  @Nonnull
  public static TypedefModel parse( @Nonnull final WebIDLParser.TypedefContext ctx )
  {
    final String name = ctx.IDENTIFIER().getText();
    final Type type = Type.parse( ctx.typeWithExtendedAttributes() );
    return new TypedefModel( name, type );
  }
}
