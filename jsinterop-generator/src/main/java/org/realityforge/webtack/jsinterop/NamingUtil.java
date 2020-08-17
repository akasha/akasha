package org.realityforge.webtack.jsinterop;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

  static boolean isCamelCase( @Nonnull final String name )
  {
    return name.equals( camelCase( name ) );
  }

  @Nonnull
  static String camelCase( @Nonnull final String name )
  {
    final String[] parts = splitIntoWords( name );
    if ( 0 != parts.length )
    {
      if ( parts[ 0 ].equals( parts[ 0 ].toUpperCase() ) )
      {
        parts[ 0 ] = parts[ 0 ].toLowerCase();
      }
      else
      {
        parts[ 0 ] = lowercaseFirstCharacter( parts[ 0 ] );
      }
    }
    for ( int i = 1; i < parts.length; i++ )
    {
      parts[ i ] = uppercaseFirstCharacter( parts[ i ] );
    }

    return String.join( "", parts );
  }

  static boolean isPascalCase( @Nonnull final String name )
  {
    return name.equals( pascalCase( name ) );
  }

  @Nonnull
  static String pascalCase( @Nonnull final String name )
  {
    return Stream
      .of( splitIntoWords( name ) )
      .map( NamingUtil::uppercaseFirstCharacter )
      .collect( Collectors.joining() );
  }

  @Nonnull
  private static String[] splitIntoWords( @Nonnull final String name )
  {
    return name
      .replaceAll( "^[_-]", "" )
      .replaceAll( "([A-Z]+)([A-Z][a-z])", "$1_$2" )
      .replaceAll( "([a-z\\d])([A-Z])", "$1_$2" )
      .replace( '-', '_' )
      .split( "_" );
  }
}
