dictionary StorageEstimate {
  unsigned long long quota;
  unsigned long long usage;
};

[SecureContext]
interface mixin NavigatorStorage {
  [SameObject]
  readonly attribute StorageManager storage;
};

[SecureContext, Exposed=(Window,Worker)]
interface StorageManager {
  Promise<StorageEstimate> estimate();
  [Exposed=Window]
  Promise<boolean> persist();
  Promise<boolean> persisted();
};

Navigator includes NavigatorStorage;

WorkerNavigator includes NavigatorStorage;
