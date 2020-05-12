package org.realityforge.webtack.model.tools.merger;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;

/**
 * Combine two or more schemas into a single schema.
 */
public interface SchemaJoiner
{
  /**
   * Combine two or more schemas into a single schema.
   *
   * @param schemas the schemas to combine.
   * @return the merged schema.
   */
  WebIDLSchema merge( @Nonnull final WebIDLSchema... schemas );
}
