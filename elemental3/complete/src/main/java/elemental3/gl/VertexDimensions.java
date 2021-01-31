package elemental3.gl;

import java.lang.annotation.Documented;
import org.intellij.lang.annotations.MagicConstant;

/**
 * Specifies the number of components per vertex attribute.
 */
@Documented
@MagicConstant( intValues = { 1, 2, 3, 4 } )
public @interface VertexDimensions
{
  final class Validator
  {
    private Validator()
    {
    }

    public static void assertValid( final int value )
    {
      assert isValid( value );
    }

    public static boolean isValid( final int value )
    {
      return 1 == value || 2 == value || 3 == value || 4 == value;
    }
  }
}
