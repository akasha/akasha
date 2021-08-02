package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class HTMLCollectionTestCompile {
  static HTMLCollection $typeReference$;

  public static int length(final HTMLCollection type) {
    return type.length();
  }

  public static Element item(final HTMLCollection $instance, final int index) {
    return $instance.item( index );
  }

  public static Element namedItem(final HTMLCollection $instance, final String name) {
    return $instance.namedItem( name );
  }
}
