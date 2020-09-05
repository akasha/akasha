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
