const enum WebGLContextError {
  WebGL2RenderingContext.NO_ERROR,
  WebGL2RenderingContext.INVALID_ENUM,
  WebGL2RenderingContext.INVALID_VALUE,
  WebGL2RenderingContext.INVALID_OPERATION,
  WebGL2RenderingContext.INVALID_FRAMEBUFFER_OPERATION
};

typedef unsigned long GLenum;

interface WebGL2RenderingContext {
  const GLenum INVALID_ENUM = 0x0500;
  const GLenum INVALID_FRAMEBUFFER_OPERATION = 0x0506;
  const GLenum INVALID_OPERATION = 0x0502;
  const GLenum INVALID_VALUE = 0x0501;
  const GLenum NO_ERROR = 0;
  GLenum getError();
  GLenum other();
};
