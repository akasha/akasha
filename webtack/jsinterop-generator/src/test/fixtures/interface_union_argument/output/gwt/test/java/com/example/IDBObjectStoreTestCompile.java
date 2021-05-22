package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class IDBObjectStoreTestCompile {
  static IDBObjectStore $typeReference$;

  public static boolean autoIncrement(final IDBObjectStore type) {
    return type.autoIncrement();
  }

  public static IDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final String keyPath, final IDBIndexParameters options) {
    return $instance.createIndex( name, keyPath, options );
  }

  public static IDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final JsArray<String> keyPath, final IDBIndexParameters options) {
    return $instance.createIndex( name, keyPath, options );
  }

  public static IDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final String[] keyPath, final IDBIndexParameters options) {
    return $instance.createIndex( name, keyPath, options );
  }

  public static IDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final String keyPath) {
    return $instance.createIndex( name, keyPath );
  }

  public static IDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final JsArray<String> keyPath) {
    return $instance.createIndex( name, keyPath );
  }

  public static IDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final String[] keyPath) {
    return $instance.createIndex( name, keyPath );
  }
}
