enum XRHitTestTrackableType {
  "mesh",
  "plane",
  "point"
};

dictionary XRHitTestOptionsInit {
  required XRSpace space;
  FrozenArray<XRHitTestTrackableType> entityTypes;
  XRRay offsetRay;
};

dictionary XRRayDirectionInit {
  double w = 0;
  double x = 0;
  double y = 0;
  double z = -1;
};

dictionary XRTransientInputHitTestOptionsInit {
  required DOMString profile;
  FrozenArray<XRHitTestTrackableType> entityTypes;
  XRRay offsetRay;
};

[SecureContext, Exposed=Window]
interface XRHitTestResult {
  XRPose? getPose( XRSpace baseSpace );
};

[SecureContext, Exposed=Window]
interface XRHitTestSource {
  undefined cancel();
};

[SecureContext, Exposed=Window]
interface XRRay {
  [SameObject]
  readonly attribute DOMPointReadOnly direction;
  [SameObject]
  readonly attribute Float32Array matrix;
  [SameObject]
  readonly attribute DOMPointReadOnly origin;
  constructor( optional DOMPointInit origin = {}, optional XRRayDirectionInit direction = {} );
  constructor( XRRigidTransform transform );
};

[SecureContext, Exposed=Window]
interface XRTransientInputHitTestResult {
  [SameObject]
  readonly attribute XRInputSource inputSource;
  readonly attribute FrozenArray<XRHitTestResult> results;
};

[SecureContext, Exposed=Window]
interface XRTransientInputHitTestSource {
  undefined cancel();
};

partial interface XRFrame {
  FrozenArray<XRHitTestResult> getHitTestResults( XRHitTestSource hitTestSource );
  FrozenArray<XRTransientInputHitTestResult> getHitTestResultsForTransientInput( XRTransientInputHitTestSource hitTestSource );
};

partial interface XRSession {
  Promise<XRHitTestSource> requestHitTestSource( XRHitTestOptionsInit options );
  Promise<XRTransientInputHitTestSource> requestHitTestSourceForTransientInput( XRTransientInputHitTestOptionsInit options );
};
