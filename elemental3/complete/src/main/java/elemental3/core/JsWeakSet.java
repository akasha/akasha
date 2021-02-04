package elemental3.core;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( name = "WeakSet", isNative = true, namespace = JsPackage.GLOBAL )
public class JsWeakSet<VALUE>
{
  public JsWeakSet()
  {
  }

  public JsWeakSet( @Nonnull JsIterable<VALUE> iterable )
  {
  }

  public JsWeakSet( @Nonnull VALUE[] iterable )
  {
  }

  @Nonnull
  public native JsWeakSet<VALUE> add( VALUE value );

  public native void clear();

  public native boolean delete( @Nonnull VALUE value );

  public native boolean has( @Nonnull VALUE value );
}
