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
public interface Dictionary_requiredUSVStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUSVStringValue requiredUSVStringValue(
      @Nonnull final String requiredUSVStringValue) {
    final Dictionary_requiredUSVStringValue $dictionaryRequiredUSVStringValue = Js.<Dictionary_requiredUSVStringValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredUSVStringValue.setRequiredUSVStringValue( requiredUSVStringValue );
    return Js.uncheckedCast( $dictionaryRequiredUSVStringValue );
  }

  @JsProperty(
      name = "requiredUSVStringValue"
  )
  @JsNonNull
  String requiredUSVStringValue();

  @JsProperty
  void setRequiredUSVStringValue(@JsNonNull String requiredUSVStringValue);
}
