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
    name = "WorkerGlobalScope"
)
public class WorkerGlobalScope {
  protected WorkerGlobalScope() {
  }

  @JsProperty(
      name = "navigator"
  )
  @Nonnull
  public native WorkerNavigator navigator();
}
