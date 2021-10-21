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
public interface Dictionary_requiredNullableUnrestrictedFloatValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUnrestrictedFloatValue requiredNullableUnrestrictedFloatValue(
      @Nullable final Double requiredNullableUnrestrictedFloatValue) {
    final Dictionary_requiredNullableUnrestrictedFloatValue $dictionaryRequiredNullableUnrestrictedFloatValue = Js.<Dictionary_requiredNullableUnrestrictedFloatValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableUnrestrictedFloatValue.setRequiredNullableUnrestrictedFloatValue( requiredNullableUnrestrictedFloatValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableUnrestrictedFloatValue );
  }

  @JsProperty(
      name = "requiredNullableUnrestrictedFloatValue"
  )
  @JsNullable
  Double requiredNullableUnrestrictedFloatValue();

  @JsProperty
  void setRequiredNullableUnrestrictedFloatValue(
      @JsNullable Double requiredNullableUnrestrictedFloatValue);
}
