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
