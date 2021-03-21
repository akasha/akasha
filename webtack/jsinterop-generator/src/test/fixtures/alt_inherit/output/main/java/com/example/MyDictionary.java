package com.example;

import com.other.JsArray;
import com.other.JsIterable;
import com.other.JsIterator;
import com.other.JsIteratorIterable;
import com.other.JsPromise;
import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public interface MyDictionary {
  @JsOverlay
  @Nonnull
  static MyDictionary create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "anyValue"
  )
  @Nullable
  Any anyValue();

  @JsProperty
  void setAnyValue(@DoNotAutobox @Nullable Object anyValue);

  @JsOverlay
  @Nonnull
  default MyDictionary anyValue(@DoNotAutobox @Nullable final Object anyValue) {
    setAnyValue( anyValue );
    return this;
  }

  @JsProperty(
      name = "booleanFrozenArrayValue"
  )
  JsArray<Boolean> booleanFrozenArrayValue();

  @JsProperty
  void setBooleanFrozenArrayValue(@Nonnull JsArray<Boolean> booleanFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary booleanFrozenArrayValue(
      @Nonnull final JsArray<Boolean> booleanFrozenArrayValue) {
    setBooleanFrozenArrayValue( booleanFrozenArrayValue );
    return this;
  }

  @JsProperty(
      name = "booleanSequenceValue"
  )
  JsArray<Boolean> booleanSequenceValue();

  @JsProperty
  void setBooleanSequenceValue(@Nonnull JsArray<Boolean> booleanSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary booleanSequenceValue(@Nonnull final JsArray<Boolean> booleanSequenceValue) {
    setBooleanSequenceValue( booleanSequenceValue );
    return this;
  }

  @JsOverlay
  default void setBooleanSequenceValue(@Nonnull final Boolean... booleanSequenceValue) {
    setBooleanSequenceValue( Js.<JsArray<Boolean>>uncheckedCast( booleanSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary booleanSequenceValue(@Nonnull final Boolean... booleanSequenceValue) {
    setBooleanSequenceValue( booleanSequenceValue );
    return this;
  }

  @JsProperty(
      name = "booleanValue"
  )
  boolean booleanValue();

  @JsProperty
  void setBooleanValue(boolean booleanValue);

  @JsOverlay
  @Nonnull
  default MyDictionary booleanValue(final boolean booleanValue) {
    setBooleanValue( booleanValue );
    return this;
  }

  @JsProperty(
      name = "byteStringRecordValue"
  )
  JsPropertyMap<String> byteStringRecordValue();

  @JsProperty
  void setByteStringRecordValue(@Nonnull JsPropertyMap<String> byteStringRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary byteStringRecordValue(
      @Nonnull final JsPropertyMap<String> byteStringRecordValue) {
    setByteStringRecordValue( byteStringRecordValue );
    return this;
  }

  @JsProperty(
      name = "byteStringValue"
  )
  String byteStringValue();

  @JsProperty
  void setByteStringValue(@Nonnull String byteStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary byteStringValue(@Nonnull final String byteStringValue) {
    setByteStringValue( byteStringValue );
    return this;
  }

  @JsProperty(
      name = "byteValue"
  )
  byte byteValue();

  @JsProperty
  void setByteValue(byte byteValue);

  @JsOverlay
  @Nonnull
  default MyDictionary byteValue(final byte byteValue) {
    setByteValue( byteValue );
    return this;
  }

  @JsProperty(
      name = "domStringRecordValue"
  )
  JsPropertyMap<String> domStringRecordValue();

  @JsProperty
  void setDomStringRecordValue(@Nonnull JsPropertyMap<String> domStringRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary domStringRecordValue(
      @Nonnull final JsPropertyMap<String> domStringRecordValue) {
    setDomStringRecordValue( domStringRecordValue );
    return this;
  }

  @JsProperty(
      name = "domStringValue"
  )
  String domStringValue();

  @JsProperty
  void setDomStringValue(@Nonnull String domStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary domStringValue(@Nonnull final String domStringValue) {
    setDomStringValue( domStringValue );
    return this;
  }

  @JsProperty(
      name = "doubleFrozenArrayValue"
  )
  JsArray<Double> doubleFrozenArrayValue();

  @JsProperty
  void setDoubleFrozenArrayValue(@Nonnull JsArray<Double> doubleFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary doubleFrozenArrayValue(
      @Nonnull final JsArray<Double> doubleFrozenArrayValue) {
    setDoubleFrozenArrayValue( doubleFrozenArrayValue );
    return this;
  }

  @JsProperty(
      name = "doubleRecordValue"
  )
  JsPropertyMap<Double> doubleRecordValue();

  @JsProperty
  void setDoubleRecordValue(@Nonnull JsPropertyMap<Double> doubleRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary doubleRecordValue(@Nonnull final JsPropertyMap<Double> doubleRecordValue) {
    setDoubleRecordValue( doubleRecordValue );
    return this;
  }

  @JsProperty(
      name = "doubleSequenceValue"
  )
  JsArray<Double> doubleSequenceValue();

  @JsProperty
  void setDoubleSequenceValue(@Nonnull JsArray<Double> doubleSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary doubleSequenceValue(@Nonnull final JsArray<Double> doubleSequenceValue) {
    setDoubleSequenceValue( doubleSequenceValue );
    return this;
  }

  @JsOverlay
  default void setDoubleSequenceValue(@Nonnull final double... doubleSequenceValue) {
    setDoubleSequenceValue( Js.<JsArray<Double>>uncheckedCast( doubleSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary doubleSequenceValue(@Nonnull final double... doubleSequenceValue) {
    setDoubleSequenceValue( doubleSequenceValue );
    return this;
  }

  @JsProperty(
      name = "doubleValue"
  )
  double doubleValue();

  @JsProperty
  void setDoubleValue(double doubleValue);

  @JsOverlay
  @Nonnull
  default MyDictionary doubleValue(final double doubleValue) {
    setDoubleValue( doubleValue );
    return this;
  }

  @JsProperty(
      name = "floatFrozenArrayValue"
  )
  JsArray<Double> floatFrozenArrayValue();

  @JsProperty
  void setFloatFrozenArrayValue(@Nonnull JsArray<Double> floatFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary floatFrozenArrayValue(@Nonnull final JsArray<Double> floatFrozenArrayValue) {
    setFloatFrozenArrayValue( floatFrozenArrayValue );
    return this;
  }

  @JsProperty(
      name = "floatSequenceValue"
  )
  JsArray<Double> floatSequenceValue();

  @JsProperty
  void setFloatSequenceValue(@Nonnull JsArray<Double> floatSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary floatSequenceValue(@Nonnull final JsArray<Double> floatSequenceValue) {
    setFloatSequenceValue( floatSequenceValue );
    return this;
  }

  @JsOverlay
  default void setFloatSequenceValue(@Nonnull final double... floatSequenceValue) {
    setFloatSequenceValue( Js.<JsArray<Double>>uncheckedCast( floatSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary floatSequenceValue(@Nonnull final double... floatSequenceValue) {
    setFloatSequenceValue( floatSequenceValue );
    return this;
  }

  @JsProperty(
      name = "floatValue"
  )
  float floatValue();

  @JsProperty
  void setFloatValue(float floatValue);

  @JsOverlay
  @Nonnull
  default MyDictionary floatValue(final float floatValue) {
    setFloatValue( floatValue );
    return this;
  }

  @JsProperty(
      name = "longLongValue"
  )
  int longLongValue();

  @JsProperty
  void setLongLongValue(int longLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary longLongValue(final int longLongValue) {
    setLongLongValue( longLongValue );
    return this;
  }

  @JsProperty(
      name = "longValue"
  )
  int longValue();

  @JsProperty
  void setLongValue(int longValue);

  @JsOverlay
  @Nonnull
  default MyDictionary longValue(final int longValue) {
    setLongValue( longValue );
    return this;
  }

  @JsProperty(
      name = "mixedStringRecordValue"
  )
  JsPropertyMap<String> mixedStringRecordValue();

  @JsProperty
  void setMixedStringRecordValue(@Nonnull JsPropertyMap<String> mixedStringRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary mixedStringRecordValue(
      @Nonnull final JsPropertyMap<String> mixedStringRecordValue) {
    setMixedStringRecordValue( mixedStringRecordValue );
    return this;
  }

  @JsProperty(
      name = "nullableBooleanFrozenArrayValue"
  )
  @Nullable
  JsArray<Boolean> nullableBooleanFrozenArrayValue();

  @JsProperty
  void setNullableBooleanFrozenArrayValue(
      @Nullable JsArray<Boolean> nullableBooleanFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableBooleanFrozenArrayValue(
      @Nullable final JsArray<Boolean> nullableBooleanFrozenArrayValue) {
    setNullableBooleanFrozenArrayValue( nullableBooleanFrozenArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableBooleanSequenceValue"
  )
  @Nullable
  JsArray<Boolean> nullableBooleanSequenceValue();

  @JsProperty
  void setNullableBooleanSequenceValue(@Nullable JsArray<Boolean> nullableBooleanSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableBooleanSequenceValue(
      @Nullable final JsArray<Boolean> nullableBooleanSequenceValue) {
    setNullableBooleanSequenceValue( nullableBooleanSequenceValue );
    return this;
  }

  @JsOverlay
  default void setNullableBooleanSequenceValue(
      @Nullable final Boolean... nullableBooleanSequenceValue) {
    setNullableBooleanSequenceValue( Js.<JsArray<Boolean>>uncheckedCast( nullableBooleanSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableBooleanSequenceValue(
      @Nullable final Boolean... nullableBooleanSequenceValue) {
    setNullableBooleanSequenceValue( nullableBooleanSequenceValue );
    return this;
  }

  @JsProperty(
      name = "nullableBooleanValue"
  )
  @Nullable
  Boolean nullableBooleanValue();

  @JsProperty
  void setNullableBooleanValue(@Nullable Boolean nullableBooleanValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableBooleanValue(@Nullable final Boolean nullableBooleanValue) {
    setNullableBooleanValue( nullableBooleanValue );
    return this;
  }

  @JsProperty(
      name = "nullableByteStringValue"
  )
  @Nullable
  String nullableByteStringValue();

  @JsProperty
  void setNullableByteStringValue(@Nullable String nullableByteStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableByteStringValue(@Nullable final String nullableByteStringValue) {
    setNullableByteStringValue( nullableByteStringValue );
    return this;
  }

  @JsProperty(
      name = "nullableByteValue"
  )
  @Nullable
  Double nullableByteValue();

  @JsProperty
  void setNullableByteValue(@Nullable Double nullableByteValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableByteValue(@Nullable final Double nullableByteValue) {
    setNullableByteValue( nullableByteValue );
    return this;
  }

  @JsProperty(
      name = "nullableDOMStringValue"
  )
  @Nullable
  String nullableDOMStringValue();

  @JsProperty
  void setNullableDOMStringValue(@Nullable String nullableDOMStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDOMStringValue(@Nullable final String nullableDOMStringValue) {
    setNullableDOMStringValue( nullableDOMStringValue );
    return this;
  }

  @JsProperty(
      name = "nullableDoubleFrozenArrayValue"
  )
  @Nullable
  JsArray<Double> nullableDoubleFrozenArrayValue();

  @JsProperty
  void setNullableDoubleFrozenArrayValue(@Nullable JsArray<Double> nullableDoubleFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDoubleFrozenArrayValue(
      @Nullable final JsArray<Double> nullableDoubleFrozenArrayValue) {
    setNullableDoubleFrozenArrayValue( nullableDoubleFrozenArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableDoubleSequenceValue"
  )
  @Nullable
  JsArray<Double> nullableDoubleSequenceValue();

  @JsProperty
  void setNullableDoubleSequenceValue(@Nullable JsArray<Double> nullableDoubleSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDoubleSequenceValue(
      @Nullable final JsArray<Double> nullableDoubleSequenceValue) {
    setNullableDoubleSequenceValue( nullableDoubleSequenceValue );
    return this;
  }

  @JsOverlay
  default void setNullableDoubleSequenceValue(
      @Nullable final double... nullableDoubleSequenceValue) {
    setNullableDoubleSequenceValue( Js.<JsArray<Double>>uncheckedCast( nullableDoubleSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDoubleSequenceValue(
      @Nullable final double... nullableDoubleSequenceValue) {
    setNullableDoubleSequenceValue( nullableDoubleSequenceValue );
    return this;
  }

  @JsProperty(
      name = "nullableDoubleValue"
  )
  @Nullable
  Double nullableDoubleValue();

  @JsProperty
  void setNullableDoubleValue(@Nullable Double nullableDoubleValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDoubleValue(@Nullable final Double nullableDoubleValue) {
    setNullableDoubleValue( nullableDoubleValue );
    return this;
  }

  @JsProperty(
      name = "nullableFloatFrozenArrayValue"
  )
  @Nullable
  JsArray<Double> nullableFloatFrozenArrayValue();

  @JsProperty
  void setNullableFloatFrozenArrayValue(@Nullable JsArray<Double> nullableFloatFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloatFrozenArrayValue(
      @Nullable final JsArray<Double> nullableFloatFrozenArrayValue) {
    setNullableFloatFrozenArrayValue( nullableFloatFrozenArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableFloatSequenceValue"
  )
  @Nullable
  JsArray<Double> nullableFloatSequenceValue();

  @JsProperty
  void setNullableFloatSequenceValue(@Nullable JsArray<Double> nullableFloatSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloatSequenceValue(
      @Nullable final JsArray<Double> nullableFloatSequenceValue) {
    setNullableFloatSequenceValue( nullableFloatSequenceValue );
    return this;
  }

  @JsOverlay
  default void setNullableFloatSequenceValue(@Nullable final double... nullableFloatSequenceValue) {
    setNullableFloatSequenceValue( Js.<JsArray<Double>>uncheckedCast( nullableFloatSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloatSequenceValue(
      @Nullable final double... nullableFloatSequenceValue) {
    setNullableFloatSequenceValue( nullableFloatSequenceValue );
    return this;
  }

  @JsProperty(
      name = "nullableFloatValue"
  )
  @Nullable
  Double nullableFloatValue();

  @JsProperty
  void setNullableFloatValue(@Nullable Double nullableFloatValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloatValue(@Nullable final Double nullableFloatValue) {
    setNullableFloatValue( nullableFloatValue );
    return this;
  }

  @JsProperty(
      name = "nullableLongLongValue"
  )
  @Nullable
  Double nullableLongLongValue();

  @JsProperty
  void setNullableLongLongValue(@Nullable Double nullableLongLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableLongLongValue(@Nullable final Double nullableLongLongValue) {
    setNullableLongLongValue( nullableLongLongValue );
    return this;
  }

  @JsProperty(
      name = "nullableLongValue"
  )
  @Nullable
  Double nullableLongValue();

  @JsProperty
  void setNullableLongValue(@Nullable Double nullableLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableLongValue(@Nullable final Double nullableLongValue) {
    setNullableLongValue( nullableLongValue );
    return this;
  }

  @JsProperty(
      name = "nullableObjectValue"
  )
  @Nullable
  Object nullableObjectValue();

  @JsProperty
  void setNullableObjectValue(@Nullable Object nullableObjectValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableObjectValue(@Nullable final Object nullableObjectValue) {
    setNullableObjectValue( nullableObjectValue );
    return this;
  }

  @JsProperty(
      name = "nullableOctetValue"
  )
  @Nullable
  Double nullableOctetValue();

  @JsProperty
  void setNullableOctetValue(@Nullable Double nullableOctetValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableOctetValue(@Nullable final Double nullableOctetValue) {
    setNullableOctetValue( nullableOctetValue );
    return this;
  }

  @JsProperty(
      name = "nullableShortFrozenArrayValue"
  )
  @Nullable
  JsArray<Double> nullableShortFrozenArrayValue();

  @JsProperty
  void setNullableShortFrozenArrayValue(@Nullable JsArray<Double> nullableShortFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortFrozenArrayValue(
      @Nullable final JsArray<Double> nullableShortFrozenArrayValue) {
    setNullableShortFrozenArrayValue( nullableShortFrozenArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableShortPromiseValue"
  )
  JsPromise<Double> nullableShortPromiseValue();

  @JsProperty
  void setNullableShortPromiseValue(@Nonnull JsPromise<Double> nullableShortPromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortPromiseValue(
      @Nonnull final JsPromise<Double> nullableShortPromiseValue) {
    setNullableShortPromiseValue( nullableShortPromiseValue );
    return this;
  }

  @JsProperty(
      name = "nullableShortSequenceValue"
  )
  @Nullable
  JsArray<Double> nullableShortSequenceValue();

  @JsProperty
  void setNullableShortSequenceValue(@Nullable JsArray<Double> nullableShortSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortSequenceValue(
      @Nullable final JsArray<Double> nullableShortSequenceValue) {
    setNullableShortSequenceValue( nullableShortSequenceValue );
    return this;
  }

  @JsOverlay
  default void setNullableShortSequenceValue(@Nullable final double... nullableShortSequenceValue) {
    setNullableShortSequenceValue( Js.<JsArray<Double>>uncheckedCast( nullableShortSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortSequenceValue(
      @Nullable final double... nullableShortSequenceValue) {
    setNullableShortSequenceValue( nullableShortSequenceValue );
    return this;
  }

  @JsProperty(
      name = "nullableShortValue"
  )
  @Nullable
  Double nullableShortValue();

  @JsProperty
  void setNullableShortValue(@Nullable Double nullableShortValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortValue(@Nullable final Double nullableShortValue) {
    setNullableShortValue( nullableShortValue );
    return this;
  }

  @JsProperty(
      name = "nullableSomeTypeFrozenArrayValue"
  )
  @Nullable
  JsArray<SomeType> nullableSomeTypeFrozenArrayValue();

  @JsProperty
  void setNullableSomeTypeFrozenArrayValue(
      @Nullable JsArray<SomeType> nullableSomeTypeFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSomeTypeFrozenArrayValue(
      @Nullable final JsArray<SomeType> nullableSomeTypeFrozenArrayValue) {
    setNullableSomeTypeFrozenArrayValue( nullableSomeTypeFrozenArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableSomeTypePromiseValue"
  )
  JsPromise<SomeType> nullableSomeTypePromiseValue();

  @JsProperty
  void setNullableSomeTypePromiseValue(@Nonnull JsPromise<SomeType> nullableSomeTypePromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSomeTypePromiseValue(
      @Nonnull final JsPromise<SomeType> nullableSomeTypePromiseValue) {
    setNullableSomeTypePromiseValue( nullableSomeTypePromiseValue );
    return this;
  }

  @JsProperty(
      name = "nullableSomeTypeSequenceValue"
  )
  @Nullable
  JsArray<SomeType> nullableSomeTypeSequenceValue();

  @JsProperty
  void setNullableSomeTypeSequenceValue(@Nullable JsArray<SomeType> nullableSomeTypeSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSomeTypeSequenceValue(
      @Nullable final JsArray<SomeType> nullableSomeTypeSequenceValue) {
    setNullableSomeTypeSequenceValue( nullableSomeTypeSequenceValue );
    return this;
  }

  @JsOverlay
  default void setNullableSomeTypeSequenceValue(
      @Nullable final SomeType... nullableSomeTypeSequenceValue) {
    setNullableSomeTypeSequenceValue( Js.<JsArray<SomeType>>uncheckedCast( nullableSomeTypeSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSomeTypeSequenceValue(
      @Nullable final SomeType... nullableSomeTypeSequenceValue) {
    setNullableSomeTypeSequenceValue( nullableSomeTypeSequenceValue );
    return this;
  }

  @JsProperty(
      name = "nullableSomeTypeValue"
  )
  @Nullable
  SomeType nullableSomeTypeValue();

  @JsProperty
  void setNullableSomeTypeValue(@Nullable SomeType nullableSomeTypeValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSomeTypeValue(@Nullable final SomeType nullableSomeTypeValue) {
    setNullableSomeTypeValue( nullableSomeTypeValue );
    return this;
  }

  @JsProperty(
      name = "nullableUSVStringValue"
  )
  @Nullable
  String nullableUSVStringValue();

  @JsProperty
  void setNullableUSVStringValue(@Nullable String nullableUSVStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUSVStringValue(@Nullable final String nullableUSVStringValue) {
    setNullableUSVStringValue( nullableUSVStringValue );
    return this;
  }

  @JsProperty(
      name = "nullableUnrestrictedDoubleValue"
  )
  @Nullable
  Double nullableUnrestrictedDoubleValue();

  @JsProperty
  void setNullableUnrestrictedDoubleValue(@Nullable Double nullableUnrestrictedDoubleValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUnrestrictedDoubleValue(
      @Nullable final Double nullableUnrestrictedDoubleValue) {
    setNullableUnrestrictedDoubleValue( nullableUnrestrictedDoubleValue );
    return this;
  }

  @JsProperty(
      name = "nullableUnrestrictedFloatValue"
  )
  @Nullable
  Double nullableUnrestrictedFloatValue();

  @JsProperty
  void setNullableUnrestrictedFloatValue(@Nullable Double nullableUnrestrictedFloatValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUnrestrictedFloatValue(
      @Nullable final Double nullableUnrestrictedFloatValue) {
    setNullableUnrestrictedFloatValue( nullableUnrestrictedFloatValue );
    return this;
  }

  @JsProperty(
      name = "nullableUnsignedLongLongValue"
  )
  @Nullable
  Double nullableUnsignedLongLongValue();

  @JsProperty
  void setNullableUnsignedLongLongValue(@Nullable Double nullableUnsignedLongLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUnsignedLongLongValue(
      @Nullable final Double nullableUnsignedLongLongValue) {
    setNullableUnsignedLongLongValue( nullableUnsignedLongLongValue );
    return this;
  }

  @JsProperty(
      name = "nullableUnsignedLongValue"
  )
  @Nullable
  Double nullableUnsignedLongValue();

  @JsProperty
  void setNullableUnsignedLongValue(@Nullable Double nullableUnsignedLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUnsignedLongValue(@Nullable final Double nullableUnsignedLongValue) {
    setNullableUnsignedLongValue( nullableUnsignedLongValue );
    return this;
  }

  @JsProperty(
      name = "nullableUnsignedShortValue"
  )
  @Nullable
  Double nullableUnsignedShortValue();

  @JsProperty
  void setNullableUnsignedShortValue(@Nullable Double nullableUnsignedShortValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUnsignedShortValue(
      @Nullable final Double nullableUnsignedShortValue) {
    setNullableUnsignedShortValue( nullableUnsignedShortValue );
    return this;
  }

  @JsProperty(
      name = "objectValue"
  )
  Object objectValue();

  @JsProperty
  void setObjectValue(@Nonnull Object objectValue);

  @JsOverlay
  @Nonnull
  default MyDictionary objectValue(@Nonnull final Object objectValue) {
    setObjectValue( objectValue );
    return this;
  }

  @JsProperty(
      name = "octetValue"
  )
  short octetValue();

  @JsProperty
  void setOctetValue(short octetValue);

  @JsOverlay
  @Nonnull
  default MyDictionary octetValue(final short octetValue) {
    setOctetValue( octetValue );
    return this;
  }

  @JsProperty(
      name = "requiredAnyIterableValue"
  )
  JsIterable<Any> requiredAnyIterableValue();

  @JsProperty
  void setRequiredAnyIterableValue(@Nonnull JsIterable<Any> requiredAnyIterableValue);

  @JsOverlay
  @Nonnull
  default MyDictionary requiredAnyIterableValue(
      @Nonnull final JsIterable<Any> requiredAnyIterableValue) {
    setRequiredAnyIterableValue( requiredAnyIterableValue );
    return this;
  }

  @JsProperty(
      name = "requiredAnyIteratorIterableValue"
  )
  JsIteratorIterable<Any> requiredAnyIteratorIterableValue();

  @JsProperty
  void setRequiredAnyIteratorIterableValue(
      @Nonnull JsIteratorIterable<Any> requiredAnyIteratorIterableValue);

  @JsOverlay
  @Nonnull
  default MyDictionary requiredAnyIteratorIterableValue(
      @Nonnull final JsIteratorIterable<Any> requiredAnyIteratorIterableValue) {
    setRequiredAnyIteratorIterableValue( requiredAnyIteratorIterableValue );
    return this;
  }

  @JsProperty(
      name = "requiredAnyIteratorValue"
  )
  JsIterator<Any> requiredAnyIteratorValue();

  @JsProperty
  void setRequiredAnyIteratorValue(@Nonnull JsIterator<Any> requiredAnyIteratorValue);

  @JsOverlay
  @Nonnull
  default MyDictionary requiredAnyIteratorValue(
      @Nonnull final JsIterator<Any> requiredAnyIteratorValue) {
    setRequiredAnyIteratorValue( requiredAnyIteratorValue );
    return this;
  }

  @JsProperty(
      name = "requiredAnySequenceValue"
  )
  JsArray<Any> requiredAnySequenceValue();

  @JsProperty
  void setRequiredAnySequenceValue(@Nonnull JsArray<Any> requiredAnySequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary requiredAnySequenceValue(
      @Nonnull final JsArray<Any> requiredAnySequenceValue) {
    setRequiredAnySequenceValue( requiredAnySequenceValue );
    return this;
  }

  @JsOverlay
  default void setRequiredAnySequenceValue(@Nonnull final Any... requiredAnySequenceValue) {
    setRequiredAnySequenceValue( Js.<JsArray<Any>>uncheckedCast( requiredAnySequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary requiredAnySequenceValue(@Nonnull final Any... requiredAnySequenceValue) {
    setRequiredAnySequenceValue( requiredAnySequenceValue );
    return this;
  }

  @JsProperty(
      name = "sequencePromiseValue"
  )
  JsPromise<JsArray<Double>> sequencePromiseValue();

  @JsProperty
  void setSequencePromiseValue(@Nonnull JsPromise<JsArray<Double>> sequencePromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary sequencePromiseValue(
      @Nonnull final JsPromise<JsArray<Double>> sequencePromiseValue) {
    setSequencePromiseValue( sequencePromiseValue );
    return this;
  }

  @JsProperty(
      name = "shortFrozenArrayValue"
  )
  JsArray<Double> shortFrozenArrayValue();

  @JsProperty
  void setShortFrozenArrayValue(@Nonnull JsArray<Double> shortFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary shortFrozenArrayValue(@Nonnull final JsArray<Double> shortFrozenArrayValue) {
    setShortFrozenArrayValue( shortFrozenArrayValue );
    return this;
  }

  @JsProperty(
      name = "shortPromiseValue"
  )
  JsPromise<Double> shortPromiseValue();

  @JsProperty
  void setShortPromiseValue(@Nonnull JsPromise<Double> shortPromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary shortPromiseValue(@Nonnull final JsPromise<Double> shortPromiseValue) {
    setShortPromiseValue( shortPromiseValue );
    return this;
  }

  @JsProperty(
      name = "shortSequenceValue"
  )
  JsArray<Double> shortSequenceValue();

  @JsProperty
  void setShortSequenceValue(@Nonnull JsArray<Double> shortSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary shortSequenceValue(@Nonnull final JsArray<Double> shortSequenceValue) {
    setShortSequenceValue( shortSequenceValue );
    return this;
  }

  @JsOverlay
  default void setShortSequenceValue(@Nonnull final double... shortSequenceValue) {
    setShortSequenceValue( Js.<JsArray<Double>>uncheckedCast( shortSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary shortSequenceValue(@Nonnull final double... shortSequenceValue) {
    setShortSequenceValue( shortSequenceValue );
    return this;
  }

  @JsProperty(
      name = "shortValue"
  )
  short shortValue();

  @JsProperty
  void setShortValue(short shortValue);

  @JsOverlay
  @Nonnull
  default MyDictionary shortValue(final short shortValue) {
    setShortValue( shortValue );
    return this;
  }

  @JsProperty(
      name = "someTypeFrozenArrayValue"
  )
  JsArray<SomeType> someTypeFrozenArrayValue();

  @JsProperty
  void setSomeTypeFrozenArrayValue(@Nonnull JsArray<SomeType> someTypeFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary someTypeFrozenArrayValue(
      @Nonnull final JsArray<SomeType> someTypeFrozenArrayValue) {
    setSomeTypeFrozenArrayValue( someTypeFrozenArrayValue );
    return this;
  }

  @JsProperty(
      name = "someTypePromiseValue"
  )
  JsPromise<SomeType> someTypePromiseValue();

  @JsProperty
  void setSomeTypePromiseValue(@Nonnull JsPromise<SomeType> someTypePromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary someTypePromiseValue(
      @Nonnull final JsPromise<SomeType> someTypePromiseValue) {
    setSomeTypePromiseValue( someTypePromiseValue );
    return this;
  }

  @JsProperty(
      name = "someTypeSequenceValue"
  )
  JsArray<SomeType> someTypeSequenceValue();

  @JsProperty
  void setSomeTypeSequenceValue(@Nonnull JsArray<SomeType> someTypeSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary someTypeSequenceValue(
      @Nonnull final JsArray<SomeType> someTypeSequenceValue) {
    setSomeTypeSequenceValue( someTypeSequenceValue );
    return this;
  }

  @JsOverlay
  default void setSomeTypeSequenceValue(@Nonnull final SomeType... someTypeSequenceValue) {
    setSomeTypeSequenceValue( Js.<JsArray<SomeType>>uncheckedCast( someTypeSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary someTypeSequenceValue(@Nonnull final SomeType... someTypeSequenceValue) {
    setSomeTypeSequenceValue( someTypeSequenceValue );
    return this;
  }

  @JsProperty(
      name = "someTypeValue"
  )
  SomeType someTypeValue();

  @JsProperty
  void setSomeTypeValue(@Nonnull SomeType someTypeValue);

  @JsOverlay
  @Nonnull
  default MyDictionary someTypeValue(@Nonnull final SomeType someTypeValue) {
    setSomeTypeValue( someTypeValue );
    return this;
  }

  @JsProperty(
      name = "typeReferenceRecordValue"
  )
  JsPropertyMap<SomeType> typeReferenceRecordValue();

  @JsProperty
  void setTypeReferenceRecordValue(@Nonnull JsPropertyMap<SomeType> typeReferenceRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary typeReferenceRecordValue(
      @Nonnull final JsPropertyMap<SomeType> typeReferenceRecordValue) {
    setTypeReferenceRecordValue( typeReferenceRecordValue );
    return this;
  }

  @JsProperty(
      name = "unrestrictedDoubleValue"
  )
  double unrestrictedDoubleValue();

  @JsProperty
  void setUnrestrictedDoubleValue(double unrestrictedDoubleValue);

  @JsOverlay
  @Nonnull
  default MyDictionary unrestrictedDoubleValue(final double unrestrictedDoubleValue) {
    setUnrestrictedDoubleValue( unrestrictedDoubleValue );
    return this;
  }

  @JsProperty(
      name = "unrestrictedFloatValue"
  )
  float unrestrictedFloatValue();

  @JsProperty
  void setUnrestrictedFloatValue(float unrestrictedFloatValue);

  @JsOverlay
  @Nonnull
  default MyDictionary unrestrictedFloatValue(final float unrestrictedFloatValue) {
    setUnrestrictedFloatValue( unrestrictedFloatValue );
    return this;
  }

  @JsProperty(
      name = "unsignedLongLongValue"
  )
  int unsignedLongLongValue();

  @JsProperty
  void setUnsignedLongLongValue(int unsignedLongLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary unsignedLongLongValue(final int unsignedLongLongValue) {
    setUnsignedLongLongValue( unsignedLongLongValue );
    return this;
  }

  @JsProperty(
      name = "unsignedLongValue"
  )
  int unsignedLongValue();

  @JsProperty
  void setUnsignedLongValue(int unsignedLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary unsignedLongValue(final int unsignedLongValue) {
    setUnsignedLongValue( unsignedLongValue );
    return this;
  }

  @JsProperty(
      name = "unsignedShortValue"
  )
  int unsignedShortValue();

  @JsProperty
  void setUnsignedShortValue(int unsignedShortValue);

  @JsOverlay
  @Nonnull
  default MyDictionary unsignedShortValue(final int unsignedShortValue) {
    setUnsignedShortValue( unsignedShortValue );
    return this;
  }

  @JsProperty(
      name = "usvStringRecordValue"
  )
  JsPropertyMap<String> usvStringRecordValue();

  @JsProperty
  void setUsvStringRecordValue(@Nonnull JsPropertyMap<String> usvStringRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary usvStringRecordValue(
      @Nonnull final JsPropertyMap<String> usvStringRecordValue) {
    setUsvStringRecordValue( usvStringRecordValue );
    return this;
  }

  @JsProperty(
      name = "usvStringValue"
  )
  String usvStringValue();

  @JsProperty
  void setUsvStringValue(@Nonnull String usvStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary usvStringValue(@Nonnull final String usvStringValue) {
    setUsvStringValue( usvStringValue );
    return this;
  }

  @JsProperty(
      name = "voidPromiseValue"
  )
  JsPromise<Void> voidPromiseValue();

  @JsProperty
  void setVoidPromiseValue(@Nonnull JsPromise<Void> voidPromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary voidPromiseValue(@Nonnull final JsPromise<Void> voidPromiseValue) {
    setVoidPromiseValue( voidPromiseValue );
    return this;
  }
}
