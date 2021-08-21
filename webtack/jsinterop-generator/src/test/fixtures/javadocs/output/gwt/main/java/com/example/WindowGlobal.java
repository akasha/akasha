package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
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
    namespace = JsPackage.GLOBAL,
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
  @Nonnull
  public static native String someVar();
}
