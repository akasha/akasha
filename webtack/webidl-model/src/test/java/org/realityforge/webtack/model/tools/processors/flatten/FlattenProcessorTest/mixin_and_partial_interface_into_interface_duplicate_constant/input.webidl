partial interface mixin DocumentOrShadowRoot {
  [LegacyLenientSetter]
  readonly attribute Element? fullscreenElement;
};

partial interface Document {
  readonly attribute DocumentTimeline timeline;
  sequence<Animation> getAnimations();
};

partial interface Document {
  const GLenum COMPRESSED_RGBA_S3TC_DXT1_EXT = 0x83F1;
  const GLenum COMPRESSED_RGBA_S3TC_DXT3_EXT = 0x83F2;
  readonly attribute SVGSVGElement? rootElement;
};

partial interface mixin DocumentOrShadowRoot {
  const GLenum COMPRESSED_RGBA_S3TC_DXT1_EXT = 0x83F1;
  const GLenum COMPRESSED_RGBA_S3TC_DXT3_EXT = 0x83F2;
};

interface mixin DocumentOrShadowRoot {
};

Document includes DocumentOrShadowRoot;

[Exposed=Window]
interface Document : Node {
};
