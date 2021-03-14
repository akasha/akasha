/**
 * @deprecated
 */
enum PermissionState {
  "denied",
  "granted",
  "prompt"
};

/**
 * @deprecated
 */
typedef ( DOMString or double ) MyTypedefedUnion;

/**
 * @deprecated
 */
namespace CSS {
  /**
   * @deprecated
   */
  DOMString escape( DOMString ident );
};

/**
 * @deprecated
 */
callback MyEventHandler = undefined ( Event event );

callback interface EventListener {
  undefined handleEvent( Event event );
};

/**
 * @deprecated
 */
callback interface OtherEventListener {
  /**
   * @deprecated
   */
  undefined handleEvent( Event event );
};

dictionary AddEventListenerOptions : EventListenerOptions {
  boolean once = false;
  boolean passive = false;
};

/**
 * @deprecated
 */
dictionary EventInit {
  /**
   * @deprecated
   */
  boolean bubbles = false;
};

dictionary EventListenerOptions {
  boolean capture = false;
};

/**
 * @deprecated
 */
[GlobalObject, NoFlatten]
interface mixin GlobalObject1 {
  /**
   * @deprecated
   */
  DOMString decodeURI( DOMString encodedURI );
};

interface Event {
};

interface EventTarget {
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

/**
 * @deprecated
 */
interface OtherType {
};

/**
 * @deprecated
 */
[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface Window : EventTarget {
  /**
   * @deprecated
   */
  readonly attribute boolean isSecureContext;
  /**
   * @deprecated
   */
  attribute DOMString name;
  /**
   * @deprecated
   */
  event Event end;
};
