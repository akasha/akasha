package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterable;
import jsinterop.base.Any;
import jsinterop.base.JsPropertyMap;

@SuppressWarnings( { "unused", "ConstantConditions" } )
public final class JsObjectTestCompile
{
  static JsObject $typeReference$;

  public static Object assign( final Object target, final Object... sources )
  {
    return JsObject.assign( target, sources );
  }

  public static JsObject create( final Object proto, final JsPropertyMap<ObjectPropertyDescriptor> props )
  {
    return JsObject.create( proto, props );
  }

  public static Object create( final Object proto )
  {
    return JsObject.create( proto );
  }

  public static void defineProperties( final Object obj, final JsPropertyMap<ObjectPropertyDescriptor> props )
  {
    JsObject.defineProperties( obj, props );
  }

  public static void defineProperty( final Object obj, final String prop, final ObjectPropertyDescriptor descriptor )
  {
    JsObject.defineProperty( obj, prop, descriptor );
  }

  public static void defineProperty( final Object obj, final Symbol prop, final ObjectPropertyDescriptor descriptor )
  {
    JsObject.defineProperty( obj, prop, descriptor );
  }

  public static JsArray<ObjectPropertyEntry> entries( final Object obj )
  {
    return JsObject.entries( obj );
  }

  public static void freeze( final Object obj )
  {
    JsObject.freeze( obj );
  }

  public static JsObject fromEntries( final JsIterable<ObjectPropertyEntry> iterable )
  {
    return JsObject.fromEntries( iterable );
  }

  public static ObjectPropertyDescriptor getOwnPropertyDescriptor( final JsObject obj, final String prop )
  {
    return JsObject.getOwnPropertyDescriptor( obj, prop );
  }

  public static ObjectPropertyDescriptor getOwnPropertyDescriptor( final JsObject obj, final Symbol prop )
  {
    return JsObject.getOwnPropertyDescriptor( obj, prop );
  }

  public static ObjectPropertyDescriptor getOwnPropertyDescriptor( final Object obj, final String prop )
  {
    return JsObject.getOwnPropertyDescriptor( obj, prop );
  }

  public static ObjectPropertyDescriptor getOwnPropertyDescriptor( final Object obj, final Symbol prop )
  {
    return JsObject.getOwnPropertyDescriptor( obj, prop );
  }

  public static JsPropertyMap<ObjectPropertyDescriptor> getOwnPropertyDescriptors( final JsObject obj )
  {
    return JsObject.getOwnPropertyDescriptors( obj );
  }

  public static JsPropertyMap<ObjectPropertyDescriptor> getOwnPropertyDescriptors( final Object obj )
  {
    return JsObject.getOwnPropertyDescriptors( obj );
  }

  public static JsArray<String> getOwnPropertyNames( final JsObject obj )
  {
    return JsObject.getOwnPropertyNames( obj );
  }

  public static JsArray<String> getOwnPropertyNames( final Object obj )
  {
    return JsObject.getOwnPropertyNames( obj );
  }

  public static JsArray<Symbol> getOwnPropertySymbols( final JsObject obj )
  {
    return JsObject.getOwnPropertySymbols( obj );
  }

  public static JsArray<Symbol> getOwnPropertySymbols( final Object obj )
  {
    return JsObject.getOwnPropertySymbols( obj );
  }

  public static JsObject getPrototypeOf( final JsObject obj )
  {
    return JsObject.getPrototypeOf( obj );
  }

  public static JsObject getPrototypeOf( final Object obj )
  {
    return JsObject.getPrototypeOf( obj );
  }

  public static boolean is( final Object value1, final Object value2 )
  {
    return JsObject.is( value1, value2 );
  }

  public static boolean isExtensible( final Object obj )
  {
    return JsObject.isExtensible( obj );
  }

  public static boolean isExtensible( final JsObject obj )
  {
    return JsObject.isExtensible( obj );
  }

  public static boolean isFrozen( final Object obj )
  {
    return JsObject.isFrozen( obj );
  }

  public static boolean isFrozen( final JsObject obj )
  {
    return JsObject.isFrozen( obj );
  }

  public static boolean isSealed( final Object obj )
  {
    return JsObject.isSealed( obj );
  }

  public static boolean isSealed( final JsObject obj )
  {
    return JsObject.isSealed( obj );
  }

  public static JsArray<String> keys( final Object obj )
  {
    return JsObject.keys( obj );
  }

  public static JsArray<String> keys( final JsObject obj )
  {
    return JsObject.keys( obj );
  }

  public static void preventExtensions( final Object obj )
  {
    JsObject.preventExtensions( obj );
  }

  public static void preventExtensions( final JsObject obj )
  {
    JsObject.preventExtensions( obj );
  }

  public static void seal( final Object obj )
  {
    JsObject.seal( obj );
  }

  public static void seal( final JsObject obj )
  {
    JsObject.seal( obj );
  }

  public static void setPrototypeOf( final Object obj, final Object prototype )
  {
    JsObject.setPrototypeOf( obj, prototype );
  }

  public static void setPrototypeOf( final JsObject obj, final Object prototype )
  {
    JsObject.setPrototypeOf( obj, prototype );
  }

  public static JsArray<Any> values( final Object obj )
  {
    return JsObject.values( obj );
  }

  public static JsArray<Any> values( final JsObject obj )
  {
    return JsObject.values( obj );
  }

  public static boolean hasOwnProperty( final JsObject $instance, final Symbol prop )
  {
    return $instance.hasOwnProperty( prop );
  }

  public static boolean hasOwnProperty( final JsObject $instance, final String prop )
  {
    return $instance.hasOwnProperty( prop );
  }

  public static boolean propertyIsEnumerable( final JsObject $instance, final String prop )
  {
    return $instance.propertyIsEnumerable( prop );
  }

  public static boolean isPrototypeOf( final JsObject $instance, final Object object )
  {
    return $instance.isPrototypeOf( object );
  }

  public static Any valueOf_( final JsObject $instance )
  {
    return $instance.valueOf_();
  }

  public static String toString_( final JsObject $instance )
  {
    return $instance.toString_();
  }
}
