interface GPU {
};

interface Navigator1 {
  [SameObject, OptionalSupport]
  readonly attribute GPU gpu;
};

interface Navigator2 {
  [SameObject, OptionalSupport=WebGPU]
  readonly attribute GPU gpu;
};

interface Window {
  [OptionalSupport]
  readonly attribute GPU gpu;
};

partial interface Navigator3 {
  [SameObject, OptionalSupport]
  readonly attribute GPU gpu;
};

partial interface Navigator4 {
  [SameObject, OptionalSupport=WebGPU]
  readonly attribute GPU gpu;
};
