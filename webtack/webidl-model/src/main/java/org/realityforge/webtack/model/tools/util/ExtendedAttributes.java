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
   * When the [Exposed] extended attribute appears on an interface, partial interface, interface mixin, partial
   * interface mixin, callback interface, namespace, partial namespace, or an individual interface member,
   * interface mixin member, or namespace member, it indicates that the construct is exposed on that particular
   * set of global interfaces.
   *
   * <p>The [Exposed] extended attribute must either take an identifier or take an identifier list. Each of the
   * identifiers mentioned must be a global name and be unique. This list of identifiers is known as the
   * construct’s own exposure set.</p>
   *
   * @see <a href="https://heycam.github.io/webidl/#Exposed">Exposed - WebIDL Specification</a>
   */
  @Nonnull
  public static final String EXPOSED = "Exposed";
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
   * The LegacyNoInterfaceObject extended attribute indicates that the interface object for this interface
   * will not be created as a property of the global object, but rather as a property of the namespace
   * identified by the argument to the extended attribute.
   *
   * @see <a href="https://heycam.github.io/webidl/#LegacyNamespace">LegacyNamespace - WebIDL Specification</a>
   */
  public static final String LEGACY_NAMESPACE = "LegacyNamespace";
  /**
   * The LegacyFactoryFunction extended attribute indicates that the ECMAScript global object will
   * have a property with the specified name whose value is a function that can create objects that
   * implement the interface.
   *
   * @see <a href="https://heycam.github.io/webidl/#LegacyFactoryFunction">LegacyFactoryFunction - WebIDL Specification</a>
   */
  public static final String LEGACY_FACTORY_FUNCTION = "LegacyFactoryFunction";
  /**
   * Indicates that the operation has no side effects and if the compiler determines that the return
   * value is not needed then the compiler can omit the call. It results in <code>@nosideeffects</code>
   * annotation in closure externs and <code>@HasNoSideEffects</code> annotation in java code.
   */
  public static final String NO_SIDE_EFFECTS = "NoSideEffects";
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
   * A custom extended property that specifies the type of the sequence class.
   * Must be one of Iterable, Iterator or IteratorIterable
   */
  @Nonnull
  public static final String SEQUENCE_TYPE = "SequenceType";
  /**
   * A custom extended property that indicates that the element only exists in the java binding
   * and should be omitted when emitting to other languages. This is usually used on java-only
   * constant values.
   */
  @Nonnull
  public static final String JAVA_ONLY = "JavaOnly";
  /**
   * A custom extended property that indicates that a mixin should be kept and omitted in the FlattenProcessor.
   */
  @Nonnull
  public static final String NO_FLATTEN = "NoFlatten";
  /**
   * A custom extended property that indicates that a mixin should be included in the global object.
   */
  @Nonnull
  public static final String GLOBAL_OBJECT = "GlobalObject";
  /**
   * In javascript there is a single function with name whereas in WebIDL there can be multiple operations
   * with the same name that take different arguments and potentially return different types. When binding
   * to jsinterop with closure externs, special care must be taken when multiple operations exist with the
   * same name that return different types based on arguments. In this scenario we create a UnionType for
   * all the return alternatives and add this extended type onto the union.
   */
  @Nonnull
  public static final String SYNTHESIZED_RETURN = "SynthesizedReturn";

  private ExtendedAttributes()
  {
  }
}
