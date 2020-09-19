package org.realityforge.webtack.jsinterop;

import javax.annotation.Nonnull;

final class ExtendedAttributes
{
  /**
   * The Transferable extended attribute is defined by the standard as appearing on interfaces that can
   * be transferred between contexts. We have also allow the attribute to appear on operation arguments and
   * dictionary members that have the type {@code sequence<object>}. In this case it indicates that the argument
   * or member can contain transferable interfaces.
   *
   * @see <a href="https://html.spec.whatwg.org/multipage/structured-data.html#transferable-objects">Transferable - HTML Specification</a>
   */
  @Nonnull
  static final String TRANSFERABLE = "Transferable";

  private ExtendedAttributes()
  {
  }
}
