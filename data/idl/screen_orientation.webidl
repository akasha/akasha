partial interface Screen {
  [SameObject] readonly attribute ScreenOrientation orientation;
};

[Exposed=Window]
interface ScreenOrientation : EventTarget {
  Promise<void> lock(OrientationLockType orientation);
  void unlock();
  readonly attribute OrientationType type;
  readonly attribute unsigned short angle;
  attribute EventHandler onchange;
};

enum OrientationLockType {
  "any",
  "natural",
  "landscape",
  "portrait",
  "portrait-primary",
  "portrait-secondary",
  "landscape-primary",
  "landscape-secondary"
};

enum OrientationType {
  "portrait-primary",
  "portrait-secondary",
  "landscape-primary",
  "landscape-secondary"
};