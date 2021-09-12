[Exposed=Window]
interface VisualViewport : EventTarget {
  readonly attribute double height;
  readonly attribute double offsetLeft;
  readonly attribute double offsetTop;
  readonly attribute double pageLeft;
  readonly attribute double pageTop;
  readonly attribute double scale;
  readonly attribute FrozenArray<DOMRect>? segments;
  readonly attribute double width;
  attribute EventHandler onresize;
  attribute EventHandler onscroll;
};

partial interface Window {
  [SameObject, Replaceable]
  readonly attribute VisualViewport visualViewport;
};
