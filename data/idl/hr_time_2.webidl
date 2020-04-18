typedef double DOMHighResTimeStamp;

[Exposed=(Window,Worker)]
interface Performance : EventTarget {
    DOMHighResTimeStamp now();
    readonly attribute DOMHighResTimeStamp timeOrigin;
    [Default] object toJSON();
};

partial interface mixin WindowOrWorkerGlobalScope {
  [Replaceable] readonly attribute Performance performance;
};