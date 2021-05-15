package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
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
  @Nonnull
  @OverSampleType
  public String oversample;

  /**
   * static attribute is an enum.
   */
  @Nonnull
  @OverSampleType
  public String static_oversample;

  public WaveShaperNode(@OverSampleType @Nonnull final String sample) {
  }

  /**
   * attribute return value is an enum.
   */
  @OverSampleType
  @Nonnull
  public native String getSample();

  /**
   * attribute argument is an enum.
   */
  public native void setSample(@OverSampleType @Nonnull String sample);
}
