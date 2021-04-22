package akasha.core;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The data type symbol is a primitive data type. The Symbol() function returns a value of type symbol, has static properties that expose several members of built-in objects, has static methods that expose the global symbol registry, and resembles a built-in object class, but is incomplete as a constructor because it does not support the syntax &quot;new Symbol()&quot;.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol">Symbol - MDN</a>
 * @see <a href="https://tc39.es/ecma262/#sec-symbol-objects">Symbol - ECMAScript (ECMA-262)</a>
 */
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "symbol" )
public interface Symbol
{
  /**
   * The Symbol.asyncIterator well-known symbol specifies the default AsyncIterator for an object. If this property is set on an object, it is an async iterable and can be used in a for await...of loop.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/asyncIterator">Symbol.asyncIterator - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.asynciterator">Symbol.asyncIterator - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol asyncIterator()
  {
    return SymbolType.asyncIterator();
  }

  /**
   * The Symbol.hasInstance well-known symbol is used to determine if a constructor object recognizes an object as its instance. The instanceof operator's behavior can be customized by this symbol.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/hasInstance">Symbol.hasInstance - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.hasinstance">Symbol.hasInstance - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol hasInstance()
  {
    return SymbolType.hasInstance();
  }

  /**
   * The Symbol.isConcatSpreadable well-known symbol is used to configure if an object should be flattened to its array elements when using the Array.prototype.concat() method.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/isConcatSpreadable">Symbol.isConcatSpreadable - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.isconcatspreadable">Symbol.isconcatspreadable - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol _isConcatSpreadable()
  {
    return SymbolType._isConcatSpreadable();
  }

  /**
   * The well-known Symbol.iterator symbol specifies the default iterator for an object. Used by for...of.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/iterator">Symbol.iterator - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.iterator">Symbol.iterator - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol iterator()
  {
    return SymbolType.iterator();
  }

  /**
   * The Symbol.match well-known symbol specifies the matching of a regular expression against a string. This function is called by the String.prototype.match() method.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/match">Symbol.match - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.match">Symbol.match - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol match()
  {
    return SymbolType.match();
  }

  /**
   * The Symbol.matchAll well-known symbol returns an iterator, that yields matches of the regular expression against a string. This function is called by the String.prototype.matchAll() method.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/matchAll">Symbol.matchAll - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.matchall">Symbol.matchAll - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol matchAll()
  {
    return SymbolType.matchAll();
  }

  /**
   * The Symbol.replace well-known symbol specifies the method that replaces matched substrings of a string. This function is called by the String.prototype.replace() method.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/replace">Symbol.replace - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.replace">Symbol.replace - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol replace()
  {
    return SymbolType.replace();
  }

  /**
   * The Symbol.search well-known symbol specifies the method that returns the index within a string that matches the regular expression. This function is called by the String.prototype.search() method.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/search">Symbol.search - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.search">Symbol.search - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol search()
  {
    return SymbolType.search();
  }

  /**
   * The well-known symbol Symbol.species specifies a function-valued property that the constructor function uses to create derived objects.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/species">Symbol.species - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.species">Symbol.species - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol species()
  {
    return SymbolType.species();
  }

  /**
   * The Symbol.split well-known symbol specifies the method that splits a string at the indices that match a regular expression. This function is called by the String.prototype.split() method.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/split">Symbol.split - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.split">Symbol.split - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol split()
  {
    return SymbolType.split();
  }

  /**
   * The Symbol.toPrimitive is a symbol that specifies a function valued property that is called to convert an object to a corresponding primitive value.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/toPrimitive">Symbol.toPrimitive - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.toprimitive">Symbol.toPrimitive - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol toPrimitive()
  {
    return SymbolType.toPrimitive();
  }

  /**
   * The Symbol.toStringTag well-known symbol is a string valued property that is used in the creation of the default string description of an object. It is accessed internally by the Object.prototype.toString() method.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/toStringTag">Symbol.toStringTag - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.tostringtag">Symbol.toStringTag - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol toStringTag()
  {
    return SymbolType.toStringTag();
  }

  /**
   * The Symbol.unscopables well-known symbol is used to specify an object value of whose own and inherited property names are excluded from the with environment bindings of the associated object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/unscopables">Symbol.unscopables - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.unscopables">Symbol.unscopables - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static Symbol unscopables()
  {
    return SymbolType.unscopables();
  }

  @Nonnull
  @JsOverlay
  static Symbol for_( @Nonnull final String key )
  {
    return SymbolType.for_( key );
  }

  /**
   * The Symbol.keyFor(sym) method retrieves a shared symbol key from the global symbol registry for the given symbol.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/keyFor">Symbol.keyFor - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.keyfor">Symbol.keyFor - ECMAScript (ECMA-262)</a>
   */
  @JsOverlay
  @Nonnull
  static String keyFor( @Nonnull final Symbol symbol )
  {
    return SymbolType.keyFor( symbol );
  }

  /**
   * The toString() method returns a string representing the specified Symbol object.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Symbol/toString">Symbol.toString - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-symbol.prototype.tostring">Symbol.prototype.toString - ECMAScript (ECMA-262)</a>
   */
  @JsMethod( name = "toString" )
  @Nonnull
  String toString_();
}
