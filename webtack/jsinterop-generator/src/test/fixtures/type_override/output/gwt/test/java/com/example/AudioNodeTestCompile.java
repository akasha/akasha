package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class AudioNodeTestCompile {
  static AudioNode $typeReference$;

  public static AudioNode connect(final AudioNode $instance, final AudioNode destinationNode,
      final int output, final int input) {
    return $instance.connect( destinationNode, output, input );
  }

  public static AudioNode connect(final AudioNode $instance, final AudioNode destinationNode,
      final int output) {
    return $instance.connect( destinationNode, output );
  }

  public static AudioNode connect(final AudioNode $instance, final AudioNode destinationNode) {
    return $instance.connect( destinationNode );
  }

  public static void connect(final AudioNode $instance, final AudioParam destinationParam,
      final int output) {
    $instance.connect( destinationParam, output );
  }

  public static void connect(final AudioNode $instance, final AudioParam destinationParam) {
    $instance.connect( destinationParam );
  }
}
