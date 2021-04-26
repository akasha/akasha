# TODO

This document is essentially a list of shorthand notes describing work yet to be completed.
Unfortunately it is not complete enough for other people to pick work off the list and
complete as there is too much un-said.

# MVP Release

* Add missing methods to typed array types

* filter out elements that are marked as `JavaOnly` from closure externs - probably by writing a processor that strips them

# Docs Integration

* Process docs and any words that match an original/non-synthetic word then convert into {@link MyType}

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

# Closure Generation

* Make sure that the js types use `@implements` for all the interfaces that we expect which are
  probably characterized via maplike, setlike etc.

* Add affordances for js developers like iterable. i.e.

  > /** @return {!Iterator<!Array<string>>} */
  > Headers.prototype[Symbol.iterator] = function() {};

# Java Generation

* Any type that defines a `[@@iterator]()` method should implement `JsIterable<X>`.

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

### Validations

This section lists some validations that should be implemented to at least confirm some of our assumptions:

* Exploded union type lists should not contain:
  * multiple values represented by javascript numbers (otherwise how to determine which variant is intended)
  * multiple dictionary values (otherwise would need to inspect data to switch between them?)
  * multiple union types represented by javascript strings (DONString, USVString, ByteString, enumeration reference)
