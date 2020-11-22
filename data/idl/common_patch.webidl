const enum DOMExceptionCode {
  DOMException.INDEX_SIZE_ERR,
  DOMException.DOMSTRING_SIZE_ERR,
  DOMException.HIERARCHY_REQUEST_ERR,
  DOMException.WRONG_DOCUMENT_ERR,
  DOMException.INVALID_CHARACTER_ERR,
  DOMException.NO_DATA_ALLOWED_ERR,
  DOMException.NO_MODIFICATION_ALLOWED_ERR,
  DOMException.NOT_FOUND_ERR,
  DOMException.NOT_SUPPORTED_ERR,
  DOMException.INUSE_ATTRIBUTE_ERR,
  DOMException.INVALID_STATE_ERR,
  DOMException.SYNTAX_ERR,
  DOMException.INVALID_MODIFICATION_ERR,
  DOMException.NAMESPACE_ERR,
  DOMException.INVALID_ACCESS_ERR,
  DOMException.VALIDATION_ERR,
  DOMException.TYPE_MISMATCH_ERR,
  DOMException.SECURITY_ERR,
  DOMException.NETWORK_ERR,
  DOMException.ABORT_ERR,
  DOMException.URL_MISMATCH_ERR,
  DOMException.QUOTA_EXCEEDED_ERR,
  DOMException.TIMEOUT_ERR,
  DOMException.INVALID_NODE_TYPE_ERR,
  DOMException.DATA_CLONE_ERR
};

partial interface DOMException {
  readonly attribute DOMException code;
};

[MarkerType]
typedef ( TypedArray or DataView ) ArrayBufferView;
