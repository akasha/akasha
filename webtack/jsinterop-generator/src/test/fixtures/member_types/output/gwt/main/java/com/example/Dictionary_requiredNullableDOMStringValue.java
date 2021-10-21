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
public interface Dictionary_requiredNullableDOMStringValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDOMStringValue requiredNullableDOMStringValue(
      @Nullable final String requiredNullableDOMStringValue) {
    final Dictionary_requiredNullableDOMStringValue $dictionaryRequiredNullableDOMStringValue = Js.<Dictionary_requiredNullableDOMStringValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredNullableDOMStringValue.setRequiredNullableDOMStringValue( requiredNullableDOMStringValue );
    return Js.uncheckedCast( $dictionaryRequiredNullableDOMStringValue );
  }

  @JsProperty(
      name = "requiredNullableDOMStringValue"
  )
  @JsNullable
  String requiredNullableDOMStringValue();

  @JsProperty
  void setRequiredNullableDOMStringValue(@JsNullable String requiredNullableDOMStringValue);
}
