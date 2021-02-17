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

const enum AttributeDataType {
  WebGL2RenderingContext.BYTE,
  WebGL2RenderingContext.UNSIGNED_BYTE,
  WebGL2RenderingContext.SHORT,
  WebGL2RenderingContext.UNSIGNED_SHORT,
  WebGL2RenderingContext.FLOAT,
  WebGL2RenderingContext.HALF_FLOAT
};

const enum AttributeIntegerDataType {
  WebGL2RenderingContext.BYTE,
  WebGL2RenderingContext.UNSIGNED_BYTE,
  WebGL2RenderingContext.SHORT,
  WebGL2RenderingContext.UNSIGNED_SHORT
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

const enum DrawElementsDataType {
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

  EXT_texture_norm16.R16_EXT,
  EXT_texture_norm16.R16_SNORM_EXT,
  EXT_texture_norm16.RG16_EXT,
  EXT_texture_norm16.RG16_SNORM_EXT,
  EXT_texture_norm16.RGB16_EXT,
  EXT_texture_norm16.RGB16_SNORM_EXT,
  EXT_texture_norm16.RGBA16_EXT,
  EXT_texture_norm16.RGBA16_SNORM_EXT,

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

const enum BlendFactor {
  WebGL2RenderingContext.ZERO,
  WebGL2RenderingContext.ONE,
  WebGL2RenderingContext.SRC_COLOR,
  WebGL2RenderingContext.DST_COLOR,
  WebGL2RenderingContext.ONE_MINUS_DST_COLOR,
  WebGL2RenderingContext.SRC_ALPHA,
  WebGL2RenderingContext.ONE_MINUS_SRC_ALPHA,
  WebGL2RenderingContext.DST_ALPHA,
  WebGL2RenderingContext.ONE_MINUS_DST_ALPHA,
  WebGL2RenderingContext.CONSTANT_COLOR,
  WebGL2RenderingContext.ONE_MINUS_CONSTANT_COLOR,
  WebGL2RenderingContext.CONSTANT_ALPHA,
  WebGL2RenderingContext.ONE_MINUS_CONSTANT_ALPHA,
  WebGL2RenderingContext.SRC_ALPHA_SATURATE
};

const enum Winding {
  WebGL2RenderingContext.CW,
  WebGL2RenderingContext.CCW
};

const enum TextureWrapMode {
  WebGL2RenderingContext.REPEAT,
  WebGL2RenderingContext.CLAMP_TO_EDGE,
  WebGL2RenderingContext.MIRRORED_REPEAT
};

const enum TextureMagnificationFilter {
  WebGL2RenderingContext.LINEAR,
  WebGL2RenderingContext.NEAREST
};

const enum TextureMinificationFilter {
  WebGL2RenderingContext.LINEAR,
  WebGL2RenderingContext.NEAREST,
  WebGL2RenderingContext.NEAREST_MIPMAP_NEAREST,
  WebGL2RenderingContext.LINEAR_MIPMAP_NEAREST,
  WebGL2RenderingContext.NEAREST_MIPMAP_LINEAR,
  WebGL2RenderingContext.LINEAR_MIPMAP_LINEAR
};

const enum TextureComparisonFunction {
  WebGL2RenderingContext.LEQUAL,
  WebGL2RenderingContext.GEQUAL,
  WebGL2RenderingContext.LESS,
  WebGL2RenderingContext.GREATER,
  WebGL2RenderingContext.EQUAL,
  WebGL2RenderingContext.NOTEQUAL,
  WebGL2RenderingContext.ALWAYS,
  WebGL2RenderingContext.NEVER
};

const enum TextureComparisonMode {
  WebGL2RenderingContext.NONE,
  WebGL2RenderingContext.COMPARE_REF_TO_TEXTURE
};

const enum WebGLContextError {
  WebGL2RenderingContext.NO_ERROR,
  WebGL2RenderingContext.INVALID_ENUM,
  WebGL2RenderingContext.INVALID_VALUE,
  WebGL2RenderingContext.INVALID_OPERATION,
  WebGL2RenderingContext.INVALID_FRAMEBUFFER_OPERATION,
  WebGL2RenderingContext.OUT_OF_MEMORY,
  WebGL2RenderingContext.CONTEXT_LOST_WEBGL
};

const enum ShaderParameterType {
  WebGL2RenderingContext.DELETE_STATUS,
  WebGL2RenderingContext.COMPILE_STATUS,
  WebGL2RenderingContext.SHADER_TYPE
};

const enum ProgramParameterType {
  KHR_parallel_shader_compile.COMPLETION_STATUS_KHR,
  WebGL2RenderingContext.DELETE_STATUS,
  WebGL2RenderingContext.LINK_STATUS,
  WebGL2RenderingContext.VALIDATE_STATUS,
  WebGL2RenderingContext.ATTACHED_SHADERS,
  WebGL2RenderingContext.ACTIVE_ATTRIBUTES,
  WebGL2RenderingContext.ACTIVE_UNIFORMS,
  WebGL2RenderingContext.TRANSFORM_FEEDBACK_BUFFER_MODE,
  WebGL2RenderingContext.TRANSFORM_FEEDBACK_VARYINGS,
  WebGL2RenderingContext.ACTIVE_UNIFORM_BLOCKS
};

const enum RenderbufferStorageTarget {
  WebGL2RenderingContext.RENDERBUFFER
};

const enum RenderbufferStorageInternalFormat {
  WebGL2RenderingContext.RGBA4,
  WebGL2RenderingContext.RGB565,
  WebGL2RenderingContext.RGB5_A1,
  WebGL2RenderingContext.DEPTH_COMPONENT16,
  WebGL2RenderingContext.STENCIL_INDEX8,
  WebGL2RenderingContext.DEPTH_STENCIL,
  WebGL2RenderingContext.R8,
  WebGL2RenderingContext.R8UI,
  WebGL2RenderingContext.R8I,
  WebGL2RenderingContext.R16UI,
  WebGL2RenderingContext.R16I,
  WebGL2RenderingContext.R32UI,
  WebGL2RenderingContext.R32I,
  WebGL2RenderingContext.RG8,
  WebGL2RenderingContext.RG8UI,
  WebGL2RenderingContext.RG8I,
  WebGL2RenderingContext.RG16UI,
  WebGL2RenderingContext.RG16I,
  WebGL2RenderingContext.RG32UI,
  WebGL2RenderingContext.RG32I,
  WebGL2RenderingContext.RGB8,
  WebGL2RenderingContext.RGBA8,
  WebGL2RenderingContext.SRGB8_ALPHA8,
  WebGL2RenderingContext.RGB10_A2,
  WebGL2RenderingContext.RGBA8UI,
  WebGL2RenderingContext.RGBA8I,
  WebGL2RenderingContext.RGB10_A2UI,
  WebGL2RenderingContext.RGBA16UI,
  WebGL2RenderingContext.RGBA16I,
  WebGL2RenderingContext.RGBA32I,
  WebGL2RenderingContext.RGBA32UI,
  WebGL2RenderingContext.DEPTH_COMPONENT24,
  WebGL2RenderingContext.DEPTH_COMPONENT32F,
  WebGL2RenderingContext.DEPTH24_STENCIL8,
  WebGL2RenderingContext.DEPTH32F_STENCIL8,

  WEBGL_color_buffer_float.RGBA32F_EXT,

  EXT_sRGB.SRGB8_ALPHA8_EXT,

  // When EXT_color_buffer_float is enabled
  WebGL2RenderingContext.R16F,
  WebGL2RenderingContext.RG16F,
  WebGL2RenderingContext.RGBA16F,
  WebGL2RenderingContext.R32F,
  WebGL2RenderingContext.RG32F,
  WebGL2RenderingContext.RGBA32F,
  WebGL2RenderingContext.R11F_G11F_B10F,

  EXT_texture_norm16.R16_EXT,
  EXT_texture_norm16.RG16_EXT,
  EXT_texture_norm16.RGBA16_EXT
};

const enum ActiveInfoDataType {
  WebGL2RenderingContext.FLOAT,
  WebGL2RenderingContext.FLOAT_VEC2,
  WebGL2RenderingContext.FLOAT_VEC3,
  WebGL2RenderingContext.FLOAT_VEC4,
  WebGL2RenderingContext.INT,
  WebGL2RenderingContext.INT_VEC2,
  WebGL2RenderingContext.INT_VEC3,
  WebGL2RenderingContext.INT_VEC4,
  WebGL2RenderingContext.BOOL,
  WebGL2RenderingContext.BOOL_VEC2,
  WebGL2RenderingContext.BOOL_VEC3,
  WebGL2RenderingContext.BOOL_VEC4,
  WebGL2RenderingContext.FLOAT_MAT2,
  WebGL2RenderingContext.FLOAT_MAT3,
  WebGL2RenderingContext.FLOAT_MAT4,
  WebGL2RenderingContext.SAMPLER_2D,
  WebGL2RenderingContext.SAMPLER_CUBE,
  WebGL2RenderingContext.UNSIGNED_INT,
  WebGL2RenderingContext.UNSIGNED_INT_VEC2,
  WebGL2RenderingContext.UNSIGNED_INT_VEC3,
  WebGL2RenderingContext.UNSIGNED_INT_VEC4,
  WebGL2RenderingContext.FLOAT_MAT2x3,
  WebGL2RenderingContext.FLOAT_MAT2x4,
  WebGL2RenderingContext.FLOAT_MAT3x2,
  WebGL2RenderingContext.FLOAT_MAT3x4,
  WebGL2RenderingContext.FLOAT_MAT4x2,
  WebGL2RenderingContext.FLOAT_MAT4x3,
  WebGL2RenderingContext.SAMPLER_3D,
  WebGL2RenderingContext.SAMPLER_2D_SHADOW,
  WebGL2RenderingContext.SAMPLER_2D_ARRAY,
  WebGL2RenderingContext.SAMPLER_2D_ARRAY_SHADOW,
  WebGL2RenderingContext.SAMPLER_CUBE_SHADOW,
  WebGL2RenderingContext.INT_SAMPLER_2D,
  WebGL2RenderingContext.INT_SAMPLER_3D,
  WebGL2RenderingContext.INT_SAMPLER_CUBE,
  WebGL2RenderingContext.INT_SAMPLER_2D_ARRAY,
  WebGL2RenderingContext.UNSIGNED_INT_SAMPLER_2D,
  WebGL2RenderingContext.UNSIGNED_INT_SAMPLER_3D,
  WebGL2RenderingContext.UNSIGNED_INT_SAMPLER_CUBE,
  WebGL2RenderingContext.UNSIGNED_INT_SAMPLER_2D_ARRAY
};

const enum WebGLParameterName {
  WebGL2RenderingContext.ACTIVE_TEXTURE,
  WebGL2RenderingContext.ALIASED_LINE_WIDTH_RANGE,
  WebGL2RenderingContext.ALIASED_POINT_SIZE_RANGE,
  WebGL2RenderingContext.ALPHA_BITS,
  WebGL2RenderingContext.ARRAY_BUFFER_BINDING,
  WebGL2RenderingContext.BLEND,
  WebGL2RenderingContext.BLEND_COLOR,
  WebGL2RenderingContext.BLEND_DST_ALPHA,
  WebGL2RenderingContext.BLEND_DST_RGB,
  WebGL2RenderingContext.BLEND_EQUATION,
  WebGL2RenderingContext.BLEND_EQUATION_ALPHA,
  WebGL2RenderingContext.BLEND_EQUATION_RGB,
  WebGL2RenderingContext.BLEND_SRC_ALPHA,
  WebGL2RenderingContext.BLEND_SRC_RGB,
  WebGL2RenderingContext.BLUE_BITS,
  WebGL2RenderingContext.COLOR_CLEAR_VALUE,
  WebGL2RenderingContext.COLOR_WRITEMASK,
  WebGL2RenderingContext.COMPRESSED_TEXTURE_FORMATS,
  WebGL2RenderingContext.CULL_FACE,
  WebGL2RenderingContext.CULL_FACE_MODE,
  WebGL2RenderingContext.CURRENT_PROGRAM,
  WebGL2RenderingContext.DEPTH_BITS,
  WebGL2RenderingContext.DEPTH_CLEAR_VALUE,
  WebGL2RenderingContext.DEPTH_FUNC,
  WebGL2RenderingContext.DEPTH_RANGE,
  WebGL2RenderingContext.DEPTH_TEST,
  WebGL2RenderingContext.DEPTH_WRITEMASK,
  WebGL2RenderingContext.DITHER,
  WebGL2RenderingContext.ELEMENT_ARRAY_BUFFER_BINDING,
  WebGL2RenderingContext.FRAMEBUFFER_BINDING,
  WebGL2RenderingContext.FRONT_FACE,
  WebGL2RenderingContext.GENERATE_MIPMAP_HINT,
  WebGL2RenderingContext.GREEN_BITS,
  WebGL2RenderingContext.IMPLEMENTATION_COLOR_READ_FORMAT,
  WebGL2RenderingContext.IMPLEMENTATION_COLOR_READ_TYPE,
  WebGL2RenderingContext.LINE_WIDTH,
  WebGL2RenderingContext.MAX_COMBINED_TEXTURE_IMAGE_UNITS,
  WebGL2RenderingContext.MAX_CUBE_MAP_TEXTURE_SIZE,
  WebGL2RenderingContext.MAX_FRAGMENT_UNIFORM_VECTORS,
  WebGL2RenderingContext.MAX_RENDERBUFFER_SIZE,
  WebGL2RenderingContext.MAX_TEXTURE_IMAGE_UNITS,
  WebGL2RenderingContext.MAX_TEXTURE_SIZE,
  WebGL2RenderingContext.MAX_VARYING_VECTORS,
  WebGL2RenderingContext.MAX_VERTEX_ATTRIBS,
  WebGL2RenderingContext.MAX_VERTEX_TEXTURE_IMAGE_UNITS,
  WebGL2RenderingContext.MAX_VERTEX_UNIFORM_VECTORS,
  WebGL2RenderingContext.MAX_VIEWPORT_DIMS,
  WebGL2RenderingContext.PACK_ALIGNMENT,
  WebGL2RenderingContext.POLYGON_OFFSET_FACTOR,
  WebGL2RenderingContext.POLYGON_OFFSET_FILL,
  WebGL2RenderingContext.POLYGON_OFFSET_UNITS,
  WebGL2RenderingContext.RED_BITS,
  WebGL2RenderingContext.RENDERBUFFER_BINDING,
  WebGL2RenderingContext.RENDERER,
  WebGL2RenderingContext.SAMPLE_BUFFERS,
  WebGL2RenderingContext.SAMPLE_COVERAGE_INVERT,
  WebGL2RenderingContext.SAMPLE_COVERAGE_VALUE,
  WebGL2RenderingContext.SAMPLES,
  WebGL2RenderingContext.SCISSOR_BOX,
  WebGL2RenderingContext.SCISSOR_TEST,
  WebGL2RenderingContext.SHADING_LANGUAGE_VERSION,
  WebGL2RenderingContext.STENCIL_BACK_FAIL,
  WebGL2RenderingContext.STENCIL_BACK_FUNC,
  WebGL2RenderingContext.STENCIL_BACK_PASS_DEPTH_FAIL,
  WebGL2RenderingContext.STENCIL_BACK_PASS_DEPTH_PASS,
  WebGL2RenderingContext.STENCIL_BACK_REF,
  WebGL2RenderingContext.STENCIL_BACK_VALUE_MASK,
  WebGL2RenderingContext.STENCIL_BACK_WRITEMASK,
  WebGL2RenderingContext.STENCIL_BITS,
  WebGL2RenderingContext.STENCIL_CLEAR_VALUE,
  WebGL2RenderingContext.STENCIL_FAIL,
  WebGL2RenderingContext.STENCIL_FUNC,
  WebGL2RenderingContext.STENCIL_PASS_DEPTH_FAIL,
  WebGL2RenderingContext.STENCIL_PASS_DEPTH_PASS,
  WebGL2RenderingContext.STENCIL_REF,
  WebGL2RenderingContext.STENCIL_TEST,
  WebGL2RenderingContext.STENCIL_VALUE_MASK,
  WebGL2RenderingContext.STENCIL_WRITEMASK,
  WebGL2RenderingContext.SUBPIXEL_BITS,
  WebGL2RenderingContext.TEXTURE_BINDING_2D,
  WebGL2RenderingContext.TEXTURE_BINDING_CUBE_MAP,
  WebGL2RenderingContext.UNPACK_ALIGNMENT,
  WebGL2RenderingContext.UNPACK_COLORSPACE_CONVERSION_WEBGL,
  WebGL2RenderingContext.UNPACK_FLIP_Y_WEBGL,
  WebGL2RenderingContext.UNPACK_PREMULTIPLY_ALPHA_WEBGL,
  WebGL2RenderingContext.VENDOR,
  WebGL2RenderingContext.VERSION,
  WebGL2RenderingContext.VIEWPORT,

  // WebGL2 specific parameters
  WebGL2RenderingContext.COPY_READ_BUFFER_BINDING,
  WebGL2RenderingContext.COPY_WRITE_BUFFER_BINDING,
  WebGL2RenderingContext.DRAW_BUFFER0,
  WebGL2RenderingContext.DRAW_BUFFER1,
  WebGL2RenderingContext.DRAW_BUFFER2,
  WebGL2RenderingContext.DRAW_BUFFER3,
  WebGL2RenderingContext.DRAW_BUFFER4,
  WebGL2RenderingContext.DRAW_BUFFER5,
  WebGL2RenderingContext.DRAW_BUFFER6,
  WebGL2RenderingContext.DRAW_BUFFER7,
  WebGL2RenderingContext.DRAW_BUFFER8,
  WebGL2RenderingContext.DRAW_BUFFER9,
  WebGL2RenderingContext.DRAW_BUFFER10,
  WebGL2RenderingContext.DRAW_BUFFER11,
  WebGL2RenderingContext.DRAW_BUFFER12,
  WebGL2RenderingContext.DRAW_BUFFER13,
  WebGL2RenderingContext.DRAW_BUFFER14,
  WebGL2RenderingContext.DRAW_BUFFER15,
  WebGL2RenderingContext.DRAW_FRAMEBUFFER_BINDING,
  WebGL2RenderingContext.FRAGMENT_SHADER_DERIVATIVE_HINT,
  WebGL2RenderingContext.MAX_3D_TEXTURE_SIZE,
  WebGL2RenderingContext.MAX_ARRAY_TEXTURE_LAYERS,
  WebGL2RenderingContext.MAX_CLIENT_WAIT_TIMEOUT_WEBGL,
  WebGL2RenderingContext.MAX_COLOR_ATTACHMENTS,
  WebGL2RenderingContext.MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS,
  WebGL2RenderingContext.MAX_COMBINED_UNIFORM_BLOCKS,
  WebGL2RenderingContext.MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS,
  WebGL2RenderingContext.MAX_DRAW_BUFFERS,
  WebGL2RenderingContext.MAX_ELEMENT_INDEX,
  WebGL2RenderingContext.MAX_ELEMENTS_INDICES,
  WebGL2RenderingContext.MAX_ELEMENTS_VERTICES,
  WebGL2RenderingContext.MAX_FRAGMENT_INPUT_COMPONENTS,
  WebGL2RenderingContext.MAX_FRAGMENT_UNIFORM_BLOCKS,
  WebGL2RenderingContext.MAX_FRAGMENT_UNIFORM_COMPONENTS,
  WebGL2RenderingContext.MAX_PROGRAM_TEXEL_OFFSET,
  WebGL2RenderingContext.MAX_SAMPLES,
  WebGL2RenderingContext.MAX_SERVER_WAIT_TIMEOUT,
  WebGL2RenderingContext.MAX_TEXTURE_LOD_BIAS,
  WebGL2RenderingContext.MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS,
  WebGL2RenderingContext.MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS,
  WebGL2RenderingContext.MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS,
  WebGL2RenderingContext.MAX_UNIFORM_BLOCK_SIZE,
  WebGL2RenderingContext.MAX_UNIFORM_BUFFER_BINDINGS,
  WebGL2RenderingContext.MAX_VARYING_COMPONENTS,
  WebGL2RenderingContext.MAX_VERTEX_OUTPUT_COMPONENTS,
  WebGL2RenderingContext.MAX_VERTEX_UNIFORM_BLOCKS,
  WebGL2RenderingContext.MAX_VERTEX_UNIFORM_COMPONENTS,
  WebGL2RenderingContext.MIN_PROGRAM_TEXEL_OFFSET,
  WebGL2RenderingContext.PACK_ROW_LENGTH,
  WebGL2RenderingContext.PACK_SKIP_PIXELS,
  WebGL2RenderingContext.PACK_SKIP_ROWS,
  WebGL2RenderingContext.PIXEL_PACK_BUFFER_BINDING,
  WebGL2RenderingContext.PIXEL_UNPACK_BUFFER_BINDING,
  WebGL2RenderingContext.RASTERIZER_DISCARD,
  WebGL2RenderingContext.READ_BUFFER,
  WebGL2RenderingContext.READ_FRAMEBUFFER_BINDING,
  WebGL2RenderingContext.SAMPLE_ALPHA_TO_COVERAGE,
  WebGL2RenderingContext.SAMPLE_COVERAGE,
  WebGL2RenderingContext.SAMPLER_BINDING,
  WebGL2RenderingContext.TEXTURE_BINDING_2D_ARRAY,
  WebGL2RenderingContext.TEXTURE_BINDING_3D,
  WebGL2RenderingContext.TRANSFORM_FEEDBACK_ACTIVE,
  WebGL2RenderingContext.TRANSFORM_FEEDBACK_BINDING,
  WebGL2RenderingContext.TRANSFORM_FEEDBACK_BUFFER_BINDING,
  WebGL2RenderingContext.TRANSFORM_FEEDBACK_PAUSED,
  WebGL2RenderingContext.UNIFORM_BUFFER_BINDING,
  WebGL2RenderingContext.UNIFORM_BUFFER_OFFSET_ALIGNMENT,
  WebGL2RenderingContext.UNPACK_IMAGE_HEIGHT,
  WebGL2RenderingContext.UNPACK_ROW_LENGTH,
  WebGL2RenderingContext.UNPACK_SKIP_IMAGES,
  WebGL2RenderingContext.UNPACK_SKIP_PIXELS,
  WebGL2RenderingContext.UNPACK_SKIP_ROWS,
  WebGL2RenderingContext.VERTEX_ARRAY_BINDING,

  EXT_texture_filter_anisotropic.MAX_TEXTURE_MAX_ANISOTROPY_EXT,
  OES_standard_derivatives.FRAGMENT_SHADER_DERIVATIVE_HINT_OES,
  WEBGL_draw_buffers.MAX_COLOR_ATTACHMENTS_WEBGL,
  WEBGL_draw_buffers.MAX_DRAW_BUFFERS_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER0_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER1_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER2_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER3_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER4_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER5_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER6_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER7_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER8_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER9_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER10_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER11_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER12_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER13_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER14_WEBGL,
  WEBGL_draw_buffers.DRAW_BUFFER15_WEBGL,
  WEBGL_debug_renderer_info.UNMASKED_VENDOR_WEBGL,
  WEBGL_debug_renderer_info.UNMASKED_RENDERER_WEBGL,
  //EXT_disjoint_timer_query.TIMESTAMP_EXT,
  //EXT_disjoint_timer_query.GPU_DISJOINT_EXT,
  //OVR_multiview2.MAX_VIEWS_OVR,
  OES_vertex_array_object.VERTEX_ARRAY_BINDING_OES
};

// The following patches add a name constant to extensions to make using these extensions
// more idiomatic to java. The constants do not exist in the underlying model so should
// not appear in other outputs such as closure externs.

partial interface ANGLE_instanced_arrays {
  [JavaOnly]
  const DOMString NAME = "ANGLE_instanced_arrays";
};

partial interface WEBGL_color_buffer_float {
  [JavaOnly]
  const DOMString NAME = "WEBGL_color_buffer_float";
};

partial interface WEBGL_compressed_texture_astc {
  [JavaOnly]
  const DOMString NAME = "WEBGL_compressed_texture_astc";
};

partial interface WEBGL_compressed_texture_s3tc {
  [JavaOnly]
  const DOMString NAME = "WEBGL_compressed_texture_s3tc";
};

partial interface WEBGL_compressed_texture_s3tc_srgb {
  [JavaOnly]
  const DOMString NAME = "WEBGL_compressed_texture_s3tc_srgb";
};

partial interface WEBGL_debug_renderer_info {
  [JavaOnly]
  const DOMString NAME = "WEBGL_debug_renderer_info";
};

partial interface WEBGL_debug_shaders {
  [JavaOnly]
  const DOMString NAME = "WEBGL_debug_shaders";
};

partial interface WEBGL_depth_texture {
  [JavaOnly]
  const DOMString NAME = "WEBGL_depth_texture";
};

partial interface WEBGL_draw_buffers {
  [JavaOnly]
  const DOMString NAME = "WEBGL_draw_buffers";
};

partial interface EXT_blend_minmax {
  [JavaOnly]
  const DOMString NAME = "EXT_blend_minmax";
};

partial interface EXT_color_buffer_float {
  [JavaOnly]
  const DOMString NAME = "EXT_color_buffer_float";
};

partial interface EXT_float_blend {
  [JavaOnly]
  const DOMString NAME = "EXT_float_blend";
};

partial interface EXT_frag_depth {
  [JavaOnly]
  const DOMString NAME = "EXT_frag_depth";
};

partial interface EXT_shader_texture_lod {
  [JavaOnly]
  const DOMString NAME = "EXT_shader_texture_lod";
};

partial interface EXT_sRGB {
  [JavaOnly]
  const DOMString NAME = "EXT_sRGB";
};

partial interface EXT_texture_compression_rgtc {
  [JavaOnly]
  const DOMString NAME = "EXT_texture_compression_rgtc";
};

partial interface EXT_texture_filter_anisotropic {
  [JavaOnly]
  const DOMString NAME = "EXT_texture_filter_anisotropic";
};

partial interface EXT_texture_norm16 {
  [JavaOnly]
  const DOMString NAME = "EXT_texture_norm16";
};

partial interface KHR_parallel_shader_compile {
  [JavaOnly]
  const DOMString NAME = "KHR_parallel_shader_compile";
};

partial interface WEBGL_lose_context {
  [JavaOnly]
  const DOMString NAME = "WEBGL_lose_context";
};

partial interface WEBGL_multi_draw {
  [JavaOnly]
  const DOMString NAME = "WEBGL_multi_draw";
};

partial interface OES_element_index_uint {
  [JavaOnly]
  const DOMString NAME = "OES_element_index_uint";
};

partial interface OES_standard_derivatives {
  [JavaOnly]
  const DOMString NAME = "OES_standard_derivatives";
};

partial interface OES_texture_float_linear {
  [JavaOnly]
  const DOMString NAME = "OES_texture_float_linear";
};

partial interface OES_texture_half_float {
  [JavaOnly]
  const DOMString NAME = "OES_texture_half_float";
};

partial interface OES_texture_half_float_linear {
  [JavaOnly]
  const DOMString NAME = "OES_texture_half_float_linear";
};

partial interface OES_vertex_array_object {
  [JavaOnly]
  const DOMString NAME = "OES_vertex_array_object";
};
