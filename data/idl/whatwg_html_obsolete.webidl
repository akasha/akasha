[Exposed=Window]
interface HTMLMarqueeElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute DOMString behavior;
  [CEReactions] attribute DOMString bgColor;
  [CEReactions] attribute DOMString direction;
  [CEReactions] attribute DOMString height;
  [CEReactions] attribute unsigned long hspace;
  [CEReactions] attribute long loop;
  [CEReactions] attribute unsigned long scrollAmount;
  [CEReactions] attribute unsigned long scrollDelay;
  [CEReactions] attribute boolean trueSpeed;
  [CEReactions] attribute unsigned long vspace;
  [CEReactions] attribute DOMString width;

  attribute EventHandler onbounce;
  attribute EventHandler onfinish;
  attribute EventHandler onstart;

  void start();
  void stop();
};

[Exposed=Window]
interface HTMLFrameSetElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute DOMString cols;
  [CEReactions] attribute DOMString rows;
};
HTMLFrameSetElement includes WindowEventHandlers;

[Exposed=Window]
interface HTMLFrameElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute DOMString name;
  [CEReactions] attribute DOMString scrolling;
  [CEReactions] attribute USVString src;
  [CEReactions] attribute DOMString frameBorder;
  [CEReactions] attribute USVString longDesc;
  [CEReactions] attribute boolean noResize;
  readonly attribute Document? contentDocument;
  readonly attribute WindowProxy? contentWindow;

  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString marginHeight;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString marginWidth;
};

partial interface HTMLAnchorElement {
  [CEReactions] attribute DOMString coords;
  [CEReactions] attribute DOMString charset;
  [CEReactions] attribute DOMString name;
  [CEReactions] attribute DOMString rev;
  [CEReactions] attribute DOMString shape;
};

partial interface HTMLAreaElement {
  [CEReactions] attribute boolean noHref;
};

partial interface HTMLBodyElement {
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString text;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString link;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString vLink;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString aLink;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString bgColor;
  [CEReactions] attribute DOMString background;
};

partial interface HTMLBRElement {
  [CEReactions] attribute DOMString clear;
};

partial interface HTMLTableCaptionElement {
  [CEReactions] attribute DOMString align;
};

partial interface HTMLTableColElement {
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute DOMString ch;
  [CEReactions] attribute DOMString chOff;
  [CEReactions] attribute DOMString vAlign;
  [CEReactions] attribute DOMString width;
};

[Exposed=Window]
interface HTMLDirectoryElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute boolean compact;
};

partial interface HTMLDivElement {
  [CEReactions] attribute DOMString align;
};

partial interface HTMLDListElement {
  [CEReactions] attribute boolean compact;
};

partial interface HTMLEmbedElement {
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute DOMString name;
};

[Exposed=Window]
interface HTMLFontElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString color;
  [CEReactions] attribute DOMString face;
  [CEReactions] attribute DOMString size; 
};

partial interface HTMLHeadingElement {
  [CEReactions] attribute DOMString align;
};

partial interface HTMLHRElement {
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute DOMString color;
  [CEReactions] attribute boolean noShade;
  [CEReactions] attribute DOMString size;
  [CEReactions] attribute DOMString width;
};

partial interface HTMLHtmlElement {
  [CEReactions] attribute DOMString version;
};

partial interface HTMLIFrameElement {
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute DOMString scrolling;
  [CEReactions] attribute DOMString frameBorder;
  [CEReactions] attribute USVString longDesc;

  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString marginHeight;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString marginWidth;
};

partial interface HTMLImageElement {
  [CEReactions] attribute DOMString name;
  [CEReactions] attribute USVString lowsrc;
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute unsigned long hspace;
  [CEReactions] attribute unsigned long vspace;
  [CEReactions] attribute USVString longDesc;

  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString border;
};

partial interface HTMLInputElement {
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute DOMString useMap;
};

partial interface HTMLLegendElement {
  [CEReactions] attribute DOMString align;
};

partial interface HTMLLIElement {
  [CEReactions] attribute DOMString type;
};

partial interface HTMLLinkElement {
  [CEReactions] attribute DOMString charset;
  [CEReactions] attribute DOMString rev;
  [CEReactions] attribute DOMString target;
};

partial interface HTMLMenuElement {
  [CEReactions] attribute boolean compact;
};

partial interface HTMLMetaElement {
  [CEReactions] attribute DOMString scheme;
};

partial interface HTMLObjectElement {
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute DOMString archive;
  [CEReactions] attribute DOMString code;
  [CEReactions] attribute boolean declare;
  [CEReactions] attribute unsigned long hspace;
  [CEReactions] attribute DOMString standby;
  [CEReactions] attribute unsigned long vspace;
  [CEReactions] attribute DOMString codeBase;
  [CEReactions] attribute DOMString codeType;

  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString border;
};

partial interface HTMLOListElement {
  [CEReactions] attribute boolean compact;
};

partial interface HTMLParagraphElement {
  [CEReactions] attribute DOMString align;
};

partial interface HTMLParamElement {
  [CEReactions] attribute DOMString type;
  [CEReactions] attribute DOMString valueType;
};

partial interface HTMLPreElement {
  [CEReactions] attribute long width;
};

partial interface HTMLStyleElement {
  [CEReactions] attribute DOMString type;
};

partial interface HTMLScriptElement {
  [CEReactions] attribute DOMString charset;
  [CEReactions] attribute DOMString event;
  [CEReactions] attribute DOMString htmlFor;
};

partial interface HTMLTableElement {
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute DOMString border;
  [CEReactions] attribute DOMString frame;
  [CEReactions] attribute DOMString rules;
  [CEReactions] attribute DOMString summary;
  [CEReactions] attribute DOMString width;

  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString bgColor;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString cellPadding;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString cellSpacing;
};

partial interface HTMLTableSectionElement {
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute DOMString ch;
  [CEReactions] attribute DOMString chOff;
  [CEReactions] attribute DOMString vAlign;
};

partial interface HTMLTableCellElement {
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute DOMString axis;
  [CEReactions] attribute DOMString height;
  [CEReactions] attribute DOMString width;

  [CEReactions] attribute DOMString ch;
  [CEReactions] attribute DOMString chOff;
  [CEReactions] attribute boolean noWrap;
  [CEReactions] attribute DOMString vAlign;

  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString bgColor;
};

partial interface HTMLTableRowElement {
  [CEReactions] attribute DOMString align;
  [CEReactions] attribute DOMString ch;
  [CEReactions] attribute DOMString chOff;
  [CEReactions] attribute DOMString vAlign;

  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString bgColor;
};

partial interface HTMLUListElement {
  [CEReactions] attribute boolean compact;
  [CEReactions] attribute DOMString type;
};

partial interface Document {
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString fgColor;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString linkColor;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString vlinkColor;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString alinkColor;
  [CEReactions] attribute [TreatNullAs=EmptyString] DOMString bgColor;

  [SameObject] readonly attribute HTMLCollection anchors;
  [SameObject] readonly attribute HTMLCollection applets;

  void clear();
  void captureEvents();
  void releaseEvents();

  [SameObject] readonly attribute HTMLAllCollection all;
};

partial interface Window {
  void captureEvents();
  void releaseEvents();

  [Replaceable, SameObject] readonly attribute External external;
};

[Exposed=Window]
interface External {
  void AddSearchProvider();
  void IsSearchProviderInstalled();
};