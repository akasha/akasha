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

const enum FramebufferAttachment {
  WebGL2RenderingContext.COLOR_ATTACHMENT0,
  WebGL2RenderingContext.DEPTH_ATTACHMENT,
  WebGL2RenderingContext.STENCIL_ATTACHMENT,
  WebGL2RenderingContext.DEPTH_STENCIL_ATTACHMENT,
  WebGL2RenderingContext.COLOR_ATTACHMENT1,
  WebGL2RenderingContext.COLOR_ATTACHMENT2,
  WebGL2RenderingContext.COLOR_ATTACHMENT3,
  WebGL2RenderingContext.COLOR_ATTACHMENT4,
  WebGL2RenderingContext.COLOR_ATTACHMENT5,
  WebGL2RenderingContext.COLOR_ATTACHMENT6,
  WebGL2RenderingContext.COLOR_ATTACHMENT7,
  WebGL2RenderingContext.COLOR_ATTACHMENT8,
  WebGL2RenderingContext.COLOR_ATTACHMENT9,
  WebGL2RenderingContext.COLOR_ATTACHMENT10,
  WebGL2RenderingContext.COLOR_ATTACHMENT11,
  WebGL2RenderingContext.COLOR_ATTACHMENT12,
  WebGL2RenderingContext.COLOR_ATTACHMENT13,
  WebGL2RenderingContext.COLOR_ATTACHMENT14,
  WebGL2RenderingContext.COLOR_ATTACHMENT15,
  WEBGL_draw_buffers.COLOR_ATTACHMENT0_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT1_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT2_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT3_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT4_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT5_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT6_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT7_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT8_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT9_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT10_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT11_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT12_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT13_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT14_WEBGL,
  WEBGL_draw_buffers.COLOR_ATTACHMENT15_WEBGL
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
  OES_texture_half_float.HALF_FLOAT_OES,
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

const enum TextureInternalFormat {

  // Unsized Internal Format
  WebGL2RenderingContext.RGB,
  WebGL2RenderingContext.RGBA,
  WebGL2RenderingContext.LUMINANCE_ALPHA,
  WebGL2RenderingContext.LUMINANCE,
  WebGL2RenderingContext.ALPHA,

  // Sized Internal Format
  WebGL2RenderingContext.R8,
  WebGL2RenderingContext.R8_SNORM,
  WebGL2RenderingContext.R16F,
  WebGL2RenderingContext.R32F,
  WebGL2RenderingContext.R8UI,
  WebGL2RenderingContext.R8I,
  WebGL2RenderingContext.R16UI,
  WebGL2RenderingContext.R16I,
  WebGL2RenderingContext.R32UI,
  WebGL2RenderingContext.R32I,
  WebGL2RenderingContext.RG8,
  WebGL2RenderingContext.RG8_SNORM,
  WebGL2RenderingContext.RG16F,
  WebGL2RenderingContext.RG32F,
  WebGL2RenderingContext.RG8UI,
  WebGL2RenderingContext.RG8I,
  WebGL2RenderingContext.RG16UI,
  WebGL2RenderingContext.RG16I,
  WebGL2RenderingContext.RG32UI,
  WebGL2RenderingContext.RG32I,
  WebGL2RenderingContext.RGB8,
  WebGL2RenderingContext.SRGB8,
  WebGL2RenderingContext.RGB565,
  WebGL2RenderingContext.RGB8_SNORM,
  WebGL2RenderingContext.R11F_G11F_B10F,
  WebGL2RenderingContext.RGB9_E5,
  WebGL2RenderingContext.RGB16F,
  WebGL2RenderingContext.RGB32F,
  WebGL2RenderingContext.RGB8UI,
  WebGL2RenderingContext.RGB8I,
  WebGL2RenderingContext.RGB16UI,
  WebGL2RenderingContext.RGB16I,
  WebGL2RenderingContext.RGB32UI,
  WebGL2RenderingContext.RGB32I,
  WebGL2RenderingContext.RGBA8,
  WebGL2RenderingContext.SRGB8_ALPHA8,
  WebGL2RenderingContext.RGBA8_SNORM,
  WebGL2RenderingContext.RGB5_A1,
  WebGL2RenderingContext.RGBA4,
  WebGL2RenderingContext.RGB10_A2,
  WebGL2RenderingContext.RGBA16F,
  WebGL2RenderingContext.RGBA32F,
  WebGL2RenderingContext.RGBA8UI,
  WebGL2RenderingContext.RGBA8I,
  WebGL2RenderingContext.RGB10_A2UI,
  WebGL2RenderingContext.RGBA16UI,
  WebGL2RenderingContext.RGBA16I,
  WebGL2RenderingContext.RGBA32I,
  WebGL2RenderingContext.RGBA32UI,

  WebGL2RenderingContext.DEPTH_COMPONENT16,
  WebGL2RenderingContext.DEPTH_COMPONENT24,
  WebGL2RenderingContext.DEPTH_COMPONENT32F,
  WebGL2RenderingContext.DEPTH24_STENCIL8,
  //WebGL2RenderingContext.DEPTH32F_STENCIL,

  EXT_sRGB.SRGB_EXT,
  EXT_sRGB.SRGB_ALPHA_EXT
};

const enum TextureFormat {
  WebGL2RenderingContext.RGB,
  WebGL2RenderingContext.RGBA,
  WebGL2RenderingContext.LUMINANCE_ALPHA,
  WebGL2RenderingContext.LUMINANCE,
  WebGL2RenderingContext.ALPHA,
  WebGL2RenderingContext.RED,
  WebGL2RenderingContext.RED_INTEGER,
  WebGL2RenderingContext.RG,
  WebGL2RenderingContext.RG_INTEGER,
  WebGL2RenderingContext.RGB_INTEGER,
  WebGL2RenderingContext.RGBA_INTEGER
};

const enum PixelFormat {
  WebGL2RenderingContext.RGB,
  WebGL2RenderingContext.RGBA,
  WebGL2RenderingContext.RED,
  WebGL2RenderingContext.RED_INTEGER,
  WebGL2RenderingContext.RG,
  WebGL2RenderingContext.RG_INTEGER,
  WebGL2RenderingContext.RGB_INTEGER,
  WebGL2RenderingContext.RGBA_INTEGER
};

const enum Capability {
  WebGL2RenderingContext.BLEND,
  WebGL2RenderingContext.CULL_FACE,
  WebGL2RenderingContext.DEPTH_TEST,
  WebGL2RenderingContext.DITHER,
  WebGL2RenderingContext.POLYGON_OFFSET_FILL,
  WebGL2RenderingContext.SAMPLE_ALPHA_TO_COVERAGE,
  WebGL2RenderingContext.SAMPLE_COVERAGE,
  WebGL2RenderingContext.SCISSOR_TEST,
  WebGL2RenderingContext.STENCIL_TEST,
  WebGL2RenderingContext.RASTERIZER_DISCARD
};
