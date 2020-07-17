typedef record<DOMString, DOMString> AuthenticationExtensionsAuthenticatorInputs;

dictionary AudioWorkletNodeOptions {
  record<DOMString, double> parameterData;
};

dictionary ClipboardItemOptions {
  DOMString presentationStyle = "unspecified";
};

dictionary OtherDict {
  AuthenticationExtensionsAuthenticatorInputs value;
};

[Exposed=Window]
interface ClipboardItem {
  constructor( record<DOMString, ClipboardItemData> items, optional ClipboardItemOptions options = {} );
};

interface ClipboardItemData {
  readonly attribute DOMString data;
};

[Exposed=(Window,Worker)]
interface Headers {
  constructor( optional record<ByteString, ByteString> headers );
};
