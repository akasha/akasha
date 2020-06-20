package org.realityforge.webtack.model.tools.spi;

import javax.annotation.Nonnull;
import org.realityforge.webtack.model.WebIDLSchema;

/**
 * Perform an action for a schema.
 */
public interface Action
{
  /**
   * Perform an action for a schema.
   *
   * @param schema the schema.
   * @throws Exception if an error occurs when running action.
   */
  void process( @Nonnull WebIDLSchema schema )
    throws Exception;
}
