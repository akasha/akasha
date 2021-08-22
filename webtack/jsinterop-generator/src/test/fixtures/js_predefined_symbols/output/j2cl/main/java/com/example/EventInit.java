package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsNonNull;
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
    name = "EventInit"
)
public interface EventInit {
  @JsOverlay
  @Nonnull
  static Builder create() {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty(
      name = "jsElapsedTime"
  )
  double elapsedTime();

  @JsProperty
  void setElapsedTime(double elapsedTime);

  @JsProperty(
      name = "propertyName"
  )
  String propertyName();

  @JsProperty
  void setPropertyName(@JsNonNull String propertyName);

  @JsProperty(
      name = "propertyName2"
  )
  String propertyName2();

  @JsProperty
  void setPropertyName2(@JsNonNull String propertyName2);

  @Generated("org.realityforge.webtack")
  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "EventInit"
  )
  interface Builder extends EventInit {
    @JsOverlay
    @Nonnull
    default Builder elapsedTime(final double elapsedTime) {
      setElapsedTime( elapsedTime );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder propertyName(@Nonnull final String propertyName) {
      setPropertyName( propertyName );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder propertyName2(@Nonnull final String propertyName2) {
      setPropertyName2( propertyName2 );
      return this;
    }
  }
}
