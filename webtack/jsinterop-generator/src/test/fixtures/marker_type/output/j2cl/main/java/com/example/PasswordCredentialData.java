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

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "PasswordCredentialData"
)
public interface PasswordCredentialData extends PasswordCredentialInit {
  @JsOverlay
  @Nonnull
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "iconURL"
  )
  String iconURL();

  @JsProperty
  void setIconURL(@JsNonNull String iconURL);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "PasswordCredentialData"
  )
  interface Builder extends PasswordCredentialData {
    @JsOverlay
    @Nonnull
    default Builder iconURL(@Nonnull final String iconURL) {
      setIconURL( iconURL );
      return this;
    }
  }
}
