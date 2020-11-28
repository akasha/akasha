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

[Exposed=(Window,Worker)]
interface AbortSignal : EventTarget {
  readonly attribute boolean aborted;
  attribute EventHandler onabort;
};
