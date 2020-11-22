package elemental3.core;

import elemental3.promise.Promise;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL )
public interface AsyncIterator<VALUE>
{
  Promise<JsIIterableResult<VALUE>> next();

  Promise<JsIIterableResult<VALUE>> next( Object p0 );
}
