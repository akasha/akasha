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
    name = "?"
)
public interface IDBIndexParameters2 {
  @JsOverlay
  @Nonnull
  static IDBIndexParameters2 create() {
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
  default IDBIndexParameters2 multiEntry(final boolean multiEntry) {
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
  default IDBIndexParameters2 unique(final boolean unique) {
    setUnique( unique );
    return this;
  }
}
