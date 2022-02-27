[Exposed=(Window,Worker)]
interface mixin MixinA {
  attribute DOMString sharedVar;
  [Exposed=Window]
  attribute DOMString windowVar;
};

[Exposed=Window]
interface mixin MixinB {
  attribute DOMString v1;
};

interface mixin MixinC {
  attribute DOMString v1;
};

interface mixin MixinD {
};

[Exposed=*]
interface mixin MyGPU {
  readonly attribute DOMString version;
  undefined myMethod();
};

[Exposed=(Window,Worker)]
partial interface mixin PartialMixinA {
  attribute DOMString sharedVar;
  [Exposed=Window]
  attribute DOMString windowVar;
};

[Exposed=Window]
partial interface mixin PartialMixinB {
  attribute DOMString v1;
};

partial interface mixin PartialMixinC {
  attribute DOMString v1;
};

partial interface mixin PartialMixinD {
};
