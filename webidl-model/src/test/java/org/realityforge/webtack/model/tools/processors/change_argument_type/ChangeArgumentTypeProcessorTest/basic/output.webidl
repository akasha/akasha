const enum ShaderType {
  WebGL2RenderingContext.VERTEX_SHADER,
  WebGL2RenderingContext.FRAGMENT_SHADER
};

typedef unsigned long GLenum;

interface WebGL2RenderingContext {
  const GLenum FRAGMENT_SHADER = 0x8B30;
  const GLenum VERTEX_SHADER = 0x8B31;
  WebGLShader? createShader( ShaderType type );
};
