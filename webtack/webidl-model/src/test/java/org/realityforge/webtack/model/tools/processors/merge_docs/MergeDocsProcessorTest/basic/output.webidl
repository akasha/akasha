/**
 * The WebAssembly JavaScript object acts as the namespace for all WebAssembly-related functionality.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly">WebAssembly - MDN</a>
 */
[Exposed=(Window,Worker,Worklet)]
namespace WebAssembly {
  /**
   * The WebAssembly.compile() function compiles WebAssembly binary code into a WebAssembly.Module object. This function is useful if it is necessary to a compile a module before it can be instantiated (otherwise, the WebAssembly.instantiate() function should be used).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly/compile">WebAssembly.compile - MDN</a>
   * @see <a href="https://example.com/wasm">wasm 1.0</a>
   */
  Promise<Module> compile( BufferSource bytes );
  /**
   * The WebAssembly.instantiate() function allows you to compile and instantiate WebAssembly code. This function has two overloads:
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly/instantiate">WebAssembly.instantiate - MDN</a>
   */
  Promise<WebAssemblyInstantiatedSource> instantiate( BufferSource bytes, optional object importObject );
  /**
   * The WebAssembly.instantiate() function allows you to compile and instantiate WebAssembly code. This function has two overloads:
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly/instantiate">WebAssembly.instantiate - MDN</a>
   */
  Promise<Instance> instantiate( Module moduleObject, optional object importObject );
  /**
   * The WebAssembly.validate() function validates a given typed array of WebAssembly binary code, returning whether the bytes form a valid wasm module (true) or not (false).
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly/validate">WebAssembly.validate - MDN</a>
   */
  boolean validate( BufferSource bytes );
};

/**
 * Documentation for NodeFilter
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/NodeFilter">NodeFilter - MDN</a>
 */
[Exposed=Window]
callback interface NodeFilter {
  /**
   * Documentation for NodeFilter.FILTER_ACCEPT
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/NodeFilter/FILTER_ACCEPT">NodeFilter.FILTER_ACCEPT - MDN</a>
   */
  const unsigned short FILTER_ACCEPT = 1;
  const unsigned short FILTER_REJECT = 2;
  /**
   * Documentation for FILTER_SKIP.
   * This should be retained as there is no docs in doc repository
   */
  const unsigned short FILTER_SKIP = 3;
  /**
   * Documentation for NodeFilter.acceptNode
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/NodeFilter/acceptNode">NodeFilter.acceptNode - MDN</a>
   */
  unsigned short acceptNode( Node node );
};

dictionary EventInit {
};

/**
 * The WebXR Device API dictionary XRSessionInit specifies required and/or optional features when requesting a new XRSession by calling the navigator.xr.requestSession() method.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/XRSessionInit">XRSessionInit - MDN</a>
 */
dictionary XRSessionInit {
  /**
   * The XRSessionInit dictionary's optionalFeatures property specifies ...
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/XRSessionInit/optionalFeatures">XRSessionEventInit.optionalFeatures - MDN</a>
   */
  sequence<any> optionalFeatures;
};

/**
 * The WebXR Device API dictionary XRSessionInit specifies required and/or optional features when requesting a new XRSession by calling the navigator.xr.requestSession() method.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/XRSessionInit">XRSessionInit - MDN</a>
 */
partial dictionary XRSessionInit {
  /**
   * The XRSessionInit dictionary's requiredFeatures property specifies ...
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/XRSessionInit/requiredFeatures">XRSessionEventInit.requiredFeatures - MDN</a>
   */
  sequence<any> requiredFeatures;
};

/**
 * The GlobalEventHandlers mixin describes the event handlers common to several interfaces like HTMLElement, Document, or Window.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers">GlobalEventHandlers - MDN</a>
 */
interface mixin GlobalEventHandlers {
  /**
   * The onabort property of the GlobalEventHandlers mixin is the EventHandler for processing abort events sent to the window.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onabort">GlobalEventHandlers.onabort - MDN</a>
   */
  attribute EventHandler onabort;
  /**
   * The abort event...
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Element/abort_event">abort event - MDN</a>
   */
  event Event abort;
  /**
   * The focus event fires when an element has received focus.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Element/focus_event">focus event - MDN</a>
   */
  event FocusEvent focus;
  event Event undocumented2;
  event Event unhandledrejection;
};

/**
 * The GlobalEventHandlers mixin describes the event handlers common to several interfaces like HTMLElement, Document, or Window.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers">GlobalEventHandlers - MDN</a>
 */
partial interface mixin GlobalEventHandlers {
  /**
   * The onblur property of the GlobalEventHandlers mixin is the EventHandler for processing blur events. It's available on Element, Document, and Window.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers/onblur">GlobalEventHandlers.onblur - MDN</a>
   */
  attribute EventHandler onblur;
  /**
   * The abort event...
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Element/abort_event">abort event - MDN</a>
   */
  event AbortEvent abort;
  /**
   * Existing documentation, with doc entry.
   */
  event BlurEvent blee;
  /**
   * The blur event...
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Element/blur_event">blur event - MDN</a>
   */
  event BlurEvent blur;
  /**
   * The focus event fires when an element has received focus.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Element/focus_event">focus event - MDN</a>
   */
  event FocusEvent focus;
  /**
   * Existing documentation, no doc entry.
   */
  event Event other;
  event Event undocumented;
  event Event unhandledrejection;
};

interface AbortEvent : Event {
};

interface BlurEvent : Event {
};

/**
 * Documentation for DOMStringMap type
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/DOMStringMap">DOMStringMap - MDN</a>
 */
interface DOMStringMap {
  getter DOMString ( DOMString name );
  [CEReactions]
  setter undefined ( DOMString name, DOMString value );
  [CEReactions]
  deleter undefined ( DOMString name );
};

interface DeviceMotionEvent : Event {
};

/**
 * Documentation for Event. It covers multiple
 * lines.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event">Event - MDN</a>
 */
[Exposed=(Window,Worker,AudioWorklet)]
interface Event {
  /**
   * Documentation for Event.AT_TARGET constant.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/AT_TARGET">Event.AT_TARGET - MDN</a>
   */
  const unsigned short AT_TARGET = 2;
  /**
   * Documentation for Event.bubbles readonly attribute.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/bubbles">Event.bubbles - MDN</a>
   */
  readonly attribute boolean bubbles;
  /**
   * Documentation for Event.cancelBubble attribute.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/cancelBubble">Event.cancelBubble - MDN</a>
   */
  attribute boolean cancelBubble;
  /**
   * Documentation for Event.filterGlobalEvent static operation.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/filterGlobalEvent">Event.filterGlobalEvent - MDN</a>
   */
  static Event filterGlobalEvent( DOMString type );
  /**
   * Documentation for Event.Event constructor.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/Event">Event.Event - MDN</a>
   */
  constructor( DOMString type, optional EventInit eventInitDict = {} );
  /**
   * Documentation for Event.composedPath operation.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Event/composedPath">Event.composedPath - MDN</a>
   */
  sequence<EventTarget> composedPath();
};

interface EventTarget {
};

interface FocusEvent : Event {
};

interface HTMLFormElement {
  event Event focus;
  /**
   * The reset event fires when a form is reset.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/HTMLFormElement/reset_event">reset event - MDN</a>
   */
  [NoBubble, NoCancel]
  event Event reset;
};

/**
 * A WebAssembly.Instance object is a stateful, executable instance of a WebAssembly.Module. Instance objects contain all the Exported WebAssembly functions that allow calling into WebAssembly code from JavaScript.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly/Instance">WebAssembly.Instance - MDN</a>
 */
[LegacyNamespace=WebAssembly, Constructor( Module module, optional object importObject ), Exposed=(Window,Worker,Worklet)]
interface Instance {
  /**
   * The exports readonly property of the WebAssembly.Instance object prototype returns an object containing as its members all the functions exported from the WebAssembly module instance, to allow them to be accessed and used by JavaScript.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/WebAssembly/Instance/exports">WebAssembly.Instance.exports - MDN</a>
   */
  readonly attribute object exports;
};

interface Node {
  event Event eventnoexisto;
};

/**
 * The WebGL2RenderingContext interface provides an interface to the OpenGL ES 3.0 graphics rendering context for the drawing surface of an HTML canvas element.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebGL2RenderingContext">WebGL2RenderingContext - MDN</a>
 */
interface WebGL2RenderingContext {
  /**
   * Docs for WebGLRenderingContext.finish
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebGLRenderingContext/finish">WebGLRenderingContext.finish - MDN</a>
   * @see <a href="https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.11">The definition of 'finish' in WebGL 1.0.</a>
   * @see <a href="https://www.khronos.org/opengles/sdk/docs/man/xhtml/glFinish.xml">The definition of 'glFinish' in OpenGL ES 2.0.</a>
   */
  undefined finish();
  /**
   * Docs for WebGL2RenderingContext.flush
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebGL2RenderingContext/flush">WebGL2RenderingContext.flush - MDN</a>
   */
  undefined flush();
  /**
   * Docs for WebGLRenderingContext.uniform
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebGLRenderingContext/uniform">WebGLRenderingContext.uniform - MDN</a>
   */
  undefined uniform1f();
  undefined uniform1ui();
};

/**
 * The WebGL2RenderingContext interface provides an interface to the OpenGL ES 3.0 graphics rendering context for the drawing surface of an HTML canvas element.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebGL2RenderingContext">WebGL2RenderingContext - MDN</a>
 */
interface WebGL3RenderingContext {
  undefined commit();
  /**
   * Docs for WebGLRenderingContext.finish
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebGLRenderingContext/finish">WebGLRenderingContext.finish - MDN</a>
   * @see <a href="https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.11">The definition of 'finish' in WebGL 1.0.</a>
   * @see <a href="https://www.khronos.org/opengles/sdk/docs/man/xhtml/glFinish.xml">The definition of 'glFinish' in OpenGL ES 2.0.</a>
   */
  undefined finish();
  /**
   * Docs for WebGL2RenderingContext.flush
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebGL2RenderingContext/flush">WebGL2RenderingContext.flush - MDN</a>
   */
  undefined flush();
};

/**
 * The WebGLRenderingContext interface provides an interface to the OpenGL ES 2.0 graphics rendering context for the drawing surface of an HTML canvas element.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebGLRenderingContext">WebGLRenderingContext - MDN</a>
 */
interface WebGLRenderingContext {
  /**
   * Docs for WebGLRenderingContext.finish
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebGLRenderingContext/finish">WebGLRenderingContext.finish - MDN</a>
   * @see <a href="https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.11">The definition of 'finish' in WebGL 1.0.</a>
   * @see <a href="https://www.khronos.org/opengles/sdk/docs/man/xhtml/glFinish.xml">The definition of 'glFinish' in OpenGL ES 2.0.</a>
   */
  undefined finish();
  /**
   * Docs for WebGLRenderingContext.flush
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/WebGLRenderingContext/flush">WebGLRenderingContext.flush - MDN</a>
   */
  undefined flush();
};

/**
 * Documentation for Window partial.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window">Window - MDN</a>
 */
interface Window {
  /**
   * The devicemotion event is fired at a regular interval and indicates the amount of physical force of acceleration the device is receiving at that time. It also provides information about the rate of rotation, if available.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/devicemotion_event">devicemotion event - MDN</a>
   */
  event DeviceMotionEvent devicemotion;
  /**
   * The focus event fires when a Window has received focus.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/focus_event">focus event - MDN</a>
   */
  event Event focus;
};

/**
 * Documentation for Window partial.
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window">Window - MDN</a>
 */
partial interface Window {
  /**
   * Documentation for Window.someVar
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/someVar">Window.someVar - MDN</a>
   */
  readonly attribute DOMString someVar;
  /**
   * The orientationchange event is fired when the orientation of the device has changed.
   *
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/API/Window/orientationchange_event">orientationchange event - MDN</a>
   */
  event Event orientationchange;
};
