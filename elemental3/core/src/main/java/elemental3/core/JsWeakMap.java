package elemental3.core;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( name = "WeakMap", isNative = true, namespace = JsPackage.GLOBAL )
public class JsWeakMap<KEY, VALUE>
{
  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface ConstructorIterableJsIterableTypeParameterArrayUnionType<KEY, VALUE>
  {
    @JsOverlay
    static ConstructorIterableJsIterableTypeParameterArrayUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default KEY asKEY()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default VALUE asVALUE()
    {
      return Js.cast( this );
    }
  }

  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface ConstructorIterableUnionType<KEY, VALUE>
  {
    @JsOverlay
    static ConstructorIterableUnionType of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default JsArray<
      JsArray<ConstructorIterableJsIterableTypeParameterArrayUnionType<KEY, VALUE>>>
    asJsArray()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default JsIterable<
      JsArray<ConstructorIterableJsIterableTypeParameterArrayUnionType<KEY, VALUE>>>
    asJsIterable()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default boolean isJsArray()
    {
      return this instanceof JsArray;
    }
  }

  public JsWeakMap()
  {
  }

  public JsWeakMap(
    ConstructorIterableJsIterableTypeParameterArrayUnionType<KEY, VALUE>[][]
      iterable )
  {
  }

  public JsWeakMap( ConstructorIterableUnionType<KEY, VALUE> iterable )
  {
  }

  public JsWeakMap(
    JsArray<
      JsArray<
        ConstructorIterableJsIterableTypeParameterArrayUnionType<KEY, VALUE>>>
      iterable )
  {
  }

  public JsWeakMap(
    JsIterable<
      JsArray<
        ConstructorIterableJsIterableTypeParameterArrayUnionType<KEY, VALUE>>>
      iterable )
  {
  }

  public native void clear();

  public native boolean delete( KEY key );

  public native VALUE get( KEY key );

  public native boolean has( KEY key );

  public native JsWeakMap<KEY, VALUE> set( KEY key, VALUE value );
}
