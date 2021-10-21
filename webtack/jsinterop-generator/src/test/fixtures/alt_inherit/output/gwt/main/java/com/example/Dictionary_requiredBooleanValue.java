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
    name = "Object"
)
public interface Dictionary_requiredBooleanValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredBooleanValue requiredBooleanValue(final boolean requiredBooleanValue) {
    final Dictionary_requiredBooleanValue $dictionaryRequiredBooleanValue = Js.<Dictionary_requiredBooleanValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredBooleanValue.setRequiredBooleanValue( requiredBooleanValue );
    return Js.uncheckedCast( $dictionaryRequiredBooleanValue );
  }

  @JsProperty(
      name = "requiredBooleanValue"
  )
  boolean requiredBooleanValue();

  @JsProperty
  void setRequiredBooleanValue(boolean requiredBooleanValue);
}
