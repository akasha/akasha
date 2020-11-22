package elemental3.core;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL )
public interface Generator<VALUE>
  extends JsIteratorIterable<VALUE>
{
  JsIIterableResult<VALUE> next();

  JsIIterableResult<VALUE> next( Object value );

  @JsMethod( name = "return" )
  JsIIterableResult<VALUE> return_( VALUE value );

  @JsMethod( name = "throw" )
  JsIIterableResult<VALUE> throw_( Object exception );
}
