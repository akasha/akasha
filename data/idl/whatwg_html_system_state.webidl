interface mixin NavigatorContentUtils {
  [SecureContext]
  void registerProtocolHandler( DOMString scheme, USVString url );
  [SecureContext]
  void unregisterProtocolHandler( DOMString scheme, USVString url );
};

interface mixin NavigatorCookies {
  readonly attribute boolean cookieEnabled;
};

interface mixin NavigatorID {
  readonly attribute DOMString appCodeName;
  readonly attribute DOMString appName;
  readonly attribute DOMString appVersion;
  readonly attribute DOMString platform;
  readonly attribute DOMString product;
  [Exposed=Window]
  readonly attribute DOMString productSub;
  readonly attribute DOMString userAgent;
  [Exposed=Window]
  readonly attribute DOMString vendor;
  [Exposed=Window]
  readonly attribute DOMString vendorSub;
};

interface mixin NavigatorLanguage {
  readonly attribute DOMString language;
  readonly attribute FrozenArray<DOMString> languages;
};

interface mixin NavigatorPlugins {
  [SameObject]
  readonly attribute MimeTypeArray mimeTypes;
  [SameObject]
  readonly attribute PluginArray plugins;
  boolean javaEnabled();
};

partial interface mixin NavigatorID {
  [Exposed=Window]
  readonly attribute DOMString oscpu;
  [Exposed=Window]
  boolean taintEnabled();
};

[Exposed=Window]
interface MimeType {
  readonly attribute DOMString description;
  readonly attribute Plugin enabledPlugin;
  readonly attribute DOMString suffixes;
  readonly attribute DOMString type;
};

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface MimeTypeArray {
  readonly attribute unsigned long length;
  getter MimeType? item( unsigned long index );
  getter MimeType? namedItem( DOMString name );
};

[Exposed=Window]
interface Navigator {
};

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface Plugin {
  readonly attribute DOMString description;
  readonly attribute DOMString filename;
  readonly attribute unsigned long length;
  readonly attribute DOMString name;
  getter MimeType? item( unsigned long index );
  getter MimeType? namedItem( DOMString name );
};

[Exposed=Window, LegacyUnenumerableNamedProperties]
interface PluginArray {
  readonly attribute unsigned long length;
  void refresh( optional boolean reload = false );
  getter Plugin? item( unsigned long index );
  getter Plugin? namedItem( DOMString name );
};

Navigator includes NavigatorConcurrentHardware;

Navigator includes NavigatorContentUtils;

Navigator includes NavigatorCookies;

Navigator includes NavigatorID;

Navigator includes NavigatorLanguage;

Navigator includes NavigatorOnLine;

Navigator includes NavigatorPlugins;
