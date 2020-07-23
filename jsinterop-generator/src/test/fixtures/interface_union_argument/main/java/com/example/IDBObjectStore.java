package com.example;

import elemental2.core.JsArray;
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
  /**
   * Type is instantiated by the runtime no attempt should be made to instantiate type by application code.
   */
  @Deprecated
  IDBObjectStore() {
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
