# Change Log

### Unreleased

* Add the `Web Audio API` spec version `Editor’s Draft, 3 May 2022` version.

### [v0.31](https://github.com/akasha/akasha/tree/v0.31) (2022-02-28) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.30...v0.31) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.30&new=0.31) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.30...v0.31)

The release includes 3 non breaking API changes.

Changes in this release:

* Add support for the `Promise.allSettled(...)` function.

### [v0.30](https://github.com/akasha/akasha/tree/v0.30) (2022-02-22) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.29...v0.30) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.29&new=0.30) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.29...v0.30)

The release includes 203 non breaking API changes, 40 potentially breaking API changes and 141 breaking API changes.

Changes in this release:

* Update the `org.realityforge.react4j` artifacts to version `0.187`.
* Add the `WebXR Augmented Reality Module - Level 1` spec version `W3C Working Draft, 24 August 2021` version.
* Add the `File System Living Standard` spec version `3 February 2022` version.
* Add the `WebXR Gamepads Module - Level 1` spec version `W3C Working Draft, 24 August 2021` version.
* Add the `WebXR Hit Test Module` spec version `Editor’s Draft, 30 September 2021` version.
* Add the `WebXR DOM Overlays Module` spec version `Editor’s Draft, 30 August 2021` version.
* Add the `WebXR Layers API Level 1` spec version `W3C Working Draft, 24 August 2021` version.
* Add the `WebXR Hand Input Module - Level 1` spec version `W3C Working Draft, 24 August 2021` version.
* Add the `WebXR Anchors Module` spec version `Editor’s Draft, 30 September 2021` version.
* Add the `WebXR Depth Sensing Module` spec version `Editor’s Draft, 30 September 2021` version.
* Add the `WebXR Lighting Estimation API Level 1` spec version `Editor’s Draft, 4 November 2021` version.
* Rename the `TextureMagnificationFilter` annotation to `SamplerMagnificationFilter`.
* Rename the `TextureMinificationFilter` annotation to `SamplerMinificationFilter`.
* Rename the `TextureWrapMode` annotation to `SamplerWrapMode`.
* Update the `CSS Pseudo-Elements Module Level 4` spec to the `Editor’s Draft, 30 January 2022` version. This added the attribute `CSSPseudoElement.parent` and the operation `CSSPseudoElement.pseudo( CSSOMString type )`.
* Update the `Permissions` spec to the `W3C Working Draft 15 February 2022` version. This version removed the `PermissionName` enum and replaced permission name with an arbitrary string and re-added the (unused) `PermissionSetParameters`.
* Update the `DOM Living Standard` spec to the `8 February 2022` version. This version added the `reason` attribute to `AbortSignal` as well as adding `AbortSignal.throwIfAborted()` and `AbortSignal.timeout(...)`.
* Remove explicit overrides of `toString()` method in the following WebIDL types as the operation is inherited from `Object`: `Boolean`, `Date`, `RegExp`, `String`, `Symbol`, `ArrayBufferViewImpl` and `DataView`.
* Update the `WebGPU` spec to the `W3C Working Draft, 18 February 2022` version.
* Update the `WebCodecs` spec to the `W3C Working Draft, 16 February 2022` version. This resulted in tightening of several types.
* Update the `Pointer Lock 2.0` spec to the `W3C Working Draft 17 November 2021` version.

### [v0.29](https://github.com/akasha/akasha/tree/v0.29) (2021-11-08) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.28...v0.29) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.28&new=0.29) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.28...v0.29)

The release includes 159 non breaking API changes, 9 potentially breaking API changes and 49 breaking API changes.

Changes in this release:

* Update the `High Resolution Time` spec to the `W3C Working Draft 12, October 2021` version. This should have no impact on the jsinterop binding but provides the `EpochTimeStamp` typedef in the generated closure externs.
* Update the `HTML Living Standard` spec to the `5 November 2021` version. This incorporated the functionality that was previously defined as part of the `Page Visibility Level 2` specification which has been removed from the set of specifications ingested by the build process. The upgrade also changed the name of the attributes `textLetterSpacing` to `letterSpacing` and `textWordSpacing` to `wordSpacing` on the 2D rendering context types.
* Update the `WebXR Device API` spec to the `W3C Working Draft, 26 October 2021` version. This update resulted in the addition of the attribute `XRFrame.predictedDisplayTime`.
* Update the `WebGPU` spec to the `W3C Working Draft, 2 November 2021` version. This resulted in support for compressed texture formats such as `astc`, `eac` and `etc2` as well as different mechanism for recording timings in the rendering pipeline.
* Update the `CSS Fonts Module Level 4` spec to the `Editor’s Draft, 3 November 2021` version. This resulted in support the `CSSFontPaletteValuesRule.basePalette` and `CSSFontPaletteValuesRule.fontFamily` attributes being made read-only as well as the replacement of maplike construct on the `CSSFontPaletteValuesRule` with explicit read only attributes `name` and `overrideColors`.
* Update the `Accessible Rich Internet Applications (WAI-ARIA) 1.3` spec to the `W3C Editor's Draft 04 November 2021` version. This resulted in the aria attributes being correctly marked as nullable.
* Update the `Push API` spec to the `W3C Working Draft 03 November 2021` version. This resulted in the operation `PushManager.permissionState(...)` operation return type changing to use the more common `PermissionState`.
* Update the `UI Events` spec to the `W3C Working Draft, 20 October 2021` version. This resulted in the inclusion of the type `MutationEvent` and the operations: `CompositionEvent.initCompositionEvent(...)`, `KeyboardEvent.initKeyboardEvent(...)`, `MouseEvent.initMouseEvent(...)`, `UIEvent.initUIEvent(...)` and `UIEvent.initUIEvent(...)`.
* Update the `Media Source Extensions` spec to the `W3C First Public Working Draft 30 September 2021` version. This resulted in the inclusion of the attribute `MediaSource.canConstructInDedicatedWorker` and the operation `MediaSource.changeType(...)`.
* Add the `Web MIDI API` spec version `W3C Editor's Draft 26 October 2021` version.
* Add the `WebUSB API` spec version `Draft Community Group Report, 6 October 2021` version.

### [v0.28](https://github.com/akasha/akasha/tree/v0.28) (2021-10-22) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.27...v0.28) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.27&new=0.28) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.27...v0.28)

The release includes 761 non breaking API changes, 128 potentially breaking API changes and 840 breaking API changes.

Changes in this release:

* Update the algorithm that "explodes" the types of operations in the jsinterop binding such that if an operation contains multiple arguments with a `sequence` IDL type, then either all `sequence` arguments are represented as java arrays or all `sequence` arguments are represented by `JsArray` and there is not a type explosion.
* Change the strategy used when constructing instances of a dictionary. Dictionaries with zero required members will have the static factory method renamed from `[Dictionary].create()` to `[Dictionary].of()` to align with existing patterns in the ecosystem. Dictionaries with required members will use method chaining to construct the dictionary and will no longer offer a multiple argument static `create(...)` method to construct the dictionary. Dictionaries with zero optional members will omit the `Builder` nested class.
* Add all the locally defined `*CompileTest` classes to the J2cl/closure compile test suite to ensure we do not regress type compatibility.
* Update the `TypedArray` java class to use the closure type `TypedArray` for the j2cl output mode but retain the `?` type in gwt output mode. This is to ensure maximum compatibility with hand-written closure sources.
* Patch the 3-argument `forEach` method on the `TypedArray` implementations to ensure that the type is compatible with current closure externs. The stricter typing present in the java binding is retained by adding a `@JsOverlay` method that retains the correct type.
* Change the type of the parameter in the method `JsObject.isPrototypeOf(JsObject)` to match the closure externs.

### [v0.27](https://github.com/akasha/akasha/tree/v0.27) (2021-09-29) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.26...v0.27) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.26&new=0.27) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.26...v0.27)

The release includes 123 potentially breaking API changes.

Changes in this release:

* Convert operations on global types and namespaces into varargs method in the jsinterop binding if the last argument is an array type. This modifies the following methods:
  * `Console.table(...)`
  * `DedicatedWorkerGlobal.postMessage(...)`
  * `WindowGlobal.postMessage(...)`
* Convert operations on interface types in the jsinterop binding if the last argument is an array type.

### [v0.26](https://github.com/akasha/akasha/tree/v0.26) (2021-09-28) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.25...v0.26) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.25...v0.26)

Changes in this release:

* Convert the last parameter of a dictionary "create" method into a varargs method if it is an array type.
* Convert the of method of union types into a varargs method if one the selected value is an array type.
* Rename `EventHandlerNonNull` to `EventHandler` in the webgpu artifact to align with the names that is used in the gwt and j2cl artifacts.

### [v0.25](https://github.com/akasha/akasha/tree/v0.25) (2021-09-26) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.24...v0.25) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.24&new=0.25) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.24...v0.25)

The release includes 285 non breaking API changes, 6 potentially breaking API changes and 86 breaking API changes.

Changes in this release:

* Specify the type of the `uncapturederror` event emitted by the `GPUDevice` type as `GPUUncapturedErrorEvent`.
* Define the following methods on TypedArray types: `fill`, `includes`, `indexOf`, `lastIndexOf`, `join`, `forEach`, `values`, `keys`, `entries`
* Rework the way the construction method for dictionaries is named if there is a single required parameter so that the name of the method matches the name of the required parameter.

### [v0.24](https://github.com/akasha/akasha/tree/v0.24) (2021-09-12) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.23...v0.24) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.23&new=0.24) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.23...v0.24)

The release includes 110 non breaking API changes, 196 potentially breaking API changes and 95 breaking API changes.

Changes in this release:
* Update the `WebGPU` spec to the `W3C Working Draft, 10 September 2021` version. This update resulted in a few minor name changes (i.e. the `GPURequestAdapterOptions.forceSoftware` member was renamed to `GPURequestAdapterOptions.forceFallbackAdapter`, `GPUAdapter.isSoftware` was renamed to `GPUAdapter.isFallbackAdapter`) as well as improved modelling of the types that contain constants (i.e. `GPUMapMode` no longer extends `JsObject` and is a final class in the java binding).
* Update the `Permissions` spec to the `W3C Working Draft 07 September 2021` version. This update resulted in a few minor changes to the `PermissionsName` enumeration, the addition of the `name` attribute to the `PermissionStatus` type and the removal of the (unused) `PermissionSetParameters`.
* Update the `WebCodecs` spec to the `W3C Working Draft, 8 September 2021` version. This update resulted in many changes across several types. See the API diff for further details.
* Migrate artifacts generated from the `WebCodecs` spec to the package `codecs` in the java binding.
* Update the `Visual Viewport API` spec to the `Draft Community Group Report 10 September 2021` version. This update resulted in the `VisualViewport.segments` attribute being made optional (or Nullable in the java binding).
* Update the `Web Share API` spec to the `W3C Working Draft 03 September 2021` version. This update resulted in the addition of the `Navigator.canShare(...)` operation.
* Update the `WebXR Device API` spec to the `W3C Working Draft, 24 August 2021` version. This update resulted in several changes, check the API diff for further details.
* Update the `HTML Living Standard` spec to the `11 September 2021` version. This update resulted in several changes, check the API diff for further details. The most significant changes were the addition of `oncontextlost` and `oncontextrestored` message handlers to several types and the addition of `isContextLost()` to contexts as appropriate.
* Updates across several specifications resulted in `PostMessageOptions` being renamed to `StructuredSerializeOptions`.
* Re-fetch the entire set of specifications ensuring that the required members in dictionaries appear in declaration order as initiated in version `v0.15`. This has resulted in the reordering of parameters in `create()` methods in the java binding to represent members in declaration order. This impacted the following types at a minimum: `StaticRangeInit`, `XRInputSourcesChangeEventInit`, `RTCRtpCodecCapability`, `RTCRtpCodecParameters`, `RTCRtpContributingSource`, `RTCRtpHeaderExtensionParameters`, `RTCRtpParameters`, `RTCRtpSendParameters`, `RTCStats`, `RTCTrackEventInit`, `HkdfParams`, `Pbkdf2Params`, `AllowedBluetoothDevice`, `AudioProcessingEventInit`, `IIRFilterOptions`, `OfflineAudioContextOptions` (as well as several other less used dictionaries)

### [v0.23](https://github.com/akasha/akasha/tree/v0.23) (2021-09-03) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.22...v0.23) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.22&new=0.23) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.22...v0.23)

The release includes 70 non breaking API changes, 37 potentially breaking API changes and 40 breaking API changes.

Changes in this release:

* Rename several union types to reflect intent, migrate the unions to the java package where they are used and convert unions to marker interfaces where appropriate. i.e. The union type `IDBObjectStoreOrIDBIndexUnion` was renamed to `IDBCursorSource`, converted to a marker interface and migrated to the `akasha.idb` java package. See the API diff for a full list of unions migrated.
* Type the `AudioTrack.kind` attribute as an enumeration containing the set of valid values.

### [v0.22](https://github.com/akasha/akasha/tree/v0.22) (2021-08-30) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.21...v0.22) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.21&new=0.22) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.21...v0.22)

The release includes 554 non breaking API changes, 854 potentially breaking API changes and 143 breaking API changes.

Changes in this release:

* Add the `Resize Observer` spec at `W3C First Public Working Draft, 11 February 2020` version to the set of specs that are used to generate the browser API. This added the `ResizeObserver` type and related infrastructure.
* Fix a bug mapping the `WindowGlobal` type that was introduced in version `0.20` when using the `xsiframe` linker from within a GWT application. The fix is to use the `<window>` namespace rather than the `<global>` namespace.
* Generate static types for global execution contexts of a service worker (i.e. `SharedWorkerGlobal`), a worker (i.e. `DedicatedWorkerGlobal`), a shared worker (i.e. `SharedWorkerGlobal`) and audio worklets (i.e. `AudioWorkletGlobal`).
* Change the way the java binding generates unions so that methods of the form `as[X]()` and `is[X]()` exist for every component type `X` that is part of the union.
* Replace usages of `@javax.annotations.Nullable` with `@jsinterop.annotations.JsNullable` and `@javax.annotations.Nonnull` with `@jsinterop.annotations.JsNonNull` on natively exposed elements to provide additional guidance to the J2CL/closure compiler variant of the java binding.
* Add event handling code to types (i.e. `addXListener(...)` and `removeXListener(...)` methods etc.) to more types and more events. The types and associated events as follows:
  - **AbstractWorker**: `error`
  - **Animation**: `cancel` `finish` `remove`
  - **AudioWorkletNode**: `processorerror`
  - **BaseAudioContext**: `statechange`
  - **Element**: `click` `contextmenu`
  - **EventSource**: `error`
  - **GlobalEventHandlers**: `abort` `animationcancel` `animationend` `animationiteration` `animationstart` `auxclick` `beforeinput` `blur` `cancel` `canplay` `canplaythrough` `change` `click` `close` `compositionend` `compositionstart` `compositionupdate` `contextmenu` `cuechange` `dblclick` `drag` `dragend` `dragenter` `dragexit` `dragleave` `dragover` `dragstart` `drop` `durationchange` `emptied` `ended` `error` `focus` `focusin` `focusout` `gotpointercapture` `input` `invalid` `keydown` `keypress` `keyup` `load` `loadeddata` `loadedmetadata` `loadstart` `lostpointercapture` `mousedown` `mouseenter` `mouseleave` `mousemove` `mouseout` `mouseover` `mouseup` `pause` `play` `playing` `pointercancel` `pointerdown` `pointerenter` `pointerleave` `pointermove` `pointerout` `pointerover` `pointerup` `progress` `ratechange` `reset` `resize` `scroll` `securitypolicyviolation` `seeked` `seeking` `select` `selectionchange` `selectstart` `stalled` `submit` `suspend` `timeupdate` `toggle` `touchcancel` `touchend` `touchmove` `touchstart` `transitioncancel` `transitionend` `transitionrun` `transitionstart` `volumechange` `waiting` `wheel`
  - **HTMLCanvasElement**: `contextlost` `contextrestored`
  - **IDBDatabase**: `versionchange`
  - **MediaDevices**: `devicechange`
  - **MediaKeySession**: `keystatuseschange` `message`
  - **MediaQueryList**: `change`
  - **MediaSource**: `sourceclose` `sourceended` `sourceopen`
  - **Notification**: `click` `close` `error` `show`
  - **OffscreenCanvas**: `contextlost` `contextrestored`
  - **PermissionStatus**: `change`
  - **RTCDtlsTransport**: `error` `statechange`
  - **ScreenOrientation**: `change`
  - **ServiceWorkerContainer**: `controllerchange` `messageerror`
  - **ServiceWorkerGlobalScope**: `canmakepayment` `fetch` `messageerror` `notificationclose` `paymentrequest` `sync`
  - **ServiceWorkerRegistration**: `updatefound`
  - **SourceBuffer**: `abort` `error` `update` `updateend` `updatestart`
  - **SourceBufferList**: `addsourcebuffer` `removesourcebuffer`
  - **TextTrackCue**: `enter` `exit`
  - **TextTrackList**: `removetrack`
  - **WindowEventHandlers**: `afterprint` `beforeprint` `beforeunload` `hashchange` `languagechange` `message` `messageerror` `offline` `online` `pagehide` `pageshow` `popstate` `rejectionhandled` `storage` `unhandledrejection` `unload`
  - **WorkerGlobalScope**: `offline` `online` `rejectionhandled` `unhandledrejection`
  - **XMLHttpRequestEventTarget**: `abort` `error` `load` `loadend` `loadstart` `progress` `timeout`
* Move the classes `IDBObjectStoreOrIDBIndexUnion` and `IDBObjectStoreOrIDBIndexOrIDBCursorUnion` from the `akasha.indexdb` package to the `akasha.idb` package. This was done to align with the rename of `indexDB` package that occurred prior to the initial release of akasha.
* Annotate several synthesized unions with the `@org.jetbrains.annotations.ApiStatus.Internal` annotation to make it clear that these types should not be used in user code. IntelliJ IDE will also generate a warning if user code interacts directly with internal types.

### [v0.21](https://github.com/akasha/akasha/tree/v0.21) (2021-08-18) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.20...v0.21) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.20...v0.21)

Changes in this release:

* Fix bug present in `v0.20` where the compile time constants for features associated with operations rather than attributes did not have the compile time properties defined in the gwt variant of the library.

### [v0.20](https://github.com/akasha/akasha/tree/v0.20) (2021-08-18) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.19...v0.20) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.19&new=0.20) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.19...v0.20)

The release includes 1 non breaking API change and 14 potentially breaking API changes.

Changes in this release:

* Ensure that the `code` parameter to `GPUShaderModuleDescriptor.create()` is annotated with `@WGSL`.
* Replace usages of `goog.global` with `$wnd` in the GWT variant. If there is an error while the GWT application is initializing or Akasha is used early in the initialization process, there was previously a period where `goog.global` had not been assigned and thus the Akasha code would generate errors when using the symbol. This change eliminated this possibility.
* Added feature detection method for the `indexDB` feature. This involved the addition of the `WindowGlobal.isIndexedDBSupported()` and `Window.isIndexedDBSupported()` methods as well as the addition of the compile time constant `"akasha.is__Window_indexedDB__supported"`.
* Added feature detection methods for features exposed on the `Navigator` type. Feature detection methods added and the associated compile time properties include:
  - `Navigator.isClipboardSupported()` with a property `akasha.is__Navigator_clipboard__supported`
  - `Navigator.isCredentialsSupported()` with a property `akasha.is__Navigator_credentials__supported`
  - `Navigator.isGeolocationSupported()` with a property `akasha.is__Navigator_geolocation__supported`
  - `Navigator.isGetGamepadsSupported()` with a property `akasha.is__Navigator_isGetGamepadsSupported__supported`
  - `Navigator.isMediaDevicesSupported()` with a property `akasha.is__Navigator_mediaDevices__supported`
  - `Navigator.isPermissionsSupported()` with a property `akasha.is__Navigator_permissions__supported`
  - `Navigator.isRequestMediaKeySystemAccessSupported()` with a property `akasha.is__Navigator_requestMediaKeySystemAccess__supported`
  - `Navigator.isSendBeaconSupported()` with a property `akasha.is__Navigator_sendBeacon__supported`
  - `Navigator.isServiceWorkerSupported()` with a property `akasha.is__Navigator_serviceWorker__supported`
  - `Navigator.isShareSupported()` with a property `akasha.is__Navigator_share__supported`
  - `Navigator.isVibrateSupported()` with a property `akasha.is__Navigator_vibrate__supported`
  - `Navigator.isWakeLockSupported()` with a property `akasha.is__Navigator_wakeLock__supported`
  - `Navigator.isXrSupported()` with a property `akasha.is__Navigator_xr__supported`

### [v0.19](https://github.com/akasha/akasha/tree/v0.19) (2021-08-16) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.18...v0.19) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.18&new=0.19) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.18...v0.19)

The release includes 10 non breaking API changes, 5 potentially breaking API changes and 5 breaking API changes.

Changes in this release:

* Update the `WebGPU` spec to the `W3C Working Draft, 6 August 2021` version. This update changed the type of the `GPUDeviceDescriptor.requiredLimits` member, rename of several attributes matching `GPUSupportedLimits.maxCompute.*` and the renaming of a few constants in `GPUTextureUsage`.
* Start generating `@JsOverlay` methods of the form `boolean isXSupported()` for features that may be optional in an implementation. This allows downstream libraries to detect whether a feature is present before making use of the feature. The feature detection can be done at run time or at compile time depending on the needs of the application. The default behaviour of feature detection methods are to perform the checks at runtime, however this can be be changed by defining an appropriately named property in closure compiler to either `true` or `false` when using the J2CL variant or setting the equivalent binding property when using the GWT variant. The name of the property is derived from the symbol that is feature detected.
  Feature detection methods added and the associated compile time properties include:
  - `Navigator.isBluetoothSupported()` with a property `akasha.is__Navigator_bluetooth__supported`
  - `Navigator.isGpuSupported()` with a property `akasha.is__Navigator_gpu__supported`
  - `Window.isLocalStorageSupported()` and `WindowGlobal.isLocalStorageSupported()` with a property `akasha.is__Window_localStorage__supported`
  - `Window.isSessionStorageSupported()` and `WindowGlobal.isSessionStorageSupported()` with a property `akasha.is__Window_sessionStorage__supported`
  - `Window.isSpeechSynthesisSupported()` and `WindowGlobal.isSpeechSynthesisSupported()` with a property `akasha.is__Window_speechSynthesis__supported`

### [v0.18](https://github.com/akasha/akasha/tree/v0.18) (2021-08-07) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.17...v0.18) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.17&new=0.18) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.17...v0.18)

The release includes 1 non breaking API change, 9 potentially breaking API changes and 2 breaking API changes.

Changes in this release:

* Move the `akasha.StringOrLongLongUnion` type to `akasha.core.StringOrLongLongUnion` as it is only used by the `akasha.core.JSON` type.
* Add initial support for the `akasha:webgpu-j2cl` artifact which is an Elemental2 compatible variant of the WebGPU specification.
* Rollback the improved typing of the `HTMLSelectElement.selectedOptions` attribute for the `akasha:j2cl` artifact as the typing mechanisms used are not supported by the closure type system.
* Remove the `TrustedScript` symbol from the externs generated for the `akasha:j2cl` artifact as it is no longer required with more recent versions of the closure compiler.

### [v0.17](https://github.com/akasha/akasha/tree/v0.17) (2021-08-02) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.16...v0.17) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.16&new=0.17) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.16...v0.17)

The release includes 7 non breaking API changes.

Changes in this release:

* Convert the following types into `const enum` representation to improve usability in the java binding. The types modified include: `GPUBufferUsageFlags`, `GPUShaderStageFlags`, `GPUMapModeFlags`, `GPUColorWriteFlags` and `GPUTextureUsageFlags`.
* Fix the typing of the `RegExpResult` type so that it is typed as an `Array` in the `akasha:gwt` artifact but continues to be typed as `RegExpResult` for the `akasha:j2cl` artifact. A change introduced in version [`v0.11`](https://github.com/akasha/akasha/tree/v0.11) made it impossible to cast instances of this type in a GWT application without an unchecked cast because GWT was expecting a native javascript type of `RegExpResult` which is actually a closure type and not a javascript type.
* Improve the typing of `HTMLSelectElement.selectedOptions` so accessing an element from the collection does not require casts.

### [v0.16](https://github.com/akasha/akasha/tree/v0.16) (2021-07-28) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.15...v0.16) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.15&new=0.16) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.15...v0.16)

The release includes 10 non breaking API changes and 3 breaking API changes.

Changes in this release:

* Change `JsObject.create(...)`, `JsObject.getPrototypeOf(...)` and `JsObject.assign(...)` operations so that they return an instance of type `JsObject` rather than an instance of type `Object`.
* Explicitly override the `HTMLOptionsCollection.item(...)` and `HTMLOptionsCollection.namedItem(...)` operations inherited from `HTMLCollection` as the `HTMLOptionsCollection` interface guarantees that the return type is `HTMLOptionElement` and thus the usability of the generated classes and externs can be improved by encoding this constraint.
* Update the `org.realityforge.gir` artifact to version `0.12`.
* Update the `org.realityforge.react4j` artifacts to version `0.183`.
* Correct the javadocs for the `JsObject.valueOf_()` operation.
* Define the `JsObject.toString_()` operation.
* Define the `JsObject.hasOwnProperty()` operation.
* Define the `JsObject.propertyIsEnumerable()` operation.
* Define the `JsObject.isPrototypeOf()` operation.

### [v0.15](https://github.com/akasha/akasha/tree/v0.15) (2021-07-23) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.14...v0.15) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.14&new=0.15) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.14...v0.15)

The release includes 3 non breaking API changes, 50 potentially breaking API changes and 4 breaking API changes.

Changes in this release:

* Update the way that the Dictionary factory methods are generated so that the parameters in the factory method are in the same order as they appear in the specification. For some specifications (i.e. WebGPU) the order of members has some semantic connotations (i.e. The `r`, `g`, `b` and `a` members of the `GPUColorDict` should appear in that order in the generated code to respect the way the users of the API expect to arrange the data.)

### [v0.14](https://github.com/akasha/akasha/tree/v0.14) (2021-07-17) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.13...v0.14) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.13&new=0.14) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.13...v0.14)

The release includes 75 non breaking API changes and 285 breaking API changes.

Changes in this release:

* Update the `Permissions` spec to the `W3C Working Draft, 13 July 2021` version. This updated the set of valid values for the `PermissionName` enum.
* Update the `Resource Timing Level 2` spec to the `W3C Editor's Draft 15 July 2021` version. This corrected the type of the `PerformanceResourceTiming.nextHopProtocol` attribute to match the browser implementations but should have no visible impact on the generated API.
* Update the `WebCodecs` spec to the `W3C Working Draft, 17 June 2021` version. This updated the structure of the `EncodedVideoChunkMetadata` dictionary that is used when defining an optional callback when constructing an instance of `VideoEncoder`.
* Update the `Content Security Policy Level 3` spec to the `W3C Working Draft, 29 June 2021` version. This refined the parameters passed to the constructor of the `SecurityPolicyViolationEvent` type.
* Update the `CSS Object Model` spec to the `Editor’s Draft, 7 July 2021` version. This defined a constructor that can be used to create instances of the `CSSStyleSheet` type.
* Update the `HTML Living Standard` spec to the `14 July 2021` version. This added back valid definitions for the deprecated `Plugin` and `MimeType` types as well as adding several minor updates to align with features implemented in  modern browsers.
* Update the `WebGPU` spec to the `W3C Working Draft, 15 July 2021` version. This change included renaming the context type (again!) from `GPUPresentationContext` to `GPUCanvasContext` and ensuring it is typed as an `OffscreenRenderingContext` and a `RenderingContext`. Several other smaller changes were made to the spec and the chrome canary browser version now aligns with this version of the spec.
* Annotate several union types with the `[MarkerType]` extended attribute. This changed the way these types are implemented in the java binding by converting them into marker interfaces. The union types modified:
  - `CanvasImageSource`
  - `GPUBindingResource`
  - `GPUError`
  - `HTMLOrSVGImageElement`
  - `HTMLOrSVGScriptElement`
  - `ImageBitmapSource`
  - `ImageBufferSource`
  - `MessageEventSource`
  - `PasswordCredentialInit`
  - `ReadableStreamReader`
  - `ReadableStreamController`
  - `OffscreenRenderingContext`
  - `XRWebGLRenderingContext`
 This change also resulted in the `WindowProxy` typedef being converted into a marker interface.

### [v0.13](https://github.com/akasha/akasha/tree/v0.13) (2021-07-14) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.12...v0.13) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.12&new=0.13) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.12...v0.13)

The release includes 136 non breaking API changes.

Changes in this release:

* Add the `WebGPU` spec with version `W3C Working Draft, 12 July 2021` to the set of specifications which the API is generated from. This specification and the corresponding generated elements are marked as "Experimental" as the specification is experimental and in developer trial mode and thus not enabled by default in the major browsers.

### [v0.12](https://github.com/akasha/akasha/tree/v0.12) (2021-06-13) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.11...v0.12) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.11&new=0.12) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.11...v0.12)

The release includes 174 non breaking API changes, 8 potentially breaking API changes and 249 breaking API changes.

Changes in this release:

* Add the `WebCodecs` spec with version `W3C Working Draft, 11 June 2021` to the set of specifications which the API is generated from.
* Update the `Geolocation API` spec to the `W3C Working Draft 10 June 2021` version. This improved typing and aligned with how browsers are implementing the underlying javascript objects.
* Update the `Gamepad` spec to the `W3C Working Draft 08 April 2021` version. This added events for when gamepads are connected and disconnected. This version also supports XR mappings.
* Update the `Web Bluetooth` spec to the `Draft Community Group Report, 17 May 2021` version. This improved the typing of several attributes and exposed `manufacturerData` via the API.
* Update to the latest version of the `webgl` specifications. This primarily resulted in supporting `VideoFrame` as a `TexImageSource`.
* Upgrade to the latest version of the `Web Authentication: Level 2 Recommendation` or `webauthn` specification finalized on `8 April 2021`.
* Update several web specifications with various fixes, clarifications and API changes to more closely align with actual browser implementations. These specifications included: `whatwg_html`, `whatwg_dom`, `visual_viewport`, `screen_capture` and `cssom_view`.

### [v0.11](https://github.com/akasha/akasha/tree/v0.11) (2021-05-23) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.10...v0.11) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.10&new=0.11) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.10...v0.11)

The release includes 78 non breaking API changes, 846 potentially breaking API changes and 29 breaking API changes.

Changes in this release:

* Upgrade the `org.realityforge.react4j` artifacts to version `0.182`.
* Omit generation of closure externs for WebIDL elements that have the extended attribute `[JavaOnly]`. This is supported across all different element types but is only currently used on constants named `"NAME"` on WebGl/WebGl2 extensions that have been added to the java interfaces to improve the typing of the method `WebGL2RenderingContext.getExtension(...)`. These constant fields are no longer being incorrectly defined in closure externs. Fixes #18.
* Add the `constructor`, `hasOwnProperty`, `propertyIsEnumerable`, `isPrototypeOf`, `valueOf` and `toString` operations to the IDL defining the `Object` interface types. This increases the ability for akasha to be used in a context with a more javascript-ish architecture but is not expected to impact the more java centric usages of Akasha.
* Define `String.matchAll` operation in WebIDL.
* Add the annotation `@HasNoSideEffects` to numerous methods in the `JsArray`, `JsMap`, `JsSet`, `JsWeakMap` and `JsWeakSet` classes so that calls to these methods will be optimized out by the GWT compiler if the return values are unused. No action is required in the closure extern generator action as these types are all part of the intrinsic externs defined by closure compiler and have already been defined as `@nosideefects`.
* Add the `@HasNoSideEffects` annotation to selected operations in the akasha generated jsinterop classes. Add the equivalent annotation `@nosideeffects` to the generated closure externs. The generation was driven by the presence of the `[NoSideEffects]` extended attribute on the operation. The `[NoSideEffects]` extended attribute was added to the WebIDL via a processor that looked in the file `data/pipelines/no_side_effects.txt` to identify operations that should have this extended attribute. The list of operations was sourced from the existing closure externs. Additional heuristics were used to add `NoSideEffects` such as any named getters as well as the read operations defined by `maplike` WebIDL construct. Fixes #13.
* Correct the externs for operations that returned typed `Iterator<X>` types. These were incorrectly represented as `Array<X>` in the closure externs but were correctly represented as `JsIterator<X>` in jsinterop annotated classes.
* Generate closure externs for operations and properties synthesized when a `iterable` or `maplike` member is present on an interface type. Fixes #28.
* Rename the extended attribute `[JavaSequenceType]` to `[SequenceType]` as it is used in the context of closure externs and is not java-specific. Fixes #25.
* Modify the closure and java binding of interface types so that they implement the `Iterator<T>` / `JsIterator<T>` interfaces respectively. Fixes #15.
* Change all interface types so that they extend `Object`. This aligns how the types are implemented in WebIDL javascript binding and makes these types easier to use in a web context. Fixes #24.
* In the java binding, annotate optional operation arguments in callbacks with the `@jsinterop.annotations.JsOptional` annotation. This ensures that the types align when compiled with J2CL and closure compiler that the types align.
* Add closure externs for the `RegExp.prototype.unicode` and `RegExp.prototype.dotAll` symbols as they is missing from the base closure externs.
* Generate classes to test compatibility of jsinterop annotated java classes and closure externs. This involves generating a java class for relevant WebIDL elements that interacts with operations and attributes on the element. These "compile test" classes are the compiled by J2CL and passed to the closure compiler to ensure no warnings or errors are generated. Fixes #31.
* Fix the definition of `DataView` to remove the `length` property that does not exist.
* Correct the return type of the `Atomics.isLockFree()` operation to be a `boolean`.
* Remove the `ArrayBufferView.length` property from the hand-crafted interface as it is not common to `DataView` type that implements the interface.
* Remove the named element getters and setters declared on the typed array types as they do exist in underlying javascript types and invoking them resulted in errors.
* Mark the `begin` parameter of `SharedArrayBuffer.slice` operation as required to align with the current closure compiler externs. A PR has been submitted upstream as google/closure-compiler#3814 to correct the closure compiler externs and this local patch will be removed once the PR is accepted and released.
* Mark the `month` parameter of `Date.UTC` operation as required to align with the current closure compiler externs. A PR has been submitted upstream as google/closure-compiler#3819 to correct the closure compiler externs and this local patch will be removed once the PR is accepted and released.
* Change the return value of the `Atomics.wait` operation to the interface string type rather than the string primitive. This is to align with the current closure compiler externs. A PR has been submitted upstream as google/closure-compiler#3820 to correct the closure compiler externs and this local patch will be removed once the PR is accepted and released.
* Use a custom implementation of `RegExpResult` to ensure that it aligns with the closure compiler externs.
* Change the packaging to produce two different artifacts. The `akasha-gwt` artifact contains the GWT module as well as jsinterop annotated classes that are optimized for the GWT runtime. The `akasha-j2cl` artifact contains the closure externs as well as the jsinterop annotated classes that are optimized for the J2CL/closure-compiler environment.

### [v0.10](https://github.com/akasha/akasha/tree/v0.10) (2021-04-22) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.09...v0.10) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.09&new=0.10) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.09...v0.10)

The release includes 1 potentially breaking API change

Changes in this release:

* Fixed bug introduced into `JsObject.getOwnPropertyNames(...)` method in `v0.08` that stopped it working.
* Fixed the typing of `JsObject.getOwnPropertyDescriptors(...)`.

### [v0.09](https://github.com/akasha/akasha/tree/v0.09) (2021-04-22) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.08...v0.09) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.08&new=0.09) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.08...v0.09)

The release includes 15 breaking API changes

Changes in this release:

* Fixed bug introduced into `JsObject.create(...)` method in `v0.08` where incorrect parameters were passed to the native method.
* Rework the way the Symbol type is mapped to be compatible with closure compiler which has two separate mechanisms for representing symbols (i.e. the interface type `Symbol` and the type annotation `@type {symbol}`). This has not changed the API from a developers perspective but will change the way the GWT and closure compilers generate code for this scenario.
* Add closure extern for `Symbol.split` symbol as it is missing from the base closure externs.

### [v0.08](https://github.com/akasha/akasha/tree/v0.08) (2021-04-21) · [Full Changelog](https://github.com/spritz/spritz/compare/v0.07...v0.08) · [API Differences](https://akasha.github.io/akasha-java/api-diff/?key=akasha-java&old=0.07&new=0.08) · [Source Diff](https://github.com/akasha/akasha-java/compare/v0.07...v0.08)

The release includes 1 non breaking API change and 518 breaking API changes

Changes in this release:

* Convert `akasha.core.JsObject` from a generated class to a locally customized version that performs an `uncheckedCast(...)` to avoid type errors when compiling with base externs provided by closure compiler.
* Remove incorrect `@JsOverlay` annotations on non-inlined constants in the generated Java binding.
* Rework the way namespaces are implemented in the java binding to be compatible with the closure externs shapes. This involved eliminating the synthetic interface and the ability to access the namespace as an instance object within java and moving to static-only fields and methods in the java representation.
* Make the second parameter of the `parseInt` function on the global object required rather than optional as this is required by the builtin closure externs.
* Remove synthetic interface for the `Global` object and much of the ceremony around the way the `ExposureSet` is made available in the Java binding. Previously there was a synthetic interface that extended the exposed type (i.e. `GlobalWindow` extended `Window`) and mixed in the javascript global object methods (i.e. `isNaN(...)`, `isFloat(...)` etc). Then there was a `Global` class that exposed the constants, attributes and operations on the `GlobalWindow` as static methods and provided access to the `globalThis` instance case to the synthetic type. This resulted in GWT 2.x producing sub-optimal code and the closure compiler being confused about the typing when J2CL compiled the `Global` class when accessing the `globalThis` object. The new code structure eliminated the synthetic interface and split the `Global` class into `Global` (for javascript global object methods) and `WindowGlobal` (for global methods and properties provided in with `Window` exposure set) with static native methods declared directly on the class.

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
