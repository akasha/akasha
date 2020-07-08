dictionary OtherPushPermissionDescriptor : PushPermissionDescriptor {
  required boolean safe;
};

dictionary PermissionDescriptor {
  required DOMString name;
};

dictionary PushPermissionDescriptor : PermissionDescriptor {
  boolean userVisibleOnly = false;
};
