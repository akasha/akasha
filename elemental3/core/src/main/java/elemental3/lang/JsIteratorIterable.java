package elemental3.lang;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
public interface JsIteratorIterable<T>
  extends JsIterable<T>, JsIterator<T>
{
}
