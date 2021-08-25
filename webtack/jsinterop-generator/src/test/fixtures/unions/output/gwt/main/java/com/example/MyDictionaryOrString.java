package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "?"
)
public interface MyDictionaryOrString {
  @JsOverlay
  @Nonnull
  static MyDictionaryOrString of(@Nonnull final MyDictionary value) {
    return Js.cast( value );
  }

  @JsOverlay
  @Nonnull
  static MyDictionaryOrString of(@Nonnull final String value) {
    return Js.cast( value );
  }

  @JsOverlay
  default boolean isMyDictionary() {
    return ( (Object) this ) instanceof JsObject;
  }

  @JsOverlay
  default MyDictionary asMyDictionary() {
    return Js.cast( this );
  }

  @JsOverlay
  default boolean isString() {
    return ( (Object) this ) instanceof String;
  }

  @JsOverlay
  default String asString() {
    return Js.asString( this );
  }
}
