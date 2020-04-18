[Exposed=Window]
    interface XMLSerializer {
      constructor();
      DOMString serializeToString(Node root);
    };

interface mixin InnerHTML {
      [CEReactions] attribute [TreatNullAs=EmptyString] DOMString innerHTML;
    };

    Element includes InnerHTML;
    ShadowRoot includes InnerHTML;

partial interface Element {
      [CEReactions] attribute [TreatNullAs=EmptyString] DOMString outerHTML;
      [CEReactions] void insertAdjacentHTML(DOMString position, DOMString text);
    };

partial interface Range {
      [CEReactions, NewObject] DocumentFragment createContextualFragment(DOMString fragment);
    };