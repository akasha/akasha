[Exposed=(Window,DedicatedWorker,SharedWorker), JavaSubPackage=req, JavaName=ReadyStateType2b]
const enum ReadyStateType2 {
  XMLHttpRequest2.UNSENT,
  XMLHttpRequest2.OPENED,
  XMLHttpRequest2.HEADERS_RECEIVED,
  XMLHttpRequest2.LOADING,
  XMLHttpRequest2.DONE
};

const enum WebGLExtensionName {
  EXT_color_buffer_float.NAME,
  EXT_float_blend.NAME,
  KHR_parallel_shader_compile.NAME
};

const enum ReadyStateType {
  XMLHttpRequest.UNSENT,
  XMLHttpRequest.OPENED,
  XMLHttpRequest.HEADERS_RECEIVED,
  XMLHttpRequest.LOADING,
  XMLHttpRequest.DONE
};

interface EXT_color_buffer_float {
  const DOMString NAME = "EXT_color_buffer_float";
};

interface EXT_float_blend {
  const DOMString NAME = "EXT_float_blend";
};

interface KHR_parallel_shader_compile {
  const DOMString NAME = "KHR_parallel_shader_compile";
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
