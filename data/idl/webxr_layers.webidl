enum XRLayerLayout {
  "default",
  "mono",
  "stereo",
  "stereo-left-right",
  "stereo-top-bottom"
};

enum XRTextureType {
  "texture",
  "texture-array"
};

dictionary XRCubeLayerInit : XRLayerInit {
  DOMPointReadOnly? orientation;
};

dictionary XRCylinderLayerInit : XRLayerInit {
  float aspectRatio = 2.0;
  float centralAngle = 0.78539;
  float radius = 2.0;
  XRTextureType textureType = "texture";
  XRRigidTransform? transform;
};

dictionary XREquirectLayerInit : XRLayerInit {
  float centralHorizontalAngle = 6.28318;
  float lowerVerticalAngle = -1.570795;
  float radius = 0;
  XRTextureType textureType = "texture";
  XRRigidTransform? transform;
  float upperVerticalAngle = 1.570795;
};

dictionary XRLayerEventInit : EventInit {
  required XRLayer layer;
};

dictionary XRLayerInit {
  required XRSpace space;
  required unsigned long viewPixelWidth;
  required unsigned long viewPixelHeight;
  GLenum colorFormat = 0x1908;
  GLenum? depthFormat;
  boolean isStatic = false;
  XRLayerLayout layout = "mono";
  unsigned long mipLevels = 1;
};

dictionary XRMediaCylinderLayerInit : XRMediaLayerInit {
  float? aspectRatio;
  float centralAngle = 0.78539;
  float radius = 2.0;
  XRRigidTransform? transform;
};

dictionary XRMediaEquirectLayerInit : XRMediaLayerInit {
  float centralHorizontalAngle = 6.28318;
  float lowerVerticalAngle = -1.570795;
  float radius = 0.0;
  XRRigidTransform? transform;
  float upperVerticalAngle = 1.570795;
};

dictionary XRMediaLayerInit {
  required XRSpace space;
  boolean invertStereo = false;
  XRLayerLayout layout = "mono";
};

dictionary XRMediaQuadLayerInit : XRMediaLayerInit {
  float? height;
  XRRigidTransform? transform;
  float? width;
};

dictionary XRProjectionLayerInit {
  GLenum colorFormat = 0x1908;
  GLenum depthFormat = 0x1902;
  double scaleFactor = 1.0;
  XRTextureType textureType = "texture";
};

dictionary XRQuadLayerInit : XRLayerInit {
  float height = 1.0;
  XRTextureType textureType = "texture";
  XRRigidTransform? transform;
  float width = 1.0;
};

[Exposed=Window]
interface XRCompositionLayer : XRLayer {
  readonly attribute XRLayerLayout layout;
  readonly attribute unsigned long mipLevels;
  readonly attribute boolean needsRedraw;
  attribute boolean blendTextureSourceAlpha;
  attribute boolean? chromaticAberrationCorrection;
  undefined destroy();
};

[Exposed=Window]
interface XRCubeLayer : XRCompositionLayer {
  attribute EventHandler onredraw;
  attribute DOMPointReadOnly orientation;
  attribute XRSpace space;
};

[Exposed=Window]
interface XRCylinderLayer : XRCompositionLayer {
  attribute float aspectRatio;
  attribute float centralAngle;
  attribute EventHandler onredraw;
  attribute float radius;
  attribute XRSpace space;
  attribute XRRigidTransform transform;
};

[Exposed=Window]
interface XREquirectLayer : XRCompositionLayer {
  attribute float centralHorizontalAngle;
  attribute float lowerVerticalAngle;
  attribute EventHandler onredraw;
  attribute float radius;
  attribute XRSpace space;
  attribute XRRigidTransform transform;
  attribute float upperVerticalAngle;
};

[SecureContext, Exposed=Window]
interface XRLayerEvent : Event {
  [SameObject]
  readonly attribute XRLayer layer;
  constructor( DOMString type, XRLayerEventInit eventInitDict );
};

[Exposed=Window]
interface XRMediaBinding {
  constructor( XRSession session );
  XRCylinderLayer createCylinderLayer( HTMLVideoElement video, optional XRMediaCylinderLayerInit init = {} );
  XREquirectLayer createEquirectLayer( HTMLVideoElement video, optional XRMediaEquirectLayerInit init = {} );
  XRQuadLayer createQuadLayer( HTMLVideoElement video, optional XRMediaQuadLayerInit init = {} );
};

[Exposed=Window]
interface XRProjectionLayer : XRCompositionLayer {
  readonly attribute boolean ignoreDepthValues;
  readonly attribute unsigned long textureArrayLength;
  readonly attribute unsigned long textureHeight;
  readonly attribute unsigned long textureWidth;
  attribute float? fixedFoveation;
};

[Exposed=Window]
interface XRQuadLayer : XRCompositionLayer {
  attribute float height;
  attribute EventHandler onredraw;
  attribute XRSpace space;
  attribute XRRigidTransform transform;
  attribute float width;
};

[Exposed=Window]
interface XRSubImage {
  [SameObject]
  readonly attribute XRViewport viewport;
};

[Exposed=Window]
interface XRWebGLBinding {
  readonly attribute double nativeProjectionScaleFactor;
  readonly attribute boolean usesDepthValues;
  constructor( XRSession session, XRWebGLRenderingContext context );
  XRCubeLayer createCubeLayer( optional XRCubeLayerInit init = {} );
  XRCylinderLayer createCylinderLayer( optional XRCylinderLayerInit init = {} );
  XREquirectLayer createEquirectLayer( optional XREquirectLayerInit init = {} );
  XRProjectionLayer createProjectionLayer( optional XRProjectionLayerInit init = {} );
  XRQuadLayer createQuadLayer( optional XRQuadLayerInit init = {} );
  XRWebGLSubImage getSubImage( XRCompositionLayer layer, XRFrame frame, optional XREye eye = "none" );
  XRWebGLSubImage getViewSubImage( XRProjectionLayer layer, XRView view );
};

[Exposed=Window]
interface XRWebGLSubImage : XRSubImage {
  [SameObject]
  readonly attribute WebGLTexture colorTexture;
  [SameObject]
  readonly attribute WebGLTexture? depthStencilTexture;
  readonly attribute unsigned long? imageIndex;
  readonly attribute unsigned long textureHeight;
  readonly attribute unsigned long textureWidth;
};

[SecureContext, Exposed=Window]
partial interface XRRenderState {
  readonly attribute FrozenArray<XRLayer> layers;
};
