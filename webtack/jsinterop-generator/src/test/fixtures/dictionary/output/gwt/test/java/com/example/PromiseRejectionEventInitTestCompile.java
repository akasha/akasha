package com.example;

import javax.annotation.Generated;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
public final class PromiseRejectionEventInitTestCompile {
  static PromiseRejectionEventInit $typeReference$;

  public static PromiseRejectionEventInit.Builder promise(final JsPromise<Any> promise) {
    return PromiseRejectionEventInit.promise( promise );
  }

  public static JsPromise<Any> promise(final PromiseRejectionEventInit $instance) {
    return $instance.promise();
  }

  public static void setPromise(final PromiseRejectionEventInit $instance, JsPromise<Any> promise) {
    $instance.setPromise( promise );
  }

  public static Any reason(final PromiseRejectionEventInit $instance) {
    return $instance.reason();
  }

  public static void setReason(final PromiseRejectionEventInit $instance, Object reason) {
    $instance.setReason( reason );
  }

  public static PromiseRejectionEventInit.Builder reason(
      final PromiseRejectionEventInit.Builder $instance, final Object reason) {
    return $instance.reason( reason );
  }

  public static PromiseRejectionEventInit.Builder bubbles(
      final PromiseRejectionEventInit.Builder $instance, final boolean bubbles) {
    return $instance.bubbles( bubbles );
  }

  public static PromiseRejectionEventInit.Builder cancelable(
      final PromiseRejectionEventInit.Builder $instance, final boolean cancelable) {
    return $instance.cancelable( cancelable );
  }

  public static PromiseRejectionEventInit.Builder composed(
      final PromiseRejectionEventInit.Builder $instance, final boolean composed) {
    return $instance.composed( composed );
  }
}
