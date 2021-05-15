package com.example;

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
    name = "Dictionary_requiredAnySequenceValue"
)
public interface Dictionary_requiredAnySequenceValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsIterable<Any> requiredAnyIterableValue,
      @Nonnull final JsIteratorIterable<Any> requiredAnyIteratorIterableValue,
      @Nonnull final JsIterator<Any> requiredAnyIteratorValue,
      @Nonnull final JsArray<Any> requiredAnySequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredAnyIterableValue( requiredAnyIterableValue ).requiredAnyIteratorIterableValue( requiredAnyIteratorIterableValue ).requiredAnyIteratorValue( requiredAnyIteratorValue ).requiredAnySequenceValue( requiredAnySequenceValue );
  }

  @JsOverlay
  @Nonnull
  static Builder create(@Nonnull final JsIterable<Any> requiredAnyIterableValue,
      @Nonnull final JsIteratorIterable<Any> requiredAnyIteratorIterableValue,
      @Nonnull final JsIterator<Any> requiredAnyIteratorValue,
      @Nonnull final Any[] requiredAnySequenceValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredAnyIterableValue( requiredAnyIterableValue ).requiredAnyIteratorIterableValue( requiredAnyIteratorIterableValue ).requiredAnyIteratorValue( requiredAnyIteratorValue ).requiredAnySequenceValue( requiredAnySequenceValue );
  }

  @JsProperty(
      name = "requiredAnyIterableValue"
  )
  @Nonnull
  JsIterable<Any> requiredAnyIterableValue();

  @JsProperty
  void setRequiredAnyIterableValue(@Nonnull JsIterable<Any> requiredAnyIterableValue);

  @JsProperty(
      name = "requiredAnyIteratorIterableValue"
  )
  @Nonnull
  JsIteratorIterable<Any> requiredAnyIteratorIterableValue();

  @JsProperty
  void setRequiredAnyIteratorIterableValue(
      @Nonnull JsIteratorIterable<Any> requiredAnyIteratorIterableValue);

  @JsProperty(
      name = "requiredAnyIteratorValue"
  )
  @Nonnull
  JsIterator<Any> requiredAnyIteratorValue();

  @JsProperty
  void setRequiredAnyIteratorValue(@Nonnull JsIterator<Any> requiredAnyIteratorValue);

  @JsProperty(
      name = "requiredAnySequenceValue"
  )
  @Nonnull
  JsArray<Any> requiredAnySequenceValue();

  @JsProperty
  void setRequiredAnySequenceValue(@Nonnull JsArray<Any> requiredAnySequenceValue);

  @JsOverlay
  default void setRequiredAnySequenceValue(@Nonnull final Any... requiredAnySequenceValue) {
    setRequiredAnySequenceValue( Js.<JsArray<Any>>uncheckedCast( requiredAnySequenceValue ) );
  }

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredAnySequenceValue"
  )
  interface Builder extends Dictionary_requiredAnySequenceValue {
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
  }
}
