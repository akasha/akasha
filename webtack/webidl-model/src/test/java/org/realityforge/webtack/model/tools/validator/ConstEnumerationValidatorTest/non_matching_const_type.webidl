const enum XMLHttpRequestReadyStateType {
  XMLHttpRequest.OPENED,
  XMLHttpRequest.HEADERS_RECEIVED,
  XMLHttpRequest.LOADING,
  XMLHttpRequest.UNSENT,
  XMLHttpRequest.DONE
};

interface XMLHttpRequest {
  const unsigned short DONE = 4;
  const unsigned short HEADERS_RECEIVED = 2;
  const unsigned short LOADING = 3;
  const unsigned short OPENED = 1;
  const long long UNSENT = 0;
  readonly attribute unsigned short readyState;
};
