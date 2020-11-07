dictionary ScrollToOptions {
  unrestricted double left;
  unrestricted double top;
};

interface EventTarget {
  readonly attribute boolean open;
  attribute DOMString id;
  boolean dispatchEvent( any event );
};

[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface Window : EventTarget {
  readonly attribute boolean closed;
  /**
   * The window.isSecureContext read-only property indicates whether a context is capable of using features that require secure contexts.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/isSecureContext">Window.isSecureContext - MDN</a>
   * @see <a href="https://w3c.github.io/webappsec-secure-contexts/">Secure Contexts</a>
   */
  readonly attribute boolean isSecureContext;
  /**
   * The Window.name property gets/sets the name of the window's browsing context.
   */
  attribute DOMString name;
  undefined scroll( unrestricted double x, unrestricted double y );
  undefined scroll( optional ScrollToOptions options = {} );
  getter object get( DOMString name );
};
