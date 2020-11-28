package elemental3.core;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( name = "String", isNative = true, namespace = JsPackage.GLOBAL )
public class JsString
  implements JsIterable<String>
{
  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface LocaleCompareLocalesUnionType
  {
    @JsOverlay
    static LocaleCompareLocalesUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default JsArray<String> asJsArray()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default String asString()
    {
      return Js.asString( this );
    }

    @JsOverlay
    default boolean isJsArray()
    {
      return this instanceof JsArray;
    }

    @JsOverlay
    default boolean isString()
    {
      return (Object) this instanceof String;
    }
  }

  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface ReplacePatternUnionType
  {
    @JsOverlay
    static ReplacePatternUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default JsRegExp asJsRegExp()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default String asString()
    {
      return Js.asString( this );
    }

    @JsOverlay
    default boolean isJsRegExp()
    {
      return this instanceof JsRegExp;
    }

    @JsOverlay
    default boolean isString()
    {
      return (Object) this instanceof String;
    }
  }

  @JsFunction
  public interface ReplaceReplacementFn
  {
    Object onInvoke( String p0, Object... p1 );
  }

  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface ReplaceReplacementUnionType
  {
    @JsOverlay
    static ReplaceReplacementUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default ReplaceReplacementFn asReplaceReplacementFn()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default String asString()
    {
      return Js.asString( this );
    }

    @JsOverlay
    default boolean isReplaceReplacementFn()
    {
      return this instanceof ReplaceReplacementFn;
    }

    @JsOverlay
    default boolean isString()
    {
      return (Object) this instanceof String;
    }
  }

  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface SearchPatternUnionType
  {
    @JsOverlay
    static SearchPatternUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default JsRegExp asJsRegExp()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default String asString()
    {
      return Js.asString( this );
    }

    @JsOverlay
    default boolean isJsRegExp()
    {
      return this instanceof JsRegExp;
    }

    @JsOverlay
    default boolean isString()
    {
      return (Object) this instanceof String;
    }
  }

  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface ToLocaleLowerCaseLocalesUnionType
  {
    @JsOverlay
    static ToLocaleLowerCaseLocalesUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default JsArray<String> asJsArray()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default String asString()
    {
      return Js.asString( this );
    }

    @JsOverlay
    default boolean isJsArray()
    {
      return this instanceof JsArray;
    }

    @JsOverlay
    default boolean isString()
    {
      return (Object) this instanceof String;
    }
  }

  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface ToLocaleUpperCaseLocalesUnionType
  {
    @JsOverlay
    static ToLocaleUpperCaseLocalesUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default JsArray<String> asJsArray()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default String asString()
    {
      return Js.asString( this );
    }

    @JsOverlay
    default boolean isJsArray()
    {
      return this instanceof JsArray;
    }

    @JsOverlay
    default boolean isString()
    {
      return (Object) this instanceof String;
    }
  }

  public static native String fromCharCode( int... var_args );

  public static native String fromCodePoint( int codePoint, int... var_args );

  public int length;

  public JsString()
  {
  }

  public JsString( Object str )
  {
  }

  public native String anchor();

  public native String big();

  public native String blink();

  public native String bold();

  public native String charAt( int index );

  public native int charCodeAt();

  public native int charCodeAt( int index );

  public native int codePointAt( int index );

  public native String concat( Object... var_args );

  public native boolean endsWith( String searchString, int position );

  public native boolean endsWith( String searchString );

  public native String fixed();

  public native String fontcolor( String color );

  public native String fontsize( int size );

  public native boolean includes( String searchString, int position );

  public native boolean includes( String searchString );

  public native int indexOf( String searchValue, int fromIndex );

  public native int indexOf( String searchValue );

  public native String italics();

  public native int lastIndexOf( String searchValue, int fromIndex );

  public native int lastIndexOf( String searchValue );

  public native String link( String hrefAttribute );

  @JsOverlay
  public final int localeCompare( String compareString, JsArray<String> locales, JsObject options )
  {
    return localeCompare(
      compareString, Js.<LocaleCompareLocalesUnionType>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final int localeCompare( String compareString, JsArray<String> locales, Object options )
  {
    return localeCompare( compareString, locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final int localeCompare( String compareString, JsArray<String> locales )
  {
    return localeCompare(
      compareString, Js.<LocaleCompareLocalesUnionType>uncheckedCast( locales ) );
  }

  public native int localeCompare(
    String compareString, LocaleCompareLocalesUnionType locales, JsObject options );

  @JsOverlay
  public final int localeCompare(
    String compareString, LocaleCompareLocalesUnionType locales, Object options )
  {
    return localeCompare( compareString, locales, Js.uncheckedCast( options ) );
  }

  public native int localeCompare(
    String compareString, LocaleCompareLocalesUnionType locales );

  @JsOverlay
  public final int localeCompare( String compareString, String locales, JsObject options )
  {
    return localeCompare(
      compareString, Js.<LocaleCompareLocalesUnionType>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final int localeCompare( String compareString, String[] locales, JsObject options )
  {
    return localeCompare( compareString, Js.<JsArray<String>>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final int localeCompare( String compareString, String locales, Object options )
  {
    return localeCompare( compareString, locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final int localeCompare( String compareString, String[] locales, Object options )
  {
    return localeCompare( compareString, locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final int localeCompare( String compareString, String locales )
  {
    return localeCompare(
      compareString, Js.<LocaleCompareLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final int localeCompare( String compareString, String[] locales )
  {
    return localeCompare( compareString, Js.<JsArray<String>>uncheckedCast( locales ) );
  }

  public native int localeCompare( String compareString );

  public native JsArray<String> match( Object regexp );

  public native String normalize();

  public native String normalize( String form );

  public native String padEnd( int targetLength, String padString );

  public native String padEnd( int targetLength );

  public native String padStart( int targetLength, String padString );

  public native String padStart( int targetLength );

  public native String quote();

  public native String repeat( int count );

  @JsOverlay
  public final String replace( JsRegExp pattern, ReplaceReplacementFn replacement )
  {
    return replace(
      Js.<ReplacePatternUnionType>uncheckedCast( pattern ),
      Js.<ReplaceReplacementUnionType>uncheckedCast( replacement ) );
  }

  @JsOverlay
  public final String replace( JsRegExp pattern, ReplaceReplacementUnionType replacement )
  {
    return replace( Js.<ReplacePatternUnionType>uncheckedCast( pattern ), replacement );
  }

  @JsOverlay
  public final String replace( JsRegExp pattern, String replacement )
  {
    return replace(
      Js.<ReplacePatternUnionType>uncheckedCast( pattern ),
      Js.<ReplaceReplacementUnionType>uncheckedCast( replacement ) );
  }

  @JsOverlay
  public final String replace(
    ReplacePatternUnionType pattern, ReplaceReplacementFn replacement )
  {
    return replace( pattern, Js.<ReplaceReplacementUnionType>uncheckedCast( replacement ) );
  }

  public native String replace(
    ReplacePatternUnionType pattern, ReplaceReplacementUnionType replacement );

  @JsOverlay
  public final String replace( ReplacePatternUnionType pattern, String replacement )
  {
    return replace( pattern, Js.<ReplaceReplacementUnionType>uncheckedCast( replacement ) );
  }

  @JsOverlay
  public final String replace( String pattern, ReplaceReplacementFn replacement )
  {
    return replace(
      Js.<ReplacePatternUnionType>uncheckedCast( pattern ),
      Js.<ReplaceReplacementUnionType>uncheckedCast( replacement ) );
  }

  @JsOverlay
  public final String replace( String pattern, ReplaceReplacementUnionType replacement )
  {
    return replace( Js.<ReplacePatternUnionType>uncheckedCast( pattern ), replacement );
  }

  @JsOverlay
  public final String replace( String pattern, String replacement )
  {
    return replace(
      Js.<ReplacePatternUnionType>uncheckedCast( pattern ),
      Js.<ReplaceReplacementUnionType>uncheckedCast( replacement ) );
  }

  @JsOverlay
  public final int search( JsRegExp pattern )
  {
    return search( Js.<SearchPatternUnionType>uncheckedCast( pattern ) );
  }

  public native int search( SearchPatternUnionType pattern );

  @JsOverlay
  public final int search( String pattern )
  {
    return search( Js.<SearchPatternUnionType>uncheckedCast( pattern ) );
  }

  public native String slice( int begin, int end );

  public native String slice( int begin );

  public native String small();

  public native JsArray<String> split();

  public native JsArray<String> split( Object separator, int limit );

  public native JsArray<String> split( Object separator );

  public native boolean startsWith( String searchString, int position );

  public native boolean startsWith( String searchString );

  public native String strike();

  public native String sub();

  public native String substr( int start, int length );

  public native String substr( int start );

  public native String substring( int start, int end );

  public native String substring( int start );

  public native String sup();

  public native String toLocaleLowerCase();

  @JsOverlay
  public final String toLocaleLowerCase( JsArray<String> locales )
  {
    return toLocaleLowerCase( Js.<ToLocaleLowerCaseLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final String toLocaleLowerCase( String locales )
  {
    return toLocaleLowerCase( Js.<ToLocaleLowerCaseLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final String toLocaleLowerCase( String[] locales )
  {
    return toLocaleLowerCase( Js.<JsArray<String>>uncheckedCast( locales ) );
  }

  public native String toLocaleLowerCase( ToLocaleLowerCaseLocalesUnionType locales );

  public native String toLocaleUpperCase();

  @JsOverlay
  public final String toLocaleUpperCase( JsArray<String> locales )
  {
    return toLocaleUpperCase( Js.<ToLocaleUpperCaseLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final String toLocaleUpperCase( String locales )
  {
    return toLocaleUpperCase( Js.<ToLocaleUpperCaseLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final String toLocaleUpperCase( String[] locales )
  {
    return toLocaleUpperCase( Js.<JsArray<String>>uncheckedCast( locales ) );
  }

  public native String toLocaleUpperCase( ToLocaleUpperCaseLocalesUnionType locales );

  public native String toLowerCase();

  public native String toSource();

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
