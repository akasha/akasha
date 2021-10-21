package com.example;

import javax.annotation.Generated;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
public final class XRSessionInitTestCompile {
  static XRSessionInit $typeReference$;

  public static XRSessionInit.Builder of() {
    return XRSessionInit.of();
  }

  public static JsArray<Any> optionalFeatures(final XRSessionInit $instance) {
    return $instance.optionalFeatures();
  }

  public static void setOptionalFeatures(final XRSessionInit $instance,
      JsArray<Any> optionalFeatures) {
    $instance.setOptionalFeatures( optionalFeatures );
  }

  public static void setOptionalFeatures(final XRSessionInit $instance,
      final Any[] optionalFeatures) {
    $instance.setOptionalFeatures( optionalFeatures );
  }

  public static JsArray<Any> requiredFeatures(final XRSessionInit $instance) {
    return $instance.requiredFeatures();
  }

  public static void setRequiredFeatures(final XRSessionInit $instance,
      JsArray<Any> requiredFeatures) {
    $instance.setRequiredFeatures( requiredFeatures );
  }

  public static void setRequiredFeatures(final XRSessionInit $instance,
      final Any[] requiredFeatures) {
    $instance.setRequiredFeatures( requiredFeatures );
  }

  public static XRSessionInit.Builder optionalFeatures(final XRSessionInit.Builder $instance,
      final JsArray<Any> optionalFeatures) {
    return $instance.optionalFeatures( optionalFeatures );
  }

  public static XRSessionInit.Builder optionalFeatures(final XRSessionInit.Builder $instance,
      final Any[] optionalFeatures) {
    return $instance.optionalFeatures( optionalFeatures );
  }

  public static XRSessionInit.Builder requiredFeatures(final XRSessionInit.Builder $instance,
      final JsArray<Any> requiredFeatures) {
    return $instance.requiredFeatures( requiredFeatures );
  }

  public static XRSessionInit.Builder requiredFeatures(final XRSessionInit.Builder $instance,
      final Any[] requiredFeatures) {
    return $instance.requiredFeatures( requiredFeatures );
  }
}
