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
public interface Dictionary_requiredByteStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredByteStringValue requiredByteStringValue(
      @Nonnull final String requiredByteStringValue) {
    final Dictionary_requiredByteStringValue $dictionaryRequiredByteStringValue = Js.<Dictionary_requiredByteStringValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredByteStringValue.setRequiredByteStringValue( requiredByteStringValue );
    return Js.uncheckedCast( $dictionaryRequiredByteStringValue );
  }

  @JsProperty(
      name = "requiredByteStringValue"
  )
  @JsNonNull
  String requiredByteStringValue();

  @JsProperty
  void setRequiredByteStringValue(@JsNonNull String requiredByteStringValue);
}
