package elemental3.core;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The Set object lets you store unique values of any type, whether primitive values or object references.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set">Set - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-set-objects">Set Objects - ECMA</a>
 */
@JsType( name = "Set", isNative = true, namespace = JsPackage.GLOBAL )
public class JsSet<T>
  implements JsIterable<T>
{
  /**
   * The Set constructor lets you create Set objects that store unique values of any type, whether primitive values or object references.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/Set">Set Constructor - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-set-constructor">Set Constructor - ECMA</a>
   */
  public JsSet()
  {
  }

  /**
   * The Set constructor lets you create Set objects that store unique values of any type, whether primitive values or object references.
   *
   * @param values the iterable that will have all of it's elements added to the Set.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/Set">Set Constructor - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-set-constructor">Set Constructor - ECMA</a>
   */
  public JsSet( @Nonnull JsIterable<T> values )
  {
  }

  /**
   * The Set constructor lets you create Set objects that store unique values of any type, whether primitive values or object references.
   *
   * @param values the array that will have all of it's elements added to the Set.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/Set">Set Constructor - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-set-constructor">Set Constructor - ECMA</a>
   */
  public JsSet( @Nonnull T[] values )
  {
  }

  /**
   * The size accessor property returns the number of (unique) elements in a Set object.
   *
   * @return an integer representing how many entries the Set object has.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/size">Set.prototype.size - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.size">Set.prototype.size - ECMA</a>
   */
  @JsProperty( name = "size" )
  public native int size();

  /**
   * The add() method appends a new element with a specified value to the end of a Set object.
   *
   * @param value the value of the element to add to the Set object.
   * @return the set.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/add">Set.prototype.add - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.add">Set.prototype.add - ECMA</a>
   */
  @Nonnull
  public native JsSet<T> add( @Nullable T value );

  /**
   * The clear() method removes all elements from a Set object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/clear">Set.prototype.clear - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.clear">Set.prototype.clear - ECMA</a>
   */
  public native void clear();

  /**
   * The delete() method removes a specified value from a Set object, if it is in the set.
   *
   * @param value the value to remove from the set object.
   * @return true if value was already in the set, otherwise false.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/delete">Set.prototype.delete - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.delete">Set.prototype.delete - ECMA</a>
   */
  public native boolean delete( @Nullable T value );

  /**
   * The forEach() method executes a provided function once for each value in the Set object, in insertion order.
   *
   * @param forEachCallback the function to execute for each element.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/forEach">Set.prototype.forEach - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.foreach">Set.prototype.forEach - ECMA</a>
   */
  public native void forEach( @Nonnull ForEachCallback<T> forEachCallback );

  /**
   * The forEach() method executes a provided function once for each value in the Set object, in insertion order.
   *
   * @param forEachCallback the function to execute for each element.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/forEach">Set.prototype.forEach - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.foreach">Set.prototype.forEach - ECMA</a>
   */
  public native void forEach( @Nonnull ForEachCallback2<T> forEachCallback );

  /**
   * The forEach() method executes a provided function once for each value in the Set object, in insertion order.
   *
   * @param forEachCallback the function to execute for each element.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/forEach">Set.prototype.forEach - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.foreach">Set.prototype.forEach - ECMA</a>
   */
  public native void forEach( @Nonnull ForEachCallback3<T> forEachCallback );

  /**
   * The has() method returns a boolean indicating whether an element with the specified value exists in a Set object or not.
   *
   * @return the value to test for presence in the Set object.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/has">Set.prototype.has - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.has">Set.prototype.has - ECMA</a>
   */
  public native boolean has( @Nullable T value );

  /**
   * The entries() method returns a new Iterator object that contains an array of <code>[value, value]</code> for each element in the Set object, in insertion order.
   *
   * @return a new iterator object that contains an array of <code>[value, value]</code> for each element in the given Set, in insertion order.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/entries">Set.prototype.entries - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.entries">Set.prototype.entries - ECMA</a>
   */
  @Nonnull
  public native JsIteratorIterable<JsArray<T>> entries();

  /**
   * The keys() method returns a new iterator object that contains the values for each element in the Set object in insertion order.
   *
   * @return a new iterator object containing the values for each element in the given Set, in insertion order.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/keys">Set.prototype.keys - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.keys">Set.prototype.keys - ECMA</a>
   */
  @Nonnull
  public native JsIteratorIterable<T> keys();

  /**
   * The values() method returns a new iterator object that contains the values for each element in the Set object in insertion order.
   *
   * @return a new iterator object containing the values for each element in the given Set, in insertion order.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set/values">Set.prototype.values - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-set.prototype.values">Set.prototype.values - ECMA</a>
   */
  @Nonnull
  public native JsIteratorIterable<T> values();

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback<T>
  {
    void item( T value );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2<T>
  {
    void item( T value, T key );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3<T>
  {
    void item( T value, T key, @Nonnull JsSet<T> array );
  }
}
