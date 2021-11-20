[SecureContext, Exposed=Window]
interface XRAnchor {
  readonly attribute XRSpace anchorSpace;
  undefined delete();
};

[Exposed=Window]
interface XRAnchorSet {
  readonly setlike<XRAnchor>;
};

partial interface XRFrame {
  Promise<XRAnchor> createAnchor( XRRigidTransform pose, XRSpace space );
};

partial interface XRFrame {
  [SameObject]
  readonly attribute XRAnchorSet trackedAnchors;
};

partial interface XRHitTestResult {
  Promise<XRAnchor> createAnchor();
};
