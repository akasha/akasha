enum WakeLockType {
  "screen"
};

[SecureContext, Exposed=(Window)]
interface WakeLock {
  Promise<WakeLockSentinel> request( WakeLockType type );
};

[SecureContext, Exposed=(Window)]
interface WakeLockSentinel : EventTarget {
  readonly attribute boolean released;
  readonly attribute WakeLockType type;
  attribute EventHandler onrelease;
  Promise<undefined> release();
};

[SecureContext]
partial interface Navigator {
  [SameObject]
  readonly attribute WakeLock wakeLock;
};
