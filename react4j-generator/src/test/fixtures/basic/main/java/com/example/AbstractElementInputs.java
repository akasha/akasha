package com.example;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;

@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public abstract class AbstractElementInputs<T extends AbstractElementInputs<T>> {
  @JsOverlay
  @Nonnull
  public final T id(@Nonnull final String id) {
    prop( "id", Js.asAny( id ) );
    return self();
  }

  @JsOverlay
  @Nonnull
  public final T className(@Nonnull final String className) {
    prop( "className", Js.asAny( className ) );
    return self();
  }

  @JsOverlay
  @Nonnull
  public final T key(@Nonnull final String key) {
    prop( "key", Js.asAny( key ) );
    return self();
  }

  @JsOverlay
  @Nonnull
  public final T prop(@Nonnull final String key, @Nullable final Any value) {
    Js.asPropertyMap( this ).set( key, value );
    return self();
  }

  @JsOverlay
  @Nonnull
  protected final T self() {
    return Js.uncheckedCast( this );
  }
}
