/**
 * This tests scenario where enum values start with number.
 */
enum OverSampleType {
  "2x",
  "4x",
  "none"
};

enum SpeechRecognitionErrorCode {
  "aborted",
  "audio-capture",
  "bad-grammar",
  "language-not-supported",
  "network",
  "no-speech",
  "not-allowed",
  "service-not-allowed"
};

/**
 * This tests scenario where there is an empty enum value.
 */
enum XMLHttpRequestResponseType {
  "",
  "arraybuffer",
  "blob",
  "document",
  "json",
  "text"
};

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
enum txMode {
  "requires",
  "requires_new",
  "not-allowed"
};

/**
 * Callback has both return type and argument as enums.
 */
callback SomeCallbackHandler = SpeechRecognitionErrorCode ( txMode blah );

/**
 * Required attribute is an enum
 */
dictionary SpeechRecognitionErrorEventInit {
  required SpeechRecognitionErrorCode error;
};

/**
 * Optional attribute is an enum
 */
dictionary WaveShaperOptions {
  OverSampleType oversample = "none";
};

interface WaveShaperNode {
  /**
   * regular attribute is an enum.
   */
  attribute OverSampleType oversample;
  /**
   * static attribute is an enum.
   */
  attribute OverSampleType static_oversample;
  constructor( OverSampleType sample );
  /**
   * attribute return value is an enum.
   */
  OverSampleType getSample();
  /**
   * attribute argument is an enum.
   */
  void setSample( OverSampleType sample );
};
