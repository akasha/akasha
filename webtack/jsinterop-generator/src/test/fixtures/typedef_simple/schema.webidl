typedef unsigned long GLbitfield;

typedef unsigned long GLenum;

typedef long GLint;

typedef ( [AllowShared] Int32Array or sequence<GLint> ) Int32List;

interface Int32Array {
};

interface WebGLRenderingContext {
  const GLenum ACTIVE_ATTRIBUTES = 0x8B89;
  GLenum checkFramebufferStatus( GLenum target );
  undefined clear( GLbitfield mask );
};
