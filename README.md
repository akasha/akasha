# webtack: Generate jsinterop types from WebIDL

[![Build Status](https://secure.travis-ci.org/realityforge/webtack.svg?branch=master)](http://travis-ci.org/realityforge/webtack)
[<img src="https://img.shields.io/maven-central/v/org.realityforge.webtack/webtack.svg?label=latest%20release"/>](https://search.maven.org/search?q=g:org.realityforge.webtack%20a:webtack)

## What is webtack?

This is an experimental tool that pulls in WebIDL files and generates java and closure types from the IDL.

### Getting Started

The tool is released to Maven Central and can be downloaded using normal dependency download mechanisms.
The Maven dependency is:

```xml
<dependency>
  <groupId>org.realityforge.webtack</groupId>
  <artifactId>webtack</artifactId>
  <version>0.00</version>
</dependency>
```

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

