package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * The Object class represents one of JavaScript's data types. It is used to store various keyed collections and more complex entities. Objects can be created using the Object() constructor or the object initializer / literal syntax.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object">Object - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-object-objects">Object - ECMAScript (ECMA-262)</a>
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
public class JsObject
{
  // It should be noted that the primary reason for this class to exist is that closure compiler
  // treats the interface type `Object` differently from non-reference types. There should be an
  // implicit `@extends {Object}` for every non-reference object in the closure type system ... but
  // there is not so we do some unchecked casts to work around this.

  protected JsObject()
  {
  }

  /**
   * The Object.assign() method copies all enumerable own properties from one or more source objects to a target object. It returns the target object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/assign">Object.assign - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.assign">Object.assign - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  public static Object assign( @Nonnull final Object target, @Nonnull final Object... sources )
  {
    return assign( Js.uncheckedCast( target ), sources );
  }

  @JsNonNull
  private static native JsObject assign( @JsNonNull JsObject target, @JsNonNull Object... sources );

  /**
   * The Object.create() method creates a new object, using an existing object as the prototype of the newly created object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/create">Object.create - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.create">Object.create - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  public static JsObject create( @Nullable final Object proto,
                                 @Nullable final JsPropertyMap<ObjectPropertyDescriptor> props )
  {
    return create( Js.uncheckedCast( proto ), props );
  }

  @JsNonNull
  private static native JsObject create( @JsNullable JsObject proto,
                                         @JsNullable JsPropertyMap<ObjectPropertyDescriptor> props );

  /**
   * The Object.create() method creates a new object, using an existing object as the prototype of the newly created object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/create">Object.create - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.create">Object.create - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  public static Object create( @Nullable final Object proto )
  {
    return create( Js.uncheckedCast( proto ) );
  }

  @JsNonNull
  private static native JsObject create( @JsNullable JsObject proto );

  /**
   * The Object.defineProperties() method defines new or modifies existing properties directly on an object, returning the object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperties">Object.defineProperties - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.defineproperties">Object.defineProperties - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  public static void defineProperties( @Nonnull final Object obj,
                                       @Nonnull final JsPropertyMap<ObjectPropertyDescriptor> props )
  {
    defineProperties( Js.uncheckedCast( obj ), props );
  }

  private static native void defineProperties( @JsNonNull JsObject obj,
                                               @JsNonNull JsPropertyMap<ObjectPropertyDescriptor> props );

  /**
   * The static method Object.defineProperty() defines a new property directly on an object, or modifies an existing property on an object, and returns the object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty">Object.defineProperty - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.defineproperty">Object.defineProperty - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  public static void defineProperty( @Nonnull final Object obj,
                                     @Nonnull final String prop,
                                     @Nonnull final ObjectPropertyDescriptor descriptor )
  {
    defineProperty( Js.uncheckedCast( obj ), prop, descriptor );
  }

  private static native void defineProperty( @JsNonNull JsObject obj,
                                             @JsNonNull String prop,
                                             @JsNonNull ObjectPropertyDescriptor descriptor );

  /**
   * The static method Object.defineProperty() defines a new property directly on an object, or modifies an existing property on an object, and returns the object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty">Object.defineProperty - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.defineproperty">Object.defineProperty - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  public static void defineProperty( @Nonnull final Object obj,
                                     @Nonnull final Symbol prop,
                                     @Nonnull final ObjectPropertyDescriptor descriptor )
  {
    defineProperty( Js.uncheckedCast( obj ), prop, descriptor );
  }

  private static native void defineProperty( @JsNonNull JsObject obj,
                                             @JsNonNull Symbol prop,
                                             @JsNonNull ObjectPropertyDescriptor descriptor );

  /**
   * The Object.entries() method returns an array of a given object's own enumerable string-keyed property [key, value] pairs, in the same order as that provided by a for...in loop. (The only important difference is that a for...in loop enumerates properties in the prototype chain as well).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/entries">Object.entries - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.entries">Object.entries - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  public static JsArray<ObjectPropertyEntry> entries( @Nonnull final Object obj )
  {
    return entries( Js.uncheckedCast( obj ) );
  }

  @JsNonNull
  private static native JsArray<ObjectPropertyEntry> entries( @JsNonNull JsObject obj );

  /**
   * The Object.freeze() method freezes an object. A frozen object can no longer be changed; freezing an object prevents new properties from being added to it, existing properties from being removed, prevents changing the enumerability, configurability, or writability of existing properties, and prevents the values of existing properties from being changed. In addition, freezing an object also prevents its prototype from being changed. freeze() returns the same object that was passed in.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/freeze">Object.freeze - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.freeze">Object.freeze - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  public static void freeze( @Nonnull final Object obj )
  {
    freeze( Js.uncheckedCast( obj ) );
  }

  private static native void freeze( @JsNonNull JsObject obj );

  /**
   * The Object.fromEntries() method transforms a list of key-value pairs into an object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/fromEntries">Object.fromEntries - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.fromentries">Object.fromEntries - ECMAScript (ECMA-262)</a>
   */
  @JsNonNull
  public static native JsObject fromEntries( @JsNonNull JsIterable<ObjectPropertyEntry> iterable );

  @JsNullable
  private static native ObjectPropertyDescriptor getOwnPropertyDescriptor( @JsNonNull JsObject obj,
                                                                           @JsNonNull String prop );

  /**
   * The Object.getOwnPropertyDescriptor() method returns an object describing the configuration of a specific property on a given object (that is, one directly present on an object and not in the object's prototype chain). The object returned is mutable but mutating it has no effect on the original property's configuration.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/getOwnPropertyDescriptor">Object.getOwnPropertyDescriptor - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.getownpropertydescriptor">Object.getOwnPropertyDescriptor - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nullable
  public static ObjectPropertyDescriptor getOwnPropertyDescriptor( @Nonnull final Object obj,
                                                                   @Nonnull final String prop )
  {
    return getOwnPropertyDescriptor( Js.uncheckedCast( obj ), prop );
  }

  @JsNullable
  private static native ObjectPropertyDescriptor getOwnPropertyDescriptor( @JsNonNull JsObject obj,
                                                                           @JsNonNull Symbol prop );

  /**
   * The Object.getOwnPropertyDescriptor() method returns an object describing the configuration of a specific property on a given object (that is, one directly present on an object and not in the object's prototype chain). The object returned is mutable but mutating it has no effect on the original property's configuration.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/getOwnPropertyDescriptor">Object.getOwnPropertyDescriptor - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.getownpropertydescriptor">Object.getOwnPropertyDescriptor - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nullable
  public static ObjectPropertyDescriptor getOwnPropertyDescriptor( @Nonnull final Object obj,
                                                                   @Nonnull final Symbol prop )
  {
    return getOwnPropertyDescriptor( Js.uncheckedCast( obj ), prop );
  }

  @JsNonNull
  private static native JsPropertyMap<ObjectPropertyDescriptor> getOwnPropertyDescriptors( @JsNonNull JsObject obj );

  /**
   * The Object.getOwnPropertyDescriptors() method returns all own property descriptors of a given object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/getOwnPropertyDescriptors">Object.getOwnPropertyDescriptors - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.getownpropertydescriptors">Object.getOwnPropertyDescriptors - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  public static JsPropertyMap<ObjectPropertyDescriptor> getOwnPropertyDescriptors( @Nonnull final Object obj )
  {
    return getOwnPropertyDescriptors( Js.uncheckedCast( obj ) );
  }

  @JsNonNull
  private static native JsArray<String> getOwnPropertyNames( @JsNonNull JsObject obj );

  /**
   * The Object.getOwnPropertyNames() method returns an array of all properties (including non-enumerable properties except for those which use Symbol) found directly in a given object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/getOwnPropertyNames">Object.getOwnPropertyNames - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.getownpropertynames">Object.getOwnPropertyNames - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  public static JsArray<String> getOwnPropertyNames( @Nonnull final Object obj )
  {
    return getOwnPropertyNames( Js.uncheckedCast( obj ) );
  }

  @JsNonNull
  private static native JsArray<Symbol> getOwnPropertySymbols( @JsNonNull JsObject obj );

  /**
   * The Object.getOwnPropertySymbols() method returns an array of all symbol properties found directly upon a given object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/getOwnPropertySymbols">Object.getOwnPropertySymbols - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.getownpropertysymbols">Object.getOwnPropertySymbols - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  public static JsArray<Symbol> getOwnPropertySymbols( @Nonnull final Object obj )
  {
    return getOwnPropertySymbols( Js.uncheckedCast( obj ) );
  }

  @JsNullable
  private static native JsObject getPrototypeOf( @JsNonNull JsObject obj );

  /**
   * The Object.getPrototypeOf() method returns the prototype (i.e. the value of the internal [[Prototype]] property) of the specified object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/getPrototypeOf">Object.getPrototypeOf - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.getprototypeof">Object.getPrototypeOf - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nullable
  public static JsObject getPrototypeOf( @Nonnull final Object obj )
  {
    return getPrototypeOf( Js.uncheckedCast( obj ) );
  }

  /**
   * The Object.is() method determines whether two values are the same value.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/is">Object.is - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.is">Object.is - ECMAScript (ECMA-262)</a>
   */
  public static native boolean is( @JsNonNull Object value1, @JsNonNull Object value2 );

  /**
   * The Object.isExtensible() method determines if an object is extensible (whether it can have new properties added to it).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/isExtensible">Object.isExtensible - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.isextensible">Object.isExtensible - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  public static boolean isExtensible( @Nonnull final Object obj )
  {
    return isExtensible( Js.uncheckedCast( obj ) );
  }

  private static native boolean isExtensible( @JsNonNull JsObject obj );

  /**
   * The Object.isFrozen() determines if an object is frozen.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/isFrozen">Object.isFrozen - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.isfrozen">Object.isFrozen - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  public static boolean isFrozen( @Nonnull final Object obj )
  {
    return isFrozen( Js.uncheckedCast( obj ) );
  }

  private static native boolean isFrozen( @JsNonNull JsObject obj );

  /**
   * The Object.isSealed() method determines if an object is sealed.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/isSealed">Object.isSealed - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.issealed">Object.isSealed - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  public static boolean isSealed( @Nonnull final Object obj )
  {
    return isSealed( Js.uncheckedCast( obj ) );
  }

  private static native boolean isSealed( @JsNonNull JsObject obj );

  /**
   * The Object.keys() method returns an array of a given object's own enumerable property names, iterated in the same order that a normal loop would.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/keys">Object.keys - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.keys">Object.keys - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  public static JsArray<String> keys( @Nonnull final Object obj )
  {
    return keys( Js.uncheckedCast( obj ) );
  }

  @JsNonNull
  private static native JsArray<String> keys( @JsNonNull JsObject obj );

  /**
   * The Object.preventExtensions() method prevents new properties from ever being added to an object (i.e. prevents future extensions to the object).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/preventExtensions">Object.preventExtensions - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.preventextensions">Object.preventExtensions - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  public static void preventExtensions( @Nonnull final Object obj )
  {
    preventExtensions( Js.uncheckedCast( obj ) );
  }

  private static native void preventExtensions( @JsNonNull JsObject obj );

  /**
   * The Object.seal() method seals an object, preventing new properties from being added to it and marking all existing properties as non-configurable. Values of present properties can still be changed as long as they are writable.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/seal">Object.seal - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.seal">Object.seal - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  public static void seal( @Nonnull final Object obj )
  {
    seal( Js.uncheckedCast( obj ) );
  }

  private static native void seal( @JsNonNull JsObject obj );

  /**
   * The Object.setPrototypeOf() method sets the prototype (i.e., the internal [[Prototype]] property) of a specified object to another object or null.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/setPrototypeOf">Object.setPrototypeOf - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.setprototypeof">Object.setPrototypeOf - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  public static void setPrototypeOf( @Nonnull final Object obj, @Nonnull final Object prototype )
  {
    setPrototypeOf( Js.uncheckedCast( obj ), prototype );
  }

  private static native void setPrototypeOf( @JsNonNull JsObject obj, @JsNonNull Object prototype );

  /**
   * The Object.values() method returns an array of a given object's own enumerable property values, in the same order as that provided by a for...in loop. (The only difference is that a for...in loop enumerates properties in the prototype chain as well.)
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/values">Object.values - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.values">Object.values - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  public static JsArray<Any> values( @Nonnull final Object obj )
  {
    return values( Js.uncheckedCast( obj ) );
  }

  @JsNonNull
  private static native JsArray<Any> values( @JsNonNull JsObject obj );

  /**
   * The hasOwnProperty() method returns a boolean indicating whether the object has the specified property as its own property (as opposed to inheriting it).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/hasOwnProperty">Object.prototype.hasOwnProperty - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.prototype.hasownproperty">Object.prototype.hasOwnProperty - ECMAScript (ECMA-262)</a>
   */
  public native boolean hasOwnProperty( @JsNonNull Symbol prop );

  /**
   * The hasOwnProperty() method returns a boolean indicating whether the object has the specified property as its own property (as opposed to inheriting it).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/hasOwnProperty">Object.prototype.hasOwnProperty - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.prototype.hasownproperty">Object.prototype.hasOwnProperty - ECMAScript (ECMA-262)</a>
   */
  public native boolean hasOwnProperty( @JsNonNull String prop );

  /**
   * The propertyIsEnumerable() method returns a Boolean indicating whether the specified property is enumerable and is the object's own property.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/propertyIsEnumerable">Object.prototype.propertyIsEnumerable - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.prototype.propertyisenumerable">Object.prototype.propertyIsEnumerable - ECMAScript (ECMA-262)</a>
   */
  public native boolean propertyIsEnumerable( @JsNonNull String prop );

  /**
   * The isPrototypeOf() method checks if an object exists in another object's prototype chain.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/isPrototypeOf">Object.prototype.isPrototypeOf - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.prototype.isprototypeof">Object.prototype.isPrototypeOf - ECMAScript (ECMA-262)</a>
   */
  public native boolean isPrototypeOf( @JsNonNull JsObject object );

  /**
   * The valueOf() method returns the wrapped primitive value of a Number object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/valueOf">Object.prototype.valueOf - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.prototype.valueof">Object.prototype.valueOf - ECMAScript (ECMA-262)</a>
   */
  @JsMethod( name = "valueOf" )
  public native Any valueOf_();

  /**
   * The valueOf() method returns the wrapped primitive value of a Number object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/toString">Object.prototype.toString - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-object.prototype.tostring">Object.prototype.toString - ECMAScript (ECMA-262)</a>
   */
  @JsMethod( name = "toString" )
  @JsNonNull
  public native String toString_();
}
