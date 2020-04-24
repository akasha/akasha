callback FunctionStringCallback = void ( DOMString data );

dictionary DragEventInit : MouseEventInit {
  DataTransfer? dataTransfer = null;
};

[Exposed=Window, Constructor]
interface DataTransfer {
  [SameObject]
  readonly attribute FileList files;
  [SameObject]
  readonly attribute DataTransferItemList items;
  readonly attribute FrozenArray<DOMString> types;
  attribute DOMString dropEffect;
  attribute DOMString effectAllowed;
  void clearData( optional DOMString format );
  DOMString getData( DOMString format );
  void setData( DOMString format, DOMString data );
  void setDragImage( Element image, long x, long y );
};

[Exposed=Window]
interface DataTransferItem {
  readonly attribute DOMString kind;
  readonly attribute DOMString type;
  File? getAsFile();
  void getAsString( FunctionStringCallback? _callback );
};

[Exposed=Window]
interface DataTransferItemList {
  readonly attribute unsigned long length;
  DataTransferItem? add( DOMString data, DOMString type );
  DataTransferItem? add( File data );
  void clear();
  void remove( unsigned long index );
  getter DataTransferItem ( unsigned long index );
};

[Exposed=Window, Constructor( DOMString type, optional DragEventInit eventInitDict = {} )]
interface DragEvent : MouseEvent {
  readonly attribute DataTransfer? dataTransfer;
};
