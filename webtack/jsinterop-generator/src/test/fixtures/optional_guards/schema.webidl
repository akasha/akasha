typedef ( unsigned long or sequence<unsigned long> ) VibratePattern;

[Exposed=Window]
interface GPU {
};

[Exposed=Window]
interface Gamepad {
};

[Exposed=Window]
interface Navigator1 {
  [SameObject, OptionalSupport]
  readonly attribute GPU gpu;
  [SameObject, OptionalSupport]
  sequence<Gamepad?> getGamepads();
};

[Exposed=Window]
interface Navigator2 {
  [SameObject, OptionalSupport=WebGPU]
  readonly attribute GPU gpu;
  [SameObject, OptionalSupport]
  sequence<Gamepad?> getGamepads();
};

[Exposed=Window]
interface Window {
  [OptionalSupport]
  readonly attribute GPU gpu;
  [SameObject, OptionalSupport]
  sequence<Gamepad?> getGamepads();
};

[Exposed=Window]
partial interface Navigator {
  /**
   * This method is exploded into multiple methods. However we should only have one feature detection method created.
   */
  [OptionalSupport]
  boolean vibrate( VibratePattern pattern );
};

[Exposed=Window]
partial interface Navigator3 {
  [SameObject, OptionalSupport]
  readonly attribute GPU gpu;
  [SameObject, OptionalSupport]
  sequence<Gamepad?> getGamepads();
};

[Exposed=Window]
partial interface Navigator4 {
  [SameObject, OptionalSupport=WebGPU]
  readonly attribute GPU gpu;
  [SameObject, OptionalSupport]
  sequence<Gamepad?> getGamepads();
};
