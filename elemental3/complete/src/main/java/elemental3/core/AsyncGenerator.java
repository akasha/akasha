package elemental3.core;

import elemental3.promise.Promise;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL )
public interface AsyncGenerator<VALUE>
  extends AsyncIteratorIterable<VALUE>
{
  Promise<JsIIterableResult<VALUE>> next();

  Promise<JsIIterableResult<VALUE>> next( Object value );

  @JsMethod( name = "return" )
  Promise<JsIIterableResult<VALUE>> return_( VALUE value );

  @JsMethod( name = "throw" )
  Promise<JsIIterableResult<VALUE>> throw_( Object exception );
}
