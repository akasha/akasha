package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
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
public interface Dictionary_requiredLongLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredLongLongValue requiredLongLongValue(final int requiredLongLongValue) {
    final Dictionary_requiredLongLongValue $dictionaryRequiredLongLongValue = Js.<Dictionary_requiredLongLongValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredLongLongValue.setRequiredLongLongValue( requiredLongLongValue );
    return Js.uncheckedCast( $dictionaryRequiredLongLongValue );
  }

  @JsProperty(
      name = "requiredLongLongValue"
  )
  int requiredLongLongValue();

  @JsProperty
  void setRequiredLongLongValue(int requiredLongLongValue);
}
