[LegacyNoInterfaceObject]
interface ANGLE_instanced_arrays {
  const GLenum VERTEX_ATTRIB_ARRAY_DIVISOR_ANGLE = 0x88FE;
  void drawArraysInstancedANGLE( GLenum mode, GLint first, GLsizei count, GLsizei primcount );
  void drawElementsInstancedANGLE( GLenum mode, GLsizei count, GLenum type, GLintptr offset, GLsizei primcount );
  void vertexAttribDivisorANGLE( GLuint index, GLuint divisor );
};
