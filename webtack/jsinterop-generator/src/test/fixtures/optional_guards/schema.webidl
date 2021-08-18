typedef ( unsigned long or sequence<unsigned long> ) VibratePattern;

interface GPU {
};

interface Gamepad {
};

interface Navigator1 {
  [SameObject, OptionalSupport]
  readonly attribute GPU gpu;
  [SameObject, OptionalSupport]
  sequence<Gamepad?> getGamepads();
};

interface Navigator2 {
  [SameObject, OptionalSupport=WebGPU]
  readonly attribute GPU gpu;
  [SameObject, OptionalSupport]
  sequence<Gamepad?> getGamepads();
};

interface Window {
  [OptionalSupport]
  readonly attribute GPU gpu;
  [SameObject, OptionalSupport]
  sequence<Gamepad?> getGamepads();
};

partial interface Navigator {
  /**
   * This method is exploded into multiple methods. However we should only have one feature detection method created.
   */
  [OptionalSupport]
  boolean vibrate( VibratePattern pattern );
};

partial interface Navigator3 {
  [SameObject, OptionalSupport]
  readonly attribute GPU gpu;
  [SameObject, OptionalSupport]
  sequence<Gamepad?> getGamepads();
};

partial interface Navigator4 {
  [SameObject, OptionalSupport=WebGPU]
  readonly attribute GPU gpu;
  [SameObject, OptionalSupport]
  sequence<Gamepad?> getGamepads();
};
