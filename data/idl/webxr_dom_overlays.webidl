enum XRDOMOverlayType {
  "floating",
  "head-locked",
  "screen"
};

dictionary XRDOMOverlayInit {
  required Element root;
};

dictionary XRDOMOverlayState {
  XRDOMOverlayType type;
};

partial dictionary XRSessionInit {
  XRDOMOverlayInit? domOverlay;
};

partial interface mixin GlobalEventHandlers {
  attribute EventHandler onbeforexrselect;
};

partial interface XRSession {
  readonly attribute XRDOMOverlayState? domOverlayState;
};
