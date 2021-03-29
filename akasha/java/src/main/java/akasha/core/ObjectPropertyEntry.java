package akasha.core;

import akasha.lang.JsArray;
import javax.annotation.Nonnull;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Array" )
public final class ObjectPropertyEntry
  extends JsArray<Object>
{
  @JsOverlay
  @Nonnull
  public String key()
  {
    return getAtAsAny( 0 ).asString();
  }

  @JsOverlay
  @Nonnull
  public Any value()
  {
    return getAtAsAny( 1 );
  }
}