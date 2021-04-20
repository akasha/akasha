# Change Log

### Unreleased

* Convert `akasha.core.JsObject` from a generated class to a locally customized version that performs an `uncheckedCast(...)` to avoid type errors when compiling with base externs provided by closure compiler.
* Remove incorrect `@JsOverlay` annotations on non-inlined constants in the generated Java binding.
* Rework the way namespaces are implemented in the java binding to be compatible with the closure externs shapes. This involved eliminating the synthetic interface and the ability to access the namespace as an instance object within java and moving to static-only fields and methods in the java representation.
* Make the second parameter of the `parseInt` function on the global object required rather than optional as this is required by the builtin closure externs.

### [v0.07](https://github.com/akasha/akasha/tree/v0.07) (2021-04-17) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.06...v0.07) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.06&new=0.07) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.06...v0.07)

The release includes 3 non breaking API changes and 3 breaking API changes

Changes in this release:

* Change the way namespaces are represented in closure externs. Namespace were previously represented as a `@const` variable with a type that defined the interface which was never correct from a conceptual point of view but is consistent with how some namespaces are represented in existing closure externs. The new representation defines properties and functions on a `@const` variable and omits the type. This avoids a type cast error due to code structure of generated Java code.
* Add some manual patches to closure externs that are required due to the types required in the base closure library.
* Explicitly specify the `javaemul.internal.annotations` dependency rather than inheriting it as an implicit dependency from GWT. Making this dependency explicit makes it easier to replace this dependency when using J2CL to compile the project.
* Convert the `MediaProvider` java type to being a marker interface to reduce the complexity when interacting with that type.

### [v0.06](https://github.com/akasha/akasha/tree/v0.06) (2021-04-10) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.05...v0.06) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.05&new=0.06) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.05...v0.06)

The release includes 713 non breaking API changes and 2254 breaking API changes

Changes in this release:

* Remove the `@JsOverlay` annotation from constant "aliases" added to the static namespace class. This was incorrect behaviour and J2CL does not allow the construct.
* Change the way dictionaries with subtypes are represented so that any dictionary that has subtypes moves the chainable builder methods to a separate subtype nested within the dictionary type. This avoids the scenario where a `@JsOverlay` annotated method in the subtype would override a `@JsOverlay` annotated method in the super type. This was incorrect behaviour and J2CL does not allow the construct.
* Remove the `MimeType` and `Plugin` interface types from the whatwg_html spec as the attributes have been updated to return undefined, the methods are noops and two of the major browsers have removed the underlying types. Removal was required for J2CL compatibility as they produced unsupported structures.
* Prefix the java method name of property accessors with an `_` if they start with the `is` string to avoid a bug in the J2CL validation of `@JsProperty` which expects a boolean if the accessor starts with the string `is`.
* Remove the `captureEvents()` and `releaseEvents()` methods from `Document` and `Window` types as they do nothing and only exist for backward compatibility.
* Remove the `clear()` operation from `Document` as it does nothing and only exists for backward compatibility.
* Remove the `applets` collection attribute from the `Document` type as it is always empty and only exists for backwards compatibility.
* Remove the `external` attribute from the `Window` type and the associated type of the of attribute as the field only exists for backwards compatibility and the operations on the associated type do nothing.
* Change the implementation of `JsUtil` so that it uses `Js.uncheckedCast(...)` to lie to the type system. The previous implementation used JSNI which was difficult to make compatible with J2CL without introducing an incompatibility with GWT.
* Add action that generates closure externs based on the WebIDL schema. Closure externs can not exactly represent the type system as present in the browser so when compromises had to be made, guidance was taken from the hand-written externs. These externs have been sufficient to get some akasha based applications converted to J2CL/Closure but they will evolve to a more complete state. The `@nosideeffects` type annotation has not been added to any extern but the type annotation is expected to be present in the future. The closure externs are also missing affordances catering to hand-written javascript and this is expected to be added as needed.

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
