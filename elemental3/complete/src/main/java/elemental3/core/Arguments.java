package elemental3.core;

import elemental3.lang.JsIterable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.JsArrayLike;

/**
 * arguments is an Array-like object accessible inside functions that contains the values of the arguments passed to that function.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/arguments">The arguments object - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-arguments-exotic-objects">Arguments Exotic Objects - ECMA</a>
 */
@JsType( name = "Object", isNative = true, namespace = JsPackage.GLOBAL )
public class Arguments
  implements JsIterable<Object>, JsArrayLike<Object>
{
  /**
   * The arguments.callee property contains the currently executing function.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/arguments/callee">arguments.callee - MDN</a>
   */
  @JsProperty( name = "callee" )
  public native JsFunction callee();

  /**
   * The length property contains the number of arguments passed to the function.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/arguments/length">arguments.length - MDN</a>
   */
  @JsProperty( name = "length" )
  public native int length();
}
