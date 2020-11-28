package elemental3.core;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( name = "Set", isNative = true, namespace = JsPackage.GLOBAL )
public class JsSet<VALUE>
  implements JsIterable<VALUE>
{
  @JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
  public interface ConstructorIterableUnionType<VALUE>
  {
    @JsOverlay
    static ConstructorIterableUnionType of( Object o )
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

  @JsFunction
  public interface ForEachCallbackFn<VALUE>
  {
    Object onInvoke( VALUE p0, VALUE p1, JsSet<? extends VALUE> p2 );
  }

  public int size;

  public JsSet()
  {
  }

  public JsSet( ConstructorIterableUnionType<VALUE> iterable )
  {
  }

  public JsSet( JsArray<VALUE> iterable )
  {
  }

  public JsSet( JsIterable<VALUE> iterable )
  {
  }

  public JsSet( VALUE[] iterable )
  {
  }

  public native JsSet<VALUE> add( VALUE value );

  public native void clear();

  public native boolean delete( VALUE value );

  public native JsIteratorIterable<JsArray<VALUE>> entries();

  public native <THIS> Object forEach(
    ForEachCallbackFn<? super VALUE> callback, THIS thisArg );

  public native Object forEach( ForEachCallbackFn<? super VALUE> callback );

  public native boolean has( VALUE value );

  public native JsIteratorIterable<VALUE> keys();

  public native JsIteratorIterable<VALUE> values();
}
