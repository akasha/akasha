package elemental3.lang;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, name = "Iterator", namespace = JsPackage.GLOBAL )
public interface JsIterator<T>
{
  JsIIterableResult<T> next();

  JsIIterableResult<T> next( Object value );
}
