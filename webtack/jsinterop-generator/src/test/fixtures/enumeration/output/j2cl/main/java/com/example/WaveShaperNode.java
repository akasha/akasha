package com.example;

import javax.annotation.processing.Generated;
import jsinterop.annotations.JsNonNull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "WaveShaperNode"
)
public class WaveShaperNode {
  /**
   * regular attribute is an enum.
   */
  @JsNonNull
  @OverSampleType
  public String oversample;

  /**
   * static attribute is an enum.
   */
  @JsNonNull
  @OverSampleType
  public String static_oversample;

  public WaveShaperNode(@OverSampleType final @JsNonNull String sample) {
  }

  /**
   * attribute return value is an enum.
   */
  @OverSampleType
  @JsNonNull
  public native String getSample();

  /**
   * attribute argument is an enum.
   */
  public native void setSample(@OverSampleType @JsNonNull String sample);
}
