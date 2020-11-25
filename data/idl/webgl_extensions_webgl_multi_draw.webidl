[NoInterfaceObject]
interface WEBGL_multi_draw {
  undefined multiDrawArraysInstancedWEBGL( GLenum mode, ( Int32Array or sequence<GLint> ) firstsList, GLuint firstsOffset, ( Int32Array or sequence<GLsizei> ) countsList, GLuint countsOffset, ( Int32Array or sequence<GLsizei> ) instanceCountsList, GLuint instanceCountsOffset, GLsizei drawcount );
  undefined multiDrawArraysWEBGL( GLenum mode, ( Int32Array or sequence<GLint> ) firstsList, GLuint firstsOffset, ( Int32Array or sequence<GLsizei> ) countsList, GLuint countsOffset, GLsizei drawcount );
  undefined multiDrawElementsInstancedWEBGL( GLenum mode, ( Int32Array or sequence<GLint> ) countsList, GLuint countsOffset, GLenum type, ( Int32Array or sequence<GLsizei> ) offsetsList, GLuint offsetsOffset, ( Int32Array or sequence<GLsizei> ) instanceCountsList, GLuint instanceCountsOffset, GLsizei drawcount );
  undefined multiDrawElementsWEBGL( GLenum mode, ( Int32Array or sequence<GLint> ) countsList, GLuint countsOffset, GLenum type, ( Int32Array or sequence<GLsizei> ) offsetsList, GLuint offsetsOffset, GLsizei drawcount );
};
