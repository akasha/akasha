package com.example;

import javax.annotation.Generated;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
public final class Sub2TestCompile {
  static Sub2 $typeReference$;

  public static Sub2.Builder of() {
    return Sub2.of();
  }

  public static JsArray<XRSessionInit> sessions(final Sub2 $instance) {
    return $instance.sessions();
  }

  public static void setSessions(final Sub2 $instance, JsArray<XRSessionInit> sessions) {
    $instance.setSessions( sessions );
  }

  public static void setSessions(final Sub2 $instance, final XRSessionInit[] sessions) {
    $instance.setSessions( sessions );
  }

  public static Sub2.Builder sessions(final Sub2.Builder $instance,
      final JsArray<XRSessionInit> sessions) {
    return $instance.sessions( sessions );
  }

  public static Sub2.Builder sessions(final Sub2.Builder $instance,
      final XRSessionInit[] sessions) {
    return $instance.sessions( sessions );
  }

  public static Sub2.Builder optionalFeatures(final Sub2.Builder $instance,
      final JsArray<Any> optionalFeatures) {
    return $instance.optionalFeatures( optionalFeatures );
  }

  public static Sub2.Builder optionalFeatures(final Sub2.Builder $instance,
      final Any[] optionalFeatures) {
    return $instance.optionalFeatures( optionalFeatures );
  }
}
