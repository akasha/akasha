package elemental3.core;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( name = "WeakSet", isNative = true, namespace = JsPackage.GLOBAL )
public class JsWeakSet<T>
{
  public JsWeakSet()
  {
  }

  public JsWeakSet( @Nonnull final JsIterable<T> values )
  {
  }

  public JsWeakSet( @Nonnull final T[] values )
  {
  }

  @Nonnull
  public native JsWeakSet<T> add( T value );

  public native boolean delete( @Nonnull T value );

  public native boolean has( @Nonnull T value );
}
