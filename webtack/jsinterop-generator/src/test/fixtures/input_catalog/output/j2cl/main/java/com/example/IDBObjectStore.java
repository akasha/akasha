package com.example;

import com.biz.MyEventHandler1;
import com.biz.MyEventListener;
import com.biz.MyIDBIndex;
import com.biz.MyIDBIndexParameters;
import com.biz.MyStringOrLongLongUnion;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "IDBObjectStore"
)
public class IDBObjectStore {
  @JsNonNull
  public MyEventHandler1 handler1;

  @JsNonNull
  public EventHandler2 handler2;

  protected IDBObjectStore() {
  }

  @JsNonNull
  public native MyIDBIndex createIndex(@JsNonNull String name, @JsNonNull String keyPath,
      @JsNonNull MyIDBIndexParameters options);

  @JsNonNull
  public native MyIDBIndex createIndex(@JsNonNull String name, @JsNonNull JsArray<String> keyPath,
      @JsNonNull MyIDBIndexParameters options);

  @JsNonNull
  public native MyIDBIndex createIndex(@JsNonNull String name, String @JsNonNull [] keyPath,
      @JsNonNull MyIDBIndexParameters options);

  @JsNonNull
  public native MyIDBIndex createIndex(@JsNonNull String name, @JsNonNull String keyPath);

  @JsNonNull
  public native MyIDBIndex createIndex(@JsNonNull String name, @JsNonNull JsArray<String> keyPath);

  @JsOverlay
  @JsNonNull
  public final MyIDBIndex createIndex(final @JsNonNull String name,
      final String @JsNonNull ... keyPath) {
    return _createIndex( name, keyPath );
  }

  @JsMethod(
      name = "createIndex"
  )
  @JsNonNull
  private native MyIDBIndex _createIndex(@JsNonNull String name, String @JsNonNull [] keyPath);

  @JsNonNull
  public native MyIDBIndex createIndex2(@JsNonNull String name,
      @JsNonNull IDBIndexParameters2 options);

  @JsNonNull
  public native MyIDBIndex createIndex2(@JsNonNull String name);

  public native void registerListeners(@JsNonNull MyEventListener eventListener,
      @JsNonNull CompletionCallback completionCallback);

  @JsNonNull
  public native StringOrFloatUnion returnSomeUnionThatIsNotPredefined();

  @JsNonNull
  public native MyStringOrLongLongUnion returnSomeUnionThatIsPredefined();
}
