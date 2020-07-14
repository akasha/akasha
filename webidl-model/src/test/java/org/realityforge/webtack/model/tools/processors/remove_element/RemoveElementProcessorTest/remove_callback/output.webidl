enum PanningModelType {
  "HRTF",
  "equalpower"
};

callback DecodeErrorCallback = void ( DOMException error );

callback DecodeSuccessCallback = void ( AudioBuffer decodedData );

dictionary AnalyserOptions : AudioNodeOptions {
  unsigned long fftSize = 2048;
  double maxDecibels = -30;
  double minDecibels = -100;
  double smoothingTimeConstant = 0.8;
};
