package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

/**
 * This tests scenario where there is an empty enum value.
 */
@Generated("org.realityforge.webtack")
@MagicConstant(
    valuesFromClass = XMLHttpRequestResponseType.class
)
public @interface XMLHttpRequestResponseType {
  @Nonnull
  String arraybuffer = "arraybuffer";

  @Nonnull
  String blob = "blob";

  @Nonnull
  String document = "document";

  @Nonnull
  String json = "json";

  @Nonnull
  String text = "text";
}
