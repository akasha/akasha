package elemental3.gl;

import java.lang.annotation.Documented;

/**
 * Marks an integer as an index of an attribute within a program.
 */
@Documented
public @interface AttributeIndex
{
  final class Validator
  {
    private Validator()
    {
    }

    @AttributeIndex
    public static int cast( final int value )
    {
      return value;
    }
  }
}
