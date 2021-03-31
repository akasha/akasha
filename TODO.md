# TODO

This document is essentially a list of shorthand notes describing work yet to be completed.
Unfortunately it is not complete enough for other people to pick work off the list and
complete as there is too much un-said.

# MVP Release

* Add missing methods to typed array types

* Include link to source repository in the release notes

* Record changes in changelog

# Docs Integration

* Process docs and any words that match an original/non-synthetic word then convert into {@link MyType}

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

* Any type that defines a `[@@iterator]()` method should implement `JsIterable<X>`.

* Consider supporting multiple exposure sets and thus multiple `GlobalX` interfaces in output library. Then
  figure out a way to support multiple `Global` objects. We may also need to support an interface to represent
  `[GlobalObject]` mixins and make sure all our global objects implement that and maybe that it is also exposed
  as a static accessor somewhere.

* Add the ability to designate root types in the graph that either identify nodes to keep or nodes to remove
  and anything that is removed has all references to it removed. This is a way of partitioning the graph into
  more meaningful subgraphs.

* Add codegen for `AsyncIterableMember`

* Use `JsPropertyMap` for records. We may need some "wrapper" types like `JsIntPropertyMap` and like `JsShortPropertyMap`
  which just unchecked cast to `JsPropertyMap<double>` and then cast on the way out?

* It would be nice to add constraints so that `(WebGL2RenderingContext)` cast can be omitted from the call
  `canvas.getContext( WebGL2RenderingContext.NAME )`. This may only be possibly by creating an overlay type such as
  `canvas.getWebGL2Context()`. In an ideal world we could also remove the nullability annotation so that the user
  was not forced to check nullability ... maybe this could be somehow incorporated into the contract. (It seems that
  the only way to implement this is to add a constraint language on type that makes claims such as if arg1 is constant
  value X then arg2 must be of type Y. To create the overlay method we may need to define an extended attribute on
  operation that defines scenario.

# React4j Host Element Factories

Generate host element factories: Events would need to be specially handled to map to reacts event system but we could control whether we generate a capture handler using the `[NoBubble]` attribute on events.

* boolean input values should have a method that accepts a boolean aswell as one that passes default value of true. i.e. `HtmlProps.required(boolean) { return ...; }` and `HtmlProps.required() { return required(true); }`

* `translate` is `yes` or `no` in html where it is boolean at IDL level

# Other

* Add some additional apis from:
  - https://github.com/w3c/webref/tree/master/ed/idl
  - https://github.com/w3c/webref/tree/master/tr/idl
  Documentation and other links could be scraped from https://github.com/w3c/webref

* Consider a reorganization of pipelines so that each independent pipeline can define a local idl to
  include so each transform could be relatively isolated with the processing stages combined with custom
  idl in one place

* Emit closure externs for WebIDL types.

* Parser is extremely slow because of it's recursive nature. Is there a way to "fix" this by reworking the
  grammar some how. For example, the `main` pipeline that loads all the schemas, applys transforms and emits
  a complete idl with all annotations takes 18sec but loading that complete idl takes 51sec)

* It would be nice to extend WebIDL and support throws either as an expression or maybe an extended attribute.
  The Gecko WebIDL files actually have a `[Throws]` extended attribute that we could look into to drive this?

### Validations

This section lists some validations that should be implemented to at least confirm some of our assumptions:

* Exploded union type lists should not contain:
  * multiple values represented by javascript numbers (otherwise how to determine which variant is intended)
  * multiple dictionary values (otherwise would need to inspect data to switch between them?)
  * multiple union types represented by javascript strings (DONString, USVString, ByteString, enumeration reference)
