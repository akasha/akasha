enum XREye {
  "left",
  "none",
  "right"
};

enum XRHandedness {
  "left",
  "none",
  "right"
};

enum XRReferenceSpaceType {
  "bounded-floor",
  "local",
  "local-floor",
  "unbounded",
  "viewer"
};

enum XRSessionMode {
  "immersive-vr",
  "inline"
};

enum XRTargetRayMode {
  "gaze",
  "screen",
  "tracked-pointer"
};

enum XRVisibilityState {
  "hidden",
  "visible",
  "visible-blurred"
};

typedef ( WebGLRenderingContext or WebGL2RenderingContext ) XRWebGLRenderingContext;

callback XRFrameRequestCallback = void ( DOMHighResTimeStamp time, XRFrame frame );

dictionary XRInputSourceEventInit : EventInit {
  required XRFrame frame;
  required XRInputSource inputSource;
};

dictionary XRInputSourcesChangeEventInit : EventInit {
  required FrozenArray<XRInputSource> added;
  required FrozenArray<XRInputSource> removed;
  required XRSession session;
};

dictionary XRReferenceSpaceEventInit : EventInit {
  required XRReferenceSpace referenceSpace;
  XRRigidTransform transform;
};

dictionary XRRenderStateInit {
  XRWebGLLayer? baseLayer;
  double depthFar;
  double depthNear;
  double inlineVerticalFieldOfView;
};

dictionary XRSessionEventInit : EventInit {
  required XRSession session;
};

dictionary XRSessionInit {
  sequence<any> optionalFeatures;
  sequence<any> requiredFeatures;
};

dictionary XRWebGLLayerInit {
  boolean alpha = true;
  boolean antialias = true;
  boolean depth = true;
  double framebufferScaleFactor = 1.0;
  boolean ignoreDepthValues = false;
  boolean stencil = false;
};

partial dictionary WebGLContextAttributes {
  boolean xrCompatible = null;
};

partial interface mixin WebGLRenderingContextBase {
  Promise<void> makeXRCompatible();
};

[SecureContext, Exposed=Window]
interface XR : EventTarget {
  attribute EventHandler ondevicechange;
  Promise<boolean> isSessionSupported( XRSessionMode mode );
  [NewObject]
  Promise<XRSession> requestSession( XRSessionMode mode, optional XRSessionInit options = {} );
};

[SecureContext, Exposed=Window]
interface XRBoundedReferenceSpace : XRReferenceSpace {
  readonly attribute FrozenArray<DOMPointReadOnly> boundsGeometry;
};

[SecureContext, Exposed=Window]
interface XRFrame {
  [SameObject]
  readonly attribute XRSession session;
  XRPose? getPose( XRSpace space, XRSpace baseSpace );
  XRViewerPose? getViewerPose( XRReferenceSpace referenceSpace );
};

[SecureContext, Exposed=Window]
interface XRInputSource {
  [SameObject]
  readonly attribute XRSpace? gripSpace;
  readonly attribute XRHandedness handedness;
  [SameObject]
  readonly attribute FrozenArray<DOMString> profiles;
  readonly attribute XRTargetRayMode targetRayMode;
  [SameObject]
  readonly attribute XRSpace targetRaySpace;
};

[SecureContext, Exposed=Window]
interface XRInputSourceArray {
  iterable<XRInputSource>;
  readonly attribute unsigned long length;
  getter XRInputSource ( unsigned long index );
};

[SecureContext, Exposed=Window]
interface XRInputSourceEvent : Event {
  [SameObject]
  readonly attribute XRFrame frame;
  [SameObject]
  readonly attribute XRInputSource inputSource;
  constructor( DOMString type, XRInputSourceEventInit eventInitDict );
};

[SecureContext, Exposed=Window]
interface XRInputSourcesChangeEvent : Event {
  [SameObject]
  readonly attribute FrozenArray<XRInputSource> added;
  [SameObject]
  readonly attribute FrozenArray<XRInputSource> removed;
  [SameObject]
  readonly attribute XRSession session;
  constructor( DOMString type, XRInputSourcesChangeEventInit eventInitDict );
};

[SecureContext, Exposed=Window]
interface XRPose {
  readonly attribute boolean emulatedPosition;
  [SameObject]
  readonly attribute XRRigidTransform transform;
};

[SecureContext, Exposed=Window]
interface XRReferenceSpace : XRSpace {
  attribute EventHandler onreset;
  [NewObject]
  XRReferenceSpace getOffsetReferenceSpace( XRRigidTransform originOffset );
};

[SecureContext, Exposed=Window]
interface XRReferenceSpaceEvent : Event {
  [SameObject]
  readonly attribute XRReferenceSpace referenceSpace;
  [SameObject]
  readonly attribute XRRigidTransform? transform;
  constructor( DOMString type, XRReferenceSpaceEventInit eventInitDict );
};

[SecureContext, Exposed=Window]
interface XRRenderState {
  readonly attribute XRWebGLLayer? baseLayer;
  readonly attribute double depthFar;
  readonly attribute double depthNear;
  readonly attribute double? inlineVerticalFieldOfView;
};

[SecureContext, Exposed=Window]
interface XRRigidTransform {
  [SameObject]
  readonly attribute XRRigidTransform inverse;
  readonly attribute Float32Array matrix;
  [SameObject]
  readonly attribute DOMPointReadOnly orientation;
  [SameObject]
  readonly attribute DOMPointReadOnly position;
  constructor( optional DOMPointInit position = {}, optional DOMPointInit orientation = {} );
};

[SecureContext, Exposed=Window]
interface XRSession : EventTarget {
  [SameObject]
  readonly attribute XRInputSourceArray inputSources;
  [SameObject]
  readonly attribute XRRenderState renderState;
  readonly attribute XRVisibilityState visibilityState;
  attribute EventHandler onend;
  attribute EventHandler oninputsourceschange;
  attribute EventHandler onselect;
  attribute EventHandler onselectend;
  attribute EventHandler onselectstart;
  attribute EventHandler onvisibilitychange;
  void cancelAnimationFrame( long handle );
  Promise<void> end();
  long requestAnimationFrame( XRFrameRequestCallback callback );
  [NewObject]
  Promise<XRReferenceSpace> requestReferenceSpace( XRReferenceSpaceType type );
  void updateRenderState( optional XRRenderStateInit state = {} );
};

[SecureContext, Exposed=Window]
interface XRSessionEvent : Event {
  [SameObject]
  readonly attribute XRSession session;
  constructor( DOMString type, XRSessionEventInit eventInitDict );
};

[SecureContext, Exposed=Window]
interface XRSpace : EventTarget {
};

[SecureContext, Exposed=Window]
interface XRView {
  readonly attribute XREye eye;
  readonly attribute Float32Array projectionMatrix;
  [SameObject]
  readonly attribute XRRigidTransform transform;
};

[SecureContext, Exposed=Window]
interface XRViewerPose : XRPose {
  [SameObject]
  readonly attribute FrozenArray<XRView> views;
};

[SecureContext, Exposed=Window]
interface XRViewport {
  readonly attribute long height;
  readonly attribute long width;
  readonly attribute long x;
  readonly attribute long y;
};

[SecureContext, Exposed=Window]
interface XRWebGLLayer {
  readonly attribute boolean antialias;
  [SameObject]
  readonly attribute WebGLFramebuffer framebuffer;
  readonly attribute unsigned long framebufferHeight;
  readonly attribute unsigned long framebufferWidth;
  readonly attribute boolean ignoreDepthValues;
  static double getNativeFramebufferScaleFactor( XRSession session );
  constructor( XRSession session, XRWebGLRenderingContext context, optional XRWebGLLayerInit layerInit = {} );
  XRViewport? getViewport( XRView view );
};

partial interface Navigator {
  [SecureContext, SameObject]
  readonly attribute XR xr;
};
