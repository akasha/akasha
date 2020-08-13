package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface GlobalDescriptor {
  @JsOverlay
  @Nonnull
  static GlobalDescriptor create(@Nullable final Any value) {
    return Js.<GlobalDescriptor>uncheckedCast( JsPropertyMap.of() ).value( value );
  }

  @JsProperty(
      name = "mutable"
  )
  boolean mutable();

  @JsProperty
  void setMutable(boolean mutable);

  @JsOverlay
  @Nonnull
  default GlobalDescriptor mutable(final boolean mutable) {
    setMutable( mutable );
    return this;
  }

  @JsProperty(
      name = "value"
  )
  @Nullable
  Any value();

  @JsProperty
  void setValue(@Nullable Any value);

  @JsOverlay
  @Nonnull
  default GlobalDescriptor value(@Nullable final Any value) {
    setValue( value );
    return this;
  }
}
