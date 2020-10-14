dictionary AnimationEventInit : EventInit {
  CSSOMString animationName = "";
  double elapsedTime = 0.0;
  CSSOMString pseudoElement = "";
};

partial interface mixin GlobalEventHandlers {
  attribute EventHandler onanimationcancel;
  attribute EventHandler onanimationend;
  attribute EventHandler onanimationiteration;
  attribute EventHandler onanimationstart;
};

[Exposed=Window]
interface AnimationEvent : Event {
  readonly attribute CSSOMString animationName;
  readonly attribute double elapsedTime;
  readonly attribute CSSOMString pseudoElement;
  constructor( CSSOMString type, optional AnimationEventInit animationEventInitDict = {} );
};

[Exposed=Window]
interface CSSKeyframeRule : CSSRule {
  [SameObject, PutForwards=cssText]
  readonly attribute CSSStyleDeclaration style;
  attribute CSSOMString keyText;
};

[Exposed=Window]
interface CSSKeyframesRule : CSSRule {
  readonly attribute CSSRuleList cssRules;
  attribute CSSOMString name;
  undefined appendRule( CSSOMString rule );
  undefined deleteRule( CSSOMString select );
  CSSKeyframeRule? findRule( CSSOMString select );
};

partial interface CSSRule {
  const unsigned short KEYFRAMES_RULE = 7;
  const unsigned short KEYFRAME_RULE = 8;
};
