package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
    name = "Dictionary_requiredLongValue"
)
public interface Dictionary_requiredLongValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredLongValue requiredLongValue(final int requiredLongValue) {
    final Dictionary_requiredLongValue $dictionaryRequiredLongValue = Js.<Dictionary_requiredLongValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredLongValue.setRequiredLongValue( requiredLongValue );
    return Js.uncheckedCast( $dictionaryRequiredLongValue );
  }

  @JsProperty(
      name = "requiredLongValue"
  )
  int requiredLongValue();

  @JsProperty
  void setRequiredLongValue(int requiredLongValue);
}
