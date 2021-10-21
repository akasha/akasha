package com.example;

import com.other.JsArray;
import com.other.JsIterable;
import com.other.JsIterator;
import com.other.JsIteratorIterable;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
  static Step1 requiredAnyIterableValue(@Nonnull final JsIterable<Any> requiredAnyIterableValue) {
    final Dictionary_requiredAnySequenceValue $dictionaryRequiredAnySequenceValue = Js.<Dictionary_requiredAnySequenceValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredAnySequenceValue.setRequiredAnyIterableValue( requiredAnyIterableValue );
    return Js.uncheckedCast( $dictionaryRequiredAnySequenceValue );
  }

  @JsProperty(
      name = "requiredAnyIterableValue"
  )
  @JsNonNull
  JsIterable<Any> requiredAnyIterableValue();

  @JsProperty
  void setRequiredAnyIterableValue(@JsNonNull JsIterable<Any> requiredAnyIterableValue);

  @JsProperty(
      name = "requiredAnyIteratorIterableValue"
  )
  @JsNonNull
  JsIteratorIterable<Any> requiredAnyIteratorIterableValue();

  @JsProperty
  void setRequiredAnyIteratorIterableValue(
      @JsNonNull JsIteratorIterable<Any> requiredAnyIteratorIterableValue);

  @JsProperty(
      name = "requiredAnyIteratorValue"
  )
  @JsNonNull
  JsIterator<Any> requiredAnyIteratorValue();

  @JsProperty
  void setRequiredAnyIteratorValue(@JsNonNull JsIterator<Any> requiredAnyIteratorValue);

  @JsProperty(
      name = "requiredAnySequenceValue"
  )
  @JsNonNull
  JsArray<Any> requiredAnySequenceValue();

  @JsProperty
  void setRequiredAnySequenceValue(@JsNonNull JsArray<Any> requiredAnySequenceValue);

  @JsOverlay
  default void setRequiredAnySequenceValue(@Nonnull final Any... requiredAnySequenceValue) {
    setRequiredAnySequenceValue( Js.<JsArray<Any>>uncheckedCast( requiredAnySequenceValue ) );
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredAnySequenceValue"
  )
  interface Step1 {
    @JsOverlay
    @Nonnull
    default Step2 requiredAnyIteratorIterableValue(
        @Nonnull JsIteratorIterable<Any> requiredAnyIteratorIterableValue) {
      Js.<Dictionary_requiredAnySequenceValue>uncheckedCast( this ).setRequiredAnyIteratorIterableValue( requiredAnyIteratorIterableValue );
      return Js.uncheckedCast( this );
    }
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredAnySequenceValue"
  )
  interface Step2 {
    @JsOverlay
    @Nonnull
    default Step3 requiredAnyIteratorValue(@Nonnull JsIterator<Any> requiredAnyIteratorValue) {
      Js.<Dictionary_requiredAnySequenceValue>uncheckedCast( this ).setRequiredAnyIteratorValue( requiredAnyIteratorValue );
      return Js.uncheckedCast( this );
    }
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredAnySequenceValue"
  )
  interface Step3 {
    @JsOverlay
    @Nonnull
    default Dictionary_requiredAnySequenceValue requiredAnySequenceValue(
        @Nonnull JsArray<Any> requiredAnySequenceValue) {
      Js.<Dictionary_requiredAnySequenceValue>uncheckedCast( this ).setRequiredAnySequenceValue( requiredAnySequenceValue );
      return Js.uncheckedCast( this );
    }

    @JsOverlay
    @Nonnull
    default Dictionary_requiredAnySequenceValue requiredAnySequenceValue(
        @Nonnull Any... requiredAnySequenceValue) {
      Js.<Dictionary_requiredAnySequenceValue>uncheckedCast( this ).setRequiredAnySequenceValue( requiredAnySequenceValue );
      return Js.uncheckedCast( this );
    }
  }
}
