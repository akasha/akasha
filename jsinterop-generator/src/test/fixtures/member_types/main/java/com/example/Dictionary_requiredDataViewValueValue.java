package com.example;

import elemental2.core.DataView;
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
public interface Dictionary_requiredDataViewValueValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredDataViewValueValue create(
      @Nonnull final DataView requiredDataViewValueValue) {
    return Js.<Dictionary_requiredDataViewValueValue>uncheckedCast( JsPropertyMap.of() ).requiredDataViewValueValue( requiredDataViewValueValue );
  }

  @JsProperty(
      name = "requiredDataViewValueValue"
  )
  @Nonnull
  DataView requiredDataViewValueValue();

  @JsProperty
  void setRequiredDataViewValueValue(@Nonnull DataView requiredDataViewValueValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredDataViewValueValue requiredDataViewValueValue(
      @Nonnull final DataView requiredDataViewValueValue) {
    setRequiredDataViewValueValue( requiredDataViewValueValue );
    return this;
  }
}
