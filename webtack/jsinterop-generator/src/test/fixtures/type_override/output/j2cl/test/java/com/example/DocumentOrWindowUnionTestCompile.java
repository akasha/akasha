package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class DocumentOrWindowUnionTestCompile {
  static DocumentOrWindowUnion $typeReference$;

  public static DocumentOrWindowUnion of(final Document value) {
    return DocumentOrWindowUnion.of( value );
  }

  public static DocumentOrWindowUnion of(final Window value) {
    return DocumentOrWindowUnion.of( value );
  }

  public static boolean isDocument(final DocumentOrWindowUnion $instance) {
    return $instance.isDocument();
  }

  public static Document asDocument(final DocumentOrWindowUnion $instance) {
    return $instance.asDocument();
  }

  public static boolean isWindow(final DocumentOrWindowUnion $instance) {
    return $instance.isWindow();
  }

  public static Window asWindow(final DocumentOrWindowUnion $instance) {
    return $instance.asWindow();
  }
}
