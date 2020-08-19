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
    name = "?"
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
  void setAnyValue(@Nullable Any anyValue);

  @JsOverlay
  @Nonnull
  default MyDictionary anyValue(@Nullable final Any anyValue) {
    setAnyValue( anyValue );
    return this;
  }

  @JsOverlay
  default void setAnyValue(@Nullable @DoNotAutobox final Object anyValue) {
    setAnyValue( Js.asAny( anyValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary anyValue(@Nullable @DoNotAutobox final Object anyValue) {
    setAnyValue( anyValue );
    return this;
  }

  @JsProperty(
      name = "arrayBufferValueValue"
  )
  ArrayBuffer arrayBufferValueValue();

  @JsProperty
  void setArrayBufferValueValue(@Nonnull ArrayBuffer arrayBufferValueValue);

  @JsOverlay
  @Nonnull
  default MyDictionary arrayBufferValueValue(@Nonnull final ArrayBuffer arrayBufferValueValue) {
    setArrayBufferValueValue( arrayBufferValueValue );
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
    setBooleanSequenceValue( JsArray.asJsArray( booleanSequenceValue ) );
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
      name = "dataViewValueValue"
  )
  DataView dataViewValueValue();

  @JsProperty
  void setDataViewValueValue(@Nonnull DataView dataViewValueValue);

  @JsOverlay
  @Nonnull
  default MyDictionary dataViewValueValue(@Nonnull final DataView dataViewValueValue) {
    setDataViewValueValue( dataViewValueValue );
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
  default void setDoubleSequenceValue(@Nonnull final Double... doubleSequenceValue) {
    setDoubleSequenceValue( JsArray.asJsArray( doubleSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary doubleSequenceValue(@Nonnull final Double... doubleSequenceValue) {
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
      name = "float32ArrayValue"
  )
  Float32Array float32ArrayValue();

  @JsProperty
  void setFloat32ArrayValue(@Nonnull Float32Array float32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary float32ArrayValue(@Nonnull final Float32Array float32ArrayValue) {
    setFloat32ArrayValue( float32ArrayValue );
    return this;
  }

  @JsProperty(
      name = "float64ArrayValue"
  )
  Float64Array float64ArrayValue();

  @JsProperty
  void setFloat64ArrayValue(@Nonnull Float64Array float64ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary float64ArrayValue(@Nonnull final Float64Array float64ArrayValue) {
    setFloat64ArrayValue( float64ArrayValue );
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
  default void setFloatSequenceValue(@Nonnull final Double... floatSequenceValue) {
    setFloatSequenceValue( JsArray.asJsArray( floatSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary floatSequenceValue(@Nonnull final Double... floatSequenceValue) {
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
      name = "int16ArrayValue"
  )
  Int16Array int16ArrayValue();

  @JsProperty
  void setInt16ArrayValue(@Nonnull Int16Array int16ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary int16ArrayValue(@Nonnull final Int16Array int16ArrayValue) {
    setInt16ArrayValue( int16ArrayValue );
    return this;
  }

  @JsProperty(
      name = "int32ArrayValue"
  )
  Int32Array int32ArrayValue();

  @JsProperty
  void setInt32ArrayValue(@Nonnull Int32Array int32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary int32ArrayValue(@Nonnull final Int32Array int32ArrayValue) {
    setInt32ArrayValue( int32ArrayValue );
    return this;
  }

  @JsProperty(
      name = "int8ArrayValue"
  )
  Int8Array int8ArrayValue();

  @JsProperty
  void setInt8ArrayValue(@Nonnull Int8Array int8ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary int8ArrayValue(@Nonnull final Int8Array int8ArrayValue) {
    setInt8ArrayValue( int8ArrayValue );
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
      name = "nullableArrayBufferValueValue"
  )
  @Nullable
  ArrayBuffer nullableArrayBufferValueValue();

  @JsProperty
  void setNullableArrayBufferValueValue(@Nullable ArrayBuffer nullableArrayBufferValueValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableArrayBufferValueValue(
      @Nullable final ArrayBuffer nullableArrayBufferValueValue) {
    setNullableArrayBufferValueValue( nullableArrayBufferValueValue );
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
    setNullableBooleanSequenceValue( JsArray.asJsArray( nullableBooleanSequenceValue ) );
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
      name = "nullableDataViewValueValue"
  )
  @Nullable
  DataView nullableDataViewValueValue();

  @JsProperty
  void setNullableDataViewValueValue(@Nullable DataView nullableDataViewValueValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDataViewValueValue(
      @Nullable final DataView nullableDataViewValueValue) {
    setNullableDataViewValueValue( nullableDataViewValueValue );
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
      @Nullable final Double... nullableDoubleSequenceValue) {
    setNullableDoubleSequenceValue( JsArray.asJsArray( nullableDoubleSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableDoubleSequenceValue(
      @Nullable final Double... nullableDoubleSequenceValue) {
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
      name = "nullableFloat32ArrayValue"
  )
  @Nullable
  Float32Array nullableFloat32ArrayValue();

  @JsProperty
  void setNullableFloat32ArrayValue(@Nullable Float32Array nullableFloat32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloat32ArrayValue(
      @Nullable final Float32Array nullableFloat32ArrayValue) {
    setNullableFloat32ArrayValue( nullableFloat32ArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableFloat64ArrayValue"
  )
  @Nullable
  Float64Array nullableFloat64ArrayValue();

  @JsProperty
  void setNullableFloat64ArrayValue(@Nullable Float64Array nullableFloat64ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloat64ArrayValue(
      @Nullable final Float64Array nullableFloat64ArrayValue) {
    setNullableFloat64ArrayValue( nullableFloat64ArrayValue );
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
  default void setNullableFloatSequenceValue(@Nullable final Double... nullableFloatSequenceValue) {
    setNullableFloatSequenceValue( JsArray.asJsArray( nullableFloatSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableFloatSequenceValue(
      @Nullable final Double... nullableFloatSequenceValue) {
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
      name = "nullableInt16ArrayValue"
  )
  @Nullable
  Int16Array nullableInt16ArrayValue();

  @JsProperty
  void setNullableInt16ArrayValue(@Nullable Int16Array nullableInt16ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableInt16ArrayValue(@Nullable final Int16Array nullableInt16ArrayValue) {
    setNullableInt16ArrayValue( nullableInt16ArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableInt32ArrayValue"
  )
  @Nullable
  Int32Array nullableInt32ArrayValue();

  @JsProperty
  void setNullableInt32ArrayValue(@Nullable Int32Array nullableInt32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableInt32ArrayValue(@Nullable final Int32Array nullableInt32ArrayValue) {
    setNullableInt32ArrayValue( nullableInt32ArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableInt8ArrayValue"
  )
  @Nullable
  Int8Array nullableInt8ArrayValue();

  @JsProperty
  void setNullableInt8ArrayValue(@Nullable Int8Array nullableInt8ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableInt8ArrayValue(@Nullable final Int8Array nullableInt8ArrayValue) {
    setNullableInt8ArrayValue( nullableInt8ArrayValue );
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
  Promise<Double> nullableShortPromiseValue();

  @JsProperty
  void setNullableShortPromiseValue(@Nonnull Promise<Double> nullableShortPromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortPromiseValue(
      @Nonnull final Promise<Double> nullableShortPromiseValue) {
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
  default void setNullableShortSequenceValue(@Nullable final Double... nullableShortSequenceValue) {
    setNullableShortSequenceValue( JsArray.asJsArray( nullableShortSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary nullableShortSequenceValue(
      @Nullable final Double... nullableShortSequenceValue) {
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
  Promise<SomeType> nullableSomeTypePromiseValue();

  @JsProperty
  void setNullableSomeTypePromiseValue(@Nonnull Promise<SomeType> nullableSomeTypePromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSomeTypePromiseValue(
      @Nonnull final Promise<SomeType> nullableSomeTypePromiseValue) {
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
    setNullableSomeTypeSequenceValue( JsArray.asJsArray( nullableSomeTypeSequenceValue ) );
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
      name = "nullableSymbolValue"
  )
  @Nullable
  Symbol nullableSymbolValue();

  @JsProperty
  void setNullableSymbolValue(@Nullable Symbol nullableSymbolValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableSymbolValue(@Nullable final Symbol nullableSymbolValue) {
    setNullableSymbolValue( nullableSymbolValue );
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
      name = "nullableUint16ArrayValue"
  )
  @Nullable
  Uint16Array nullableUint16ArrayValue();

  @JsProperty
  void setNullableUint16ArrayValue(@Nullable Uint16Array nullableUint16ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUint16ArrayValue(
      @Nullable final Uint16Array nullableUint16ArrayValue) {
    setNullableUint16ArrayValue( nullableUint16ArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableUint32ArrayValue"
  )
  @Nullable
  Uint32Array nullableUint32ArrayValue();

  @JsProperty
  void setNullableUint32ArrayValue(@Nullable Uint32Array nullableUint32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUint32ArrayValue(
      @Nullable final Uint32Array nullableUint32ArrayValue) {
    setNullableUint32ArrayValue( nullableUint32ArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableUint8ArrayValue"
  )
  @Nullable
  Uint8Array nullableUint8ArrayValue();

  @JsProperty
  void setNullableUint8ArrayValue(@Nullable Uint8Array nullableUint8ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary nullableUint8ArrayValue(@Nullable final Uint8Array nullableUint8ArrayValue) {
    setNullableUint8ArrayValue( nullableUint8ArrayValue );
    return this;
  }

  @JsProperty(
      name = "nullableUint8ClampedArrayValue"
  )
  @Nullable
  Uint8ClampedArray nullableUint8ClampedArrayValue();

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
      name = "sequencePromiseValue"
  )
  Promise<JsArray<Double>> sequencePromiseValue();

  @JsProperty
  void setSequencePromiseValue(@Nonnull Promise<JsArray<Double>> sequencePromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary sequencePromiseValue(
      @Nonnull final Promise<JsArray<Double>> sequencePromiseValue) {
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
  Promise<Double> shortPromiseValue();

  @JsProperty
  void setShortPromiseValue(@Nonnull Promise<Double> shortPromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary shortPromiseValue(@Nonnull final Promise<Double> shortPromiseValue) {
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
  default void setShortSequenceValue(@Nonnull final Double... shortSequenceValue) {
    setShortSequenceValue( JsArray.asJsArray( shortSequenceValue ) );
  }

  @JsOverlay
  @Nonnull
  default MyDictionary shortSequenceValue(@Nonnull final Double... shortSequenceValue) {
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
  Promise<SomeType> someTypePromiseValue();

  @JsProperty
  void setSomeTypePromiseValue(@Nonnull Promise<SomeType> someTypePromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary someTypePromiseValue(@Nonnull final Promise<SomeType> someTypePromiseValue) {
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
    setSomeTypeSequenceValue( JsArray.asJsArray( someTypeSequenceValue ) );
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
      name = "symbolValue"
  )
  Symbol symbolValue();

  @JsProperty
  void setSymbolValue(@Nonnull Symbol symbolValue);

  @JsOverlay
  @Nonnull
  default MyDictionary symbolValue(@Nonnull final Symbol symbolValue) {
    setSymbolValue( symbolValue );
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
      name = "uint16ArrayValue"
  )
  Uint16Array uint16ArrayValue();

  @JsProperty
  void setUint16ArrayValue(@Nonnull Uint16Array uint16ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary uint16ArrayValue(@Nonnull final Uint16Array uint16ArrayValue) {
    setUint16ArrayValue( uint16ArrayValue );
    return this;
  }

  @JsProperty(
      name = "uint32ArrayValue"
  )
  Uint32Array uint32ArrayValue();

  @JsProperty
  void setUint32ArrayValue(@Nonnull Uint32Array uint32ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary uint32ArrayValue(@Nonnull final Uint32Array uint32ArrayValue) {
    setUint32ArrayValue( uint32ArrayValue );
    return this;
  }

  @JsProperty(
      name = "uint8ArrayValue"
  )
  Uint8Array uint8ArrayValue();

  @JsProperty
  void setUint8ArrayValue(@Nonnull Uint8Array uint8ArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary uint8ArrayValue(@Nonnull final Uint8Array uint8ArrayValue) {
    setUint8ArrayValue( uint8ArrayValue );
    return this;
  }

  @JsProperty(
      name = "uint8ClampedArrayValue"
  )
  Uint8ClampedArray uint8ClampedArrayValue();

  @JsProperty
  void setUint8ClampedArrayValue(@Nonnull Uint8ClampedArray uint8ClampedArrayValue);

  @JsOverlay
  @Nonnull
  default MyDictionary uint8ClampedArrayValue(
      @Nonnull final Uint8ClampedArray uint8ClampedArrayValue) {
    setUint8ClampedArrayValue( uint8ClampedArrayValue );
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
  Promise<Void> voidPromiseValue();

  @JsProperty
  void setVoidPromiseValue(@Nonnull Promise<Void> voidPromiseValue);

  @JsOverlay
  @Nonnull
  default MyDictionary voidPromiseValue(@Nonnull final Promise<Void> voidPromiseValue) {
    setVoidPromiseValue( voidPromiseValue );
    return this;
  }
}
