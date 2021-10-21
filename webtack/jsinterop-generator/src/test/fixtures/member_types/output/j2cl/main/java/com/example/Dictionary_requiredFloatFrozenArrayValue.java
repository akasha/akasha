package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Dictionary_requiredFloatFrozenArrayValue"
)
public interface Dictionary_requiredFloatFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredFloatFrozenArrayValue requiredFloatFrozenArrayValue(
      @Nonnull final JsArray<Double> requiredFloatFrozenArrayValue) {
    final Dictionary_requiredFloatFrozenArrayValue $dictionaryRequiredFloatFrozenArrayValue = Js.<Dictionary_requiredFloatFrozenArrayValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredFloatFrozenArrayValue.setRequiredFloatFrozenArrayValue( requiredFloatFrozenArrayValue );
    return Js.uncheckedCast( $dictionaryRequiredFloatFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredFloatFrozenArrayValue"
  )
  @JsNonNull
  JsArray<Double> requiredFloatFrozenArrayValue();

  @JsProperty
  void setRequiredFloatFrozenArrayValue(@JsNonNull JsArray<Double> requiredFloatFrozenArrayValue);
}
