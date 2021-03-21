package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Storage"
)
public class Storage {
  protected Storage() {
  }

  @JsProperty(
      name = "length"
  )
  public native int length();

  public native void clear();

  @Nullable
  public native String key(int index);

  @Nullable
  public native String getItem(@Nonnull String key);

  public native void setItem(@Nonnull String key, @Nonnull String value);

  public native void removeItem(@Nonnull String key);
}
