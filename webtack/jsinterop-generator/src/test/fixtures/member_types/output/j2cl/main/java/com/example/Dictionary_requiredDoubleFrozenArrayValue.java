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
    name = "Dictionary_requiredDoubleFrozenArrayValue"
)
public interface Dictionary_requiredDoubleFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleFrozenArrayValue requiredDoubleFrozenArrayValue(
      @Nonnull final JsArray<Double> requiredDoubleFrozenArrayValue) {
    final Dictionary_requiredDoubleFrozenArrayValue $dictionaryRequiredDoubleFrozenArrayValue = Js.<Dictionary_requiredDoubleFrozenArrayValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredDoubleFrozenArrayValue.setRequiredDoubleFrozenArrayValue( requiredDoubleFrozenArrayValue );
    return Js.uncheckedCast( $dictionaryRequiredDoubleFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredDoubleFrozenArrayValue"
  )
  @JsNonNull
  JsArray<Double> requiredDoubleFrozenArrayValue();

  @JsProperty
  void setRequiredDoubleFrozenArrayValue(@JsNonNull JsArray<Double> requiredDoubleFrozenArrayValue);
}
