[SecureContext,
 Exposed=Window]
interface ApplicationCache : EventTarget {

  // update status
  const unsigned short UNCACHED = 0;
  const unsigned short IDLE = 1;
  const unsigned short CHECKING = 2;
  const unsigned short DOWNLOADING = 3;
  const unsigned short UPDATEREADY = 4;
  const unsigned short OBSOLETE = 5;
  readonly attribute unsigned short status;

  // updates
  void update();
  void abort();
  void swapCache();

  // events
  attribute EventHandler onchecking;
  attribute EventHandler onerror;
  attribute EventHandler onnoupdate;
  attribute EventHandler ondownloading;
  attribute EventHandler onprogress;
  attribute EventHandler onupdateready;
  attribute EventHandler oncached;
  attribute EventHandler onobsolete;
};

interface mixin NavigatorOnLine {
  readonly attribute boolean onLine;
};