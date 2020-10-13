const enum XMLHttpRequestReadyStateType {
  XMLHttpRequest.UNSENT,
  XMLHttpRequest.OPENED,
  XMLHttpRequest.HEADERS_RECEIVED,
  XMLHttpRequest.LOADING,
  XMLHttpRequest.DONE
};

partial interface XMLHttpRequest {
  readonly attribute XMLHttpRequestReadyStateType readyState;
};
