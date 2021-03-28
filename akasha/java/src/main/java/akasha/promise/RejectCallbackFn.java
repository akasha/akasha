package akasha.promise;

import javax.annotation.Nullable;
import jsinterop.annotations.JsFunction;

@JsFunction
public interface RejectCallbackFn
{
  void reject( @Nullable Object reason );
}
