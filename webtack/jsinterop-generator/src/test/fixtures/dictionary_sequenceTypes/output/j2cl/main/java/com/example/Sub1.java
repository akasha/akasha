package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
    name = "Sub1"
)
public interface Sub1 extends Base {
  @JsOverlay
  @Nonnull
  static Builder of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "others"
  )
  JsArray<Base> others();

  @JsProperty
  void setOthers(@JsNonNull JsArray<Base> others);

  @JsOverlay
  default void setOthers(@Nonnull final Base... others) {
    setOthers( Js.<JsArray<Base>>uncheckedCast( others ) );
  }

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Sub1"
  )
  interface Builder extends Sub1 {
    @JsOverlay
    @Nonnull
    default Builder others(@Nonnull final JsArray<Base> others) {
      setOthers( others );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder others(@Nonnull final Base... others) {
      setOthers( others );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder optionalFeatures(@Nonnull final JsArray<Any> optionalFeatures) {
      setOptionalFeatures( optionalFeatures );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder optionalFeatures(@Nonnull final Any... optionalFeatures) {
      setOptionalFeatures( optionalFeatures );
      return this;
    }
  }
}
