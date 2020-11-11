typedef ( Int8Array or Int16Array or Int32Array or Uint8Array or Uint16Array or Uint32Array or Uint8ClampedArray or Float32Array or Float64Array or DataView ) ArrayBufferView;

typedef ( DOMString or Blob ) ClipboardItemDataType;

typedef ( double? or sequence<double?> ) IndexedKeyframeOffsetType;

[Exposed=(Window,Worker), Serializable]
interface Blob {
  readonly attribute DOMString type;
};

interface DataView {
};
