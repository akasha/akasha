[Exposed=(Window,Worker), LegacyNoInterfaceObject]
interface WEBGL_multi_draw {
  undefined multiDrawArraysInstancedWEBGL( GLenum mode, ( [AllowShared] Int32Array or sequence<GLint> ) firstsList, GLuint firstsOffset, ( [AllowShared] Int32Array or sequence<GLsizei> ) countsList, GLuint countsOffset, ( [AllowShared] Int32Array or sequence<GLsizei> ) instanceCountsList, GLuint instanceCountsOffset, GLsizei drawcount );
  undefined multiDrawArraysWEBGL( GLenum mode, ( [AllowShared] Int32Array or sequence<GLint> ) firstsList, GLuint firstsOffset, ( [AllowShared] Int32Array or sequence<GLsizei> ) countsList, GLuint countsOffset, GLsizei drawcount );
  undefined multiDrawElementsInstancedWEBGL( GLenum mode, ( [AllowShared] Int32Array or sequence<GLint> ) countsList, GLuint countsOffset, GLenum type, ( [AllowShared] Int32Array or sequence<GLsizei> ) offsetsList, GLuint offsetsOffset, ( [AllowShared] Int32Array or sequence<GLsizei> ) instanceCountsList, GLuint instanceCountsOffset, GLsizei drawcount );
  undefined multiDrawElementsWEBGL( GLenum mode, ( [AllowShared] Int32Array or sequence<GLint> ) countsList, GLuint countsOffset, GLenum type, ( [AllowShared] Int32Array or sequence<GLsizei> ) offsetsList, GLuint offsetsOffset, GLsizei drawcount );
};
