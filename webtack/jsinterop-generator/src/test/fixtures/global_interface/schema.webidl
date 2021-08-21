callback interface EventListener {
  undefined handleEvent( Event event );
};

callback interface FocusEventListener {
  undefined handleEvent( FocusEvent event );
};

dictionary AddEventListenerOptions : EventListenerOptions {
  boolean once = false;
  boolean passive = false;
};

dictionary EventListenerOptions {
  boolean capture = false;
};

dictionary ScrollToOptions {
  unrestricted double left;
  unrestricted double top;
};

interface Event {
};

interface EventTarget {
  readonly attribute boolean open;
  attribute DOMString id;
  event Event bing;
  undefined addEventListener( DOMString type, EventListener? callback, optional ( AddEventListenerOptions or boolean ) options = {} );
  /**
   * Dispatches an Event at the specified EventTarget, (synchronously) invoking the affected EventListeners in the appropriate order. The normal event processing rules (including the capturing and optional bubbling phase) also apply to events dispatched manually with dispatchEvent().
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/dispatchEvent">EventTarget.dispatchEvent - MDN</a>
   */
  boolean dispatchEvent( Event event );
  /**
   * The EventTarget.removeEventListener() method removes from the EventTarget an event listener previously registered with EventTarget.addEventListener(). The event listener to be removed is identified using a combination of the event type, the event listener function itself, and various optional options that may affect the matching process; see Matching event listeners for removal
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener">EventTarget.removeEventListener - MDN</a>
   */
  undefined removeEventListener( DOMString type, EventListener? callback, optional ( EventListenerOptions or boolean ) options = {} );
};

interface FocusEvent : Event {
};

interface Navigator {
};

[Global=(Worker,SharedWorker), Exposed=SharedWorker]
interface SharedWorkerGlobalScope : WorkerGlobalScope {
  [Replaceable]
  readonly attribute DOMString name;
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
  readonly attribute Navigator navigator;
  /**
   * The Window.name property gets/sets the name of the window's browsing context.
   */
  attribute DOMString name;
  [NoBubble, NoCancel]
  event Event DOMContentLoaded;
  event FocusEvent focus;
  undefined scroll( unrestricted double x, unrestricted double y );
  undefined scroll( optional ScrollToOptions options = {} );
  getter object get( DOMString name );
};

[Exposed=Worker]
interface WorkerGlobalScope {
  readonly attribute WorkerNavigator navigator;
};

interface WorkerNavigator {
};
