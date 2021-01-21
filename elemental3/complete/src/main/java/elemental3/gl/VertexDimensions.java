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
}
