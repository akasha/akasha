package elemental3.core;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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

  public JsSet( @Nonnull JsIterable<T> values )
  {
  }

  public JsSet( @Nonnull T[] values )
  {
  }

  @Nonnull
  public native JsSet<T> add( @Nullable T value );

  public native void clear();

  public native boolean delete( @Nullable T value );

  @Nonnull
  public native JsIteratorIterable<JsArray<T>> entries();

  public native <THIS> Object forEach( ForEachCallbackFn<? super T> callback, THIS thisArg );

  public native Object forEach( ForEachCallbackFn<? super T> callback );

  public native boolean has( @Nullable T value );

  @Nonnull
  public native JsIteratorIterable<T> keys();

  @Nonnull
  public native JsIteratorIterable<T> values();
}
