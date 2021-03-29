dictionary MyDictionary {
  object? nullableObjectValue;
  object objectValue;
  required object requiredObjectValue;
};

interface MyType1 {
  static readonly attribute object staticReadonlyObjectValue;
  static attribute object staticObjectValue;
  readonly attribute object readonlyObjectValue;
  attribute object objectValue;
  static object staticOjectMethod( object v1, optional object v2 );
  object objectMethod( object v1, optional object v2 );
};

[JavaName=JsObject]
interface Object {
};
