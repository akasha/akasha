package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

/**
 * This tests that lowercase name converted to uppercase when converted into java.
 */
@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = TxMode.class
)
public @interface TxMode {
  @Nonnull
  String not_allowed = "not-allowed";

  @Nonnull
  String requires = "requires";

  @Nonnull
  String requires_new = "requires_new";
}
