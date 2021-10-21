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
  static Builder of() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "multiEntry"
  )
  boolean multiEntry();

  @JsProperty
  void setMultiEntry(boolean multiEntry);

  @JsProperty(
      name = "unique"
  )
  boolean unique();

  @JsProperty
  void setUnique(boolean unique);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends IDBIndexParameters {
    @JsOverlay
    @Nonnull
    default Builder multiEntry(final boolean multiEntry) {
      setMultiEntry( multiEntry );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder unique(final boolean unique) {
      setUnique( unique );
      return this;
    }
  }
}
