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
public interface Dictionary_requiredObjectValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredObjectValue requiredObjectValue(
      @Nonnull final JsObject requiredObjectValue) {
    final Dictionary_requiredObjectValue $dictionaryRequiredObjectValue = Js.<Dictionary_requiredObjectValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredObjectValue.setRequiredObjectValue( requiredObjectValue );
    return Js.uncheckedCast( $dictionaryRequiredObjectValue );
  }

  @JsProperty(
      name = "requiredObjectValue"
  )
  @JsNonNull
  JsObject requiredObjectValue();

  @JsProperty
  void setRequiredObjectValue(@JsNonNull JsObject requiredObjectValue);
}
