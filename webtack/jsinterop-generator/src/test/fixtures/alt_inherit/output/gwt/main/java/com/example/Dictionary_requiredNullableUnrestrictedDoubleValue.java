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
public interface Dictionary_requiredNullableUnrestrictedDoubleValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableUnrestrictedDoubleValue requiredNullableUnrestrictedDoubleValue(
      @Nullable final Double requiredNullableUnrestrictedDoubleValue) {
    final Dictionary_requiredNullableUnrestrictedDoubleValue $dictionaryRequiredNullableUnrestrictedDoubleValue = Js.<Dictionary_requiredNullableUnrestrictedDoubleValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableUnrestrictedDoubleValue.setRequiredNullableUnrestrictedDoubleValue( requiredNullableUnrestrictedDoubleValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableUnrestrictedDoubleValue );
  }

  @JsProperty(
      name = "requiredNullableUnrestrictedDoubleValue"
  )
  @JsNullable
  Double requiredNullableUnrestrictedDoubleValue();

  @JsProperty
  void setRequiredNullableUnrestrictedDoubleValue(
      @JsNullable Double requiredNullableUnrestrictedDoubleValue);
}
