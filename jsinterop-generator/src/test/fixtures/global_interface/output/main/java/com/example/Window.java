package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Window"
)
public class Window extends EventTarget {
  /**
   * The Window.name property gets/sets the name of the window's browsing context.
   */
  @Nonnull
  public String name;

  protected Window() {
  }

  @JsProperty(
      name = "closed"
  )
  public native boolean closed();

  /**
   * The window.isSecureContext read-only property indicates whether a context is capable of using features that require secure contexts.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/isSecureContext">Window.isSecureContext - MDN</a>
   * @see <a href="https://w3c.github.io/webappsec-secure-contexts/">Secure Contexts</a>
   */
  @JsProperty(
      name = "isSecureContext"
  )
  public native boolean isSecureContext();

  public native void scroll(double x, double y);

  public native void scroll(@Nonnull ScrollToOptions options);

  public native void scroll();

  @Nonnull
  public native Object get(@Nonnull String name);
}
