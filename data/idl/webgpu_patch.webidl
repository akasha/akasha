[Flags]
const enum GPUBufferUsageFlags {
  GPUBufferUsage.MAP_READ,
  GPUBufferUsage.MAP_WRITE,
  GPUBufferUsage.COPY_SRC,
  GPUBufferUsage.COPY_DST,
  GPUBufferUsage.INDEX,
  GPUBufferUsage.VERTEX,
  GPUBufferUsage.UNIFORM,
  GPUBufferUsage.STORAGE,
  GPUBufferUsage.INDIRECT,
  GPUBufferUsage.QUERY_RESOLVE
};

[Flags]
const enum GPUColorWriteFlags {
  GPUColorWrite.RED,
  GPUColorWrite.GREEN,
  GPUColorWrite.BLUE,
  GPUColorWrite.ALPHA,
  GPUColorWrite.ALL
};

[Flags]
const enum GPUMapModeFlags {
  GPUMapMode.READ,
  GPUMapMode.WRITE
};

[Flags]
const enum GPUShaderStageFlags {
  GPUShaderStage.VERTEX,
  GPUShaderStage.FRAGMENT,
  GPUShaderStage.COMPUTE
};

[Flags]
const enum GPUTextureUsageFlags {
  GPUTextureUsage.COPY_SRC,
  GPUTextureUsage.COPY_DST,
  GPUTextureUsage.SHADER_READ,
  GPUTextureUsage.STORAGE,
  GPUTextureUsage.RENDER_ATTACHMENT
};
