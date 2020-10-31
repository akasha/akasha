const enum ShaderType {
  WebGL2RenderingContext.VERTEX_SHADER,
  WebGL2RenderingContext.FRAGMENT_SHADER
};

const enum UsageType {
  WebGL2RenderingContext.STATIC_DRAW,
  WebGL2RenderingContext.DYNAMIC_DRAW,
  WebGL2RenderingContext.STREAM_DRAW,
  WebGL2RenderingContext.STATIC_READ,
  WebGL2RenderingContext.DYNAMIC_READ,
  WebGL2RenderingContext.STREAM_READ,
  WebGL2RenderingContext.STATIC_COPY,
  WebGL2RenderingContext.DYNAMIC_COPY,
  WebGL2RenderingContext.STREAM_COPY
};

const enum BufferTargetType {
  WebGL2RenderingContext.ARRAY_BUFFER,
  WebGL2RenderingContext.ELEMENT_ARRAY_BUFFER,
  WebGL2RenderingContext.COPY_READ_BUFFER,
  WebGL2RenderingContext.COPY_WRITE_BUFFER,
  WebGL2RenderingContext.TRANSFORM_FEEDBACK_BUFFER,
  WebGL2RenderingContext.UNIFORM_BUFFER,
  WebGL2RenderingContext.PIXEL_PACK_BUFFER,
  WebGL2RenderingContext.PIXEL_UNPACK_BUFFER
};

const enum DataType {
  WebGL2RenderingContext.BYTE,
  WebGL2RenderingContext.UNSIGNED_BYTE,
  WebGL2RenderingContext.SHORT,
  WebGL2RenderingContext.UNSIGNED_SHORT,
  WebGL2RenderingContext.FLOAT,
  WebGL2RenderingContext.HALF_FLOAT
};

const enum FramebufferTargetType {
  WebGL2RenderingContext.FRAMEBUFFER,
  WebGL2RenderingContext.DRAW_FRAMEBUFFER,
  WebGL2RenderingContext.READ_FRAMEBUFFER
};

const enum RenderbufferTargetType {
  WebGL2RenderingContext.RENDERBUFFER
};

const enum Texture2DSurfaceTargetType {
  WebGL2RenderingContext.TEXTURE_2D,
  WebGL2RenderingContext.TEXTURE_CUBE_MAP_POSITIVE_X,
  WebGL2RenderingContext.TEXTURE_CUBE_MAP_NEGATIVE_X,
  WebGL2RenderingContext.TEXTURE_CUBE_MAP_POSITIVE_Y,
  WebGL2RenderingContext.TEXTURE_CUBE_MAP_NEGATIVE_Y,
  WebGL2RenderingContext.TEXTURE_CUBE_MAP_POSITIVE_Z,
  WebGL2RenderingContext.TEXTURE_CUBE_MAP_NEGATIVE_Z
};

const enum Texture2DTargetType {
  WebGL2RenderingContext.TEXTURE_2D,
  WebGL2RenderingContext.TEXTURE_CUBE_MAP
};

const enum Texture3DTargetType {
  WebGL2RenderingContext.TEXTURE_3D,
  WebGL2RenderingContext.TEXTURE_2D_ARRAY
};

const enum TextureTargetType {
  WebGL2RenderingContext.TEXTURE_2D,
  WebGL2RenderingContext.TEXTURE_CUBE_MAP,
  WebGL2RenderingContext.TEXTURE_3D,
  WebGL2RenderingContext.TEXTURE_2D_ARRAY
};

const enum TextureParameter {
  WebGL2RenderingContext.TEXTURE_MAG_FILTER,
  WebGL2RenderingContext.TEXTURE_MIN_FILTER,
  WebGL2RenderingContext.TEXTURE_WRAP_S,
  WebGL2RenderingContext.TEXTURE_WRAP_T,
  EXT_texture_filter_anisotropic.TEXTURE_MAX_ANISOTROPY_EXT,
  WebGL2RenderingContext.TEXTURE_BASE_LEVEL,
  WebGL2RenderingContext.TEXTURE_COMPARE_FUNC,
  WebGL2RenderingContext.TEXTURE_COMPARE_MODE,
  WebGL2RenderingContext.TEXTURE_MAX_LEVEL,
  WebGL2RenderingContext.TEXTURE_MAX_LOD,
  WebGL2RenderingContext.TEXTURE_MIN_LOD,
  WebGL2RenderingContext.TEXTURE_WRAP_R
};

const enum ReadableTextureParameter {
  WebGL2RenderingContext.TEXTURE_MAG_FILTER,
  WebGL2RenderingContext.TEXTURE_MIN_FILTER,
  WebGL2RenderingContext.TEXTURE_WRAP_S,
  WebGL2RenderingContext.TEXTURE_WRAP_T,
  EXT_texture_filter_anisotropic.TEXTURE_MAX_ANISOTROPY_EXT,
  WebGL2RenderingContext.TEXTURE_BASE_LEVEL,
  WebGL2RenderingContext.TEXTURE_COMPARE_FUNC,
  WebGL2RenderingContext.TEXTURE_COMPARE_MODE,
  WebGL2RenderingContext.TEXTURE_IMMUTABLE_FORMAT,
  WebGL2RenderingContext.TEXTURE_IMMUTABLE_LEVELS,
  WebGL2RenderingContext.TEXTURE_MAX_LEVEL,
  WebGL2RenderingContext.TEXTURE_MAX_LOD,
  WebGL2RenderingContext.TEXTURE_MIN_LOD,
  WebGL2RenderingContext.TEXTURE_WRAP_R
};

const enum TexelDataType {
  WebGL2RenderingContext.UNSIGNED_BYTE,
  WebGL2RenderingContext.UNSIGNED_SHORT,
  WebGL2RenderingContext.UNSIGNED_SHORT_5_6_5,
  WebGL2RenderingContext.UNSIGNED_SHORT_4_4_4_4,
  WebGL2RenderingContext.UNSIGNED_SHORT_5_5_5_1,
  WebGL2RenderingContext.BYTE,
  WebGL2RenderingContext.SHORT,
  WebGL2RenderingContext.UNSIGNED_INT,
  WEBGL_depth_texture.UNSIGNED_INT_24_8_WEBGL,
  WebGL2RenderingContext.INT,
  WebGL2RenderingContext.HALF_FLOAT,
  WebGL2RenderingContext.FLOAT,
  WebGL2RenderingContext.UNSIGNED_INT_2_10_10_10_REV,
  WebGL2RenderingContext.UNSIGNED_INT_10F_11F_11F_REV,
  WebGL2RenderingContext.UNSIGNED_INT_5_9_9_9_REV,
  WebGL2RenderingContext.UNSIGNED_INT_24_8,
  WebGL2RenderingContext.FLOAT_32_UNSIGNED_INT_24_8_REV
};

const enum DrawPrimitiveType {
  WebGL2RenderingContext.POINTS,
  WebGL2RenderingContext.LINE_STRIP,
  WebGL2RenderingContext.LINE_LOOP,
  WebGL2RenderingContext.LINES,
  WebGL2RenderingContext.TRIANGLE_STRIP,
  WebGL2RenderingContext.TRIANGLE_FAN,
  WebGL2RenderingContext.TRIANGLES
};

const enum PixelStorageParameter {
  WebGL2RenderingContext.PACK_ALIGNMENT,
  WebGL2RenderingContext.UNPACK_ALIGNMENT,
  WebGL2RenderingContext.UNPACK_FLIP_Y_WEBGL,
  WebGL2RenderingContext.UNPACK_PREMULTIPLY_ALPHA_WEBGL,
  WebGL2RenderingContext.UNPACK_COLORSPACE_CONVERSION_WEBGL,
  WebGL2RenderingContext.PACK_ROW_LENGTH,
  WebGL2RenderingContext.PACK_SKIP_PIXELS,
  WebGL2RenderingContext.PACK_SKIP_ROWS,
  WebGL2RenderingContext.UNPACK_ROW_LENGTH,
  WebGL2RenderingContext.UNPACK_IMAGE_HEIGHT,
  WebGL2RenderingContext.UNPACK_SKIP_PIXELS,
  WebGL2RenderingContext.UNPACK_SKIP_ROWS,
  WebGL2RenderingContext.UNPACK_SKIP_IMAGES
};

const enum DrawElementDataType {
  WebGL2RenderingContext.UNSIGNED_BYTE,
  WebGL2RenderingContext.UNSIGNED_SHORT,
  WebGL2RenderingContext.UNSIGNED_INT
};
