# Change Log

### Unreleased

* Remove the `@JsOverlay` annotation from constant "aliases" added to the static namespace class. This was incorrect behaviour and J2CL does not allow the construct.

### [v0.05](https://github.com/akasha/akasha/tree/v0.05) (2021-03-30) · [Full Changelog](https://github.com/akasha/akasha/compare/v0.04...v0.05) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.04&new=0.05) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.04...v0.05)

The release includes 222 potentially breaking API changes and 5 breaking API changes.

Changes in this release:

* Fix a bug introduced in version `v0.04` where the WebIDL `object` type (which is represented in the java binding as `java.lang.Object`) was incorrectly translated to the WebIDL `interface` type named `Object` (which is represented in the java binding as `akasha.core.JsObject`).

### [v0.04](https://github.com/akasha/akasha/tree/v0.04) (2021-03-29) · [Full Changelog](https://github.com/akasha/akasha/compare/v0.03...v0.04) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.03&new=0.04) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.03...v0.04)

The release includes 35 non breaking API changes, 167 potentially breaking API changes and 5 breaking API changes.

Changes in this release:

* Upgrade the `org.realityforge.react4j` artifacts to version `0.181`.
* Incorporate IDL for the javascript type `Object` that will be renamed to `JsObject` when emitted as part of the java binding.

### [v0.03](https://github.com/akasha/akasha/tree/v0.03) (2021-03-23) · [Full Changelog](https://github.com/akasha/akasha/compare/v0.02...v0.03) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.02&new=0.03) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.02...v0.03)

The release includes 1 potentially breaking API change.

Changes in this release:

* Correct the type of the `DOMException.code` attribute that had been incorrectly transformed to a string due to a typo in the transformation configuration files.

### [v0.02](https://github.com/akasha/akasha/tree/v0.02) (2021-03-23) · [Full Changelog](https://github.com/akasha/akasha/compare/v0.01...v0.02) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.01&new=0.02) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.01...v0.02)

The release includes 9 non breaking API changes and 27 breaking API changes.

Changes in this release:

* Imported the WebIDL for the [Cooperative Scheduling of Background Tasks](https://w3c.github.io/requestidlecallback/) specification which resulted in the addition of the `requestIdleCallback()` and `cancelIdleCallback()` functions being added to the `Window` type.
* Adjusted the typing of the typing of the callbacks handed to the `setTimeout()` and `setInterval()` functions to be more java friendly so that a lambda can be passed to the methods in the Java binding. This change has resulted in the removal of the ability to specify a string when creating a timer but this is considered a positive change as that was not a recommended feature.

### [v0.01](https://github.com/akasha/akasha/tree/v0.01) (2021-03-22) · [Full Changelog](https://github.com/akasha/akasha/compare/ade60402464b32cb22500eddfc4c05914b77e30f...v0.01) · [Source Diff](https://github.com/akasha/akasha-java/compare/ade60402464b32cb22500eddfc4c05914b77e30f...v0.01)

 🎉	Initial super-alpha release 🎉.
