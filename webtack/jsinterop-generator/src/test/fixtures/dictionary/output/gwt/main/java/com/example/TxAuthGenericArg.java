package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public interface TxAuthGenericArg {
  @JsOverlay
  @Nonnull
  static TxAuthGenericArg contentType(@Nonnull final String contentType) {
    final TxAuthGenericArg $txAuthGenericArg = Js.<TxAuthGenericArg>uncheckedCast( JsPropertyMap.of() );
    $txAuthGenericArg.setContentType( contentType );
    return Js.uncheckedCast( $txAuthGenericArg );
  }

  @JsProperty(
      name = "contentType"
  )
  @JsNonNull
  String contentType();

  @JsProperty
  void setContentType(@JsNonNull String contentType);
}
