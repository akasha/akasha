package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
    name = "Dictionary_requiredAnyValue"
)
public interface Dictionary_requiredAnyValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredAnyValue requiredAnyValue(
      @DoNotAutobox @Nullable final Object requiredAnyValue) {
    final Dictionary_requiredAnyValue $dictionaryRequiredAnyValue = Js.<Dictionary_requiredAnyValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredAnyValue.setRequiredAnyValue( requiredAnyValue );
    return Js.uncheckedCast( $dictionaryRequiredAnyValue );
  }

  @JsProperty(
      name = "requiredAnyValue"
  )
  @JsNullable
  Any requiredAnyValue();

  @JsProperty
  void setRequiredAnyValue(@DoNotAutobox @JsNullable Object requiredAnyValue);
}
