package com.example;

import java.lang.annotation.Documented;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

@Generated("org.realityforge.webtack")
@Documented
@MagicConstant(
    valuesFromClass = KeyType.class
)
public @interface KeyType {
  @Nonnull
  String private_ = "private";

  @Nonnull
  String public_ = "public";

  @Nonnull
  String secret = "secret";
}
