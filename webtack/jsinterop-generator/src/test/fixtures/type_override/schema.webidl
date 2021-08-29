[Internal, Synthetic]
typedef ( AudioNode or undefined ) AudioNodeOrUndefinedUnion;

[Internal, Synthetic]
typedef ( Document or Window ) DocumentOrWindowUnion;

[MarkerType]
typedef Window WindowProxy;

interface AudioNode {
  [TypeOverride=AudioNodeOrUndefinedUnion]
  AudioNode connect( AudioNode destinationNode, optional unsigned long output = 0, optional unsigned long input = 0 );
  [TypeOverride=AudioNodeOrUndefinedUnion]
  undefined connect( AudioParam destinationParam, optional unsigned long output = 0 );
};

interface AudioParam {
};

interface Document {
  [TypeOverride=DocumentOrWindowUnion]
  Document open( optional DOMString unused1, optional DOMString unused2 );
  [TypeOverride=DocumentOrWindowUnion]
  WindowProxy? open( USVString url, DOMString name, DOMString features );
};

interface Window {
};
