[JavaSubPackage=core]
interface RegExp {
  [JavaAnnotation="akasha.core.RegExpLanguage"]
  readonly attribute DOMString source;
  [JavaAnnotation="akasha.core.RegExpFlags"]
  readonly attribute DOMString flags;
  readonly attribute boolean dotAll;
  readonly attribute boolean global;
  readonly attribute boolean ignoreCase;
  readonly attribute boolean multiline;
  readonly attribute boolean sticky;
  readonly attribute boolean unicode;
  attribute unsigned long lastIndex;

  constructor( [JavaAnnotation="akasha.core.RegExpLanguage"] DOMString pattern, [JavaAnnotation="akasha.core.RegExpFlags"] optional DOMString flags = "" );

  RegExpResult? exec( DOMString text );

  boolean test( DOMString text );

  stringifier DOMString toString();
};

[JavaSubPackage=core, LegacyNoInterfaceObject]
interface RegExpResult {
  iterable<DOMString>;
  readonly attribute DOMString input;
  readonly attribute unsigned long index;
  readonly attribute RegExpGroups? groups;

  readonly attribute unsigned long length;
  getter DOMString? ( unsigned long index );
};

[JavaSubPackage=core, LegacyNoInterfaceObject]
interface RegExpGroups {
  readonly maplike<DOMString, DOMString>;
};
