package com.example;

import com.other.JsArray;
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
public interface Dictionary_requiredNullableShortFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableShortFrozenArrayValue requiredNullableShortFrozenArrayValue(
      @Nullable final JsArray<Double> requiredNullableShortFrozenArrayValue) {
    final Dictionary_requiredNullableShortFrozenArrayValue $dictionaryRequiredNullableShortFrozenArrayValue = Js.<Dictionary_requiredNullableShortFrozenArrayValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableShortFrozenArrayValue.setRequiredNullableShortFrozenArrayValue( requiredNullableShortFrozenArrayValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableShortFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableShortFrozenArrayValue"
  )
  @JsNullable
  JsArray<Double> requiredNullableShortFrozenArrayValue();

  @JsProperty
  void setRequiredNullableShortFrozenArrayValue(
      @JsNullable JsArray<Double> requiredNullableShortFrozenArrayValue);
}
