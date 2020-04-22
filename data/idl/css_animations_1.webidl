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

[Exposed=Window, Constructor( CSSOMString type, optional AnimationEventInit animationEventInitDict )]
interface AnimationEvent : Event {
  readonly attribute CSSOMString animationName;
  readonly attribute double elapsedTime;
  readonly attribute CSSOMString pseudoElement;
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
  void appendRule( CSSOMString rule );
  void deleteRule( CSSOMString select );
  CSSKeyframeRule? findRule( CSSOMString select );
};

partial interface CSSRule {
  const unsigned short KEYFRAMES_RULE = 7;
  const unsigned short KEYFRAME_RULE = 8;
};
