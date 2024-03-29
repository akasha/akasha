typedef ArrayBuffer BufferSource;

[Exposed=Window]
namespace CSS {
  DOMString escape( DOMString ident );
};

[JavaName=JsMath]
namespace Math {
  [JavaName=JsMath]
  const double E = 2.7182818284590452354;
  [JavaName=JsMath]
  const double LN10 = 2.302585092994046;
  unrestricted double abs( unrestricted double x );
};

/**
 * This tests auto convert to varargs in jsinterop binding.
 */
namespace VarargsType {
  undefined myOperation1( sequence<DOMString> tokens );
  undefined myOperation2( sequence<DOMString> tokens1, sequence<DOMString> tokens2 );
};

/**
 * The WebAssembly JavaScript object acts as the namespace for all WebAssembly-related functionality.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly">WebAssembly - MDN</a>
 */
[Exposed=Window]
namespace WebAssembly {
  /**
   * The WebAssembly.validate() function validates a given typed array of WebAssembly binary code, returning whether the bytes form a valid wasm module (true) or not (false).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly/validate">WebAssembly.validate - MDN</a>
   */
  boolean validate( BufferSource bytes );
};

/**
 * The console object provides access to the browser's debugging console (e.g. the Web Console in Firefox). The specifics of how it works varies from browser to browser, but there is a de facto set of features that are typically provided.
 * This tests that lowercase name converted to uppercase when converted into java.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console">console - MDN</a>
 */
[Exposed=Window]
namespace console {
  undefined assert( optional boolean condition = false, any... data );
  /**
   * The console.clear() method clears the console if the environment allows it.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console/clear">console.clear - MDN</a>
   */
  undefined clear();
  /**
   * Last argument is optional and a varargs candidate
   */
  undefined table( optional any tabularData, optional sequence<DOMString> properties );
  /**
   * Outputs a warning message to the Web Console.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/console/warn">console.warn - MDN</a>
   */
  undefined warn( any... data );
};

interface ArrayBuffer {
};

/**
 * The Window interface represents a window containing a DOM document; the document property points to the DOM document loaded in that window.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window">Window - MDN</a>
 */
[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface Window {
  readonly attribute boolean closed;
};
