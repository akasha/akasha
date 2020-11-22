package elemental3.core;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( isNative = true, name = "Date", namespace = JsPackage.GLOBAL )
public class JsDate
{
  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface ToLocaleDateStringLocalesUnionType
  {
    @JsOverlay
    static ToLocaleDateStringLocalesUnionType of( Object o )
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
  public interface ToLocaleTimeStringLocalesUnionType
  {
    @JsOverlay
    static ToLocaleTimeStringLocalesUnionType of( Object o )
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

  public static native double UTC(
    double year,
    double month,
    double date,
    double hours,
    double minute,
    double second,
    double ms );

  public static native double UTC(
    double year, double month, double date, double hours, double minute, double second );

  public static native double UTC(
    double year, double month, double date, double hours, double minute );

  public static native double UTC( double year, double month, double date, double hours );

  public static native double UTC( double year, double month, double date );

  public static native double UTC( double year, double month );

  public static native double now();

  public static native double parse( Object date );

  public JsDate()
  {
  }

  public JsDate(
    Object yr_num,
    Object mo_num,
    Object day_num,
    Object hr_num,
    Object min_num,
    Object sec_num,
    Object ms_num )
  {
  }

  public JsDate(
    Object yr_num,
    Object mo_num,
    Object day_num,
    Object hr_num,
    Object min_num,
    Object sec_num )
  {
  }

  public JsDate( Object yr_num, Object mo_num, Object day_num, Object hr_num, Object min_num )
  {
  }

  public JsDate( Object yr_num, Object mo_num, Object day_num, Object hr_num )
  {
  }

  public JsDate( Object yr_num, Object mo_num, Object day_num )
  {
  }

  public JsDate( Object yr_num, Object mo_num )
  {
  }

  public JsDate( Object yr_num )
  {
  }

  public native int getDate();

  public native int getDay();

  public native int getFullYear();

  public native int getHours();

  public native int getMilliseconds();

  public native int getMinutes();

  public native int getMonth();

  public native int getSeconds();

  public native double getTime();

  public native int getTimezoneOffset();

  public native int getUTCDate();

  public native int getUTCDay();

  public native int getUTCFullYear();

  public native int getUTCHours();

  public native int getUTCMilliseconds();

  public native int getUTCMinutes();

  public native int getUTCMonth();

  public native int getUTCSeconds();

  public native int getYear();

  public native double setDate( int dayValue );

  public native double setFullYear( int yearValue, int monthValue, int dayValue );

  public native double setFullYear( int yearValue, int monthValue );

  public native double setFullYear( int yearValue );

  public native double setHours( int hoursValue, int minutesValue, int secondsValue, int msValue );

  public native double setHours( int hoursValue, int minutesValue, int secondsValue );

  public native double setHours( int hoursValue, int minutesValue );

  public native double setHours( int hoursValue );

  public native double setMilliseconds( int millisecondsValue );

  public native double setMinutes( int minutesValue, int secondsValue, int msValue );

  public native double setMinutes( int minutesValue, int secondsValue );

  public native double setMinutes( int minutesValue );

  public native double setMonth( int monthValue, int dayValue );

  public native double setMonth( int monthValue );

  public native double setSeconds( int secondsValue, int msValue );

  public native double setSeconds( int secondsValue );

  public native double setTime( double timeValue );

  public native double setUTCDate( int dayValue );

  public native double setUTCFullYear( int yearValue, int monthValue, int dayValue );

  public native double setUTCFullYear( int yearValue, int monthValue );

  public native double setUTCFullYear( int yearValue );

  public native double setUTCHours( int hoursValue, int minutesValue, int secondsValue, int msValue );

  public native double setUTCHours( int hoursValue, int minutesValue, int secondsValue );

  public native double setUTCHours( int hoursValue, int minutesValue );

  public native double setUTCHours( int hoursValue );

  public native double setUTCMilliseconds( int millisecondsValue );

  public native double setUTCMinutes( int minutesValue, int secondsValue, int msValue );

  public native double setUTCMinutes( int minutesValue, int secondsValue );

  public native double setUTCMinutes( int minutesValue );

  public native double setUTCMonth( int monthValue, int dayValue );

  public native double setUTCMonth( int monthValue );

  public native double setUTCSeconds( int secondsValue, int msValue );

  public native double setUTCSeconds( int secondsValue );

  @Deprecated
  public native double setYear( int yearValue );

  public native String toDateString();

  public native String toGMTString();

  public native String toISOString();

  public native String toJSON();

  public native String toJSON( Object ignoredKey );

  public native String toLocaleDateString();

  @JsOverlay
  public final String toLocaleDateString( JsArray<String> locales, JsObject options )
  {
    return toLocaleDateString(
      Js.<ToLocaleDateStringLocalesUnionType>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final String toLocaleDateString( JsArray<String> locales, Object options )
  {
    return toLocaleDateString( locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final String toLocaleDateString( JsArray<String> locales )
  {
    return toLocaleDateString( Js.<ToLocaleDateStringLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final String toLocaleDateString( String locales, JsObject options )
  {
    return toLocaleDateString(
      Js.<ToLocaleDateStringLocalesUnionType>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final String toLocaleDateString( String[] locales, JsObject options )
  {
    return toLocaleDateString( Js.<JsArray<String>>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final String toLocaleDateString( String locales, Object options )
  {
    return toLocaleDateString( locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final String toLocaleDateString( String[] locales, Object options )
  {
    return toLocaleDateString( locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final String toLocaleDateString( String locales )
  {
    return toLocaleDateString( Js.<ToLocaleDateStringLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final String toLocaleDateString( String[] locales )
  {
    return toLocaleDateString( Js.<JsArray<String>>uncheckedCast( locales ) );
  }

  public native String toLocaleDateString(
    ToLocaleDateStringLocalesUnionType locales, JsObject options );

  @JsOverlay
  public final String toLocaleDateString(
    ToLocaleDateStringLocalesUnionType locales, Object options )
  {
    return toLocaleDateString( locales, Js.uncheckedCast( options ) );
  }

  public native String toLocaleDateString( ToLocaleDateStringLocalesUnionType locales );

  public native String toLocaleFormat( String formatString );

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

  public native String toLocaleTimeString();

  @JsOverlay
  public final String toLocaleTimeString( JsArray<String> locales, JsObject options )
  {
    return toLocaleTimeString(
      Js.<ToLocaleTimeStringLocalesUnionType>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final String toLocaleTimeString( JsArray<String> locales, Object options )
  {
    return toLocaleTimeString( locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final String toLocaleTimeString( JsArray<String> locales )
  {
    return toLocaleTimeString( Js.<ToLocaleTimeStringLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final String toLocaleTimeString( String locales, JsObject options )
  {
    return toLocaleTimeString(
      Js.<ToLocaleTimeStringLocalesUnionType>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final String toLocaleTimeString( String[] locales, JsObject options )
  {
    return toLocaleTimeString( Js.<JsArray<String>>uncheckedCast( locales ), options );
  }

  @JsOverlay
  public final String toLocaleTimeString( String locales, Object options )
  {
    return toLocaleTimeString( locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final String toLocaleTimeString( String[] locales, Object options )
  {
    return toLocaleTimeString( locales, Js.uncheckedCast( options ) );
  }

  @JsOverlay
  public final String toLocaleTimeString( String locales )
  {
    return toLocaleTimeString( Js.<ToLocaleTimeStringLocalesUnionType>uncheckedCast( locales ) );
  }

  @JsOverlay
  public final String toLocaleTimeString( String[] locales )
  {
    return toLocaleTimeString( Js.<JsArray<String>>uncheckedCast( locales ) );
  }

  public native String toLocaleTimeString(
    ToLocaleTimeStringLocalesUnionType locales, JsObject options );

  @JsOverlay
  public final String toLocaleTimeString(
    ToLocaleTimeStringLocalesUnionType locales, Object options )
  {
    return toLocaleTimeString( locales, Js.uncheckedCast( options ) );
  }

  public native String toLocaleTimeString( ToLocaleTimeStringLocalesUnionType locales );

  public native String toSource();

  @JsMethod( name = "toString" )
  public native String toString_();

  public native String toTimeString();

  public native String toUTCString();

  public native double valueOf();
}
