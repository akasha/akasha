dictionary ShareData {
  sequence<File> files;
  USVString text;
  USVString title;
  USVString url;
};

partial interface Navigator {
  [SecureContext]
  boolean canShare( optional ShareData data = {} );
  [SecureContext]
  Promise<undefined> share( optional ShareData data = {} );
};
