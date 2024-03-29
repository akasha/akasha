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
   * If the [Global] extended attribute appears on an interface, it indicates that objects implementing this
   * interface will be used as the global object in a Realm.
   *
   * <p>The [Global] extended attribute must either take an identifier or take an identifier list. The global
   * names for the interface are the identifiers that can be used to reference it in the [Exposed] extended
   * attribute. A single name can be shared across multiple different global interfaces, allowing an interface
   * to more easily use [Exposed] to expose itself to all of them at once. For example, "Worker" is used to
   * refer to several distinct types of threading-related global interfaces.</p>
   *
   * @see <a href="https://heycam.github.io/webidl/#Global">Global - WebIDL Specification</a>
   */
  @Nonnull
  public static final String GLOBAL = "Global";
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
   * A custom extended property that specifies the name of the underlying javascript type for the specified element.
   * This is used when a WebIDL artifact is not mapped to javascript type directly due to browser incompatibilities
   * or because the WebIDL is a "synthetic" type introduced to aid modelling for other bindings.
   */
  public static final String JS_NAME = "JsName";
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
   * A type that appears on a Union to indicate it was synthesized without an underlying nominal type.
   * Typically this is to represent unnamed union return types.
   */
  @Nonnull
  public static final String SYNTHETIC = "Synthetic";
  /**
   * A extended attribute that indicates that a type was created internally for modelling purposes and
   * should not be used outside the library. This typically applied to Unions to represent return value
   * of operations with the same name but different return types or attributes across global contexts
   * that differ by type.
   *
   * This may result in types being generated with annotations warning on usage @Api.Internal or as package access.
   */
  @Nonnull
  public static final String INTERNAL = "Internal";
  /**
   * Operations with the same name in WebIDL may return different types but in the javascript binding
   * there is a single function with a return type that varies based on the parameter types and counts.
   * To model this scenario in Closure Compiler compatible manner, the return type for the closure function
   * representing these operations must return a union of all the return types. Then the jsinterop
   * binding adds a @JsOverlay method that "casts" to the specific type expected type of the oepration.
   *
   * This extended attribute specifies the name of the union that represents the underlying return type.
   */
  @Nonnull
  public static final String TYPE_OVERRIDE = "TypeOverride";
  /**
   * Multiple global execution contexts that can be modelled with the Window type, the
   * SharedWorkerGlobalScope type etc. These may have attributes and operations of with the same name
   * but different types. In a similar method to the {@link #TYPE_OVERRIDE}, this extend attribute
   * specifies the underlying type of the attribute or return type of the operation.
   */
  @Nonnull
  public static final String GLOBAL_TYPE_OVERRIDE = "GlobalTypeOverride";
  /**
   * A custom extended property that can appear on a "const enum" that indicates that the const enum
   * represents potential flags in a bitset.
   */
  @Nonnull
  public static final String FLAGS = "Flags";
  /**
   * A custom extended property that can be added to an attribute that indicates that the attribute may not be
   * present in all environments. This usually results in an overlay method like "is[X]Supported()"  being
   * generated in the java binding where X is the attribute with an uppercase first letter. The extended attribute
   * may also accept a name to use to replace X.
   */
  @Nonnull
  public static final String OPTIONAL_SUPPORT = "OptionalSupport";

  private ExtendedAttributes()
  {
  }
}
