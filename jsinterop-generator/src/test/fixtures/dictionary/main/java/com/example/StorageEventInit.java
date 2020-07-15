package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
    name = "?"
)
public interface StorageEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static StorageEventInit create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty
  @Nullable
  String getKey();

  @JsProperty
  void setKey(@Nullable String key);

  @JsOverlay
  @Nonnull
  default StorageEventInit key(@Nullable String key) {
    setKey( key );
    return this;
  }

  @JsProperty
  @Nullable
  String getNewValue();

  @JsProperty
  void setNewValue(@Nullable String newValue);

  @JsOverlay
  @Nonnull
  default StorageEventInit newValue(@Nullable String newValue) {
    setNewValue( newValue );
    return this;
  }

  @JsProperty
  @Nullable
  String getOldValue();

  @JsProperty
  void setOldValue(@Nullable String oldValue);

  @JsOverlay
  @Nonnull
  default StorageEventInit oldValue(@Nullable String oldValue) {
    setOldValue( oldValue );
    return this;
  }

  @JsProperty
  @Nullable
  Storage getStorageArea();

  @JsProperty
  void setStorageArea(@Nullable Storage storageArea);

  @JsOverlay
  @Nonnull
  default StorageEventInit storageArea(@Nullable Storage storageArea) {
    setStorageArea( storageArea );
    return this;
  }

  @JsProperty
  String getUrl();

  @JsProperty
  void setUrl(@Nonnull String url);

  @JsOverlay
  @Nonnull
  default StorageEventInit url(@Nonnull String url) {
    setUrl( url );
    return this;
  }
}
