package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public interface IDBIndexParameters {
  @JsOverlay
  @Nonnull
  static IDBIndexParameters create() {
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
  default IDBIndexParameters multiEntry(final boolean multiEntry) {
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
  default IDBIndexParameters unique(final boolean unique) {
    setUnique( unique );
    return this;
  }
}
