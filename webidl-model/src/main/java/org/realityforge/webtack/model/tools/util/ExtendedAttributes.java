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
   * A attribute applied to no arg constructors that implies special handling by the environment.
   *
   * @see <a href="https://html.spec.whatwg.org/#htmlconstructor">[HTMLConstructor] - HTML Specification</a>
   */
  @Nonnull
  public static final String HTML_CONSTRUCTOR = "HTMLConstructor";
  /**
   * The LegacyNoInterfaceObject extended attribute indicates that an interface object will not exist
   * for the interface in the ECMAScript binding.
   *
   * @see <a href="https://heycam.github.io/webidl/#LegacyNoInterfaceObject">LegacyNoInterfaceObject - WebIDL Specification</a>
   */
  public static final String LEGACY_NO_INTERFACE_OBJECT = "LegacyNoInterfaceObject";
  /**
   * The LegacyFactoryFunction extended attribute indicates that the ECMAScript global object will
   * have a property with the specified name whose value is a function that can create objects that
   * implement the interface.
   *
   * @see <a href="https://heycam.github.io/webidl/#LegacyFactoryFunction">LegacyFactoryFunction - WebIDL Specification</a>
   */
  public static final String LEGACY_FACTORY_FUNCTION = "LegacyFactoryFunction";
  /**
   * A custom extended property that specifies the sub-package in which to generate element relative to the root element.
   */
  public static final String JAVA_SUB_PACKAGE = "JavaSubPackage";
  /**
   * A custom extended property that specifies the name of the java class, method or field when generating for the specified element.
   */
  public static final String JAVA_NAME = "JavaName";
  /**
   * A custom extended property that specifies the name of a java annotation that is added to the the specified element.
   */
  public static final String JAVA_ANNOTATION = "JavaAnnotation";
  /**
   * A custom extended property that can be applied to interfaces that defines a "logical enumeration" consisting of
   * several constants within the interface. i.e.
   *
   * ConstEnumeration=ReadyStateType(UNSENT,OPENED,HEADERS_RECEIVED,LOADING,DONE)
   */
  public static final String CONST_ENUMERATION = "ConstEnumeration";

  private ExtendedAttributes()
  {
  }
}
