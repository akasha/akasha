typedef record<DOMString, DOMString> AuthenticationExtensionsAuthenticatorInputs;

dictionary AudioWorkletNodeOptions {
  record<DOMString, boolean> otherData1;
  record<DOMString, float> otherData10;
  record<DOMString, unrestricted float> otherData11;
  record<DOMString, byte> otherData2;
  record<DOMString, octet> otherData3;
  record<DOMString, short> otherData4;
  record<DOMString, unsigned short> otherData5;
  record<DOMString, long> otherData6;
  record<DOMString, unsigned long> otherData7;
  record<DOMString, long long> otherData8;
  record<DOMString, unsigned long long> otherData9;
  record<DOMString, double> parameterData;
};

dictionary ClipboardItemOptions {
  DOMString presentationStyle = "unspecified";
};

dictionary OtherDict {
  AuthenticationExtensionsAuthenticatorInputs value;
};

interface ClipboardItem {
  constructor( record<DOMString, ClipboardItemData> items, optional ClipboardItemOptions options = {} );
};

interface ClipboardItemData {
  readonly attribute DOMString data;
};

interface Headers {
  constructor( optional record<ByteString, ByteString> headers );
};
