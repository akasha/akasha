package elemental3.core;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "?" )
public interface ArrayBufferView
  extends BufferSource
{
  @JsProperty( name = "buffer" )
  @Nonnull
  ArrayBuffer buffer();

  @JsProperty( name = "byteLength" )
  int byteLength();

  @JsProperty( name = "byteOffset" )
  int byteOffset();

  @JsProperty( name = "length" )
  int length();
}
