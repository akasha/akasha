package elemental3.core;

import elemental3.lang.JsArray;
import elemental3.lang.JsIterable;
import elemental3.lang.JsIteratorIterable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * The Map object holds key-value pairs and remembers the original insertion order of the keys.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map">Map - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-map-objects">Map Objects - ECMA</a>
 */
@JsType( isNative = true, name = "Map", namespace = JsPackage.GLOBAL )
public class JsMap<K, V>
  implements JsIterable<JsMap.Entry<K, V>>
{
  /**
   * The Map() constructor creates Map objects.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/Map">Map() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-map-constructor">Map Constructor - ECMA</a>
   */
  public JsMap()
  {
  }

  /**
   * The Map() constructor creates Map objects.
   *
   * @param pairs an array of pairs that will be added to the Map.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/Map">Map() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-map-constructor">Map Constructor - ECMA</a>
   */
  @SafeVarargs
  public JsMap( @Nonnull final Entry<K, V>... pairs )
  {
  }

  /**
   * The Map() constructor creates Map objects.
   *
   * @param pairs an iterable containing pairs that will be added to the Map.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/Map">Map() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-map-constructor">Map Constructor - ECMA</a>
   */
  public JsMap( @Nonnull final JsIterable<Entry<K, V>> pairs )
  {
  }

  /**
   * The size accessor property returns the number of elements in a Map object.
   *
   * @return an integer representing how many entries the Set object has.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/size">Map.prototype.size - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-map.prototype.size">Map.prototype.size - ECMA</a>
   */
  @JsProperty( name = "size" )
  public native int size();

  /**
   * The clear() method removes all elements from a Map object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/clear">Map.prototype.clear - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-map.prototype.clear">Map.prototype.clear - ECMA</a>
   */
  public native void clear();

  /**
   * The delete() method removes the specified element from a Map object.
   *
   * @param key the key of the element to remove from the Map object.
   * @return true if an element in the Map object has been removed successfully, false if the key is not found in the Map or if the key is not an object.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/delete">Map.prototype.delete() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-map.prototype.delete">Map.prototype.delete() - ECMA</a>
   */
  public native boolean delete( @Nullable K key );

  /**
   * The entries() method returns a new Iterator object that contains the [key, value] pairs for each element in the Map object in insertion order.
   *
   * @return a new iterator object.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/entries">Map.prototype.entries - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-map.prototype.entries">Map.prototype.entries - ECMA</a>
   */
  public native JsIteratorIterable<Entry<K, V>> entries();

  /**
   * The forEach() method executes a provided function once per each key/value pair in the Map object, in insertion order.
   *
   * @param forEachCallback the function to execute for each element.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/forEach">Map.prototype.forEach - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-map.prototype.foreach">Map.prototype.forEach - ECMA</a>
   */
  public native void forEach( @Nonnull ForEachCallback<V> forEachCallback );

  /**
   * The forEach() method executes a provided function once per each key/value pair in the Map object, in insertion order.
   *
   * @param forEachCallback the function to execute for each element.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/forEach">Map.prototype.forEach - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-map.prototype.foreach">Map.prototype.forEach - ECMA</a>
   */
  public native void forEach( @Nonnull ForEachCallback2<K, V> forEachCallback );

  /**
   * The forEach() method executes a provided function once per each key/value pair in the Map object, in insertion order.
   *
   * @param forEachCallback the function to execute for each element.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/forEach">Map.prototype.forEach - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-map.prototype.foreach">Map.prototype.forEach - ECMA</a>
   */
  public native void forEach( @Nonnull ForEachCallback3<K, V> forEachCallback );

  /**
   * The get() method returns a specified element from a Map object.
   *
   * @param key the key of the element to return from the Map object.
   * @return the value associated with the specified key, or null if the key is present in the Map object.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/get">Map.prototype.get - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-map.prototype.get">Map.prototype.get - ECMA</a>
   */
  public native V get( K key );

  /**
   * The has() method returns a boolean indicating whether an element with the specified value exists in a Map object or not.
   *
   * @return the value to test for presence in the Map object.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/has">Map.prototype.has - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-map.prototype.has">Map.prototype.has - ECMA</a>
   */
  public native boolean has( @Nullable K key );

  /**
   * The keys() method returns a new Iterator object that contains the keys for each element in the Map object in insertion order.
   *
   * @return a new iterator object containing the keys for each element in the Map, in insertion order.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/keys">Map.prototype.keys - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-map.prototype.keys">Map.prototype.keys - ECMA</a>
   */
  @Nonnull
  public native JsIteratorIterable<K> keys();

  /**
   * The set() method adds a new element with a specified key and value to a Map object.
   *
   * @param key   the key of the element to add to the Map object.
   * @param value the value of the element to add to the Map object.
   * @return this Map
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/set">Map.prototype.set() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-map.prototype.set">Map.prototype.set() - ECMA</a>
   */
  @Nonnull
  public native JsMap<K, V> set( @Nullable K key, @Nullable V value );

  /**
   * The values() method returns a new Iterator object that contains the values for each element in the Map object in insertion order.
   *
   * @return a new iterator object containing the values for each element in the Map, in insertion order.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Map/values">Map.prototype.values - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-get-map.prototype.values">Map.prototype.values - ECMA</a>
   */
  @Nonnull
  public native JsIteratorIterable<V> values();

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback<V>
  {
    void item( V value );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback2<K, V>
  {
    void item( V value, K key );
  }

  @JsFunction
  @FunctionalInterface
  public interface ForEachCallback3<K, V>
  {
    void item( V value, K key, @Nonnull JsMap<K, V> array );
  }

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
