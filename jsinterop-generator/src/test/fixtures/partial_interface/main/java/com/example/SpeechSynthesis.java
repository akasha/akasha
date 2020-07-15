package com.example;

import javax.annotation.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Object"
)
public class SpeechSynthesis {
  /**
   * Type is instantiated by the runtime no attempt should be made to instantiate type by application code.
   */
  @Deprecated
  SpeechSynthesis() {
  }

  @JsProperty(
      name = "paused"
  )
  public native boolean paused();

  @JsProperty(
      name = "pending"
  )
  public native boolean pending();

  @JsProperty(
      name = "speaking"
  )
  public native boolean speaking();
}
