package com.example;

import com.biz.MyEventHandler1;
import com.biz.MyEventListener;
import com.biz.MyIDBIndex;
import com.biz.MyIDBIndexParameters;
import com.biz.MyStringOrLongLongUnion;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "IDBObjectStore"
)
public class IDBObjectStore {
  @Nonnull
  public MyEventHandler1 handler1;

  @Nonnull
  public EventHandler2 handler2;

  protected IDBObjectStore() {
  }

  @Nonnull
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull String keyPath,
      @Nonnull MyIDBIndexParameters options);

  @Nonnull
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull JsArray<String> keyPath,
      @Nonnull MyIDBIndexParameters options);

  @Nonnull
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull String[] keyPath,
      @Nonnull MyIDBIndexParameters options);

  @Nonnull
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull String keyPath);

  @Nonnull
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull JsArray<String> keyPath);

  @Nonnull
  public native MyIDBIndex createIndex(@Nonnull String name, @Nonnull String[] keyPath);

  @Nonnull
  public native MyIDBIndex createIndex2(@Nonnull String name, @Nonnull IDBIndexParameters2 options);

  @Nonnull
  public native MyIDBIndex createIndex2(@Nonnull String name);

  public native void registerListeners(@Nonnull MyEventListener eventListener,
      @Nonnull CompletionCallback completionCallback);

  @Nonnull
  public native StringOrFloatUnion returnSomeUnionThatIsNotPredefined();

  @Nonnull
  public native MyStringOrLongLongUnion returnSomeUnionThatIsPredefined();
}
