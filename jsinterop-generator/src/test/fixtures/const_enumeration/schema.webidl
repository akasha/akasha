[Exposed=(Window,DedicatedWorker,SharedWorker), ConstEnumeration=ReadyStateType(UNSENT,OPENED,HEADERS_RECEIVED,LOADING,DONE)]
interface XMLHttpRequest {
  const unsigned short DONE = 4;
  const unsigned short HEADERS_RECEIVED = 2;
  const unsigned short LOADING = 3;
  const unsigned short OPENED = 1;
  const unsigned short UNSENT = 0;
  readonly attribute unsigned short readyState;
};

[Exposed=(Window,DedicatedWorker,SharedWorker), ConstEnumeration=ReadyStateType2(UNSENT,OPENED,HEADERS_RECEIVED,LOADING,DONE), JavaSubPackage=req, JavaName=XMLHR2]
interface XMLHttpRequest2 {
  const unsigned short DONE = 4;
  const unsigned short HEADERS_RECEIVED = 2;
  const unsigned short LOADING = 3;
  const unsigned short OPENED = 1;
  const unsigned short UNSENT = 0;
  readonly attribute unsigned short readyState;
};
