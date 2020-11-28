package elemental3.core;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( name = "Boolean", isNative = true, namespace = JsPackage.GLOBAL )
public class JsBoolean
{
  public JsBoolean()
  {
  }

  public JsBoolean( Object value )
  {
  }

  public native String toSource();

  @JsMethod( name = "toString" )
  public native String toString_();

  public native boolean valueOf();
}
