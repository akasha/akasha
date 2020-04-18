enum ScrollRestoration { "auto", "manual" };

[Exposed=Window]
interface History {
  readonly attribute unsigned long length;
  attribute ScrollRestoration scrollRestoration;
  readonly attribute any state;
  void go(optional long delta = 0);
  void back();
  void forward();
  void pushState(any data, DOMString title, optional USVString? url = null);
  void replaceState(any data, DOMString title, optional USVString? url = null);
};

[Exposed=Window]
interface Location { // but see also additional creation steps and overridden internal methods
  [Unforgeable] stringifier attribute USVString href;
  [Unforgeable] readonly attribute USVString origin;
  [Unforgeable] attribute USVString protocol;
  [Unforgeable] attribute USVString host;
  [Unforgeable] attribute USVString hostname;
  [Unforgeable] attribute USVString port;
  [Unforgeable] attribute USVString pathname;
  [Unforgeable] attribute USVString search;
  [Unforgeable] attribute USVString hash;

  [Unforgeable] void assign(USVString url);
  [Unforgeable] void replace(USVString url);
  [Unforgeable] void reload();

  [Unforgeable, SameObject] readonly attribute DOMStringList ancestorOrigins;
};