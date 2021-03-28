package akasha.promise;

import javax.annotation.Nonnull;
import jsinterop.annotations.JsFunction;

@JsFunction
public interface PromiseExecutor<T>
{
  void onInvoke( @Nonnull ResolveCallbackFn<T> resolveFn, @Nonnull RejectCallbackFn rejectFn );
}
