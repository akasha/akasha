partial interface Window {
  const GLenum COMPRESSED_RGBA_S3TC_DXT1_EXT = 0x83F1;
  const GLenum COMPRESSED_RGBA_S3TC_DXT3_EXT = 0x83F2;
  const GLenum COMPRESSED_RGBA_S3TC_DXT5_EXT = 0x83F3;
  const GLenum COMPRESSED_RGB_S3TC_DXT1_EXT = 0x83F0;
};

partial interface Window {
  [SecureContext]
  attribute EventHandler ondeviceorientation;
};

partial interface Window {
  const GLenum COMPRESSED_RGB_S3TC_DXT1_EXT = 0x83F0;
};

[Global=Window, Exposed=Window, LegacyUnenumerableNamedProperties]
interface Window : EventTarget {
  [SecureContext]
  readonly attribute ApplicationCache applicationCache;
  readonly attribute boolean closed;
};
