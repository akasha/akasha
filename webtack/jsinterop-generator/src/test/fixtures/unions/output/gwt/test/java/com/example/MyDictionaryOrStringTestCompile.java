package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class MyDictionaryOrStringTestCompile {
  public static MyDictionaryOrString of(final MyDictionary value) {
    return MyDictionaryOrString.of( value );
  }

  public static MyDictionaryOrString of(final String value) {
    return MyDictionaryOrString.of( value );
  }

  public static boolean isMyDictionary(final MyDictionaryOrString $instance) {
    return $instance.isMyDictionary();
  }

  public static MyDictionary asMyDictionary(final MyDictionaryOrString $instance) {
    return $instance.asMyDictionary();
  }

  public static boolean isString(final MyDictionaryOrString $instance) {
    return $instance.isString();
  }

  public static String asString(final MyDictionaryOrString $instance) {
    return $instance.asString();
  }
}
