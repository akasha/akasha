[Exposed=Window]
interface HTMLMarqueeElement : HTMLElement {
  [CEReactions]
  attribute DOMString behavior;
  [CEReactions]
  attribute DOMString bgColor;
  [CEReactions]
  attribute DOMString direction;
  [CEReactions]
  attribute DOMString height;
  [CEReactions]
  attribute unsigned long hspace;
  [CEReactions]
  attribute long loop;
  attribute EventHandler onbounce;
  attribute EventHandler onfinish;
  attribute EventHandler onstart;
  [CEReactions]
  attribute unsigned long scrollAmount;
  [CEReactions]
  attribute unsigned long scrollDelay;
  [CEReactions]
  attribute boolean trueSpeed;
  [CEReactions]
  attribute unsigned long vspace;
  [CEReactions]
  attribute DOMString width;
  [HTMLConstructor]
  constructor();
  void start();
  void stop();
};

[Exposed=Window]
interface HTMLFrameSetElement : HTMLElement {
  [CEReactions]
  attribute DOMString cols;
  [CEReactions]
  attribute DOMString rows;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLDirectoryElement : HTMLElement {
  [CEReactions]
  attribute boolean compact;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface External {
  void AddSearchProvider();
  void IsSearchProviderInstalled();
};

[Exposed=Window]
interface HTMLFontElement : HTMLElement {
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString color;
  [CEReactions]
  attribute DOMString face;
  [CEReactions]
  attribute DOMString size;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLFrameElement : HTMLElement {
  readonly attribute Document? contentDocument;
  readonly attribute WindowProxy? contentWindow;
  [CEReactions]
  attribute DOMString frameBorder;
  [CEReactions]
  attribute USVString longDesc;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString marginHeight;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString marginWidth;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute boolean noResize;
  [CEReactions]
  attribute DOMString scrolling;
  [CEReactions]
  attribute USVString src;
  [HTMLConstructor]
  constructor();
};

partial interface HTMLTableRowElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString bgColor;
  [CEReactions]
  attribute DOMString ch;
  [CEReactions]
  attribute DOMString chOff;
  [CEReactions]
  attribute DOMString vAlign;
};

partial interface HTMLOListElement {
  [CEReactions]
  attribute boolean compact;
};

partial interface HTMLIFrameElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString frameBorder;
  [CEReactions]
  attribute USVString longDesc;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString marginHeight;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString marginWidth;
  [CEReactions]
  attribute DOMString scrolling;
};

partial interface HTMLInputElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString useMap;
};

partial interface Document {
  [SameObject]
  readonly attribute HTMLAllCollection all;
  [SameObject]
  readonly attribute HTMLCollection anchors;
  [SameObject]
  readonly attribute HTMLCollection applets;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString alinkColor;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString bgColor;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString fgColor;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString linkColor;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString vlinkColor;
  void captureEvents();
  void clear();
  void releaseEvents();
};

partial interface HTMLParamElement {
  [CEReactions]
  attribute DOMString type;
  [CEReactions]
  attribute DOMString valueType;
};

partial interface HTMLAreaElement {
  [CEReactions]
  attribute boolean noHref;
};

partial interface HTMLTableSectionElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString ch;
  [CEReactions]
  attribute DOMString chOff;
  [CEReactions]
  attribute DOMString vAlign;
};

partial interface HTMLImageElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString border;
  [CEReactions]
  attribute unsigned long hspace;
  [CEReactions]
  attribute USVString longDesc;
  [CEReactions]
  attribute USVString lowsrc;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute unsigned long vspace;
};

partial interface HTMLTableColElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString ch;
  [CEReactions]
  attribute DOMString chOff;
  [CEReactions]
  attribute DOMString vAlign;
  [CEReactions]
  attribute DOMString width;
};

partial interface HTMLUListElement {
  [CEReactions]
  attribute boolean compact;
  [CEReactions]
  attribute DOMString type;
};

partial interface HTMLTableElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString bgColor;
  [CEReactions]
  attribute DOMString border;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString cellPadding;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString cellSpacing;
  [CEReactions]
  attribute DOMString frame;
  [CEReactions]
  attribute DOMString rules;
  [CEReactions]
  attribute DOMString summary;
  [CEReactions]
  attribute DOMString width;
};

partial interface HTMLMetaElement {
  [CEReactions]
  attribute DOMString scheme;
};

partial interface HTMLTableCellElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString axis;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString bgColor;
  [CEReactions]
  attribute DOMString ch;
  [CEReactions]
  attribute DOMString chOff;
  [CEReactions]
  attribute DOMString height;
  [CEReactions]
  attribute boolean noWrap;
  [CEReactions]
  attribute DOMString vAlign;
  [CEReactions]
  attribute DOMString width;
};

partial interface HTMLDivElement {
  [CEReactions]
  attribute DOMString align;
};

partial interface HTMLTableCaptionElement {
  [CEReactions]
  attribute DOMString align;
};

partial interface HTMLBRElement {
  [CEReactions]
  attribute DOMString clear;
};

partial interface HTMLHeadingElement {
  [CEReactions]
  attribute DOMString align;
};

partial interface HTMLHtmlElement {
  [CEReactions]
  attribute DOMString version;
};

partial interface Window {
  [Replaceable, SameObject]
  readonly attribute External external;
  void captureEvents();
  void releaseEvents();
};

partial interface HTMLMenuElement {
  [CEReactions]
  attribute boolean compact;
};

partial interface HTMLObjectElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString archive;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString border;
  [CEReactions]
  attribute DOMString code;
  [CEReactions]
  attribute DOMString codeBase;
  [CEReactions]
  attribute DOMString codeType;
  [CEReactions]
  attribute boolean declare;
  [CEReactions]
  attribute unsigned long hspace;
  [CEReactions]
  attribute DOMString standby;
  [CEReactions]
  attribute unsigned long vspace;
};

partial interface HTMLLegendElement {
  [CEReactions]
  attribute DOMString align;
};

partial interface HTMLLIElement {
  [CEReactions]
  attribute DOMString type;
};

partial interface HTMLLinkElement {
  [CEReactions]
  attribute DOMString charset;
  [CEReactions]
  attribute DOMString rev;
  [CEReactions]
  attribute DOMString target;
};

partial interface HTMLParagraphElement {
  [CEReactions]
  attribute DOMString align;
};

partial interface HTMLHRElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString color;
  [CEReactions]
  attribute boolean noShade;
  [CEReactions]
  attribute DOMString size;
  [CEReactions]
  attribute DOMString width;
};

partial interface HTMLDListElement {
  [CEReactions]
  attribute boolean compact;
};

partial interface HTMLStyleElement {
  [CEReactions]
  attribute DOMString type;
};

partial interface HTMLAnchorElement {
  [CEReactions]
  attribute DOMString charset;
  [CEReactions]
  attribute DOMString coords;
  [CEReactions]
  attribute DOMString name;
  [CEReactions]
  attribute DOMString rev;
  [CEReactions]
  attribute DOMString shape;
};

partial interface HTMLScriptElement {
  [CEReactions]
  attribute DOMString charset;
  [CEReactions]
  attribute DOMString event;
  [CEReactions]
  attribute DOMString htmlFor;
};

partial interface HTMLPreElement {
  [CEReactions]
  attribute long width;
};

partial interface HTMLBodyElement {
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString aLink;
  [CEReactions]
  attribute DOMString background;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString bgColor;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString link;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString text;
  [CEReactions]
  attribute [LegacyNullToEmptyString] DOMString vLink;
};

partial interface HTMLEmbedElement {
  [CEReactions]
  attribute DOMString align;
  [CEReactions]
  attribute DOMString name;
};

HTMLFrameSetElement includes WindowEventHandlers;
