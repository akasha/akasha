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
    name = "Dictionary_requiredUnrestrictedDoubleValue"
)
public interface Dictionary_requiredUnrestrictedDoubleValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredUnrestrictedDoubleValue requiredUnrestrictedDoubleValue(
      final double requiredUnrestrictedDoubleValue) {
    final Dictionary_requiredUnrestrictedDoubleValue $dictionaryRequiredUnrestrictedDoubleValue = Js.<Dictionary_requiredUnrestrictedDoubleValue>uncheckedCast( JsPropertyMap.of() );
    $dictionaryRequiredUnrestrictedDoubleValue.setRequiredUnrestrictedDoubleValue( requiredUnrestrictedDoubleValue );
    return Js.uncheckedCast( $dictionaryRequiredUnrestrictedDoubleValue );
  }

  @JsProperty(
      name = "requiredUnrestrictedDoubleValue"
  )
  double requiredUnrestrictedDoubleValue();

  @JsProperty
  void setRequiredUnrestrictedDoubleValue(double requiredUnrestrictedDoubleValue);
}
