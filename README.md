# Akasha: Evergreen Browser API

[![Build Status](https://api.travis-ci.com/akasha/akasha.svg?branch=master)](http://travis-ci.com/akasha/akasha)

## What is Akasha?

Akasha is a typed browser API layer that is always up to date with the latest web specifications. These API layers
are intended to simplify writing web applications in languages other than pure-Javascript. Akasha currently
provides:

* [Closure-compiler](https://github.com/google/closure-compiler) externs so that the closure-compiler
  can perform type checking and advanced type-based optimizations.
* Jsinterop annotated java classes that can be used in [GWT](https://github.com/gwtproject/gwt) or
  [J2CL](https://github.com/google/j2cl) based projects.

In the near future, it is expected that bindings for other languages and frameworks will be produced
(particularly to support WASM based toolkits). Support will also be re-enabled to generate
[React4j](https://github.com/react4j/react4j) element factories.

## How does it work?

Akasha is kept with evolving browser standards by fetching WebIDL and processing the WebIDL to generate
source code and other artifacts.

[WebIDL](https://heycam.github.io/webidl/) is used by various specifications to communicate the interfaces that
are expected to be implemented in web browsers. Many web browsers also use a WebIDL variant to generate code to
implement the specification.

WebIDL published as part of the official specifications are not always perfect representations of the interfaces as
implemented by the web browsers. Nor is there a central place that contains the complete WebIDL that a browser is
expected to implement. The Akasha suite defines a pipeline for processing WebIDL schemas. The pipeline defines a
series of stages. Each stage will either transform a schema, combine multiple schemas or perform an action for the
schema. This capability allows WebIDL or process the WebIDL schemas fetched from the specifications and combine
them into a consistent document.

The Akasha suite also includes tools to fetch data from other locations and combine the data with the
WebIDL in processing stages. The most significant other data source is the documentation that is scraped from the
[MDN](https://developer.mozilla.org/en-US/) website and used to add basic documentation to the WebIDL elements. In the
near future it is expected that the [browser compatibility data](https://github.com/mdn/browser-compat-data/tree/master/api)
will be also be scraped so that browser compatibility data for WebIDL elements can be used in the processing pipeline
to influence how artifacts are built. Other data from the web specifications could be combined to improve the outputs
generated from the suite.

Akasha extends the WebIDL syntax to support additional data being added to the WebIDL. This includes syntax to
explicitly declare events emitted by interfaces (i.e. there is a new member element that looks like
`event ProgressEvent load;`). It also supports a [Javadoc-like](https://en.wikipedia.org/wiki/Javadoc) syntax for
documenting the WebIDL elements.

The Akasha jsinterop action generates source code with a more java-esque feel than is present in
[elemental2](https://github.com/google/elemental2). It also aims to offer affordances that make working with
the browser API easier for java developers. A few differences from Elemental2 include:

* Javadocs are added for most fields, methods and types if the element is documented on MDN. This often includes
  references to the specification in which the element is defined.
* Constants in WebIDL are represented as constants in java. This typically results in smaller code size and may open
  up additional optimization opportunities.
* Fields, methods and parameters are annotated with `@Nonnull` or `@Nullable` if the type is a non-primitive, non-void type.
* Read-only attributes in WebIDL are implemented as methods rather than mutable fields or properties with setters.
* Dictionaries in WebIDL use a "builder" pattern to make construction of these types much easier.
* No parameterized types exist in Akasha generate artifacts as WebIDL does not define such constructs. However there
  are a handful of hand-written jsinterop annotated java classes such as `JsArray`, `JsMap`, `JsSet`, `JsWeakMap`
  and `JsWeakSet` that make use of parameterized types to support normal java development practices.
* Event handlers and event listeners are typed according to type of event expected to be delivered and have a void
  return type. This simplifies the use of lambdas and method references in java code.
* `@JsOverlay` methods are added for known events emitted by an interface. For example, it is possible to use code such
  as `e.addBlurListener(this::processBlurEvent)` rather than the more verbose `e.addEventListener("blur", e -> processBlurEvent((FocusEvent) e)`
* WebIDL enumerations are annotated with the `@MagicConstant` annotation when translated to java code. The
  Jetbrains/IntelliJ IDE suite will detect this annotation and allow auto-completion of enumeration values or
  report errors when incorrect values are supplied.
* Several other minor usability improvements, particularly with respect to union types.

One of the greatest advantages of Akasha is the ability to quickly generate API for new specifications. First you
run a single command to register the spec url, extracting the WebIDL from the specification and extract the
documentation from MDN. Then you run a second command to regenerate the java and library and closure externs.

## How does this relate to WebTack?

WebTack was the former name of this project when the scope encompassed building a tool to fetch and process
WebIDL files. That name still lives on with that part of the suite but the name is no longer used outside this
project.

## The project evolution

Akasha grew out of several experiments that helped shape the way the code was generated. Several web apps
have been created to explore the feel of using the generated code and these may be interesting to investigate
to get a feel of how the project evolved. This has included experiments with the
[Web Bluetooth API](https://webbluetoothcg.github.io/web-bluetooth/) by creating a browser based
[Heart Rate Monitor](https://github.com/react4j/react4j-heart-rate-monitor), experiments with [speech synthesis](https://github.com/react4j/react4j-webspeechdemo) using the [Web Speech API](https://wicg.github.io/speech-api/), experiments
with [WebRTC](https://w3c.github.io/webrtc-pc/) by creating a [video chat application](https://github.com/react4j/react4j-vchat)
and several other experiments that are not open source.

The next major milestone was for integration of Akasha into a medium sized application with ~600K lines of GWT
code that has been in development since 2011. This integration has successfully replaced our previous browser API
layers and we are now focusing on fine tuning and optimizing the output.

Adopting Akasha has made it trivial to integrate with new Web APIs as they come out with minimal fuss compared to
past approaches such as the handwritten DOM adapters, elemental or elemental2 libraries and we think Akasha is nearing
a time where it is suitable for adoption in a broader context.

### Limitations

The outputs are not without limitations. The following limitations that have been discovered while using
the libraries generated by Akasha.

#### Large Java Packages

Akasha generates a java type for every element within the input WebIDL schema. These elements are mostly
generated within a small number of java packages. A reasonably complete WebIDL will produce a single library
with 1200+ java classes. This is not the simplest structure to navigate and is not expected to be an efficient
compilation module. See [Issue #9](https://github.com/akasha/akasha/issues/9) for a potential path to addressing
this limitation.

#### Browser Implementation Differences

Some APIs that applications are browser-specific and thus not included in the specification. Some browsers do not
implement the specification exactly. The fix is to apply processor stages to adjust the schema to match the way
browsers implement the specification. This is somewhat error prone as it involves detecting the error and applying
the appropriate patch. A better solution is to import the browser specific WebIDL source files, detect differences
and merge the differences as desired. This should be relatively easy for chrome and gecko based browsers that already
have publicly available WebIDL files. See [Issue #1](https://github.com/akasha/akasha/issues/1) to track any progress
made towards addressing this limitation.

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
    * [Elemental2](https://github.com/google/elemental2): A Browser API generated from closure externs by the `jsinterop-generator` tool.
