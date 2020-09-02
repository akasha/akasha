package com.example;

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
public interface Dictionary_requiredAnyValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredAnyValue create(@Nullable final Any requiredAnyValue) {
    return Js.<Dictionary_requiredAnyValue>uncheckedCast( JsPropertyMap.of() ).requiredAnyValue( requiredAnyValue );
  }

  @JsOverlay
  @Nonnull
  static Dictionary_requiredAnyValue create(@DoNotAutobox @Nullable final Object requiredAnyValue) {
    return Js.<Dictionary_requiredAnyValue>uncheckedCast( JsPropertyMap.of() ).requiredAnyValue( requiredAnyValue );
  }

  @JsProperty(
      name = "requiredAnyValue"
  )
  @Nullable
  Any requiredAnyValue();

  @JsProperty
  void setRequiredAnyValue(@Nullable Any requiredAnyValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredAnyValue requiredAnyValue(@Nullable final Any requiredAnyValue) {
    setRequiredAnyValue( requiredAnyValue );
    return this;
  }

  @JsOverlay
  default void setRequiredAnyValue(@DoNotAutobox @Nullable final Object requiredAnyValue) {
    setRequiredAnyValue( Js.asAny( requiredAnyValue ) );
  }

  @JsOverlay
  @Nonnull
  default Dictionary_requiredAnyValue requiredAnyValue(
      @DoNotAutobox @Nullable final Object requiredAnyValue) {
    setRequiredAnyValue( requiredAnyValue );
    return this;
  }
}
