# TODO

This document is essentially a list of shorthand notes describing work yet to be completed.
Unfortunately it is not complete enough for other people to pick work off the list and
complete as there is too much un-said.

# Docs Integration

* Some doc entries include documentation for constants .. scan for that?.

* Extract param docs for methods and constructors.
  - See example at https://developer.mozilla.org/en-US/docs/Web/API/WebGLRenderingContext/polygonOffset

* Add special handling for `@return` javadoc.

* The spec docs have a lot of documentation that can be scraped. Some of them have great cross-linking
  so it should be possible with a little bit of heuristics to extract the documentation for different
  members and definitions. Alternatively we could just cross link and add other @see tags

  Spec Docs: https://heycam.github.io/webidl/

  We could make the doc repository populate docs from multiple sources

* Scan https://github.com/mdn/browser-compat-data/tree/master/api to build up compatibility information for types
  and possibly also add https://github.com/mdn/browser-compat-data/tree/master/browsers so we can decide which
  browsers to support

# Apps to Stretch Implementation

* use webrtc video chat ala ZipCall.io as another example

* webgl renderer of some kind.
 - a good one is https://github.com/PavelDoGreat/WebGL-Fluid-Simulation/blob/master/script.js

* Maybe mesh+shaders sample app?

* use webrtc + hand-tracking (https://immersive-web.github.io/webxr-hand-input/) for web based comms system. Possibly even add video layers via https://github.com/immersive-web/layers for desktop users?
 - https://github.com/marlon360/webxr-handtracking
 - https://cabanier.github.io/WebXRLayers-samples/index.html

# Events

* Another place to scan events from
  - https://html.spec.whatwg.org/multipage/indices.html#events-2

* Validate should validate event types are present for event members

* Validate callback names do not collide with other named elements

* Update doc scanner to allow per-type css selectors so that we can somehow collect events
  for something like: https://developer.mozilla.org/en-US/docs/Web/API/GlobalEventHandlers
  Alternatively we may just manually import these docs.

* Add code that "specializes" event handlers in some way. So we can make an event handler for a
  particular `on[myevent]` attribute take an event of type `MyEvent`. We could have a processor that
  adds webidl `callback` instances for all these event handlers.

* We could also add overlap methods on the interfaces that wrapped and generated methods like:

```java
  @JsOverlay
  public void addProgressListener(@Nonnull final ProgressEventListener callback, @Nonnull AddEventListenerOptions options)
  {
    addEventListener( "progress", callback, options );
  }

  @JsOverlay
  public void addProgressListener(@Nonnull final ProgressEventListener callback, boolean options)
  {
    addEventListener( "progress", callback, options );
  }

  @JsOverlay
  public void addProgressListener(@Nonnull final ProgressEventListener callback)
  {
    addEventListener( "progress", callback );
  }

```

* Type the `on[someevent]` properties on interfaces using the typed interface as specified above.

# Java Generation

* Generate a global object ala `DomGlobal` based on a specific interface name.

* Generate `GETTER`, `SETTER`, `DELETER` and `STRINGIFIER` operations

* Classes with `LegacyNamespace` should  default to different package based on namespace or maybe prefix all classes?

* Figure out if we can get string enums represented as enums in j2cl and/or gwt. Otherwise try to use trickery of intellij annotations for enumerations as attributes.

* Generate a test that checks whether the browser supports the symbols that are in the webidl. Essentially the test
  would use raw inspection of objects to see if they line up with what is in WebIDL

* Use `JsPropertyMap` for records. We may need some "wrapper" types like `JsIntPropertyMap` and like `JsShortPropertyMap`
  which just unchecked cast to `JsPropertyMap<double>` and then cast on the way out?

# Other

* Change pipeline so that doc runtime is shared across pipeline stages? Or maybe we can each repository?

* Also change the constructor properties ala `Constructor( DOMString type, optional MouseEventInit eventInitDict )` into actual constructors.

* Add a `complete` method on `Action`, `Combiner` and `Processor` interfaces that will be invoked once the code will no longer have any schemas passed in. This allows the processor to perform cleanup and/or check that it is still needed. i.e. if a `RenameX` processor does not perform any renames we could alert in the complete to indicate that no match occurred. We could also add statistics (i.e. renamed 2 elements).

* Support defining and using variables in pipeline json. It probably means string values can be
  interpolated like `"someProp"="${globalObject}"` and we would define the configuration `globalObject="Window"`
  earlier in the pipeline (and effectively reuse it in extract exposure set, global object generator and
  a few other places).

* Start to download chrome webidl as they do not seem to align with specs exactly and thus generate some issues.
  - https://www.chromium.org/Home
  - https://source.chromium.org/chromium/chromium/src/+/master:third_party/blink/renderer/modules/speech/window_speech_synthesis.idl?originalUrl=https:%2F%2Fcs.chromium.org%2F

* Start to download gecko WebIDL as well https://github.com/mozilla/gecko-dev/tree/master/dom/webidl

* Enhance `MergerTool` with a strategy that will actually merge constructs that "match". i.e. If two operations
  have the same name and parameters then they should be collapsed into a single operation but with potentially
  merged extended attributes. The intention is for this to be used to import gecko and/or chrome WebIDL and combine
  it with the spec produced WebIDL so that we have a combined schema and can specifically identify which constructs
  are browser specific. We may also combine multiple versions of schemas so we can see which versions of the browsers
  added which features. Questions exist such as: Should blend of multiple Extended attribute `Ident` types produce
  an `IdentList` type or only for special well-known extended attributes ala `Exposed`?

* Emit closure externs for WebIDL types.

* Add javac compile, gwtc compile and javadoc processing as part of jsinterop pipeline.

### Validations

This section lists some validations that should be implemented to at least confirm some of our assumptions:

* Exploded union type lists should not contain:
  * multiple values represented by javascript numbers (otherwise how to determine which variant is intended)
  * multiple dictionary values (otherwise would need to inspect data to switch between them?)
