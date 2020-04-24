dictionary TextDecodeOptions {
  boolean stream = false;
};

dictionary TextDecoderOptions {
  boolean fatal = false;
  boolean ignoreBOM = false;
};

dictionary TextEncoderEncodeIntoResult {
  unsigned long long read;
  unsigned long long written;
};

interface mixin GenericTransformStream {
  readonly attribute ReadableStream readable;
  readonly attribute WritableStream writable;
};

interface mixin TextDecoderCommon {
  readonly attribute DOMString encoding;
  readonly attribute boolean fatal;
  readonly attribute boolean ignoreBOM;
};

interface mixin TextEncoderCommon {
  readonly attribute DOMString encoding;
};

[Exposed=(Window,Worker)]
interface TextDecoder {
  constructor( optional DOMString label = "utf-8", optional TextDecoderOptions options = {} );
  USVString decode( optional [AllowShared] BufferSource input, optional TextDecodeOptions options = {} );
};

[Exposed=(Window,Worker)]
interface TextDecoderStream {
  constructor( optional DOMString label = "utf-8", optional TextDecoderOptions options = {} );
};

[Exposed=(Window,Worker)]
interface TextEncoder {
  constructor();
  [NewObject]
  Uint8Array encode( optional USVString input = "" );
  TextEncoderEncodeIntoResult encodeInto( USVString source, [AllowShared] Uint8Array destination );
};

[Exposed=(Window,Worker)]
interface TextEncoderStream {
  constructor();
};

TextDecoder includes TextDecoderCommon;

TextDecoderStream includes GenericTransformStream;

TextDecoderStream includes TextDecoderCommon;

TextEncoder includes TextEncoderCommon;

TextEncoderStream includes GenericTransformStream;

TextEncoderStream includes TextEncoderCommon;
