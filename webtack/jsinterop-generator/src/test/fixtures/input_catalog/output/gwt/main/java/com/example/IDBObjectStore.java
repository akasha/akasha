package com.example;

import com.biz.MyEventHandler1;
import com.biz.MyEventListener;
import com.biz.MyIDBIndex;
import com.biz.MyIDBIndexParameters;
import com.biz.MyStringOrLongLongUnion;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull String keyPath,
      @Nonnull MyIDBIndexParameters options);

  @JsNonNull
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull JsArray<String> keyPath,
      @Nonnull MyIDBIndexParameters options);

  @JsNonNull
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull String[] keyPath,
      @Nonnull MyIDBIndexParameters options);

  @JsNonNull
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull String keyPath);

  @JsNonNull
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull JsArray<String> keyPath);

  @JsOverlay
  @JsNonNull
  public final MyIDBIndex createIndex(@Nonnull final String name,
      @Nonnull final String... keyPath) {
    return _createIndex( name, keyPath );
  }

  @JsMethod(
      name = "createIndex"
  )
  @JsNonNull
  private native MyIDBIndex _createIndex(@Nonnull String name, @Nonnull String[] keyPath);

  @JsNonNull
  public native MyIDBIndex createIndex2(@Nonnull String name, @Nonnull IDBIndexParameters2 options);

  @JsNonNull
  public native MyIDBIndex createIndex2(@Nonnull String name);

  public native void registerListeners(@Nonnull MyEventListener eventListener,
      @Nonnull CompletionCallback completionCallback);

  @JsNonNull
  public native StringOrFloatUnion returnSomeUnionThatIsNotPredefined();

  @JsNonNull
  public native MyStringOrLongLongUnion returnSomeUnionThatIsPredefined();
}
