const enum XMLHttpRequestReadyState {
  XMLHttpRequest.UNSENT,
  XMLHttpRequest.OPENED,
  XMLHttpRequest.HEADERS_RECEIVED,
  XMLHttpRequest.LOADING,
  XMLHttpRequest.DONE
};

partial interface XMLHttpRequest {
  readonly attribute XMLHttpRequestReadyState readyState;
};
