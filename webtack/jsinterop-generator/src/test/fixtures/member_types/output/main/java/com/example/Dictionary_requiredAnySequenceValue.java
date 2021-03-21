package com.example;

import akasha.lang.JsArray;
import akasha.lang.JsIterable;
import akasha.lang.JsIterator;
import akasha.lang.JsIteratorIterable;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
public interface Dictionary_requiredAnySequenceValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredAnySequenceValue create(
      @Nonnull final JsIterable<Any> requiredAnyIterableValue,
      @Nonnull final JsIteratorIterable<Any> requiredAnyIteratorIterableValue,
      @Nonnull final JsIterator<Any> requiredAnyIteratorValue,
      @Nonnull final JsArray<Any> requiredAnySequenceValue) {
    return Js.<Dictionary_requiredAnySequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredAnyIterableValue( requiredAnyIterableValue ).requiredAnyIteratorIterableValue( requiredAnyIteratorIterableValue ).requiredAnyIteratorValue( requiredAnyIteratorValue ).requiredAnySequenceValue( requiredAnySequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredAnySequenceValue create(
      @Nonnull final JsIterable<Any> requiredAnyIterableValue,
      @Nonnull final JsIteratorIterable<Any> requiredAnyIteratorIterableValue,
      @Nonnull final JsIterator<Any> requiredAnyIteratorValue,
      @Nonnull final Any[] requiredAnySequenceValue) {
    return Js.<Dictionary_requiredAnySequenceValue>uncheckedCast( JsPropertyMap.of() ).requiredAnyIterableValue( requiredAnyIterableValue ).requiredAnyIteratorIterableValue( requiredAnyIteratorIterableValue ).requiredAnyIteratorValue( requiredAnyIteratorValue ).requiredAnySequenceValue( requiredAnySequenceValue );
  }

  @JsProperty(
      name = "requiredAnyIterableValue"
  )
  @Nonnull
  JsIterable<Any> requiredAnyIterableValue();

  @JsProperty
  void setRequiredAnyIterableValue(@Nonnull JsIterable<Any> requiredAnyIterableValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredAnySequenceValue requiredAnyIterableValue(
      @Nonnull final JsIterable<Any> requiredAnyIterableValue) {
    setRequiredAnyIterableValue( requiredAnyIterableValue );
    return this;
  }

  @JsProperty(
      name = "requiredAnyIteratorIterableValue"
  )
  @Nonnull
  JsIteratorIterable<Any> requiredAnyIteratorIterableValue();

  @JsProperty
  void setRequiredAnyIteratorIterableValue(
      @Nonnull JsIteratorIterable<Any> requiredAnyIteratorIterableValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredAnySequenceValue requiredAnyIteratorIterableValue(
      @Nonnull final JsIteratorIterable<Any> requiredAnyIteratorIterableValue) {
    setRequiredAnyIteratorIterableValue( requiredAnyIteratorIterableValue );
    return this;
  }

  @JsProperty(
      name = "requiredAnyIteratorValue"
  )
  @Nonnull
  JsIterator<Any> requiredAnyIteratorValue();

  @JsProperty
  void setRequiredAnyIteratorValue(@Nonnull JsIterator<Any> requiredAnyIteratorValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredAnySequenceValue requiredAnyIteratorValue(
      @Nonnull final JsIterator<Any> requiredAnyIteratorValue) {
    setRequiredAnyIteratorValue( requiredAnyIteratorValue );
    return this;
  }

  @JsProperty(
      name = "requiredAnySequenceValue"
  )
  @Nonnull
  JsArray<Any> requiredAnySequenceValue();

  @JsProperty
  void setRequiredAnySequenceValue(@Nonnull JsArray<Any> requiredAnySequenceValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredAnySequenceValue requiredAnySequenceValue(
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
  default Dictionary_requiredAnySequenceValue requiredAnySequenceValue(
      @Nonnull final Any... requiredAnySequenceValue) {
    setRequiredAnySequenceValue( requiredAnySequenceValue );
    return this;
  }
}
