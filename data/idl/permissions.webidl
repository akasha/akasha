enum PermissionState {
  "denied",
  "granted",
  "prompt"
};

dictionary PermissionDescriptor {
  required DOMString name;
};

dictionary PermissionSetParameters {
  required PermissionDescriptor descriptor;
  required PermissionState state;
  boolean oneRealm = false;
};

[Exposed=(Window,Worker)]
interface PermissionStatus : EventTarget {
  readonly attribute DOMString name;
  readonly attribute PermissionState state;
  attribute EventHandler onchange;
};

[Exposed=(Window,Worker)]
interface Permissions {
  Promise<PermissionStatus> query( object permissionDesc );
};

[Exposed=(Window)]
partial interface Navigator {
  [SameObject]
  readonly attribute Permissions permissions;
};

[Exposed=(Worker)]
partial interface WorkerNavigator {
  [SameObject]
  readonly attribute Permissions permissions;
};
