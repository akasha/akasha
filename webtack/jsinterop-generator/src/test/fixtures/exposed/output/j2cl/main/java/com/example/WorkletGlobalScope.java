package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "WorkletGlobalScope"
)
public class WorkletGlobalScope {
  protected WorkletGlobalScope() {
  }

  @JsProperty(
      name = "workletGlobalScopeAttribute"
  )
  @Nonnull
  public native String workletGlobalScopeAttribute();
}
