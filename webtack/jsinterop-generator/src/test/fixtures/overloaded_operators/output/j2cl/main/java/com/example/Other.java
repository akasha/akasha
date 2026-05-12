package com.example;

import javax.annotation.Nonnull;
import javax.annotation.processing.Generated;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Move overloaded operator arguments with a minimum arg count higher than 0.
 */
@Generated("org.realityforge.webtack")
@JsType(
    isNative = true,
    namespace = JsPackage.GLOBAL,
    name = "Other"
)
public class Other {
  protected Other() {
  }

  public native void castSpell(double x, double y);

  public native void castSpell(@Nonnull Point location);
}
