enum txMode {
  "not-allowed",
  "requires",
  "requires_new"
};

typedef Promise<ClipboardItemDataType> ClipboardItemData;

typedef ( DOMString or Blob ) ClipboardItemDataType;

callback ClipboardItemDelayedCallback = ClipboardItemData ();

[Serializable]
interface Blob {
  readonly attribute DOMString type;
};

interface SomeStore {
  /**
   * Anonymous Union contains a lower cased element and will be generated.
   */
  readonly attribute ( long or txMode ) transactionMode;
};
