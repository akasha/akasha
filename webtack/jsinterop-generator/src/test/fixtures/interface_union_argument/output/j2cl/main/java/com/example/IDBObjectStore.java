package com.example;

import javax.annotation.processing.Generated;
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
  public native IDBIndex createIndex(@JsNonNull String name, @JsNonNull String keyPath,
      @JsNonNull IDBIndexParameters options);

  @JsNonNull
  public native IDBIndex createIndex(@JsNonNull String name, @JsNonNull JsArray<String> keyPath,
      @JsNonNull IDBIndexParameters options);

  @JsNonNull
  public native IDBIndex createIndex(@JsNonNull String name, String @JsNonNull [] keyPath,
      @JsNonNull IDBIndexParameters options);

  @JsNonNull
  public native IDBIndex createIndex(@JsNonNull String name, @JsNonNull String keyPath);

  @JsNonNull
  public native IDBIndex createIndex(@JsNonNull String name, @JsNonNull JsArray<String> keyPath);

  @JsOverlay
  @JsNonNull
  public final IDBIndex createIndex(final @JsNonNull String name,
      final String @JsNonNull ... keyPath) {
    return _createIndex( name, keyPath );
  }

  @JsMethod(
      name = "createIndex"
  )
  @JsNonNull
  private native IDBIndex _createIndex(@JsNonNull String name, String @JsNonNull [] keyPath);
}
