[Exposed=(Window,Worker)]
interface mixin MixinA {
  [Exposed=Worker]
  attribute DOMString workerVar;
  [Exposed=Window]
  attribute DOMString windowVar;
  attribute DOMString sharedVar;
};

[Exposed=Window]
interface mixin MixinB {
  attribute DOMString v1;
};

interface mixin MixinC {
  attribute DOMString v1;
};

interface mixin MixinD {
  [Exposed=Worker]
  attribute DOMString v1;
};

[Exposed=(Window,Worker)]
partial interface mixin PartialMixinA {
  [Exposed=Worker]
  attribute DOMString workerVar;
  [Exposed=Window]
  attribute DOMString windowVar;
  attribute DOMString sharedVar;
};

[Exposed=Window]
partial interface mixin PartialMixinB {
  attribute DOMString v1;
};

partial interface mixin PartialMixinC {
  attribute DOMString v1;
};

partial interface mixin PartialMixinD {
  [Exposed=Worker]
  attribute DOMString v1;
};

