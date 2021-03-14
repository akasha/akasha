package akasha.promise;

import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsOverlay;

@JsFunction
public interface ResolveCallbackFn<T>
{
  @JsOverlay
  default void resolve( @Nullable final Promise<T> value )
  {
    resolve( ResolveValue.of( value ) );
  }

  @JsOverlay
  default void resolve( @Nullable final T value )
  {
    resolve( ResolveValue.of( value ) );
  }

  void resolve( @Nullable ResolveValue<T> value );
}
