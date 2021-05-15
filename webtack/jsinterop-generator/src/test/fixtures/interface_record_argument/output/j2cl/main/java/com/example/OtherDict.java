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
    name = "OtherDict"
)
public interface OtherDict {
  @JsOverlay
  @Nonnull
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "value"
  )
  JsPropertyMap<String> value();

  @JsProperty
  void setValue(@Nonnull JsPropertyMap<String> value);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "OtherDict"
  )
  interface Builder extends OtherDict {
    @JsOverlay
    @Nonnull
    default Builder value(@Nonnull final JsPropertyMap<String> value) {
      setValue( value );
      return this;
    }
  }
}
