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
public interface Dictionary_requiredNullableDoubleFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDoubleFrozenArrayValue requiredNullableDoubleFrozenArrayValue(
      @Nullable final JsArray<Double> requiredNullableDoubleFrozenArrayValue) {
    final Dictionary_requiredNullableDoubleFrozenArrayValue $dictionaryRequiredNullableDoubleFrozenArrayValue = Js.<Dictionary_requiredNullableDoubleFrozenArrayValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableDoubleFrozenArrayValue.setRequiredNullableDoubleFrozenArrayValue( requiredNullableDoubleFrozenArrayValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableDoubleFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableDoubleFrozenArrayValue"
  )
  @JsNullable
  JsArray<Double> requiredNullableDoubleFrozenArrayValue();

  @JsProperty
  void setRequiredNullableDoubleFrozenArrayValue(
      @JsNullable JsArray<Double> requiredNullableDoubleFrozenArrayValue);
}
