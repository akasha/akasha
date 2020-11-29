package elemental3.core;

import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@JsType( isNative = true, namespace = JsPackage.GLOBAL )
public interface ObjectPropertyDescriptor
{
  @JsFunction
  interface GetFn
  {
    Object onInvoke();
  }

  @JsFunction
  interface SetFn
  {
    void onInvoke( Object p0 );
  }

  @JsOverlay
  static ObjectPropertyDescriptor create()
  {
    return Js.uncheckedCast( JsPropertyMap.of() );
  }

  @JsProperty
  GetFn getGet();

  @JsProperty
  SetFn getSet();

  @JsProperty
  Object getValue();

  @JsProperty
  boolean isConfigurable();

  @JsProperty
  boolean isEnumerable();

  @JsProperty
  boolean isWritable();

  @JsProperty
  void setConfigurable( boolean configurable );

  @JsProperty
  void setEnumerable( boolean enumerable );

  @JsProperty
  void setGet( GetFn get );

  @JsProperty
  void setSet( SetFn set );

  @JsProperty
  void setValue( Object value );

  @JsProperty
  void setWritable( boolean writable );
}
