dictionary Dictionary_requiredAnySequenceValue {
  required [SequenceType=Iterable] sequence<any> requiredAnyIterableValue;
  required [SequenceType=IteratorIterable] sequence<any> requiredAnyIteratorIterableValue;
  required [SequenceType=Iterator] sequence<any> requiredAnyIteratorValue;
  required sequence<any> requiredAnySequenceValue;
};

dictionary Dictionary_requiredAnyValue {
  required any requiredAnyValue;
};

dictionary Dictionary_requiredBooleanFrozenArrayValue {
  required FrozenArray<boolean> requiredBooleanFrozenArrayValue;
};

dictionary Dictionary_requiredBooleanSequenceValue {
  required sequence<boolean> requiredBooleanSequenceValue;
};

dictionary Dictionary_requiredBooleanValue {
  required boolean requiredBooleanValue;
};

dictionary Dictionary_requiredByteStringValue {
  required ByteString requiredByteStringValue;
};

dictionary Dictionary_requiredByteValue {
  required byte requiredByteValue;
};

dictionary Dictionary_requiredDOMStringValue {
  required DOMString requiredDOMStringValue;
};

dictionary Dictionary_requiredDoubleFrozenArrayValue {
  required FrozenArray<double> requiredDoubleFrozenArrayValue;
};

dictionary Dictionary_requiredDoubleSequenceSequenceValue {
  required sequence<sequence<double>> requiredDoubleSequenceSequenceValue;
};

dictionary Dictionary_requiredDoubleSequenceValue {
  required sequence<double> requiredDoubleSequenceValue;
};

dictionary Dictionary_requiredDoubleValue {
  required double requiredDoubleValue;
};

dictionary Dictionary_requiredFloatFrozenArrayValue {
  required FrozenArray<float> requiredFloatFrozenArrayValue;
};

dictionary Dictionary_requiredFloatSequenceValue {
  required sequence<float> requiredFloatSequenceValue;
};

dictionary Dictionary_requiredFloatValue {
  required float requiredFloatValue;
};

dictionary Dictionary_requiredLongLongValue {
  required long long requiredLongLongValue;
};

dictionary Dictionary_requiredLongValue {
  required long requiredLongValue;
};

dictionary Dictionary_requiredNullableBooleanFrozenArrayValue {
  required FrozenArray<boolean>? requiredNullableBooleanFrozenArrayValue;
};

dictionary Dictionary_requiredNullableBooleanSequenceValue {
  required sequence<boolean>? requiredNullableBooleanSequenceValue;
};

dictionary Dictionary_requiredNullableBooleanValue {
  required boolean? requiredNullableBooleanValue;
};

dictionary Dictionary_requiredNullableByteStringValue {
  required ByteString? requiredNullableByteStringValue;
};

dictionary Dictionary_requiredNullableByteValue {
  required byte? requiredNullableByteValue;
};

dictionary Dictionary_requiredNullableDOMStringValue {
  required DOMString? requiredNullableDOMStringValue;
};

dictionary Dictionary_requiredNullableDoubleFrozenArrayValue {
  required FrozenArray<double>? requiredNullableDoubleFrozenArrayValue;
};

dictionary Dictionary_requiredNullableDoubleSequenceValue {
  required sequence<double>? requiredNullableDoubleSequenceValue;
};

dictionary Dictionary_requiredNullableDoubleValue {
  required double? requiredNullableDoubleValue;
};

dictionary Dictionary_requiredNullableFloatFrozenArrayValue {
  required FrozenArray<float>? requiredNullableFloatFrozenArrayValue;
};

dictionary Dictionary_requiredNullableFloatSequenceValue {
  required sequence<float>? requiredNullableFloatSequenceValue;
};

dictionary Dictionary_requiredNullableFloatValue {
  required float? requiredNullableFloatValue;
};

dictionary Dictionary_requiredNullableLongLongValue {
  required long long? requiredNullableLongLongValue;
};

dictionary Dictionary_requiredNullableLongValue {
  required long? requiredNullableLongValue;
};

dictionary Dictionary_requiredNullableObjectValue {
  required object? requiredNullableObjectValue;
};

dictionary Dictionary_requiredNullableOctetValue {
  required octet? requiredNullableOctetValue;
};

dictionary Dictionary_requiredNullableShortFrozenArrayValue {
  required FrozenArray<short>? requiredNullableShortFrozenArrayValue;
};

dictionary Dictionary_requiredNullableShortSequenceValue {
  required sequence<short>? requiredNullableShortSequenceValue;
};

dictionary Dictionary_requiredNullableShortValue {
  required short? requiredNullableShortValue;
};

dictionary Dictionary_requiredNullableSomeTypeFrozenArrayValue {
  required FrozenArray<SomeType>? requiredNullableSomeTypeFrozenArrayValue;
};

dictionary Dictionary_requiredNullableSomeTypeSequenceValue {
  required sequence<SomeType>? requiredNullableSomeTypeSequenceValue;
};

dictionary Dictionary_requiredNullableSomeTypeValue {
  required SomeType? requiredNullableSomeTypeValue;
};

dictionary Dictionary_requiredNullableUSVStringValue {
  required USVString? requiredNullableUSVStringValue;
};

dictionary Dictionary_requiredNullableUnrestrictedDoubleValue {
  required unrestricted double? requiredNullableUnrestrictedDoubleValue;
};

dictionary Dictionary_requiredNullableUnrestrictedFloatValue {
  required unrestricted float? requiredNullableUnrestrictedFloatValue;
};

dictionary Dictionary_requiredNullableUnsignedLongLongValue {
  required unsigned long long? requiredNullableUnsignedLongLongValue;
};

dictionary Dictionary_requiredNullableUnsignedLongValue {
  required unsigned long? requiredNullableUnsignedLongValue;
};

dictionary Dictionary_requiredNullableUnsignedShortValue {
  required unsigned short? requiredNullableUnsignedShortValue;
};

dictionary Dictionary_requiredObjectValue {
  required object requiredObjectValue;
};

dictionary Dictionary_requiredOctetValue {
  required octet requiredOctetValue;
};

dictionary Dictionary_requiredShortFrozenArrayValue {
  required FrozenArray<short> requiredShortFrozenArrayValue;
};

dictionary Dictionary_requiredShortSequenceValue {
  required sequence<short> requiredShortSequenceValue;
};

dictionary Dictionary_requiredShortValue {
  required short requiredShortValue;
};

dictionary Dictionary_requiredSomeTypeFrozenArrayValue {
  required FrozenArray<SomeType> requiredSomeTypeFrozenArrayValue;
};

dictionary Dictionary_requiredSomeTypeSequenceValue {
  required sequence<SomeType> requiredSomeTypeSequenceValue;
};

dictionary Dictionary_requiredSomeTypeValue {
  required SomeType requiredSomeTypeValue;
};

dictionary Dictionary_requiredUSVStringValue {
  required USVString requiredUSVStringValue;
};

dictionary Dictionary_requiredUnrestrictedDoubleValue {
  required unrestricted double requiredUnrestrictedDoubleValue;
};

dictionary Dictionary_requiredUnrestrictedFloatValue {
  required unrestricted float requiredUnrestrictedFloatValue;
};

dictionary Dictionary_requiredUnsignedLongLongValue {
  required unsigned long long requiredUnsignedLongLongValue;
};

dictionary Dictionary_requiredUnsignedLongValue {
  required unsigned long requiredUnsignedLongValue;
};

dictionary Dictionary_requiredUnsignedShortValue {
  required unsigned short requiredUnsignedShortValue;
};

dictionary MyDictionary {
  any anyValue;
  FrozenArray<boolean> booleanFrozenArrayValue;
  sequence<boolean> booleanSequenceValue;
  boolean booleanValue;
  record<ByteString, ByteString> byteStringRecordValue;
  ByteString byteStringValue;
  byte byteValue;
  record<DOMString, DOMString> domStringRecordValue;
  DOMString domStringValue;
  FrozenArray<double> doubleFrozenArrayValue;
  record<DOMString, double> doubleRecordValue;
  sequence<double> doubleSequenceValue;
  double doubleValue;
  FrozenArray<float> floatFrozenArrayValue;
  sequence<float> floatSequenceValue;
  float floatValue;
  long long longLongValue;
  long longValue;
  record<DOMString, USVString> mixedStringRecordValue;
  FrozenArray<boolean>? nullableBooleanFrozenArrayValue;
  sequence<boolean>? nullableBooleanSequenceValue;
  boolean? nullableBooleanValue;
  ByteString? nullableByteStringValue;
  byte? nullableByteValue;
  DOMString? nullableDOMStringValue;
  FrozenArray<double>? nullableDoubleFrozenArrayValue;
  sequence<double>? nullableDoubleSequenceValue;
  double? nullableDoubleValue;
  FrozenArray<float>? nullableFloatFrozenArrayValue;
  sequence<float>? nullableFloatSequenceValue;
  float? nullableFloatValue;
  long long? nullableLongLongValue;
  long? nullableLongValue;
  object? nullableObjectValue;
  octet? nullableOctetValue;
  FrozenArray<short>? nullableShortFrozenArrayValue;
  Promise<short?> nullableShortPromiseValue;
  sequence<short>? nullableShortSequenceValue;
  short? nullableShortValue;
  FrozenArray<SomeType>? nullableSomeTypeFrozenArrayValue;
  Promise<SomeType?> nullableSomeTypePromiseValue;
  sequence<SomeType>? nullableSomeTypeSequenceValue;
  SomeType? nullableSomeTypeValue;
  USVString? nullableUSVStringValue;
  unrestricted double? nullableUnrestrictedDoubleValue;
  unrestricted float? nullableUnrestrictedFloatValue;
  unsigned long long? nullableUnsignedLongLongValue;
  unsigned long? nullableUnsignedLongValue;
  unsigned short? nullableUnsignedShortValue;
  object objectValue;
  octet octetValue;
  [SequenceType=Iterable]
  sequence<any> requiredAnyIterableValue;
  [SequenceType=IteratorIterable]
  sequence<any> requiredAnyIteratorIterableValue;
  [SequenceType=Iterator]
  sequence<any> requiredAnyIteratorValue;
  sequence<any> requiredAnySequenceValue;
  Promise<sequence<long long>> sequencePromiseValue;
  FrozenArray<short> shortFrozenArrayValue;
  Promise<short> shortPromiseValue;
  sequence<short> shortSequenceValue;
  short shortValue;
  FrozenArray<SomeType> someTypeFrozenArrayValue;
  Promise<SomeType> someTypePromiseValue;
  sequence<SomeType> someTypeSequenceValue;
  SomeType someTypeValue;
  record<DOMString, SomeType> typeReferenceRecordValue;
  unrestricted double unrestrictedDoubleValue;
  unrestricted float unrestrictedFloatValue;
  unsigned long long unsignedLongLongValue;
  unsigned long unsignedLongValue;
  unsigned short unsignedShortValue;
  record<USVString, USVString> usvStringRecordValue;
  USVString usvStringValue;
  Promise<undefined> voidPromiseValue;
};

[SecureContext]
interface MyType1 {
  readonly attribute any readonlyAnyValue;
  readonly attribute FrozenArray<boolean> readonlyBooleanFrozenArrayValue;
  readonly attribute sequence<boolean> readonlyBooleanSequenceValue;
  readonly attribute boolean readonlyBooleanValue;
  readonly attribute ByteString readonlyByteStringValue;
  readonly attribute byte readonlyByteValue;
  readonly attribute DOMString readonlyDOMStringValue;
  readonly attribute FrozenArray<double> readonlyDoubleFrozenArrayValue;
  readonly attribute sequence<double> readonlyDoubleSequenceValue;
  readonly attribute double readonlyDoubleValue;
  readonly attribute FrozenArray<float> readonlyFloatFrozenArrayValue;
  readonly attribute sequence<float> readonlyFloatSequenceValue;
  readonly attribute float readonlyFloatValue;
  readonly attribute long long readonlyLongLongValue;
  readonly attribute long readonlyLongValue;
  readonly attribute FrozenArray<boolean>? readonlyNullableBooleanFrozenArrayValue;
  readonly attribute sequence<boolean>? readonlyNullableBooleanSequenceValue;
  readonly attribute boolean? readonlyNullableBooleanValue;
  readonly attribute ByteString? readonlyNullableByteStringValue;
  readonly attribute byte? readonlyNullableByteValue;
  readonly attribute DOMString? readonlyNullableDOMStringValue;
  readonly attribute FrozenArray<double>? readonlyNullableDoubleFrozenArrayValue;
  readonly attribute sequence<double>? readonlyNullableDoubleSequenceValue;
  readonly attribute double? readonlyNullableDoubleValue;
  readonly attribute FrozenArray<float>? readonlyNullableFloatFrozenArrayValue;
  readonly attribute sequence<float>? readonlyNullableFloatSequenceValue;
  readonly attribute float? readonlyNullableFloatValue;
  readonly attribute long long? readonlyNullableLongLongValue;
  readonly attribute long? readonlyNullableLongValue;
  readonly attribute object? readonlyNullableObjectValue;
  readonly attribute octet? readonlyNullableOctetValue;
  readonly attribute FrozenArray<short>? readonlyNullableShortFrozenArrayValue;
  readonly attribute Promise<short?> readonlyNullableShortPromiseValue;
  readonly attribute sequence<short>? readonlyNullableShortSequenceValue;
  readonly attribute short? readonlyNullableShortValue;
  readonly attribute FrozenArray<SomeType>? readonlyNullableSomeTypeFrozenArrayValue;
  readonly attribute Promise<SomeType?> readonlyNullableSomeTypePromiseValue;
  readonly attribute sequence<SomeType>? readonlyNullableSomeTypeSequenceValue;
  readonly attribute SomeType? readonlyNullableSomeTypeValue;
  readonly attribute USVString? readonlyNullableUSVStringValue;
  readonly attribute unrestricted double? readonlyNullableUnrestrictedDoubleValue;
  readonly attribute unrestricted float? readonlyNullableUnrestrictedFloatValue;
  readonly attribute unsigned long long? readonlyNullableUnsignedLongLongValue;
  readonly attribute unsigned long? readonlyNullableUnsignedLongValue;
  readonly attribute unsigned short? readonlyNullableUnsignedShortValue;
  readonly attribute object readonlyObjectValue;
  readonly attribute octet readonlyOctetValue;
  readonly attribute FrozenArray<short> readonlyShortFrozenArrayValue;
  readonly attribute Promise<short> readonlyShortPromiseValue;
  readonly attribute sequence<short> readonlyShortSequenceValue;
  readonly attribute short readonlyShortValue;
  readonly attribute FrozenArray<SomeType> readonlySomeTypeFrozenArrayValue;
  readonly attribute Promise<SomeType> readonlySomeTypePromiseValue;
  readonly attribute sequence<SomeType> readonlySomeTypeSequenceValue;
  readonly attribute SomeType readonlySomeTypeValue;
  readonly attribute USVString readonlyUSVStringValue;
  readonly attribute unrestricted double readonlyUnrestrictedDoubleValue;
  readonly attribute unrestricted float readonlyUnrestrictedFloatValue;
  readonly attribute unsigned long long readonlyUnsignedLongLongValue;
  readonly attribute unsigned long readonlyUnsignedLongValue;
  readonly attribute unsigned short readonlyUnsignedShortValue;
  readonly attribute Promise<undefined> readonlyVoidPromiseValue;
  readonly attribute [SequenceType=Iterable] sequence<any> requiredAnyIterableValue;
  readonly attribute [SequenceType=IteratorIterable] sequence<any> requiredAnyIteratorIterableValue;
  readonly attribute [SequenceType=Iterator] sequence<any> requiredAnyIteratorValue;
  readonly attribute sequence<any> requiredAnySequenceValue;
};

[SecureContext]
interface MyType2 {
  attribute any anyValue;
  attribute FrozenArray<boolean> booleanFrozenArrayValue;
  attribute sequence<boolean> booleanSequenceValue;
  attribute boolean booleanValue;
  attribute record<ByteString, ByteString> byteStringRecordValue;
  attribute ByteString byteStringValue;
  attribute byte byteValue;
  attribute record<DOMString, DOMString> domStringRecordValue;
  attribute DOMString domStringValue;
  attribute FrozenArray<double> doubleFrozenArrayValue;
  attribute record<DOMString, double> doubleRecordValue;
  attribute sequence<double> doubleSequenceValue;
  attribute double doubleValue;
  attribute FrozenArray<float> floatFrozenArrayValue;
  attribute sequence<float> floatSequenceValue;
  attribute float floatValue;
  attribute Promise<sequence<long long>> longLongPromiseValue;
  attribute long long longLongValue;
  attribute long longValue;
  attribute record<DOMString, USVString> mixedStringRecordValue;
  attribute FrozenArray<boolean>? nullableBooleanFrozenArrayValue;
  attribute sequence<boolean>? nullableBooleanSequenceValue;
  attribute boolean? nullableBooleanValue;
  attribute ByteString? nullableByteStringValue;
  attribute byte? nullableByteValue;
  attribute DOMString? nullableDOMStringValue;
  attribute FrozenArray<double>? nullableDoubleFrozenArrayValue;
  attribute sequence<double>? nullableDoubleSequenceValue;
  attribute double? nullableDoubleValue;
  attribute FrozenArray<float>? nullableFloatFrozenArrayValue;
  attribute sequence<float>? nullableFloatSequenceValue;
  attribute float? nullableFloatValue;
  attribute long long? nullableLongLongValue;
  attribute long? nullableLongValue;
  attribute object? nullableObjectValue;
  attribute octet? nullableOctetValue;
  attribute FrozenArray<short>? nullableShortFrozenArrayValue;
  attribute Promise<short?> nullableShortPromiseValue;
  attribute sequence<short>? nullableShortSequenceValue;
  attribute short? nullableShortValue;
  attribute FrozenArray<SomeType>? nullableSomeTypeFrozenArrayValue;
  attribute Promise<SomeType?> nullableSomeTypePromiseValue;
  attribute sequence<SomeType>? nullableSomeTypeSequenceValue;
  attribute SomeType? nullableSomeTypeValue;
  attribute USVString? nullableUSVStringValue;
  attribute unrestricted double? nullableUnrestrictedDoubleValue;
  attribute unrestricted float? nullableUnrestrictedFloatValue;
  attribute unsigned long long? nullableUnsignedLongLongValue;
  attribute unsigned long? nullableUnsignedLongValue;
  attribute unsigned short? nullableUnsignedShortValue;
  attribute object objectValue;
  attribute octet octetValue;
  attribute [SequenceType=Iterable] sequence<any> requiredAnyIterableValue;
  attribute [SequenceType=IteratorIterable] sequence<any> requiredAnyIteratorIterableValue;
  attribute [SequenceType=Iterator] sequence<any> requiredAnyIteratorValue;
  attribute sequence<any> requiredAnySequenceValue;
  attribute FrozenArray<short> shortFrozenArrayValue;
  attribute Promise<short> shortPromiseValue;
  attribute sequence<short> shortSequenceValue;
  attribute short shortValue;
  attribute FrozenArray<SomeType> someTypeFrozenArrayValue;
  attribute Promise<SomeType> someTypePromiseValue;
  attribute sequence<SomeType> someTypeSequenceValue;
  attribute SomeType someTypeValue;
  attribute record<DOMString, SomeType> typeReferenceRecordValue;
  attribute unrestricted double unrestrictedDoubleValue;
  attribute unrestricted float unrestrictedFloatValue;
  attribute unsigned long long unsignedLongLongValue;
  attribute unsigned long unsignedLongValue;
  attribute unsigned short unsignedShortValue;
  attribute record<USVString, USVString> usvStringRecordValue;
  attribute USVString usvStringValue;
  attribute Promise<undefined> voidPromiseValue;
};

[SecureContext]
interface MyType3 {
  [SequenceType=Iterable]
  sequence<any> anyIterableMethod( [SequenceType=Iterable] sequence<any> v1, optional [SequenceType=Iterable] sequence<any> v2 );
  [SequenceType=IteratorIterable]
  sequence<any> anyIteratorIterableMethod( [SequenceType=IteratorIterable] sequence<any> v1, optional [SequenceType=IteratorIterable] sequence<any> v2 );
  [SequenceType=Iterator]
  sequence<any> anyIteratorMethod( [SequenceType=Iterator] sequence<any> v1, optional [SequenceType=Iterator] sequence<any> v2 );
  any anyMethod( any v1, optional any v2 );
  sequence<any> anySequenceMethod( sequence<any> v1, optional sequence<any> v2 );
  FrozenArray<boolean> booleanFrozenArrayMethod( FrozenArray<boolean> v1, optional FrozenArray<boolean> v2 );
  boolean booleanMethod( boolean v1, optional boolean v2 );
  sequence<boolean> booleanSequenceMethod( sequence<boolean> v1, optional sequence<boolean> v2 );
  byte byteMethod( byte v1, optional byte v2 );
  ByteString byteStringMethod( ByteString v1, optional ByteString v2 );
  record<ByteString, ByteString> byteStringRecordMethod( record<ByteString, ByteString> v1, optional record<ByteString, ByteString> v2 );
  DOMString domStringMethod( DOMString v1, optional DOMString v2 );
  record<DOMString, DOMString> domStringRecordMethod( record<DOMString, DOMString> v1, optional record<DOMString, DOMString> v2 );
  FrozenArray<double> doubleFrozenArrayMethod( FrozenArray<double> v1, optional FrozenArray<double> v2 );
  double doubleMethod( double v1, optional double v2 );
  record<DOMString, double> doubleRecordMethod( record<DOMString, double> v1, optional record<DOMString, double> v2 );
  sequence<double> doubleSequenceMethod( sequence<double> v1, optional sequence<double> v2 );
  FrozenArray<float> floatFrozenArrayMethod( FrozenArray<float> v1, optional FrozenArray<float> v2 );
  float floatMethod( float v1, optional float v2 );
  sequence<float> floatSequenceMethod( sequence<float> v1, optional sequence<float> v2 );
  long long longLongMethod( long long v1, optional long long v2 );
  Promise<sequence<long long>> longLongPromiseMethod( Promise<sequence<long long>> v1, optional Promise<sequence<long long>> v2 );
  long longMethod( long v1, optional long v2 );
  record<DOMString, USVString> mixedStringRecordMethod( record<DOMString, USVString> v1, optional record<DOMString, USVString> v2 );
  FrozenArray<boolean>? nullableBooleanFrozenArrayMethod( FrozenArray<boolean>? v1, optional FrozenArray<boolean>? v2 );
  boolean? nullableBooleanMethod( boolean? v1, optional boolean? v2 );
  sequence<boolean>? nullableBooleanSequenceMethod( sequence<boolean>? v1, optional sequence<boolean>? v2 );
  byte? nullableByteMethod( byte? v1, optional byte? v2 );
  ByteString? nullableByteStringMethod( ByteString? v1, optional ByteString? v2 );
  DOMString? nullableDOMStringMethod( DOMString? v1, optional DOMString? v2 );
  FrozenArray<double>? nullableDoubleFrozenArrayMethod( FrozenArray<double>? v1, optional FrozenArray<double>? v2 );
  double? nullableDoubleMethod( double? v1, optional double? v2 );
  sequence<double>? nullableDoubleSequenceMethod( sequence<double>? v1, optional sequence<double>? v2 );
  FrozenArray<float>? nullableFloatFrozenArrayMethod( FrozenArray<float>? v1, optional FrozenArray<float>? v2 );
  float? nullableFloatMethod( float? v1, optional float? v2 );
  sequence<float>? nullableFloatSequenceMethod( sequence<float>? v1, optional sequence<float>? v2 );
  long long? nullableLongLongMethod( long long? v1, optional long long? v2 );
  long? nullableLongMethod( long? v1, optional long? v2 );
  object? nullableObjectMethod( object? v1, optional object? v2 );
  octet? nullableOctetMethod( octet? v1, optional octet? v2 );
  FrozenArray<short>? nullableShortFrozenArrayMethod( FrozenArray<short>? v1, optional FrozenArray<short>? v2 );
  short? nullableShortMethod( short? v1, optional short? v2 );
  Promise<short?> nullableShortPromiseMethod( Promise<short?> v1, optional Promise<short?> v2 );
  sequence<short>? nullableShortSequenceMethod( sequence<short>? v1, optional sequence<short>? v2 );
  FrozenArray<SomeType>? nullableSomeTypeFrozenArrayMethod( FrozenArray<SomeType>? v1, optional FrozenArray<SomeType>? v2 );
  SomeType? nullableSomeTypeMethod( SomeType? v1, optional SomeType? v2 );
  Promise<SomeType?> nullableSomeTypePromiseMethod( Promise<SomeType?> v1, optional Promise<SomeType?> v2 );
  sequence<SomeType>? nullableSomeTypeSequenceMethod( sequence<SomeType>? v1, optional sequence<SomeType>? v2 );
  USVString? nullableUSVStringMethod( USVString? v1, optional USVString? v2 );
  unrestricted double? nullableUnrestrictedDoubleMethod( unrestricted double? v1, optional unrestricted double? v2 );
  unrestricted float? nullableUnrestrictedFloatMethod( unrestricted float? v1, optional unrestricted float? v2 );
  unsigned long long? nullableUnsignedLongLongMethod( unsigned long long? v1, optional unsigned long long? v2 );
  unsigned long? nullableUnsignedLongMethod( unsigned long? v1, optional unsigned long? v2 );
  unsigned short? nullableUnsignedShortMethod( unsigned short? v1, optional unsigned short? v2 );
  object objectMethod( object v1, optional object v2 );
  octet octetMethod( octet v1, optional octet v2 );
  FrozenArray<short> shortFrozenArrayMethod( FrozenArray<short> v1, optional FrozenArray<short> v2 );
  short shortMethod( short v1, optional short v2 );
  Promise<short> shortPromiseMethod( Promise<short> v1, optional Promise<short> v2 );
  sequence<short> shortSequenceMethod( sequence<short> v1, optional sequence<short> v2 );
  FrozenArray<SomeType> someTypeFrozenArrayMethod( FrozenArray<SomeType> v1, optional FrozenArray<SomeType> v2 );
  SomeType someTypeMethod( SomeType v1, optional SomeType v2 );
  Promise<SomeType> someTypePromiseMethod( Promise<SomeType> v1, optional Promise<SomeType> v2 );
  sequence<SomeType> someTypeSequenceMethod( sequence<SomeType> v1, optional sequence<SomeType> v2 );
  record<DOMString, SomeType> typeReferenceRecordMethod( record<DOMString, SomeType> v1, optional record<DOMString, SomeType> v2 );
  unrestricted double unrestrictedDoubleMethod( unrestricted double v1, optional unrestricted double v2 );
  unrestricted float unrestrictedFloatMethod( unrestricted float v1, optional unrestricted float v2 );
  unsigned long long unsignedLongLongMethod( unsigned long long v1, optional unsigned long long v2 );
  unsigned long unsignedLongMethod( unsigned long v1, optional unsigned long v2 );
  unsigned short unsignedShortMethod( unsigned short v1, optional unsigned short v2 );
  USVString usvStringMethod( USVString v1, optional USVString v2 );
  record<USVString, USVString> usvStringRecordMethod( record<USVString, USVString> v1, optional record<USVString, USVString> v2 );
  Promise<undefined> voidPromiseMethod( Promise<undefined> v1, optional Promise<undefined> v2 );
};

[SecureContext]
interface MyType4 {
  [SequenceType=Iterable]
  static sequence<any> anyIterableMethod( [SequenceType=Iterable] sequence<any> v1, optional [SequenceType=Iterable] sequence<any> v2 );
  [SequenceType=IteratorIterable]
  static sequence<any> anyIteratorIterableMethod( [SequenceType=IteratorIterable] sequence<any> v1, optional [SequenceType=IteratorIterable] sequence<any> v2 );
  [SequenceType=Iterator]
  static sequence<any> anyIteratorMethod( [SequenceType=Iterator] sequence<any> v1, optional [SequenceType=Iterator] sequence<any> v2 );
  static any anyMethod( any v1, optional any v2 );
  static sequence<any> anySequenceMethod( sequence<any> v1, optional sequence<any> v2 );
  static FrozenArray<boolean> booleanFrozenArrayMethod( FrozenArray<boolean> v1, optional FrozenArray<boolean> v2 );
  static boolean booleanMethod( boolean v1, optional boolean v2 );
  static sequence<boolean> booleanSequenceMethod( sequence<boolean> v1, optional sequence<boolean> v2 );
  static byte byteMethod( byte v1, optional byte v2 );
  static ByteString byteStringMethod( ByteString v1, optional ByteString v2 );
  static record<ByteString, ByteString> byteStringRecordMethod( record<ByteString, ByteString> v1, optional record<ByteString, ByteString> v2 );
  static DOMString domStringMethod( DOMString v1, optional DOMString v2 );
  static record<DOMString, DOMString> domStringRecordMethod( record<DOMString, DOMString> v1, optional record<DOMString, DOMString> v2 );
  static FrozenArray<double> doubleFrozenArrayMethod( FrozenArray<double> v1, optional FrozenArray<double> v2 );
  static double doubleMethod( double v1, optional double v2 );
  static record<DOMString, double> doubleRecordMethod( record<DOMString, double> v1, optional record<DOMString, double> v2 );
  static sequence<double> doubleSequenceMethod( sequence<double> v1, optional sequence<double> v2 );
  static FrozenArray<float> floatFrozenArrayMethod( FrozenArray<float> v1, optional FrozenArray<float> v2 );
  static float floatMethod( float v1, optional float v2 );
  static sequence<float> floatSequenceMethod( sequence<float> v1, optional sequence<float> v2 );
  static long long longLongMethod( long long v1, optional long long v2 );
  static Promise<sequence<long long>> longLongPromiseMethod( Promise<sequence<long long>> v1, optional Promise<sequence<long long>> v2 );
  static long longMethod( long v1, optional long v2 );
  static record<DOMString, USVString> mixedStringRecordMethod( record<DOMString, USVString> v1, optional record<DOMString, USVString> v2 );
  static FrozenArray<boolean>? nullableBooleanFrozenArrayMethod( FrozenArray<boolean>? v1, optional FrozenArray<boolean>? v2 );
  static boolean? nullableBooleanMethod( boolean? v1, optional boolean? v2 );
  static sequence<boolean>? nullableBooleanSequenceMethod( sequence<boolean>? v1, optional sequence<boolean>? v2 );
  static byte? nullableByteMethod( byte? v1, optional byte? v2 );
  static ByteString? nullableByteStringMethod( ByteString? v1, optional ByteString? v2 );
  static DOMString? nullableDOMStringMethod( DOMString? v1, optional DOMString? v2 );
  static FrozenArray<double>? nullableDoubleFrozenArrayMethod( FrozenArray<double>? v1, optional FrozenArray<double>? v2 );
  static double? nullableDoubleMethod( double? v1, optional double? v2 );
  static sequence<double>? nullableDoubleSequenceMethod( sequence<double>? v1, optional sequence<double>? v2 );
  static FrozenArray<float>? nullableFloatFrozenArrayMethod( FrozenArray<float>? v1, optional FrozenArray<float>? v2 );
  static float? nullableFloatMethod( float? v1, optional float? v2 );
  static sequence<float>? nullableFloatSequenceMethod( sequence<float>? v1, optional sequence<float>? v2 );
  static long long? nullableLongLongMethod( long long? v1, optional long long? v2 );
  static long? nullableLongMethod( long? v1, optional long? v2 );
  static object? nullableObjectMethod( object? v1, optional object? v2 );
  static octet? nullableOctetMethod( octet? v1, optional octet? v2 );
  static FrozenArray<short>? nullableShortFrozenArrayMethod( FrozenArray<short>? v1, optional FrozenArray<short>? v2 );
  static short? nullableShortMethod( short? v1, optional short? v2 );
  static Promise<short?> nullableShortPromiseMethod( Promise<short?> v1, optional Promise<short?> v2 );
  static sequence<short>? nullableShortSequenceMethod( sequence<short>? v1, optional sequence<short>? v2 );
  static FrozenArray<SomeType>? nullableSomeTypeFrozenArrayMethod( FrozenArray<SomeType>? v1, optional FrozenArray<SomeType>? v2 );
  static SomeType? nullableSomeTypeMethod( SomeType? v1, optional SomeType? v2 );
  static Promise<SomeType?> nullableSomeTypePromiseMethod( Promise<SomeType?> v1, optional Promise<SomeType?> v2 );
  static sequence<SomeType>? nullableSomeTypeSequenceMethod( sequence<SomeType>? v1, optional sequence<SomeType>? v2 );
  static USVString? nullableUSVStringMethod( USVString? v1, optional USVString? v2 );
  static unrestricted double? nullableUnrestrictedDoubleMethod( unrestricted double? v1, optional unrestricted double? v2 );
  static unrestricted float? nullableUnrestrictedFloatMethod( unrestricted float? v1, optional unrestricted float? v2 );
  static unsigned long long? nullableUnsignedLongLongMethod( unsigned long long? v1, optional unsigned long long? v2 );
  static unsigned long? nullableUnsignedLongMethod( unsigned long? v1, optional unsigned long? v2 );
  static unsigned short? nullableUnsignedShortMethod( unsigned short? v1, optional unsigned short? v2 );
  static object objectMethod( object v1, optional object v2 );
  static octet octetMethod( octet v1, optional octet v2 );
  static FrozenArray<short> shortFrozenArrayMethod( FrozenArray<short> v1, optional FrozenArray<short> v2 );
  static short shortMethod( short v1, optional short v2 );
  static Promise<short> shortPromiseMethod( Promise<short> v1, optional Promise<short> v2 );
  static sequence<short> shortSequenceMethod( sequence<short> v1, optional sequence<short> v2 );
  static FrozenArray<SomeType> someTypeFrozenArrayMethod( FrozenArray<SomeType> v1, optional FrozenArray<SomeType> v2 );
  static SomeType someTypeMethod( SomeType v1, optional SomeType v2 );
  static Promise<SomeType> someTypePromiseMethod( Promise<SomeType> v1, optional Promise<SomeType> v2 );
  static sequence<SomeType> someTypeSequenceMethod( sequence<SomeType> v1, optional sequence<SomeType> v2 );
  static record<DOMString, SomeType> typeReferenceRecordMethod( record<DOMString, SomeType> v1, optional record<DOMString, SomeType> v2 );
  static unrestricted double unrestrictedDoubleMethod( unrestricted double v1, optional unrestricted double v2 );
  static unrestricted float unrestrictedFloatMethod( unrestricted float v1, optional unrestricted float v2 );
  static unsigned long long unsignedLongLongMethod( unsigned long long v1, optional unsigned long long v2 );
  static unsigned long unsignedLongMethod( unsigned long v1, optional unsigned long v2 );
  static unsigned short unsignedShortMethod( unsigned short v1, optional unsigned short v2 );
  static USVString usvStringMethod( USVString v1, optional USVString v2 );
  static record<USVString, USVString> usvStringRecordMethod( record<USVString, USVString> v1, optional record<USVString, USVString> v2 );
  static Promise<undefined> voidPromiseMethod( Promise<undefined> v1, optional Promise<undefined> v2 );
};

/**
 * Interface contains static read-only attributes.
 */
[SecureContext]
interface MyType5 {
  static readonly attribute any readonlyAnyValue;
  static readonly attribute FrozenArray<boolean> readonlyBooleanFrozenArrayValue;
  static readonly attribute sequence<boolean> readonlyBooleanSequenceValue;
  static readonly attribute boolean readonlyBooleanValue;
  static readonly attribute ByteString readonlyByteStringValue;
  static readonly attribute byte readonlyByteValue;
  static readonly attribute DOMString readonlyDOMStringValue;
  static readonly attribute FrozenArray<double> readonlyDoubleFrozenArrayValue;
  static readonly attribute sequence<double> readonlyDoubleSequenceValue;
  static readonly attribute double readonlyDoubleValue;
  static readonly attribute FrozenArray<float> readonlyFloatFrozenArrayValue;
  static readonly attribute sequence<float> readonlyFloatSequenceValue;
  static readonly attribute float readonlyFloatValue;
  static readonly attribute long long readonlyLongLongValue;
  static readonly attribute long readonlyLongValue;
  static readonly attribute FrozenArray<boolean>? readonlyNullableBooleanFrozenArrayValue;
  static readonly attribute sequence<boolean>? readonlyNullableBooleanSequenceValue;
  static readonly attribute boolean? readonlyNullableBooleanValue;
  static readonly attribute ByteString? readonlyNullableByteStringValue;
  static readonly attribute byte? readonlyNullableByteValue;
  static readonly attribute DOMString? readonlyNullableDOMStringValue;
  static readonly attribute FrozenArray<double>? readonlyNullableDoubleFrozenArrayValue;
  static readonly attribute sequence<double>? readonlyNullableDoubleSequenceValue;
  static readonly attribute double? readonlyNullableDoubleValue;
  static readonly attribute FrozenArray<float>? readonlyNullableFloatFrozenArrayValue;
  static readonly attribute sequence<float>? readonlyNullableFloatSequenceValue;
  static readonly attribute float? readonlyNullableFloatValue;
  static readonly attribute long long? readonlyNullableLongLongValue;
  static readonly attribute long? readonlyNullableLongValue;
  static readonly attribute object? readonlyNullableObjectValue;
  static readonly attribute octet? readonlyNullableOctetValue;
  static readonly attribute FrozenArray<short>? readonlyNullableShortFrozenArrayValue;
  static readonly attribute Promise<short?> readonlyNullableShortPromiseValue;
  static readonly attribute sequence<short>? readonlyNullableShortSequenceValue;
  static readonly attribute short? readonlyNullableShortValue;
  static readonly attribute FrozenArray<SomeType>? readonlyNullableSomeTypeFrozenArrayValue;
  static readonly attribute Promise<SomeType?> readonlyNullableSomeTypePromiseValue;
  static readonly attribute sequence<SomeType>? readonlyNullableSomeTypeSequenceValue;
  static readonly attribute SomeType? readonlyNullableSomeTypeValue;
  static readonly attribute USVString? readonlyNullableUSVStringValue;
  static readonly attribute unrestricted double? readonlyNullableUnrestrictedDoubleValue;
  static readonly attribute unrestricted float? readonlyNullableUnrestrictedFloatValue;
  static readonly attribute unsigned long long? readonlyNullableUnsignedLongLongValue;
  static readonly attribute unsigned long? readonlyNullableUnsignedLongValue;
  static readonly attribute unsigned short? readonlyNullableUnsignedShortValue;
  static readonly attribute object readonlyObjectValue;
  static readonly attribute octet readonlyOctetValue;
  static readonly attribute FrozenArray<short> readonlyShortFrozenArrayValue;
  static readonly attribute Promise<short> readonlyShortPromiseValue;
  static readonly attribute sequence<short> readonlyShortSequenceValue;
  static readonly attribute short readonlyShortValue;
  static readonly attribute FrozenArray<SomeType> readonlySomeTypeFrozenArrayValue;
  static readonly attribute Promise<SomeType> readonlySomeTypePromiseValue;
  static readonly attribute sequence<SomeType> readonlySomeTypeSequenceValue;
  static readonly attribute SomeType readonlySomeTypeValue;
  static readonly attribute USVString readonlyUSVStringValue;
  static readonly attribute unrestricted double readonlyUnrestrictedDoubleValue;
  static readonly attribute unrestricted float readonlyUnrestrictedFloatValue;
  static readonly attribute unsigned long long readonlyUnsignedLongLongValue;
  static readonly attribute unsigned long readonlyUnsignedLongValue;
  static readonly attribute unsigned short readonlyUnsignedShortValue;
  static readonly attribute Promise<undefined> readonlyVoidPromiseValue;
  static readonly attribute [SequenceType=Iterable] sequence<any> requiredAnyIterableValue;
  static readonly attribute [SequenceType=IteratorIterable] sequence<any> requiredAnyIteratorIterableValue;
  static readonly attribute [SequenceType=Iterator] sequence<any> requiredAnyIteratorValue;
  static readonly attribute sequence<any> requiredAnySequenceValue;
};

/**
 * Interface contains static mutable attributes.
 */
[SecureContext]
interface MyType6 {
  static attribute any anyValue;
  static attribute FrozenArray<boolean> booleanFrozenArrayValue;
  static attribute sequence<boolean> booleanSequenceValue;
  static attribute boolean booleanValue;
  static attribute record<ByteString, ByteString> byteStringRecordValue;
  static attribute ByteString byteStringValue;
  static attribute byte byteValue;
  static attribute record<DOMString, DOMString> domStringRecordValue;
  static attribute DOMString domStringValue;
  static attribute FrozenArray<double> doubleFrozenArrayValue;
  static attribute record<DOMString, double> doubleRecordValue;
  static attribute sequence<double> doubleSequenceValue;
  static attribute double doubleValue;
  static attribute FrozenArray<float> floatFrozenArrayValue;
  static attribute sequence<float> floatSequenceValue;
  static attribute float floatValue;
  static attribute Promise<sequence<long long>> longLongPromiseValue;
  static attribute long long longLongValue;
  static attribute long longValue;
  static attribute record<DOMString, USVString> mixedStringRecordValue;
  static attribute FrozenArray<boolean>? nullableBooleanFrozenArrayValue;
  static attribute sequence<boolean>? nullableBooleanSequenceValue;
  static attribute boolean? nullableBooleanValue;
  static attribute ByteString? nullableByteStringValue;
  static attribute byte? nullableByteValue;
  static attribute DOMString? nullableDOMStringValue;
  static attribute FrozenArray<double>? nullableDoubleFrozenArrayValue;
  static attribute sequence<double>? nullableDoubleSequenceValue;
  static attribute double? nullableDoubleValue;
  static attribute FrozenArray<float>? nullableFloatFrozenArrayValue;
  static attribute sequence<float>? nullableFloatSequenceValue;
  static attribute float? nullableFloatValue;
  static attribute long long? nullableLongLongValue;
  static attribute long? nullableLongValue;
  static attribute object? nullableObjectValue;
  static attribute octet? nullableOctetValue;
  static attribute FrozenArray<short>? nullableShortFrozenArrayValue;
  static attribute Promise<short?> nullableShortPromiseValue;
  static attribute sequence<short>? nullableShortSequenceValue;
  static attribute short? nullableShortValue;
  static attribute FrozenArray<SomeType>? nullableSomeTypeFrozenArrayValue;
  static attribute Promise<SomeType?> nullableSomeTypePromiseValue;
  static attribute sequence<SomeType>? nullableSomeTypeSequenceValue;
  static attribute SomeType? nullableSomeTypeValue;
  static attribute USVString? nullableUSVStringValue;
  static attribute unrestricted double? nullableUnrestrictedDoubleValue;
  static attribute unrestricted float? nullableUnrestrictedFloatValue;
  static attribute unsigned long long? nullableUnsignedLongLongValue;
  static attribute unsigned long? nullableUnsignedLongValue;
  static attribute unsigned short? nullableUnsignedShortValue;
  static attribute object objectValue;
  static attribute octet octetValue;
  static attribute [SequenceType=Iterable] sequence<any> requiredAnyIterableValue;
  static attribute [SequenceType=IteratorIterable] sequence<any> requiredAnyIteratorIterableValue;
  static attribute [SequenceType=Iterator] sequence<any> requiredAnyIteratorValue;
  static attribute sequence<any> requiredAnySequenceValue;
  static attribute FrozenArray<short> shortFrozenArrayValue;
  static attribute Promise<short> shortPromiseValue;
  static attribute sequence<short> shortSequenceValue;
  static attribute short shortValue;
  static attribute FrozenArray<SomeType> someTypeFrozenArrayValue;
  static attribute Promise<SomeType> someTypePromiseValue;
  static attribute sequence<SomeType> someTypeSequenceValue;
  static attribute SomeType someTypeValue;
  static attribute record<DOMString, SomeType> typeReferenceRecordValue;
  static attribute unrestricted double unrestrictedDoubleValue;
  static attribute unrestricted float unrestrictedFloatValue;
  static attribute unsigned long long unsignedLongLongValue;
  static attribute unsigned long unsignedLongValue;
  static attribute unsigned short unsignedShortValue;
  static attribute record<USVString, USVString> usvStringRecordValue;
  static attribute USVString usvStringValue;
  static attribute Promise<undefined> voidPromiseValue;
};

[SecureContext]
interface SomeType {
};
