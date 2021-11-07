typedef double DOMHighResTimeStamp;

typedef unsigned long long EpochTimeStamp;

partial interface mixin WindowOrWorkerGlobalScope {
  [Replaceable]
  readonly attribute Performance performance;
};

[Exposed=(Window,Worker)]
interface Performance : EventTarget {
  readonly attribute DOMHighResTimeStamp timeOrigin;
  DOMHighResTimeStamp now();
  [Default]
  object toJSON();
};
