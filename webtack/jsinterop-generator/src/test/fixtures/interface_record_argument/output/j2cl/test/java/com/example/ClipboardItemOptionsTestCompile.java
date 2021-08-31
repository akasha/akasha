package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class ClipboardItemOptionsTestCompile {
  static ClipboardItemOptions $typeReference$;

  public static ClipboardItemOptions.Builder create() {
    return ClipboardItemOptions.create();
  }

  public static String presentationStyle(final ClipboardItemOptions $instance) {
    return $instance.presentationStyle();
  }

  public static void setPresentationStyle(final ClipboardItemOptions $instance,
      String presentationStyle) {
    $instance.setPresentationStyle( presentationStyle );
  }

  public static ClipboardItemOptions.Builder presentationStyle(
      final ClipboardItemOptions.Builder $instance, final String presentationStyle) {
    return $instance.presentationStyle( presentationStyle );
  }
}
