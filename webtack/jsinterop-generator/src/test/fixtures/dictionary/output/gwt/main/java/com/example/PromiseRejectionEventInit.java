package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public interface PromiseRejectionEventInit extends EventInit {
  @JsOverlay
  @Nonnull
  static Builder promise(@Nonnull final JsPromise<Any> promise) {
    return Js.<Builder>uncheckedCast( JsPropertyMap.of() ).promise( promise );
  }

  @JsProperty(
      name = "promise"
  )
  @JsNonNull
  JsPromise<Any> promise();

  @JsProperty
  void setPromise(@JsNonNull JsPromise<Any> promise);

  @JsProperty(
      name = "reason"
  )
  @JsNullable
  Any reason();

  @JsProperty
  void setReason(@DoNotAutobox @JsNullable Object reason);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends PromiseRejectionEventInit {
    @JsOverlay
    @Nonnull
    default Builder promise(@Nonnull final JsPromise<Any> promise) {
      setPromise( promise );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder reason(@DoNotAutobox @Nullable final Object reason) {
      setReason( reason );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder bubbles(final boolean bubbles) {
      setBubbles( bubbles );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder cancelable(final boolean cancelable) {
      setCancelable( cancelable );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder composed(final boolean composed) {
      setComposed( composed );
      return this;
    }
  }
}
