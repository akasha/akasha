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
    name = "Dictionary_requiredOctetValue"
)
public interface Dictionary_requiredOctetValue {
  @JsOverlay
  @Nonnull
  static Builder create(final short requiredOctetValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredOctetValue( requiredOctetValue );
  }

  @JsProperty(
      name = "requiredOctetValue"
  )
  short requiredOctetValue();

  @JsProperty
  void setRequiredOctetValue(short requiredOctetValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredOctetValue"
  )
  interface Builder extends Dictionary_requiredOctetValue {
    @JsOverlay
    @Nonnull
    default Builder requiredOctetValue(final short requiredOctetValue) {
      setRequiredOctetValue( requiredOctetValue );
      return this;
    }
  }
}
