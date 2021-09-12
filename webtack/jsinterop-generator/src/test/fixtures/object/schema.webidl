dictionary MyDictionary {
  required object requiredObjectValue;
  object? nullableObjectValue;
  object objectValue;
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
