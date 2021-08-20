package com.example;

import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("org.realityforge.webtack")
public final class DocumentOrWindowProxyUnionTestCompile {
  @Nonnull
  public static DocumentOrWindowProxyUnion of(final DocumentOrWindowProxyUnion $instance,
      @Nonnull final Document value) {
    return DocumentOrWindowProxyUnion.of( value );
  }

  @Nullable
  public static DocumentOrWindowProxyUnion of(final DocumentOrWindowProxyUnion $instance,
      @Nullable final WindowProxy value) {
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
