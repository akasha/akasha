const enum XMLHttpRequestReadyStateType {
  XMLHttpRequest.UNSENT,
  XMLHttpRequest.OPENED,
  XMLHttpRequest.HEADERS_RECEIVED,
  XMLHttpRequest.LOADING,
  XMLHttpRequest.DONE
};

interface XMLHttpRequest {
  const unsigned short DONE = 4;
  const unsigned short HEADERS_RECEIVED = 2;
  const unsigned short LOADING = 3;
  const unsigned short OPENED = 1;
  const unsigned short UNSENT = 0;
  readonly attribute unsigned short readyState;
};

const enum WebGLExtensionName {
  EXT_color_buffer_float.NAME,
  EXT_float_blend.NAME,
  KHR_parallel_shader_compile.NAME
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
