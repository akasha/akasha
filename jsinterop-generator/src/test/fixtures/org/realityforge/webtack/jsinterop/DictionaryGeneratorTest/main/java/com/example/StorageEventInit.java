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
    name = "?"
)
public interface StorageEventInit extends EventInit {
  @JsProperty
  @Nullable
  String getKey();

  @JsProperty
  void setKey(@Nullable String key);

  @JsProperty
  @Nullable
  String getNewValue();

  @JsProperty
  void setNewValue(@Nullable String newValue);

  @JsProperty
  @Nullable
  String getOldValue();

  @JsProperty
  void setOldValue(@Nullable String oldValue);

  @JsProperty
  @Nullable
  Storage getStorageArea();

  @JsProperty
  void setStorageArea(@Nullable Storage storageArea);

  @JsProperty
  @Nonnull
  String getUrl();

  @JsProperty
  void setUrl(@Nonnull String url);
}
