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

partial interface mixin PartialMixinC {
  attribute DOMString v1;
};

partial interface mixin PartialMixinD {
};
