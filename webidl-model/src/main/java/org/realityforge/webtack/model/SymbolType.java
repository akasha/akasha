package org.realityforge.webtack.model;

import javax.annotation.Nonnull;

public final class SymbolType
  extends Type
{
  @Nonnull
  public static final SymbolType SYMBOL = new SymbolType( "symbol", false );
  @Nonnull
  public static final SymbolType NULLABLE_SYMBOL = new SymbolType( "symbol", true );

  private SymbolType( @Nonnull final String name, final boolean nullable )
  {
    super( name, nullable );
  }
}
