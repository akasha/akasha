package elemental3.core;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.JsPropertyMap;

@JsType( isNative = true, namespace = JsPackage.GLOBAL )
public class RegExpResult
  extends JsArray<String>
{
  public JsPropertyMap<String> groups;
  public double index;
  public String input;
  public double length;

  public RegExpResult()
  {
    // This super call is here only for the code to compile; it is never executed.
    super( (String) null );
  }
}
