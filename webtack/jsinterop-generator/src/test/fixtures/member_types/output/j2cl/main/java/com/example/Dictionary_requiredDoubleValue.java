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
    name = "Dictionary_requiredDoubleValue"
)
public interface Dictionary_requiredDoubleValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDoubleValue requiredDoubleValue(final double requiredDoubleValue) {
    final Dictionary_requiredDoubleValue $dictionaryRequiredDoubleValue = Js.<Dictionary_requiredDoubleValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredDoubleValue.setRequiredDoubleValue( requiredDoubleValue );
    return Js.uncheckedCast( $dictionaryRequiredDoubleValue );
  }

  @JsProperty(
      name = "requiredDoubleValue"
  )
  double requiredDoubleValue();

  @JsProperty
  void setRequiredDoubleValue(double requiredDoubleValue);
}
