[Exposed=Window]
interface CSSPseudoElement : EventTarget {
  readonly attribute Element element;
  readonly attribute ( Element or CSSPseudoElement ) parent;
  readonly attribute CSSOMString type;
  CSSPseudoElement? pseudo( CSSOMString type );
};

partial interface Element {
  CSSPseudoElement? pseudo( CSSOMString type );
};
