package elemental3.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( name = "WeakSet", isNative = true, namespace = JsPackage.GLOBAL )
public class JsWeakSet<VALUE>
{
  public JsWeakSet()
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
