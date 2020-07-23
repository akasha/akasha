package com.example;

import elemental2.core.ArrayBuffer;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
    name = "?"
)
public interface Dictionary_requiredNullableArrayBufferValueValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableArrayBufferValueValue create(
      @Nullable final ArrayBuffer requiredNullableArrayBufferValueValue) {
    return Js.<Dictionary_requiredNullableArrayBufferValueValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableArrayBufferValueValue( requiredNullableArrayBufferValueValue );
  }

  @JsProperty
  @Nullable
  ArrayBuffer getRequiredNullableArrayBufferValueValue();

  @JsProperty
  void setRequiredNullableArrayBufferValueValue(
      @Nullable ArrayBuffer requiredNullableArrayBufferValueValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableArrayBufferValueValue requiredNullableArrayBufferValueValue(
      @Nullable final ArrayBuffer requiredNullableArrayBufferValueValue) {
    setRequiredNullableArrayBufferValueValue( requiredNullableArrayBufferValueValue );
    return this;
  }
}
