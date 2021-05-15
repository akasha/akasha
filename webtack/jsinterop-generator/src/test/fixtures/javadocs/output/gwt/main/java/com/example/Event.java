package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Documentation for Event. It covers multiple
 * lines.
 *
 * @see <a href="http://example.com/API/Event">Event - MDN</a>
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Event"
)
public class Event {
  /**
   * Documentation for constant Event.AT_TARGET.
   *
   * @see <a href="http://example.com/API/Event/AT_TARGET">Event.AT_TARGET - MDN</a>
   */
  @JsOverlay
  public static final int AT_TARGET = 2;

  /**
   * Documentation for attribute Event.cancelBubble. It covers multiple
   * lines.
   *
   * @see <a href="http://example.com/API/Event/cancelBubble">Event.cancelBubble - MDN</a>
   */
  public boolean cancelBubble;

  /**
   * Documentation for Event constructor.
   *
   * @see <a href="http://example.com/API/Event/Event">Event.Event - MDN</a>
   */
  public Event(@Nonnull final String type, @Nonnull final EventInit eventInitDict) {
  }

  /**
   * Documentation for Event constructor.
   *
   * @see <a href="http://example.com/API/Event/Event">Event.Event - MDN</a>
   */
  public Event(@Nonnull final String type) {
  }

  /**
   * Documentation for readonly attribute Event.bubbles. It covers multiple
   * lines.
   *
   * @see <a href="http://example.com/API/Event/bubbles">Event.bubbles - MDN</a>
   */
  @JsProperty(
      name = "bubbles"
  )
  public native boolean bubbles();

  /**
   * Documentation for Event.filterGlobalEvent.
   *
   * @return the event.
   * @see <a href="http://example.com/API/Event/filterGlobalEvent">Event.filterGlobalEvent - MDN</a>
   */
  @Nonnull
  public static native Event filterGlobalEvent(@Nonnull String type);

  /**
   * Documentation for Event.composedPath.
   *
   * @return the path.
   * @see <a href="http://example.com/API/Event/composedPath">Event.composedPath - MDN</a>
   */
  @Nonnull
  public native JsArray<EventTarget> composedPath();
}
