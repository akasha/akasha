package elemental3.core;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( name = "Set", isNative = true, namespace = JsPackage.GLOBAL )
public class JsSet<T>
  implements JsIterable<T>
{
  @JsFunction
  public interface ForEachCallbackFn<VALUE>
  {
    Object onInvoke( VALUE p0, VALUE p1, JsSet<? extends VALUE> p2 );
  }

  public int size;

  public JsSet()
  {
  }

  public JsSet( JsIterable<T> iterable )
  {
  }

  public JsSet( T[] iterable )
  {
  }

  public native JsSet<T> add( T value );

  public native void clear();

  public native boolean delete( T value );

  public native JsIteratorIterable<JsArray<T>> entries();

  public native <THIS> Object forEach(
    ForEachCallbackFn<? super T> callback, THIS thisArg );

  public native Object forEach( ForEachCallbackFn<? super T> callback );

  public native boolean has( T value );

  public native JsIteratorIterable<T> keys();

  public native JsIteratorIterable<T> values();
}
