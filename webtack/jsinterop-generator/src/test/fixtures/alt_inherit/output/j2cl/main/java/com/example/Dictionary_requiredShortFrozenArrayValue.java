package com.example;

import com.other.JsArray;
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
    name = "Dictionary_requiredShortFrozenArrayValue"
)
public interface Dictionary_requiredShortFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredShortFrozenArrayValue requiredShortFrozenArrayValue(
      @Nonnull final JsArray<Double> requiredShortFrozenArrayValue) {
    final Dictionary_requiredShortFrozenArrayValue $dictionaryRequiredShortFrozenArrayValue = Js.<Dictionary_requiredShortFrozenArrayValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredShortFrozenArrayValue.setRequiredShortFrozenArrayValue( requiredShortFrozenArrayValue );
    return Js.uncheckedCast( $dictionaryRequiredShortFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredShortFrozenArrayValue"
  )
  @JsNonNull
  JsArray<Double> requiredShortFrozenArrayValue();

  @JsProperty
  void setRequiredShortFrozenArrayValue(@JsNonNull JsArray<Double> requiredShortFrozenArrayValue);
}
