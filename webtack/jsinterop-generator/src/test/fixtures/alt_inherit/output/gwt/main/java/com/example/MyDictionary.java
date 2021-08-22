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
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
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
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "anyValue"
  )
  @JsNullable
  Any anyValue();

  @JsProperty
  void setAnyValue(@DoNotAutobox @JsNullable Object anyValue);

  @JsProperty(
      name = "booleanFrozenArrayValue"
  )
  JsArray<Boolean> booleanFrozenArrayValue();

  @JsProperty
  void setBooleanFrozenArrayValue(@JsNonNull JsArray<Boolean> booleanFrozenArrayValue);

  @JsProperty(
      name = "booleanSequenceValue"
  )
  JsArray<Boolean> booleanSequenceValue();

  @JsProperty
  void setBooleanSequenceValue(@JsNonNull JsArray<Boolean> booleanSequenceValue);

  @JsOverlay
  default void setBooleanSequenceValue(@Nonnull final Boolean... booleanSequenceValue) {
    setBooleanSequenceValue( Js.<JsArray<Boolean>>uncheckedCast( booleanSequenceValue ) );
  }

  @JsProperty(
      name = "booleanValue"
  )
  boolean booleanValue();

  @JsProperty
  void setBooleanValue(boolean booleanValue);

  @JsProperty(
      name = "byteStringRecordValue"
  )
  JsPropertyMap<String> byteStringRecordValue();

  @JsProperty
  void setByteStringRecordValue(@JsNonNull JsPropertyMap<String> byteStringRecordValue);

  @JsProperty(
      name = "byteStringValue"
  )
  String byteStringValue();

  @JsProperty
  void setByteStringValue(@JsNonNull String byteStringValue);

  @JsProperty(
      name = "byteValue"
  )
  byte byteValue();

  @JsProperty
  void setByteValue(byte byteValue);

  @JsProperty(
      name = "domStringRecordValue"
  )
  JsPropertyMap<String> domStringRecordValue();

  @JsProperty
  void setDomStringRecordValue(@JsNonNull JsPropertyMap<String> domStringRecordValue);

  @JsProperty(
      name = "domStringValue"
  )
  String domStringValue();

  @JsProperty
  void setDomStringValue(@JsNonNull String domStringValue);

  @JsProperty(
      name = "doubleFrozenArrayValue"
  )
  JsArray<Double> doubleFrozenArrayValue();

  @JsProperty
  void setDoubleFrozenArrayValue(@JsNonNull JsArray<Double> doubleFrozenArrayValue);

  @JsProperty(
      name = "doubleRecordValue"
  )
  JsPropertyMap<Double> doubleRecordValue();

  @JsProperty
  void setDoubleRecordValue(@JsNonNull JsPropertyMap<Double> doubleRecordValue);

  @JsProperty(
      name = "doubleSequenceValue"
  )
  JsArray<Double> doubleSequenceValue();

  @JsProperty
  void setDoubleSequenceValue(@JsNonNull JsArray<Double> doubleSequenceValue);

  @JsOverlay
  default void setDoubleSequenceValue(@Nonnull final double... doubleSequenceValue) {
    setDoubleSequenceValue( Js.<JsArray<Double>>uncheckedCast( doubleSequenceValue ) );
  }

  @JsProperty(
      name = "doubleValue"
  )
  double doubleValue();

  @JsProperty
  void setDoubleValue(double doubleValue);

  @JsProperty(
      name = "floatFrozenArrayValue"
  )
  JsArray<Double> floatFrozenArrayValue();

  @JsProperty
  void setFloatFrozenArrayValue(@JsNonNull JsArray<Double> floatFrozenArrayValue);

  @JsProperty(
      name = "floatSequenceValue"
  )
  JsArray<Double> floatSequenceValue();

  @JsProperty
  void setFloatSequenceValue(@JsNonNull JsArray<Double> floatSequenceValue);

  @JsOverlay
  default void setFloatSequenceValue(@Nonnull final double... floatSequenceValue) {
    setFloatSequenceValue( Js.<JsArray<Double>>uncheckedCast( floatSequenceValue ) );
  }

  @JsProperty(
      name = "floatValue"
  )
  float floatValue();

  @JsProperty
  void setFloatValue(float floatValue);

  @JsProperty(
      name = "longLongValue"
  )
  int longLongValue();

  @JsProperty
  void setLongLongValue(int longLongValue);

  @JsProperty(
      name = "longValue"
  )
  int longValue();

  @JsProperty
  void setLongValue(int longValue);

  @JsProperty(
      name = "mixedStringRecordValue"
  )
  JsPropertyMap<String> mixedStringRecordValue();

  @JsProperty
  void setMixedStringRecordValue(@JsNonNull JsPropertyMap<String> mixedStringRecordValue);

  @JsProperty(
      name = "nullableBooleanFrozenArrayValue"
  )
  @JsNullable
  JsArray<Boolean> nullableBooleanFrozenArrayValue();

  @JsProperty
  void setNullableBooleanFrozenArrayValue(
      @JsNullable JsArray<Boolean> nullableBooleanFrozenArrayValue);

  @JsProperty(
      name = "nullableBooleanSequenceValue"
  )
  @JsNullable
  JsArray<Boolean> nullableBooleanSequenceValue();

  @JsProperty
  void setNullableBooleanSequenceValue(@JsNullable JsArray<Boolean> nullableBooleanSequenceValue);

  @JsOverlay
  default void setNullableBooleanSequenceValue(
      @Nullable final Boolean... nullableBooleanSequenceValue) {
    setNullableBooleanSequenceValue( Js.<JsArray<Boolean>>uncheckedCast( nullableBooleanSequenceValue ) );
  }

  @JsProperty(
      name = "nullableBooleanValue"
  )
  @JsNullable
  Boolean nullableBooleanValue();

  @JsProperty
  void setNullableBooleanValue(@JsNullable Boolean nullableBooleanValue);

  @JsProperty(
      name = "nullableByteStringValue"
  )
  @JsNullable
  String nullableByteStringValue();

  @JsProperty
  void setNullableByteStringValue(@JsNullable String nullableByteStringValue);

  @JsProperty(
      name = "nullableByteValue"
  )
  @JsNullable
  Double nullableByteValue();

  @JsProperty
  void setNullableByteValue(@JsNullable Double nullableByteValue);

  @JsProperty(
      name = "nullableDOMStringValue"
  )
  @JsNullable
  String nullableDOMStringValue();

  @JsProperty
  void setNullableDOMStringValue(@JsNullable String nullableDOMStringValue);

  @JsProperty(
      name = "nullableDoubleFrozenArrayValue"
  )
  @JsNullable
  JsArray<Double> nullableDoubleFrozenArrayValue();

  @JsProperty
  void setNullableDoubleFrozenArrayValue(
      @JsNullable JsArray<Double> nullableDoubleFrozenArrayValue);

  @JsProperty(
      name = "nullableDoubleSequenceValue"
  )
  @JsNullable
  JsArray<Double> nullableDoubleSequenceValue();

  @JsProperty
  void setNullableDoubleSequenceValue(@JsNullable JsArray<Double> nullableDoubleSequenceValue);

  @JsOverlay
  default void setNullableDoubleSequenceValue(
      @Nullable final double... nullableDoubleSequenceValue) {
    setNullableDoubleSequenceValue( Js.<JsArray<Double>>uncheckedCast( nullableDoubleSequenceValue ) );
  }

  @JsProperty(
      name = "nullableDoubleValue"
  )
  @JsNullable
  Double nullableDoubleValue();

  @JsProperty
  void setNullableDoubleValue(@JsNullable Double nullableDoubleValue);

  @JsProperty(
      name = "nullableFloatFrozenArrayValue"
  )
  @JsNullable
  JsArray<Double> nullableFloatFrozenArrayValue();

  @JsProperty
  void setNullableFloatFrozenArrayValue(@JsNullable JsArray<Double> nullableFloatFrozenArrayValue);

  @JsProperty(
      name = "nullableFloatSequenceValue"
  )
  @JsNullable
  JsArray<Double> nullableFloatSequenceValue();

  @JsProperty
  void setNullableFloatSequenceValue(@JsNullable JsArray<Double> nullableFloatSequenceValue);

  @JsOverlay
  default void setNullableFloatSequenceValue(@Nullable final double... nullableFloatSequenceValue) {
    setNullableFloatSequenceValue( Js.<JsArray<Double>>uncheckedCast( nullableFloatSequenceValue ) );
  }

  @JsProperty(
      name = "nullableFloatValue"
  )
  @JsNullable
  Double nullableFloatValue();

  @JsProperty
  void setNullableFloatValue(@JsNullable Double nullableFloatValue);

  @JsProperty(
      name = "nullableLongLongValue"
  )
  @JsNullable
  Double nullableLongLongValue();

  @JsProperty
  void setNullableLongLongValue(@JsNullable Double nullableLongLongValue);

  @JsProperty(
      name = "nullableLongValue"
  )
  @JsNullable
  Double nullableLongValue();

  @JsProperty
  void setNullableLongValue(@JsNullable Double nullableLongValue);

  @JsProperty(
      name = "nullableObjectValue"
  )
  @JsNullable
  JsObject nullableObjectValue();

  @JsProperty
  void setNullableObjectValue(@JsNullable JsObject nullableObjectValue);

  @JsProperty(
      name = "nullableOctetValue"
  )
  @JsNullable
  Double nullableOctetValue();

  @JsProperty
  void setNullableOctetValue(@JsNullable Double nullableOctetValue);

  @JsProperty(
      name = "nullableShortFrozenArrayValue"
  )
  @JsNullable
  JsArray<Double> nullableShortFrozenArrayValue();

  @JsProperty
  void setNullableShortFrozenArrayValue(@JsNullable JsArray<Double> nullableShortFrozenArrayValue);

  @JsProperty(
      name = "nullableShortPromiseValue"
  )
  JsPromise<Double> nullableShortPromiseValue();

  @JsProperty
  void setNullableShortPromiseValue(@JsNonNull JsPromise<Double> nullableShortPromiseValue);

  @JsProperty(
      name = "nullableShortSequenceValue"
  )
  @JsNullable
  JsArray<Double> nullableShortSequenceValue();

  @JsProperty
  void setNullableShortSequenceValue(@JsNullable JsArray<Double> nullableShortSequenceValue);

  @JsOverlay
  default void setNullableShortSequenceValue(@Nullable final double... nullableShortSequenceValue) {
    setNullableShortSequenceValue( Js.<JsArray<Double>>uncheckedCast( nullableShortSequenceValue ) );
  }

  @JsProperty(
      name = "nullableShortValue"
  )
  @JsNullable
  Double nullableShortValue();

  @JsProperty
  void setNullableShortValue(@JsNullable Double nullableShortValue);

  @JsProperty(
      name = "nullableSomeTypeFrozenArrayValue"
  )
  @JsNullable
  JsArray<SomeType> nullableSomeTypeFrozenArrayValue();

  @JsProperty
  void setNullableSomeTypeFrozenArrayValue(
      @JsNullable JsArray<SomeType> nullableSomeTypeFrozenArrayValue);

  @JsProperty(
      name = "nullableSomeTypePromiseValue"
  )
  JsPromise<SomeType> nullableSomeTypePromiseValue();

  @JsProperty
  void setNullableSomeTypePromiseValue(@JsNonNull JsPromise<SomeType> nullableSomeTypePromiseValue);

  @JsProperty(
      name = "nullableSomeTypeSequenceValue"
  )
  @JsNullable
  JsArray<SomeType> nullableSomeTypeSequenceValue();

  @JsProperty
  void setNullableSomeTypeSequenceValue(
      @JsNullable JsArray<SomeType> nullableSomeTypeSequenceValue);

  @JsOverlay
  default void setNullableSomeTypeSequenceValue(
      @Nullable final SomeType... nullableSomeTypeSequenceValue) {
    setNullableSomeTypeSequenceValue( Js.<JsArray<SomeType>>uncheckedCast( nullableSomeTypeSequenceValue ) );
  }

  @JsProperty(
      name = "nullableSomeTypeValue"
  )
  @JsNullable
  SomeType nullableSomeTypeValue();

  @JsProperty
  void setNullableSomeTypeValue(@JsNullable SomeType nullableSomeTypeValue);

  @JsProperty(
      name = "nullableUSVStringValue"
  )
  @JsNullable
  String nullableUSVStringValue();

  @JsProperty
  void setNullableUSVStringValue(@JsNullable String nullableUSVStringValue);

  @JsProperty(
      name = "nullableUnrestrictedDoubleValue"
  )
  @JsNullable
  Double nullableUnrestrictedDoubleValue();

  @JsProperty
  void setNullableUnrestrictedDoubleValue(@JsNullable Double nullableUnrestrictedDoubleValue);

  @JsProperty(
      name = "nullableUnrestrictedFloatValue"
  )
  @JsNullable
  Double nullableUnrestrictedFloatValue();

  @JsProperty
  void setNullableUnrestrictedFloatValue(@JsNullable Double nullableUnrestrictedFloatValue);

  @JsProperty(
      name = "nullableUnsignedLongLongValue"
  )
  @JsNullable
  Double nullableUnsignedLongLongValue();

  @JsProperty
  void setNullableUnsignedLongLongValue(@JsNullable Double nullableUnsignedLongLongValue);

  @JsProperty(
      name = "nullableUnsignedLongValue"
  )
  @JsNullable
  Double nullableUnsignedLongValue();

  @JsProperty
  void setNullableUnsignedLongValue(@JsNullable Double nullableUnsignedLongValue);

  @JsProperty(
      name = "nullableUnsignedShortValue"
  )
  @JsNullable
  Double nullableUnsignedShortValue();

  @JsProperty
  void setNullableUnsignedShortValue(@JsNullable Double nullableUnsignedShortValue);

  @JsProperty(
      name = "objectValue"
  )
  JsObject objectValue();

  @JsProperty
  void setObjectValue(@JsNonNull JsObject objectValue);

  @JsProperty(
      name = "octetValue"
  )
  short octetValue();

  @JsProperty
  void setOctetValue(short octetValue);

  @JsProperty(
      name = "requiredAnyIterableValue"
  )
  JsIterable<Any> requiredAnyIterableValue();

  @JsProperty
  void setRequiredAnyIterableValue(@JsNonNull JsIterable<Any> requiredAnyIterableValue);

  @JsProperty(
      name = "requiredAnyIteratorIterableValue"
  )
  JsIteratorIterable<Any> requiredAnyIteratorIterableValue();

  @JsProperty
  void setRequiredAnyIteratorIterableValue(
      @JsNonNull JsIteratorIterable<Any> requiredAnyIteratorIterableValue);

  @JsProperty(
      name = "requiredAnyIteratorValue"
  )
  JsIterator<Any> requiredAnyIteratorValue();

  @JsProperty
  void setRequiredAnyIteratorValue(@JsNonNull JsIterator<Any> requiredAnyIteratorValue);

  @JsProperty(
      name = "requiredAnySequenceValue"
  )
  JsArray<Any> requiredAnySequenceValue();

  @JsProperty
  void setRequiredAnySequenceValue(@JsNonNull JsArray<Any> requiredAnySequenceValue);

  @JsOverlay
  default void setRequiredAnySequenceValue(@Nonnull final Any... requiredAnySequenceValue) {
    setRequiredAnySequenceValue( Js.<JsArray<Any>>uncheckedCast( requiredAnySequenceValue ) );
  }

  @JsProperty(
      name = "sequencePromiseValue"
  )
  JsPromise<JsArray<Double>> sequencePromiseValue();

  @JsProperty
  void setSequencePromiseValue(@JsNonNull JsPromise<JsArray<Double>> sequencePromiseValue);

  @JsProperty(
      name = "shortFrozenArrayValue"
  )
  JsArray<Double> shortFrozenArrayValue();

  @JsProperty
  void setShortFrozenArrayValue(@JsNonNull JsArray<Double> shortFrozenArrayValue);

  @JsProperty(
      name = "shortPromiseValue"
  )
  JsPromise<Double> shortPromiseValue();

  @JsProperty
  void setShortPromiseValue(@JsNonNull JsPromise<Double> shortPromiseValue);

  @JsProperty(
      name = "shortSequenceValue"
  )
  JsArray<Double> shortSequenceValue();

  @JsProperty
  void setShortSequenceValue(@JsNonNull JsArray<Double> shortSequenceValue);

  @JsOverlay
  default void setShortSequenceValue(@Nonnull final double... shortSequenceValue) {
    setShortSequenceValue( Js.<JsArray<Double>>uncheckedCast( shortSequenceValue ) );
  }

  @JsProperty(
      name = "shortValue"
  )
  short shortValue();

  @JsProperty
  void setShortValue(short shortValue);

  @JsProperty(
      name = "someTypeFrozenArrayValue"
  )
  JsArray<SomeType> someTypeFrozenArrayValue();

  @JsProperty
  void setSomeTypeFrozenArrayValue(@JsNonNull JsArray<SomeType> someTypeFrozenArrayValue);

  @JsProperty(
      name = "someTypePromiseValue"
  )
  JsPromise<SomeType> someTypePromiseValue();

  @JsProperty
  void setSomeTypePromiseValue(@JsNonNull JsPromise<SomeType> someTypePromiseValue);

  @JsProperty(
      name = "someTypeSequenceValue"
  )
  JsArray<SomeType> someTypeSequenceValue();

  @JsProperty
  void setSomeTypeSequenceValue(@JsNonNull JsArray<SomeType> someTypeSequenceValue);

  @JsOverlay
  default void setSomeTypeSequenceValue(@Nonnull final SomeType... someTypeSequenceValue) {
    setSomeTypeSequenceValue( Js.<JsArray<SomeType>>uncheckedCast( someTypeSequenceValue ) );
  }

  @JsProperty(
      name = "someTypeValue"
  )
  SomeType someTypeValue();

  @JsProperty
  void setSomeTypeValue(@JsNonNull SomeType someTypeValue);

  @JsProperty(
      name = "typeReferenceRecordValue"
  )
  JsPropertyMap<SomeType> typeReferenceRecordValue();

  @JsProperty
  void setTypeReferenceRecordValue(@JsNonNull JsPropertyMap<SomeType> typeReferenceRecordValue);

  @JsProperty(
      name = "unrestrictedDoubleValue"
  )
  double unrestrictedDoubleValue();

  @JsProperty
  void setUnrestrictedDoubleValue(double unrestrictedDoubleValue);

  @JsProperty(
      name = "unrestrictedFloatValue"
  )
  float unrestrictedFloatValue();

  @JsProperty
  void setUnrestrictedFloatValue(float unrestrictedFloatValue);

  @JsProperty(
      name = "unsignedLongLongValue"
  )
  int unsignedLongLongValue();

  @JsProperty
  void setUnsignedLongLongValue(int unsignedLongLongValue);

  @JsProperty(
      name = "unsignedLongValue"
  )
  int unsignedLongValue();

  @JsProperty
  void setUnsignedLongValue(int unsignedLongValue);

  @JsProperty(
      name = "unsignedShortValue"
  )
  int unsignedShortValue();

  @JsProperty
  void setUnsignedShortValue(int unsignedShortValue);

  @JsProperty(
      name = "usvStringRecordValue"
  )
  JsPropertyMap<String> usvStringRecordValue();

  @JsProperty
  void setUsvStringRecordValue(@JsNonNull JsPropertyMap<String> usvStringRecordValue);

  @JsProperty(
      name = "usvStringValue"
  )
  String usvStringValue();

  @JsProperty
  void setUsvStringValue(@JsNonNull String usvStringValue);

  @JsProperty(
      name = "voidPromiseValue"
  )
  JsPromise<Void> voidPromiseValue();

  @JsProperty
  void setVoidPromiseValue(@JsNonNull JsPromise<Void> voidPromiseValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends MyDictionary {
    @JsOverlay
    @Nonnull
    default Builder anyValue(@DoNotAutobox @Nullable final Object anyValue) {
      setAnyValue( anyValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder booleanFrozenArrayValue(
        @Nonnull final JsArray<Boolean> booleanFrozenArrayValue) {
      setBooleanFrozenArrayValue( booleanFrozenArrayValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder booleanSequenceValue(@Nonnull final JsArray<Boolean> booleanSequenceValue) {
      setBooleanSequenceValue( booleanSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder booleanSequenceValue(@Nonnull final Boolean... booleanSequenceValue) {
      setBooleanSequenceValue( booleanSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder booleanValue(final boolean booleanValue) {
      setBooleanValue( booleanValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder byteStringRecordValue(
        @Nonnull final JsPropertyMap<String> byteStringRecordValue) {
      setByteStringRecordValue( byteStringRecordValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder byteStringValue(@Nonnull final String byteStringValue) {
      setByteStringValue( byteStringValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder byteValue(final byte byteValue) {
      setByteValue( byteValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder domStringRecordValue(
        @Nonnull final JsPropertyMap<String> domStringRecordValue) {
      setDomStringRecordValue( domStringRecordValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder domStringValue(@Nonnull final String domStringValue) {
      setDomStringValue( domStringValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder doubleFrozenArrayValue(@Nonnull final JsArray<Double> doubleFrozenArrayValue) {
      setDoubleFrozenArrayValue( doubleFrozenArrayValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder doubleRecordValue(@Nonnull final JsPropertyMap<Double> doubleRecordValue) {
      setDoubleRecordValue( doubleRecordValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder doubleSequenceValue(@Nonnull final JsArray<Double> doubleSequenceValue) {
      setDoubleSequenceValue( doubleSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder doubleSequenceValue(@Nonnull final double... doubleSequenceValue) {
      setDoubleSequenceValue( doubleSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder doubleValue(final double doubleValue) {
      setDoubleValue( doubleValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder floatFrozenArrayValue(@Nonnull final JsArray<Double> floatFrozenArrayValue) {
      setFloatFrozenArrayValue( floatFrozenArrayValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder floatSequenceValue(@Nonnull final JsArray<Double> floatSequenceValue) {
      setFloatSequenceValue( floatSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder floatSequenceValue(@Nonnull final double... floatSequenceValue) {
      setFloatSequenceValue( floatSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder floatValue(final float floatValue) {
      setFloatValue( floatValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder longLongValue(final int longLongValue) {
      setLongLongValue( longLongValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder longValue(final int longValue) {
      setLongValue( longValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder mixedStringRecordValue(
        @Nonnull final JsPropertyMap<String> mixedStringRecordValue) {
      setMixedStringRecordValue( mixedStringRecordValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableBooleanFrozenArrayValue(
        @Nullable final JsArray<Boolean> nullableBooleanFrozenArrayValue) {
      setNullableBooleanFrozenArrayValue( nullableBooleanFrozenArrayValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableBooleanSequenceValue(
        @Nullable final JsArray<Boolean> nullableBooleanSequenceValue) {
      setNullableBooleanSequenceValue( nullableBooleanSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableBooleanSequenceValue(
        @Nullable final Boolean... nullableBooleanSequenceValue) {
      setNullableBooleanSequenceValue( nullableBooleanSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableBooleanValue(@Nullable final Boolean nullableBooleanValue) {
      setNullableBooleanValue( nullableBooleanValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableByteStringValue(@Nullable final String nullableByteStringValue) {
      setNullableByteStringValue( nullableByteStringValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableByteValue(@Nullable final Double nullableByteValue) {
      setNullableByteValue( nullableByteValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableDOMStringValue(@Nullable final String nullableDOMStringValue) {
      setNullableDOMStringValue( nullableDOMStringValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableDoubleFrozenArrayValue(
        @Nullable final JsArray<Double> nullableDoubleFrozenArrayValue) {
      setNullableDoubleFrozenArrayValue( nullableDoubleFrozenArrayValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableDoubleSequenceValue(
        @Nullable final JsArray<Double> nullableDoubleSequenceValue) {
      setNullableDoubleSequenceValue( nullableDoubleSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableDoubleSequenceValue(
        @Nullable final double... nullableDoubleSequenceValue) {
      setNullableDoubleSequenceValue( nullableDoubleSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableDoubleValue(@Nullable final Double nullableDoubleValue) {
      setNullableDoubleValue( nullableDoubleValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableFloatFrozenArrayValue(
        @Nullable final JsArray<Double> nullableFloatFrozenArrayValue) {
      setNullableFloatFrozenArrayValue( nullableFloatFrozenArrayValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableFloatSequenceValue(
        @Nullable final JsArray<Double> nullableFloatSequenceValue) {
      setNullableFloatSequenceValue( nullableFloatSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableFloatSequenceValue(
        @Nullable final double... nullableFloatSequenceValue) {
      setNullableFloatSequenceValue( nullableFloatSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableFloatValue(@Nullable final Double nullableFloatValue) {
      setNullableFloatValue( nullableFloatValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableLongLongValue(@Nullable final Double nullableLongLongValue) {
      setNullableLongLongValue( nullableLongLongValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableLongValue(@Nullable final Double nullableLongValue) {
      setNullableLongValue( nullableLongValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableObjectValue(@Nullable final JsObject nullableObjectValue) {
      setNullableObjectValue( nullableObjectValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableOctetValue(@Nullable final Double nullableOctetValue) {
      setNullableOctetValue( nullableOctetValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableShortFrozenArrayValue(
        @Nullable final JsArray<Double> nullableShortFrozenArrayValue) {
      setNullableShortFrozenArrayValue( nullableShortFrozenArrayValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableShortPromiseValue(
        @Nonnull final JsPromise<Double> nullableShortPromiseValue) {
      setNullableShortPromiseValue( nullableShortPromiseValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableShortSequenceValue(
        @Nullable final JsArray<Double> nullableShortSequenceValue) {
      setNullableShortSequenceValue( nullableShortSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableShortSequenceValue(
        @Nullable final double... nullableShortSequenceValue) {
      setNullableShortSequenceValue( nullableShortSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableShortValue(@Nullable final Double nullableShortValue) {
      setNullableShortValue( nullableShortValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableSomeTypeFrozenArrayValue(
        @Nullable final JsArray<SomeType> nullableSomeTypeFrozenArrayValue) {
      setNullableSomeTypeFrozenArrayValue( nullableSomeTypeFrozenArrayValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableSomeTypePromiseValue(
        @Nonnull final JsPromise<SomeType> nullableSomeTypePromiseValue) {
      setNullableSomeTypePromiseValue( nullableSomeTypePromiseValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableSomeTypeSequenceValue(
        @Nullable final JsArray<SomeType> nullableSomeTypeSequenceValue) {
      setNullableSomeTypeSequenceValue( nullableSomeTypeSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableSomeTypeSequenceValue(
        @Nullable final SomeType... nullableSomeTypeSequenceValue) {
      setNullableSomeTypeSequenceValue( nullableSomeTypeSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableSomeTypeValue(@Nullable final SomeType nullableSomeTypeValue) {
      setNullableSomeTypeValue( nullableSomeTypeValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableUSVStringValue(@Nullable final String nullableUSVStringValue) {
      setNullableUSVStringValue( nullableUSVStringValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableUnrestrictedDoubleValue(
        @Nullable final Double nullableUnrestrictedDoubleValue) {
      setNullableUnrestrictedDoubleValue( nullableUnrestrictedDoubleValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableUnrestrictedFloatValue(
        @Nullable final Double nullableUnrestrictedFloatValue) {
      setNullableUnrestrictedFloatValue( nullableUnrestrictedFloatValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableUnsignedLongLongValue(
        @Nullable final Double nullableUnsignedLongLongValue) {
      setNullableUnsignedLongLongValue( nullableUnsignedLongLongValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableUnsignedLongValue(@Nullable final Double nullableUnsignedLongValue) {
      setNullableUnsignedLongValue( nullableUnsignedLongValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder nullableUnsignedShortValue(@Nullable final Double nullableUnsignedShortValue) {
      setNullableUnsignedShortValue( nullableUnsignedShortValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder objectValue(@Nonnull final JsObject objectValue) {
      setObjectValue( objectValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder octetValue(final short octetValue) {
      setOctetValue( octetValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredAnyIterableValue(
        @Nonnull final JsIterable<Any> requiredAnyIterableValue) {
      setRequiredAnyIterableValue( requiredAnyIterableValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredAnyIteratorIterableValue(
        @Nonnull final JsIteratorIterable<Any> requiredAnyIteratorIterableValue) {
      setRequiredAnyIteratorIterableValue( requiredAnyIteratorIterableValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredAnyIteratorValue(
        @Nonnull final JsIterator<Any> requiredAnyIteratorValue) {
      setRequiredAnyIteratorValue( requiredAnyIteratorValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredAnySequenceValue(@Nonnull final JsArray<Any> requiredAnySequenceValue) {
      setRequiredAnySequenceValue( requiredAnySequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder requiredAnySequenceValue(@Nonnull final Any... requiredAnySequenceValue) {
      setRequiredAnySequenceValue( requiredAnySequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder sequencePromiseValue(
        @Nonnull final JsPromise<JsArray<Double>> sequencePromiseValue) {
      setSequencePromiseValue( sequencePromiseValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder shortFrozenArrayValue(@Nonnull final JsArray<Double> shortFrozenArrayValue) {
      setShortFrozenArrayValue( shortFrozenArrayValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder shortPromiseValue(@Nonnull final JsPromise<Double> shortPromiseValue) {
      setShortPromiseValue( shortPromiseValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder shortSequenceValue(@Nonnull final JsArray<Double> shortSequenceValue) {
      setShortSequenceValue( shortSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder shortSequenceValue(@Nonnull final double... shortSequenceValue) {
      setShortSequenceValue( shortSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder shortValue(final short shortValue) {
      setShortValue( shortValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder someTypeFrozenArrayValue(
        @Nonnull final JsArray<SomeType> someTypeFrozenArrayValue) {
      setSomeTypeFrozenArrayValue( someTypeFrozenArrayValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder someTypePromiseValue(@Nonnull final JsPromise<SomeType> someTypePromiseValue) {
      setSomeTypePromiseValue( someTypePromiseValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder someTypeSequenceValue(@Nonnull final JsArray<SomeType> someTypeSequenceValue) {
      setSomeTypeSequenceValue( someTypeSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder someTypeSequenceValue(@Nonnull final SomeType... someTypeSequenceValue) {
      setSomeTypeSequenceValue( someTypeSequenceValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder someTypeValue(@Nonnull final SomeType someTypeValue) {
      setSomeTypeValue( someTypeValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder typeReferenceRecordValue(
        @Nonnull final JsPropertyMap<SomeType> typeReferenceRecordValue) {
      setTypeReferenceRecordValue( typeReferenceRecordValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder unrestrictedDoubleValue(final double unrestrictedDoubleValue) {
      setUnrestrictedDoubleValue( unrestrictedDoubleValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder unrestrictedFloatValue(final float unrestrictedFloatValue) {
      setUnrestrictedFloatValue( unrestrictedFloatValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder unsignedLongLongValue(final int unsignedLongLongValue) {
      setUnsignedLongLongValue( unsignedLongLongValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder unsignedLongValue(final int unsignedLongValue) {
      setUnsignedLongValue( unsignedLongValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder unsignedShortValue(final int unsignedShortValue) {
      setUnsignedShortValue( unsignedShortValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder usvStringRecordValue(
        @Nonnull final JsPropertyMap<String> usvStringRecordValue) {
      setUsvStringRecordValue( usvStringRecordValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder usvStringValue(@Nonnull final String usvStringValue) {
      setUsvStringValue( usvStringValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder voidPromiseValue(@Nonnull final JsPromise<Void> voidPromiseValue) {
      setVoidPromiseValue( voidPromiseValue );
      return this;
    }
  }
}
