interface mixin NavigatorOnLine {
  readonly attribute boolean onLine;
};

[SecureContext, Exposed=Window]
interface ApplicationCache : EventTarget {
  const unsigned short CHECKING = 2;
  const unsigned short DOWNLOADING = 3;
  const unsigned short IDLE = 1;
  const unsigned short OBSOLETE = 5;
  const unsigned short UNCACHED = 0;
  const unsigned short UPDATEREADY = 4;
  readonly attribute unsigned short status;
  attribute EventHandler oncached;
  attribute EventHandler onchecking;
  attribute EventHandler ondownloading;
  attribute EventHandler onerror;
  attribute EventHandler onnoupdate;
  attribute EventHandler onobsolete;
  attribute EventHandler onprogress;
  attribute EventHandler onupdateready;
  void abort();
  void swapCache();
  void update();
};
