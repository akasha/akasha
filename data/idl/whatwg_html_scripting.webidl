dictionary AssignedNodesOptions {
  boolean flatten = false;
};

[Exposed=Window]
interface HTMLSlotElement : HTMLElement {
  [CEReactions]
  attribute DOMString name;
  [HTMLConstructor]
  constructor();
  sequence<Element> assignedElements( optional AssignedNodesOptions options = {} );
  sequence<Node> assignedNodes( optional AssignedNodesOptions options = {} );
};

[Exposed=Window]
interface HTMLTemplateElement : HTMLElement {
  readonly attribute DocumentFragment content;
  [HTMLConstructor]
  constructor();
};

[Exposed=Window]
interface HTMLScriptElement : HTMLElement {
  [CEReactions]
  attribute boolean async;
  [CEReactions]
  attribute DOMString? crossOrigin;
  [CEReactions]
  attribute boolean defer;
  [CEReactions]
  attribute DOMString integrity;
  [CEReactions]
  attribute boolean noModule;
  [CEReactions]
  attribute DOMString referrerPolicy;
  [CEReactions]
  attribute USVString src;
  [CEReactions]
  attribute DOMString text;
  [CEReactions]
  attribute DOMString type;
  [HTMLConstructor]
  constructor();
};
