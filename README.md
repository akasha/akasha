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
