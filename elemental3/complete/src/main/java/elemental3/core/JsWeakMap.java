package elemental3.core;

import elemental3.lang.JsArray;
import elemental3.lang.JsIterable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The WeakMap object is a collection of key/value pairs in which the keys are weakly referenced. The keys must be objects and the values can be arbitrary values.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakMap">WeakMap - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-weakmap-objects">WeakMap Objects - ECMA</a>
 */
@JsType( name = "WeakMap", isNative = true, namespace = JsPackage.GLOBAL )
public class JsWeakMap<K, V>
{
  /**
   * The WeakMap() constructor creates WeakMap objects which are a collections of key/value pairs in which the keys are weakly referenced. The keys must be objects and the values can be arbitrary values.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakMap/WeakMap">WeakMap() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakmap-constructor">WeakMap Constructor - ECMA</a>
   */
  public JsWeakMap()
  {
  }

  /**
   * The WeakMap() constructor creates WeakMap objects which are a collections of key/value pairs in which the keys are weakly referenced. The keys must be objects and the values can be arbitrary values.
   *
   * @param pairs an array of pairs that will be added to the WeakMap.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakMap/WeakMap">WeakMap() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakmap-constructor">WeakMap Constructor - ECMA</a>
   */
  @SafeVarargs
  public JsWeakMap( @Nonnull final Entry<K, V>... pairs )
  {
  }

  /**
   * The WeakMap() constructor creates WeakMap objects which are a collections of key/value pairs in which the keys are weakly referenced. The keys must be objects and the values can be arbitrary values.
   *
   * @param pairs an iterable containing pairs that will be added to the WeakMap.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakMap/WeakMap">WeakMap() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakmap-constructor">WeakMap Constructor - ECMA</a>
   */
  public JsWeakMap( @Nonnull final JsIterable<Entry<K, V>> pairs )
  {
  }

  /**
   * The delete() method removes the specified element from a WeakMap object.
   *
   * @param key the key of the element to remove from the WeakMap object.
   * @return true if an element in the WeakMap object has been removed successfully, false if the key is not found in the WeakMap or if the key is not an object.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakMap/delete">WeakMap.prototype.delete() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakmap.prototype.delete">WeakMap.prototype.delete() - ECMA</a>
   */
  public native boolean delete( @Nonnull K key );

  /**
   * The get() method returns a specified element from a WeakMap object.
   *
   * @param key the key of the element to return from the WeakMap object.
   * @return the element associated with the specified key in the WeakMap object or null if no such element.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakMap/get">WeakMap.prototype.get() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakmap.prototype.get">WeakMap.prototype.get() - ECMA</a>
   */
  @Nullable
  public native V get( @Nonnull K key );

  /**
   * The has() method returns a boolean indicating whether an element with the specified key exists in the WeakMap object or not.
   *
   * @param key the key of the element to test for presence in the WeakMap object.
   * @return true if an element with the specified key exists in the WeakMap object, otherwise false.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakMap/has">WeakMap.prototype.has() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakmap.prototype.has">WeakMap.prototype.has() - ECMA</a>
   */
  public native boolean has( @Nonnull K key );

  /**
   * The set() method adds a new element with a specified key and value to a WeakMap object.
   *
   * @param key   the key of the element to add to the WeakMap object.
   * @param value the value of the element to add to the WeakMap object.
   * @return this WeakMap
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WeakMap/set">WeakMap.prototype.set() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-weakmap.prototype.set">WeakMap.prototype.set() - ECMA</a>
   */
  @Nonnull
  public native JsWeakMap<K, V> set( @Nonnull K key, @Nonnull V value );

  @JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Array" )
  public static final class Entry<K, V>
    extends JsArray<Object>
  {
    @JsOverlay
    @Nonnull
    public K key()
    {
      return getAtAsAny( 0 ).cast();
    }

    @JsOverlay
    @Nullable
    public V value()
    {
      return getAtAsAny( 1 ).cast();
    }
  }
}
