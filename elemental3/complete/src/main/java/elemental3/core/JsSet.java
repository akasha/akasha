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

  public native void forEach( @Nonnull JsArray.ForEachCallback<T> forEachCallback );

  public native void forEach( @Nonnull JsArray.ForEachCallback2<T> forEachCallback );

  public native void forEach( @Nonnull JsArray.ForEachCallback3<T> forEachCallback );

  public native boolean has( @Nullable T value );

  @Nonnull
  public native JsIteratorIterable<JsArray<T>> entries();

  @Nonnull
  public native JsIteratorIterable<T> keys();

  @Nonnull
  public native JsIteratorIterable<T> values();

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback<T>
  {
    void item( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2<T>
  {
    void item( T value, T key );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3<T>
  {
    void item( T value, T key, @Nonnull JsSet<T> array );
  }
}
