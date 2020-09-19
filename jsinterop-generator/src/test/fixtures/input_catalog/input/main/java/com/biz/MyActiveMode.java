package com.biz;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import org.intellij.lang.annotations.MagicConstant;

/**
 * This is a predefined type.
 */
@MagicConstant( valuesFromClass = MyActiveMode.class )
public @interface MyActiveMode {
  @Nonnull
  String active = "active";

  @Nonnull
  String passive = "passive";
}
