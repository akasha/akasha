enum ScrollRestoration {
  "auto",
  "manual"
};

[Exposed=Window]
interface History {
  readonly attribute unsigned long length;
  readonly attribute any state;
  attribute ScrollRestoration scrollRestoration;
  void back();
  void forward();
  void go( optional long delta = 0 );
  void pushState( any data, DOMString title, optional USVString? url = null );
  void replaceState( any data, DOMString title, optional USVString? url = null );
};

[Exposed=Window]
interface Location {
  [LegacyUnforgeable, SameObject]
  readonly attribute DOMStringList ancestorOrigins;
  [LegacyUnforgeable]
  readonly attribute USVString origin;
  [LegacyUnforgeable]
  attribute USVString hash;
  [LegacyUnforgeable]
  attribute USVString host;
  [LegacyUnforgeable]
  attribute USVString hostname;
  [LegacyUnforgeable]
  attribute USVString pathname;
  [LegacyUnforgeable]
  attribute USVString port;
  [LegacyUnforgeable]
  attribute USVString protocol;
  [LegacyUnforgeable]
  attribute USVString search;
  [LegacyUnforgeable]
  stringifier attribute USVString href;
  [LegacyUnforgeable]
  void assign( USVString url );
  [LegacyUnforgeable]
  void reload();
  [LegacyUnforgeable]
  void replace( USVString url );
};
