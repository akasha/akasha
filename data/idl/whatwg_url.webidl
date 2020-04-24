[Exposed=(Window,Worker), LegacyWindowAlias=webkitURL]
interface URL {
  readonly attribute USVString origin;
  [SameObject]
  readonly attribute URLSearchParams searchParams;
  attribute USVString hash;
  attribute USVString host;
  attribute USVString hostname;
  attribute USVString password;
  attribute USVString pathname;
  attribute USVString port;
  attribute USVString protocol;
  attribute USVString search;
  attribute USVString username;
  stringifier attribute USVString href;
  constructor( USVString url, optional USVString base );
  USVString toJSON();
};

[Exposed=(Window,Worker)]
interface URLSearchParams {
  iterable<USVString, USVString>;
  constructor( optional ( sequence<sequence<USVString>> or record<USVString, USVString> or USVString ) init = "" );
  void append( USVString name, USVString value );
  void delete( USVString name );
  USVString? get( USVString name );
  sequence<USVString> getAll( USVString name );
  boolean has( USVString name );
  void set( USVString name, USVString value );
  void sort();
  stringifier;
};
