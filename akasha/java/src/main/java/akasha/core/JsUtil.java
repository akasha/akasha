package akasha.core;

import javax.annotation.Nonnull;
import jsinterop.base.Js;

public final class JsUtil
{
  private JsUtil()
  {
  }

  /**
   * Return the property on the object indexed by the specified symbol.
   *
   * @param object the object.
   * @param key    the symbol to use to access the property.
   * @param <T>    the type of the property.
   * @return the property value.
   */
  public static <T> T get( @Nonnull final Object object, @Nonnull final Symbol key )
  {
    // Totally lie to the type system which should produce no problem and does not
    // introduce complex native binding that is difficult to bridge between J2CL and GWT
    return Js.uncheckedCast( Js.asPropertyMap( object ).get( Js.uncheckedCast( key ) ) );
  }
}
