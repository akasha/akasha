enum PanningModelType {
  "HRTF",
  "equalpower"
};

callback DecodeErrorCallback = undefined ( DOMException error );

callback DecodeSuccessCallback = undefined ( AudioBuffer decodedData );

dictionary AnalyserOptions : AudioNodeOptions {
  unsigned long fftSize = 2048;
  double maxDecibels = -30;
  double minDecibels = -100;
  double smoothingTimeConstant = 0.8;
};
