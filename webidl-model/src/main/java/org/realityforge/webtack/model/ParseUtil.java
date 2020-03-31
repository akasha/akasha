package org.realityforge.webtack.model;

import javax.annotation.Nonnull;
import org.antlr.v4.runtime.tree.TerminalNode;

final class ParseUtil
{
  private ParseUtil(){}

  @Nonnull
  static String extractString( @Nonnull final TerminalNode string )
  {
    final String text = string.getText();
    assert text.startsWith( "\"" );
    assert text.endsWith( "\"" );
    return text.substring( 1, text.length() - 1 );
  }
}
