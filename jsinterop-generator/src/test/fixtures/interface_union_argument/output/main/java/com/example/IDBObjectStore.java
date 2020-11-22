package com.example;

import elemental3.core.JsArray;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

  @Nonnull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull String keyPath,
      @Nonnull IDBIndexParameters options);

  @Nonnull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull JsArray<String> keyPath,
      @Nonnull IDBIndexParameters options);

  @Nonnull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull String[] keyPath,
      @Nonnull IDBIndexParameters options);

  @Nonnull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull String keyPath);

  @Nonnull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull JsArray<String> keyPath);

  @Nonnull
  public native IDBIndex createIndex(@Nonnull String name, @Nonnull String[] keyPath);
}
