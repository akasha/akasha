package org.realityforge.webtack.model.tools.transform;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
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
  @Nullable
  WebIDLSchema transform( @Nonnull WebIDLSchema schema )
    throws Exception;
}
