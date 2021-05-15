package com.example;

import javax.annotation.Generated;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsArrayLike;

/**
 * This type contains anonymous indexed property operations.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "MyThingCollection"
)
public class MyThingCollection {
  protected MyThingCollection() {
  }

  @JsOverlay
  @Nullable
  public final MyThing getAt(final int index) {
    return Js.<JsArrayLike<MyThing>>cast( this ).getAt( index );
  }

  @JsOverlay
  public final void setAt(final int index, @Nullable final MyThing option) {
    Js.<JsArrayLike<MyThing>>cast( this ).setAt( index, option );
  }
}
