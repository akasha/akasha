package com.example;

import elemental2.core.ArrayBuffer;
import elemental2.core.DataView;
import elemental2.core.Float32Array;
import elemental2.core.Float64Array;
import elemental2.core.Int16Array;
import elemental2.core.Int32Array;
import elemental2.core.Int8Array;
import elemental2.core.JsArray;
import elemental2.core.Symbol;
import elemental2.core.Uint16Array;
import elemental2.core.Uint32Array;
import elemental2.core.Uint8Array;
import elemental2.core.Uint8ClampedArray;
import elemental2.promise.Promise;
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
    name = "?"
)
public interface MyDictionary {
  @JsOverlay
  @Nonnull
  static MyDictionary create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty
  @Nullable
  Any getAnyValue();

  @JsProperty
  void setAnyValue(@Nullable Any anyValue);

  @JsOverlay
  @Nonnull
  default MyDictionary anyValue(@Nullable final Any anyValue) {
    setAnyValue( anyValue );
    return this;
  }

  @JsProperty
  ArrayBuffer getArrayBufferValueValue();

  @JsProperty
  void setArrayBufferValueValue(@Nonnull ArrayBuffer arrayBufferValueValue);

  @JsOverlay
  @Nonnull
  default MyDictionary arrayBufferValueValue(@Nonnull final ArrayBuffer arrayBufferValueValue) {
    setArrayBufferValueValue( arrayBufferValueValue );
    return this;
  }

  @JsProperty
  JsArray<Boolean> getBooleanFrozenArrayValue();

  @JsProperty
  void setBooleanFrozenArrayValue(@Nonnull JsArray<Boolean> booleanFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary booleanFrozenArrayValue(
      @Nonnull final JsArray<Boolean> booleanFrozenArrayValue) {
    setBooleanFrozenArrayValue( booleanFrozenArrayValue );
    return this;
  }

  @JsProperty
  JsArray<Boolean> getBooleanSequenceValue();

  @JsProperty
  void setBooleanSequenceValue(@Nonnull JsArray<Boolean> booleanSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary booleanSequenceValue(@Nonnull final JsArray<Boolean> booleanSequenceValue) {
    setBooleanSequenceValue( booleanSequenceValue );
    return this;
  }

  @JsOverlay
  default void setBooleanSequenceValue(@Nonnull final Boolean[] booleanSequenceValue) {
    setBooleanSequenceValue( JsArray.asJsArray( booleanSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary booleanSequenceValue(@Nonnull final Boolean[] booleanSequenceValue) {
    setBooleanSequenceValue( booleanSequenceValue );
    return this;
  }

  @JsProperty
  boolean isBooleanValue();

  @JsProperty
  void setBooleanValue(boolean booleanValue);

  @JsOverlay
  @Nonnull
  default MyDictionary booleanValue(final boolean booleanValue) {
    setBooleanValue( booleanValue );
    return this;
  }

  @JsProperty
  JsPropertyMap<String> getByteStringRecordValue();

  @JsProperty
  void setByteStringRecordValue(@Nonnull JsPropertyMap<String> byteStringRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary byteStringRecordValue(
      @Nonnull final JsPropertyMap<String> byteStringRecordValue) {
    setByteStringRecordValue( byteStringRecordValue );
    return this;
  }

  @JsProperty
  String getByteStringValue();

  @JsProperty
  void setByteStringValue(@Nonnull String byteStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary byteStringValue(@Nonnull final String byteStringValue) {
    setByteStringValue( byteStringValue );
    return this;
  }

  @JsProperty
  byte getByteValue();

  @JsProperty
  void setByteValue(byte byteValue);

  @JsOverlay
  @Nonnull
  default MyDictionary byteValue(final byte byteValue) {
    setByteValue( byteValue );
    return this;
  }

  @JsProperty
  DataView getDataViewValueValue();

  @JsProperty
  void setDataViewValueValue(@Nonnull DataView dataViewValueValue);

  @JsOverlay
  @Nonnull
  default MyDictionary dataViewValueValue(@Nonnull final DataView dataViewValueValue) {
    setDataViewValueValue( dataViewValueValue );
    return this;
  }

  @JsProperty
  JsPropertyMap<String> getDomStringRecordValue();

  @JsProperty
  void setDomStringRecordValue(@Nonnull JsPropertyMap<String> domStringRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary domStringRecordValue(
      @Nonnull final JsPropertyMap<String> domStringRecordValue) {
    setDomStringRecordValue( domStringRecordValue );
    return this;
  }

  @JsProperty
  String getDomStringValue();

  @JsProperty
  void setDomStringValue(@Nonnull String domStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary domStringValue(@Nonnull final String domStringValue) {
    setDomStringValue( domStringValue );
    return this;
  }

  @JsProperty
  JsArray<Double> getDoubleFrozenArrayValue();

  @JsProperty
  void setDoubleFrozenArrayValue(@Nonnull JsArray<Double> doubleFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary doubleFrozenArrayValue(
      @Nonnull final JsArray<Double> doubleFrozenArrayValue) {
    setDoubleFrozenArrayValue( doubleFrozenArrayValue );
    return this;
  }

  @JsProperty
  JsPropertyMap<Double> getDoubleRecordValue();

  @JsProperty
  void setDoubleRecordValue(@Nonnull JsPropertyMap<Double> doubleRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary doubleRecordValue(@Nonnull final JsPropertyMap<Double> doubleRecordValue) {
    setDoubleRecordValue( doubleRecordValue );
    return this;
  }

  @JsProperty
  JsArray<Double> getDoubleSequenceValue();

  @JsProperty
  void setDoubleSequenceValue(@Nonnull JsArray<Double> doubleSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary doubleSequenceValue(@Nonnull final JsArray<Double> doubleSequenceValue) {
    setDoubleSequenceValue( doubleSequenceValue );
    return this;
  }

  @JsOverlay
  default void setDoubleSequenceValue(@Nonnull final Double[] doubleSequenceValue) {
    setDoubleSequenceValue( JsArray.asJsArray( doubleSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary doubleSequenceValue(@Nonnull final Double[] doubleSequenceValue) {
    setDoubleSequenceValue( doubleSequenceValue );
    return this;
  }

  @JsProperty
  double getDoubleValue();

  @JsProperty
  void setDoubleValue(double doubleValue);

  @JsOverlay
  @Nonnull
  default MyDictionary doubleValue(final double doubleValue) {
    setDoubleValue( doubleValue );
    return this;
  }

  @JsProperty
  Float32Array getFloat32ArrayValue();

  @JsProperty
  void setFloat32ArrayValue(@Nonnull Float32Array float32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary float32ArrayValue(@Nonnull final Float32Array float32ArrayValue) {
    setFloat32ArrayValue( float32ArrayValue );
    return this;
  }

  @JsProperty
  Float64Array getFloat64ArrayValue();

  @JsProperty
  void setFloat64ArrayValue(@Nonnull Float64Array float64ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary float64ArrayValue(@Nonnull final Float64Array float64ArrayValue) {
    setFloat64ArrayValue( float64ArrayValue );
    return this;
  }

  @JsProperty
  JsArray<Double> getFloatFrozenArrayValue();

  @JsProperty
  void setFloatFrozenArrayValue(@Nonnull JsArray<Double> floatFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary floatFrozenArrayValue(@Nonnull final JsArray<Double> floatFrozenArrayValue) {
    setFloatFrozenArrayValue( floatFrozenArrayValue );
    return this;
  }

  @JsProperty
  JsArray<Double> getFloatSequenceValue();

  @JsProperty
  void setFloatSequenceValue(@Nonnull JsArray<Double> floatSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary floatSequenceValue(@Nonnull final JsArray<Double> floatSequenceValue) {
    setFloatSequenceValue( floatSequenceValue );
    return this;
  }

  @JsOverlay
  default void setFloatSequenceValue(@Nonnull final Double[] floatSequenceValue) {
    setFloatSequenceValue( JsArray.asJsArray( floatSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary floatSequenceValue(@Nonnull final Double[] floatSequenceValue) {
    setFloatSequenceValue( floatSequenceValue );
    return this;
  }

  @JsProperty
  float getFloatValue();

  @JsProperty
  void setFloatValue(float floatValue);

  @JsOverlay
  @Nonnull
  default MyDictionary floatValue(final float floatValue) {
    setFloatValue( floatValue );
    return this;
  }

  @JsProperty
  Int16Array getInt16ArrayValue();

  @JsProperty
  void setInt16ArrayValue(@Nonnull Int16Array int16ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary int16ArrayValue(@Nonnull final Int16Array int16ArrayValue) {
    setInt16ArrayValue( int16ArrayValue );
    return this;
  }

  @JsProperty
  Int32Array getInt32ArrayValue();

  @JsProperty
  void setInt32ArrayValue(@Nonnull Int32Array int32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary int32ArrayValue(@Nonnull final Int32Array int32ArrayValue) {
    setInt32ArrayValue( int32ArrayValue );
    return this;
  }

  @JsProperty
  Int8Array getInt8ArrayValue();

  @JsProperty
  void setInt8ArrayValue(@Nonnull Int8Array int8ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary int8ArrayValue(@Nonnull final Int8Array int8ArrayValue) {
    setInt8ArrayValue( int8ArrayValue );
    return this;
  }

  @JsProperty
  int getLongLongValue();

  @JsProperty
  void setLongLongValue(int longLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary longLongValue(final int longLongValue) {
    setLongLongValue( longLongValue );
    return this;
  }

  @JsProperty
  int getLongValue();

  @JsProperty
  void setLongValue(int longValue);

  @JsOverlay
  @Nonnull
  default MyDictionary longValue(final int longValue) {
    setLongValue( longValue );
    return this;
  }

  @JsProperty
  JsPropertyMap<String> getMixedStringRecordValue();

  @JsProperty
  void setMixedStringRecordValue(@Nonnull JsPropertyMap<String> mixedStringRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary mixedStringRecordValue(
      @Nonnull final JsPropertyMap<String> mixedStringRecordValue) {
    setMixedStringRecordValue( mixedStringRecordValue );
    return this;
  }

  @JsProperty
  @Nullable
  ArrayBuffer getNullableArrayBufferValueValue();

  @JsProperty
  void setNullableArrayBufferValueValue(@Nullable ArrayBuffer nullableArrayBufferValueValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableArrayBufferValueValue(
      @Nullable final ArrayBuffer nullableArrayBufferValueValue) {
    setNullableArrayBufferValueValue( nullableArrayBufferValueValue );
    return this;
  }

  @JsProperty
  @Nullable
  JsArray<Boolean> getNullableBooleanFrozenArrayValue();

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

  @JsProperty
  @Nullable
  JsArray<Boolean> getNullableBooleanSequenceValue();

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
      @Nullable final Boolean[] nullableBooleanSequenceValue) {
    setNullableBooleanSequenceValue( JsArray.asJsArray( nullableBooleanSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableBooleanSequenceValue(
      @Nullable final Boolean[] nullableBooleanSequenceValue) {
    setNullableBooleanSequenceValue( nullableBooleanSequenceValue );
    return this;
  }

  @JsProperty
  @Nullable
  Boolean getNullableBooleanValue();

  @JsProperty
  void setNullableBooleanValue(@Nullable Boolean nullableBooleanValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableBooleanValue(@Nullable final Boolean nullableBooleanValue) {
    setNullableBooleanValue( nullableBooleanValue );
    return this;
  }

  @JsProperty
  @Nullable
  String getNullableByteStringValue();

  @JsProperty
  void setNullableByteStringValue(@Nullable String nullableByteStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableByteStringValue(@Nullable final String nullableByteStringValue) {
    setNullableByteStringValue( nullableByteStringValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableByteValue();

  @JsProperty
  void setNullableByteValue(@Nullable Double nullableByteValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableByteValue(@Nullable final Double nullableByteValue) {
    setNullableByteValue( nullableByteValue );
    return this;
  }

  @JsProperty
  @Nullable
  String getNullableDOMStringValue();

  @JsProperty
  void setNullableDOMStringValue(@Nullable String nullableDOMStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDOMStringValue(@Nullable final String nullableDOMStringValue) {
    setNullableDOMStringValue( nullableDOMStringValue );
    return this;
  }

  @JsProperty
  @Nullable
  DataView getNullableDataViewValueValue();

  @JsProperty
  void setNullableDataViewValueValue(@Nullable DataView nullableDataViewValueValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDataViewValueValue(
      @Nullable final DataView nullableDataViewValueValue) {
    setNullableDataViewValueValue( nullableDataViewValueValue );
    return this;
  }

  @JsProperty
  @Nullable
  JsArray<Double> getNullableDoubleFrozenArrayValue();

  @JsProperty
  void setNullableDoubleFrozenArrayValue(@Nullable JsArray<Double> nullableDoubleFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDoubleFrozenArrayValue(
      @Nullable final JsArray<Double> nullableDoubleFrozenArrayValue) {
    setNullableDoubleFrozenArrayValue( nullableDoubleFrozenArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  JsArray<Double> getNullableDoubleSequenceValue();

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
      @Nullable final Double[] nullableDoubleSequenceValue) {
    setNullableDoubleSequenceValue( JsArray.asJsArray( nullableDoubleSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDoubleSequenceValue(
      @Nullable final Double[] nullableDoubleSequenceValue) {
    setNullableDoubleSequenceValue( nullableDoubleSequenceValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableDoubleValue();

  @JsProperty
  void setNullableDoubleValue(@Nullable Double nullableDoubleValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDoubleValue(@Nullable final Double nullableDoubleValue) {
    setNullableDoubleValue( nullableDoubleValue );
    return this;
  }

  @JsProperty
  @Nullable
  Float32Array getNullableFloat32ArrayValue();

  @JsProperty
  void setNullableFloat32ArrayValue(@Nullable Float32Array nullableFloat32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloat32ArrayValue(
      @Nullable final Float32Array nullableFloat32ArrayValue) {
    setNullableFloat32ArrayValue( nullableFloat32ArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  Float64Array getNullableFloat64ArrayValue();

  @JsProperty
  void setNullableFloat64ArrayValue(@Nullable Float64Array nullableFloat64ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloat64ArrayValue(
      @Nullable final Float64Array nullableFloat64ArrayValue) {
    setNullableFloat64ArrayValue( nullableFloat64ArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  JsArray<Double> getNullableFloatFrozenArrayValue();

  @JsProperty
  void setNullableFloatFrozenArrayValue(@Nullable JsArray<Double> nullableFloatFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloatFrozenArrayValue(
      @Nullable final JsArray<Double> nullableFloatFrozenArrayValue) {
    setNullableFloatFrozenArrayValue( nullableFloatFrozenArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  JsArray<Double> getNullableFloatSequenceValue();

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
  default void setNullableFloatSequenceValue(@Nullable final Double[] nullableFloatSequenceValue) {
    setNullableFloatSequenceValue( JsArray.asJsArray( nullableFloatSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloatSequenceValue(
      @Nullable final Double[] nullableFloatSequenceValue) {
    setNullableFloatSequenceValue( nullableFloatSequenceValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableFloatValue();

  @JsProperty
  void setNullableFloatValue(@Nullable Double nullableFloatValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloatValue(@Nullable final Double nullableFloatValue) {
    setNullableFloatValue( nullableFloatValue );
    return this;
  }

  @JsProperty
  @Nullable
  Int16Array getNullableInt16ArrayValue();

  @JsProperty
  void setNullableInt16ArrayValue(@Nullable Int16Array nullableInt16ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableInt16ArrayValue(@Nullable final Int16Array nullableInt16ArrayValue) {
    setNullableInt16ArrayValue( nullableInt16ArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  Int32Array getNullableInt32ArrayValue();

  @JsProperty
  void setNullableInt32ArrayValue(@Nullable Int32Array nullableInt32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableInt32ArrayValue(@Nullable final Int32Array nullableInt32ArrayValue) {
    setNullableInt32ArrayValue( nullableInt32ArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  Int8Array getNullableInt8ArrayValue();

  @JsProperty
  void setNullableInt8ArrayValue(@Nullable Int8Array nullableInt8ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableInt8ArrayValue(@Nullable final Int8Array nullableInt8ArrayValue) {
    setNullableInt8ArrayValue( nullableInt8ArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableLongLongValue();

  @JsProperty
  void setNullableLongLongValue(@Nullable Double nullableLongLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableLongLongValue(@Nullable final Double nullableLongLongValue) {
    setNullableLongLongValue( nullableLongLongValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableLongValue();

  @JsProperty
  void setNullableLongValue(@Nullable Double nullableLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableLongValue(@Nullable final Double nullableLongValue) {
    setNullableLongValue( nullableLongValue );
    return this;
  }

  @JsProperty
  @Nullable
  Object getNullableObjectValue();

  @JsProperty
  void setNullableObjectValue(@Nullable Object nullableObjectValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableObjectValue(@Nullable final Object nullableObjectValue) {
    setNullableObjectValue( nullableObjectValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableOctetValue();

  @JsProperty
  void setNullableOctetValue(@Nullable Double nullableOctetValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableOctetValue(@Nullable final Double nullableOctetValue) {
    setNullableOctetValue( nullableOctetValue );
    return this;
  }

  @JsProperty
  @Nullable
  JsArray<Double> getNullableShortFrozenArrayValue();

  @JsProperty
  void setNullableShortFrozenArrayValue(@Nullable JsArray<Double> nullableShortFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortFrozenArrayValue(
      @Nullable final JsArray<Double> nullableShortFrozenArrayValue) {
    setNullableShortFrozenArrayValue( nullableShortFrozenArrayValue );
    return this;
  }

  @JsProperty
  Promise<Double> getNullableShortPromiseValue();

  @JsProperty
  void setNullableShortPromiseValue(@Nonnull Promise<Double> nullableShortPromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortPromiseValue(
      @Nonnull final Promise<Double> nullableShortPromiseValue) {
    setNullableShortPromiseValue( nullableShortPromiseValue );
    return this;
  }

  @JsProperty
  @Nullable
  JsArray<Double> getNullableShortSequenceValue();

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
  default void setNullableShortSequenceValue(@Nullable final Double[] nullableShortSequenceValue) {
    setNullableShortSequenceValue( JsArray.asJsArray( nullableShortSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortSequenceValue(
      @Nullable final Double[] nullableShortSequenceValue) {
    setNullableShortSequenceValue( nullableShortSequenceValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableShortValue();

  @JsProperty
  void setNullableShortValue(@Nullable Double nullableShortValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortValue(@Nullable final Double nullableShortValue) {
    setNullableShortValue( nullableShortValue );
    return this;
  }

  @JsProperty
  @Nullable
  JsArray<SomeType> getNullableSomeTypeFrozenArrayValue();

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

  @JsProperty
  Promise<SomeType> getNullableSomeTypePromiseValue();

  @JsProperty
  void setNullableSomeTypePromiseValue(@Nonnull Promise<SomeType> nullableSomeTypePromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSomeTypePromiseValue(
      @Nonnull final Promise<SomeType> nullableSomeTypePromiseValue) {
    setNullableSomeTypePromiseValue( nullableSomeTypePromiseValue );
    return this;
  }

  @JsProperty
  @Nullable
  JsArray<SomeType> getNullableSomeTypeSequenceValue();

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
      @Nullable final SomeType[] nullableSomeTypeSequenceValue) {
    setNullableSomeTypeSequenceValue( JsArray.asJsArray( nullableSomeTypeSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSomeTypeSequenceValue(
      @Nullable final SomeType[] nullableSomeTypeSequenceValue) {
    setNullableSomeTypeSequenceValue( nullableSomeTypeSequenceValue );
    return this;
  }

  @JsProperty
  @Nullable
  SomeType getNullableSomeTypeValue();

  @JsProperty
  void setNullableSomeTypeValue(@Nullable SomeType nullableSomeTypeValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSomeTypeValue(@Nullable final SomeType nullableSomeTypeValue) {
    setNullableSomeTypeValue( nullableSomeTypeValue );
    return this;
  }

  @JsProperty
  @Nullable
  Symbol getNullableSymbolValue();

  @JsProperty
  void setNullableSymbolValue(@Nullable Symbol nullableSymbolValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSymbolValue(@Nullable final Symbol nullableSymbolValue) {
    setNullableSymbolValue( nullableSymbolValue );
    return this;
  }

  @JsProperty
  @Nullable
  String getNullableUSVStringValue();

  @JsProperty
  void setNullableUSVStringValue(@Nullable String nullableUSVStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUSVStringValue(@Nullable final String nullableUSVStringValue) {
    setNullableUSVStringValue( nullableUSVStringValue );
    return this;
  }

  @JsProperty
  @Nullable
  Uint16Array getNullableUint16ArrayValue();

  @JsProperty
  void setNullableUint16ArrayValue(@Nullable Uint16Array nullableUint16ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUint16ArrayValue(
      @Nullable final Uint16Array nullableUint16ArrayValue) {
    setNullableUint16ArrayValue( nullableUint16ArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  Uint32Array getNullableUint32ArrayValue();

  @JsProperty
  void setNullableUint32ArrayValue(@Nullable Uint32Array nullableUint32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUint32ArrayValue(
      @Nullable final Uint32Array nullableUint32ArrayValue) {
    setNullableUint32ArrayValue( nullableUint32ArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  Uint8Array getNullableUint8ArrayValue();

  @JsProperty
  void setNullableUint8ArrayValue(@Nullable Uint8Array nullableUint8ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUint8ArrayValue(@Nullable final Uint8Array nullableUint8ArrayValue) {
    setNullableUint8ArrayValue( nullableUint8ArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  Uint8ClampedArray getNullableUint8ClampedArrayValue();

  @JsProperty
  void setNullableUint8ClampedArrayValue(
      @Nullable Uint8ClampedArray nullableUint8ClampedArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUint8ClampedArrayValue(
      @Nullable final Uint8ClampedArray nullableUint8ClampedArrayValue) {
    setNullableUint8ClampedArrayValue( nullableUint8ClampedArrayValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableUnrestrictedDoubleValue();

  @JsProperty
  void setNullableUnrestrictedDoubleValue(@Nullable Double nullableUnrestrictedDoubleValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUnrestrictedDoubleValue(
      @Nullable final Double nullableUnrestrictedDoubleValue) {
    setNullableUnrestrictedDoubleValue( nullableUnrestrictedDoubleValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableUnrestrictedFloatValue();

  @JsProperty
  void setNullableUnrestrictedFloatValue(@Nullable Double nullableUnrestrictedFloatValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUnrestrictedFloatValue(
      @Nullable final Double nullableUnrestrictedFloatValue) {
    setNullableUnrestrictedFloatValue( nullableUnrestrictedFloatValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableUnsignedLongLongValue();

  @JsProperty
  void setNullableUnsignedLongLongValue(@Nullable Double nullableUnsignedLongLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUnsignedLongLongValue(
      @Nullable final Double nullableUnsignedLongLongValue) {
    setNullableUnsignedLongLongValue( nullableUnsignedLongLongValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableUnsignedLongValue();

  @JsProperty
  void setNullableUnsignedLongValue(@Nullable Double nullableUnsignedLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUnsignedLongValue(@Nullable final Double nullableUnsignedLongValue) {
    setNullableUnsignedLongValue( nullableUnsignedLongValue );
    return this;
  }

  @JsProperty
  @Nullable
  Double getNullableUnsignedShortValue();

  @JsProperty
  void setNullableUnsignedShortValue(@Nullable Double nullableUnsignedShortValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUnsignedShortValue(
      @Nullable final Double nullableUnsignedShortValue) {
    setNullableUnsignedShortValue( nullableUnsignedShortValue );
    return this;
  }

  @JsProperty
  Object getObjectValue();

  @JsProperty
  void setObjectValue(@Nonnull Object objectValue);

  @JsOverlay
  @Nonnull
  default MyDictionary objectValue(@Nonnull final Object objectValue) {
    setObjectValue( objectValue );
    return this;
  }

  @JsProperty
  short getOctetValue();

  @JsProperty
  void setOctetValue(short octetValue);

  @JsOverlay
  @Nonnull
  default MyDictionary octetValue(final short octetValue) {
    setOctetValue( octetValue );
    return this;
  }

  @JsProperty
  Promise<JsArray<Double>> getSequencePromiseValue();

  @JsProperty
  void setSequencePromiseValue(@Nonnull Promise<JsArray<Double>> sequencePromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary sequencePromiseValue(
      @Nonnull final Promise<JsArray<Double>> sequencePromiseValue) {
    setSequencePromiseValue( sequencePromiseValue );
    return this;
  }

  @JsProperty
  JsArray<Double> getShortFrozenArrayValue();

  @JsProperty
  void setShortFrozenArrayValue(@Nonnull JsArray<Double> shortFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary shortFrozenArrayValue(@Nonnull final JsArray<Double> shortFrozenArrayValue) {
    setShortFrozenArrayValue( shortFrozenArrayValue );
    return this;
  }

  @JsProperty
  Promise<Double> getShortPromiseValue();

  @JsProperty
  void setShortPromiseValue(@Nonnull Promise<Double> shortPromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary shortPromiseValue(@Nonnull final Promise<Double> shortPromiseValue) {
    setShortPromiseValue( shortPromiseValue );
    return this;
  }

  @JsProperty
  JsArray<Double> getShortSequenceValue();

  @JsProperty
  void setShortSequenceValue(@Nonnull JsArray<Double> shortSequenceValue);

  @JsOverlay
  @Nonnull
  default MyDictionary shortSequenceValue(@Nonnull final JsArray<Double> shortSequenceValue) {
    setShortSequenceValue( shortSequenceValue );
    return this;
  }

  @JsOverlay
  default void setShortSequenceValue(@Nonnull final Double[] shortSequenceValue) {
    setShortSequenceValue( JsArray.asJsArray( shortSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary shortSequenceValue(@Nonnull final Double[] shortSequenceValue) {
    setShortSequenceValue( shortSequenceValue );
    return this;
  }

  @JsProperty
  short getShortValue();

  @JsProperty
  void setShortValue(short shortValue);

  @JsOverlay
  @Nonnull
  default MyDictionary shortValue(final short shortValue) {
    setShortValue( shortValue );
    return this;
  }

  @JsProperty
  JsArray<SomeType> getSomeTypeFrozenArrayValue();

  @JsProperty
  void setSomeTypeFrozenArrayValue(@Nonnull JsArray<SomeType> someTypeFrozenArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary someTypeFrozenArrayValue(
      @Nonnull final JsArray<SomeType> someTypeFrozenArrayValue) {
    setSomeTypeFrozenArrayValue( someTypeFrozenArrayValue );
    return this;
  }

  @JsProperty
  Promise<SomeType> getSomeTypePromiseValue();

  @JsProperty
  void setSomeTypePromiseValue(@Nonnull Promise<SomeType> someTypePromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary someTypePromiseValue(@Nonnull final Promise<SomeType> someTypePromiseValue) {
    setSomeTypePromiseValue( someTypePromiseValue );
    return this;
  }

  @JsProperty
  JsArray<SomeType> getSomeTypeSequenceValue();

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
  default void setSomeTypeSequenceValue(@Nonnull final SomeType[] someTypeSequenceValue) {
    setSomeTypeSequenceValue( JsArray.asJsArray( someTypeSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary someTypeSequenceValue(@Nonnull final SomeType[] someTypeSequenceValue) {
    setSomeTypeSequenceValue( someTypeSequenceValue );
    return this;
  }

  @JsProperty
  SomeType getSomeTypeValue();

  @JsProperty
  void setSomeTypeValue(@Nonnull SomeType someTypeValue);

  @JsOverlay
  @Nonnull
  default MyDictionary someTypeValue(@Nonnull final SomeType someTypeValue) {
    setSomeTypeValue( someTypeValue );
    return this;
  }

  @JsProperty
  Symbol getSymbolValue();

  @JsProperty
  void setSymbolValue(@Nonnull Symbol symbolValue);

  @JsOverlay
  @Nonnull
  default MyDictionary symbolValue(@Nonnull final Symbol symbolValue) {
    setSymbolValue( symbolValue );
    return this;
  }

  @JsProperty
  JsPropertyMap<SomeType> getTypeReferenceRecordValue();

  @JsProperty
  void setTypeReferenceRecordValue(@Nonnull JsPropertyMap<SomeType> typeReferenceRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary typeReferenceRecordValue(
      @Nonnull final JsPropertyMap<SomeType> typeReferenceRecordValue) {
    setTypeReferenceRecordValue( typeReferenceRecordValue );
    return this;
  }

  @JsProperty
  Uint16Array getUint16ArrayValue();

  @JsProperty
  void setUint16ArrayValue(@Nonnull Uint16Array uint16ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary uint16ArrayValue(@Nonnull final Uint16Array uint16ArrayValue) {
    setUint16ArrayValue( uint16ArrayValue );
    return this;
  }

  @JsProperty
  Uint32Array getUint32ArrayValue();

  @JsProperty
  void setUint32ArrayValue(@Nonnull Uint32Array uint32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary uint32ArrayValue(@Nonnull final Uint32Array uint32ArrayValue) {
    setUint32ArrayValue( uint32ArrayValue );
    return this;
  }

  @JsProperty
  Uint8Array getUint8ArrayValue();

  @JsProperty
  void setUint8ArrayValue(@Nonnull Uint8Array uint8ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary uint8ArrayValue(@Nonnull final Uint8Array uint8ArrayValue) {
    setUint8ArrayValue( uint8ArrayValue );
    return this;
  }

  @JsProperty
  Uint8ClampedArray getUint8ClampedArrayValue();

  @JsProperty
  void setUint8ClampedArrayValue(@Nonnull Uint8ClampedArray uint8ClampedArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary uint8ClampedArrayValue(
      @Nonnull final Uint8ClampedArray uint8ClampedArrayValue) {
    setUint8ClampedArrayValue( uint8ClampedArrayValue );
    return this;
  }

  @JsProperty
  double getUnrestrictedDoubleValue();

  @JsProperty
  void setUnrestrictedDoubleValue(double unrestrictedDoubleValue);

  @JsOverlay
  @Nonnull
  default MyDictionary unrestrictedDoubleValue(final double unrestrictedDoubleValue) {
    setUnrestrictedDoubleValue( unrestrictedDoubleValue );
    return this;
  }

  @JsProperty
  float getUnrestrictedFloatValue();

  @JsProperty
  void setUnrestrictedFloatValue(float unrestrictedFloatValue);

  @JsOverlay
  @Nonnull
  default MyDictionary unrestrictedFloatValue(final float unrestrictedFloatValue) {
    setUnrestrictedFloatValue( unrestrictedFloatValue );
    return this;
  }

  @JsProperty
  int getUnsignedLongLongValue();

  @JsProperty
  void setUnsignedLongLongValue(int unsignedLongLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary unsignedLongLongValue(final int unsignedLongLongValue) {
    setUnsignedLongLongValue( unsignedLongLongValue );
    return this;
  }

  @JsProperty
  int getUnsignedLongValue();

  @JsProperty
  void setUnsignedLongValue(int unsignedLongValue);

  @JsOverlay
  @Nonnull
  default MyDictionary unsignedLongValue(final int unsignedLongValue) {
    setUnsignedLongValue( unsignedLongValue );
    return this;
  }

  @JsProperty
  int getUnsignedShortValue();

  @JsProperty
  void setUnsignedShortValue(int unsignedShortValue);

  @JsOverlay
  @Nonnull
  default MyDictionary unsignedShortValue(final int unsignedShortValue) {
    setUnsignedShortValue( unsignedShortValue );
    return this;
  }

  @JsProperty
  JsPropertyMap<String> getUsvStringRecordValue();

  @JsProperty
  void setUsvStringRecordValue(@Nonnull JsPropertyMap<String> usvStringRecordValue);

  @JsOverlay
  @Nonnull
  default MyDictionary usvStringRecordValue(
      @Nonnull final JsPropertyMap<String> usvStringRecordValue) {
    setUsvStringRecordValue( usvStringRecordValue );
    return this;
  }

  @JsProperty
  String getUsvStringValue();

  @JsProperty
  void setUsvStringValue(@Nonnull String usvStringValue);

  @JsOverlay
  @Nonnull
  default MyDictionary usvStringValue(@Nonnull final String usvStringValue) {
    setUsvStringValue( usvStringValue );
    return this;
  }

  @JsProperty
  Promise<Void> getVoidPromiseValue();

  @JsProperty
  void setVoidPromiseValue(@Nonnull Promise<Void> voidPromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary voidPromiseValue(@Nonnull final Promise<Void> voidPromiseValue) {
    setVoidPromiseValue( voidPromiseValue );
    return this;
  }
}
