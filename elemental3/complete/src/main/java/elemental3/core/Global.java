package elemental3.core;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType( isNative = true, name = "goog.global", namespace = JsPackage.GLOBAL )
public class Global
{
  @JsOverlay
  public static final double Infinity = Global__Constants.Infinity;
  @JsOverlay
  public static final double NaN = Global__Constants.NaN;
  public static Arguments arguments;
}
