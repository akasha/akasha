package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "IDBObjectStore"
)
public class IDBObjectStore {
  protected IDBObjectStore() {
  }

  @JsProperty(
      name = "autoIncrement"
  )
  public native boolean autoIncrement();

  @JsNonNull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull String keyPath,
      @Nonnull IDBIndexParameters options);

  @JsNonNull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull JsArray<String> keyPath,
      @Nonnull IDBIndexParameters options);

  @JsNonNull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull String[] keyPath,
      @Nonnull IDBIndexParameters options);

  @JsNonNull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull String keyPath);

  @JsNonNull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull JsArray<String> keyPath);

  @JsOverlay
  @JsNonNull
  public final IDBIndex createIndex(@Nonnull final String name, @Nonnull final String... keyPath) {
    return _createIndex( name, keyPath );
  }

  @JsMethod(
      name = "createIndex"
  )
  @JsNonNull
  private native IDBIndex _createIndex(@Nonnull String name, @Nonnull String[] keyPath);
}
