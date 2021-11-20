enum XREnvironmentBlendMode {
  "additive",
  "alpha-blend",
  "opaque"
};

enum XRInteractionMode {
  "screen-space",
  "world-space"
};

partial interface XRSession {
  readonly attribute XREnvironmentBlendMode environmentBlendMode;
};

partial interface XRSession {
  readonly attribute XRInteractionMode interactionMode;
};

partial interface XRView {
  readonly attribute boolean isFirstPersonObserver;
};
