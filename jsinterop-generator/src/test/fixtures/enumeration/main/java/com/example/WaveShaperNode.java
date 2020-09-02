package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.intellij.lang.annotations.MagicConstant;

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
  public String oversample;

  /**
   * static attribute is an enum.
   */
  @Nonnull
  public String static_oversample;

  public WaveShaperNode(
      @MagicConstant(valuesFromClass = OverSampleType.class) @Nonnull final String sample) {
  }

  /**
   * attribute return value is an enum.
   */
  @MagicConstant(
      valuesFromClass = OverSampleType.class
  )
  @Nonnull
  public native String getSample();

  /**
   * attribute argument is an enum.
   */
  public native void setSample(
      @MagicConstant(valuesFromClass = OverSampleType.class) @Nonnull String sample);
}
