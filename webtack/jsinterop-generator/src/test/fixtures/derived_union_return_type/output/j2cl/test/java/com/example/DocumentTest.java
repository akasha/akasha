package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class DocumentTest {
  static Document $typeReference$;

  public static DocumentOrWindowProxyUnion open(final Document $instance, final String unused1,
      final String unused2) {
    return $instance.open( unused1, unused2 );
  }

  public static DocumentOrWindowProxyUnion open(final Document $instance, final String unused1) {
    return $instance.open( unused1 );
  }

  public static DocumentOrWindowProxyUnion open(final Document $instance) {
    return $instance.open();
  }

  public static DocumentOrWindowProxyUnion open(final Document $instance, final String url,
      final String name, final String features) {
    return $instance.open( url, name, features );
  }
}
