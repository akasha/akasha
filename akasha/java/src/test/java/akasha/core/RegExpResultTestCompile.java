package akasha.core;

import akasha.lang.JsArray;
import akasha.lang.JsIterator;
import jsinterop.base.JsPropertyMap;

public final class RegExpResultTestCompile
{
  static RegExpResult $typeReference$;

  public static JsPropertyMap<String> groups( final RegExpResult type )
  {
    return type.groups();
  }

  public static int index( final RegExpResult type )
  {
    return type.index();
  }

  public static String input( final RegExpResult type )
  {
    return type.input();
  }

  public static int length( final RegExpResult type )
  {
    return type.length();
  }

  public static JsIterator<Double> keys( RegExpResult $instance )
  {
    return $instance.keys();
  }

  public static JsIterator<String> values( RegExpResult $instance )
  {
    return $instance.values();
  }

  public static JsIterator<JsArray<JsArray.Entry<String>>> entries( RegExpResult $instance )
  {
    return $instance.entries();
  }

  public static void forEach( RegExpResult $instance, RegExpResult.ForEachCallback<String> callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( RegExpResult $instance, RegExpResult.ForEachCallback2<String> callback )
  {
    $instance.forEach( callback );
  }

  public static void forEach( RegExpResult $instance, RegExpResult.ForEachCallback3<String> callback )
  {
    $instance.forEach( callback );
  }
}
