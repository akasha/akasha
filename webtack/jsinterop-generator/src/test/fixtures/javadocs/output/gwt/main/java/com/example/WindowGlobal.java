package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Documentation for WindowToSoul type that defines a global execution context.
 *
 * @see <a href="http://example.com/API/WindowToSoul">WindowToSoul - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = "<window>",
    name = "$wnd"
)
public final class WindowGlobal {
  private WindowGlobal() {
  }

  /**
   * Documentation for Window.someVar attribute.
   *
   * @see <a href="http://example.com/API/WindowToSoul/someVar">WindowToSoul.someVar - MDN</a>
   */
  @JsProperty(
      name = "someVar"
  )
  @JsNonNull
  public static native String someVar();
}
