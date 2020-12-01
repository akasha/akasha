package org.realityforge.webtack.model.tools.util;

import javax.annotation.Nonnull;

public final class ExtendedAttributes
{
  /**
   * The Transferable extended attribute is defined by the standard as appearing on interfaces that can
   * be transferred between contexts.
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
   * The JavaNoInline extended attribute can be added to constants. If added to a constant then the constant value
   * will be accessed from the javascript context rather than inlined into the java code.
   *
   * <p>This is the same strategy as used in the elemental2 libraries and may cause the creation of unnecessary
   * &lt;clinit&gt; methods in GWT2.x (J2CL has an optimization pass that eliminates this cost). This should only
   * be used when the constant value MUST be accessed from the java script context (i.e. Math constants which are
   * platform specific or symbol constants that are context specific etc.)</p>
   */
  public static final String JAVA_NO_INLINE = "JavaNoInline";
  /**
   * The MarkerType extended attribute can be added to a UnionType to indicate that the union can be treated as
   * a separate type. The member types of the union be interface types or other [MarkerType] typedefs.
   *
   * <p>When generating the code for this, it should be generated as a java marker interface and the java classes that
   * are generated to model the WebIDL interface types should implement the java interface.</p>
   */
  @Nonnull
  public static final String MARKER_TYPE = "MarkerType";
  /**
   * A custom extended property that specifies the java type of the sequence class.
   */
  @Nonnull
  public static final String JAVA_SEQUENCE_TYPE = "JavaSequenceType";

  private ExtendedAttributes()
  {
  }
}
