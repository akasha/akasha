package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("org.realityforge.webtack")
public final class ClipboardItemDataTypeTestCompile {
  @Nonnull
  public static ClipboardItemDataType of(final ClipboardItemDataType $instance,
      @Nonnull final String value) {
    return ClipboardItemDataType.of( value );
  }

  @Nonnull
  public static ClipboardItemDataType of(final ClipboardItemDataType $instance,
      @Nonnull final Blob value) {
    return ClipboardItemDataType.of( value );
  }

  public static boolean isBlob(final ClipboardItemDataType $instance) {
    return $instance.isBlob();
  }

  public static Blob asBlob(final ClipboardItemDataType $instance) {
    return $instance.asBlob();
  }
}
