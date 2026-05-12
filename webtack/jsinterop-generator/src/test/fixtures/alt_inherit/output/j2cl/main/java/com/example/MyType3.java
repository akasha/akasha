package com.example;

import com.other.JsArray;
import com.other.JsIterable;
import com.other.JsIterator;
import com.other.JsIteratorIterable;
import com.other.JsPromise;
import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.processing.Generated;
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
  public native JsIterable<Any> anyIterableMethod(@JsNonNull JsIterable<Any> v1,
      @JsNonNull JsIterable<Any> v2);

  @JsNonNull
  public native JsIterable<Any> anyIterableMethod(@JsNonNull JsIterable<Any> v1);

  @JsNonNull
  public native JsIteratorIterable<Any> anyIteratorIterableMethod(
      @JsNonNull JsIteratorIterable<Any> v1, @JsNonNull JsIteratorIterable<Any> v2);

  @JsNonNull
  public native JsIteratorIterable<Any> anyIteratorIterableMethod(
      @JsNonNull JsIteratorIterable<Any> v1);

  @JsNonNull
  public native JsIterator<Any> anyIteratorMethod(@JsNonNull JsIterator<Any> v1,
      @JsNonNull JsIterator<Any> v2);

  @JsNonNull
  public native JsIterator<Any> anyIteratorMethod(@JsNonNull JsIterator<Any> v1);

  @JsNullable
  public native Any anyMethod(@DoNotAutobox @JsNullable Object v1,
      @DoNotAutobox @JsNullable Object v2);

  @JsNullable
  public native Any anyMethod(@DoNotAutobox @JsNullable Object v1);

  @JsNonNull
  public native JsArray<Any> anySequenceMethod(@JsNonNull JsArray<Any> v1,
      @JsNonNull JsArray<Any> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Any> anySequenceMethod(final Any @JsNonNull [] v1,
      final Any @JsNonNull ... v2) {
    return _anySequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "anySequenceMethod"
  )
  @JsNonNull
  private native JsArray<Any> _anySequenceMethod(Any @JsNonNull [] v1, Any @JsNonNull [] v2);

  @JsNonNull
  public native JsArray<Any> anySequenceMethod(@JsNonNull JsArray<Any> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<Any> anySequenceMethod(final Any @JsNonNull ... v1) {
    return _anySequenceMethod( v1 );
  }

  @JsMethod(
      name = "anySequenceMethod"
  )
  @JsNonNull
  private native JsArray<Any> _anySequenceMethod(Any @JsNonNull [] v1);

  @JsNonNull
  public native JsArray<Boolean> booleanFrozenArrayMethod(@JsNonNull JsArray<Boolean> v1,
      @JsNonNull JsArray<Boolean> v2);

  @JsNonNull
  public native JsArray<Boolean> booleanFrozenArrayMethod(@JsNonNull JsArray<Boolean> v1);

  public native boolean booleanMethod(boolean v1, boolean v2);

  public native boolean booleanMethod(boolean v1);

  @JsNonNull
  public native JsArray<Boolean> booleanSequenceMethod(@JsNonNull JsArray<Boolean> v1,
      @JsNonNull JsArray<Boolean> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Boolean> booleanSequenceMethod(final Boolean @JsNonNull [] v1,
      final Boolean @JsNonNull ... v2) {
    return _booleanSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "booleanSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Boolean> _booleanSequenceMethod(Boolean @JsNonNull [] v1,
      Boolean @JsNonNull [] v2);

  @JsNonNull
  public native JsArray<Boolean> booleanSequenceMethod(@JsNonNull JsArray<Boolean> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<Boolean> booleanSequenceMethod(final Boolean @JsNonNull ... v1) {
    return _booleanSequenceMethod( v1 );
  }

  @JsMethod(
      name = "booleanSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Boolean> _booleanSequenceMethod(Boolean @JsNonNull [] v1);

  public native byte byteMethod(byte v1, byte v2);

  public native byte byteMethod(byte v1);

  @JsNonNull
  public native String byteStringMethod(@JsNonNull String v1, @JsNonNull String v2);

  @JsNonNull
  public native String byteStringMethod(@JsNonNull String v1);

  @JsNonNull
  public native JsPropertyMap<String> byteStringRecordMethod(@JsNonNull JsPropertyMap<String> v1,
      @JsNonNull JsPropertyMap<String> v2);

  @JsNonNull
  public native JsPropertyMap<String> byteStringRecordMethod(@JsNonNull JsPropertyMap<String> v1);

  @JsNonNull
  public native String domStringMethod(@JsNonNull String v1, @JsNonNull String v2);

  @JsNonNull
  public native String domStringMethod(@JsNonNull String v1);

  @JsNonNull
  public native JsPropertyMap<String> domStringRecordMethod(@JsNonNull JsPropertyMap<String> v1,
      @JsNonNull JsPropertyMap<String> v2);

  @JsNonNull
  public native JsPropertyMap<String> domStringRecordMethod(@JsNonNull JsPropertyMap<String> v1);

  @JsNonNull
  public native JsArray<Double> doubleFrozenArrayMethod(@JsNonNull JsArray<Double> v1,
      @JsNonNull JsArray<Double> v2);

  @JsNonNull
  public native JsArray<Double> doubleFrozenArrayMethod(@JsNonNull JsArray<Double> v1);

  public native double doubleMethod(double v1, double v2);

  public native double doubleMethod(double v1);

  @JsNonNull
  public native JsPropertyMap<Double> doubleRecordMethod(@JsNonNull JsPropertyMap<Double> v1,
      @JsNonNull JsPropertyMap<Double> v2);

  @JsNonNull
  public native JsPropertyMap<Double> doubleRecordMethod(@JsNonNull JsPropertyMap<Double> v1);

  @JsNonNull
  public native JsArray<Double> doubleSequenceMethod(@JsNonNull JsArray<Double> v1,
      @JsNonNull JsArray<Double> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> doubleSequenceMethod(final double @JsNonNull [] v1,
      final double @JsNonNull ... v2) {
    return _doubleSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "doubleSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _doubleSequenceMethod(double @JsNonNull [] v1,
      double @JsNonNull [] v2);

  @JsNonNull
  public native JsArray<Double> doubleSequenceMethod(@JsNonNull JsArray<Double> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> doubleSequenceMethod(final double @JsNonNull ... v1) {
    return _doubleSequenceMethod( v1 );
  }

  @JsMethod(
      name = "doubleSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _doubleSequenceMethod(double @JsNonNull [] v1);

  @JsNonNull
  public native JsArray<Double> floatFrozenArrayMethod(@JsNonNull JsArray<Double> v1,
      @JsNonNull JsArray<Double> v2);

  @JsNonNull
  public native JsArray<Double> floatFrozenArrayMethod(@JsNonNull JsArray<Double> v1);

  public native float floatMethod(float v1, float v2);

  public native float floatMethod(float v1);

  @JsNonNull
  public native JsArray<Double> floatSequenceMethod(@JsNonNull JsArray<Double> v1,
      @JsNonNull JsArray<Double> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> floatSequenceMethod(final double @JsNonNull [] v1,
      final double @JsNonNull ... v2) {
    return _floatSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "floatSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _floatSequenceMethod(double @JsNonNull [] v1,
      double @JsNonNull [] v2);

  @JsNonNull
  public native JsArray<Double> floatSequenceMethod(@JsNonNull JsArray<Double> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> floatSequenceMethod(final double @JsNonNull ... v1) {
    return _floatSequenceMethod( v1 );
  }

  @JsMethod(
      name = "floatSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _floatSequenceMethod(double @JsNonNull [] v1);

  public native int longLongMethod(int v1, int v2);

  public native int longLongMethod(int v1);

  @JsNonNull
  public native JsPromise<JsArray<Double>> longLongPromiseMethod(
      @JsNonNull JsPromise<JsArray<Double>> v1, @JsNonNull JsPromise<JsArray<Double>> v2);

  @JsNonNull
  public native JsPromise<JsArray<Double>> longLongPromiseMethod(
      @JsNonNull JsPromise<JsArray<Double>> v1);

  public native int longMethod(int v1, int v2);

  public native int longMethod(int v1);

  @JsNonNull
  public native JsPropertyMap<String> mixedStringRecordMethod(@JsNonNull JsPropertyMap<String> v1,
      @JsNonNull JsPropertyMap<String> v2);

  @JsNonNull
  public native JsPropertyMap<String> mixedStringRecordMethod(@JsNonNull JsPropertyMap<String> v1);

  @JsNullable
  public native JsArray<Boolean> nullableBooleanFrozenArrayMethod(@JsNullable JsArray<Boolean> v1,
      @JsNullable JsArray<Boolean> v2);

  @JsNullable
  public native JsArray<Boolean> nullableBooleanFrozenArrayMethod(@JsNullable JsArray<Boolean> v1);

  @JsNullable
  public native Boolean nullableBooleanMethod(@JsNullable Boolean v1, @JsNullable Boolean v2);

  @JsNullable
  public native Boolean nullableBooleanMethod(@JsNullable Boolean v1);

  @JsNullable
  public native JsArray<Boolean> nullableBooleanSequenceMethod(@JsNullable JsArray<Boolean> v1,
      @JsNullable JsArray<Boolean> v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Boolean> nullableBooleanSequenceMethod(final Boolean @JsNullable [] v1,
      final Boolean @JsNullable ... v2) {
    return _nullableBooleanSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableBooleanSequenceMethod"
  )
  @JsNullable
  private native JsArray<Boolean> _nullableBooleanSequenceMethod(Boolean @JsNullable [] v1,
      Boolean @JsNullable [] v2);

  @JsNullable
  public native JsArray<Boolean> nullableBooleanSequenceMethod(@JsNullable JsArray<Boolean> v1);

  @JsOverlay
  @JsNullable
  public final JsArray<Boolean> nullableBooleanSequenceMethod(final Boolean @JsNullable ... v1) {
    return _nullableBooleanSequenceMethod( v1 );
  }

  @JsMethod(
      name = "nullableBooleanSequenceMethod"
  )
  @JsNullable
  private native JsArray<Boolean> _nullableBooleanSequenceMethod(Boolean @JsNullable [] v1);

  @JsNullable
  public native Double nullableByteMethod(@JsNullable Double v1, @JsNullable Double v2);

  @JsNullable
  public native Double nullableByteMethod(@JsNullable Double v1);

  @JsNullable
  public native String nullableByteStringMethod(@JsNullable String v1, @JsNullable String v2);

  @JsNullable
  public native String nullableByteStringMethod(@JsNullable String v1);

  @JsNullable
  public native String nullableDOMStringMethod(@JsNullable String v1, @JsNullable String v2);

  @JsNullable
  public native String nullableDOMStringMethod(@JsNullable String v1);

  @JsNullable
  public native JsArray<Double> nullableDoubleFrozenArrayMethod(@JsNullable JsArray<Double> v1,
      @JsNullable JsArray<Double> v2);

  @JsNullable
  public native JsArray<Double> nullableDoubleFrozenArrayMethod(@JsNullable JsArray<Double> v1);

  @JsNullable
  public native Double nullableDoubleMethod(@JsNullable Double v1, @JsNullable Double v2);

  @JsNullable
  public native Double nullableDoubleMethod(@JsNullable Double v1);

  @JsNullable
  public native JsArray<Double> nullableDoubleSequenceMethod(@JsNullable JsArray<Double> v1,
      @JsNullable JsArray<Double> v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableDoubleSequenceMethod(final double @JsNullable [] v1,
      final double @JsNullable ... v2) {
    return _nullableDoubleSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableDoubleSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableDoubleSequenceMethod(double @JsNullable [] v1,
      double @JsNullable [] v2);

  @JsNullable
  public native JsArray<Double> nullableDoubleSequenceMethod(@JsNullable JsArray<Double> v1);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableDoubleSequenceMethod(final double @JsNullable ... v1) {
    return _nullableDoubleSequenceMethod( v1 );
  }

  @JsMethod(
      name = "nullableDoubleSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableDoubleSequenceMethod(double @JsNullable [] v1);

  @JsNullable
  public native JsArray<Double> nullableFloatFrozenArrayMethod(@JsNullable JsArray<Double> v1,
      @JsNullable JsArray<Double> v2);

  @JsNullable
  public native JsArray<Double> nullableFloatFrozenArrayMethod(@JsNullable JsArray<Double> v1);

  @JsNullable
  public native Double nullableFloatMethod(@JsNullable Double v1, @JsNullable Double v2);

  @JsNullable
  public native Double nullableFloatMethod(@JsNullable Double v1);

  @JsNullable
  public native JsArray<Double> nullableFloatSequenceMethod(@JsNullable JsArray<Double> v1,
      @JsNullable JsArray<Double> v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableFloatSequenceMethod(final double @JsNullable [] v1,
      final double @JsNullable ... v2) {
    return _nullableFloatSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableFloatSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableFloatSequenceMethod(double @JsNullable [] v1,
      double @JsNullable [] v2);

  @JsNullable
  public native JsArray<Double> nullableFloatSequenceMethod(@JsNullable JsArray<Double> v1);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableFloatSequenceMethod(final double @JsNullable ... v1) {
    return _nullableFloatSequenceMethod( v1 );
  }

  @JsMethod(
      name = "nullableFloatSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableFloatSequenceMethod(double @JsNullable [] v1);

  @JsNullable
  public native Double nullableLongLongMethod(@JsNullable Double v1, @JsNullable Double v2);

  @JsNullable
  public native Double nullableLongLongMethod(@JsNullable Double v1);

  @JsNullable
  public native Double nullableLongMethod(@JsNullable Double v1, @JsNullable Double v2);

  @JsNullable
  public native Double nullableLongMethod(@JsNullable Double v1);

  @JsNullable
  public native JsObject nullableObjectMethod(@JsNullable JsObject v1, @JsNullable JsObject v2);

  @JsNullable
  public native JsObject nullableObjectMethod(@JsNullable JsObject v1);

  @JsNullable
  public native Double nullableOctetMethod(@JsNullable Double v1, @JsNullable Double v2);

  @JsNullable
  public native Double nullableOctetMethod(@JsNullable Double v1);

  @JsNullable
  public native JsArray<Double> nullableShortFrozenArrayMethod(@JsNullable JsArray<Double> v1,
      @JsNullable JsArray<Double> v2);

  @JsNullable
  public native JsArray<Double> nullableShortFrozenArrayMethod(@JsNullable JsArray<Double> v1);

  @JsNullable
  public native Double nullableShortMethod(@JsNullable Double v1, @JsNullable Double v2);

  @JsNullable
  public native Double nullableShortMethod(@JsNullable Double v1);

  @JsNonNull
  public native JsPromise<Double> nullableShortPromiseMethod(@JsNonNull JsPromise<Double> v1,
      @JsNonNull JsPromise<Double> v2);

  @JsNonNull
  public native JsPromise<Double> nullableShortPromiseMethod(@JsNonNull JsPromise<Double> v1);

  @JsNullable
  public native JsArray<Double> nullableShortSequenceMethod(@JsNullable JsArray<Double> v1,
      @JsNullable JsArray<Double> v2);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableShortSequenceMethod(final double @JsNullable [] v1,
      final double @JsNullable ... v2) {
    return _nullableShortSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableShortSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableShortSequenceMethod(double @JsNullable [] v1,
      double @JsNullable [] v2);

  @JsNullable
  public native JsArray<Double> nullableShortSequenceMethod(@JsNullable JsArray<Double> v1);

  @JsOverlay
  @JsNullable
  public final JsArray<Double> nullableShortSequenceMethod(final double @JsNullable ... v1) {
    return _nullableShortSequenceMethod( v1 );
  }

  @JsMethod(
      name = "nullableShortSequenceMethod"
  )
  @JsNullable
  private native JsArray<Double> _nullableShortSequenceMethod(double @JsNullable [] v1);

  @JsNullable
  public native JsArray<SomeType> nullableSomeTypeFrozenArrayMethod(
      @JsNullable JsArray<SomeType> v1, @JsNullable JsArray<SomeType> v2);

  @JsNullable
  public native JsArray<SomeType> nullableSomeTypeFrozenArrayMethod(
      @JsNullable JsArray<SomeType> v1);

  @JsNullable
  public native SomeType nullableSomeTypeMethod(@JsNullable SomeType v1, @JsNullable SomeType v2);

  @JsNullable
  public native SomeType nullableSomeTypeMethod(@JsNullable SomeType v1);

  @JsNonNull
  public native JsPromise<SomeType> nullableSomeTypePromiseMethod(@JsNonNull JsPromise<SomeType> v1,
      @JsNonNull JsPromise<SomeType> v2);

  @JsNonNull
  public native JsPromise<SomeType> nullableSomeTypePromiseMethod(
      @JsNonNull JsPromise<SomeType> v1);

  @JsNullable
  public native JsArray<SomeType> nullableSomeTypeSequenceMethod(@JsNullable JsArray<SomeType> v1,
      @JsNullable JsArray<SomeType> v2);

  @JsOverlay
  @JsNullable
  public final JsArray<SomeType> nullableSomeTypeSequenceMethod(final SomeType @JsNullable [] v1,
      final SomeType @JsNullable ... v2) {
    return _nullableSomeTypeSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "nullableSomeTypeSequenceMethod"
  )
  @JsNullable
  private native JsArray<SomeType> _nullableSomeTypeSequenceMethod(SomeType @JsNullable [] v1,
      SomeType @JsNullable [] v2);

  @JsNullable
  public native JsArray<SomeType> nullableSomeTypeSequenceMethod(@JsNullable JsArray<SomeType> v1);

  @JsOverlay
  @JsNullable
  public final JsArray<SomeType> nullableSomeTypeSequenceMethod(final SomeType @JsNullable ... v1) {
    return _nullableSomeTypeSequenceMethod( v1 );
  }

  @JsMethod(
      name = "nullableSomeTypeSequenceMethod"
  )
  @JsNullable
  private native JsArray<SomeType> _nullableSomeTypeSequenceMethod(SomeType @JsNullable [] v1);

  @JsNullable
  public native String nullableUSVStringMethod(@JsNullable String v1, @JsNullable String v2);

  @JsNullable
  public native String nullableUSVStringMethod(@JsNullable String v1);

  @JsNullable
  public native Double nullableUnrestrictedDoubleMethod(@JsNullable Double v1,
      @JsNullable Double v2);

  @JsNullable
  public native Double nullableUnrestrictedDoubleMethod(@JsNullable Double v1);

  @JsNullable
  public native Double nullableUnrestrictedFloatMethod(@JsNullable Double v1,
      @JsNullable Double v2);

  @JsNullable
  public native Double nullableUnrestrictedFloatMethod(@JsNullable Double v1);

  @JsNullable
  public native Double nullableUnsignedLongLongMethod(@JsNullable Double v1, @JsNullable Double v2);

  @JsNullable
  public native Double nullableUnsignedLongLongMethod(@JsNullable Double v1);

  @JsNullable
  public native Double nullableUnsignedLongMethod(@JsNullable Double v1, @JsNullable Double v2);

  @JsNullable
  public native Double nullableUnsignedLongMethod(@JsNullable Double v1);

  @JsNullable
  public native Double nullableUnsignedShortMethod(@JsNullable Double v1, @JsNullable Double v2);

  @JsNullable
  public native Double nullableUnsignedShortMethod(@JsNullable Double v1);

  @JsNonNull
  public native JsObject objectMethod(@JsNonNull JsObject v1, @JsNonNull JsObject v2);

  @JsNonNull
  public native JsObject objectMethod(@JsNonNull JsObject v1);

  public native short octetMethod(short v1, short v2);

  public native short octetMethod(short v1);

  @JsNonNull
  public native JsArray<Double> shortFrozenArrayMethod(@JsNonNull JsArray<Double> v1,
      @JsNonNull JsArray<Double> v2);

  @JsNonNull
  public native JsArray<Double> shortFrozenArrayMethod(@JsNonNull JsArray<Double> v1);

  public native short shortMethod(short v1, short v2);

  public native short shortMethod(short v1);

  @JsNonNull
  public native JsPromise<Double> shortPromiseMethod(@JsNonNull JsPromise<Double> v1,
      @JsNonNull JsPromise<Double> v2);

  @JsNonNull
  public native JsPromise<Double> shortPromiseMethod(@JsNonNull JsPromise<Double> v1);

  @JsNonNull
  public native JsArray<Double> shortSequenceMethod(@JsNonNull JsArray<Double> v1,
      @JsNonNull JsArray<Double> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> shortSequenceMethod(final double @JsNonNull [] v1,
      final double @JsNonNull ... v2) {
    return _shortSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "shortSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _shortSequenceMethod(double @JsNonNull [] v1,
      double @JsNonNull [] v2);

  @JsNonNull
  public native JsArray<Double> shortSequenceMethod(@JsNonNull JsArray<Double> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<Double> shortSequenceMethod(final double @JsNonNull ... v1) {
    return _shortSequenceMethod( v1 );
  }

  @JsMethod(
      name = "shortSequenceMethod"
  )
  @JsNonNull
  private native JsArray<Double> _shortSequenceMethod(double @JsNonNull [] v1);

  @JsNonNull
  public native JsArray<SomeType> someTypeFrozenArrayMethod(@JsNonNull JsArray<SomeType> v1,
      @JsNonNull JsArray<SomeType> v2);

  @JsNonNull
  public native JsArray<SomeType> someTypeFrozenArrayMethod(@JsNonNull JsArray<SomeType> v1);

  @JsNonNull
  public native SomeType someTypeMethod(@JsNonNull SomeType v1, @JsNonNull SomeType v2);

  @JsNonNull
  public native SomeType someTypeMethod(@JsNonNull SomeType v1);

  @JsNonNull
  public native JsPromise<SomeType> someTypePromiseMethod(@JsNonNull JsPromise<SomeType> v1,
      @JsNonNull JsPromise<SomeType> v2);

  @JsNonNull
  public native JsPromise<SomeType> someTypePromiseMethod(@JsNonNull JsPromise<SomeType> v1);

  @JsNonNull
  public native JsArray<SomeType> someTypeSequenceMethod(@JsNonNull JsArray<SomeType> v1,
      @JsNonNull JsArray<SomeType> v2);

  @JsOverlay
  @JsNonNull
  public final JsArray<SomeType> someTypeSequenceMethod(final SomeType @JsNonNull [] v1,
      final SomeType @JsNonNull ... v2) {
    return _someTypeSequenceMethod( v1, v2 );
  }

  @JsMethod(
      name = "someTypeSequenceMethod"
  )
  @JsNonNull
  private native JsArray<SomeType> _someTypeSequenceMethod(SomeType @JsNonNull [] v1,
      SomeType @JsNonNull [] v2);

  @JsNonNull
  public native JsArray<SomeType> someTypeSequenceMethod(@JsNonNull JsArray<SomeType> v1);

  @JsOverlay
  @JsNonNull
  public final JsArray<SomeType> someTypeSequenceMethod(final SomeType @JsNonNull ... v1) {
    return _someTypeSequenceMethod( v1 );
  }

  @JsMethod(
      name = "someTypeSequenceMethod"
  )
  @JsNonNull
  private native JsArray<SomeType> _someTypeSequenceMethod(SomeType @JsNonNull [] v1);

  @JsNonNull
  public native JsPropertyMap<SomeType> typeReferenceRecordMethod(
      @JsNonNull JsPropertyMap<SomeType> v1, @JsNonNull JsPropertyMap<SomeType> v2);

  @JsNonNull
  public native JsPropertyMap<SomeType> typeReferenceRecordMethod(
      @JsNonNull JsPropertyMap<SomeType> v1);

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
  public native String usvStringMethod(@JsNonNull String v1, @JsNonNull String v2);

  @JsNonNull
  public native String usvStringMethod(@JsNonNull String v1);

  @JsNonNull
  public native JsPropertyMap<String> usvStringRecordMethod(@JsNonNull JsPropertyMap<String> v1,
      @JsNonNull JsPropertyMap<String> v2);

  @JsNonNull
  public native JsPropertyMap<String> usvStringRecordMethod(@JsNonNull JsPropertyMap<String> v1);

  @JsNonNull
  public native JsPromise<Void> voidPromiseMethod(@JsNonNull JsPromise<Void> v1,
      @JsNonNull JsPromise<Void> v2);

  @JsNonNull
  public native JsPromise<Void> voidPromiseMethod(@JsNonNull JsPromise<Void> v1);
}
