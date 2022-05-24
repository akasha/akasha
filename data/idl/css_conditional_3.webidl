partial namespace CSS {
  boolean supports( CSSOMString property, CSSOMString value );
  boolean supports( CSSOMString conditionText );
};

[Exposed=Window]
interface CSSConditionRule : CSSGroupingRule {
  readonly attribute CSSOMString conditionText;
};

[Exposed=Window]
interface CSSMediaRule : CSSConditionRule {
  [SameObject, PutForwards=mediaText]
  readonly attribute MediaList media;
};

[Exposed=Window]
interface CSSSupportsRule : CSSConditionRule {
};

partial interface CSSRule {
  const unsigned short SUPPORTS_RULE = 12;
};
