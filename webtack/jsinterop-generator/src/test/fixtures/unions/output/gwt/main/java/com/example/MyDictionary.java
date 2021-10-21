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
    name = "Object"
)
public interface MyDictionary {
  @JsOverlay
  @Nonnull
  static Builder name(@Nonnull final String name) {
    final Builder $myDictionary = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $myDictionary.setName( name );
    return Js.uncheckedCast( $myDictionary );
  }

  @JsProperty(
      name = "name"
  )
  @JsNonNull
  String name();

  @JsProperty
  void setName(@JsNonNull String name);

  @JsProperty(
      name = "description"
  )
  String description();

  @JsProperty
  void setDescription(@JsNonNull String description);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends MyDictionary {
    @JsOverlay
    @Nonnull
    default Builder description(@Nonnull final String description) {
      setDescription( description );
      return this;
    }
  }
}
