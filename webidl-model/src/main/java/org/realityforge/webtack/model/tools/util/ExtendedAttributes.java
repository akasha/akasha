package org.realityforge.webtack.model.tools.util;

import javax.annotation.Nonnull;

public final class ExtendedAttributes
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
  public static final String TRANSFERABLE = "Transferable";
  /**
   * The LegacyNoInterfaceObject extended attribute indicates that an interface object will not exist
   * for the interface in the ECMAScript binding.
   *
   * @see <a href="https://heycam.github.io/webidl/#LegacyNoInterfaceObject">LegacyNoInterfaceObject - WebIDL Specification</a>
   */
  public static final String LEGACY_NO_INTERFACE_OBJECT = "LegacyNoInterfaceObject";
  /**
   * A custom extended property that specifies the sub-package in which to generate element relative to the root element.
   */
  public static final String JAVA_SUB_PACKAGE = "JavaSubPackage";

  private ExtendedAttributes()
  {
  }
}
