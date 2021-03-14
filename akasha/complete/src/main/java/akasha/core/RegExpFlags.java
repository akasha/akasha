package akasha.core;

import java.lang.annotation.Documented;
import org.intellij.lang.annotations.Pattern;

/**
 * Specifies the valid flag string for regexps.
 */
@Documented
@Pattern( "[gimsuy]*" )
public @interface RegExpFlags
{
}
