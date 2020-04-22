enum PresentationStyle {
  "attachment",
  "inline",
  "unspecified"
};

typedef sequence<ClipboardItem> ClipboardItems;

typedef Promise<ClipboardItemDataType> ClipboardItemData;

typedef ( DOMString or Blob ) ClipboardItemDataType;

callback ClipboardItemDelayedCallback = ClipboardItemData ();

dictionary ClipboardEventInit : EventInit {
  DataTransfer? clipboardData = null;
};

dictionary ClipboardItemOptions {
  PresentationStyle presentationStyle = "unspecified";
};

dictionary ClipboardPermissionDescriptor : PermissionDescriptor {
  boolean allowWithoutGesture = false;
};

[Constructor( record<DOMString, ClipboardItemData> items, optional ClipboardItemOptions options ), Exposed=Window]
interface ClipboardItem {
  readonly attribute boolean delayed;
  readonly attribute long long lastModified;
  readonly attribute PresentationStyle presentationStyle;
  readonly attribute FrozenArray<DOMString> types;
  static ClipboardItem createDelayed( record<DOMString, ClipboardItemDelayedCallback> items, optional ClipboardItemOptions options );
  Promise<Blob> getType( DOMString type );
};

[Constructor( DOMString type, optional ClipboardEventInit eventInitDict ), Exposed=Window]
interface ClipboardEvent : Event {
  readonly attribute DataTransfer? clipboardData;
};

[SecureContext, Exposed=Window]
interface Clipboard : EventTarget {
  Promise<ClipboardItems> read();
  Promise<DOMString> readText();
  Promise<void> write( ClipboardItems data );
  Promise<void> writeText( DOMString data );
};

partial interface Navigator {
  [SecureContext, SameObject]
  readonly attribute Clipboard clipboard;
};
