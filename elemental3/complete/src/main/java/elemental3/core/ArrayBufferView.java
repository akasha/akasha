package elemental3.core;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The ArrayBufferView is used to represent objects that provide a view on to an ArrayBuffer.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/ArrayBufferView">ArrayBufferView - MDN</a>
 * @see <a href="https://heycam.github.io/webidl/#ArrayBufferView">ArrayBufferView - WebIDL</a>
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "?" )
public interface ArrayBufferView
  extends BufferSource
{
  /**
   * The buffer accessor property represents the ArrayBuffer referenced by the ArrayBufferView at construction time.
   */
  @JsProperty( name = "buffer" )
  @Nonnull
  ArrayBuffer buffer();

  /**
   * The byteLength accessor property represents the length (in bytes) of a ArrayBufferView.
   */
  @JsProperty( name = "byteLength" )
  int byteLength();

  /**
   * The byteOffset accessor property represents the offset (in bytes) of a ArrayBufferView from the start of its ArrayBuffer.
   */
  @JsProperty( name = "byteOffset" )
  int byteOffset();

  /**
   * The length accessor property represents the length (in elements) of a ArrayBufferView.
   */
  @JsProperty( name = "length" )
  int length();
}
