# WebTack: Fetch and process WebIDL to generate Source Code

[![Build Status](https://api.travis-ci.com/realityforge/webtack.svg?branch=master)](http://travis-ci.com/realityforge/webtack)

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
  <groupId>org.realityforge.webtack</groupId>
  <artifactId>webtack-elemental3-complete</artifactId>
  <version>0.02</version>
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

#### Missing/Incomplete Features

WebTack is missing a handful of features.

* Ths closure externs generator action has been removed as it was not being exercised as our test applications are
  not using J2CL.
* The `IterableMember` element in WebIDL does not yet result in any java code as no application has required that
  feature yet.
* Some of the type mappings from WebIDL to java are not mapped in a java-friendly manner. The most obvious example
  is how sequences of non-double numeric values or nullable non-double primitives are mapped to java. The numeric
  values are mapped to `java.lang.Double` as that will map to javascript `number` when compiled. It is unclear on
  the best strategy to address this mismatch.
* WebTack references several classes from `elemental2-promise` and `elemental2-core` libraries. These dependencies
  can and should be removed but this would require additional work that has not been done.


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
