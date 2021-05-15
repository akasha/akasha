package com.example;

import com.biz.MyEventHandler1;
import com.biz.MyEventListener;
import com.biz.MyIDBIndex;
import com.biz.MyIDBIndexParameters;
import com.biz.MyStringOrLongLongUnion;
import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class IDBObjectStoreTest {
  public static MyEventHandler1 handler1(final IDBObjectStore type) {
    return type.handler1;
  }

  public static void handler1(final IDBObjectStore type, final MyEventHandler1 value) {
    type.handler1 = value;
  }

  public static EventHandler2 handler2(final IDBObjectStore type) {
    return type.handler2;
  }

  public static void handler2(final IDBObjectStore type, final EventHandler2 value) {
    type.handler2 = value;
  }

  public static MyIDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final String keyPath, final MyIDBIndexParameters options) {
    return $instance.createIndex( name, keyPath, options );
  }

  public static MyIDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final JsArray<String> keyPath, final MyIDBIndexParameters options) {
    return $instance.createIndex( name, keyPath, options );
  }

  public static MyIDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final String[] keyPath, final MyIDBIndexParameters options) {
    return $instance.createIndex( name, keyPath, options );
  }

  public static MyIDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final String keyPath) {
    return $instance.createIndex( name, keyPath );
  }

  public static MyIDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final JsArray<String> keyPath) {
    return $instance.createIndex( name, keyPath );
  }

  public static MyIDBIndex createIndex(final IDBObjectStore $instance, final String name,
      final String[] keyPath) {
    return $instance.createIndex( name, keyPath );
  }

  public static MyIDBIndex createIndex2(final IDBObjectStore $instance, final String name,
      final IDBIndexParameters2 options) {
    return $instance.createIndex2( name, options );
  }

  public static MyIDBIndex createIndex2(final IDBObjectStore $instance, final String name) {
    return $instance.createIndex2( name );
  }

  public static void registerListeners(final IDBObjectStore $instance,
      final MyEventListener eventListener, final CompletionCallback completionCallback) {
    $instance.registerListeners( eventListener, completionCallback );
  }

  public static StringOrFloatUnion returnSomeUnionThatIsNotPredefined(
      final IDBObjectStore $instance) {
    return $instance.returnSomeUnionThatIsNotPredefined();
  }

  public static MyStringOrLongLongUnion returnSomeUnionThatIsPredefined(
      final IDBObjectStore $instance) {
    return $instance.returnSomeUnionThatIsPredefined();
  }
}
