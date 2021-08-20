package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class AudioNodeOrUndefinedUnionTestCompile {
  public static AudioNodeOrUndefinedUnion of(final AudioNodeOrUndefinedUnion $instance,
      final AudioNode value) {
    return AudioNodeOrUndefinedUnion.of( value );
  }

  public static AudioNodeOrUndefinedUnion of() {
    return AudioNodeOrUndefinedUnion.of();
  }

  public static boolean isVoid(final AudioNodeOrUndefinedUnion $instance) {
    return $instance.isVoid();
  }

  public static boolean isAudioNode(final AudioNodeOrUndefinedUnion $instance) {
    return $instance.isAudioNode();
  }

  public static AudioNode asAudioNode(final AudioNodeOrUndefinedUnion $instance) {
    return $instance.asAudioNode();
  }
}
