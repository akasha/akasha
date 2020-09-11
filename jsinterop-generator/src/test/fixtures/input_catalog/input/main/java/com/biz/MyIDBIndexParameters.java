package com.biz;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "?" )
public interface MyIDBIndexParameters {
  @JsOverlay
  @Nonnull
  static MyIDBIndexParameters create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "multiEntry"
  )
  boolean multiEntry();

  @JsProperty
  void setMultiEntry(boolean multiEntry);

  @JsOverlay
  @Nonnull
  default MyIDBIndexParameters multiEntry(final boolean multiEntry) {
    setMultiEntry( multiEntry );
    return this;
  }

  @JsProperty(
      name = "unique"
  )
  boolean unique();

  @JsProperty
  void setUnique(boolean unique);

  @JsOverlay
  @Nonnull
  default MyIDBIndexParameters unique(final boolean unique) {
    setUnique( unique );
    return this;
  }
}
