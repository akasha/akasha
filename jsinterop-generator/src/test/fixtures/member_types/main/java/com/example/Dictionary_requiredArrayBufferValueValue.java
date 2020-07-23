package com.example;

import elemental2.core.ArrayBuffer;
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
    name = "?"
)
public interface Dictionary_requiredArrayBufferValueValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredArrayBufferValueValue create(
      @Nonnull final ArrayBuffer requiredArrayBufferValueValue) {
    return Js.<Dictionary_requiredArrayBufferValueValue>uncheckedCast( JsPropertyMap.of() ).requiredArrayBufferValueValue( requiredArrayBufferValueValue );
  }

  @JsProperty
  @Nonnull
  ArrayBuffer getRequiredArrayBufferValueValue();

  @JsProperty
  void setRequiredArrayBufferValueValue(@Nonnull ArrayBuffer requiredArrayBufferValueValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredArrayBufferValueValue requiredArrayBufferValueValue(
      @Nonnull final ArrayBuffer requiredArrayBufferValueValue) {
    setRequiredArrayBufferValueValue( requiredArrayBufferValueValue );
    return this;
  }
}
