package akasha.promise;

import javax.annotation.Nullable;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@SuppressWarnings( "unused" )
@JsType( isNative = true, name = "?", namespace = JsPackage.GLOBAL )
public interface ResolveValue<T>
{
  @JsOverlay
  @Nullable
  static <T> ResolveValue<T> of( @Nullable final T value )
  {
    return Js.cast( value );
  }

  @JsOverlay
  @Nullable
  static <T> ResolveValue<T> of( @Nullable final Promise<T> value )
  {
    return Js.cast( value );
  }
}
