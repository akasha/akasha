typedef Promise<ClipboardItemDataType> ClipboardItemData;

typedef ( DOMString or Blob ) ClipboardItemDataType;

callback ClipboardItemDelayedCallback = ClipboardItemData ();

[Exposed=(Window,Worker), Serializable]
interface Blob {
  readonly attribute DOMString type;
};
