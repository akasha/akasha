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
    name = "Dictionary_requiredNullableDOMStringValue"
)
public interface Dictionary_requiredNullableDOMStringValue {
  @JsOverlay
  @Nonnull
  static Builder create(@Nullable final String requiredNullableDOMStringValue) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).requiredNullableDOMStringValue( requiredNullableDOMStringValue );
  }

  @JsProperty(
      name = "requiredNullableDOMStringValue"
  )
  @JsNullable
  String requiredNullableDOMStringValue();

  @JsProperty
  void setRequiredNullableDOMStringValue(@JsNullable String requiredNullableDOMStringValue);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Dictionary_requiredNullableDOMStringValue"
  )
  interface Builder extends Dictionary_requiredNullableDOMStringValue {
    @JsOverlay
    @Nonnull
    default Builder requiredNullableDOMStringValue(
        @Nullable final String requiredNullableDOMStringValue) {
      setRequiredNullableDOMStringValue( requiredNullableDOMStringValue );
      return this;
    }
  }
}
