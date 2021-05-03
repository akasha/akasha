[Exposed=(Window,Worker), JavaSubPackage=core, JavaName=JsError, Serializable]
interface Error {
  readonly attribute DOMString name;
  readonly attribute DOMString message;

  // stack is non-standard but broadly implemented and reasonably useful...
  readonly attribute DOMString stack;

  /**
   * The Error constructor creates an error object.
   *
   * @param message A human-readable description of the error.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Error/Error">Error() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-error-constructor">Error() - ECMA</a>
   */
  constructor( optional DOMString message = "" );
};

[Exposed=(Window,Worker), JavaSubPackage=core, Serializable]
interface EvalError : Error {
  /**
   * The EvalError constructor creates a new error regarding the global eval() function. This exception is not thrown by JavaScript anymore, however the EvalError object remains for compatibility.
   *
   * @param message A human-readable description of the error.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/EvalError/EvalError">EvalError() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-native-error-types-used-in-this-standard-evalerror">EvalError() - ECMA</a>
   */
  constructor( optional DOMString message = "" );
};

[Exposed=(Window,Worker), JavaSubPackage=core, Serializable]
interface RangeError : Error {
  /**
   * The RangeError() constructor creates an error when a value is not in the set or range of allowed values.
   *
   * @param message A human-readable description of the error.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/RangeError/RangeError">RangeError() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-native-error-types-used-in-this-standard-rangeerror">RangeError() - ECMA</a>
   */
  constructor( optional DOMString message = "" );
};

[Exposed=(Window,Worker), JavaSubPackage=core, Serializable]
interface ReferenceError : Error {
  /**
   * The ReferenceError object represents an error when a non-existent variable is referenced.
   *
   * @param message A human-readable description of the error.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ReferenceError/ReferenceError">ReferenceError() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-native-error-types-used-in-this-standard-referenceerror">ReferenceError() - ECMA</a>
   */
  constructor( optional DOMString message = "" );
};

[Exposed=(Window,Worker), JavaSubPackage=core, Serializable]
interface SyntaxError : Error {
  /**
   * The SyntaxError constructor creates a new error object that represents an error when trying to interpret syntactically invalid code.
   *
   * @param message A human-readable description of the error.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/SyntaxError/SyntaxError">SyntaxError() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-native-error-types-used-in-this-standard-syntaxerror">SyntaxError() - ECMA</a>
   */
  constructor( optional DOMString message = "" );
};

[Exposed=(Window,Worker), JavaSubPackage=core, Serializable]
interface TypeError : Error {
  /**
   * The TypeError() constructor creates a new error when an operation could not be performed, typically (but not exclusively) when a value is not of the expected type.
   *
   * @param message A human-readable description of the error.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypeError/TypeError">TypeError() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-native-error-types-used-in-this-standard-typeerror">TypeError() - ECMA</a>
   */
  constructor( optional DOMString message = "" );
};

[Exposed=(Window,Worker), JavaSubPackage=core, Serializable]
interface URIError : Error {
  /**
   * The URIError() constructor creates an error when a global URI handling function was used in a wrong way.
   *
   * @param message A human-readable description of the error.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/URIError/URIError">URIError() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-native-error-types-used-in-this-standard-urierror">URIError() - ECMA</a>
   */
  constructor( optional DOMString message = "" );
};

[Exposed=(Window,Worker), JavaSubPackage=core, Serializable]
interface AggregateError : Error {

  readonly attribute [SequenceType=Iterable] sequence<any> errors;

  /**
   * The AggregateError() constructor creates an error for several errors that need to be wrapped in a single error.
   *
   * @param errors An iterable of errors, may not actually be Error instances.
   * @param message A human-readable description of the error.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/URIError/URIError">URIError() - MDN</a>
   * @see <a href="https://tc39.es/ecma262/#sec-native-error-types-used-in-this-standard-urierror">URIError() - ECMA</a>
   */
  constructor( [SequenceType=Iterable] sequence<any> errors, optional DOMString message = "" );
};
