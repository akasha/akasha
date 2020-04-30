[Exposed=Window]
interface CSSPseudoElement : EventTarget {
  readonly attribute Element element;
  readonly attribute CSSOMString type;
};

partial interface Element {
  CSSPseudoElement? pseudo( CSSOMString type );
};
