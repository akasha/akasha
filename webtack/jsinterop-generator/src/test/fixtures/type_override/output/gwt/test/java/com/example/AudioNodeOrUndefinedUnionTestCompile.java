package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class AudioNodeOrUndefinedUnionTestCompile {
  static AudioNodeOrUndefinedUnion $typeReference$;

  public static AudioNodeOrUndefinedUnion of(final AudioNode value) {
    return AudioNodeOrUndefinedUnion.of( value );
  }

  public static AudioNodeOrUndefinedUnion of() {
    return AudioNodeOrUndefinedUnion.of();
  }

  public static boolean isAudioNode(final AudioNodeOrUndefinedUnion $instance) {
    return $instance.isAudioNode();
  }

  public static AudioNode asAudioNode(final AudioNodeOrUndefinedUnion $instance) {
    return $instance.asAudioNode();
  }

  public static boolean isVoid(final AudioNodeOrUndefinedUnion $instance) {
    return $instance.isVoid();
  }
}
