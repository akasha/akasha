# TODO

This document is essentially a list of shorthand notes describing work yet to be completed.
Unfortunately it is not complete enough for other people to pick work off the list and
complete as there is too much un-said.

* use webrtc video chat ala ZipCall.io as another example

* use webrtc + hand-tracking (https://immersive-web.github.io/webxr-hand-input/) for web based comms system

* Remove `Type is instantiated by the runtime no attempt should be made to instantiate type by application code.`

* Use `JsPropertyMap` for records. We may need some "wrapper" types like `JsIntPropertyMap` and like `JsShortPropertyMap`
  which just unchecked cast to `JsPropertyMap<double>` and then cast on the way out?

* Also change the constructor properties ala `Constructor( DOMString type, optional MouseEventInit eventInitDict )` into actual constructors.

* Add `VoidReturnCallback` processor so can make `EventHandler` return `Void`. Makes the java
  code a whole lot nicer. We could do this after we have emitted closure externs.

* Add code that "specializes" event handlers in some way. So we can make an event handler for a
  particular `onmyevent` attribute take an event of type `MyEvent`. We could also add overlap
  methods on the interfaces that wrapped and generated methods like:

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

* Remove all the `onsomeevent` properties from interfaces once there is jsoverlay event handler like the above in place.

* Support defining and using variables in pipeline json. It probably means string values can be
  interpolated like `"someProp"="${globalObject}"` and we would define the configuration `globalObject="Window"`
  earlier in the pipeline (and effectively reuse it in extract exposure set, global object generator and
  a few other places).

* Start to download chrome webidl as they do not seem to align with specs exactly and thus generate some issues.
  - https://www.chromium.org/Home
  - https://source.chromium.org/chromium/chromium/src/+/master:third_party/blink/renderer/modules/speech/window_speech_synthesis.idl?originalUrl=https:%2F%2Fcs.chromium.org%2F

* Classes with `LegacyNamespace` should  default to different package based on namespace or maybe prefix all classes?

* Generate a test that checks whether the browser supports the symbols that are in the webidl. Essentially the test
  would use raw inspection of objects to see if they line up with what is in WebIDL

* Enhance `MergerTool` with a strategy that will actually merge constructs that "match". i.e. If two operations
  have the same name and parameters then they should be collapsed into a single operation but with potentially
  merged extended attributes. The intention is for this to be used to import gecko and/or chrome WebIDL and combine
  it with the spec produced WebIDL so that we have a combined schema and can specifically identify which constructs
  are browser specific. We may also combine multiple versions of schemas so we can see which versions of the browsers
  added which features. Questions exist such as: Should blend of multiple Extended attribute `Ident` types produce
  an `IdentList` type or only for special well-known extended attributes ala `Exposed`?

* The spec docs have a lot of documentation that can be scraped. Some of them have great cross-linking
  so it should be possible with a little bit of heuristics to extract the documentation for different
  members and definitions.

  Spec Docs: https://heycam.github.io/webidl/

* Add a simple output process that emits java (or closure externs) directly as part of the experiment. Consider
  how this would look if we created a parallel model hierarchy and then generated source code based on this model.
  We should also emit browser specific extension with clear markers in the source code (i.e. generate the externs
  prefixed with `chrome_` etc or add explicit annotations in java code).

* Should union types as method parameters just result in multiple overloaded methods in java-land?

* Only keep union type materialization for properties and/or return types from operations?

### Validations

This section lists some validations that should be implemented to at least confirm some of our assumptions:

* Exploded union type lists should not contains:
  * multiple values represented by javascript numbers (otherwise how to determine which variant is intended)
  * multiple dictionary values (otherwise would need to inspect data to switch between them?)
