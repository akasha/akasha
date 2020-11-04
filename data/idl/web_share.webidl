dictionary ShareData {
  sequence<File> files;
  USVString text;
  USVString title;
  USVString url;
};

partial interface Navigator {
  [SecureContext]
  Promise<undefined> share( optional ShareData data = {} );
};
