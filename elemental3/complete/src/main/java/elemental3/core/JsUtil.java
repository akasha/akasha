package elemental3.core;

import javax.annotation.Nonnull;

public final class JsUtil
{
  private JsUtil()
  {
  }

  /**
   * Return the property on the object indexed by the specified symbol.
   *
   * @param obj the object.
   * @param key the symbol to use to access the property.
   * @param <T> the type of the property.
   * @return the property value.
   */
  public static native <T> T get( @Nonnull Object obj, @Nonnull Symbol key ) /*-{
    return obj[key];
  }-*/;
}
