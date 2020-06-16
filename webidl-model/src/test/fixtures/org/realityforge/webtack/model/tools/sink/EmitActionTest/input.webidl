[Exposed=(Window,Worker)]
interface mixin MixinA {
  [Exposed=Worker]
  attribute DOMString workerVar;
  [Exposed=Window]
  attribute DOMString windowVar;
  attribute DOMString sharedVar;
};

partial interface mixin PartialMixinD {
  [Exposed=Worker]
  attribute DOMString v1;
};

