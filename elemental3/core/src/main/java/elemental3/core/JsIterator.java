package elemental3.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, name = "Iterator", namespace = JsPackage.GLOBAL )
public interface JsIterator<VALUE>
{
  JsIIterableResult<VALUE> next();

  JsIIterableResult<VALUE> next( Object value );
}
