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
public interface Dictionary_requiredDOMStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDOMStringValue requiredDOMStringValue(
      @Nonnull final String requiredDOMStringValue) {
    final Dictionary_requiredDOMStringValue $dictionaryRequiredDOMStringValue = Js.<Dictionary_requiredDOMStringValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredDOMStringValue.setRequiredDOMStringValue( requiredDOMStringValue );
    return Js.uncheckedCast( $dictionaryRequiredDOMStringValue );
  }

  @JsProperty(
      name = "requiredDOMStringValue"
  )
  @JsNonNull
  String requiredDOMStringValue();

  @JsProperty
  void setRequiredDOMStringValue(@JsNonNull String requiredDOMStringValue);
}
