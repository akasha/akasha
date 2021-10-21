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
    name = "Object"
)
public interface Dictionary_requiredBooleanFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredBooleanFrozenArrayValue requiredBooleanFrozenArrayValue(
      @Nonnull final JsArray<Boolean> requiredBooleanFrozenArrayValue) {
    final Dictionary_requiredBooleanFrozenArrayValue $dictionaryRequiredBooleanFrozenArrayValue = Js.<Dictionary_requiredBooleanFrozenArrayValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredBooleanFrozenArrayValue.setRequiredBooleanFrozenArrayValue( requiredBooleanFrozenArrayValue );
    return Js.uncheckedCast( $dictionaryRequiredBooleanFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredBooleanFrozenArrayValue"
  )
  @JsNonNull
  JsArray<Boolean> requiredBooleanFrozenArrayValue();

  @JsProperty
  void setRequiredBooleanFrozenArrayValue(
      @JsNonNull JsArray<Boolean> requiredBooleanFrozenArrayValue);
}
