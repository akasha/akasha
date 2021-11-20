enum XRDepthDataFormat {
  "float32",
  "luminance-alpha"
};

enum XRDepthUsage {
  "cpu-optimized",
  "gpu-optimized"
};

dictionary XRDepthStateInit {
  required sequence<XRDepthUsage> usagePreference;
  required sequence<XRDepthDataFormat> dataFormatPreference;
};

partial dictionary XRSessionInit {
  XRDepthStateInit depthSensing;
};

[Exposed=Window]
interface XRCPUDepthInformation : XRDepthInformation {
  [SameObject]
  readonly attribute ArrayBuffer data;
  float getDepthInMeters( float x, float y );
};

[SecureContext, Exposed=Window]
interface XRDepthInformation {
  readonly attribute unsigned long height;
  [SameObject]
  readonly attribute XRRigidTransform normDepthBufferFromNormView;
  readonly attribute float rawValueToMeters;
  readonly attribute unsigned long width;
};

[Exposed=Window]
interface XRWebGLDepthInformation : XRDepthInformation {
  [SameObject]
  readonly attribute WebGLTexture texture;
};

partial interface XRFrame {
  XRCPUDepthInformation? getDepthInformation( XRView view );
};

partial interface XRSession {
  readonly attribute XRDepthDataFormat depthDataFormat;
  readonly attribute XRDepthUsage depthUsage;
};

partial interface XRWebGLBinding {
  XRWebGLDepthInformation? getDepthInformation( XRView view );
};
