package org.realityforge.webtack.model.tools.spi;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;

/**
 * Combine two or more schemas into a single schema.
 */
public interface Combiner
{
  /**
   * Combine two or more schemas into a single schema.
   *
   * @param schemas the schemas to combine.
   * @return the merged schema.
   */
  WebIDLSchema combine( @Nonnull final WebIDLSchema... schemas );
}
