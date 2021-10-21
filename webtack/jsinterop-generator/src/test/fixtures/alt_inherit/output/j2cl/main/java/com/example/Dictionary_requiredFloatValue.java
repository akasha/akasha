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
    name = "Dictionary_requiredFloatValue"
)
public interface Dictionary_requiredFloatValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredFloatValue requiredFloatValue(final float requiredFloatValue) {
    final Dictionary_requiredFloatValue $dictionaryRequiredFloatValue = Js.<Dictionary_requiredFloatValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredFloatValue.setRequiredFloatValue( requiredFloatValue );
    return Js.uncheckedCast( $dictionaryRequiredFloatValue );
  }

  @JsProperty(
      name = "requiredFloatValue"
  )
  float requiredFloatValue();

  @JsProperty
  void setRequiredFloatValue(float requiredFloatValue);
}
