callback IdleRequestCallback = undefined ( IdleDeadline deadline );

dictionary IdleRequestOptions {
  unsigned long timeout;
};

[Exposed=Window]
interface IdleDeadline {
  readonly attribute boolean didTimeout;
  DOMHighResTimeStamp timeRemaining();
};

partial interface Window {
  undefined cancelIdleCallback( unsigned long handle );
  unsigned long requestIdleCallback( IdleRequestCallback callback, optional IdleRequestOptions options = {} );
};
