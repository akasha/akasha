package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class AudioScheduledSourceNodeTestCompile {
  static AudioScheduledSourceNode $typeReference$;

  public static void start(final AudioScheduledSourceNode $instance, final double when) {
    $instance.start( when );
  }

  public static void start(final AudioScheduledSourceNode $instance) {
    $instance.start();
  }

  public static void stop(final AudioScheduledSourceNode $instance, final double when) {
    $instance.stop( when );
  }

  public static void stop(final AudioScheduledSourceNode $instance) {
    $instance.stop();
  }
}
