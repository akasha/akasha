package elemental3.core;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( name = "WeakSet", isNative = true, namespace = JsPackage.GLOBAL )
public class JsWeakSet<VALUE>
{
  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface ConstructorIterableUnionType<VALUE>
  {
    @JsOverlay
    static <T> ConstructorIterableUnionType<T> of( Object o )
    {
      return Js.cast( o );
    }

    @JsOverlay
    default JsArray<VALUE> asJsArray()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default JsIterable<VALUE> asJsIterable()
    {
      return Js.cast( this );
    }

    @JsOverlay
    default boolean isJsArray()
    {
      return this instanceof JsArray;
    }
  }

  public JsWeakSet()
  {
  }

  public JsWeakSet( ConstructorIterableUnionType<VALUE> iterable )
  {
  }

  public JsWeakSet( JsArray<VALUE> iterable )
  {
  }

  public JsWeakSet( JsIterable<VALUE> iterable )
  {
  }

  public JsWeakSet( VALUE[] iterable )
  {
  }

  public native JsWeakSet<VALUE> add( VALUE value );

  public native void clear();

  public native boolean delete( VALUE value );

  public native boolean has( VALUE value );
}
