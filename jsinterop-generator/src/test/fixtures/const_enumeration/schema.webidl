[Exposed=(Window,DedicatedWorker,SharedWorker), JavaSubPackage=req, JavaName=ReadyStateType2b]
const enum ReadyStateType2 {
  XMLHttpRequest2.UNSENT,
  XMLHttpRequest2.OPENED,
  XMLHttpRequest2.HEADERS_RECEIVED,
  XMLHttpRequest2.LOADING,
  XMLHttpRequest2.DONE
};

const enum ReadyStateType {
  XMLHttpRequest.UNSENT,
  XMLHttpRequest.OPENED,
  XMLHttpRequest.HEADERS_RECEIVED,
  XMLHttpRequest.LOADING,
  XMLHttpRequest.DONE
};

[Exposed=(Window,DedicatedWorker,SharedWorker)]
interface XMLHttpRequest {
  const unsigned short DONE = 4;
  const unsigned short HEADERS_RECEIVED = 2;
  const unsigned short LOADING = 3;
  const unsigned short OPENED = 1;
  const unsigned short UNSENT = 0;
  /**
   * readonly attribute is a const enum.
   */
  readonly attribute ReadyStateType readyState;
  /**
   * regular attribute is a const enum.
   */
  attribute ReadyStateType otherReadyState;
  constructor( ReadyStateType value );
  /**
   * operation return value is a const enum.
   */
  ReadyStateType getSample();
  /**
   * operation argument is an enum.
   */
  undefined setSample( ReadyStateType sample );
};

/**
 * Type and associated const enum is in a separate package.
 */
[Exposed=(Window,DedicatedWorker,SharedWorker), JavaSubPackage=req, JavaName=XMLHR2]
interface XMLHttpRequest2 {
  const unsigned short DONE = 4;
  const unsigned short HEADERS_RECEIVED = 2;
  const unsigned short LOADING = 3;
  const unsigned short OPENED = 1;
  const unsigned short UNSENT = 0;
  readonly attribute ReadyStateType2 readyState;
};
