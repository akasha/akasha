package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class ReadableStreamBYOBReadResultTestCompile {
  static ReadableStreamBYOBReadResult $typeReference$;

  public static ReadableStreamBYOBReadResult.Builder of() {
    return ReadableStreamBYOBReadResult.of();
  }

  public static boolean done(final ReadableStreamBYOBReadResult $instance) {
    return $instance.done();
  }

  public static void setDone(final ReadableStreamBYOBReadResult $instance, boolean done) {
    $instance.setDone( done );
  }

  public static ArrayBufferViewOrUndefinedUnion value(
      final ReadableStreamBYOBReadResult $instance) {
    return $instance.value();
  }

  public static void setValue(final ReadableStreamBYOBReadResult $instance,
      ArrayBufferViewOrUndefinedUnion value) {
    $instance.setValue( value );
  }

  public static void setValue(final ReadableStreamBYOBReadResult $instance,
      final ArrayBufferView value) {
    $instance.setValue( value );
  }

  public static ReadableStreamBYOBReadResult.Builder done(
      final ReadableStreamBYOBReadResult.Builder $instance, final boolean done) {
    return $instance.done( done );
  }

  public static ReadableStreamBYOBReadResult.Builder value(
      final ReadableStreamBYOBReadResult.Builder $instance, final ArrayBufferView value) {
    return $instance.value( value );
  }
}
