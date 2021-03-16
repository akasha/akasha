typedef unsigned long long GLuint64EXT;

[Exposed=(Window,Worker), LegacyNoInterfaceObject]
interface EXT_disjoint_timer_query {
  const GLenum CURRENT_QUERY_EXT = 0x8865;
  const GLenum GPU_DISJOINT_EXT = 0x8FBB;
  const GLenum QUERY_COUNTER_BITS_EXT = 0x8864;
  const GLenum QUERY_RESULT_AVAILABLE_EXT = 0x8867;
  const GLenum QUERY_RESULT_EXT = 0x8866;
  const GLenum TIMESTAMP_EXT = 0x8E28;
  const GLenum TIME_ELAPSED_EXT = 0x88BF;
  undefined beginQueryEXT( GLenum target, WebGLTimerQueryEXT query );
  WebGLTimerQueryEXT? createQueryEXT();
  undefined deleteQueryEXT( WebGLTimerQueryEXT? query );
  undefined endQueryEXT( GLenum target );
  any getQueryEXT( GLenum target, GLenum pname );
  any getQueryObjectEXT( WebGLTimerQueryEXT query, GLenum pname );
  [WebGLHandlesContextLoss]
  boolean isQueryEXT( WebGLTimerQueryEXT? query );
  undefined queryCounterEXT( WebGLTimerQueryEXT query, GLenum target );
};

[Exposed=(Window,Worker), LegacyNoInterfaceObject]
interface WebGLTimerQueryEXT : WebGLObject {
};
