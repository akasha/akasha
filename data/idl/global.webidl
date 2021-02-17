[GlobalObject, NoFlatten]
interface mixin GlobalObject
{
  /**
   * The decodeURI() function decodes a Uniform Resource Identifier (URI) previously created by encodeURI() or by a similar routine.
   *
   * @param encodedURI A complete, encoded Uniform Resource Identifier.
   * @return A new string representing the unencoded version of the given encoded Uniform Resource Identifier (URI).
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/decodeURI">decodeURI - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-decodeuri-encodeduri">decodeURI() - ECMA</a>
   */
  DOMString decodeURI( DOMString encodedURI );

  /**
   * The decodeURIComponent() function decodes a Uniform Resource Identifier (URI) component previously created by encodeURIComponent or by a similar routine.
   *
   * @param encodedURI An encoded component of a Uniform Resource Identifier.
   * @return A new string representing the decoded version of the given encoded Uniform Resource Identifier (URI) component.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/decodeURIComponent">decodeURIComponent - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-decodeuricomponent-encodeduricomponent">decodeURIComponent() - ECMA</a>
   */
  DOMString decodeURIComponent( DOMString encodedURI );

  /**
   * The encodeURI() function encodes a URI by replacing each instance of certain characters by one, two, three, or four escape sequences representing the UTF-8 encoding of the character (will only be four escape sequences for characters composed of two "surrogate" characters).
   *
   * @param uri a complete URI.
   * @return a new string representing the provided string encoded as a URI.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/encodeURI">encodeURI - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-encodeuri-uri">encodeURI() - ECMA</a>
   */
  DOMString encodeURI( DOMString uri );

  /**
   * The encodeURIComponent() function encodes a URI by replacing each instance of certain characters by one, two, three, or four escape sequences representing the UTF-8 encoding of the character (will only be four escape sequences for characters composed of two "surrogate" characters).
   *
   * @param uri a component of a URI.
   * @return a new string representing the provided string encoded as a URI component.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/encodeURIComponent">encodeURIComponent - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-encodeuricomponent-uricomponent">encodeURIComponent() - ECMA</a>
   */
  DOMString encodeURIComponent( DOMString uri );

  /**
   * The escape() function computes a new string in which certain characters have been replaced by a hexadecimal escape sequence.
   *
   * @param str a string to be encoded.
   * @return a new string in which certain characters have been escaped.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/escape">escape - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-escape-string">escape() - ECMA</a>
   * @deprecated
   */
  DOMString escape( DOMString str );

  /**
   * The eval() function evaluates JavaScript code represented as a string.
   *
   * @param code a string representing a JavaScript expression, statement, or sequence of statements. The expression can include variables and properties of existing objects.
   * @return The completion value of evaluating the given code. If the completion value is empty, undefined is returned.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/eval">eval - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-eval-x">eval() - ECMA</a>
   */
  any eval( DOMString code );

  /**
   * The global isFinite() function determines whether the passed value is a finite number.
   *
   * @param value the value to be tested.
   * @return false if the specified value positive or negative infinity or NaN else true.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/isFinite">isFinite - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-isfinite-number">isFinite() - ECMA</a>
   */
   boolean isFinite( double num );

  /**
   * The isNaN() function determines whether a value is NaN or not. Note, coercion inside the isNaN function has interesting rules; you may alternatively want to use Number.isNaN(), as defined in ECMAScript 2015.
   *
   * @param value the value to be tested.
   * @return true if the specified value is NaN else false.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/isNaN">isNaN - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-isnan-number">isNaN() - ECMA</a>
   */
  boolean isNaN( double value );

  /**
   * The parseFloat() function parses an argument (converting it to a string first if needed) and returns a floating point number.
   *
   * @param string the value to parse. Leading whitespace in this argument is ignored.
   * @return a floating point number parsed from the given string.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/parseFloat">parseFloat - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-parsefloat-string">parseFloat() - ECMA</a>
   */
  double parseFloat( DOMString string );

  /**
   * The parseInt() function parses a string argument and returns an integer of the specified radix (the base in mathematical numeral systems).
   *
   * @param string the value to parse. Leading whitespace in this argument is ignored.
   * @param radix An integer between 2 and 36 that represents the radix (the base in mathematical numeral systems) of the string.
   * @return an integer parsed from the given string.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/parseInt">parseInt - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-parseint-string-radix">parseInt() - ECMA</a>
   */
  long long parseInt( DOMString string, optional long long radix );

  /**
   * The unescape() function computes a new string in which hexadecimal escape sequences are replaced with the character that it represents. The escape sequences might be introduced by a function like escape. Usually, decodeURI or decodeURIComponent are preferred over unescape.
   *
   * @param str a string to be decoded.
   * @return a new string in which certain characters have been unescaped.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/unescape">unescape - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-unescape-string">unescape() - ECMA</a>
   * @deprecated
   */
  DOMString unescape( DOMString str );
};
