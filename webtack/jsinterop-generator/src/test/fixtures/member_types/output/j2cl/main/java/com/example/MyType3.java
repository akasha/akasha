package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "MyType3"
)
public class MyType3 {
  protected MyType3() {
  }

  @JsNonNull
  public native JsIterable<Any> anyIterableMethod(@Nonnull JsIterable<Any> v1,
      @Nonnull JsIterable<Any> v2);

  @JsNonNull
  public native JsIterable<Any> anyIterableMethod(@Nonnull JsIterable<Any> v1);

  @JsNonNull
  public native JsIteratorIterable<Any> anyIteratorIterableMethod(
      @Nonnull JsIteratorIterable<Any> v1, @Nonnull JsIteratorIterable<Any> v2);

  @JsNonNull
  public native JsIteratorIterable<Any> anyIteratorIterableMethod(
      @Nonnull JsIteratorIterable<Any> v1);

  @JsNonNull
  public native JsIterator<Any> anyIteratorMethod(@Nonnull JsIterator<Any> v1,
      @Nonnull JsIterator<Any> v2);

  @JsNonNull
  public native JsIterator<Any> anyIteratorMethod(@Nonnull JsIterator<Any> v1);

  @JsNullable
  public native Any anyMethod(@DoNotAutobox @Nullable Object v1, @DoNotAutobox @Nullable Object v2);

  @JsNullable
  public native Any anyMethod(@DoNotAutobox @Nullable Object v1);

  @JsNonNull
  public native JsArray<Any> anySequenceMethod(@Nonnull JsArray<Any> v1, @Nonnull JsArray<Any> v2);

  @JsNonNull
  public native JsArray<Any> anySequenceMethod(@Nonnull Any[] v1, @Nonnull JsArray<Any> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Any> anySequenceMethod(@Nonnull final JsArray<Any> v1,
      @Nonnull final Any... v2) {
    return _anySequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "anySequenceMethod"
  )
  @JsNonNull
  private native JsArray<Any> _anySequenceMethod(@Nonnull JsArray<Any> v1, @Nonnull Any[] v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Any> anySequenceMethod(@Nonnull final Any[] v1, @Nonnull final Any... v2) {
    return _anySequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "anySequenceMethod"
  )
  @JsNonNull
  private native JsArray<Any> _anySequenceMethod(@Nonnull Any[] v1, @Nonnull Any[] v2);

  @JsNonNull
  public native JsArray<Any> anySequenceMethod(@Nonnull JsArray<Any> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<Any> anySequenceMethod(@Nonnull final Any... v1) {
    return _anySequenceMethod( v1 );
  }

  @JsMethod(
      name = "anySequenceMethod"
  )
  @JsNonNull
  private native JsArray<Any> _anySequenceMethod(@Nonnull Any[] v1);

  @JsNonNull
  public native JsArray<Boolean> booleanFrozenArrayMethod(@Nonnull JsArray<Boolean> v1,
      @Nonnull JsArray<Boolean> v2);

  @JsNonNull
  public native JsArray<Boolean> booleanFrozenArrayMethod(@Nonnull JsArray<Boolean> v1);

  public native boolean booleanMethod(boolean v1, boolean v2);

  public native boolean booleanMethod(boolean v1);

  @JsNonNull
  public native JsArray<Boolean> booleanSequenceMethod(@Nonnull JsArray<Boolean> v1,
      @Nonnull JsArray<Boolean> v2);

  @JsNonNull
  public native JsArray<Boolean> booleanSequenceMethod(@Nonnull Boolean[] v1,
      @Nonnull JsArray<Boolean> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Boolean> booleanSequenceMethod(@Nonnull final JsArray<Boolean> v1,
      @Nonnull final Boolean... v2) {
    return _booleanSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "booleanSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Boolean> _booleanSequenceMethod(@Nonnull JsArray<Boolean> v1,
      @Nonnull Boolean[] v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Boolean> booleanSequenceMethod(@Nonnull final Boolean[] v1,
      @Nonnull final Boolean... v2) {
    return _booleanSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "booleanSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Boolean> _booleanSequenceMethod(@Nonnull Boolean[] v1,
      @Nonnull Boolean[] v2);

  @JsNonNull
  public native JsArray<Boolean> booleanSequenceMethod(@Nonnull JsArray<Boolean> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<Boolean> booleanSequenceMethod(@Nonnull final Boolean... v1) {
    return _booleanSequenceMethod( v1 );
  }

  @JsMethod(
      name = "booleanSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Boolean> _booleanSequenceMethod(@Nonnull Boolean[] v1);

  public native byte byteMethod(byte v1, byte v2);

  public native byte byteMethod(byte v1);

  @JsNonNull
  public native String byteStringMethod(@Nonnull String v1, @Nonnull String v2);

  @JsNonNull
  public native String byteStringMethod(@Nonnull String v1);

  @JsNonNull
  public native JsPropertyMap<String> byteStringRecordMethod(@Nonnull JsPropertyMap<String> v1,
      @Nonnull JsPropertyMap<String> v2);

  @JsNonNull
  public native JsPropertyMap<String> byteStringRecordMethod(@Nonnull JsPropertyMap<String> v1);

  @JsNonNull
  public native String domStringMethod(@Nonnull String v1, @Nonnull String v2);

  @JsNonNull
  public native String domStringMethod(@Nonnull String v1);

  @JsNonNull
  public native JsPropertyMap<String> domStringRecordMethod(@Nonnull JsPropertyMap<String> v1,
      @Nonnull JsPropertyMap<String> v2);

  @JsNonNull
  public native JsPropertyMap<String> domStringRecordMethod(@Nonnull JsPropertyMap<String> v1);

  @JsNonNull
  public native JsArray<Double> doubleFrozenArrayMethod(@Nonnull JsArray<Double> v1,
      @Nonnull JsArray<Double> v2);

  @JsNonNull
  public native JsArray<Double> doubleFrozenArrayMethod(@Nonnull JsArray<Double> v1);

  public native double doubleMethod(double v1, double v2);

  public native double doubleMethod(double v1);

  @JsNonNull
  public native JsPropertyMap<Double> doubleRecordMethod(@Nonnull JsPropertyMap<Double> v1,
      @Nonnull JsPropertyMap<Double> v2);

  @JsNonNull
  public native JsPropertyMap<Double> doubleRecordMethod(@Nonnull JsPropertyMap<Double> v1);

  @JsNonNull
  public native JsArray<Double> doubleSequenceMethod(@Nonnull JsArray<Double> v1,
      @Nonnull JsArray<Double> v2);

  @JsNonNull
  public native JsArray<Double> doubleSequenceMethod(@Nonnull double[] v1,
      @Nonnull JsArray<Double> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> doubleSequenceMethod(@Nonnull final JsArray<Double> v1,
      @Nonnull final double... v2) {
    return _doubleSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "doubleSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _doubleSequenceMethod(@Nonnull JsArray<Double> v1,
      @Nonnull double[] v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> doubleSequenceMethod(@Nonnull final double[] v1,
      @Nonnull final double... v2) {
    return _doubleSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "doubleSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _doubleSequenceMethod(@Nonnull double[] v1, @Nonnull double[] v2);

  @JsNonNull
  public native JsArray<Double> doubleSequenceMethod(@Nonnull JsArray<Double> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> doubleSequenceMethod(@Nonnull final double... v1) {
    return _doubleSequenceMethod( v1 );
  }

  @JsMethod(
      name = "doubleSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _doubleSequenceMethod(@Nonnull double[] v1);

  @JsNonNull
  public native JsArray<Double> floatFrozenArrayMethod(@Nonnull JsArray<Double> v1,
      @Nonnull JsArray<Double> v2);

  @JsNonNull
  public native JsArray<Double> floatFrozenArrayMethod(@Nonnull JsArray<Double> v1);

  public native float floatMethod(float v1, float v2);

  public native float floatMethod(float v1);

  @JsNonNull
  public native JsArray<Double> floatSequenceMethod(@Nonnull JsArray<Double> v1,
      @Nonnull JsArray<Double> v2);

  @JsNonNull
  public native JsArray<Double> floatSequenceMethod(@Nonnull double[] v1,
      @Nonnull JsArray<Double> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> floatSequenceMethod(@Nonnull final JsArray<Double> v1,
      @Nonnull final double... v2) {
    return _floatSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "floatSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _floatSequenceMethod(@Nonnull JsArray<Double> v1,
      @Nonnull double[] v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> floatSequenceMethod(@Nonnull final double[] v1,
      @Nonnull final double... v2) {
    return _floatSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "floatSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _floatSequenceMethod(@Nonnull double[] v1, @Nonnull double[] v2);

  @JsNonNull
  public native JsArray<Double> floatSequenceMethod(@Nonnull JsArray<Double> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> floatSequenceMethod(@Nonnull final double... v1) {
    return _floatSequenceMethod( v1 );
  }

  @JsMethod(
      name = "floatSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _floatSequenceMethod(@Nonnull double[] v1);

  public native int longLongMethod(int v1, int v2);

  public native int longLongMethod(int v1);

  @JsNonNull
  public native JsPromise<JsArray<Double>> longLongPromiseMethod(
      @Nonnull JsPromise<JsArray<Double>> v1, @Nonnull JsPromise<JsArray<Double>> v2);

  @JsNonNull
  public native JsPromise<JsArray<Double>> longLongPromiseMethod(
      @Nonnull JsPromise<JsArray<Double>> v1);

  public native int longMethod(int v1, int v2);

  public native int longMethod(int v1);

  @JsNonNull
  public native JsPropertyMap<String> mixedStringRecordMethod(@Nonnull JsPropertyMap<String> v1,
      @Nonnull JsPropertyMap<String> v2);

  @JsNonNull
  public native JsPropertyMap<String> mixedStringRecordMethod(@Nonnull JsPropertyMap<String> v1);

  @JsNullable
  public native JsArray<Boolean> nullableBooleanFrozenArrayMethod(@Nullable JsArray<Boolean> v1,
      @Nullable JsArray<Boolean> v2);

  @JsNullable
  public native JsArray<Boolean> nullableBooleanFrozenArrayMethod(@Nullable JsArray<Boolean> v1);

  @JsNullable
  public native Boolean nullableBooleanMethod(@Nullable Boolean v1, @Nullable Boolean v2);

  @JsNullable
  public native Boolean nullableBooleanMethod(@Nullable Boolean v1);

  @JsNullable
  public native JsArray<Boolean> nullableBooleanSequenceMethod(@Nullable JsArray<Boolean> v1,
      @Nullable JsArray<Boolean> v2);

  @JsNullable
  public native JsArray<Boolean> nullableBooleanSequenceMethod(@Nullable Boolean[] v1,
      @Nullable JsArray<Boolean> v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Boolean> nullableBooleanSequenceMethod(@Nullable final JsArray<Boolean> v1,
      @Nullable final Boolean... v2) {
    return _nullableBooleanSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableBooleanSequenceMethod"
  )
  @JsNullable
  private native JsArray<Boolean> _nullableBooleanSequenceMethod(@Nullable JsArray<Boolean> v1,
      @Nullable Boolean[] v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Boolean> nullableBooleanSequenceMethod(@Nullable final Boolean[] v1,
      @Nullable final Boolean... v2) {
    return _nullableBooleanSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableBooleanSequenceMethod"
  )
  @JsNullable
  private native JsArray<Boolean> _nullableBooleanSequenceMethod(@Nullable Boolean[] v1,
      @Nullable Boolean[] v2);

  @JsNullable
  public native JsArray<Boolean> nullableBooleanSequenceMethod(@Nullable JsArray<Boolean> v1);

  @JsOverlay
  @JsNullable
  public final JsArray<Boolean> nullableBooleanSequenceMethod(@Nullable final Boolean... v1) {
    return _nullableBooleanSequenceMethod( v1 );
  }

  @JsMethod(
      name = "nullableBooleanSequenceMethod"
  )
  @JsNullable
  private native JsArray<Boolean> _nullableBooleanSequenceMethod(@Nullable Boolean[] v1);

  @JsNullable
  public native Double nullableByteMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableByteMethod(@Nullable Double v1);

  @JsNullable
  public native String nullableByteStringMethod(@Nullable String v1, @Nullable String v2);

  @JsNullable
  public native String nullableByteStringMethod(@Nullable String v1);

  @JsNullable
  public native String nullableDOMStringMethod(@Nullable String v1, @Nullable String v2);

  @JsNullable
  public native String nullableDOMStringMethod(@Nullable String v1);

  @JsNullable
  public native JsArray<Double> nullableDoubleFrozenArrayMethod(@Nullable JsArray<Double> v1,
      @Nullable JsArray<Double> v2);

  @JsNullable
  public native JsArray<Double> nullableDoubleFrozenArrayMethod(@Nullable JsArray<Double> v1);

  @JsNullable
  public native Double nullableDoubleMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableDoubleMethod(@Nullable Double v1);

  @JsNullable
  public native JsArray<Double> nullableDoubleSequenceMethod(@Nullable JsArray<Double> v1,
      @Nullable JsArray<Double> v2);

  @JsNullable
  public native JsArray<Double> nullableDoubleSequenceMethod(@Nullable double[] v1,
      @Nullable JsArray<Double> v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableDoubleSequenceMethod(@Nullable final JsArray<Double> v1,
      @Nullable final double... v2) {
    return _nullableDoubleSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableDoubleSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableDoubleSequenceMethod(@Nullable JsArray<Double> v1,
      @Nullable double[] v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableDoubleSequenceMethod(@Nullable final double[] v1,
      @Nullable final double... v2) {
    return _nullableDoubleSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableDoubleSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableDoubleSequenceMethod(@Nullable double[] v1,
      @Nullable double[] v2);

  @JsNullable
  public native JsArray<Double> nullableDoubleSequenceMethod(@Nullable JsArray<Double> v1);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableDoubleSequenceMethod(@Nullable final double... v1) {
    return _nullableDoubleSequenceMethod( v1 );
  }

  @JsMethod(
      name = "nullableDoubleSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableDoubleSequenceMethod(@Nullable double[] v1);

  @JsNullable
  public native JsArray<Double> nullableFloatFrozenArrayMethod(@Nullable JsArray<Double> v1,
      @Nullable JsArray<Double> v2);

  @JsNullable
  public native JsArray<Double> nullableFloatFrozenArrayMethod(@Nullable JsArray<Double> v1);

  @JsNullable
  public native Double nullableFloatMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableFloatMethod(@Nullable Double v1);

  @JsNullable
  public native JsArray<Double> nullableFloatSequenceMethod(@Nullable JsArray<Double> v1,
      @Nullable JsArray<Double> v2);

  @JsNullable
  public native JsArray<Double> nullableFloatSequenceMethod(@Nullable double[] v1,
      @Nullable JsArray<Double> v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableFloatSequenceMethod(@Nullable final JsArray<Double> v1,
      @Nullable final double... v2) {
    return _nullableFloatSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableFloatSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableFloatSequenceMethod(@Nullable JsArray<Double> v1,
      @Nullable double[] v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableFloatSequenceMethod(@Nullable final double[] v1,
      @Nullable final double... v2) {
    return _nullableFloatSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableFloatSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableFloatSequenceMethod(@Nullable double[] v1,
      @Nullable double[] v2);

  @JsNullable
  public native JsArray<Double> nullableFloatSequenceMethod(@Nullable JsArray<Double> v1);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableFloatSequenceMethod(@Nullable final double... v1) {
    return _nullableFloatSequenceMethod( v1 );
  }

  @JsMethod(
      name = "nullableFloatSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableFloatSequenceMethod(@Nullable double[] v1);

  @JsNullable
  public native Double nullableLongLongMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableLongLongMethod(@Nullable Double v1);

  @JsNullable
  public native Double nullableLongMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableLongMethod(@Nullable Double v1);

  @JsNullable
  public native JsObject nullableObjectMethod(@Nullable JsObject v1, @Nullable JsObject v2);

  @JsNullable
  public native JsObject nullableObjectMethod(@Nullable JsObject v1);

  @JsNullable
  public native Double nullableOctetMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableOctetMethod(@Nullable Double v1);

  @JsNullable
  public native JsArray<Double> nullableShortFrozenArrayMethod(@Nullable JsArray<Double> v1,
      @Nullable JsArray<Double> v2);

  @JsNullable
  public native JsArray<Double> nullableShortFrozenArrayMethod(@Nullable JsArray<Double> v1);

  @JsNullable
  public native Double nullableShortMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableShortMethod(@Nullable Double v1);

  @JsNonNull
  public native JsPromise<Double> nullableShortPromiseMethod(@Nonnull JsPromise<Double> v1,
      @Nonnull JsPromise<Double> v2);

  @JsNonNull
  public native JsPromise<Double> nullableShortPromiseMethod(@Nonnull JsPromise<Double> v1);

  @JsNullable
  public native JsArray<Double> nullableShortSequenceMethod(@Nullable JsArray<Double> v1,
      @Nullable JsArray<Double> v2);

  @JsNullable
  public native JsArray<Double> nullableShortSequenceMethod(@Nullable double[] v1,
      @Nullable JsArray<Double> v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableShortSequenceMethod(@Nullable final JsArray<Double> v1,
      @Nullable final double... v2) {
    return _nullableShortSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableShortSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableShortSequenceMethod(@Nullable JsArray<Double> v1,
      @Nullable double[] v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableShortSequenceMethod(@Nullable final double[] v1,
      @Nullable final double... v2) {
    return _nullableShortSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableShortSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableShortSequenceMethod(@Nullable double[] v1,
      @Nullable double[] v2);

  @JsNullable
  public native JsArray<Double> nullableShortSequenceMethod(@Nullable JsArray<Double> v1);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableShortSequenceMethod(@Nullable final double... v1) {
    return _nullableShortSequenceMethod( v1 );
  }

  @JsMethod(
      name = "nullableShortSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableShortSequenceMethod(@Nullable double[] v1);

  @JsNullable
  public native JsArray<SomeType> nullableSomeTypeFrozenArrayMethod(@Nullable JsArray<SomeType> v1,
      @Nullable JsArray<SomeType> v2);

  @JsNullable
  public native JsArray<SomeType> nullableSomeTypeFrozenArrayMethod(@Nullable JsArray<SomeType> v1);

  @JsNullable
  public native SomeType nullableSomeTypeMethod(@Nullable SomeType v1, @Nullable SomeType v2);

  @JsNullable
  public native SomeType nullableSomeTypeMethod(@Nullable SomeType v1);

  @JsNonNull
  public native JsPromise<SomeType> nullableSomeTypePromiseMethod(@Nonnull JsPromise<SomeType> v1,
      @Nonnull JsPromise<SomeType> v2);

  @JsNonNull
  public native JsPromise<SomeType> nullableSomeTypePromiseMethod(@Nonnull JsPromise<SomeType> v1);

  @JsNullable
  public native JsArray<SomeType> nullableSomeTypeSequenceMethod(@Nullable JsArray<SomeType> v1,
      @Nullable JsArray<SomeType> v2);

  @JsNullable
  public native JsArray<SomeType> nullableSomeTypeSequenceMethod(@Nullable SomeType[] v1,
      @Nullable JsArray<SomeType> v2);

  @JsOverlay
  @JsNullable
  public final JsArray<SomeType> nullableSomeTypeSequenceMethod(
      @Nullable final JsArray<SomeType> v1, @Nullable final SomeType... v2) {
    return _nullableSomeTypeSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableSomeTypeSequenceMethod"
  )
  @JsNullable
  private native JsArray<SomeType> _nullableSomeTypeSequenceMethod(@Nullable JsArray<SomeType> v1,
      @Nullable SomeType[] v2);

  @JsOverlay
  @JsNullable
  public final JsArray<SomeType> nullableSomeTypeSequenceMethod(@Nullable final SomeType[] v1,
      @Nullable final SomeType... v2) {
    return _nullableSomeTypeSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableSomeTypeSequenceMethod"
  )
  @JsNullable
  private native JsArray<SomeType> _nullableSomeTypeSequenceMethod(@Nullable SomeType[] v1,
      @Nullable SomeType[] v2);

  @JsNullable
  public native JsArray<SomeType> nullableSomeTypeSequenceMethod(@Nullable JsArray<SomeType> v1);

  @JsOverlay
  @JsNullable
  public final JsArray<SomeType> nullableSomeTypeSequenceMethod(@Nullable final SomeType... v1) {
    return _nullableSomeTypeSequenceMethod( v1 );
  }

  @JsMethod(
      name = "nullableSomeTypeSequenceMethod"
  )
  @JsNullable
  private native JsArray<SomeType> _nullableSomeTypeSequenceMethod(@Nullable SomeType[] v1);

  @JsNullable
  public native String nullableUSVStringMethod(@Nullable String v1, @Nullable String v2);

  @JsNullable
  public native String nullableUSVStringMethod(@Nullable String v1);

  @JsNullable
  public native Double nullableUnrestrictedDoubleMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableUnrestrictedDoubleMethod(@Nullable Double v1);

  @JsNullable
  public native Double nullableUnrestrictedFloatMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableUnrestrictedFloatMethod(@Nullable Double v1);

  @JsNullable
  public native Double nullableUnsignedLongLongMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableUnsignedLongLongMethod(@Nullable Double v1);

  @JsNullable
  public native Double nullableUnsignedLongMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableUnsignedLongMethod(@Nullable Double v1);

  @JsNullable
  public native Double nullableUnsignedShortMethod(@Nullable Double v1, @Nullable Double v2);

  @JsNullable
  public native Double nullableUnsignedShortMethod(@Nullable Double v1);

  @JsNonNull
  public native JsObject objectMethod(@Nonnull JsObject v1, @Nonnull JsObject v2);

  @JsNonNull
  public native JsObject objectMethod(@Nonnull JsObject v1);

  public native short octetMethod(short v1, short v2);

  public native short octetMethod(short v1);

  @JsNonNull
  public native JsArray<Double> shortFrozenArrayMethod(@Nonnull JsArray<Double> v1,
      @Nonnull JsArray<Double> v2);

  @JsNonNull
  public native JsArray<Double> shortFrozenArrayMethod(@Nonnull JsArray<Double> v1);

  public native short shortMethod(short v1, short v2);

  public native short shortMethod(short v1);

  @JsNonNull
  public native JsPromise<Double> shortPromiseMethod(@Nonnull JsPromise<Double> v1,
      @Nonnull JsPromise<Double> v2);

  @JsNonNull
  public native JsPromise<Double> shortPromiseMethod(@Nonnull JsPromise<Double> v1);

  @JsNonNull
  public native JsArray<Double> shortSequenceMethod(@Nonnull JsArray<Double> v1,
      @Nonnull JsArray<Double> v2);

  @JsNonNull
  public native JsArray<Double> shortSequenceMethod(@Nonnull double[] v1,
      @Nonnull JsArray<Double> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> shortSequenceMethod(@Nonnull final JsArray<Double> v1,
      @Nonnull final double... v2) {
    return _shortSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "shortSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _shortSequenceMethod(@Nonnull JsArray<Double> v1,
      @Nonnull double[] v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> shortSequenceMethod(@Nonnull final double[] v1,
      @Nonnull final double... v2) {
    return _shortSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "shortSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _shortSequenceMethod(@Nonnull double[] v1, @Nonnull double[] v2);

  @JsNonNull
  public native JsArray<Double> shortSequenceMethod(@Nonnull JsArray<Double> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> shortSequenceMethod(@Nonnull final double... v1) {
    return _shortSequenceMethod( v1 );
  }

  @JsMethod(
      name = "shortSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _shortSequenceMethod(@Nonnull double[] v1);

  @JsNonNull
  public native JsArray<SomeType> someTypeFrozenArrayMethod(@Nonnull JsArray<SomeType> v1,
      @Nonnull JsArray<SomeType> v2);

  @JsNonNull
  public native JsArray<SomeType> someTypeFrozenArrayMethod(@Nonnull JsArray<SomeType> v1);

  @JsNonNull
  public native SomeType someTypeMethod(@Nonnull SomeType v1, @Nonnull SomeType v2);

  @JsNonNull
  public native SomeType someTypeMethod(@Nonnull SomeType v1);

  @JsNonNull
  public native JsPromise<SomeType> someTypePromiseMethod(@Nonnull JsPromise<SomeType> v1,
      @Nonnull JsPromise<SomeType> v2);

  @JsNonNull
  public native JsPromise<SomeType> someTypePromiseMethod(@Nonnull JsPromise<SomeType> v1);

  @JsNonNull
  public native JsArray<SomeType> someTypeSequenceMethod(@Nonnull JsArray<SomeType> v1,
      @Nonnull JsArray<SomeType> v2);

  @JsNonNull
  public native JsArray<SomeType> someTypeSequenceMethod(@Nonnull SomeType[] v1,
      @Nonnull JsArray<SomeType> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<SomeType> someTypeSequenceMethod(@Nonnull final JsArray<SomeType> v1,
      @Nonnull final SomeType... v2) {
    return _someTypeSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "someTypeSequenceMethod"
  )
  @JsNonNull
  private native JsArray<SomeType> _someTypeSequenceMethod(@Nonnull JsArray<SomeType> v1,
      @Nonnull SomeType[] v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<SomeType> someTypeSequenceMethod(@Nonnull final SomeType[] v1,
      @Nonnull final SomeType... v2) {
    return _someTypeSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "someTypeSequenceMethod"
  )
  @JsNonNull
  private native JsArray<SomeType> _someTypeSequenceMethod(@Nonnull SomeType[] v1,
      @Nonnull SomeType[] v2);

  @JsNonNull
  public native JsArray<SomeType> someTypeSequenceMethod(@Nonnull JsArray<SomeType> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<SomeType> someTypeSequenceMethod(@Nonnull final SomeType... v1) {
    return _someTypeSequenceMethod( v1 );
  }

  @JsMethod(
      name = "someTypeSequenceMethod"
  )
  @JsNonNull
  private native JsArray<SomeType> _someTypeSequenceMethod(@Nonnull SomeType[] v1);

  @JsNonNull
  public native JsPropertyMap<SomeType> typeReferenceRecordMethod(
      @Nonnull JsPropertyMap<SomeType> v1, @Nonnull JsPropertyMap<SomeType> v2);

  @JsNonNull
  public native JsPropertyMap<SomeType> typeReferenceRecordMethod(
      @Nonnull JsPropertyMap<SomeType> v1);

  public native double unrestrictedDoubleMethod(double v1, double v2);

  public native double unrestrictedDoubleMethod(double v1);

  public native float unrestrictedFloatMethod(float v1, float v2);

  public native float unrestrictedFloatMethod(float v1);

  public native int unsignedLongLongMethod(int v1, int v2);

  public native int unsignedLongLongMethod(int v1);

  public native int unsignedLongMethod(int v1, int v2);

  public native int unsignedLongMethod(int v1);

  public native int unsignedShortMethod(int v1, int v2);

  public native int unsignedShortMethod(int v1);

  @JsNonNull
  public native String usvStringMethod(@Nonnull String v1, @Nonnull String v2);

  @JsNonNull
  public native String usvStringMethod(@Nonnull String v1);

  @JsNonNull
  public native JsPropertyMap<String> usvStringRecordMethod(@Nonnull JsPropertyMap<String> v1,
      @Nonnull JsPropertyMap<String> v2);

  @JsNonNull
  public native JsPropertyMap<String> usvStringRecordMethod(@Nonnull JsPropertyMap<String> v1);

  @JsNonNull
  public native JsPromise<Void> voidPromiseMethod(@Nonnull JsPromise<Void> v1,
      @Nonnull JsPromise<Void> v2);

  @JsNonNull
  public native JsPromise<Void> voidPromiseMethod(@Nonnull JsPromise<Void> v1);
}
