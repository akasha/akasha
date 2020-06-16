package org.realityforge.webtack.model.tools.sink;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.realityforge.webtack.model.WebIDLSchema;

/**
 * Perform an action for a schema.
 */
public interface SchemaAction
{
  /**
   * Perform an action for a schema.
   *
   * @param schema the schema.
   */
  void process( @Nonnull WebIDLSchema schema )
    throws Exception;
}
