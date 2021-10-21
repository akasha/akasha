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
    name = "Dictionary_requiredNullableBooleanFrozenArrayValue"
)
public interface Dictionary_requiredNullableBooleanFrozenArrayValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableBooleanFrozenArrayValue requiredNullableBooleanFrozenArrayValue(
      @Nullable final JsArray<Boolean> requiredNullableBooleanFrozenArrayValue) {
    final Dictionary_requiredNullableBooleanFrozenArrayValue $dictionaryRequiredNullableBooleanFrozenArrayValue = Js.<Dictionary_requiredNullableBooleanFrozenArrayValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableBooleanFrozenArrayValue.setRequiredNullableBooleanFrozenArrayValue( requiredNullableBooleanFrozenArrayValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableBooleanFrozenArrayValue );
  }

  @JsProperty(
      name = "requiredNullableBooleanFrozenArrayValue"
  )
  @JsNullable
  JsArray<Boolean> requiredNullableBooleanFrozenArrayValue();

  @JsProperty
  void setRequiredNullableBooleanFrozenArrayValue(
      @JsNullable JsArray<Boolean> requiredNullableBooleanFrozenArrayValue);
}
