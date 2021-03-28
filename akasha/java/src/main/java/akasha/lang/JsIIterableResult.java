package akasha.lang;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType( isNative = true, name = "Object", namespace = JsPackage.GLOBAL )
public interface JsIIterableResult<T>
{
  @JsProperty
  T getValue();

  @JsProperty
  boolean isDone();
}
