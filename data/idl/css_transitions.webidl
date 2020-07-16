dictionary TransitionEventInit : EventInit {
  double elapsedTime = 0.0;
  CSSOMString propertyName = "";
  CSSOMString pseudoElement = "";
};

partial interface mixin GlobalEventHandlers {
  attribute EventHandler ontransitioncancel;
  attribute EventHandler ontransitionend;
  attribute EventHandler ontransitionrun;
  attribute EventHandler ontransitionstart;
};

[Exposed=Window]
interface TransitionEvent : Event {
  readonly attribute double elapsedTime;
  readonly attribute CSSOMString propertyName;
  readonly attribute CSSOMString pseudoElement;
  constructor( CSSOMString type, optional TransitionEventInit transitionEventInitDict = {} );
};
