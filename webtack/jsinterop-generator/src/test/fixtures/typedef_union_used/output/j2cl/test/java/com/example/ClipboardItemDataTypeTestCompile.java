package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class ClipboardItemDataTypeTestCompile {
  static ClipboardItemDataType $typeReference$;

  public static ClipboardItemDataType of(final String value) {
    return ClipboardItemDataType.of( value );
  }

  public static ClipboardItemDataType of(final Blob value) {
    return ClipboardItemDataType.of( value );
  }

  public static boolean isBlob(final ClipboardItemDataType $instance) {
    return $instance.isBlob();
  }

  public static Blob asBlob(final ClipboardItemDataType $instance) {
    return $instance.asBlob();
  }

  public static boolean isString(final ClipboardItemDataType $instance) {
    return $instance.isString();
  }

  public static String asString(final ClipboardItemDataType $instance) {
    return $instance.asString();
  }
}
