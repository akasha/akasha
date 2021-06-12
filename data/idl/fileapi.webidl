enum EndingType {
  "native",
  "transparent"
};

typedef ( BufferSource or Blob or USVString ) BlobPart;

dictionary BlobPropertyBag {
  EndingType endings = "transparent";
  DOMString type = "";
};

dictionary FilePropertyBag : BlobPropertyBag {
  long long lastModified;
};

[Exposed=(Window,Worker), Serializable]
interface Blob {
  readonly attribute unsigned long long size;
  readonly attribute DOMString type;
  constructor( optional sequence<BlobPart> blobParts, optional BlobPropertyBag options = {} );
  [NewObject]
  Promise<ArrayBuffer> arrayBuffer();
  Blob slice( optional [Clamp] long long start, optional [Clamp] long long end, optional DOMString contentType );
  [NewObject]
  ReadableStream stream();
  [NewObject]
  Promise<USVString> text();
};

[Exposed=(Window,Worker), Serializable]
interface File : Blob {
  readonly attribute long long lastModified;
  readonly attribute DOMString name;
  constructor( sequence<BlobPart> fileBits, USVString fileName, optional FilePropertyBag options = {} );
};

[Exposed=(Window,Worker), Serializable]
interface FileList {
  readonly attribute unsigned long length;
  getter File? item( unsigned long index );
};

[Exposed=(Window,Worker)]
interface FileReader : EventTarget {
  const unsigned short DONE = 2;
  const unsigned short EMPTY = 0;
  const unsigned short LOADING = 1;
  readonly attribute DOMException? error;
  readonly attribute unsigned short readyState;
  readonly attribute ( DOMString or ArrayBuffer )? result;
  attribute EventHandler onabort;
  attribute EventHandler onerror;
  attribute EventHandler onload;
  attribute EventHandler onloadend;
  attribute EventHandler onloadstart;
  attribute EventHandler onprogress;
  constructor();
  undefined abort();
  undefined readAsArrayBuffer( Blob blob );
  undefined readAsBinaryString( Blob blob );
  undefined readAsDataURL( Blob blob );
  undefined readAsText( Blob blob, optional DOMString encoding );
};

[Exposed=(DedicatedWorker,SharedWorker)]
interface FileReaderSync {
  constructor();
  ArrayBuffer readAsArrayBuffer( Blob blob );
  DOMString readAsBinaryString( Blob blob );
  DOMString readAsDataURL( Blob blob );
  DOMString readAsText( Blob blob, optional DOMString encoding );
};

[Exposed=(Window,DedicatedWorker,SharedWorker)]
partial interface URL {
  static DOMString createObjectURL( ( Blob or MediaSource ) obj );
  static undefined revokeObjectURL( DOMString url );
};
