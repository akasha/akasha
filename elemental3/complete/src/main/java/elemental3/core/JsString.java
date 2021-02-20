package elemental3.core;

import elemental3.lang.JsArray;
import elemental3.lang.JsIterable;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;

@JsType( name = "String", isNative = true, namespace = JsPackage.GLOBAL )
public class JsString
  implements JsIterable<String>
{
  public static native String fromCharCode( int... var_args );

  public static native String fromCodePoint( int codePoint, int... var_args );

  public int length;

  public JsString()
  {
  }

  public JsString( Object str )
  {
  }

  public native String charAt( int index );

  public native int charCodeAt();

  public native int charCodeAt( int index );

  public native int codePointAt( int index );

  public native String concat( Object... var_args );

  public native boolean endsWith( String searchString, int position );

  public native boolean endsWith( String searchString );

  public native boolean includes( String searchString, int position );

  public native boolean includes( String searchString );

  public native int indexOf( String searchValue, int fromIndex );

  public native int indexOf( String searchValue );

  public native int lastIndexOf( String searchValue, int fromIndex );

  public native int lastIndexOf( String searchValue );

  public native int localeCompare( @Nonnull String compareString );

  public native int localeCompare( @Nonnull String compareString, @Nonnull String[] locales );

  public native int localeCompare( @Nonnull String compareString,
                                   @Nonnull String[] locales,
                                   @Nonnull JsPropertyMap<Object> options );

  public native int localeCompare( @Nonnull String compareString, @Nonnull JsArray<String> locales );

  public native int localeCompare( @Nonnull String compareString,
                                   @Nonnull JsArray<String> locales,
                                   @Nonnull JsPropertyMap<Object> options );

  public native int localeCompare( @Nonnull String compareString, @Nonnull String locale );

  public native int localeCompare( @Nonnull String compareString,
                                   @Nonnull String locale,
                                   @Nonnull JsPropertyMap<Object> options );

  public native JsArray<String> match( Object regexp );

  public native String normalize();

  public native String normalize( String form );

  public native String padEnd( int targetLength, String padString );

  public native String padEnd( int targetLength );

  public native String padStart( int targetLength, String padString );

  public native String padStart( int targetLength );

  public native String repeat( int count );

  @Nonnull
  public native String replace( @Nonnull RegExp pattern, @Nonnull String replacement );

  @Nonnull
  public native String replace( @Nonnull String pattern, @Nonnull String replacement );

  public native int search( @Nonnull RegExp pattern );

  public native int search( @Nonnull String pattern );

  public native String slice( int begin, int end );

  public native String slice( int begin );

  public native JsArray<String> split();

  public native JsArray<String> split( Object separator, int limit );

  public native JsArray<String> split( Object separator );

  public native boolean startsWith( String searchString, int position );

  public native boolean startsWith( String searchString );

  public native String substring( int start, int end );

  public native String substring( int start );

  @Nonnull
  public native String toLocaleLowerCase( @Nonnull String... locales );

  @Nonnull
  public native String toLocaleUpperCase( @Nonnull String... locales );

  public native String toLowerCase();

  @JsMethod( name = "toString" )
  public native String toString_();

  public native String toUpperCase();

  public native String trim();

  public native String trimEnd();

  public native String trimLeft();

  public native String trimRight();

  public native String trimStart();

  public native String valueOf();
}
