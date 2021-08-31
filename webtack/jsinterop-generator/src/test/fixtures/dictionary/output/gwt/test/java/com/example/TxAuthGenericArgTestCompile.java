package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class TxAuthGenericArgTestCompile {
  static TxAuthGenericArg $typeReference$;

  public static TxAuthGenericArg.Builder create(final String contentType) {
    return TxAuthGenericArg.create( contentType );
  }

  public static String contentType(final TxAuthGenericArg $instance) {
    return $instance.contentType();
  }

  public static void setContentType(final TxAuthGenericArg $instance, String contentType) {
    $instance.setContentType( contentType );
  }

  public static TxAuthGenericArg.Builder contentType(final TxAuthGenericArg.Builder $instance,
      final String contentType) {
    return $instance.contentType( contentType );
  }
}
