[Exposed=Window]
interface HTMLScriptElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute USVString src;
  [CEReactions] attribute DOMString type;
  [CEReactions] attribute boolean noModule;
  [CEReactions] attribute boolean async;
  [CEReactions] attribute boolean defer;
  [CEReactions] attribute DOMString? crossOrigin;
  [CEReactions] attribute DOMString text;
  [CEReactions] attribute DOMString integrity;
  [CEReactions] attribute DOMString referrerPolicy;

};

[Exposed=Window]
interface HTMLTemplateElement : HTMLElement {
  [HTMLConstructor] constructor();

  readonly attribute DocumentFragment content;
};

[Exposed=Window]
interface HTMLSlotElement : HTMLElement {
  [HTMLConstructor] constructor();

  [CEReactions] attribute DOMString name;
  sequence<Node> assignedNodes(optional AssignedNodesOptions options = {});
  sequence<Element> assignedElements(optional AssignedNodesOptions options = {});
};

dictionary AssignedNodesOptions {
  boolean flatten = false;
};