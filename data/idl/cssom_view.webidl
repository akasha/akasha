enum ScrollBehavior {
  "auto",
  "smooth"
};

enum ScrollLogicalPosition {
  "center",
  "end",
  "nearest",
  "start"
};

dictionary IsVisibleOptions {
  boolean checkInert = false;
  boolean checkOpacity = false;
  boolean checkVisibilityCSS = false;
};

dictionary MediaQueryListEventInit : EventInit {
  boolean matches = false;
  CSSOMString media = "";
};

dictionary ScrollIntoViewOptions : ScrollOptions {
  ScrollLogicalPosition block = "start";
  ScrollLogicalPosition inline = "nearest";
};

dictionary ScrollOptions {
  ScrollBehavior behavior = "auto";
};

dictionary ScrollToOptions : ScrollOptions {
  unrestricted double left;
  unrestricted double top;
};

partial dictionary MouseEventInit {
  double clientX = 0.0;
  double clientY = 0.0;
  double screenX = 0.0;
  double screenY = 0.0;
};

[Exposed=Window]
interface CaretPosition {
  readonly attribute unsigned long offset;
  readonly attribute Node offsetNode;
  [NewObject]
  DOMRect? getClientRect();
};

[Exposed=Window]
interface MediaQueryList : EventTarget {
  readonly attribute boolean matches;
  readonly attribute CSSOMString media;
  attribute EventHandler onchange;
  undefined addListener( EventListener? callback );
  undefined removeListener( EventListener? callback );
};

[Exposed=Window]
interface MediaQueryListEvent : Event {
  readonly attribute boolean matches;
  readonly attribute CSSOMString media;
  constructor( CSSOMString type, optional MediaQueryListEventInit eventInitDict = {} );
};

[Exposed=Window]
interface Screen {
  readonly attribute long availHeight;
  readonly attribute long availWidth;
  readonly attribute unsigned long colorDepth;
  readonly attribute long height;
  readonly attribute unsigned long pixelDepth;
  readonly attribute long width;
};

partial interface Document {
  readonly attribute Element? scrollingElement;
  CaretPosition? caretPositionFromPoint( double x, double y );
  Element? elementFromPoint( double x, double y );
  sequence<Element> elementsFromPoint( double x, double y );
};

partial interface Element {
  readonly attribute long clientHeight;
  readonly attribute long clientLeft;
  readonly attribute long clientTop;
  readonly attribute long clientWidth;
  readonly attribute long scrollHeight;
  readonly attribute long scrollWidth;
  attribute unrestricted double scrollLeft;
  attribute unrestricted double scrollTop;
  [NewObject]
  DOMRect getBoundingClientRect();
  DOMRectList getClientRects();
  boolean isVisible( optional IsVisibleOptions options = {} );
  undefined scroll( optional ScrollToOptions options = {} );
  undefined scroll( unrestricted double x, unrestricted double y );
  undefined scrollBy( optional ScrollToOptions options = {} );
  undefined scrollBy( unrestricted double x, unrestricted double y );
  undefined scrollIntoView( optional ( boolean or ScrollIntoViewOptions ) arg = {} );
  undefined scrollTo( optional ScrollToOptions options = {} );
  undefined scrollTo( unrestricted double x, unrestricted double y );
};

partial interface HTMLElement {
  readonly attribute long offsetHeight;
  readonly attribute long offsetLeft;
  readonly attribute Element? offsetParent;
  readonly attribute long offsetTop;
  readonly attribute long offsetWidth;
};

partial interface HTMLImageElement {
  readonly attribute long x;
  readonly attribute long y;
};

partial interface MouseEvent {
  readonly attribute double clientX;
  readonly attribute double clientY;
  readonly attribute double offsetX;
  readonly attribute double offsetY;
  readonly attribute double pageX;
  readonly attribute double pageY;
  readonly attribute double screenX;
  readonly attribute double screenY;
  readonly attribute double x;
  readonly attribute double y;
};

partial interface Range {
  [NewObject]
  DOMRect getBoundingClientRect();
  DOMRectList getClientRects();
};

partial interface Window {
  [Replaceable]
  readonly attribute double devicePixelRatio;
  [Replaceable]
  readonly attribute long innerHeight;
  [Replaceable]
  readonly attribute long innerWidth;
  [Replaceable]
  readonly attribute long outerHeight;
  [Replaceable]
  readonly attribute long outerWidth;
  [Replaceable]
  readonly attribute double pageXOffset;
  [Replaceable]
  readonly attribute double pageYOffset;
  [SameObject, Replaceable]
  readonly attribute Screen screen;
  [Replaceable]
  readonly attribute long screenLeft;
  [Replaceable]
  readonly attribute long screenTop;
  [Replaceable]
  readonly attribute long screenX;
  [Replaceable]
  readonly attribute long screenY;
  [Replaceable]
  readonly attribute double scrollX;
  [Replaceable]
  readonly attribute double scrollY;
  [NewObject]
  MediaQueryList matchMedia( CSSOMString query );
  undefined moveBy( long x, long y );
  undefined moveTo( long x, long y );
  undefined resizeBy( long x, long y );
  undefined resizeTo( long width, long height );
  undefined scroll( optional ScrollToOptions options = {} );
  undefined scroll( unrestricted double x, unrestricted double y );
  undefined scrollBy( optional ScrollToOptions options = {} );
  undefined scrollBy( unrestricted double x, unrestricted double y );
  undefined scrollTo( optional ScrollToOptions options = {} );
  undefined scrollTo( unrestricted double x, unrestricted double y );
};
