package com.example;

import javax.annotation.Generated;
import jsinterop.base.Any;

@Generated("org.realityforge.webtack")
public final class RequiredAnyDictTestCompile {
  static RequiredAnyDict $typeReference$;

  public static RequiredAnyDict.Builder create(final Object someValue) {
    return RequiredAnyDict.create( someValue );
  }

  public static Any someValue(final RequiredAnyDict $instance) {
    return $instance.someValue();
  }

  public static void setSomeValue(final RequiredAnyDict $instance, Object someValue) {
    $instance.setSomeValue( someValue );
  }

  public static RequiredAnyDict.Builder someValue(final RequiredAnyDict.Builder $instance,
      final Object someValue) {
    return $instance.someValue( someValue );
  }
}
