[Exposed=(Window,Worker), LegacyNoInterfaceObject]
interface EXT_disjoint_timer_query_webgl2 {
  const GLenum GPU_DISJOINT_EXT = 0x8FBB;
  const GLenum QUERY_COUNTER_BITS_EXT = 0x8864;
  const GLenum TIMESTAMP_EXT = 0x8E28;
  const GLenum TIME_ELAPSED_EXT = 0x88BF;
  undefined queryCounterEXT( WebGLQuery query, GLenum target );
};
