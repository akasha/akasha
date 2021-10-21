package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNullable;
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
    name = "Object"
)
public interface Dictionary_requiredNullableFloatFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableFloatFrozenArrayValue requiredNullableFloatFrozenArrayValue(
      @Nullable final JsArray<Double> requiredNullableFloatFrozenArrayValue) {
    final Dictionary_requiredNullableFloatFrozenArrayValue $dictionaryRequiredNullableFloatFrozenArrayValue = Js.<Dictionary_requiredNullableFloatFrozenArrayValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableFloatFrozenArrayValue.setRequiredNullableFloatFrozenArrayValue( requiredNullableFloatFrozenArrayValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableFloatFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableFloatFrozenArrayValue"
  )
  @JsNullable
  JsArray<Double> requiredNullableFloatFrozenArrayValue();

  @JsProperty
  void setRequiredNullableFloatFrozenArrayValue(
      @JsNullable JsArray<Double> requiredNullableFloatFrozenArrayValue);
}
