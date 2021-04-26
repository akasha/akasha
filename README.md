# WebTack: Fetch and process WebIDL to generate Source Code

[![Build Status](https://api.travis-ci.com/akasha/akasha.svg?branch=master)](http://travis-ci.com/akasha/akasha)

## What is WebTack?

WebTack is a tool designed to fetch WebIDL and supporting artifacts, process the WebIDL and generate source
code to support writing web applications.

[WebIDL](https://heycam.github.io/webidl/) is used by various specifications to communicate the interfaces that
are expected to be implemented in web browsers. Many web browsers also use a WebIDL variant to generate code to
implement the specification.

The types of source code artifacts that WebTack generates or will generate include:

* [Closure-compiler](https://github.com/google/closure-compiler) externs so that the closure-compiler
  can perform type checking and advanced type-based optimizations.
* Jsinterop annotated java classes that can be used in [GWT](https://github.com/gwtproject/gwt) or
  [J2CL](https://github.com/google/j2cl) based projects.
* [React4j](https://github.com/react4j/react4j) element factories.

WebIDL published as part of the official specifications are not always perfect representations of the interfaces as
implemented by the web browsers. Nor is there a central place that contains the complete WebIDL that a browser is
expected to implement. WebTack defines a pipeline for processing WebIDL schemas. The pipeline defines a series of
stages. Each stage will either transform a schema, combine multiple schemas or perform an action for the schema.
This capability allows WebIDL or process the WebIDL schemas fetched from the specifications and combine them into
a consistent document.

WebTack also includes tools to fetch data from other locations and combine the data with the WebIDL in processing
stages. The most significant other data source is the documentation that is scraped from the
[MDN](https://developer.mozilla.org/en-US/) website and used to add basic documentation to the WebIDL elements. In the
near future it is expected that the [browser compatibility data](https://github.com/mdn/browser-compat-data/tree/master/api)
will be also be scraped so that browser compatibility data for WebIDL elements can be used in the processing pipeline
to influence how artifacts are built. Other data from the web specifications could be combined to improve the outputs.
At the very least, links to the specifications will be added to the WebIDL elements in the future.

WebTack extends the WebIDL syntax to support additional data being added to the WebIDL. This includes syntax to
explicitly declare events emitted by interfaces (i.e. there is a new member element that looks like
`event ProgressEvent load;`). It also supports a [Javadoc-like](https://en.wikipedia.org/wiki/Javadoc) syntax for
documenting the WebIDL elements.

The WebTack jsinterop action generates source code with a more java-esque feel than is present in
[elemental2](https://github.com/google/elemental2). It also aims to offer affordances that make working with
the browser API easier for java developers. A few differences from Elemental2 include:

* Javadocs are added for most fields, methods and types if the element is documented on MDN. This often includes
  references to the specification in which the element is defined.
* Constants in WebIDL are represented as constants in java. This typically results in smaller code size and may open
  up additional optimization opportunities.
* Fields, methods and parameters are annotated with `@Nonnull` or `@Nullable` if the type is a non-primitive, non-void type.
* Read-only attributes in WebIDL are implemented as methods rather than mutable fields or properties with setters.
* Dictionaries in WebIDL use a "builder" pattern to make construction of these types much easier.
* No parameterized types exist in WebTack as WebIDL does not define such constructs.
* Event handlers and event listeners are typed according to type of event expected to be delivered and have a void
  return type. This simplifies the use of lambdas and method references in java code.
* `@JsOverlay` methods are added for known events emitted by an interface. For example, it is possible to use code such
  as `e.addBlurListener(this::processBlurEvent)` rather than the more verbose `e.addEventListener("blur", e -> processBlurEvent((FocusEvent) e)`
* WebIDL enumerations are annotated with the `@MagicConstant` annotation when translated to java code. The
  Jetbrains/IntelliJ IDE suite will detect this annotation and allow auto-completion of enumeration values or
  report errors when incorrect values are supplied.
* Several other minor usability improvements, particularly with respect to union types.

One of the greatest advantages of WebTack is the ability to quickly generate API for new specifications. First you
run a single command to register the spec url, extracting the WebIDL from the specification and extract the
documentation from MDN. Then you run a second command to regenerate the java library.

### The Now

Experiments with WebTack are ongoing but so far the experiments have largely proved successful. Several web apps
have been created to explore the feel of using the generated code. This has included experiments with the
[Web Bluetooth API](https://webbluetoothcg.github.io/web-bluetooth/) by creating a browser based
[Heart Rate Monitor](https://github.com/react4j/react4j-heart-rate-monitor), experiments with [speech synthesis](https://github.com/react4j/react4j-webspeechdemo) using the [Web Speech API](https://wicg.github.io/speech-api/), experiments
with [WebRTC](https://w3c.github.io/webrtc-pc/) by creating a [video chat application](https://github.com/react4j/react4j-vchat)
and several other experiments that are not open source.

The experiments to date, have copied the WebTack generated source into the source tree. To facilitate experiments
by third parties, the generated source code for the has been packaged and published to maven central. This artifact
can be added as a maven dependency:

```xml
<dependency>
  <groupId>org.realityforge.akasha</groupId>
  <artifactId>akasha-java</artifactId>
  <version>0.10</version>
</dependency>
```

### The Future

WebTack is an alpha project that is surprisingly useful as is. It is extremely useful to start using web APIs
that are not covered by [elemental2](https://github.com/google/elemental2) with minimal fuss. The web APIs are also
generated with basic javadocs that makes it relatively easy to explore the API locally or follow a link to MDN for
more details. The java API is usually equivalent or better than the equivalent in Elemental2 as it tries to follow
conventions more comfortable to Java developers.

The outputs are not without limitations. The following limitations that have been discovered while using the
outputs of WebTack.

#### Large Java Packages

WebTacks jsinterop action generates a java type for every element within the input WebIDL schema. These elements
are mostly generated within a single java package. If a reasonably complete WebIDL is fed into the action this can
produce a single package with 1200+ java classes. This is not the simplest structure to navigate and is not expected
to be an efficient compilation module.

An approach that we have used to address this limitation is manually partitioning the schema into required subset
needed by the application. This has been surprisingly effective at producing small java packages, at the expense of
some manual labour. However, it is expected that this would not scale to larger applications. A better approach maybe
to automatically partition the files into different packages based on the originating specification or some other
grouping heuristic.

#### Browser Implementation Differences

Some APIs that applications are browser-specific and thus not included in the specification. Some browsers do not
implement the specification exactly. The fix is to apply processor stages to adjust the schema to match the way
browsers implement the specification. This is somewhat error prone as it involves detecting the error and applying
the appropriate patch. A better solution is to import the browser specific WebIDL source files, detect differences
and merge the differences as desired. This should be relatively easy for chrome and gecko based browsers that already
have publicly available WebIDL files.

#### The globalThis / ExposureSet relationship is not yet finalized

Javascript has the notion of a global object that is named `globalThis` in modern versions of javascript.
The properties, operations and namespaces exposed on the global object differs in different JavaScript
environments.

Historically, accessing the global object has required different syntax in different JavaScript environments. On
the web you can use `window`, `self`, or `frames` - but in Web Workers only `self` will work. In Node.js none of
these work, and you must instead use `global`. In WebIDL, the `ExposureSet` extended attribute is used to control
whether an interface or namespace is present in a particular Javascript environment.

WebTack currently assumes that the generated library is used in a specific JavaScript environment. This makes it
difficult to reuse the library across different Javascript environments. WebTack generates a single
`Global.globalThis()` static method to access the global object which is quite verbose. Both of these implementation
decisions will be re-evaluated going forward.

#### Missing/Incomplete Features

WebTack is missing a handful of features.

* The `IterableMember` element in WebIDL does not yet result in any java code as no application has required that
  feature yet.
* Some of the type mappings from WebIDL to java are not mapped in a java-friendly manner. The most obvious example
  is how sequences of non-double numeric values or nullable non-double primitives are mapped to java. The numeric
  values are mapped to `java.lang.Double` as that will map to javascript `number` when compiled. It is unclear on
  the best strategy to address this mismatch.

# Contributing

The project was released as open source so others could benefit from the project. We are thankful for any
contributions from the community. A [Code of Conduct](CODE_OF_CONDUCT.md) has been put in place and
a [Contributing](CONTRIBUTING.md) document is under development.

# License

The project is licensed under [Apache License, Version 2.0](LICENSE).

# Credit

* This project took inspiration and some techniques from:
    * [TSJS-lib-generator](https://github.com/microsoft/TSJS-lib-generator): a WebIDL to Typescript types project.
    * [jsinterop-generator](https://github.com/google/jsinterop-generator): A closure externs to Java project.
