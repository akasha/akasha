[Exposed=Window,
 Constructor]
interface DataTransfer {
  attribute DOMString dropEffect;
  attribute DOMString effectAllowed;

  [SameObject] readonly attribute DataTransferItemList items;

  void setDragImage(Element image, long x, long y);

  /* old interface */
  readonly attribute FrozenArray<DOMString> types;
  DOMString getData(DOMString format);
  void setData(DOMString format, DOMString data);
  void clearData(optional DOMString format);
  [SameObject] readonly attribute FileList files;
};

[Exposed=Window]
interface DataTransferItemList {
  readonly attribute unsigned long length;
  getter DataTransferItem (unsigned long index);
  DataTransferItem? add(DOMString data, DOMString type);
  DataTransferItem? add(File data);
  void remove(unsigned long index);
  void clear();
};

[Exposed=Window]
interface DataTransferItem {
  readonly attribute DOMString kind;
  readonly attribute DOMString type;
  void getAsString(FunctionStringCallback? _callback);
  File? getAsFile();
};

callback FunctionStringCallback = void (DOMString data);

[Exposed=Window,
 Constructor(DOMString type, optional DragEventInit eventInitDict = {})]
interface DragEvent : MouseEvent {
  readonly attribute DataTransfer? dataTransfer;
};

dictionary DragEventInit : MouseEventInit {
  DataTransfer? dataTransfer = null;
};