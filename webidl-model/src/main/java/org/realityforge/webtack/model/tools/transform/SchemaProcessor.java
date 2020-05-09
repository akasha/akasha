package org.realityforge.webtack.model.tools.transform;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;

/**
 * Apply a transformation to a schema.
 */
public interface SchemaProcessor
{
  /**
   * Transform one schema into another schema.
   *
   * @param schema the input schema.
   * @return the output schema.
   */
  WebIDLSchema transform( @Nonnull WebIDLSchema schema );
}
