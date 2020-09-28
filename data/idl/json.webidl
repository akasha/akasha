typedef (DOMString or long long) StringifySpaceUnionType;

callback StringifyReplacerFn = any ( DOMString key, any value );

callback ParseReviverFn = any ( DOMString key, any value );

/**
 * The JSON object contains methods for parsing JavaScript Object Notation (JSON) and converting values to JSON.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON">MDN - JSON</a>
 * @see <a href="https://tc39.es/ecma262/#sec-json-object">Atomics - ECMA</a>
 */
interface JSON {
  /**
   * The JSON.stringify() method converts a JavaScript object or value to a JSON string, optionally replacing values if a replacer function is specified or optionally including only the specified properties if a replacer array is specified.
   *
   * @param text The value to convert to a JSON string.
   * @param replacer A function that alters the behavior of the stringification process, or an array of String and Number that serve as an allowlist for selecting/filtering the properties of the value object to be included in the JSON string. If this value is null or not provided, all properties of the object are included in the resulting JSON string.
   * @param space A String or Number object that's used to insert white space into the output JSON string for readability purposes. If this is a Number, it indicates the number of space characters to use as white space; this number is capped at 10 (if it is greater, the value is just 10). Values less than 1 indicate that no space should be used. If this is a String, the string (or the first 10 characters of the string, if it's longer than that) is used as white space. If this parameter is not provided (or is null), no white space is used.
   * @return A JSON string representing the given value.
   * @throw TypeError if a circular reference is found or an attempt is made to stringify a BigInt.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON/stringify">JSON.stringify() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-json.stringify">JSON.stringify() - ECMA</a>
   */
  static DOMString stringify( any value, optional (StringifyReplacerFn or sequence<(DOMString or long long)>)? replacer = null, optional StringifySpaceUnionType? space = null );

  /**
   * The JSON.parse() method parses a JSON string, constructing the JavaScript value or object described by the string.
   *
   * @param text The string to parse as JSON.
   * @param reviver This prescribes how the value originally produced by parsing is transformed, before being returned.
   * @return The Object, Array, string, number, boolean, or null value corresponding to the given JSON text.
   * @throw SyntaxError if the string to parse is not valid JSON.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON/parse">JSON.parse() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-json.parse">JSON.parse() - ECMA</a>
   */
  static any parse( DOMString text, optional ParseReviverFn? reviver = null);
};
