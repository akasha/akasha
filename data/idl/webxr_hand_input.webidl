enum XRHandJoint {
  "index-finger-metacarpal",
  "index-finger-phalanx-distal",
  "index-finger-phalanx-intermediate",
  "index-finger-phalanx-proximal",
  "index-finger-tip",
  "middle-finger-metacarpal",
  "middle-finger-phalanx-distal",
  "middle-finger-phalanx-intermediate",
  "middle-finger-phalanx-proximal",
  "middle-finger-tip",
  "pinky-finger-metacarpal",
  "pinky-finger-phalanx-distal",
  "pinky-finger-phalanx-intermediate",
  "pinky-finger-phalanx-proximal",
  "pinky-finger-tip",
  "ring-finger-metacarpal",
  "ring-finger-phalanx-distal",
  "ring-finger-phalanx-intermediate",
  "ring-finger-phalanx-proximal",
  "ring-finger-tip",
  "thumb-metacarpal",
  "thumb-phalanx-distal",
  "thumb-phalanx-proximal",
  "thumb-tip",
  "wrist"
};

[Exposed=Window]
interface XRHand {
  iterable<XRHandJoint, XRJointSpace>;
  readonly attribute unsigned long size;
  XRJointSpace get( XRHandJoint key );
};

[Exposed=Window]
interface XRJointPose : XRPose {
  readonly attribute float radius;
};

[Exposed=Window]
interface XRJointSpace : XRSpace {
  readonly attribute XRHandJoint jointName;
};

partial interface XRFrame {
  boolean fillJointRadii( sequence<XRJointSpace> jointSpaces, Float32Array radii );
  boolean fillPoses( sequence<XRSpace> spaces, XRSpace baseSpace, Float32Array transforms );
  XRJointPose? getJointPose( XRJointSpace joint, XRSpace baseSpace );
};

partial interface XRInputSource {
  [SameObject]
  readonly attribute XRHand? hand;
};
