package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "MyType4"
)
public class MyType4 {
  protected MyType4() {
  }

  @JsMethod(
      name = "clone"
  )
  public native void clone_(@JsNonNull Object clone);

  @JsMethod(
      name = "default"
  )
  public native void default_(@JsNonNull Object default_);

  @JsMethod(
      name = "equals"
  )
  public native void equals_(@JsNonNull Object equals);

  @JsMethod(
      name = "finalize"
  )
  public native void finalize_(@JsNonNull Object finalize);

  @JsMethod(
      name = "getClass"
  )
  public native void getClass_(@JsNonNull Object getClass);

  @JsMethod(
      name = "hashCode"
  )
  public native void hashCode_(@JsNonNull Object hashCode);

  public native void is(@JsNonNull Object is);

  @JsMethod(
      name = "notify"
  )
  public native void notify_(@JsNonNull Object notify);

  @JsMethod(
      name = "notifyAll"
  )
  public native void notifyAll_(@JsNonNull Object notifyAll);

  public native void other(@JsNonNull Object toString);

  @JsMethod(
      name = "private"
  )
  public native void private_(@JsNonNull Object private_);

  @JsMethod(
      name = "protected"
  )
  public native void protected_(@JsNonNull Object protected_);

  @JsMethod(
      name = "public"
  )
  public native void public_(@JsNonNull Object public_);

  @JsMethod(
      name = "toString"
  )
  @JsNonNull
  public native String toString_();

  @JsMethod(
      name = "wait"
  )
  public native void wait_(@JsNonNull Object wait);
}
