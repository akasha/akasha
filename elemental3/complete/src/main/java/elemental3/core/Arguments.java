package elemental3.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

@JsType( isNative = true, namespace = JsPackage.GLOBAL )
public class Arguments
  implements JsIterable<Object>, JsArrayLike<Object>
{
  public Function callee;
  @Deprecated
  public Function caller;
  public int length;
}
