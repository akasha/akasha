package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
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
    name = "Object"
)
public interface StorageEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static Builder of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "key"
  )
  @JsNullable
  String key();

  @JsProperty
  void setKey(@JsNullable String key);

  @JsProperty(
      name = "newValue"
  )
  @JsNullable
  String newValue();

  @JsProperty
  void setNewValue(@JsNullable String newValue);

  @JsProperty(
      name = "oldValue"
  )
  @JsNullable
  String oldValue();

  @JsProperty
  void setOldValue(@JsNullable String oldValue);

  @JsProperty(
      name = "storageArea"
  )
  @JsNullable
  Storage storageArea();

  @JsProperty
  void setStorageArea(@JsNullable Storage storageArea);

  @JsProperty(
      name = "url"
  )
  String url();

  @JsProperty
  void setUrl(@JsNonNull String url);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
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
  }
}
