package elemental3.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

@JsType( name = "Arguments", isNative = true, namespace = JsPackage.GLOBAL )
public class Arguments
  implements JsIterable<Object>, JsArrayLike<Object>
{
  public JsFunction callee;
  public int length;
}
