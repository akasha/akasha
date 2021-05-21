package akasha.core;

import akasha.lang.JsArray;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "RegExpResult" )
public class RegExpResult
  extends JsArray<String>
{
  // This file has been hand-written to align with the closure externs which vary slightly
  // from the WebIDL definition

  protected RegExpResult()
  {
  }

  @JsProperty( name = "groups" )
  @Nullable
  public native JsPropertyMap<String> groups();

  @JsProperty( name = "index" )
  public native int index();

  @JsProperty( name = "input" )
  @Nonnull
  public native String input();

  @JsProperty( name = "length" )
  public native int length();
}
