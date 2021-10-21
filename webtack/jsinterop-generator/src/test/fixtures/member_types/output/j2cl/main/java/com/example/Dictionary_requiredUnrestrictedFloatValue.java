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
    name = "Dictionary_requiredUnrestrictedFloatValue"
)
public interface Dictionary_requiredUnrestrictedFloatValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUnrestrictedFloatValue requiredUnrestrictedFloatValue(
      final float requiredUnrestrictedFloatValue) {
    final Dictionary_requiredUnrestrictedFloatValue $dictionaryRequiredUnrestrictedFloatValue = Js.<Dictionary_requiredUnrestrictedFloatValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredUnrestrictedFloatValue.setRequiredUnrestrictedFloatValue( requiredUnrestrictedFloatValue );
    return Js.uncheckedCast( $dictionaryRequiredUnrestrictedFloatValue );
  }

  @JsProperty(
      name = "requiredUnrestrictedFloatValue"
  )
  float requiredUnrestrictedFloatValue();

  @JsProperty
  void setRequiredUnrestrictedFloatValue(float requiredUnrestrictedFloatValue);
}
