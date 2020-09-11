enum txMode {
  "requires",
  "requires_new",
  "not-allowed"
};

typedef Promise<ClipboardItemDataType> ClipboardItemData;

typedef ( DOMString or Blob ) ClipboardItemDataType;

callback ClipboardItemDelayedCallback = ClipboardItemData ();

[Exposed=(Window,Worker), Serializable]
interface Blob {
  readonly attribute DOMString type;
};

interface SomeStore {
  /**
   * Anonymous Union contains a lower cased element and will be generated.
   */
  readonly attribute ( long or txMode ) transactionMode;
};
