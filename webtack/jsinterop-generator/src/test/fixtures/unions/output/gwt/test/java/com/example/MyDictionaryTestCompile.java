package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class MyDictionaryTestCompile {
  static MyDictionary $typeReference$;

  public static MyDictionary.Builder name(final String name) {
    return MyDictionary.name( name );
  }

  public static String name(final MyDictionary $instance) {
    return $instance.name();
  }

  public static void setName(final MyDictionary $instance, String name) {
    $instance.setName( name );
  }

  public static String description(final MyDictionary $instance) {
    return $instance.description();
  }

  public static void setDescription(final MyDictionary $instance, String description) {
    $instance.setDescription( description );
  }

  public static MyDictionary.Builder description(final MyDictionary.Builder $instance,
      final String description) {
    return $instance.description( description );
  }
}
