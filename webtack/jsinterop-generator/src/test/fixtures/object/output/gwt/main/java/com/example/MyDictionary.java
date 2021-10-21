package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsNullable;
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
  static Builder requiredObjectValue(@Nonnull final JsObject requiredObjectValue) {
    final Builder $myDictionary = Js.<Builder>uncheckedCast( JsPropertyMap.of() );
    $myDictionary.setRequiredObjectValue( requiredObjectValue );
    return Js.uncheckedCast( $myDictionary );
  }

  @JsProperty(
      name = "requiredObjectValue"
  )
  @JsNonNull
  JsObject requiredObjectValue();

  @JsProperty
  void setRequiredObjectValue(@JsNonNull JsObject requiredObjectValue);

  @JsProperty(
      name = "nullableObjectValue"
  )
  @JsNullable
  JsObject nullableObjectValue();

  @JsProperty
  void setNullableObjectValue(@JsNullable JsObject nullableObjectValue);

  @JsProperty(
      name = "objectValue"
  )
  JsObject objectValue();

  @JsProperty
  void setObjectValue(@JsNonNull JsObject objectValue);

  @JsType(
      isNative = true,
      namespace = JsPackage.GLOBAL,
      name = "Object"
  )
  interface Builder extends MyDictionary {
    @JsOverlay
    @Nonnull
    default Builder nullableObjectValue(@Nullable final JsObject nullableObjectValue) {
      setNullableObjectValue( nullableObjectValue );
      return this;
    }

    @JsOverlay
    @Nonnull
    default Builder objectValue(@Nonnull final JsObject objectValue) {
      setObjectValue( objectValue );
      return this;
    }
  }
}
