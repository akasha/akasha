# TODO

This document is essentially a list of shorthand notes describing work yet to be completed.
Unfortunately it is not complete enough for other people to pick work off the list and
complete as there is too much un-said.

# MVP Release

* Rename output to avoid naming clash with elemental2
  - Atomix
  - Atomical
  - Elementix
  - Elementrix
  - Elemix
  - eLemix
  - fission
  - atomize

* Figure out a way how to manage which versions of the elemental3 packages have been deployed. We
  have currently deployed `org.realityforge.webtack:webtack-elemental3-complete:jar:0.02` to maven central
  but have no way to automate the upload, release and bump of the version number.

* Remove dependency on `elemental2-core`

* Change ArrayBufferView so it is interface implemented by TypeArrays

# Docs Integration

* Process docs and any words that match an original/non-synthetic word then convert into {@link MyType}

* Link with OpenGL docs ala https://www.khronos.org/registry/OpenGL-Refpages/es2.0/xhtml/glBindBuffer.xml

* Some doc entries include documentation for constants .. scan for that?.

* Extract param docs for methods and constructors.
  - See example at https://developer.mozilla.org/en-US/docs/Web/API/WebGLRenderingContext/polygonOffset

* Add special handling for `@return` javadoc.

* Scan [MDN browser compat ability data](https://github.com/mdn/browser-compat-data/tree/master/api) to
  build up compatibility table for elements, possibly adding
  [browser](https://github.com/mdn/browser-compat-data/tree/master/browsers) compatibility to the mix.
  Alternatively extract [caniuse](https://github.com/Fyrd/caniuse) data.

# Apps to Stretch Implementation

* Complete `react4j-vchat`

* webgl renderer of some kind.
 - a good one is https://github.com/PavelDoGreat/WebGL-Fluid-Simulation/blob/master/script.js

* Port https://github.com/toji/webxr-particles

* WebRTC + XR + Hand-tracking to create VR chat with a real feel of social presence. Each "area" would be hosted
  independently and other users use webrtc so connect to that peer. The communication could include audio and/or
  video as well as a data stream. Video would allow the immersion of desktop users into the world.
 - Hand Tracking: https://github.com/marlon360/webxr-handtracking
 - Hand Tracking: https://github.com/stewdio/handy.js
 - WebXR Layers Spec: https://github.com/immersive-web/layers
 - WebXR Layers Sample: https://cabanier.github.io/WebXRLayers-samples/index.html

* Figure out an example for indexdb.

# Java Generation

* Change the way that globals are implemented. So that a global context based on window would be named `GlobalWindow` and would extend `Window`. Thus we could eliminate the instance methods on `Global` and add static methods to access the methods on window and static access to the namespaces. Once this is in place we could consider generating multiple globals for each context and exposing all the common namespaces on the `Global` object.

* Change the implementation class of namespaces to be `XNamespace` rather than `X` and then make `X` contain static methods that mirror those on the namespace. Thus we would have `Console.log(...)` which would result in a call like `Global.globalThis().console().log(...)`

* Add `static boolean isValid(...) {...}` to java enumerations for `enum` and `const enum` types to make it easy to validate types in code.

* Add `[alias=SomeAlias]` extended attribute that will create an alias method via a `@JsOverlay` that calls base
  method. The alias method will also omit any arguments that have a `values=` extended attribute with a single value

* Define operation alias `canvas.getContext()` that passed `WebGL2RenderingContextAttributes` and returns
  `WebGL2RenderingContext` and whos first  parameter is `values=` restricted to the appropriate value.

* Add the ability to designate root types in the graph that either identify nodes to keep or nodes to remove
  and anything that is removed has all references to it removed. This is a way of partitioning the graph into
  more meaningful subgraphs.

* Add codegen for `IterableMember` and `AsyncIterableMember`

* Generate a test that checks whether the browser supports the symbols that are in the webidl. Essentially the test
  would use raw inspection of objects to see if they line up with what is in WebIDL

* Use `JsPropertyMap` for records. We may need some "wrapper" types like `JsIntPropertyMap` and like `JsShortPropertyMap`
  which just unchecked cast to `JsPropertyMap<double>` and then cast on the way out?

* It would be nice to add constraints so that `(WebGL2RenderingContext)` cast can be omitted from the call
  `canvas.getContext( WebGL2RenderingContext.NAME )`. This may only be possibly by creating an overlay type such as
  `canvas.getWebGL2Context()`. In an ideal world we could also remove the nullability annotation so that the user
  was not forced to check nullability ... maybe this could be somehow incorporated into the contract. (It seems that
  the only way to implement this is to add a constraint language on type that makes claims such as if arg1 is constant
  value X then arg2 must be of type Y.

* Make `AbstractProcessor` cache instance of `PipelineContext`

* Consider allowing some unions to be have extended attributes that indicate that they should be converted into
  marker interfaces for all the contained types. `IntegerTypedArray` could be converted into such an abstraction
  as could `Transfer` and `TexImageSource`

# React4j Host Element Factories

Generate host element factories: Events would need to be specially handled to map to reacts event system but we could control whether we generate a capture handler using the `[NoBubble]` attribute on events.

* boolean input values should have a method that accepts a boolean aswell as one that passes default value of true. i.e. `HtmlProps.required(boolean) { return ...; }` and `HtmlProps.required() { return required(true); }`

* `translate` is `yes` or `no` in html where it is boolean at IDL level

# Other

* Add a processor that changes the type of a operation, attribute, dictionary member etc to specific type.
  Change the way we enhance schemas for adding `enum` and `const enum` support to libraries.

* Convert several other ECMA namespaces/types from https://tc39.es/ecma262/ to WebIDL

* Create a ruby or java DSL that builds up the pipeline configuration.

* Add some additional apis from:
  - https://github.com/w3c/webref/tree/master/ed/idl
  - https://github.com/w3c/webref/tree/master/tr/idl
  Documentation and other links could be scraped from https://github.com/w3c/webref

* Consider a reorganization of pipelines so that each independent pipeline can define a local idl to
  include so each transform could be relatively isolated with the processing stages combined with custom
  idl in one place

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

* Parser is extremely slow because of it's recursive nature. Is there a way to "fix" this by reworking the
  grammar some how. For example, the `main` pipeline that loads all the schemas, applys transforms and emits
  a complete idl with all annotations takes 18sec but loading that complete idl takes 51sec)

* It would be nice to extend WebIDL and support throws either as an expression or maybe an extended attribute.
  The Gecko WebIDL files actually have a `[Throws]` extended attribute that we could look into to drive this?

* Expand `const enum` support to cover off all remaining APIs such as `svg` and `gl`.

### Validations

This section lists some validations that should be implemented to at least confirm some of our assumptions:

* Exploded union type lists should not contain:
  * multiple values represented by javascript numbers (otherwise how to determine which variant is intended)
  * multiple dictionary values (otherwise would need to inspect data to switch between them?)
  * multiple union types represented by javascript strings (DONString, USVString, ByteString, enumeration reference)
