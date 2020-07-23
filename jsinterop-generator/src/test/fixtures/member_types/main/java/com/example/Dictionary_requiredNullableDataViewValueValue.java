package com.example;

import elemental2.core.DataView;
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
public interface Dictionary_requiredNullableDataViewValueValue {
  @JsOverlay
  @Nonnull
  static Dictionary_requiredNullableDataViewValueValue create(
      @Nullable final DataView requiredNullableDataViewValueValue) {
    return Js.<Dictionary_requiredNullableDataViewValueValue>uncheckedCast( JsPropertyMap.of() ).requiredNullableDataViewValueValue( requiredNullableDataViewValueValue );
  }

  @JsProperty
  @Nullable
  DataView getRequiredNullableDataViewValueValue();

  @JsProperty
  void setRequiredNullableDataViewValueValue(@Nullable DataView requiredNullableDataViewValueValue);

  @JsOverlay
  @Nonnull
  default Dictionary_requiredNullableDataViewValueValue requiredNullableDataViewValueValue(
      @Nullable final DataView requiredNullableDataViewValueValue) {
    setRequiredNullableDataViewValueValue( requiredNullableDataViewValueValue );
    return this;
  }
}
