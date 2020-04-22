dictionary TransitionEventInit : EventInit {
  double elapsedTime = 0.0;
  CSSOMString propertyName = "";
  CSSOMString pseudoElement = "";
};

[Exposed=Window, Constructor( CSSOMString type, optional TransitionEventInit transitionEventInitDict )]
interface TransitionEvent : Event {
  readonly attribute double elapsedTime;
  readonly attribute CSSOMString propertyName;
  readonly attribute CSSOMString pseudoElement;
};

partial interface GlobalEventHandlers {
  attribute EventHandler ontransitioncancel;
  attribute EventHandler ontransitionend;
  attribute EventHandler ontransitionrun;
  attribute EventHandler ontransitionstart;
};
