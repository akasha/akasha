const enum ActiveInfoDataType {
  WebGL2RenderingContext.FLOAT,
  WebGL2RenderingContext.FLOAT_VEC2,
  WebGL2RenderingContext.FLOAT_VEC3,
  WebGL2RenderingContext.FLOAT_VEC4,
  WebGL2RenderingContext.UNSIGNED_INT_SAMPLER_2D_ARRAY
};

typedef unsigned long GLenum;

typedef unsigned long GLint;

[Exposed=(Window,Worker)]
interface WebGLActiveInfo {
  readonly attribute DOMString name;
  readonly attribute GLint size;
  readonly attribute ActiveInfoDataType type;
};
