package elemental3.core;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsConstructorFn;

@JsType( name = "Reflect", isNative = true, namespace = JsPackage.GLOBAL )
public class Reflect
{
  @JsFunction
  public interface ApplyTargetFn<RESULT>
  {
    RESULT onInvoke( Object... p0 );
  }

  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface OwnKeysArrayUnionType
  {
    @JsOverlay
    static OwnKeysArrayUnionType of( Object o )
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

  public static native <THIS, RESULT> RESULT apply(
    ApplyTargetFn<? extends RESULT> targetFn, THIS thisArg, JsArray<Object> argList );

  @JsOverlay
  public static final <THIS, RESULT> RESULT apply(
    ApplyTargetFn<? extends RESULT> targetFn, THIS thisArg, Object[] argList )
  {
    return apply( targetFn, thisArg, Js.<JsArray<Object>>uncheckedCast( argList ) );
  }

  @JsOverlay
  public static final <TARGET> TARGET construct(
    Class<?> targetConstructorFn,
    JsArray<Object> argList,
    Class<? extends TARGET> newTargetConstructorFn )
  {
    return construct(
      Js.asConstructorFn( targetConstructorFn ),
      argList,
      Js.asConstructorFn( newTargetConstructorFn ) );
  }

  @JsOverlay
  public static final <TARGET> TARGET construct(
    Class<?> targetConstructorFn, JsArray<Object> argList )
  {
    return construct( Js.asConstructorFn( targetConstructorFn ), argList );
  }

  @JsOverlay
  public static final <TARGET> TARGET construct(
    Class<?> targetConstructorFn,
    Object[] argList,
    Class<? extends TARGET> newTargetConstructorFn )
  {
    return construct(
      targetConstructorFn, Js.<JsArray<Object>>uncheckedCast( argList ), newTargetConstructorFn );
  }

  @JsOverlay
  public static final <TARGET> TARGET construct( Class<?> targetConstructorFn, Object[] argList )
  {
    return construct( targetConstructorFn, Js.<JsArray<Object>>uncheckedCast( argList ) );
  }

  public static native <TARGET> TARGET construct(
    JsConstructorFn<?> targetConstructorFn,
    JsArray<Object> argList,
    JsConstructorFn<? extends TARGET> newTargetConstructorFn );

  public static native <TARGET> TARGET construct(
    JsConstructorFn<?> targetConstructorFn, JsArray<Object> argList );

  @JsOverlay
  public static final <TARGET> TARGET construct(
    JsConstructorFn<?> targetConstructorFn,
    Object[] argList,
    JsConstructorFn<? extends TARGET> newTargetConstructorFn )
  {
    return construct(
      targetConstructorFn, Js.<JsArray<Object>>uncheckedCast( argList ), newTargetConstructorFn );
  }

  @JsOverlay
  public static final <TARGET> TARGET construct(
    JsConstructorFn<?> targetConstructorFn, Object[] argList )
  {
    return construct( targetConstructorFn, Js.<JsArray<Object>>uncheckedCast( argList ) );
  }

  public static native boolean defineProperty(
    JsObject target, String propertyKey, ObjectPropertyDescriptor attributes );

  @JsOverlay
  public static final boolean defineProperty(
    Object target, String propertyKey, ObjectPropertyDescriptor attributes )
  {
    return defineProperty( Js.uncheckedCast( target ), propertyKey, attributes );
  }

  public static native boolean deleteProperty( JsObject target, String propertyKey );

  @JsOverlay
  public static final boolean deleteProperty( Object target, String propertyKey )
  {
    return deleteProperty( Js.uncheckedCast( target ), propertyKey );
  }

  public static native Object get( JsObject target, String propertyKey, JsObject receiver );

  public static native Object get( JsObject target, String propertyKey );

  @JsOverlay
  public static final Object get( Object target, String propertyKey, Object receiver )
  {
    return get(
      Js.uncheckedCast( target ), propertyKey, Js.uncheckedCast( receiver ) );
  }

  @JsOverlay
  public static final Object get( Object target, String propertyKey )
  {
    return get( Js.uncheckedCast( target ), propertyKey );
  }

  public static native ObjectPropertyDescriptor getOwnPropertyDescriptor(
    JsObject target, String propertyKey );

  @JsOverlay
  public static final ObjectPropertyDescriptor getOwnPropertyDescriptor(
    Object target, String propertyKey )
  {
    return getOwnPropertyDescriptor( Js.uncheckedCast( target ), propertyKey );
  }

  public static native JsObject getPrototypeOf( JsObject target );

  @JsOverlay
  public static final JsObject getPrototypeOf( Object target )
  {
    return getPrototypeOf( Js.uncheckedCast( target ) );
  }

  public static native boolean has( JsObject target, String propertyKey );

  @JsOverlay
  public static final boolean has( Object target, String propertyKey )
  {
    return has( Js.uncheckedCast( target ), propertyKey );
  }

  public static native boolean isExtensible( JsObject target );

  @JsOverlay
  public static final boolean isExtensible( Object target )
  {
    return isExtensible( Js.uncheckedCast( target ) );
  }

  public static native JsArray<OwnKeysArrayUnionType> ownKeys( JsObject target );

  @JsOverlay
  public static final JsArray<OwnKeysArrayUnionType> ownKeys( Object target )
  {
    return ownKeys( Js.uncheckedCast( target ) );
  }

  public static native boolean preventExtensions( JsObject target );

  @JsOverlay
  public static final boolean preventExtensions( Object target )
  {
    return preventExtensions( Js.uncheckedCast( target ) );
  }

  public static native boolean set(
    JsObject target, String propertyKey, Object value, JsObject receiver );

  public static native boolean set( JsObject target, String propertyKey, Object value );

  @JsOverlay
  public static final boolean set(
    Object target, String propertyKey, Object value, Object receiver )
  {
    return set(
      Js.uncheckedCast( target ),
      propertyKey,
      value,
      Js.uncheckedCast( receiver ) );
  }

  @JsOverlay
  public static final boolean set( Object target, String propertyKey, Object value )
  {
    return set( Js.uncheckedCast( target ), propertyKey, value );
  }

  public static native boolean setPrototypeOf( JsObject target, JsObject proto );

  @JsOverlay
  public static final boolean setPrototypeOf( Object target, Object proto )
  {
    return setPrototypeOf( Js.uncheckedCast( target ), Js.uncheckedCast( proto ) );
  }
}
