# TODO

This document is essentially a list of shorthand notes describing work yet to be completed.
Unfortunately it is not complete enough for other people to pick work off the list and
complete as there is too much un-said.

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

* Add some apis at https://www.w3.org/wiki/DAS/Implementations

* Complete implementation of `Transferable` by adding `Transferable` extended attribute to
  the dictionary member `PostMessageOptions.transfer`

# Docs Integration

* Add `a:not([class="new"])` when MDN scanning so that we never collect unrealized links.

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

* Do we ever need `Any` as a parameter value? Why not always use `@DoNotAutobox @Nullable Object`. It would mean
  that we could pass null without having to type cast to `Object` or `Any` when trying to invoke these APIs.

* Add an extended attribute ala `[values=[Value1,Value2]]` that indicates either the value returned by an
  operation, the value of an attribute, the value passed as an argument must comply with the values in set.
  This will result in a `@MagicConstant` being generated for the element. The first implementation will just
  support enumeration types and the values in the `values` list will be the strings that are part of enumeration
  set. The second phase will be for numeric values and it is expected the values within `values` list are
  constants of the same type in the declaring element.
  - add a processor that makes adding `values` extended attribute to appropriate elements. Maybe adapt
    `AddExtendedAttribute` to cover this capability?
  - Consider adding `valuesSource=SomeType` that names an interface/enumeration from which to source values.
  - Add validation that verifies the values extended attribute appears in the correct locations in WebIDL, references
    values that exist, contains at least 1 value, references constants of the correct type and appears on members
    of the correct type (i.e. Can not annotate a reference to an interface)

* Apply `values=...` to restrict numeric values for GL method arguments such as in `WebGLRenderingContext.bindBuffer()`

* Apply `values=...` to restrict numeric values for readyState etc.

* Add `[alias=SomeAlias]` extended attribute that will create an alias method via a `@JsOverlay` that calls base
  method. The alias method will also omit any arguments that have a `values=` extended attribute with a single value

* Define operation alias `canvas.getContext()` that passed `WebGL2RenderingContextAttributes` and returns
  `WebGL2RenderingContext` and whos first  parameter is `values=` restricted to the appropriate value.

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

* It would be nice to add constraints so that `(WebGL2RenderingContext)` cast can be omitted from the call
  `canvas.getContext( WebGL2RenderingContext.NAME )`. This may only be possibly by creating an overlay type such as
  `canvas.getWebGL2Context()`. In an ideal world we could also remove the nullability annotation so that the user
  was not forced to check nullability ... maybe this could be somehow incorporated into the contract. (It seems that
  the only way to implement this is to add a constraint language on type that makes claims such as if arg1 is constant
  value X then arg2 must be of type Y.

* Make `AbstractProcessor` cache instance of `PipelineContext`

# React4j Host Element Factories

Generate host element factories: Events would need to be specially handled to map to reacts event system but we could control whether we generate a capture handler using the `[NoBubble]` attribute on events.

* boolean input values should have a method that accepts a boolean aswell as one that passes default value of true. i.e. `HtmlProps.required(boolean) { return ...; }` and `HtmlProps.required() { return required(true); }`

* `translate` is `yes` or `no` in html where it is boolean at IDL level

# Other

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

### Validations

This section lists some validations that should be implemented to at least confirm some of our assumptions:

* Exploded union type lists should not contain:
  * multiple values represented by javascript numbers (otherwise how to determine which variant is intended)
  * multiple dictionary values (otherwise would need to inspect data to switch between them?)
  * multiple union types represented by javascript strings (DONString, USVString, ByteString, enumeratin reference)
