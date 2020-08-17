package org.realityforge.webtack.jsinterop;

import java.util.Arrays;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;

final class NamingUtil
{
  private NamingUtil()
  {
  }

  @Nonnull
  static String underscore( @Nonnull final String name )
  {
    return Arrays.stream( name.split( "(?=\\p{Lu})" ) ).map( String::toLowerCase ).collect( Collectors.joining( "_" ) );
  }

  @Nonnull
  static String lowercaseFirstCharacter( @Nonnull final String name )
  {
    return Character.toLowerCase( name.charAt( 0 ) ) + ( name.length() > 1 ? name.substring( 1 ) : "" );
  }

  @Nonnull
  static String uppercaseFirstCharacter( @Nonnull final String name )
  {
    return Character.toUpperCase( name.charAt( 0 ) ) + ( name.length() > 1 ? name.substring( 1 ) : "" );
  }
}
