dictionary FocusOptions {
  boolean preventScroll = false;
};

interface mixin ElementContentEditable {
  readonly attribute boolean isContentEditable;
  [CEReactions]
  attribute DOMString contentEditable;
  [CEReactions]
  attribute DOMString enterKeyHint;
  [CEReactions]
  attribute DOMString inputMode;
};
