package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class AudioNodeTest {
  static AudioNode $typeReference$;

  public static AudioNodeOrUndefinedUnion connect(final AudioNode $instance,
      final AudioNode destinationNode, final int output, final int input) {
    return $instance.connect( destinationNode, output, input );
  }

  public static AudioNodeOrUndefinedUnion connect(final AudioNode $instance,
      final AudioNode destinationNode, final int output) {
    return $instance.connect( destinationNode, output );
  }

  public static AudioNodeOrUndefinedUnion connect(final AudioNode $instance,
      final AudioNode destinationNode) {
    return $instance.connect( destinationNode );
  }

  public static AudioNodeOrUndefinedUnion connect(final AudioNode $instance,
      final AudioParam destinationParam, final int output) {
    return $instance.connect( destinationParam, output );
  }

  public static AudioNodeOrUndefinedUnion connect(final AudioNode $instance,
      final AudioParam destinationParam) {
    return $instance.connect( destinationParam );
  }
}
