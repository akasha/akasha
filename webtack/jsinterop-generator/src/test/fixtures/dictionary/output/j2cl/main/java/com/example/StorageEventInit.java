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
    name = "StorageEventInit"
)
public interface StorageEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "key"
  )
  @Nullable
  String key();

  @JsProperty
  void setKey(@Nullable String key);

  @JsProperty(
      name = "newValue"
  )
  @Nullable
  String newValue();

  @JsProperty
  void setNewValue(@Nullable String newValue);

  @JsProperty(
      name = "oldValue"
  )
  @Nullable
  String oldValue();

  @JsProperty
  void setOldValue(@Nullable String oldValue);

  @JsProperty(
      name = "storageArea"
  )
  @Nullable
  Storage storageArea();

  @JsProperty
  void setStorageArea(@Nullable Storage storageArea);

  @JsProperty(
      name = "url"
  )
  String url();

  @JsProperty
  void setUrl(@Nonnull String url);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "StorageEventInit"
  )
  interface Builder extends StorageEventInit {
    @JsOverlay
    @Nonnull
    default Builder key(@Nullable final String key) {
      setKey( key );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder newValue(@Nullable final String newValue) {
      setNewValue( newValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder oldValue(@Nullable final String oldValue) {
      setOldValue( oldValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder storageArea(@Nullable final Storage storageArea) {
      setStorageArea( storageArea );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder url(@Nonnull final String url) {
      setUrl( url );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder bubbles(final boolean bubbles) {
      setBubbles( bubbles );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder cancelable(final boolean cancelable) {
      setCancelable( cancelable );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder composed(final boolean composed) {
      setComposed( composed );
      return this;
    }
  }
}
