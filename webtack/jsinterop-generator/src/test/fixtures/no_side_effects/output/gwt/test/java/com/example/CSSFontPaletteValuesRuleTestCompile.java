package com.example;

import javax.annotation.Generated;

@Generated("org.realityforge.webtack")
public final class CSSFontPaletteValuesRuleTestCompile {
  static CSSFontPaletteValuesRule $typeReference$;

  public static String basePalette(final CSSFontPaletteValuesRule type) {
    return type.basePalette;
  }

  public static void basePalette(final CSSFontPaletteValuesRule type, final String value) {
    type.basePalette = value;
  }

  public static String fontFamily(final CSSFontPaletteValuesRule type) {
    return type.fontFamily;
  }

  public static void fontFamily(final CSSFontPaletteValuesRule type, final String value) {
    type.fontFamily = value;
  }

  public static int size(CSSFontPaletteValuesRule $instance) {
    return $instance.size();
  }

  public static boolean has(int key, CSSFontPaletteValuesRule $instance) {
    return $instance.has( key );
  }

  public static String get(CSSFontPaletteValuesRule $instance, int key) {
    return $instance.get( key );
  }

  public static JsIterator<Double> keys(CSSFontPaletteValuesRule $instance) {
    return $instance.keys();
  }

  public static JsIterator<String> values(CSSFontPaletteValuesRule $instance) {
    return $instance.values();
  }

  public static JsIterator<CSSFontPaletteValuesRule.Entry> entries(
      CSSFontPaletteValuesRule $instance) {
    return $instance.entries();
  }

  public static void forEach(CSSFontPaletteValuesRule $instance,
      CSSFontPaletteValuesRule.ForEachCallback callback) {
    $instance.forEach( callback );
  }

  public static void forEach(CSSFontPaletteValuesRule $instance,
      CSSFontPaletteValuesRule.ForEachCallback2 callback) {
    $instance.forEach( callback );
  }

  public static void forEach(CSSFontPaletteValuesRule $instance,
      CSSFontPaletteValuesRule.ForEachCallback3 callback) {
    $instance.forEach( callback );
  }

  public static void set(CSSFontPaletteValuesRule $instance, int key, String value) {
    $instance.set( key, value );
  }

  public static boolean delete(CSSFontPaletteValuesRule $instance, int key) {
    return $instance.delete( key );
  }

  public static void clear(CSSFontPaletteValuesRule $instance) {
    $instance.clear();
  }
}
