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

callback VoidFunction = undefined ();

[Exposed=(Window,Worker), Serializable]
interface DOMException : Error {
  const unsigned short ABORT_ERR = 20;
  const unsigned short DATA_CLONE_ERR = 25;
  const unsigned short DOMSTRING_SIZE_ERR = 2;
  const unsigned short HIERARCHY_REQUEST_ERR = 3;
  const unsigned short INDEX_SIZE_ERR = 1;
  const unsigned short INUSE_ATTRIBUTE_ERR = 10;
  const unsigned short INVALID_ACCESS_ERR = 15;
  const unsigned short INVALID_CHARACTER_ERR = 5;
  const unsigned short INVALID_MODIFICATION_ERR = 13;
  const unsigned short INVALID_NODE_TYPE_ERR = 24;
  const unsigned short INVALID_STATE_ERR = 11;
  const unsigned short NAMESPACE_ERR = 14;
  const unsigned short NETWORK_ERR = 19;
  const unsigned short NOT_FOUND_ERR = 8;
  const unsigned short NOT_SUPPORTED_ERR = 9;
  const unsigned short NO_DATA_ALLOWED_ERR = 6;
  const unsigned short NO_MODIFICATION_ALLOWED_ERR = 7;
  const unsigned short QUOTA_EXCEEDED_ERR = 22;
  const unsigned short SECURITY_ERR = 18;
  const unsigned short SYNTAX_ERR = 12;
  const unsigned short TIMEOUT_ERR = 23;
  const unsigned short TYPE_MISMATCH_ERR = 17;
  const unsigned short URL_MISMATCH_ERR = 21;
  const unsigned short VALIDATION_ERR = 16;
  const unsigned short WRONG_DOCUMENT_ERR = 4;
  readonly attribute DOMException code;
  constructor( optional DOMString message = "", optional DOMString name = "Error" );
};
