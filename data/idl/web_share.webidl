dictionary ShareData {
  sequence<File> files;
  USVString text;
  USVString title;
  USVString url;
};

partial interface Navigator {
  [SecureContext]
  Promise<void> share( optional ShareData data = {} );
};
