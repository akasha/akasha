enum OrientationLockType {
  "any",
  "landscape",
  "landscape-primary",
  "landscape-secondary",
  "natural",
  "portrait",
  "portrait-primary",
  "portrait-secondary"
};

enum OrientationType {
  "landscape-primary",
  "landscape-secondary",
  "portrait-primary",
  "portrait-secondary"
};

[Exposed=Window]
interface ScreenOrientation : EventTarget {
  readonly attribute unsigned short angle;
  readonly attribute OrientationType type;
  attribute EventHandler onchange;
  Promise<undefined> lock( OrientationLockType orientation );
  undefined unlock();
};

partial interface Screen {
  [SameObject]
  readonly attribute ScreenOrientation orientation;
};
