package akasha.lang;

import akasha.core.JsUtil;
import akasha.core.Symbol;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
public interface JsIterable<T>
{
  @JsOverlay
  default JsIterator<T> iterator()
  {
    return JsUtil.get( this, Symbol.iterator() );
  }
}
