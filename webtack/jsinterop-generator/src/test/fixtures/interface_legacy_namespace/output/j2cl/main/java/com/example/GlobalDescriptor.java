package com.example;

import javaemul.internal.annotations.DoNotAutobox;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
    name = "GlobalDescriptor"
)
public interface GlobalDescriptor {
  @JsOverlay
  @Nonnull
  static Builder value(@DoNotAutobox @Nullable final Object value) {
    final Builder $globalDescriptor = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $globalDescriptor.setValue( value );
    return Js.uncheckedCast( $globalDescriptor );
  }

  @JsProperty(
      name = "value"
  )
  @JsNullable
  Any value();

  @JsProperty
  void setValue(@DoNotAutobox @JsNullable Object value);

  @JsProperty(
      name = "mutable"
  )
  boolean mutable();

  @JsProperty
  void setMutable(boolean mutable);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "GlobalDescriptor"
  )
  interface Builder extends GlobalDescriptor {
    @JsOverlay
    @Nonnull
    default Builder mutable(final boolean mutable) {
      setMutable( mutable );
      return this;
    }
  }
}
