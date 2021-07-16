[Exposed=Window]
namespace CSS {
  CSSOMString escape( CSSOMString ident );
};

dictionary CSSStyleSheetInit {
  DOMString baseURL = null;
  boolean disabled = false;
  ( MediaList or DOMString ) media = "";
};

interface mixin ElementCSSInlineStyle {
  [SameObject, PutForwards=cssText]
  readonly attribute CSSStyleDeclaration style;
};

interface mixin LinkStyle {
  readonly attribute CSSStyleSheet? sheet;
};

partial interface mixin DocumentOrShadowRoot {
  [SameObject]
  readonly attribute StyleSheetList styleSheets;
};

[Exposed=Window]
interface CSSGroupingRule : CSSRule {
  [SameObject]
  readonly attribute CSSRuleList cssRules;
  undefined deleteRule( unsigned long index );
  unsigned long insertRule( CSSOMString rule, optional unsigned long index = 0 );
};

[Exposed=Window]
interface CSSImportRule : CSSRule {
  readonly attribute USVString href;
  [SameObject, PutForwards=mediaText]
  readonly attribute MediaList media;
  [SameObject]
  readonly attribute CSSStyleSheet styleSheet;
};

[Exposed=Window]
interface CSSMarginRule : CSSRule {
  readonly attribute CSSOMString name;
  [SameObject, PutForwards=cssText]
  readonly attribute CSSStyleDeclaration style;
};

[Exposed=Window]
interface CSSNamespaceRule : CSSRule {
  readonly attribute CSSOMString namespaceURI;
  readonly attribute CSSOMString prefix;
};

[Exposed=Window]
interface CSSPageRule : CSSGroupingRule {
  [SameObject, PutForwards=cssText]
  readonly attribute CSSStyleDeclaration style;
  attribute CSSOMString selectorText;
};

[Exposed=Window]
interface CSSRule {
  const unsigned short CHARSET_RULE = 2;
  const unsigned short FONT_FACE_RULE = 5;
  const unsigned short IMPORT_RULE = 3;
  const unsigned short MARGIN_RULE = 9;
  const unsigned short MEDIA_RULE = 4;
  const unsigned short NAMESPACE_RULE = 10;
  const unsigned short PAGE_RULE = 6;
  const unsigned short STYLE_RULE = 1;
  readonly attribute CSSRule? parentRule;
  readonly attribute CSSStyleSheet? parentStyleSheet;
  readonly attribute unsigned short type;
  attribute CSSOMString cssText;
};

[Exposed=Window]
interface CSSRuleList {
  readonly attribute unsigned long length;
  getter CSSRule? item( unsigned long index );
};

[Exposed=Window]
interface CSSStyleDeclaration {
  readonly attribute unsigned long length;
  readonly attribute CSSRule? parentRule;
  [CEReactions]
  attribute [LegacyNullToEmptyString] CSSOMString cssFloat;
  [CEReactions]
  attribute CSSOMString cssText;
  CSSOMString getPropertyPriority( CSSOMString property );
  CSSOMString getPropertyValue( CSSOMString property );
  [CEReactions]
  CSSOMString removeProperty( CSSOMString property );
  [CEReactions]
  undefined setProperty( CSSOMString property, [LegacyNullToEmptyString] CSSOMString value, optional [LegacyNullToEmptyString] CSSOMString priority = "" );
  getter CSSOMString item( unsigned long index );
};

[Exposed=Window]
interface CSSStyleRule : CSSRule {
  [SameObject, PutForwards=cssText]
  readonly attribute CSSStyleDeclaration style;
  attribute CSSOMString selectorText;
};

[Exposed=Window]
interface CSSStyleSheet : StyleSheet {
  [SameObject]
  readonly attribute CSSRuleList cssRules;
  readonly attribute CSSRule? ownerRule;
  constructor( optional CSSStyleSheetInit options = {} );
  undefined deleteRule( unsigned long index );
  unsigned long insertRule( CSSOMString rule, optional unsigned long index = 0 );
  Promise<CSSStyleSheet> replace( USVString text );
  undefined replaceSync( USVString text );
};

[Exposed=Window]
interface MediaList {
  readonly attribute unsigned long length;
  stringifier attribute [LegacyNullToEmptyString] CSSOMString mediaText;
  undefined appendMedium( CSSOMString medium );
  undefined deleteMedium( CSSOMString medium );
  getter CSSOMString? item( unsigned long index );
};

[Exposed=Window]
interface StyleSheet {
  readonly attribute USVString? href;
  [SameObject, PutForwards=mediaText]
  readonly attribute MediaList media;
  readonly attribute ( Element or ProcessingInstruction )? ownerNode;
  readonly attribute CSSStyleSheet? parentStyleSheet;
  readonly attribute DOMString? title;
  readonly attribute CSSOMString type;
  attribute boolean disabled;
};

[Exposed=Window]
interface StyleSheetList {
  readonly attribute unsigned long length;
  getter CSSStyleSheet? item( unsigned long index );
};

partial interface CSSStyleSheet {
  [SameObject]
  readonly attribute CSSRuleList rules;
  long addRule( optional DOMString selector = "undefined", optional DOMString style = "undefined", optional unsigned long index );
  undefined removeRule( optional unsigned long index = 0 );
};

partial interface Window {
  [NewObject]
  CSSStyleDeclaration getComputedStyle( Element elt, optional CSSOMString? pseudoElt );
};

HTMLElement includes ElementCSSInlineStyle;

MathMLElement includes ElementCSSInlineStyle;

ProcessingInstruction includes LinkStyle;

SVGElement includes ElementCSSInlineStyle;
