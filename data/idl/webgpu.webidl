enum GPUAddressMode {
  "clamp-to-edge",
  "mirror-repeat",
  "repeat"
};

enum GPUBlendFactor {
  "constant",
  "dst",
  "dst-alpha",
  "one",
  "one-minus-constant",
  "one-minus-dst",
  "one-minus-dst-alpha",
  "one-minus-src",
  "one-minus-src-alpha",
  "src",
  "src-alpha",
  "src-alpha-saturated",
  "zero"
};

enum GPUBlendOperation {
  "add",
  "max",
  "min",
  "reverse-subtract",
  "subtract"
};

enum GPUBufferBindingType {
  "read-only-storage",
  "storage",
  "uniform"
};

enum GPUCanvasCompositingAlphaMode {
  "opaque",
  "premultiplied"
};

enum GPUCompareFunction {
  "always",
  "equal",
  "greater",
  "greater-equal",
  "less",
  "less-equal",
  "never",
  "not-equal"
};

enum GPUCompilationMessageType {
  "error",
  "info",
  "warning"
};

enum GPUCullMode {
  "back",
  "front",
  "none"
};

enum GPUDeviceLostReason {
  "destroyed"
};

enum GPUErrorFilter {
  "out-of-memory",
  "validation"
};

enum GPUFeatureName {
  "depth-clamping",
  "depth24unorm-stencil8",
  "depth32float-stencil8",
  "pipeline-statistics-query",
  "texture-compression-bc",
  "timestamp-query"
};

enum GPUFilterMode {
  "linear",
  "nearest"
};

enum GPUFrontFace {
  "ccw",
  "cw"
};

enum GPUIndexFormat {
  "uint16",
  "uint32"
};

enum GPULoadOp {
  "load"
};

enum GPUPipelineStatisticName {
  "clipper-invocations",
  "clipper-primitives-out",
  "compute-shader-invocations",
  "fragment-shader-invocations",
  "vertex-shader-invocations"
};

enum GPUPowerPreference {
  "high-performance",
  "low-power"
};

enum GPUPredefinedColorSpace {
  "srgb"
};

enum GPUPrimitiveTopology {
  "line-list",
  "line-strip",
  "point-list",
  "triangle-list",
  "triangle-strip"
};

enum GPUQueryType {
  "occlusion",
  "pipeline-statistics",
  "timestamp"
};

enum GPUSamplerBindingType {
  "comparison",
  "filtering",
  "non-filtering"
};

enum GPUStencilOperation {
  "decrement-clamp",
  "decrement-wrap",
  "increment-clamp",
  "increment-wrap",
  "invert",
  "keep",
  "replace",
  "zero"
};

enum GPUStorageTextureAccess {
  "write-only"
};

enum GPUStoreOp {
  "discard",
  "store"
};

enum GPUTextureAspect {
  "all",
  "depth-only",
  "stencil-only"
};

enum GPUTextureDimension {
  "1d",
  "2d",
  "3d"
};

enum GPUTextureFormat {
  "bc1-rgba-unorm",
  "bc1-rgba-unorm-srgb",
  "bc2-rgba-unorm",
  "bc2-rgba-unorm-srgb",
  "bc3-rgba-unorm",
  "bc3-rgba-unorm-srgb",
  "bc4-r-snorm",
  "bc4-r-unorm",
  "bc5-rg-snorm",
  "bc5-rg-unorm",
  "bc6h-rgb-float",
  "bc6h-rgb-ufloat",
  "bc7-rgba-unorm",
  "bc7-rgba-unorm-srgb",
  "bgra8unorm",
  "bgra8unorm-srgb",
  "depth16unorm",
  "depth24plus",
  "depth24plus-stencil8",
  "depth24unorm-stencil8",
  "depth32float",
  "depth32float-stencil8",
  "r16float",
  "r16sint",
  "r16uint",
  "r32float",
  "r32sint",
  "r32uint",
  "r8sint",
  "r8snorm",
  "r8uint",
  "r8unorm",
  "rg11b10ufloat",
  "rg16float",
  "rg16sint",
  "rg16uint",
  "rg32float",
  "rg32sint",
  "rg32uint",
  "rg8sint",
  "rg8snorm",
  "rg8uint",
  "rg8unorm",
  "rgb10a2unorm",
  "rgb9e5ufloat",
  "rgba16float",
  "rgba16sint",
  "rgba16uint",
  "rgba32float",
  "rgba32sint",
  "rgba32uint",
  "rgba8sint",
  "rgba8snorm",
  "rgba8uint",
  "rgba8unorm",
  "rgba8unorm-srgb",
  "stencil8"
};

enum GPUTextureSampleType {
  "depth",
  "float",
  "sint",
  "uint",
  "unfilterable-float"
};

enum GPUTextureViewDimension {
  "1d",
  "2d",
  "2d-array",
  "3d",
  "cube",
  "cube-array"
};

enum GPUVertexFormat {
  "float16x2",
  "float16x4",
  "float32",
  "float32x2",
  "float32x3",
  "float32x4",
  "sint16x2",
  "sint16x4",
  "sint32",
  "sint32x2",
  "sint32x3",
  "sint32x4",
  "sint8x2",
  "sint8x4",
  "snorm16x2",
  "snorm16x4",
  "snorm8x2",
  "snorm8x4",
  "uint16x2",
  "uint16x4",
  "uint32",
  "uint32x2",
  "uint32x3",
  "uint32x4",
  "uint8x2",
  "uint8x4",
  "unorm16x2",
  "unorm16x4",
  "unorm8x2",
  "unorm8x4"
};

enum GPUVertexStepMode {
  "instance",
  "vertex"
};

typedef ( GPUSampler or GPUTextureView or GPUBufferBinding or GPUExternalTexture ) GPUBindingResource;

typedef unsigned long GPUBufferDynamicOffset;

typedef unsigned long GPUBufferUsageFlags;

typedef ( sequence<double> or GPUColorDict ) GPUColor;

typedef unsigned long GPUColorWriteFlags;

typedef long GPUDepthBias;

typedef ( GPUOutOfMemoryError or GPUValidationError ) GPUError;

typedef ( sequence<GPUIntegerCoordinate> or GPUExtent3DDict ) GPUExtent3D;

typedef unsigned long GPUFlagsConstant;

typedef unsigned long GPUIndex32;

typedef unsigned long GPUIntegerCoordinate;

typedef unsigned long GPUMapModeFlags;

typedef ( sequence<GPUIntegerCoordinate> or GPUOrigin2DDict ) GPUOrigin2D;

typedef ( sequence<GPUIntegerCoordinate> or GPUOrigin3DDict ) GPUOrigin3D;

typedef double GPUPipelineConstantValue;

typedef unsigned long GPUSampleMask;

typedef unsigned long GPUShaderStageFlags;

typedef long GPUSignedOffset32;

typedef unsigned long GPUSize32;

typedef unsigned long long GPUSize64;

typedef unsigned long GPUStencilValue;

typedef unsigned long GPUTextureUsageFlags;

[Exposed=(Window,DedicatedWorker)]
namespace GPUBufferUsage {
  const GPUFlagsConstant COPY_DST = 0x0008;
  const GPUFlagsConstant COPY_SRC = 0x0004;
  const GPUFlagsConstant INDEX = 0x0010;
  const GPUFlagsConstant INDIRECT = 0x0100;
  const GPUFlagsConstant MAP_READ = 0x0001;
  const GPUFlagsConstant MAP_WRITE = 0x0002;
  const GPUFlagsConstant QUERY_RESOLVE = 0x0200;
  const GPUFlagsConstant STORAGE = 0x0080;
  const GPUFlagsConstant UNIFORM = 0x0040;
  const GPUFlagsConstant VERTEX = 0x0020;
};

[Exposed=(Window,DedicatedWorker)]
namespace GPUColorWrite {
  const GPUFlagsConstant ALL = 0xF;
  const GPUFlagsConstant ALPHA = 0x8;
  const GPUFlagsConstant BLUE = 0x4;
  const GPUFlagsConstant GREEN = 0x2;
  const GPUFlagsConstant RED = 0x1;
};

[Exposed=(Window,DedicatedWorker)]
namespace GPUMapMode {
  const GPUFlagsConstant READ = 0x0001;
  const GPUFlagsConstant WRITE = 0x0002;
};

[Exposed=(Window,DedicatedWorker)]
namespace GPUShaderStage {
  const GPUFlagsConstant COMPUTE = 0x4;
  const GPUFlagsConstant FRAGMENT = 0x2;
  const GPUFlagsConstant VERTEX = 0x1;
};

[Exposed=(Window,DedicatedWorker)]
namespace GPUTextureUsage {
  const GPUFlagsConstant COPY_DST = 0x02;
  const GPUFlagsConstant COPY_SRC = 0x01;
  const GPUFlagsConstant RENDER_ATTACHMENT = 0x10;
  const GPUFlagsConstant STORAGE_BINDING = 0x08;
  const GPUFlagsConstant TEXTURE_BINDING = 0x04;
};

dictionary GPUBindGroupDescriptor : GPUObjectDescriptorBase {
  required GPUBindGroupLayout layout;
  required sequence<GPUBindGroupEntry> entries;
};

dictionary GPUBindGroupEntry {
  required GPUIndex32 binding;
  required GPUBindingResource resource;
};

dictionary GPUBindGroupLayoutDescriptor : GPUObjectDescriptorBase {
  required sequence<GPUBindGroupLayoutEntry> entries;
};

dictionary GPUBindGroupLayoutEntry {
  required GPUIndex32 binding;
  required GPUShaderStageFlags visibility;
  GPUBufferBindingLayout buffer;
  GPUExternalTextureBindingLayout externalTexture;
  GPUSamplerBindingLayout sampler;
  GPUStorageTextureBindingLayout storageTexture;
  GPUTextureBindingLayout texture;
};

dictionary GPUBlendComponent {
  GPUBlendFactor dstFactor = "zero";
  GPUBlendOperation operation = "add";
  GPUBlendFactor srcFactor = "one";
};

dictionary GPUBlendState {
  required GPUBlendComponent color;
  required GPUBlendComponent alpha;
};

dictionary GPUBufferBinding {
  required GPUBuffer buffer;
  GPUSize64 offset = 0;
  GPUSize64 size;
};

dictionary GPUBufferBindingLayout {
  boolean hasDynamicOffset = false;
  GPUSize64 minBindingSize = 0;
  GPUBufferBindingType type = "uniform";
};

dictionary GPUBufferDescriptor : GPUObjectDescriptorBase {
  required GPUSize64 size;
  required GPUBufferUsageFlags usage;
  boolean mappedAtCreation = false;
};

dictionary GPUCanvasConfiguration {
  required GPUDevice device;
  required GPUTextureFormat format;
  GPUPredefinedColorSpace colorSpace = "srgb";
  GPUCanvasCompositingAlphaMode compositingAlphaMode = "opaque";
  GPUExtent3D size;
  GPUTextureUsageFlags usage = 0x10;
};

dictionary GPUColorDict {
  required double r;
  required double g;
  required double b;
  required double a;
};

dictionary GPUColorTargetState {
  required GPUTextureFormat format;
  GPUBlendState blend;
  GPUColorWriteFlags writeMask = 0xF;
};

dictionary GPUCommandBufferDescriptor : GPUObjectDescriptorBase {
};

dictionary GPUCommandEncoderDescriptor : GPUObjectDescriptorBase {
  boolean measureExecutionTime = false;
};

dictionary GPUComputePassDescriptor : GPUObjectDescriptorBase {
};

dictionary GPUComputePipelineDescriptor : GPUPipelineDescriptorBase {
  required GPUProgrammableStage compute;
};

dictionary GPUDepthStencilState {
  required GPUTextureFormat format;
  GPUDepthBias depthBias = 0;
  float depthBiasClamp = 0;
  float depthBiasSlopeScale = 0;
  GPUCompareFunction depthCompare = "always";
  boolean depthWriteEnabled = false;
  GPUStencilFaceState stencilBack = {};
  GPUStencilFaceState stencilFront = {};
  GPUStencilValue stencilReadMask = 0xFFFFFFFF;
  GPUStencilValue stencilWriteMask = 0xFFFFFFFF;
};

dictionary GPUDeviceDescriptor : GPUObjectDescriptorBase {
  sequence<GPUFeatureName> requiredFeatures = [];
  record<DOMString, GPUSize64> requiredLimits = {};
};

dictionary GPUExtent3DDict {
  required GPUIntegerCoordinate width;
  GPUIntegerCoordinate depthOrArrayLayers = 1;
  GPUIntegerCoordinate height = 1;
};

dictionary GPUExternalTextureBindingLayout {
};

dictionary GPUExternalTextureDescriptor : GPUObjectDescriptorBase {
  required HTMLVideoElement source;
  GPUPredefinedColorSpace colorSpace = "srgb";
};

dictionary GPUFragmentState : GPUProgrammableStage {
  required sequence<GPUColorTargetState> targets;
};

dictionary GPUImageCopyBuffer : GPUImageDataLayout {
  required GPUBuffer buffer;
};

dictionary GPUImageCopyExternalImage {
  required ( ImageBitmap or HTMLCanvasElement or OffscreenCanvas ) source;
  GPUOrigin2D origin = {};
};

dictionary GPUImageCopyTexture {
  required GPUTexture texture;
  GPUTextureAspect aspect = "all";
  GPUIntegerCoordinate mipLevel = 0;
  GPUOrigin3D origin = {};
};

dictionary GPUImageCopyTextureTagged : GPUImageCopyTexture {
  GPUPredefinedColorSpace colorSpace = "srgb";
  boolean premultipliedAlpha = false;
};

dictionary GPUImageDataLayout {
  GPUSize32 bytesPerRow;
  GPUSize64 offset = 0;
  GPUSize32 rowsPerImage;
};

dictionary GPUMultisampleState {
  boolean alphaToCoverageEnabled = false;
  GPUSize32 count = 1;
  GPUSampleMask mask = 0xFFFFFFFF;
};

dictionary GPUObjectDescriptorBase {
  USVString label;
};

dictionary GPUOrigin2DDict {
  GPUIntegerCoordinate x = 0;
  GPUIntegerCoordinate y = 0;
};

dictionary GPUOrigin3DDict {
  GPUIntegerCoordinate x = 0;
  GPUIntegerCoordinate y = 0;
  GPUIntegerCoordinate z = 0;
};

dictionary GPUPipelineDescriptorBase : GPUObjectDescriptorBase {
  GPUPipelineLayout layout;
};

dictionary GPUPipelineLayoutDescriptor : GPUObjectDescriptorBase {
  required sequence<GPUBindGroupLayout> bindGroupLayouts;
};

dictionary GPUPrimitiveState {
  boolean clampDepth = false;
  GPUCullMode cullMode = "none";
  GPUFrontFace frontFace = "ccw";
  GPUIndexFormat stripIndexFormat;
  GPUPrimitiveTopology topology = "triangle-list";
};

dictionary GPUProgrammableStage {
  required GPUShaderModule module;
  required USVString entryPoint;
  record<USVString, GPUPipelineConstantValue> constants;
};

dictionary GPUQuerySetDescriptor : GPUObjectDescriptorBase {
  required GPUQueryType type;
  required GPUSize32 count;
  sequence<GPUPipelineStatisticName> pipelineStatistics = [];
};

dictionary GPURenderBundleDescriptor : GPUObjectDescriptorBase {
};

dictionary GPURenderBundleEncoderDescriptor : GPURenderPassLayout {
  boolean depthReadOnly = false;
  boolean stencilReadOnly = false;
};

dictionary GPURenderPassColorAttachment {
  required GPUTextureView view;
  GPUTextureView resolveTarget;
  required ( GPULoadOp or GPUColor ) loadValue;
  required GPUStoreOp storeOp;
};

dictionary GPURenderPassDepthStencilAttachment {
  required GPUTextureView view;
  required ( GPULoadOp or float ) depthLoadValue;
  required GPUStoreOp depthStoreOp;
  boolean depthReadOnly = false;
  required ( GPULoadOp or GPUStencilValue ) stencilLoadValue;
  required GPUStoreOp stencilStoreOp;
  boolean stencilReadOnly = false;
};

dictionary GPURenderPassDescriptor : GPUObjectDescriptorBase {
  required sequence<GPURenderPassColorAttachment> colorAttachments;
  GPURenderPassDepthStencilAttachment depthStencilAttachment;
  GPUQuerySet occlusionQuerySet;
};

dictionary GPURenderPassLayout : GPUObjectDescriptorBase {
  required sequence<GPUTextureFormat> colorFormats;
  GPUTextureFormat depthStencilFormat;
  GPUSize32 sampleCount = 1;
};

dictionary GPURenderPipelineDescriptor : GPUPipelineDescriptorBase {
  required GPUVertexState vertex;
  GPUDepthStencilState depthStencil;
  GPUFragmentState fragment;
  GPUMultisampleState multisample = {};
  GPUPrimitiveState primitive = {};
};

dictionary GPURequestAdapterOptions {
  boolean forceFallbackAdapter = false;
  GPUPowerPreference powerPreference;
};

dictionary GPUSamplerBindingLayout {
  GPUSamplerBindingType type = "filtering";
};

dictionary GPUSamplerDescriptor : GPUObjectDescriptorBase {
  GPUAddressMode addressModeU = "clamp-to-edge";
  GPUAddressMode addressModeV = "clamp-to-edge";
  GPUAddressMode addressModeW = "clamp-to-edge";
  GPUCompareFunction compare;
  float lodMaxClamp = 32;
  float lodMinClamp = 0;
  GPUFilterMode magFilter = "nearest";
  [Clamp]
  unsigned short maxAnisotropy = 1;
  GPUFilterMode minFilter = "nearest";
  GPUFilterMode mipmapFilter = "nearest";
};

dictionary GPUShaderModuleDescriptor : GPUObjectDescriptorBase {
  required USVString code;
  object sourceMap;
};

dictionary GPUStencilFaceState {
  GPUCompareFunction compare = "always";
  GPUStencilOperation depthFailOp = "keep";
  GPUStencilOperation failOp = "keep";
  GPUStencilOperation passOp = "keep";
};

dictionary GPUStorageTextureBindingLayout {
  GPUStorageTextureAccess access = "write-only";
  required GPUTextureFormat format;
  GPUTextureViewDimension viewDimension = "2d";
};

dictionary GPUTextureBindingLayout {
  boolean multisampled = false;
  GPUTextureSampleType sampleType = "float";
  GPUTextureViewDimension viewDimension = "2d";
};

dictionary GPUTextureDescriptor : GPUObjectDescriptorBase {
  required GPUExtent3D size;
  GPUTextureDimension dimension = "2d";
  GPUIntegerCoordinate mipLevelCount = 1;
  GPUSize32 sampleCount = 1;
  required GPUTextureFormat format;
  required GPUTextureUsageFlags usage;
};

dictionary GPUTextureViewDescriptor : GPUObjectDescriptorBase {
  GPUIntegerCoordinate arrayLayerCount;
  GPUTextureAspect aspect = "all";
  GPUIntegerCoordinate baseArrayLayer = 0;
  GPUIntegerCoordinate baseMipLevel = 0;
  GPUTextureViewDimension dimension;
  GPUTextureFormat format;
  GPUIntegerCoordinate mipLevelCount;
};

dictionary GPUUncapturedErrorEventInit : EventInit {
  required GPUError error;
};

dictionary GPUVertexAttribute {
  required GPUVertexFormat format;
  required GPUSize64 offset;
  required GPUIndex32 shaderLocation;
};

dictionary GPUVertexBufferLayout {
  required GPUSize64 arrayStride;
  GPUVertexStepMode stepMode = "vertex";
  required sequence<GPUVertexAttribute> attributes;
};

dictionary GPUVertexState : GPUProgrammableStage {
  sequence<GPUVertexBufferLayout?> buffers = [];
};

interface mixin GPUObjectBase {
  attribute USVString? label;
};

interface mixin GPUPipelineBase {
  GPUBindGroupLayout getBindGroupLayout( unsigned long index );
};

interface mixin GPUProgrammablePassEncoder {
  undefined insertDebugMarker( USVString markerLabel );
  undefined popDebugGroup();
  undefined pushDebugGroup( USVString groupLabel );
  undefined setBindGroup( GPUIndex32 index, GPUBindGroup bindGroup, optional sequence<GPUBufferDynamicOffset> dynamicOffsets = [] );
  undefined setBindGroup( GPUIndex32 index, GPUBindGroup bindGroup, Uint32Array dynamicOffsetsData, GPUSize64 dynamicOffsetsDataStart, GPUSize32 dynamicOffsetsDataLength );
};

interface mixin GPURenderEncoderBase {
  undefined draw( GPUSize32 vertexCount, optional GPUSize32 instanceCount = 1, optional GPUSize32 firstVertex = 0, optional GPUSize32 firstInstance = 0 );
  undefined drawIndexed( GPUSize32 indexCount, optional GPUSize32 instanceCount = 1, optional GPUSize32 firstIndex = 0, optional GPUSignedOffset32 baseVertex = 0, optional GPUSize32 firstInstance = 0 );
  undefined drawIndexedIndirect( GPUBuffer indirectBuffer, GPUSize64 indirectOffset );
  undefined drawIndirect( GPUBuffer indirectBuffer, GPUSize64 indirectOffset );
  undefined setIndexBuffer( GPUBuffer buffer, GPUIndexFormat indexFormat, optional GPUSize64 offset = 0, optional GPUSize64 size );
  undefined setPipeline( GPURenderPipeline pipeline );
  undefined setVertexBuffer( GPUIndex32 slot, GPUBuffer buffer, optional GPUSize64 offset = 0, optional GPUSize64 size );
};

interface mixin NavigatorGPU {
  [SameObject, SecureContext]
  readonly attribute GPU gpu;
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPU {
  Promise<GPUAdapter?> requestAdapter( optional GPURequestAdapterOptions options = {} );
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUAdapter {
  [SameObject]
  readonly attribute GPUSupportedFeatures features;
  readonly attribute boolean isFallbackAdapter;
  [SameObject]
  readonly attribute GPUSupportedLimits limits;
  readonly attribute DOMString name;
  Promise<GPUDevice> requestDevice( optional GPUDeviceDescriptor descriptor = {} );
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUBindGroup {
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUBindGroupLayout {
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUBuffer {
  undefined destroy();
  ArrayBuffer getMappedRange( optional GPUSize64 offset = 0, optional GPUSize64 size );
  Promise<undefined> mapAsync( GPUMapModeFlags mode, optional GPUSize64 offset = 0, optional GPUSize64 size );
  undefined unmap();
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUCanvasContext {
  readonly attribute ( HTMLCanvasElement or OffscreenCanvas ) canvas;
  undefined configure( GPUCanvasConfiguration configuration );
  GPUTexture getCurrentTexture();
  GPUTextureFormat getPreferredFormat( GPUAdapter adapter );
  undefined unconfigure();
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUCommandBuffer {
  readonly attribute Promise<double> executionTime;
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUCommandEncoder {
  GPUComputePassEncoder beginComputePass( optional GPUComputePassDescriptor descriptor = {} );
  GPURenderPassEncoder beginRenderPass( GPURenderPassDescriptor descriptor );
  undefined copyBufferToBuffer( GPUBuffer source, GPUSize64 sourceOffset, GPUBuffer destination, GPUSize64 destinationOffset, GPUSize64 size );
  undefined copyBufferToTexture( GPUImageCopyBuffer source, GPUImageCopyTexture destination, GPUExtent3D copySize );
  undefined copyTextureToBuffer( GPUImageCopyTexture source, GPUImageCopyBuffer destination, GPUExtent3D copySize );
  undefined copyTextureToTexture( GPUImageCopyTexture source, GPUImageCopyTexture destination, GPUExtent3D copySize );
  GPUCommandBuffer finish( optional GPUCommandBufferDescriptor descriptor = {} );
  undefined insertDebugMarker( USVString markerLabel );
  undefined popDebugGroup();
  undefined pushDebugGroup( USVString groupLabel );
  undefined resolveQuerySet( GPUQuerySet querySet, GPUSize32 firstQuery, GPUSize32 queryCount, GPUBuffer destination, GPUSize64 destinationOffset );
  undefined writeTimestamp( GPUQuerySet querySet, GPUSize32 queryIndex );
};

[Exposed=(Window,DedicatedWorker), Serializable, SecureContext]
interface GPUCompilationInfo {
  readonly attribute FrozenArray<GPUCompilationMessage> messages;
};

[Exposed=(Window,DedicatedWorker), Serializable, SecureContext]
interface GPUCompilationMessage {
  readonly attribute unsigned long long length;
  readonly attribute unsigned long long lineNum;
  readonly attribute unsigned long long linePos;
  readonly attribute DOMString message;
  readonly attribute unsigned long long offset;
  readonly attribute GPUCompilationMessageType type;
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUComputePassEncoder {
  undefined beginPipelineStatisticsQuery( GPUQuerySet querySet, GPUSize32 queryIndex );
  undefined dispatch( GPUSize32 x, optional GPUSize32 y = 1, optional GPUSize32 z = 1 );
  undefined dispatchIndirect( GPUBuffer indirectBuffer, GPUSize64 indirectOffset );
  undefined endPass();
  undefined endPipelineStatisticsQuery();
  undefined setPipeline( GPUComputePipeline pipeline );
  undefined writeTimestamp( GPUQuerySet querySet, GPUSize32 queryIndex );
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUComputePipeline {
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUDevice : EventTarget {
  [SameObject]
  readonly attribute GPUSupportedFeatures features;
  [SameObject]
  readonly attribute GPUSupportedLimits limits;
  [SameObject]
  readonly attribute GPUQueue queue;
  GPUBindGroup createBindGroup( GPUBindGroupDescriptor descriptor );
  GPUBindGroupLayout createBindGroupLayout( GPUBindGroupLayoutDescriptor descriptor );
  GPUBuffer createBuffer( GPUBufferDescriptor descriptor );
  GPUCommandEncoder createCommandEncoder( optional GPUCommandEncoderDescriptor descriptor = {} );
  GPUComputePipeline createComputePipeline( GPUComputePipelineDescriptor descriptor );
  Promise<GPUComputePipeline> createComputePipelineAsync( GPUComputePipelineDescriptor descriptor );
  GPUPipelineLayout createPipelineLayout( GPUPipelineLayoutDescriptor descriptor );
  GPUQuerySet createQuerySet( GPUQuerySetDescriptor descriptor );
  GPURenderBundleEncoder createRenderBundleEncoder( GPURenderBundleEncoderDescriptor descriptor );
  GPURenderPipeline createRenderPipeline( GPURenderPipelineDescriptor descriptor );
  Promise<GPURenderPipeline> createRenderPipelineAsync( GPURenderPipelineDescriptor descriptor );
  GPUSampler createSampler( optional GPUSamplerDescriptor descriptor = {} );
  GPUShaderModule createShaderModule( GPUShaderModuleDescriptor descriptor );
  GPUTexture createTexture( GPUTextureDescriptor descriptor );
  undefined destroy();
  GPUExternalTexture importExternalTexture( GPUExternalTextureDescriptor descriptor );
};

[Exposed=(Window,DedicatedWorker)]
interface GPUDeviceLostInfo {
  readonly attribute DOMString message;
  readonly attribute ( GPUDeviceLostReason or undefined ) reason;
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUExternalTexture {
};

[Exposed=(Window,DedicatedWorker)]
interface GPUOutOfMemoryError {
  constructor();
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUPipelineLayout {
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUQuerySet {
  undefined destroy();
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUQueue {
  undefined copyExternalImageToTexture( GPUImageCopyExternalImage source, GPUImageCopyTextureTagged destination, GPUExtent3D copySize );
  Promise<undefined> onSubmittedWorkDone();
  undefined submit( sequence<GPUCommandBuffer> commandBuffers );
  undefined writeBuffer( GPUBuffer buffer, GPUSize64 bufferOffset, [AllowShared] BufferSource data, optional GPUSize64 dataOffset = 0, optional GPUSize64 size );
  undefined writeTexture( GPUImageCopyTexture destination, [AllowShared] BufferSource data, GPUImageDataLayout dataLayout, GPUExtent3D size );
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPURenderBundle {
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPURenderBundleEncoder {
  GPURenderBundle finish( optional GPURenderBundleDescriptor descriptor = {} );
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPURenderPassEncoder {
  undefined beginOcclusionQuery( GPUSize32 queryIndex );
  undefined beginPipelineStatisticsQuery( GPUQuerySet querySet, GPUSize32 queryIndex );
  undefined endOcclusionQuery();
  undefined endPass();
  undefined endPipelineStatisticsQuery();
  undefined executeBundles( sequence<GPURenderBundle> bundles );
  undefined setBlendConstant( GPUColor color );
  undefined setScissorRect( GPUIntegerCoordinate x, GPUIntegerCoordinate y, GPUIntegerCoordinate width, GPUIntegerCoordinate height );
  undefined setStencilReference( GPUStencilValue reference );
  undefined setViewport( float x, float y, float width, float height, float minDepth, float maxDepth );
  undefined writeTimestamp( GPUQuerySet querySet, GPUSize32 queryIndex );
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPURenderPipeline {
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUSampler {
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUShaderModule {
  Promise<GPUCompilationInfo> compilationInfo();
};

[Exposed=(Window,DedicatedWorker)]
interface GPUSupportedFeatures {
  readonly setlike<DOMString>;
};

[Exposed=(Window,DedicatedWorker)]
interface GPUSupportedLimits {
  readonly attribute unsigned long maxBindGroups;
  readonly attribute unsigned long maxComputeInvocationsPerWorkgroup;
  readonly attribute unsigned long maxComputeWorkgroupSizeX;
  readonly attribute unsigned long maxComputeWorkgroupSizeY;
  readonly attribute unsigned long maxComputeWorkgroupSizeZ;
  readonly attribute unsigned long maxComputeWorkgroupStorageSize;
  readonly attribute unsigned long maxComputeWorkgroupsPerDimension;
  readonly attribute unsigned long maxDynamicStorageBuffersPerPipelineLayout;
  readonly attribute unsigned long maxDynamicUniformBuffersPerPipelineLayout;
  readonly attribute unsigned long maxInterStageShaderComponents;
  readonly attribute unsigned long maxSampledTexturesPerShaderStage;
  readonly attribute unsigned long maxSamplersPerShaderStage;
  readonly attribute unsigned long long maxStorageBufferBindingSize;
  readonly attribute unsigned long maxStorageBuffersPerShaderStage;
  readonly attribute unsigned long maxStorageTexturesPerShaderStage;
  readonly attribute unsigned long maxTextureArrayLayers;
  readonly attribute unsigned long maxTextureDimension1D;
  readonly attribute unsigned long maxTextureDimension2D;
  readonly attribute unsigned long maxTextureDimension3D;
  readonly attribute unsigned long long maxUniformBufferBindingSize;
  readonly attribute unsigned long maxUniformBuffersPerShaderStage;
  readonly attribute unsigned long maxVertexAttributes;
  readonly attribute unsigned long maxVertexBufferArrayStride;
  readonly attribute unsigned long maxVertexBuffers;
  readonly attribute unsigned long minStorageBufferOffsetAlignment;
  readonly attribute unsigned long minUniformBufferOffsetAlignment;
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUTexture {
  GPUTextureView createView( optional GPUTextureViewDescriptor descriptor = {} );
  undefined destroy();
};

[Exposed=(Window,DedicatedWorker), SecureContext]
interface GPUTextureView {
};

[Exposed=(Window,DedicatedWorker)]
interface GPUUncapturedErrorEvent : Event {
  [SameObject]
  readonly attribute GPUError error;
  constructor( DOMString type, GPUUncapturedErrorEventInit gpuUncapturedErrorEventInitDict );
};

[Exposed=(Window,DedicatedWorker)]
interface GPUValidationError {
  readonly attribute DOMString message;
  constructor( DOMString message );
};

partial interface GPUDevice {
  readonly attribute Promise<GPUDeviceLostInfo> lost;
};

partial interface GPUDevice {
  Promise<GPUError?> popErrorScope();
  undefined pushErrorScope( GPUErrorFilter filter );
};

partial interface GPUDevice {
  [Exposed=(Window,DedicatedWorker)]
  attribute EventHandler onuncapturederror;
};

GPUBindGroup includes GPUObjectBase;

GPUBindGroupLayout includes GPUObjectBase;

GPUBuffer includes GPUObjectBase;

GPUCommandBuffer includes GPUObjectBase;

GPUCommandEncoder includes GPUObjectBase;

GPUComputePassEncoder includes GPUObjectBase;

GPUComputePassEncoder includes GPUProgrammablePassEncoder;

GPUComputePipeline includes GPUObjectBase;

GPUComputePipeline includes GPUPipelineBase;

GPUDevice includes GPUObjectBase;

GPUExternalTexture includes GPUObjectBase;

GPUPipelineLayout includes GPUObjectBase;

GPUQuerySet includes GPUObjectBase;

GPUQueue includes GPUObjectBase;

GPURenderBundle includes GPUObjectBase;

GPURenderBundleEncoder includes GPUObjectBase;

GPURenderBundleEncoder includes GPUProgrammablePassEncoder;

GPURenderBundleEncoder includes GPURenderEncoderBase;

GPURenderPassEncoder includes GPUObjectBase;

GPURenderPassEncoder includes GPUProgrammablePassEncoder;

GPURenderPassEncoder includes GPURenderEncoderBase;

GPURenderPipeline includes GPUObjectBase;

GPURenderPipeline includes GPUPipelineBase;

GPUSampler includes GPUObjectBase;

GPUShaderModule includes GPUObjectBase;

GPUTexture includes GPUObjectBase;

GPUTextureView includes GPUObjectBase;

Navigator includes NavigatorGPU;

WorkerNavigator includes NavigatorGPU;
