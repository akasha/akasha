[Exposed=*]
interface CompressionStream {
  constructor( DOMString format );
};

[Exposed=*]
interface DecompressionStream {
  constructor( DOMString format );
};

CompressionStream includes GenericTransformStream;

DecompressionStream includes GenericTransformStream;
