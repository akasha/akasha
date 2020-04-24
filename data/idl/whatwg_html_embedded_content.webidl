[Exposed=Window, LegacyFactoryFunction=Image( optional unsigned long width, optional unsigned long height )]
interface HTMLImageElement : HTMLElement {
  readonly attribute boolean complete;
  readonly attribute USVString currentSrc;
  readonly attribute unsigned long naturalHeight;
  readonly attribute unsigned long naturalWidth;
  [CEReactions]
  attribute DOMString alt;
  [CEReactions]
  attribute DOMString? crossOrigin;
  [CEReactions]
  attribute DOMString decoding;
  [CEReactions]
  attribute unsigned long height;
  [CEReactions]
  attribute boolean isMap;
  [CEReactions]
  attribute DOMString loading;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute DOMString sizes;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute USVString srcset;
  [CEReactions]
  attribute DOMString useMap;
  [CEReactions]
  attribute unsigned long width;
  [HTMLConstructor]
  constructor();
  Promise<void> decode();
};

[Exposed=Window]
interface HTMLPictureElement : HTMLElement {
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLSourceElement : HTMLElement {
  [CEReactions]
  attribute DOMString media;
  [CEReactions]
  attribute DOMString sizes;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute USVString srcset;
  [CEReactions]
  attribute DOMString type;
  [HTMLConstructor]
  constructor();
};
