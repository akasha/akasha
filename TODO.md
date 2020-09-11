# TODO

This document is essentially a list of shorthand notes describing work yet to be completed.
Unfortunately it is not complete enough for other people to pick work off the list and
complete as there is too much un-said.

* Figure out a way how to manage which versions of the elemental3 packages have been deployed. We
  have currently deployed `org.realityforge.webtack:webtack-elemental3-complete:jar:0.02` to maven central
  but have no way to automate the upload, release and bump of the version number.

* Add some apis at https://www.w3.org/wiki/DAS/Implementations

* Consider making `Transferable` extended attribute into a "marker interface" and change
  `interface MessagePort { void postMessage( any message, sequence<object> transfer ); }`
  so that it can be marked as Transferable. See closure externs for how it is used
  - https://developer.mozilla.org/en-US/docs/Web/API/Transferable
  "The ArrayBuffer, MessagePort, ImageBitmap and OffscreenCanvas types implement this interface."
  Probably what we need to do is create a synthetic marker interface and apply marker interface to
  types and accept values of that type. Alternatively we could convert it to a union in an earlier
  step which is functionally equivalent if a bit uglier in java code.

# Docs Integration

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

* Maybe mesh+shaders sample app?

* Port https://github.com/toji/webxr-particles

* WebRTC + XR + Hand-tracking to create VR chat with a real feel of social presence. Each "area" would be hosted
  independently and other users use webrtc so connect to that peer. The communication could include audio and/or
  video as well as a data stream. Video would allow the immersion of desktop users into the world.
 - Hand Tracking: https://github.com/marlon360/webxr-handtracking
 - Hand Tracking: https://github.com/stewdio/handy.js
 - WebXR Layers Spec: https://github.com/immersive-web/layers
 - WebXR Layers Sample: https://cabanier.github.io/WebXRLayers-samples/index.html

# Java Generation

* Change the way `FormEncodingType` is encoded by supporting extended attributes on enumeration values AND
  defining an extended attribute to change the name that java field is generated with.

* Extract a separate module for building java-generating generators. Move `AbstractJavaAction` and other related
  infrastructure to this project.

* Extract a separate module for testing java-generating generators. Move `AbstractTest`, `BailErrorListener` and
  `JavaProcess` from `jsinterop-generator` and `react4j-generator` projects to this module.

* Add the ability for an extended attribute such as `javaSubPackage=mySubPkg` to control which subpackage the
  type is created in.

* Add the ability to designate root types in the graph that either identify nodes to keep or nodes to remove
  and anything that is removed has all references to it removed. This is a way of partitioning the graph into
  more meaningful subgraphs.

* Add codegen for `IterableMember`

* Generate a test that checks whether the browser supports the symbols that are in the webidl. Essentially the test
  would use raw inspection of objects to see if they line up with what is in WebIDL

* Use `JsPropertyMap` for records. We may need some "wrapper" types like `JsIntPropertyMap` and like `JsShortPropertyMap`
  which just unchecked cast to `JsPropertyMap<double>` and then cast on the way out?

# React4j Host Element Factories

Generate host element factories in the current style Generate one prop object per HTML element with parallel inheritance. The `ref` param would be typed and all the other attributes would be as-is. Events would need to be specially handled to map to reacts event system but we could control whether we generate a capture handler using the `[NoBubble]` attribute on events.

* Update the react4j action to use type catalog to lookup idl types rather than hardcoding `elemental3` package.

* boolean input values should have a method that accepts a boolean aswell as one that passes default value of true. i.e. `HtmlProps.required(boolean) { return ...; }` and `HtmlProps.required() { return required(true); }`

* `translate` is `yes` or `no` in html where it is boolean at IDL level

# Other

* Add a `complete` method on `Action`, `Combiner` and `Processor` interfaces that will be invoked once the code will no longer have any schemas passed in. This allows the processor to perform cleanup and/or check that it is still needed. i.e. if a `RenameX` processor does not perform any renames we could alert in the complete to indicate that no match occurred. We could also add statistics (i.e. renamed 2 elements).

* Add an `expectedChangeCount` to various processors that will generate an error if the expected number of
  changes is not identical.

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
  The Gecko WebIDL files actually have a `[Throws]`  extended attribute that we could look into to drive this?

### Validations

This section lists some validations that should be implemented to at least confirm some of our assumptions:

* Exploded union type lists should not contain:
  * multiple values represented by javascript numbers (otherwise how to determine which variant is intended)
  * multiple dictionary values (otherwise would need to inspect data to switch between them?)
  * multiple union types represented by javascript strings (DONString, USVString, ByteString, enumeratin reference)