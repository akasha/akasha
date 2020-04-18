[Exposed=Window]
interface HTMLPictureElement : HTMLElement {
  [HTMLConstructor] constructor();
};

[Exposed=Window]
interface HTMLSourceElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute USVString src;
  [CEReactions] attribute DOMString type;
  [CEReactions] attribute USVString srcset;
  [CEReactions] attribute DOMString sizes;
  [CEReactions] attribute DOMString media;
};

[Exposed=Window,
 NamedConstructor=Image(optional unsigned long width, optional unsigned long height)]
interface HTMLImageElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute DOMString alt;
  [CEReactions] attribute USVString src;
  [CEReactions] attribute USVString srcset;
  [CEReactions] attribute DOMString sizes;
  [CEReactions] attribute DOMString? crossOrigin;
  [CEReactions] attribute DOMString useMap;
  [CEReactions] attribute boolean isMap;
  [CEReactions] attribute unsigned long width;
  [CEReactions] attribute unsigned long height;
  readonly attribute unsigned long naturalWidth;
  readonly attribute unsigned long naturalHeight;
  readonly attribute boolean complete;
  readonly attribute USVString currentSrc;
  [CEReactions] attribute DOMString referrerPolicy;
  [CEReactions] attribute DOMString decoding;
  [CEReactions] attribute DOMString loading;

  Promise<void> decode();
};