package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class DocumentOrWindowProxyUnionTestCompile {
  public static DocumentOrWindowProxyUnion of(final DocumentOrWindowProxyUnion $instance,
      final Document value) {
    return DocumentOrWindowProxyUnion.of( value );
  }

  public static DocumentOrWindowProxyUnion of(final DocumentOrWindowProxyUnion $instance,
      final WindowProxy value) {
    return DocumentOrWindowProxyUnion.of( value );
  }

  public static boolean isDocument(final DocumentOrWindowProxyUnion $instance) {
    return $instance.isDocument();
  }

  public static Document asDocument(final DocumentOrWindowProxyUnion $instance) {
    return $instance.asDocument();
  }

  public static boolean isWindowProxy(final DocumentOrWindowProxyUnion $instance) {
    return $instance.isWindowProxy();
  }

  public static WindowProxy asWindowProxy(final DocumentOrWindowProxyUnion $instance) {
    return $instance.asWindowProxy();
  }
}
