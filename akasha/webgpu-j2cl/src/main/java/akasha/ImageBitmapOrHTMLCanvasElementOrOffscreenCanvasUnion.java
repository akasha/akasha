package akasha;

import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.ImageBitmap;
import elemental2.dom.OffscreenCanvas;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "ImageBitmapOrHTMLCanvasElementOrOffscreenCanvasUnion" )
public interface ImageBitmapOrHTMLCanvasElementOrOffscreenCanvasUnion
{
  @JsOverlay
  @Nonnull
  static ImageBitmapOrHTMLCanvasElementOrOffscreenCanvasUnion of( @Nonnull final ImageBitmap value )
  {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ImageBitmapOrHTMLCanvasElementOrOffscreenCanvasUnion of( @Nonnull final HTMLCanvasElement value )
  {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static ImageBitmapOrHTMLCanvasElementOrOffscreenCanvasUnion of( @Nonnull final OffscreenCanvas value )
  {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isHTMLCanvasElement()
  {
    return ( (Object) this ) instanceof HTMLCanvasElement;
  }

  @JsOverlay
  default HTMLCanvasElement asHTMLCanvasElement()
  {
    return Js.cast( this );
  }

  // ImageBitmap is an interface in Elemental2 so the instanceof expression is invalid
  //@JsOverlay
  //default boolean isImageBitmap()
  //{
  //  return ( (Object) this ) instanceof ImageBitmap;
  //}

  @JsOverlay
  default ImageBitmap asImageBitmap()
  {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isOffscreenCanvas()
  {
    return ( (Object) this ) instanceof OffscreenCanvas;
  }

  @JsOverlay
  default OffscreenCanvas asOffscreenCanvas()
  {
    return Js.cast( this );
  }
}
