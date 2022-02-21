[Exposed=(Window,Worker)]
interface mixin MixinA {
  attribute DOMString sharedVar;
  [Exposed=Worker]
  attribute DOMString workerVar;
};

interface mixin MixinC {
  attribute DOMString v1;
};

interface mixin MixinD {
  [Exposed=Worker]
  attribute DOMString v1;
};

[Exposed=*]
interface mixin MyGPU {
  readonly attribute DOMString version;
  undefined myMethod();
};

[Exposed=(Window,Worker)]
partial interface mixin PartialMixinA {
  attribute DOMString sharedVar;
  [Exposed=Worker]
  attribute DOMString workerVar;
};

partial interface mixin PartialMixinC {
  attribute DOMString v1;
};

partial interface mixin PartialMixinD {
  [Exposed=Worker]
  attribute DOMString v1;
};
