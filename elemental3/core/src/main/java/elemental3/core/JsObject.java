package elemental3.core;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType( name = "Object", isNative = true, namespace = JsPackage.GLOBAL )
public class JsObject
{
  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface DefinePropertyPropUnionType
  {
    @JsOverlay
    static DefinePropertyPropUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default Object asObject()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default String asString()
    {
      return Js.asString( this );
    }

    @JsOverlay
    default boolean isObject()
    {
      return this instanceof Object;
    }

    @JsOverlay
    default boolean isString()
    {
      return (Object) this instanceof String;
    }
  }

  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface EntriesArrayArrayUnionType<T>
  {
    @JsOverlay
    static EntriesArrayArrayUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default String asString()
    {
      return Js.asString( this );
    }

    @JsOverlay
    default T asT()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default boolean isString()
    {
      return (Object) this instanceof String;
    }
  }

  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface GetOwnPropertyDescriptorPropUnionType
  {
    @JsOverlay
    static GetOwnPropertyDescriptorPropUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default Object asObject()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default String asString()
    {
      return Js.asString( this );
    }

    @JsOverlay
    default boolean isObject()
    {
      return this instanceof Object;
    }

    @JsOverlay
    default boolean isString()
    {
      return (Object) this instanceof String;
    }
  }

  public static native JsObject assign( JsObject target, JsObject... var_args );

  @JsOverlay
  public static final JsObject assign( Object target, Object... var_args )
  {
    return assign( Js.uncheckedCast( target ), Js.<JsObject>uncheckedCast( var_args ) );
  }

  public static native JsObject create( JsObject proto, JsObject properties );

  public static native JsObject create( JsObject proto );

  @JsOverlay
  public static final JsObject create( Object proto, Object properties )
  {
    return create( Js.uncheckedCast( proto ), Js.uncheckedCast( properties ) );
  }

  @JsOverlay
  public static final JsObject create( Object proto )
  {
    return create( Js.uncheckedCast( proto ) );
  }

  public static native JsObject defineProperties( JsObject obj, JsObject props );

  @JsOverlay
  public static final JsObject defineProperties( Object obj, Object props )
  {
    return defineProperties( Js.uncheckedCast( obj ), Js.uncheckedCast( props ) );
  }

  public static native JsObject defineProperty(
    JsObject obj, DefinePropertyPropUnionType prop, JsObject descriptor );

  @JsOverlay
  public static final JsObject defineProperty( JsObject obj, Object prop, JsObject descriptor )
  {
    return defineProperty(
      obj, Js.<DefinePropertyPropUnionType>uncheckedCast( prop ), descriptor );
  }

  @JsOverlay
  public static final JsObject defineProperty( JsObject obj, String prop, JsObject descriptor )
  {
    return defineProperty(
      obj, Js.<DefinePropertyPropUnionType>uncheckedCast( prop ), descriptor );
  }

  @JsOverlay
  public static final JsObject defineProperty(
    Object obj, DefinePropertyPropUnionType prop, Object descriptor )
  {
    return defineProperty(
      Js.uncheckedCast( obj ), prop, Js.uncheckedCast( descriptor ) );
  }

  @JsOverlay
  public static final JsObject defineProperty( Object obj, Object prop, Object descriptor )
  {
    return defineProperty(
      Js.uncheckedCast( obj ), prop, Js.uncheckedCast( descriptor ) );
  }

  @JsOverlay
  public static final JsObject defineProperty( Object obj, String prop, Object descriptor )
  {
    return defineProperty(
      Js.uncheckedCast( obj ), prop, Js.uncheckedCast( descriptor ) );
  }

  public static native <T> JsArray<JsArray<EntriesArrayArrayUnionType<T>>> entries(
    JsPropertyMap<T> obj );

  public static native <T> T freeze( T obj );

  public static native JsObject fromEntries( JsIterable<Object> iter );

  public static native <T> ObjectPropertyDescriptor<T> getOwnPropertyDescriptor(
    T obj, GetOwnPropertyDescriptorPropUnionType prop );

  @JsOverlay
  public static final <T> ObjectPropertyDescriptor<T> getOwnPropertyDescriptor( T obj, Object prop )
  {
    return getOwnPropertyDescriptor(
      obj, Js.<GetOwnPropertyDescriptorPropUnionType>uncheckedCast( prop ) );
  }

  @JsOverlay
  public static final <T> ObjectPropertyDescriptor<T> getOwnPropertyDescriptor( T obj, String prop )
  {
    return getOwnPropertyDescriptor(
      obj, Js.<GetOwnPropertyDescriptorPropUnionType>uncheckedCast( prop ) );
  }

  public static native JsPropertyMap<ObjectPropertyDescriptor> getOwnPropertyDescriptors(
    JsObject obj );

  @JsOverlay
  public static final JsPropertyMap<ObjectPropertyDescriptor> getOwnPropertyDescriptors(
    Object obj )
  {
    return getOwnPropertyDescriptors( Js.uncheckedCast( obj ) );
  }

  public static native JsArray<String> getOwnPropertyNames( JsObject obj );

  @JsOverlay
  public static final JsArray<String> getOwnPropertyNames( Object obj )
  {
    return getOwnPropertyNames( Js.uncheckedCast( obj ) );
  }

  public static native JsArray<Object> getOwnPropertySymbols( JsObject obj );

  @JsOverlay
  public static final JsArray<Object> getOwnPropertySymbols( Object obj )
  {
    return getOwnPropertySymbols( Js.uncheckedCast( obj ) );
  }

  public static native JsObject getPrototypeOf( JsObject obj );

  @JsOverlay
  public static final JsObject getPrototypeOf( Object obj )
  {
    return getPrototypeOf( Js.uncheckedCast( obj ) );
  }

  public static native boolean is( Object p0, Object p1 );

  public static native boolean isExtensible( JsObject obj );

  @JsOverlay
  public static final boolean isExtensible( Object obj )
  {
    return isExtensible( Js.uncheckedCast( obj ) );
  }

  public static native boolean isFrozen( JsObject obj );

  @JsOverlay
  public static final boolean isFrozen( Object obj )
  {
    return isFrozen( Js.uncheckedCast( obj ) );
  }

  public static native boolean isSealed( JsObject obj );

  @JsOverlay
  public static final boolean isSealed( Object obj )
  {
    return isSealed( Js.uncheckedCast( obj ) );
  }

  public static native JsArray<String> keys( JsObject obj );

  @JsOverlay
  public static final JsArray<String> keys( Object obj )
  {
    return keys( Js.uncheckedCast( obj ) );
  }

  public static native <T> T preventExtensions( T obj );

  public static native <T> T seal( T obj );

  public static native JsObject setPrototypeOf( JsObject obj, Object proto );

  @JsOverlay
  public static final JsObject setPrototypeOf( Object obj, Object proto )
  {
    return setPrototypeOf( Js.uncheckedCast( obj ), proto );
  }

  public static native <T> JsArray<T> values( JsPropertyMap<T> obj );

  @Deprecated
  public JsObject __parent__;
  public JsObject __proto__;
  public JsFunction constructor;

  public JsObject()
  {
  }

  public JsObject( Object value )
  {
  }

  @Deprecated
  public native void __defineGetter__( String sprop, JsFunction fun );

  @Deprecated
  public native void __defineSetter__( String sprop, JsFunction fun );

  @Deprecated
  public native JsFunction __lookupGetter__( String sprop );

  @Deprecated
  public native JsFunction __lookupSetter__( String sprop );

  @Deprecated
  public native Object __noSuchMethod__( JsFunction fun );

  public native boolean hasOwnProperty( Object propertyName );

  public native boolean isPrototypeOf( JsObject other );

  @JsOverlay
  public final boolean isPrototypeOf( Object other )
  {
    return isPrototypeOf( Js.uncheckedCast( other ) );
  }

  public native boolean propertyIsEnumerable( String propertyName );

  public native Object toJSON();

  public native Object toJSON( String key );

  public native String toLocaleString();

  public native String toSource();

  @JsMethod( name = "toString" )
  public native String toString_();

  public native Object valueOf();
}
