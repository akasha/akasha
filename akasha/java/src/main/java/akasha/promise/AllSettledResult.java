package akasha.promise;

import java.lang.annotation.Documented;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.intellij.lang.annotations.MagicConstant;

// GWT_ONLY /*
@JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Promise.AllSettledResultElement" )
// GWT_ONLY */
// GWT_ONLY @JsType( isNative = true, namespace = JsPackage.GLOBAL, name = "Object" )
public class AllSettledResult<T>
{
  // This file has been hand-written to align with the closure externs which vary slightly
  // from the WebIDL definition

  protected AllSettledResult()
  {
  }

  @Status
  @JsProperty( name = "status" )
  @Nonnull
  public native String status();

  /**
   * Exists only if the status field is 'fulfilled'
   */
  @JsProperty( name = "value" )
  @Nullable
  public native T value();

  /**
   * Exists only if the status field is 'rejected'
   */
  @JsProperty( name = "reason" )
  @Nullable
  public native Object reason();

  @Documented
  @MagicConstant( valuesFromClass = Status.class )
  public @interface Status
  {
    @Nonnull
    String fulfilled = "fulfilled";
    @Nonnull
    String rejected = "rejected";

    final class Util
    {
      private Util()
      {
      }

      @Status
      public static String requireValid( final String value )
      {
        assertValid( value );
        return value;
      }

      public static void assertValid( @Nonnull final String value )
      {
        assert isValid( value );
      }

      public static boolean isValid( @Nonnull final String value )
      {
        return Status.fulfilled.equals( value ) || Status.rejected.equals( value );
      }
    }
  }
}
