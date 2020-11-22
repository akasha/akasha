package elemental3.promise;

import elemental3.core.JsError;
import elemental3.core.JsIterable;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Any;
import jsinterop.base.Js;

@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "AggregateError" )
public class AggregateError
  extends JsError
{
  /**
   * An iterable of errors, may not actually be Error instances.
   */
  @Nonnull
  JsIterable<Any> errors;

  /**
   * The AggregateError() constructor creates an error for several errors that need to be wrapped in a single error.
   *
   * @param errors the errors. May not actually be Error instances.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/AggregateError/AggregateError">MDN - AggregateError()</a>
   */
  public AggregateError( @Nonnull final Any... errors )
  {
    this.errors = Js.uncheckedCast( errors );
  }

  /**
   * The AggregateError() constructor creates an error for several errors that need to be wrapped in a single error.
   *
   * @param errors the errors. May not actually be Error instances.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/AggregateError/AggregateError">MDN - AggregateError()</a>
   */
  public AggregateError( @Nonnull final JsIterable<Any> errors )
  {
    this.errors = errors;
  }

  /**
   * The AggregateError() constructor creates an error for several errors that need to be wrapped in a single error.
   *
   * @param errors  the errors. May not actually be Error instances.
   * @param message An optional human-readable description of the aggregate error.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/AggregateError/AggregateError">MDN - AggregateError()</a>
   */
  public AggregateError( @Nonnull final Any[] errors, @Nullable final String message )
  {
    this.errors = Js.uncheckedCast( errors );
    this.message = message;
  }

  /**
   * The AggregateError() constructor creates an error for several errors that need to be wrapped in a single error.
   *
   * @param errors  the errors. May not actually be Error instances.
   * @param message An optional human-readable description of the aggregate error.
   * @see <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/AggregateError/AggregateError">MDN - AggregateError()</a>
   */
  public AggregateError( @Nonnull final JsIterable<Any> errors, @Nullable final String message )
  {
    this.errors = errors;
    this.message = message;
  }
}
