package elemental3.core;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( name = "Number", isNative = true, namespace = JsPackage.GLOBAL )
public class JsNumber
{
  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface ToLocaleStringLocalesUnionType
  {
    @JsOverlay
    static ToLocaleStringLocalesUnionType of( Object o )
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
  public interface ToStringRadixUnionType
  {
    @JsOverlay
    static ToStringRadixUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default int asInt()
    {
      return Js.asInt( this );
    }

    @JsOverlay
    default JsNumber asJsNumber()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default boolean isInt()
    {
      return (Object) this instanceof Double;
    }

    @JsOverlay
    default boolean isJsNumber()
    {
      return this instanceof JsNumber;
    }
  }

  @JsOverlay
  public static final double EPSILON = JsNumber__Constants.EPSILON;
  @JsOverlay
  public static final double MAX_SAFE_INTEGER = JsNumber__Constants.MAX_SAFE_INTEGER;
  @JsOverlay
  public static final double MAX_VALUE = JsNumber__Constants.MAX_VALUE;
  @JsOverlay
  public static final double MIN_SAFE_INTEGER = JsNumber__Constants.MIN_SAFE_INTEGER;
  @JsOverlay
  public static final double MIN_VALUE = JsNumber__Constants.MIN_VALUE;
  @JsOverlay
  public static final double NEGATIVE_INFINITY = JsNumber__Constants.NEGATIVE_INFINITY;
  @JsOverlay
  public static final double NaN = JsNumber__Constants.NaN;
  @JsOverlay
  public static final double POSITIVE_INFINITY = JsNumber__Constants.POSITIVE_INFINITY;

  public static native boolean isFinite( double value );

  public static native boolean isInteger( double value );

  public static native boolean isNaN( double value );

  public static native boolean isSafeInteger( double value );

  public static native double parseFloat( String string );

  public static native int parseInt( String string, int radix );

  public JsNumber()
  {
  }

  public JsNumber( Object value )
  {
  }

  public native String toExponential();

  public native String toExponential( double fractionDigits );

  public native String toFixed();

  public native String toFixed( Object digits );

  public native String toLocaleString();

  @JsOverlay
  public final String toLocaleString( JsArray<String> locales, JsObject options )
  {
    return toLocaleString(
      Js.<ToLocaleStringLocalesUnionType>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final String toLocaleString( JsArray<String> locales, Object options )
  {
    return toLocaleString( locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final String toLocaleString( JsArray<String> locales )
  {
    return toLocaleString( Js.<ToLocaleStringLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final String toLocaleString( String locales, JsObject options )
  {
    return toLocaleString(
      Js.<ToLocaleStringLocalesUnionType>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final String toLocaleString( String[] locales, JsObject options )
  {
    return toLocaleString( Js.<JsArray<String>>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final String toLocaleString( String locales, Object options )
  {
    return toLocaleString( locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final String toLocaleString( String[] locales, Object options )
  {
    return toLocaleString( locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final String toLocaleString( String locales )
  {
    return toLocaleString( Js.<ToLocaleStringLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final String toLocaleString( String[] locales )
  {
    return toLocaleString( Js.<JsArray<String>>uncheckedCast( locales ) );
  }

  public native String toLocaleString(
    ToLocaleStringLocalesUnionType locales, JsObject options );

  @JsOverlay
  public final String toLocaleString(
    ToLocaleStringLocalesUnionType locales, Object options )
  {
    return toLocaleString( locales, Js.uncheckedCast( options ) );
  }

  public native String toLocaleString( ToLocaleStringLocalesUnionType locales );

  public native String toPrecision();

  public native String toPrecision( double precision );

  @JsOverlay
  public final String toString( JsNumber radix )
  {
    return toString( Js.<ToStringRadixUnionType>uncheckedCast( radix ) );
  }

  public native String toString( ToStringRadixUnionType radix );

  @JsOverlay
  public final String toString( int radix )
  {
    return toString( Js.<ToStringRadixUnionType>uncheckedCast( radix ) );
  }

  @JsMethod( name = "toString" )
  public native String toString_();

  public native double valueOf();
}
