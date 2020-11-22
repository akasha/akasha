package elemental3.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL )
public interface AsyncIteratorIterable<VALUE>
  extends AsyncIterable<VALUE>, AsyncIterator<VALUE>
{
}
