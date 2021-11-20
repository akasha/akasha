enum XRReflectionFormat {
  "rgba16f",
  "srgba8"
};

dictionary XRLightProbeInit {
  XRReflectionFormat reflectionFormat = "srgba8";
};

[SecureContext, Exposed=Window]
interface XRLightEstimate {
  readonly attribute DOMPointReadOnly primaryLightDirection;
  readonly attribute DOMPointReadOnly primaryLightIntensity;
  readonly attribute Float32Array sphericalHarmonicsCoefficients;
};

[SecureContext, Exposed=Window]
interface XRLightProbe : EventTarget {
  readonly attribute XRSpace probeSpace;
  attribute EventHandler onreflectionchange;
};

partial interface XRFrame {
  XRLightEstimate? getLightEstimate( XRLightProbe lightProbe );
};

partial interface XRSession {
  readonly attribute XRReflectionFormat preferredReflectionFormat;
  Promise<XRLightProbe> requestLightProbe( optional XRLightProbeInit options = {} );
};

partial interface XRWebGLBinding {
  WebGLTexture? getReflectionCubeMap( XRLightProbe lightProbe );
};
