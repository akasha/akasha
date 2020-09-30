[Exposed=(Window,Worker)]
interface CompressionStream {
  constructor( DOMString format );
};

[Exposed=(Window,Worker)]
interface DecompressionStream {
  constructor( DOMString format );
};

CompressionStream includes GenericTransformStream;

DecompressionStream includes GenericTransformStream;
