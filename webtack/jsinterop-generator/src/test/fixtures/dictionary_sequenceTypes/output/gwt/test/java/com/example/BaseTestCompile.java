package com.example;

import javax.annotation.Generated;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
public final class BaseTestCompile {
  static Base $typeReference$;

  public static Base.Builder create() {
    return Base.create();
  }

  public static JsArray<Any> optionalFeatures(final Base $instance) {
    return $instance.optionalFeatures();
  }

  public static void setOptionalFeatures(final Base $instance, JsArray<Any> optionalFeatures) {
    $instance.setOptionalFeatures( optionalFeatures );
  }

  public static void setOptionalFeatures(final Base $instance, final Any[] optionalFeatures) {
    $instance.setOptionalFeatures( optionalFeatures );
  }

  public static Base.Builder optionalFeatures(final Base.Builder $instance,
      final JsArray<Any> optionalFeatures) {
    return $instance.optionalFeatures( optionalFeatures );
  }

  public static Base.Builder optionalFeatures(final Base.Builder $instance,
      final Any[] optionalFeatures) {
    return $instance.optionalFeatures( optionalFeatures );
  }
}
