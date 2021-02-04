package elemental3.core;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The WeakSet object lets you store weakly held objects in a collection.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakSet">WeakSet - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-weakset-objects">WeakSet Objects - ECMA</a>
 */
@JsType( name = "WeakSet", isNative = true, namespace = JsPackage.GLOBAL )
public class JsWeakSet<T>
{
  /**
   * The WeakSet constructor lets you create WeakSet objects that store weakly held objects in a collection.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakSet/WeakSet">WeakSet() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakset-constructor">WeakSet Constructor - ECMA</a>
   */
  public JsWeakSet()
  {
  }

  /**
   * The WeakSet constructor lets you create WeakSet objects that store weakly held objects in a collection.
   *
   * @param values the iterable that will have all of it's elements added to the WeakSet.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakSet/WeakSet">WeakSet() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakset-constructor">WeakSet Constructor - ECMA</a>
   */
  public JsWeakSet( @Nonnull final JsIterable<T> values )
  {
  }

  /**
   * The WeakSet constructor lets you create WeakSet objects that store weakly held objects in a collection.
   *
   * @param values the array that will have all of it's elements added to the WeakSet.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakSet/WeakSet">WeakSet() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakset-constructor">WeakSet Constructor - ECMA</a>
   */
  public JsWeakSet( @Nonnull final T[] values )
  {
  }

  /**
   * The add() method appends a new object to the end of a WeakSet object.
   *
   * @param value the object to add to the WeakSet collection.
   * @return the WeakSet object.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakSet/add">WeakSet.prototype.add() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakset.prototype.add">WeakSet.prototype.add() - ECMA</a>
   */
  @Nonnull
  public native JsWeakSet<T> add( @Nonnull T value );

  /**
   * The delete() method removes the specified element from a WeakSet object.
   *
   * @param value the object remove from the WeakSet object.
   * @return true if an element in the WeakSet object has been removed successfully. false if the value is not found in the WeakSet or if the value is not an object.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakSet/delete">WeakSet.prototype.delete() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakset.prototype.delete">WeakSet.prototype.delete() - ECMA</a>
   */
  public native boolean delete( @Nonnull T value );

  /**
   * The has() method returns a boolean indicating whether an object exists in a WeakSet or not.
   *
   * @param value the object to test for presence in the WeakSet.
   * @return true if an element with the specified value exists in the WeakSet object, otherwise false.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakSet/has">WeakSet.prototype.has() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakset.prototype.has">WeakSet.prototype.has() - ECMA</a>
   */
  public native boolean has( @Nonnull T value );
}
