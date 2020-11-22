package elemental3.core;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType( isNative = true, namespace = JsPackage.GLOBAL )
public class Function
{
  public Object arguments;
  @Deprecated
  public double arity;
  public Function caller;
  public Object displayName;
  public int length;
  public String name;

  public Function( Object... var_args )
  {
  }

  public native Object apply( Object... var_args );

  public native Function bind( JsObject selfObj, Object... var_args );

  @JsOverlay
  public final Function bind( Object selfObj, Object... var_args )
  {
    return bind( Js.uncheckedCast( selfObj ), var_args );
  }

  public native Object call( Object... var_args );

  @JsMethod( name = "toString" )
  public native String toString_();
}
