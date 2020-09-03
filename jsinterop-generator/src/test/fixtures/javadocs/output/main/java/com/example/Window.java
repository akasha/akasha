package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

/**
 * Documentation for Window partial.
 *
 * @see <a href="http://example.com/API/Window">Window - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Window"
)
public final class Window {
  private Window() {
  }

  @JsOverlay
  @Nonnull
  public static Window of(@Nonnull final Object object) {
    return Js.cast( object );
  }

  /**
   * Documentation for Window.someVar attribute.
   *
   * @see <a href="http://example.com/API/Window/someVar">Window.someVar - MDN</a>
   */
  @JsProperty(
      name = "someVar"
  )
  @Nonnull
  public native String someVar();
}
