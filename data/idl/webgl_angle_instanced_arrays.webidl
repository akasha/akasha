[Exposed=(Window,Worker), LegacyNoInterfaceObject]
interface ANGLE_instanced_arrays {
  const GLenum VERTEX_ATTRIB_ARRAY_DIVISOR_ANGLE = 0x88FE;
  undefined drawArraysInstancedANGLE( GLenum mode, GLint first, GLsizei count, GLsizei primcount );
  undefined drawElementsInstancedANGLE( GLenum mode, GLsizei count, GLenum type, GLintptr offset, GLsizei primcount );
  undefined vertexAttribDivisorANGLE( GLuint index, GLuint divisor );
};
